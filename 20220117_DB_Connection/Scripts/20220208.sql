-- 집계함수
-- 집계(함침)가 되면 
--여러개의 row를 그룹하여 하나의 결과를 

SELECT DISTINCT (TEAM_ID), PLAYER_ID
FROM PLAYER p ;

--COUNT(컬럼), COUNT(*), MIN, MAX, SUM, AVG
--집계 함수는 NULL의 대상을 선정하지 않는다
--축구 선수는 481명

--COUNT 는 *(WILD CARD)를 사용하면 ROW를 확인
--COUNT는 컬럼이 들어가면 NULL이 아닌 갯수를 확인
SELECT COUNT(*) ,COUNT(E_PLAYER_NAME)
FROM PLAYER p ;

--현재 입력한 글 중 에서 가장 최신의 글을 보고 싶다
--REGDATE가 가장 최근이거나 SEQ가 가장 숫자가 높은것

SELECT MAX(SEQ), NAME --집계 함수가 되었다면 단일 값을 사용할 수 없음
FROM INFO i ;

SELECT *
FROM INFO i 
WHERE SEQ =MAX(SEQ);

--MAIN쿼리에 속해 있는  SUB쿼리를 만들어서 먼저 동작시킨 후 결과를 MAIN쿼리에서 확인 할 수 있도록 한다.
SELECT *
FROM INFO i 
WHERE SEQ = (SELECT MAX(SEQ)
FROM INFO);

-- 집계함수 확인
SELECT COUNT(*) "선수들의 총 명",
		COUNT(HEIGHT) "키 값을 가지고 있는 선수",
		MAX(HEIGHT) "선수들 중 최대 키",
		MIN(HEIGHT) "선수들 중 최소 키",
		ROUND(AVG(HEIGHT),2) "선수들의 평균 키"
FROM PLAYER p ;

--실행순서 269PAGE

--집계함수는 GROUP BY에서는 사용이 가능 단일 값은 사용이 안됨
-- 문제> K리그 선수들의 포지션별 평균 키 -> 다른정보를 출력 할 수가 없음 >> WINDOW FUNCTION으로 는 가능
SELECT "POSITION", AVG(HEIGHT) -- SELECT 절의 표현되는 값은 GROUP BY 사용된 컬럼 이거나 집계함수만 가능
	FROM PLAYER p 
	WHERE "POSITION" IS NOT NULL --값은 FROM 절의 ROW를 정제한 후 사용하는게 좋다
	GROUP BY "POSITION";

SELECT "POSITION", AVG(HEIGHT) 
	FROM PLAYER p  
	GROUP BY "POSITION"
	HAVING "POSITION" IS NOT NULL; -- GROUP BY 된 값을 조건처리 하기 위해서는 HAVING절을 사용한다.
	
SELECT "POSITION", AVG(HEIGHT) 
	FROM PLAYER p  
		HAVING "POSITION" IS NOT NULL; -- HAVING절은 GROUP BY뒤에 반드시 위치할 필요는 없다
	GROUP BY "POSITION"


SELECT "POSITION", AVG(HEIGHT)
	FROM PLAYER p 
	HAVING "POSITION" IS NOT NULL; --HAVING절은 반드시 GROUP BY가 SQL문장에 포험되어 있어야 한다.

--팀별 최대키, 최소키, 평균키
SELECT TEAM_ID ,MAX(HEIGHT) "최대 키", MIN(HEIGHT) "최소 키", AVG(HEIGHT) "평균 키"  
	FROM PLAYER p 
	GROUP BY TEAM_ID ;

-- MYSQL에서는 GROUP BY에 컬럼의 순서대로 INDEX값을 넣어도 됨
SELECT TEAM_ID ,MAX(HEIGHT) "최대 키", MIN(HEIGHT) "최소 키", AVG(HEIGHT) "평균 키"  
	FROM PLAYER p 
	GROUP BY 1;

-- HAVING 절은 GROUP BY 와 반드시 같이 사용되어야 함
-- 즉, 집계가 되어진 상태 그렇기 때문에 WHERE절에는 집계함수를 사용할 수 없었지만
-- HAVING 절에는 집계함수를 사용할 수 있다.
-- FROM > GROUP BY > HAVING 

--평균키가 170이상 팀을 출력
SELECT TEAM_ID , ROUND(AVG(HEIGHT)) 평균키
FROM PLAYER p 
-- WHERE HEIGHT > 180 --선수들의 키중에서 180초과인 선수들의 대상을
GROUP BY TEAM_ID
HAVING AVG(HEIGHT) > 180;

--문제> K리그 선수들 중에서 K02, K07의 인원수는 얼마인가
-- 대상이 되는 ROW를 줄여서 처리하면 속도가 빨라짐
SELECT TEAM_ID , COUNT(*) 인원수 
FROM PLAYER p
WHERE TEAM_ID IN('K02','K07')
GROUP BY TEAM_ID 

-- CASE문과 집계함수 GROUP BY를 사용한 통계 정보 구하기
-- 문제> 부서별로 월별 입사자의 평균 급여를 알고 싶다.
-- 가로 세로 변경하기 문제

SELECT 10 "NEW YORK", 20 "DALLAS", 30 "CHICAGO", 40 "BOSTON"
FROM DUAL;

SELECT 
	SUM (CASE LOC WHEN 'NEW YORK' THEN 10 END) "NEW YORK",
	SUM(CASE LOC WHEN 'DALLAS' THEN 20 ELSE 0 END) "DALLAS",
	SUM(CASE LOC WHEN 'CHICAGO' THEN 30 ELSE 0 END) "CHICAGO",
	SUM(CASE LOC WHEN 'BOSTON' THEN 40 ELSE 0 END) "BOSTON"
FROM DEPT d ;

SELECT HIREDATE, DEPTNO, SAL
FROM EMP;

--월별 HIREDATE 에서 월
-- TO_CHAR 형변환: 문자 EX)01, EXTRACT: 숫자 EX)1
SELECT TO_CHAR(HIREDATE, 'MM') 월  , DEPTNO , SAL 
	FROM EMP;

SELECT EXTRACT(MONTH FROM HIREDATE)
	FROM EMP;
SELECT EXTRACT(YEAR FROM HIREDATE)
	FROM EMP;
SELECT EXTRACT(DAY FROM HIREDATE)
	FROM EMP;


SELECT DEPTNO,
	AVG(CASE TO_CHAR(HIREDATE, 'MM') WHEN '01' THEN SAL END) AS "1월",
	AVG(CASE TO_CHAR(HIREDATE, 'MM') WHEN '02' THEN SAL END) AS "2월",
	AVG(CASE TO_CHAR(HIREDATE, 'MM') WHEN '03' THEN SAL END) AS "3월",
	AVG(CASE TO_CHAR(HIREDATE, 'MM') WHEN '04' THEN SAL END) AS "4월",
	AVG(CASE TO_CHAR(HIREDATE, 'MM') WHEN '05' THEN SAL END) AS "5월",
	AVG(CASE TO_CHAR(HIREDATE, 'MM') WHEN '06' THEN SAL END) AS "6월",
	AVG(CASE EXTRACT(MONTH FROM HIREDATE) WHEN 7 THEN SAL END) AS "7월",
	AVG(CASE EXTRACT(MONTH FROM HIREDATE) WHEN 8 THEN SAL END) AS "8월",
	AVG(CASE EXTRACT(MONTH FROM HIREDATE) WHEN 9 THEN SAL END) AS "9월",
	AVG(CASE EXTRACT(MONTH FROM HIREDATE) WHEN 10 THEN SAL END) AS "10월",
	AVG(CASE EXTRACT(MONTH FROM HIREDATE) WHEN 11 THEN SAL END) AS "11월",
	AVG(CASE EXTRACT(MONTH FROM HIREDATE) WHEN 12 THEN SAL END) AS "12월"
	FROM EMP
	GROUP BY DEPTNO
	ORDER BY 1;

--INLINE VIEW : FROM 절에 가상을 정제된 테이블을 만들어 놓는것 > SUB QUERY중에 하나 >  VIEW테이블로 작성
SELECT DEPTNO ,
    AVG(CASE MM WHEN '01'THEN SAL END) AS "1월",
    AVG(CASE MM WHEN '02'THEN SAL END) AS"2월",
    AVG(CASE MM WHEN '03'THEN SAL END) AS"3월",
    AVG(CASE MM WHEN '04'THEN SAL END) AS"4월",
    AVG(CASE MM WHEN '05'THEN SAL END) AS"5월",
    AVG(CASE MM WHEN '06'THEN SAL END) AS"6월",
    AVG(CASE MM WHEN '07'THEN SAL END) AS"7월",
    AVG(CASE MM WHEN '08'THEN SAL END) AS"8월",
    AVG(CASE MM WHEN '09'THEN SAL END) AS"9월",
    AVG(CASE MM WHEN '10'THEN SAL END) AS"10월",
    AVG(CASE MM WHEN '11'THEN SAL END) AS"11월",
    AVG(CASE MM WHEN '12'THEN SAL END) AS"12월"
    FROM (
    SELECT DEPTNO , TO_CHAR(HIREDATE, 'MM') MM , SAL FROM EMP) 
    EMP_TEMP
    GROUP BY DEPTNO;


-- INLINE VIEW 를 VIEW가상의 테이블로 생성
   CREATE OR REPLACE VIEW EMP_VIEW AS SELECT DEPTNO, TO_CHAR(HIREDATE, 'MM')MM, SAL
   FROM EMP;
   
  SELECT *
  FROM EMP_VIEW ;
 
 SELECT DEPTNO ,
    AVG(CASE MM WHEN '01'THEN SAL END) AS "1월",
    AVG(CASE MM WHEN '02'THEN SAL END) AS"2월",
    AVG(CASE MM WHEN '03'THEN SAL END) AS"3월",
    AVG(CASE MM WHEN '04'THEN SAL END) AS"4월",
    AVG(CASE MM WHEN '05'THEN SAL END) AS"5월",
    AVG(CASE MM WHEN '06'THEN SAL END) AS"6월",
    AVG(CASE MM WHEN '07'THEN SAL END) AS"7월",
    AVG(CASE MM WHEN '08'THEN SAL END) AS"8월",
    AVG(CASE MM WHEN '09'THEN SAL END) AS"9월",
    AVG(CASE MM WHEN '10'THEN SAL END) AS"10월",
    AVG(CASE MM WHEN '11'THEN SAL END) AS"11월",
    AVG(CASE MM WHEN '12'THEN SAL END) AS"12월"
    FROM EMP_VIEW 
    GROUP BY DEPTNO;
   
--K 리그 선수들의 정보를 출력
-- 팀별 포지션별 인원을 출력해 주세요
-- 각 팀별 전체 인원 출력
   SELECT TEAM_ID ,
		COUNT(PLAYER_NAME) AS "전체인원", 
		COUNT(CASE "POSITION" WHEN 'DF' THEN "POSITION"  END) DF,
		COUNT(CASE "POSITION" WHEN 'MF' THEN "POSITION" END) MF,
		COUNT(CASE "POSITION" WHEN 'FW' THEN "POSITION" END) FW,
		COUNT(CASE "POSITION" WHEN 'GK' THEN "POSITION" END) GK
		FROM PLAYER p  
		GROUP BY TEAM_ID ;

SELECT COUNT("POSITION"),COUNT(*), TEAM_ID --집계함수는 NULL을 제외하고 계산한다.
FROM PLAYER p 
GROUP BY TEAM_ID ;

SELECT TEAM_ID ,
		COUNT(DECODE("POSITION",'DF',POSITION)) AS DF,
		COUNT(DECODE("POSITION",'MF',POSITION)) AS MF,
		COUNT(DECODE("POSITION",'FW',POSITION)) AS FW,
		COUNT(DECODE("POSITION",'GK',POSITION)) AS GK,
		COUNT(DECODE("POSITION",NULL,POSITION)) AS "NULL", --SIMPLE CASE문은 NULL을 =으로 비교 
		COUNT(*)
	FROM PLAYER p 
   GROUP BY TEAM_ID 
   ORDER BY 1;
  
 SELECT TEAM_ID ,
 	SUM(CASE WHEN "POSITION" = 'DF' THEN 1 END) DF,
 	SUM(CASE WHEN "POSITION" = 'FW' THEN 1 END) FW,
 	SUM(CASE WHEN "POSITION" = 'GK' THEN 1 END) GK,
 	SUM(CASE WHEN "POSITION" = 'MF' THEN 1 END) MF,
 	SUM(CASE WHEN "POSITION" IS NULL THEN 1 END) A,
 	COUNT(*)
 	FROM PLAYER p 
 	GROUP BY TEAM_ID;
 
 -- ORDER BY 정렬
 -- 쿼리의 가장 마지막에 실행 SELECT절을 단순히 정렬
 -- INDEX, ALIAS, 컬럼명, 함수가능
 
 SELECT EMPNO, ENAME 이름, SAL 급여, COMM + SAL 급여보너스합계 
 FROM EMP 
 ORDER BY 1 DESC, 급여, ENAME DESC, COMM+SAL; --컬럼명
   
-- ROWNUM 부터 시작
-- RDBMS가 테이블의 row를 읽어 내면서 순번을 표기해 줌
-- 1부터 시작 하지만 1이 없으면 당연히 2는 없음
 
 -- 사원들 중 급여가 높은 순번을 표기 해보자
 SELECT e.*, ROWNUM
 	FROM EMP e;
 
 SELECT ROWNUM, e2.EMPNO, e2.SAL
 FROM ( 
 		SELECT ROWNUM, e.*
 			FROM EMP e
 				ORDER BY SAL DESC) e2;
 			
 --FROM의 출력되는 순서대로
 SELECT ROWNUM, e.*
 	FROM EMP e
 		WHERE ROWNUM < 10;
 	
 SELECT ROWNUM, e.*
 	FROM EMP e
 		WHERE ROWNUM < 2;
 	
 
 	
 
 
 
 
 