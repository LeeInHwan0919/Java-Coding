-- 20220216
-- PL/SQL 기초
-- Procedure(절차) Language 이란 : SQL문 단일 실행 > 복합 > 조건에 따라서 동작 될 수 있도록 함 > MERGE
-- 문법
-- CREATE OR REPLACE [프로시저이름]
-- IS
-- 	BEGIN
-- 	   SQL문을 작성
-- END;
-- [EXCEPTION]

-- 사용이유 장/단점
-- FOR문 IF문과 같은 조건문을 사용하거나 복잡한 연속된 쿼리를 작업하고 싶을 때
-- CASE문으로 작성 했던 문법 중에서 부서(DEPTNO)가 20이면 보너스(COMM)를 100을 주고 10(DEPTNO)이고 이름(DNAME)이 M으로 시작되는 사원이라면
CREATE OR REPLACE PROCEDURE TEST_PL
(
	IN_YEAR IN VARCHAR2,
	IN_MONTH IN VARCHAR2,
	IN_DATE IN VARCHAR2
) 
IS 
 BEGIN 
	DBMS_OUTPUT.PUT_LINE(IN_YEAR || '/' || IN_MONTH || '/' || IN_DATE);
 END;
 
-- 부서를 등록하는데 부서가 있다면 이미 SELECT '등록된 부서 입니다.'
-- 없는 부서 INSERT하고 '입력 완료'
-- 예외가 발생하면 ROLLBACK 'ERROR'

CREATE OR REPLACE PROCEDURE PL_DEPT_INSERT
(	v_deptno IN NUMBER,
    v_dename IN VARCHAR2 ,
    v_loc IN VARCHAR2 ,
    v_result OUT VARCHAR2 
)
IS 
	cnt number :=0;
BEGIN 
    SELECT COUNT(*) INTO cnt 
        FROM DEPT d 
        WHERE DEPTNO = v_deptno;
IF cnt > 0 THEN
    v_result :='이미등록된부서입니다.';
ELSE
    INSERT INTO DEPT (DEPTNO,DNAME,LOC)
            VALUES(v_deptno, v_dename, v_loc);
    COMMIT;
    v_result :='입력완료.';
END IF;
EXCEPTION 
    WHEN OTHERS THEN 
    ROLLBACK ;
    v_result :='ERROR';
END;
--위 내용
--CREATE OR REPLACE PROCEDURE [명]
--(
--	사용되는 변수들을 선언한다 외부에서 입력(IN) 받거나 출력(OUT)되는
--)
--id(DECLARE)
-- 내부에서 사용되는 변수를 선언한다. 초기값 입력 :=
--BEGIN
--	SQL문장을 입력, 내부변수에 값을 입력한다면 SELECT 절에 INTO 변수명
--				, 외부에서 입력받은 값을 입력 할 때는 선언된 변수명
--	COMMIT;은 반드시 해준다(INSERT UPDATE DELETE인 경우).
--	외부 변수에 값을 담고 싶다면 변수명:='값'
--  IF[조건문] THEN
--    SQL문 작성
--	COMMIT;은 반드시 해준다(INSERT UPDATE DELETE인 경우).
--	외부 변수에 값을 담고 싶다면 변수명:='값'
--	ELSE
--	COMMIT;은 반드시 해준다(INSERT UPDATE DELETE인 경우).
--	외부 변수에 값을 담고 싶다면 변수명:='값'
--	END IF;
--	[EXCEPTION
--		WHEN OTHERS THEN
--		ROLLBACK;
--		외부 변수에 값을 담고 싶다면 변수명:='값'
--		]
--END;
--/
--------------------------------------------------------------------------------------------------------
-- 시험똑같이 낸대요
-- Trigger 자동으로 동작
-- 자동으로 호출되고 수행되도록 만들어 놓은 명령문의 집합
-- PL과의 차이점 -> 테이블이 자신을 대상으로 함
-- Trigger는 조건에 의해서 다른 테이블 값을 입력하거나 수정 하거나 하게 됨.

-- 주문테이블에서 실시간으로 데이터가 입력됨
-- 입력되면 자동으로 Trigger가 작동되어 일자별 판매집계테이블에 일자별, 상품별, 판매수량과 판매금액을 계산해서 업데이트

-- 주문정보 테이블
CREATE TABLE ORDER_LIST(
	ORDER_DATE CHAR(8) NOT NULL,
	PRODUCT VARCHAR2(100) NOT NULL,
	QTY 	NUMBER NOT NULL,
	AMOUNT  NUMBER NOT NULL
);

--일자별 판매 집계 테이블 (통계성 테이블)
CREATE TABLE SALES_PER_DATE(
	SALE_DATE CHAR(8) NOT NULL,
	PRODUCT VARCHAR2(100) NOT NULL,
	QTY 	NUMBER NOT NULL,
	AMOUNT  NUMBER NOT NULL
);

CREATE OR REPLACE TRIGGER SUMMARY_SALES
	AFTER INSERT 
	ON ORDER_LIST 
	FOR EACH ROW
  DECLARE 
    o_date ORDER_LIST.order_date%TYPE;
    o_product ORDER_LIST.product%TYPE;
  BEGIN 
	  o_date := :NEW.order_date;
	  o_product := :NEW.product;
	 UPDATE SALES_PER_DATE 
	 	SET qty = qty + :NEW.qty, amount = amount + :new.amount 
	 	WHERE sale_date = o_date 
	 AND PRODUCT =o_product ;
	IF SQL%NOTFOUND THEN
	 INSERT INTO SALES_PER_DATE 
	       VALUES(o_date, o_product, :NEW.qty, :NEW.amount);
	END IF;
  END;

	
-- ORDER_LIST에 입력이 된다면 추가 Trigger 
CREATE OR REPLACE TRIGGER WELCOME
 AFTER INSERT ON ORDER_LIST
 FOR EACH ROW
 BEGIN 
	 DBMS_OUTPUT.PUT_LINE('제품이 입력되어 있습니다.');
 END;

-----------------------------------------------------------------
-- 상품테이블
CREATE TABLE 상품(
	상품코드 CHAR(4) CONSTRAINT 상품_PK PRIMARY KEY,
	상품명 VARCHAR2(20) NOT NULL, 
	제조자 VARCHAR2(50),
	소비자가격 NUMBER,
	재고수량 NUMBER DEFAULT 0
);

--입고 테이블
CREATE TABLE 입고(
	입고번호 NUMBER CONSTRAINT 입고_PK PRIMARY KEY,
	상품코드 CHAR(4) CONSTRAINT 입고_FK REFERENCES 상품(상품코드),
	입고일자 DATE DEFAULT SYSDATE,
	입고수량 NUMBER,
	입고단가 NUMBER,
	입고금액 NUMBER
);

--입고 시퀀스
CREATE SEQUENCE 입고_SEQ
	START WITH 1 INCREMENT BY 1 NOCYCLE NOCACHE;

-- 더미테이블
INSERT INTO 상품
(상품코드, 상품명, 제조자, 소비자가격)
VALUES('A001', '마우스', '삼성', 1000);

INSERT INTO 상품
(상품코드, 상품명, 제조자, 소비자가격)
VALUES('A002', '키보드', 'LG', 2000);

INSERT INTO 상품
(상품코드, 상품명, 제조자, 소비자가격)
VALUES('A003', '모니터', '알파스캔', 5000);

SELECT *
	FROM 상품;

--입력 트리거(입고 테이블에 상품이 입력이 되었을 때 재고를 증가시킴)
-- 입고테이블에 키보드가 10개가 입고 되었을 때 상품테이블의 A002의 상품의 재고를 0-> 10으로 변경
CREATE OR REPLACE TRIGGER PRODUCT_INSERT
	AFTER INSERT ON 입고 
	FOR EACH ROW 
	BEGIN 
		UPDATE 상품 SET 재고수량 = :NEW.입고수량 + 재고수량
		WHERE 상품코드 = :NEW.상품코드;
	END;
	
INSERT INTO 입고
(입고번호, 상품코드, 입고수량, 입고단가, 입고금액)
VALUES(입고_SEQ.NEXTVAL, 'A002', 10, 1000, 10000);

-- 입고테이블에 상품의 입고수량이 변경됐을 때 상품테이블의 재고 수량을 변경
CREATE OR REPLACE TRIGGER PRODUCT_UPDATE
    AFTER UPDATE ON 입고
    FOR EACH ROW 
    BEGIN 
        UPDATE 상품 SET 재고수량 = 재고수량 - :OLD.입고수량 + :NEW.입고수량
        WHERE 상품코드 = :NEW.상품코드;
    END;

UPDATE 입고 SET 입고수량 = 40 WHERE 입고번호 =9;

--삭제 트리거
--입고테이블에서 삭제 해당상품의 재고에서 입고수량
CREATE OR REPLACE TRIGGER PRODUCT_DELETE
    AFTER DELETE ON 입고
    FOR EACH ROW 
    BEGIN 
        UPDATE 상품 SET 재고수량 = 재고수량 - :OLD.입고수량
        WHERE 상품코드 = :OLD.상품코드;
    END;
   
DELETE FROM 입고 WHERE 입고번호 = 9;













