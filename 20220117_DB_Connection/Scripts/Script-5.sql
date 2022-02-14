-- 20220124
-- DML 데이터 조작 언어
-- SELECT , INSERT , DELETE, UPDATE => CRUD

CREATE TABLE INFO(
	SEQ NUMBER PRIMARY KEY, -- 컬럼 정의 방식
	NAME VARCHAR2(50) NOT NULL,
	PHONE VARCHAR2(20),
	AUTH CHAR(1),
	REGDATE DATE NOT NULL
	-- CONSTRANINT INFO PRIMARY KEY (SEQ) -- 테이블 정의 방식
);

-- ALTER TABLE INFO ADD CONSTRAINT ~~ PRIMARY KEY SEQ -- ALTER 정의 방식

-- SEQUENCE 자동으로 증가 되어서 컬럼의 값을 UNIQUE하게 만들기 위해서
-- NEXTVAL, CURRVAL, SESSION
-- 값을 증가(NEXTVAL)시키지 않았다면 현재 값(CURRVAL)을 가지고 올 수 가 없다.
CREATE SEQUENCE INFO_SEQ START WITH 1 INCREMENT BY 1;
SELECT INFO_SEQ.CURRVAL
	FROM DUAL;

SELECT INFO_SEQ.NEXTVAL
	FROM DUAL;
-- DUAL 테이블
-- DUMMY 테이블 문법을 맞추기 위해서 DBMS가 가상으로 사용하는 테이블
-- 값이 없을경우(공집합) x가 반환됨

SELECT * FROM DUAL;
SELECT SYSDATE 시간, '맑음' AS 날씨, '눈' "눈 SNOW"
	FROM DUAL;

-- AUTH에 DEFAULT 제약조건을 정의 하도록 함
ALTER TABLE INFO MODIFY (AUTH DEFAULT 'U');

-- INFO 테이블 값을 입력한다?
-- 반드시 입력해야할 값은? SEQ, NAME, REGDATE
-- 테이블이 DEFAULT가 정의 되어 있다면? AUTH
-- 명시적 방법으로 입력 해야 한다.

INSERT INTO INFO 
	VALUES(INFO_SEQ.NEXTVAL, '까치', '', '', '20220124');
SELECT *
	FROM INFO;

INSERT INTO INFO(SEQ, NAME, PHONE, REGDATE)
	VALUES(INFO_SEQ.NEXTVAL, '산군', '009', SYSDATE);

-- 182P 예제
-- 선수테이블에 박지성 선수의 데이터를 입력
-- PLAYER PLAYER_ID, PLAYER_NAME, TEAM_ID
-- 테이블은 모두 관계를 가지고 (예외 : 코드성테이블, 통계)
INSERT INTO PLAYER(PLAYER_ID, PLAYER_NAME, TEAM_ID)
	VALUES ('2001155', '박지성', 'K16');
-- 무결성 제약조건(GD.PLAYER_FK) 부모키가 없음 ORA-02291


INSERT INTO PLAYER(PLAYER_ID, PLAYER_NAME, TEAM_ID)
	VALUES ('2007155', '박지성', 'K15');
-- 무결성 제약조건(GD.PLAYER_FK) 유니크키가 아님 ORA-00001

INSERT INTO PLAYER(PLAYER_ID, PLAYER_NAME, TEAM_ID)
	VALUES ('2022011', '박지성', 'K15');

-- TCL 현재 작업하고 있는 SESSION의 변경 상태를 볼 수 있음
-- 하지만 다른 SESSION의 사용자는 변경된 상태가 적용(COMMIT)되어 있는
-- 상태가 아니기 때문에 확인이 되지 않는다.

SELECT PLAYER_ID
	FROM PLAYER p ;

SELECT TEAM_ID 
	FROM TEAM t ;

COMMIT;

SELECT * 
	FROM PLAYER 
		WHERE PLAYER_ID = '2022011';
	
--UPDATE 
-- 입력되어 있는 데이터를 수정할때 사용 => WHERE을 사용해야 한다.

SELECT *
	FROM INFO;

UPDATE INFO 
	SET PHONE = '007' 
		WHERE SEQ = '3';
	
-- 문제 : INFO테이블에 자신의 정보를 입력하고
--		AUTH를 'A'로 변경하세요
	
INSERT INTO INFO(SEQ, NAME, PHONE, AUTH, REGDATE)
	VALUES (INFO_SEQ.NEXTVAL, '김우연', '01045057042', 'A', '19970710');

UPDATE INFO 
	SET AUTH = 'A' , REGDATE = '19960409' 
		WHERE  SEQ = '6';

COMMIT;

-- 선수 테이블의 백넘을 일괄적으로 99로 변경
UPDATE PLAYER 
	SET BACK_NO = '99';
	
SELECT BACK_NO 
	FROM PLAYER p ;
	

--DELETE 
-- INFO 의 NAME이 까치인 ROW를 삭제해 주세요
DELETE FROM INFO 
	WHERE NAME = '까치';
SELECT *
	FROM INFO;
	
-- 문제 185쪽
-- 축구선수들의 정보(아이디, 이름, 팀아이디, 포지션, 키, 몸무게, 등번호)를 알고싶다.

SELECT PLAYER_ID ,PLAYER_NAME ,TEAM_ID ,"POSITION" ,HEIGHT ,WEIGHT , BACK_NO 
	FROM PLAYER p ;
	
-- 문제 186 DISTINCT 옵션을 사용 - 중복되는 값을 SELECT  절에서 묶어서 표현
-- 축구선수들의 아이디로 DISTINCT 갯수와
-- 축구선수들의 PLAYER_NAME으로 DISTINCT 갯수를 확인해 주세요
SELECT DISTINCT (PLAYER_ID)
	FROM PLAYER p ; -- 481

SELECT  DISTINCT (PLAYER_NAME) 
	FROM PLAYER p ; -- 472
	
-- ALIAS
-- SELECT  절, FROM 절
-- SELECT 연산이나 혹은 컬럼명을 객체와 매핑할때 사용 AS문법으로 사용
-- FROM 테이블명이 길어서 작성하기 힘들때 사용하게 됨

-- 문제) 홈그라운드 구장을 알고싶다
-- 테이블 : STADIUM , TEAM 
-- 연결 : STADIUM (STADIUM_ID), TEAM (STADIUM_ID)

SELECT *
	FROM STADIUM s , TEAM t 
	WHERE s.STADIUM_ID  = t.STADIUM_ID ; -- 팀이 15개 이기 때문에

SELECT *
	FROM STADIUM s , TEAM t 
	WHERE s.STADIUM_ID  = t.STADIUM_ID 
	AND s.HOMETEAM_ID = t.TEAM_ID ; -- 팀이 15개 이기 때문

	
-- 팀이 없는 구장의 정보를 보고싶다.
SELECT *
	FROM STADIUM s 
	WHERE HOMETEAM_ID IS NULL ;

-- OUTER JOIN(LEFT, RIGHT, FULL)
-- 왼쪽의 테이블(STADIUM)을 기준으로 오른쪽의 테이블을 붙인다.
-- JOIN 중복된 교차값이 나오지만 OUTER JOIN은 특정 테이블을 선택된 테이블 전체 + JOIN ROW가 나옴
SELECT s.STADIUM_ID , TEAM_ID, TEAM_NAME
	FROM STADIUM s LEFT OUTER JOIN TEAM t 
	ON s.STADIUM_ID  = t.STADIUM_ID ;

-- FROM 절의 조인은
-- 테이블 명을 대신해서 사용하거나(s.STADIUM_ID), 단일값으로 선택하기 위해서(s.STADIUM_ID)
-- FROM 절에 ALIAS를 사용했다면 반드시 ALIAS로 사용해야 함(STADIUM.STATIUM_ID 안됨)

--SELECT 절 ALIAS : 출력되는 컬럼명을 정의 하기 위해서
-- 테이블 AS ALIAS, 테이블 ALIAS, 테이블 "공백 컬럼명"

SELECT PLAYER_ID AS 아이디, PLAYER_NAME 이름, HEIGHT 키, BACK_NO "등 번호"
	FROM PLAYER p ;

-- 문제 190페이지
-- 각 선수들의 BMI지수를 계산하여 출력
-- 선수 이름, BMI로 출랙해 주세요

SELECT PLAYER_NAME AS "선수 이름",  ROUND(WEIGHT / (WEIGHT/100*HEIGHT/100)) AS "BMI"
	FROM PLAYER p ;

-- 191페이지 TCL
-- COMMIT; ROLBACK;

SAVEPOINT SVPT1;
INSERT INTO PLAYER(PLAYER_ID, PLAYER_NAME, TEAM_ID)
	VALUES ('2022012', '전민균', 'K01');
SAVEPOINT SVPT2;
UPDATE PLAYER SET PLAYER_NAME ='이령' 
	WHERE PLAYER_ID = '2022012';
SAVEPOINT SVPT3;
DELETE FROM PLAYER p ;
SELECT *
	FROM PLAYER
		WHERE PLAYER_ID = '2022012';
ROLLBACK TO SVPT3;
ROLLBACK TO SVPT1;




