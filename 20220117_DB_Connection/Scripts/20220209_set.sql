-- Set operation
-- 다른 쿼리를 붙여서 출력해 줄 수 있다
-- 단, 1)order by는 맨 마지막에 작성해야 한다
--	   2)같은 타입의 컬럼이 출력되어야 한다
--     3)컬럼명은 선택 테이블의 명으로 정해짐
--UNION		: 중복되는 ROM을 제거하고 표현
--UNION ALL	: 두 개의 쿼리는 단순히 붙여서 포기
--INTERSECT	: 교차되는 값을 출력
--MINUS 	: 선행 테이블에서 교차되는 값을 제거한 순수한 선행 ROW만을 출력

-- 축구 선수들의 정보 중에서 K02와 K07 선수들의 정보를 출력
SELECT *
	FROM PLAYER p 
	WHERE TEAM_ID IN('K02','K07');

-- 출력 타입이 같아야한다. 컬럼명 선택 테이블로 작성된다
SELECT *
	FROM PLAYER p 
	WHERE TEAM_ID = 'K02'
UNION
SELECT *
	FROM PLAYER p 
	WHERE TEAM_ID ='K07';

SELECT PLAYER_NAME, TEAM_ID , '1', 99 AS 등번호
	FROM PLAYER p 
	WHERE TEAM_ID ='K02'
	--	ORDER BY 1 -- 오더바이는 문장 맨 마지막에 작성되어야한다
UNION 
SELECT PLAYER_NAME, TEAM_ID , "POSITION" , NVL(BACK_NO,99) 
	FROM PLAYER p
	WHERE TEAM_ID ='K07'
	ORDER BY 1;
	
--DB에서는 NULL이 가장 큰 값으로 나온다 숫자 -> 문자 ->널
--JAVA에서 [] 순서 SORT NULL이 맨 앞에 나온다 널->숫자->문자

SELECT COMM
	FROM EMP
	ORDER BY COMM DESC;
--1) K- 리그 소속 선수 중 소속이 삼성블루왕즈팀인 선수들의 집합과
--K- 리그 소속 선수 중 소속이 전남드레곤즈팀인 선수들의 집합의 합집합
SELECT *
	FROM PLAYER p 
	WHERE TEAM_ID IN('K02','K07');


SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션, BACK_NO 백넘버, HEIGHT 키
	FROM PLAYER p 
	WHERE TEAM_ID  ='K02'
UNION
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션, BACK_NO 백넘버, HEIGHT 키
	FROM PLAYER p 
	WHERE TEAM_ID = 'K07';
	



--2) K- 리그 소속 선수 중 소속이 삼성블루왕즈팀 인 선수들의 집합과
--K- 리그 소속 선수 중 포지션이 골키퍼 (GK) 인 선수들의 집합의 합집합

--UNION에서의 ORDER BY는 ALIAS와 INDEX만 잦ㄱ동됨
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션, BACK_NO 백넘버, HEIGHT 키
	FROM PLAYER p 
	WHERE TEAM_ID = 'K02'
UNION
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션, BACK_NO 백넘버, HEIGHT 키
	FROM PLAYER p
	WHERE "POSITION" = 'GK'
	ORDER BY 포지션, 1;

SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션, BACK_NO 백넘버, HEIGHT 키
	FROM PLAYER p 
	WHERE "POSITION" = 'GK'
--	ORDER BY "POSITION", TEAM_ID ;
--	ORDER BY 3, 1; --INDEX;
	ORDER BY 포지션, 팀코드; --ALIAS 명


SELECT *
	FROM PLAYER p 
	WHERE TEAM_ID ='K02' OR "POSITION" = 'GK'
	ORDER BY "POSITION", TEAM_ID ;


-- UNION은 같은 값이면 제거하고 출력
-- K02 이면서 GK + K02 + GK ==>	92명 -4명 (K02이면서 GK)
--UNION ALL인 경우 중복제거 X
--	교차인 4명 INTERSECT를 통해서 검색 가능
--	검색되는 테이블의 조건 TEAM_ID 와 POSITION (TEAM_ID),(POSITION),(TEAM_ID AND POSITION)

SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션, BACK_NO 백넘버, HEIGHT 키
	FROM PLAYER p --481
UNION
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션, BACK_NO 백넘버, HEIGHT 키
	FROM PLAYER p2
	WHERE "POSITION" = 'GK'; --43
	
--481 > 524-43
	

--3) K- 리그 소속 선수 중 포지션별 평균키에 대한 집합과
--K- 리그 소속 선수 중 팀별 평균키에 대한 집합의 합집합
SELECT "POSITION" 이름 ,AVG(HEIGHT) 평균키   
	FROM PLAYER p
	WHERE "POSITION" IS NOT NULL 
	GROUP BY "POSITION"   
UNION 
SELECT TEAM_ID ,AVG(HEIGHT) 
	FROM PLAYER p 
	GROUP BY TEAM_ID ;

--문제점 : ~별 은 절대 같은 쿼리로 동작을 시킬 수가 없습니다. 같이되는애들은 집계함수(SUM, MAX, MIN, AVG)
SELECT "POSITION", TEAM_ID ,AVG(HEIGHT) 
	FROM PLAYER p 
	GROUP BY TEAM_ID, "POSITION" ;
--GROUP BY 묶어서 처리
-- TEAM_ID 따로 POSITION 따로 된것이 아니라, TEAM_ID AND(&) POSITION 인 묶음으로 나타냄

SELECT "POSITION" || TEAM_ID
	FROM PLAYER p ;
	
--4) K 리그 소속 선수 중 소속이 삼성블루왕즈팀인 선수들의 집합과
--K- 리그 소속 선수 중 포지션이 미드필더 (MF)) 인 선수들의 집합의 차집합
SELECT  TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션 , BACK_NO 백넘버, HEIGHT 키 
	FROM PLAYER p 
		WHERE TEAM_ID = 'K02' AND "POSITION" !='MF';--31명
--전체결과에서 차집합
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션 , BACK_NO 백넘버, HEIGHT 키 
	FROM PLAYER p 
	WHERE TEAM_ID ='K02';--49명

SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션 , BACK_NO 백넘버, HEIGHT 키 
	FROM PLAYER p 
	WHERE TEAM_ID ='K02' AND "POSITION"='MF';--18명
	
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션 , BACK_NO 백넘버, HEIGHT 키 
	FROM PLAYER p 
	WHERE TEAM_ID ='K02'--49명
MINUS
SELECT TEAM_ID 팀코드, PLAYER_NAME 선수명, "POSITION" 포지션 , BACK_NO 백넘버, HEIGHT 키 
	FROM PLAYER p 
	WHERE "POSITION"='MF';--18명
	
--5) K- 리그 소속 선수 중 소속이 삼성블루명즈팀인 선수들의 집합과
--K- 리그 소속 선수 중 포지션이 골키퍼 (GK) 인 선수들의 집합의 교집합

--K02인 선수들 중에서 GK를 선택하고 출력
--K02인 선수들 중에서 MF, FW, DF인 선수들을 제외하면됨

--비효율적이 아니라 가독성이 떨어진다.
SELECT *
	FROM PLAYER p 
	WHERE TEAM_ID ='K02' AND "POSITION" ='GK';
SELECT *
	FROM PLAYER p 
	WHERE TEAM_ID ='K02' AND "POSITION" NOT IN ('MF', 'FW', 'DF');

SELECT *
	FROM PLAYER p 
	WHERE TEAM_ID ='K02' AND 
		"POSITION" != 'MF' AND
      	"POSITION" != 'FW' AND
      	"POSITION" != 'DF';
      
--3일차 SQL과제
      
--1.	 사원 테이블에서 각 사원에 급여(SAL) 등급을 아래 예제처럼 출력하세요?
--(급여순위점수(SALGRADE) 테이블 조인)
--ex) 정렬은 등급(GRADE) 오름차순
--퓰이 : EQUI JOIN이 아니라 범위를 가진 NON-EQUI JOIN 방식이다
 
      
SELECT *
	FROM SAL_GRADE sg ;

SELECT EMPNO, ENAME, SAL, GRADE
	FROM EMP JOIN SAL_GRADE sg 
	ON SAL BETWEEN LOSAL AND HISAL;

SELECT EMPNO, ENAME, SAL, GRADE
	FROM EMP JOIN SAL_GRADE sg 
	ON SAL >= LOSAL AND SAL <=HISAL ;

SELECT EMPNO, ENAME, SAL, GRADE
	FROM EMP JOIN SAL_GRADE sg 
	ON SAL >= LOSAL 
	WHERE SAL <= HISAL ;

--2.	사원 테이블에서 평균 급여(SAL) 보다 높은 사원 정보를 아래 예제처럼 출력하세요? 
--ex) 정렬은 급여(SAL) 내림차순
-- 집계 함쑤는 WHERE절에 사용할 수 없다.
-- 내부에서 단독으로 작동되는 쿼리 (SUBQUERY) -> 주의 점 반드시 () 괄호로 묶어 줘야함
SELECT EMPNO, ENAME , JOB , SAL 
	FROM EMP e 
	WHERE SAL > (SELECT AVG(SAL) FROM EMP e2)
	ORDER BY SAL DESC;

--3.	사원 테이블에서 부서별 평균 급여(SAL) 보다 높은 사원 정보를 아래 예제처럼 출력하세요?
--ex) 정렬은 급여(SAL) 내림차순

--1) 직원들의 정보 EMP테이블(EMPNO, ENAME, JOB, SAL)
-- 부서정보 DEPT(DNAME)
--2) INLINE VIEW는 만들어 놓은 각 부서별 평균 급여(DEPTNO)

SELECT 'DNAME', EMPNO, ENAME, JOB, SAL, DEPTNO
	FROM EMP e
	WHERE DEPTNO IS NOT NULL 
	ORDER BY DEPTNO;

SELECT DEPTNO, AVG(SAL) 평균급여
	FROM EMP e 
	WHERE DEPTNO IS NOT NULL 
	GROUP BY DEPTNO 
	ORDER BY DEPTNO ;
------------------------------------------------------
CREATE VIEW EMP_AVG AS SELECT DEPTNO, AVG(SAL) 평균급여
						FROM EMP e 
						WHERE DEPTNO IS NOT NULL 
						GROUP BY DEPTNO 
						ORDER BY DEPTNO ;
					
SELECT d.DNAME ,EMPNO, ENAME, JOB, SAL, 평균급여
	FROM EMP e JOIN EMP_AVG ev
			ON e.DEPTNO =ev.DEPTNO
				JOIN DEPT d 
			ON e.DEPTNO = d.DEPTNO 
	WHERE e.SAL > ev.평균급여
	ORDER BY SAL DESC;
	


---------------------------------아래 우연이가 푼거
SELECT DNAME, EMPNO, ENAME , JOB , SAL
	FROM EMP e JOIN DEPT d 
	USING(DEPTNO)
--	ON e.DEPTNO = d.DEPTNO 
	WHERE SAL > (SELECT AVG(SAL) FROM EMP e2) --SUBQUERY는 EMP테이블의 전체 평균 > XXX
	ORDER BY SAL DESC;

--연관 서브쿼리 MAIN 쿼리의 FROM 절의 1개의 ROW를 사용하여 SUBQUERY에서 조인한 후 결과를 반환
SELECT d.DNAME , EMPNO, ENAME , JOB , SAL
	FROM EMP e , DEPT d 
	WHERE e.DEPTNO = d.DEPTNO 
		AND SAL > (SELECT AVG(SAL)
					FROM EMP e2
					WHERE e.DEPTNO = e2.DEPTNO)
	ORDER BY SAL DESC;

--4.	사원 테이블에서 각 사원에 급여(SAL) 순위 점수 별로 인원수를 아래 예제처럼 출력하세요?
--(급여순위점수(SALGRADE) 테이블 조인)
	
-- 치현님
SELECT sg.GRADE , LOSAL , HISAL , c.CNT
	FROM SAL_GRADE sg  
	JOIN (SELECT sg.GRADE, COUNT(sg.GRADE) CNT  
			FROM EMP e JOIN SAL_GRADE sg
			ON e.SAL BETWEEN sg.LOSAL AND sg.HISAL 
			GROUP BY sg.GRADE	
			ORDER BY sg.GRADE) c
	ON sg.GRADE = c.GRADE;

--우연님
SELECT GRADE, LOSAL , HISAL , COUNT(GRADE) AS CNT
	FROM EMP e JOIN SAL_GRADE sg 
	ON SAL BETWEEN LOSAL AND HISAL
	GROUP BY GRADE ,LOSAL ,HISAL ;

	

--5.	부서명이 'RESEARCH' 이거나 부서위치가 'NEW YORK' 사원 정보를 아래 예제처럼 출력하세요?
--ex) 정렬은 부서명(DNAME) 오름차순
SELECT DNAME , LOC , EMPNO, ENAME  
	FROM DEPT d, EMP e 
		WHERE d.DEPTNO = e.DEPTNO 
		AND (LOC = 'NEW YORK' OR DNAME = 'RESEARCH')
	ORDER BY DNAME ASC;

--4일차 SQL
--1.	사원 테이블에서 각 사원에 급여(SAL)가 높은 순서대로 상위 5명을 아래 예제처럼 출력하세요? 
--우연
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
	FROM ( SELECT * FROM EMP e ORDER BY SAL DESC)
	WHERE ROWNUM<=5;

--치현
SELECT e.*
	FROM EMP e , (SELECT EMPNO,SAL, RANK() OVER (ORDER BY SAL DESC,ENAME DESC) AS "RNUMBER" 
	FROM EMP ORDER BY SAL DESC) c
	WHERE c.RNUMBER < 6 
	AND e.EMPNO = c.EMPNO
		ORDER BY e.SAL DESC;



--2. 사원 테이블에서 각 사원에 급여(SAL)가 높은 순서대로 순위를 부여 했을 때 6등~10등인 사람을 순위대로 아래 예제처럼 출력하세요? 
-- EX)
-- 나중에 paging 처리 할 때 필요한 코드

SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO, RM
	FROM (
		SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO, ROWNUM RM
			FROM(
				SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO
					FROM EMP
					ORDER BY SAL DESC)
					)
		WHERE RM BETWEEN 6 AND 10;

	-- OVER(행 정렬)
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO, RN
	FROM(
SELECT EMPNO, ENAME, JOB, MGR , HIREDATE , SAL, COMM, DEPTNO , ROW_NUMBER () OVER(ORDER BY SAL DESC) RN
	FROM EMP e )
	WHERE RN BETWEEN 6 AND 10;
			


--3아래 SQL 실행 했을 경우 0건 출력되는 이유를 설명하세요?
--ex) 
SELECT ROWNUM, A.* 
	FROM   EMP A
	WHERE  ROWNUM > 5;

	ROWNUM은 FROM의 결과에 따라서 동적으로 부여되는 번호
	위의 쿼리는 처음 데이터 들어 갔을 때 ROWNUM 은 1이 부여되어야 한다
	하지만 5보다 크다는 만족할 수 있는 작은 값이 생성되지 않앗기 때문에
	1이상의 값이 증가 되지 않기 때문에 5가 될수 없고 0이 출력된다.
	
--4.SALGRADE 테이블 데이터 세로 정보를 가로로 아래 예제처럼 출력하세요?
--EX)
		SELECT 
			MAX(CASE GRADE WHEN 1 THEN LOSAL || '~' ||HISAL END) AS GRADE_1,
			MAX(CASE GRADE WHEN 2 THEN LOSAL || '~' ||HISAL END) AS GRADE_2,
			MAX(CASE GRADE WHEN 3 THEN LOSAL || '~' ||HISAL END) AS GRADE_3,
			MAX(CASE GRADE WHEN 4 THEN LOSAL || '~' ||HISAL END) AS GRADE_4,
			MAX(CASE GRADE WHEN 5 THEN LOSAL || '~' ||HISAL END) AS GRADE_5
		FROM SAL_GRADE sg ;
	
	SELECT 
			MAX(DECODE(GRADE, 1, LOSAL || '~' || HISAL)) AS GRADE_1,
			MAX(DECODE(GRADE, 2, LOSAL || '~' || HISAL)) AS GRADE_2,
			MAX(DECODE(GRADE, 3, LOSAL || '~' || HISAL)) AS GRADE_3,
			MAX(DECODE(GRADE, 4, LOSAL || '~' || HISAL)) AS GRADE_4,
			MAX(DECODE(GRADE, 5, LOSAL || '~' || HISAL)) AS GRADE_5
		FROM SAL_GRADE sg ;
	
--5.SALGRADE_TEMP 테이블을 아래처럼 만들고,위의 예제와 반대로  데이터 가로 정보를 세로로 아래 예제처럼 출력되게 SQL을 작성하세요?
	CREATE TABLE SAL_GRADE_TEMP AS SELECT 
    MAX(CASE GRADE WHEN 1 THEN LOSAL || '~' || HISAL END) AS GRADE_1,
    MAX(CASE GRADE WHEN 2 THEN LOSAL || '~' || HISAL END) AS GRADE_2,
    MAX(CASE GRADE WHEN 3 THEN LOSAL || '~' || HISAL END) AS GRADE_3,
    MAX(CASE GRADE WHEN 4 THEN LOSAL || '~' || HISAL END) AS GRADE_4,
    MAX(CASE GRADE WHEN 5 THEN LOSAL || '~' || HISAL END) AS GRADE_5
    FROM SAL_GRADE sg;
   
   	SELECT GRADE ,
	MAX(CASE GRADE WHEN 1 THEN  LOSAL ||'~' || HISAL
					WHEN 2 THEN LOSAL || '~' || HISAL 
					WHEN 3 THEN LOSAL || '~' || HISAL 
					WHEN 4 THEN LOSAL || '~' || HISAL 
					WHEN 5 THEN LOSAL || '~' || HISAL  END) GRADE_5
	FROM SAL_GRADE sg
	GROUP BY GRADE;

--5일차 SQL
--1. 1.	사원 테이블에서 EMPNO, MGR, SAL 세 개의 컬럼을 단순 숫자 의미로 가정 할 경우 
--		세 개의 값 중 최대값(MAX_VALUE), 최소값(MIN_VALUE) 을 아래 예제처럼 출력하세요?
--ex) EMPNO, MGR, SAL 컬럼 중 널 값이 존재할 경우 0으로 치환
--       정렬은 최대값 내림차순


	
