-- 20220121
-- SELECT 기본문법

--SELECT 컬럼명 FROM 테이블명[WHERE 컬럼명=컬럼명의 어떠한 값]


SELECT * -- WILD CARD(전체)
			FROM PLAYER p ;
		
--SQL문에서 값은 모두 '(SINGLE QUOTE)'
--"(DOUBLE QUOTE)" 예약어를 값으로 사용할 때, ALIAS에 공백이 있을 경우
SELECT PLAYER_ID , "POSITION"
			FROM PLAYER p;
SELECT PLAYER_ID 선수아이디, BACK_NO AS 백넘버, HEIGHT / WEIGHT BMI,
			E_PLAYER_NAME "영문 선수 아이디"
			FROM PLAYER p;
	
SELECT p.*
		FROM PLAYER p; -- 테이블 ALIAS
SELECT p.PLAYER_ID
		FROM PLAYER p;

	-- FROM절의 ALIAS 필수
	-- ALIAS와 테이블명을 복합으로 사용하면 안됨
SELECT p.PLAYER_ID, PLAYER.PLAYER_ID 
		FROM PLAYER p;
	
SELECT p.PLAYER_ID, p.PLAYER_ID 
		FROM PLAYER p;
SELECT p.PLAYER_ID, PLAYER .PLAYER_ID 
		FROM PLAYER p;
	
--조건절 비교 AND(교집합) OR(합집합)
SELECT *
		FROM EMP
				WHERE EMPNO = '7369' OR JOB = 'CHECK';
SELECT *
		FROM EMP -- 연산자 우선순위는 AND가 우선이다.그다음 OR
				WHERE EMPNO = '7369' OR JOB = 'SALESMAN' AND EMPNO=7499;

--IN 연산자
SELECT *
		FROM EMP
				WHERE EMPNO IN('7369','7876'); --연산자 우선순위가 높음
				
-- 중복제거 쓰지않는다는거
-- SELECT ANY(*) DISTINCT
-- ** SQL문의 실행 순서 FROM -> WHERE -> SELECT 
SELECT *
		FROM TEAM t ;
	
SELECT	 DISTINCT(TEAM_ID), PLAYER_ID 
		FROM PLAYER p ;
		
--테이블의 원래 형태
-- 선수들의 소속된 팀명, 팀아이디, 선수 이름을 알고 싶다.
-- 테이블 : PLAYER ,TEAM
-- 컴색컬럼: 팀명(TEAM_NAME), 팀아이디, 선수이름
-- 연결컬럼: PLAYER, TEAM_ID, TEAM.TEAM_ID
SELECT TEAM_NAME, TEAM_ID , PLAYER_NAME , 
		FROM PLAYER p, TEAM t 
				WHERE p.TEAM_ID = t.TEAM_ID ;
				
--급여가 1250 초과이면서 직무가 SALESMAN인 직원의 부서를 알고 싶다. 급여를 오름차 순으로 출력
--테이블 : EMP, DEPT
--컬럼 : EMP*, DEPT.DNAME
--연결 컬럼 : EMP.DEPTNO, DEPT.DEPTNO
SELECT ENAME ,JOB, DEPT.DNAME 
		FROM EMP, DEPT  -- CARTESIAN PRODUCT
			WHERE EMP.DEPTNO = DEPT.DEPTNO 
			AND SAL > '1250'
			AND JOB ='SALESMAN'
		ORDER BY DEPT.DEPTNO ;
