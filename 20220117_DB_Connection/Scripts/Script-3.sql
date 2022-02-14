SELECT JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY
FROM BD.JOBS;

SELECT JOB,SUM(SAL)
	FROM EMP
		WHERE JOB NOT IN (SELECT JOB
						FROM EMP
						WHERE SAL<1000
						)
		GROUP BY JOB;
	
	SELECT JOB, SUM(SAL)
    FROM (
            SELECT JOB, COUNT(*) CNT, SUM(SAL) SUM
                FROM EMP e 
                WHERE SAL > 1000
                GROUP BY JOB
            )JOIN(
            SELECT JOB, COUNT(*) CNT2 
                FROM EMP e 
                GROUP BY JOB)
    USING(JOB)
    WHERE CNT = CNT2 ;

--1.	사원 테이블에서 부서위치가 BOSTON과 CHICAGO가 아닌 
--사원의 정보를 아래 예제와 같이 출력하세요?
--(부서번호가 null인 사원포함, not exists 사용)
-- NOT EXISTS를 사용하면 차집합을 구할 수 있다.
-- JOIN을 수행하는데 EMP에 부서번호가 NULL인 값을 INNER JOIN을
--   값을 나타내지 못함
   -- OUTER JOIN 을 사용하여 처리 해야 한다.
SELECT EMPNO, ENAME , DNAME, LOC
	FROM EMP e LEFT JOIN DEPT d 
	ON e.DEPTNO = d.DEPTNO 
	WHERE NOT EXISTS (
					SELECT 'x'
						FROM DEPT d2 
						WHERE d.DEPTNO = d2.DEPTNO 
						AND LOC IN('BOSTON', 'CHICAGO')
					)
	ORDER BY LOC DESC, ENAME DESC;
   
SELECT EMPNO ENAME, DNAME, LOC
	FROM EMP e JOIN DEPT d 
	ON e.DEPTNO = d.DEPTNO(+)
	WHERE NOT EXISTS (SELECT 'ASDAFSAD'
						FROM DEPT d 
						WHERE e.DEPTNO = d.DEPTNO 
						AND LOC IN('BOSTIN', 'CHICAGO'));
	
	
--2.	모든 사원의 최상위 관리자를 아래 예제와 같이 출력하세요?
--ex)
SELECT LEVEL "DEPTH", CONNECT_BY_ROOT EMPNO ROOT , MGR, EMPNO, ENAME, SYS_CONNECT_BY_PATH(ENAME, '>') RELATION 
	FROM EMP
	START WITH MGR IS NULL
	CONNECT BY PRIOR EMPNO = MGR;


--3.	사원 테이블에 사원번호를 내림차순으로 하는 인덱스를 만들고,
-- 만들어진 인덱스를 사용하여 아래 예제처럼 사원정보를 출력하세요?
-- INDEX는 컬럼을 검색을 할 때 FTS(Full Table Scan)
-- EMP 테이블은 EMPNO가 PK(NN, UNIQUE, INDEX)로 작성되면서 INDEX가 자동으로 생성
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE , SAL, COMM, DEPTNO 
	FROM EMP
	WHERE EMPNO = '7934';

CREATE INDEX EMP_IDX ON EMP(EMPNO DESC);
SELECT /* +INDEX (EMP PK_EMP) */EMPNO, ENAME, JOB, HIREDATE, SAL, COMM
FROM EMP
WHERE EMPNO = '7934';


-- 13 일 3번 가장 상위 관리ㅣ자부터 하위사원까지 관계를 상위 10개 레코드만 출렭ㄱ
SELECT *
FROM (
SELECT LPAD(' ', 4*(LEVEL-1)) || JOB JOB, EMPNO, ENAME, MGR
	FROM EMP
	START WITH MGR IS NULL
	CONNECT BY PRIOR EMPNO = MGR 
	ORDER SIBLINGS BY EMPNO DESC
)
WHERE ROWNUM <= 10;

--4. EMP_TEST테이블에서 부서번호(DEPTNO) 20,30의 사원이 존재하면
-- 급여를 10% 인상하고, 존재하지 않으면 
--급여가 1000보다 큰 사원정보를 등록하세요. (Merge사용)
--ex) CREATE TABLE EMP_TEST 
--AS SELECT EMPNO, DEPTNO, SAL FROM EMP WHERE DEPTNO IN (10, 20);
--테이블 사용
CREATE TABLE EMP_TEST 
AS SELECT EMPNO, DEPTNO, SAL 
FROM EMP 
WHERE DEPTNO IN (10, 20);

SELECT * FROM EMP_TEST et;

--MERGE 사용해서 UPDATE와 INSERT를 진행
--EMP_TEST와 EMP테이블 을 EMPNO로 조인
--이때, DEPTNO(부서번호)가 20, 30이라면 급여를 10%인상
--아니라면, EMP테이블의 DEPTNO가 30이고 급여가 1000을 초과하는
--ROW를 EMP_TEST테이블에 INSERT

MERGE
	INTO EMP_TEST e
	USING EMP e2
	ON(e.EMPNO = e2.EMPNO 
	AND (e.DEPTNO='20' OR e2.DEPTNO='30'))
	WHEN MATCHED THEN --맞다면
		UPDATE SET e.SAL = e.SAL * 1.1
	WHEN NOT MATCHED THEN -- 안맞다면
		INSERT (e.EMPNO, e.DEPTNO, e.SAL)
		VALUES (e2.EMPNO, e2.DEPTNO ,e2.SAL)
		WHERE e2.DEPTNO=30 AND e2.SAL >1000;
	
DROP TABLE EMP_TEST ;
	
DELETE FROM EMP_TEST et WHERE EMPNO=7777;
		
SELECT * FROM EMP_TEST;

--5.EMP_TEST 테이블에서 부서번호(DEPTNO) 10의 사원 급여를 10% 인상하고
--, 부서번호(DEPTNO) 20의 사원정보는 삭제하며, 
--부서번호(DEPTNO) 30의 사원 급여를 20% 인상하세요.(Merge사용)?
--Ex)문제 4번에서 했던 정보는 DELETE를 한다
DELETE FROM EMP_TEST WHERE DEPTNO = 30;

-- MERGE를 해서 UPDATE와 INSERT를 함께 사용
-- EMRGE안에서 DELETE문은 단독으로 사용될 수 없음
-- 10이거나 20인 사원에 대해서는 모두 SAL 10% 인상한 뒤 >
-- DELECT문을 사용해서 20인 경우에만 삭제
-- 부서번호가 NULL /  30인 사원인 경우 급여를 20% 인상 한 뒤 INSERT

MERGE 
	INTO EMP_TEST e
	USING EMP e2
	ON(e.EMPNO = e2.EMPNO
	AND (e.DEPTNO='10' OR e.DEPTNO='20'))
	WHEN MATCHED THEN --맞다면
		UPDATE SET e.SAL = e.SAL * 1.1
		DELETE WHERE e.DEPTNO=20
	WHEN NOT MATCHED THEN -- 안맞다면
		INSERT (e.EMPNO, e.DEPTNO, e.SAL)
		VALUES (e2.EMPNO, e2.DEPTNO ,e2.SAL*1.2);

	SELECT *
		FROM EMP_TEST;
		