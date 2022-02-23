-- 20220214
-- 그룹 함수
-- 집계(SUM, MAX, MIN, AVG, ACCOUNT)
-- GROUP함수 : GROUP BY -> 통계 함수 ROLLUP CUBE GROUPIN GSET

-- ROLLUP 소계를 나타낸다. 
-- GROUP BY (A, B)
-- 부서명과 업무명 기준으로 사원수와 급여 합을 집계 GROUP BY
SELECT DNAME , JOB
	FROM EMP e JOIN DEPT d 
	USING(DEPTNO)
	GROUP BY DNAME , JOB
	ORDER BY 1;

SELECT DNAME , JOB, COUNT(*), SUM(SAL) --9개
	FROM EMP e JOIN DEPT d 
	USING(DEPTNO)
	
	GROUP BY JOB, DNAME 
	ORDER BY 1;

SELECT DISTINCT JOB
	FROM EMP;

SELECT DNAME , JOB, COUNT(*), SUM(SAL) --14개
	FROM EMP e JOIN DEPT d 
	USING(DEPTNO)
	GROUP BY ROLLUP (DNAME, JOB) --DNAME별로 소계
	ORDER BY 1;

SELECT JOB, DNAME, COUNT(*), SUM(SAL) --13개
	FROM EMP e JOIN DEPT d 
	USING(DEPTNO)
	GROUP BY JOB, ROLLUP (DNAME)
	ORDER BY 2;
	
--1) DNAME & JOB의 GROUP BY
SELECT DNAME, JOB, COUNT(*), SUM(SAL)
	FROM EMP e JOIN DEPT d 
	USING(DEPTNO)
	GROUP BY DNAME, JOB
	ORDER BY 1;
UNION ALL	
SELECT DNAME, NULL, COUNT(*), SUM(SAL)
	FROM EMP e JOIN DEPT d 
	USING(DEPTNO)
	GROUP BY DNAME
UNION ALL
SELECT NULL, NULL, COUNT(*), SUM(SAL)
	FROM EMP e JOIN DEPT d 
	USING(DEPTNO)
	ORDER BY 1,2;
	

-- GROUPING
SELECT CASE GROUPING (DNAME) WHEN 1 THEN 'ALL DEPARTMENTS' ELSE DNAME END,
	   CASE GROUPING (JOB) WHEN 1 THEN 'ALL JOBS' ELSE JOB END,
		COUNT(*), SUM(SAL) 
	FROM EMP e JOIN DEPT d 
	ON e.DEPTNO = d.DEPTNO 
	GROUP BY ROLLUP(DNAME, JOB); --순서가 매우 중요하다
	
-- 진짜 어려운 문제
-- ** ()괄호를 하면 묶음으로 처리하게된다. GROUP BY (A,(B,C))

SELECT DNAME, JOB, MGR, COUNT(*) 
	FROM EMP e ,DEPT d 
	WHERE e.DEPTNO = d.DEPTNO 
	GROUP BY DNAME, ROLLUP((JOB, MGR))
	ORDER BY 2, 3;

--CUBE는 다차원 통계를 발생 시켜 준다.
SELECT DNAME, JOB, COUNT(*), SUM(SAL)
	FROM EMP e JOIN DEPT d 
	USING(DEPTNO)
	GROUP BY ROLLUP(DNAME, JOB)
	ORDER BY 1,2;
	
SELECT DNAME, JOB, COUNT(*), SUM(SAL)
    FROM EMP e JOIN DEPT d
    USING(DEPTNO)
    GROUP BY DNAME, JOB
UNION ALL
    SELECT DNAME, NULL, COUNT(*), SUM(SAL)
    FROM EMP e JOIN DEPT d 
    USING(DEPTNO)
    GROUP BY DNAME
UNION ALL
    SELECT NULL, JOB, COUNT(*), SUM(SAL)
    FROM EMP e JOIN DEPT d 
    USING(DEPTNO)
    GROUP BY JOB
UNION ALL
    SELECT NULL, NULL, COUNT(*), SUM(SAL)
    FROM EMP e JOIN DEPT d 
    USING(DEPTNO)
    ORDER BY 1,2;
    
CREATE VIEW EMPNDEPT AS SELECT *
						FROM EMP e JOIN DEPT D 
						USING(DEPTNO);
						
SELECT DNAME, JOB, COUNT(*), SUM(SAL)
	FROM EMPNDEPT e
	GROUP BY DNAME, JOB
UNION ALL	
SELECT DNAME, 'ALL JOBS' , COUNT(*), SUM(SAL)
	FROM EMPNDEPT e
	GROUP BY DNAME
UNION ALL	
SELECT 'ALL DNAMES', JOB, COUNT(*), SUM(SAL)
	FROM EMPNDEPT e
	GROUP BY JOB
UNION ALL	
SELECT 'ALL DNAME', 'ALL JOB', COUNT(*), SUM(SAL) 
	FROM EMPNDEPT e
	ORDER BY 1, 2 DESC, 3, 4;

--GROUPING SETS
SELECT DNAME, JOB, COUNT(*), SUM(SAL) 
	FROM EMPNDEPT e
	GROUP BY DNAME, GROUPING SETS(JOB)
	ORDER BY 1;
	
SELECT DNAME, COUNT(*), SUM(SAL) 
	FROM EMPNDEPT e
	GROUP BY DNAME;

SELECT DNAME ,JOB, COUNT(*), SUM(SAL) 
	FROM EMPNDEPT e
	GROUP BY GROUPING SETS(JOB, DNAME);

SELECT DNAME,NULL, COUNT(*), SUM(SAL)
	FROM EMPNDEPT e
	GROUP BY DNAME
UNION ALL
SELECT NULL, JOB, COUNT(*), SUM(SAL)
	FROM EMPNDEPT e
	GROUP BY JOB;
	
-- 9일차문제
SELECT DEPTNO , JOB, SUM(SAL) SUM_SAL 
	FROM EMP e 
	WHERE DEPTNO IS NOT NULL
	GROUP BY ROLLUP(DEPTNO,JOB)
	ORDER BY 1,3;
--2
 
 SELECT DECODE(GROUPING(DEPTNO),1,' ',DEPTNO) DEPTNO ,
 		DECODE(GROUPING(JOB),1,' ',JOB) JOB ,
	 	SUM(SAL) SUM_SAL
	FROM EMP e 
	WHERE DEPTNO IS NOT NULL
	GROUP BY CUBE(DEPTNO, JOB);

--3.	부서명(DNAME), 직업(JOB) 별로 급여 소계, 합계를 
--			명시하여 아래 예제처럼 출력하세요?
--ex) 부서 없는 사원은 제외 (ROLLUP 구문 사용)
SELECT DECODE(GROUPING(DNAME),1,'합계',DNAME) DNAME,
	DECODE(GROUPING(JOB),1,'소계',JOB) JOB ,
	SUM(SAL) SUM_SAL
	FROM EMP e JOIN DEPT d 
	USING(DEPTNO)
	GROUP BY ROLLUP(DNAME, JOB)
	ORDER BY 1, 2, 3;

SELECT CASE GROUPING (DNAME) WHEN 1 THEN '합계' ELSE DNAME END DNAME,
	   CASE GROUPING (JOB) WHEN 1 THEN
	   		CASE GROUPING(DNAME) 
	   		WHEN 0 THEN'소계'
	   		WHEN 1 THEN ' '
	   		END
	   	ELSE JOB END JOB,
	   SUM(SAL) SUM_SAL
	FROM EMP e JOIN DEPT d 
	ON e.DEPTNO = d.DEPTNO 
	WHERE e.DEPTNO IS NOT NULL
	GROUP BY ROLLUP (DNAME,JOB)
	ORDER BY 1, 2;

--4.	부서명(DNAME), 직업(JOB) 별로 급여 소계,
--합계를 명시하고 부서명은 상위 하나만 보여주고 급여는 금액(천단위 ,) 
--단위로 아래 예제처럼 출력하세요?
--ex) 부서 없는 사원은 제외 (ROLLUP 구문 사용)
-- WINDOWS FUNCTION : SELECT 절에 사용가능한 집계 함수
SELECT SAL, ROWNUM
	FROM EMP
	ORDER BY SAL DESC;
	
SELECT SAL, ROWNUM
FROM (
SELECT *
	FROM EMP e 
	ORDER BY SAL DESC);

SELECT SAL, ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUM
	FROM EMP;

SELECT  DECODE(GROUPING(DNAME),1,'합계',DECODE(ROW_NUMBER() OVER(PARTITION BY DNAME ORDER BY DNAME),1, DNAME,' ')) DNAME,
		DECODE(GROUPING(JOB),1,DECODE(GROUPING(DNAME),1,' ','소계'), JOB) JOB,
		SUM(SAL)
	FROM DEPT d JOIN EMP e 
	USING(DEPTNO)
	GROUP BY ROLLUP(DNAME, JOB);

--5.	부서명(DNAME), 직업(JOB) 별로 급여 소계, 합계를 명시하고 
--부서명은 상위 하나만 보여주고 급여는 금액(천단위 ,) 단위로 아래 예제처럼
--출력하고 단 부서명, 직업별로 급여가 1000 이상인 데이터만 출력하세요?
--ex) 부서 없는 사원은 제외 (ROLLUP 구문 사용)
