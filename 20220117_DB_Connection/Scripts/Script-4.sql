-- 20220121
-- SELECT 기본문법

-- SELECT 컬럼명 FROM 테이블명 [WHERE = 컬럼명의 어떠한 값];

SELECT * --와일드카드(전체)
	FROM PLAYER p ;

-- SQL문에서 값은 모두 '(SINGLE QUOTE)'
-- "(DOUBLE QUOTE)" 예약어를 값으로 사용할때, ALIAS에 공백이 있을 경우
SELECT PLAYER_ID, "POSITION" 
	FROM PLAYER p ;

SELECT PLAYER_ID 선수아이디, BACK_NO AS 백넘버 , HEIGHT / WEIGHT BMI, 
		E_PLAYER_NAME "영문 선수 아이디"
	FROM PLAYER p ;
	
SELECT P.*
	FROM PLAYER p ; --테이블 ALIAS
	
	
SELECT P.PLAYER_ID
	FROM PLAYER p ;

-- FROM절의 ALIAS 필수
-- ALIAS와 테이블명을 복합으로 사용하면 안됨
SELECT P.PLAYER_ID, PLAYER.PLAYER_ID 
	FROM PLAYER p ;

SELECT P.PLAYER_ID, P.PLAYER_ID 
	FROM PLAYER p ;

SELECT PLAYER.PLAYER_ID, PLAYER.PLAYER_ID 
	FROM PLAYER PLAYER ;

-- 조건절 비교 AND(교집합) OR(합집합)
SELECT *
	FROM EMP 
		WHERE EMPNO = '7369' OR JOB = 'CLERK';

-- 연산자인 AND와 OR 순으로 연산 진행
SELECT *
	FROM EMP 
		WHERE EMPNO = '7369' OR JOB = 'SALESMAN' AND EMPNO =7499;

SELECT *
	FROM EMP 
		WHERE EMPNO = '7369' AND EMPNO = 7499 OR JOB = 'SALESMAN';
	
-- IN 연산자
SELECT *
	FROM EMP 
		WHERE EMPNO IN ('7369', '7876'); -- 우선순위가 높음
	
-- 중복제거 쓰지않는다는거~
-- SELECT ANY(*) DISTINT
-- ** SQL문의 실행 순서 FROM -> WHERE -> SELECT 
SELECT *
	FROM TEAM t ;

SELECT PLAYER_NAME , TEAM_ID 
	FROM PLAYER p ;

SELECT DISTINCT (TEAM_ID), PLAYER_ID 
	FROM PLAYER p ;

--테이블의 원래 형태
-- 선수들의 소속된 팀명, 팀ID, 선수이름을 알고싶다
-- 테이블 : PLAYER, TEAM
-- 컴생컬럼 : 팀명(TEAM_NAME), 팀아이디(TEMA_ID), 선수이름(PLAYER_NAME)
-- 연결컬럼 : PLAYER의 TEAM_ID , TEAM.TEAM_ID

SELECT TEAM_NAME 팀이름, t.TEAM_ID 팀아이디, PLAYER_NAME 선수이름
	FROM PLAYER p, TEAM t 
	WHERE P.TEAM_ID = T.TEAM_ID; -- 카테시안프로덕트. CROSS JOIN CATESIAN PRODUCT

--급여(SAL)가 1250 초과이면서 직무(JOB)가 SALESNAME인 직원의 정보와 부서(DEPTNO)를 알고싶다. 급여를 오름차순으로 출력
-- 테이블 : EMP, DEPT
-- 컬럼 : EMP.*, DEPT.DNAME 
-- 연결ㄹ컬럼 : EMP.DEPTNO , DEPT.DEPTNO 

-- SAL이 없어도 SAL로 정렬 가능
SELECT ENAME , JOB , DEPT.DNAME 
        FROM EMP , DEPT 
            WHERE EMP.DEPTNO = DEPT.DEPTNO 
            AND SAL > '1250' 
            AND JOB ='SALESMAN'
        ORDER BY DEPT.DEPTNO ;
       
CREATE TABLE TEST(
	NAME VARCHAR2(20),
	"name" CHAR(10)

);

INSERT INTO TEST(NAME, "name") VALUES('A', 'B');

--GD."USER"
SELECT *
 FROM GD."DEPT" ;
 
INSERT INTO TEST(NAME) VALUES('C');
INSERT INTO TEST VALUES('C','C');
INSERT INTO TEST VALUES('D', '');
INSERT INTO TEST VALUES('E', NULL);
COMMIT;

SELECT *
	FROM TEST t ;
	

-- CTAS
CREATE TABLE TEAM_TEMP AS SELECT * FROM TEAM t ;

-- ALTER ADD COLUM
ALTER TABLE PLAYER ADD (ADDRESS VARCHAR2(100));

SELECT ADDRESS 
	FROM PLAYER;


SELECT *
	FROM TEST t ;

ALTER TABLE TEST 
	RENAME COLUMN "name" TO HELLO;

RENAME TEST TO TEST_2;

SELECT * FROM TEST_2;

DROP TABLE TEST_2;




