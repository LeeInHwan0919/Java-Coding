--20220215
-- Window Function
-- rows unbounds preceding > windowing ��

-- window finction�� ����
-- function��() over([partition by] [order by] [windowing ��])
--partition by select������ �÷��� �������� ���� > �׷����
-- �������� select������ ������ ������ ����
-- ������ �� ���ꤧ���� ������ ��, ������ ������ �� ����
-- windowing��
-- ����(between), ���� ����.
-- rows|range BETWEEN UNBOUNDED PRECEDING : ���� ���õ� ROW�� �������� ����
--					  CURRENT : ���� ���õ� ROW 
--					  FOLLOWING : ���� ���õ� ROW�� �ٷ������� ROW 
--					EX) 1 PRECEDING : ���� ���õ� ROW�� �������� 1�� ����
--					  

-- ���� �Լ�
-- RANK : ���� ���̶�� ���� ���ڷ� ǥ�� �ϰ� �� ���� ���� +n�� ���ؼ� ������ ��Ÿ�� 1134
-- DENSE_RANK : ���� ���̶�� ���� �����ڷ� ǥ��, �״��� ���� +1, 11234
-- ROW_NUMBER : order by�� ���Ŀ� ���� ���ڸ� �ο���

--�޿��� ���� ������ ǥ�� �غ���
SELECT SAL
	FROM EMP
	ORDER BY SAL DESC;

SELECT SAL, RANK() OVER(ORDER BY SAL DESC) RANK,
			DENSE_RANK () OVER(ORDER BY SAL DESC) RANK2,
			ROW_NUMBER () OVER(ORDER BY SAL DESC) ROW_NUMBER
	FROM EMP e ;
	
-- �μ� ���� ������ �˰� �ʹ�.
SELECT DEPTNO, SAL, RANK() OVER(PARTITION BY DEPTNO ORDER BY SAL DESC) RANK,
			DENSE_RANK () OVER(ORDER BY SAL DESC) RANK2,
			ROW_NUMBER () OVER(ORDER BY SAL DESC) ROW_NUMBER
	FROM EMP e 
	ORDER BY DEPTNO ;
	
-- �����Լ�
-- SUM
-- ����� �޿����� ���� �Ŵ����� �ΰ� �ִ� ����� SAL�� ���� ���� �޶�!
SELECT EMPNO, e1.MGR, COALESCE(SUM_SAL, SAL)
FROM EMP e1 LEFT JOIN (
SELECT MGR, SUM(SAL) SUM_SAL
	FROM EMP 
	GROUP BY MGR) e2
		 ON e1.MGR = e2.MGR;

SELECT EMPNO, MGR, (SELECT SUM(SAL) FROM EMP e2 WHERE e1.MGR = e2.MGR) ����
	FROM EMP e1;

SELECT EMPNO, MGR, SUM(SAL) OVER(PARTITION BY MGR) ����
	FROM EMP e 
	ORDER BY MGR;

--MAX���� �Ŵ����� �ΰ� �ִ� ������� �޿��� �ִ� �޿��� �Է�
SELECT EMPNO, MGR, MAX(SAL) OVER(PARTITION BY MGR ORDER BY SAL DESC) �ִ�޿�
	FROM EMP;

--AVG BETWEEN �� ���ؼ� ���õǴ� ROWȤ�� RANGE�� ���� �� �� �ִ�.
-- ����� ���ϴµ� ���� �Ŵ���, �ڽ��� ROW�� �������� �յ� �Ѱ���
SELECT EMPNO , MGR, AVG(SAL) OVER() �ִ�޿� -- ��ü ���
    FROM EMP;

SELECT EMPNO , MGR, SAL ,AVG(SAL) OVER(PARTITION BY MGR) �ִ�޿� -- �� ���� MGR�� ���
    FROM EMP;

SELECT EMPNO , MGR, SAL ,AVG(SAL) OVER(ORDER BY SAL DESC RANGE UNBOUNDED PRECEDING) -- ���� ���̶�� ���� ����
    FROM EMP;

SELECT EMPNO , MGR, SAL ,AVG(SAL) OVER(ORDER BY SAL DESC ROWS UNBOUNDED PRECEDING) -- ROW���� ���
    FROM EMP;

SELECT EMPNO , MGR, SAL ,AVG(SAL) OVER(PARTITION BY MGR ORDER BY SAL DESC RANGE UNBOUNDED PRECEDING) ��� -- MGR �׷쿡 ������ ���� ���� ���
    FROM EMP



