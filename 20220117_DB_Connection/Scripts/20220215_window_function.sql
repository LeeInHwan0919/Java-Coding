--20220215
-- Window Function
-- rows unbounds preceding > windowing 절

-- window finction의 문법
-- function명() over([partition by] [order by] [windowing 절])
--partition by select절에서 컬럼을 묶음으로 만듬 > 그룹바이
-- 오더바이 select절에서 순서와 순위를 지정
-- 윈도윙 절 연산ㄷ괴는 범위를 행, 값으로 지정할 수 있음
-- windowing절
-- 범위(between), 범위 없다.
-- rows|range BETWEEN UNBOUNDED PRECEDING : 현재 선택된 ROW를 기준으로 이전
--					  CURRENT : 현재 선택된 ROW 
--					  FOLLOWING : 현재 선택된 ROW의 바로이전의 ROW 
--					EX) 1 PRECEDING : 현재 선택된 ROW를 기준으로 1개 이전
--					  

-- 순위 함수
-- RANK : 같은 값이라면 같은 숫자로 표기 하고 그 다음 값을 +n을 통해서 점수를 나타냄 1134
-- DENSE_RANK : 같은 값이라면 같은 숫ㅅ자로 표기, 그다음 값을 +1, 11234
-- ROW_NUMBER : order by에 정렬에 따라서 숫자를 부여함

--급여에 따른 순위를 표현 해보자
SELECT SAL
	FROM EMP
	ORDER BY SAL DESC;

SELECT SAL, RANK() OVER(ORDER BY SAL DESC) RANK,
			DENSE_RANK () OVER(ORDER BY SAL DESC) RANK2,
			ROW_NUMBER () OVER(ORDER BY SAL DESC) ROW_NUMBER
	FROM EMP e ;
	
-- 부서 내의 순위를 알고 싶다.
SELECT DEPTNO, SAL, RANK() OVER(PARTITION BY DEPTNO ORDER BY SAL DESC) RANK,
			DENSE_RANK () OVER(ORDER BY SAL DESC) RANK2,
			ROW_NUMBER () OVER(ORDER BY SAL DESC) ROW_NUMBER
	FROM EMP e 
	ORDER BY DEPTNO ;
	
-- 집계함수
-- SUM
-- 사원들 급여ㄱ와 같은 매니저를 두고 있는 사원들 SAL의 합을 구해 달라!
SELECT EMPNO, e1.MGR, COALESCE(SUM_SAL, SAL)
FROM EMP e1 LEFT JOIN (
SELECT MGR, SUM(SAL) SUM_SAL
	FROM EMP 
	GROUP BY MGR) e2
		 ON e1.MGR = e2.MGR;

SELECT EMPNO, MGR, (SELECT SUM(SAL) FROM EMP e2 WHERE e1.MGR = e2.MGR) 총합
	FROM EMP e1;

SELECT EMPNO, MGR, SUM(SAL) OVER(PARTITION BY MGR) 총합
	FROM EMP e 
	ORDER BY MGR;

--MAX같은 매니저를 두고 있는 사원들의 급여중 최대 급여를 입력
SELECT EMPNO, MGR, MAX(SAL) OVER(PARTITION BY MGR ORDER BY SAL DESC) 최대급여
	FROM EMP;

--AVG BETWEEN 을 통해서 선택되는 ROW혹은 RANGE를 제한 할 수 있다.
-- 평균을 구하는데 같은 매니저, 자신의 ROW를 기준으로 앞뒤 한개씩
SELECT EMPNO , MGR, AVG(SAL) OVER() 최대급여 -- 전체 평균
    FROM EMP;

SELECT EMPNO , MGR, SAL ,AVG(SAL) OVER(PARTITION BY MGR) 최대급여 -- 각 같은 MGR의 평균
    FROM EMP;

SELECT EMPNO , MGR, SAL ,AVG(SAL) OVER(ORDER BY SAL DESC RANGE UNBOUNDED PRECEDING) -- 같은 값이라면 같은 묶음
    FROM EMP;

SELECT EMPNO , MGR, SAL ,AVG(SAL) OVER(ORDER BY SAL DESC ROWS UNBOUNDED PRECEDING) -- ROW별로 계산
    FROM EMP;

SELECT EMPNO , MGR, SAL ,AVG(SAL) OVER(PARTITION BY MGR ORDER BY SAL DESC RANGE UNBOUNDED PRECEDING) 평균 -- MGR 그룹에 이전에 값을 누적 계산
    FROM EMP



