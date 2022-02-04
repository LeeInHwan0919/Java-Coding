    
SELECT * FROM DEPT;
-- 20220204 241p
-- CASE 표현식
-- if문, switch case 문을 만들어 낼 수 있음
-- ~~ 별 case 문 혹은 Group by 로 해결, 년도별 + 팀별 group by + case 문

-- 범위 : searched case 문
-- 값 : simple case 문 => oracle에서만 사용하는 DECODE 문법과 같음

-- CASE WHEN THEN ELSE END : ELSE 의 값 or CASE WHEN THEN END : ELSE 가 없기 때문에 NULL 

-- 문제 > 부서정보에서 부서 위치를 미국의 동부, 중부, 서부로 구분하라
--                뉴욕, 보스턴 "EAST" / 시카고, 달라스 "CENTER"  / 그 외의 지역은 "WEST"
-- 1:1의 비교이기 때문에 SIMPLE CASE 문을 사용
-- 만약 CASE 컬럼 WHEN 값 => SIMPLE
--		CASE WHEN 컬럼 > 값 THEN => SEARCHED

--같은 타입이라면 반환은 불가능 하다
--ELSE문이 없다면 결과는 NULL이 나온다
SELECT LOC, CASE LOC 
					WHEN 'NEW YORK' THEN 'EAST'
					WHEN 'BOSTON' THEN 'EAST'
					END AS GUBUN
    FROM DEPT;
--문제> 사원정보 급여가 3000이상이라면 HIGH, 1000이상이라면 MID, 1000미만이라면 LOW로 분류하라
-- SEARCHED 문법 : CASE WGHEN 컬럼>10 THEN ELSE END
SELECT ENAME ,SAL, CASE 
						WHEN SAL>=3000 THEN 'HIGH'
						WHEN SAL>=1000 THEN 'MID'
						ELSE 'LOW'
						END
	FROM EMP;
-- SEARCH 문법 중첩 CASE문을 사용 할 수 있다.
-- 문제> 사원 정보에서 급여가 2000 이상이라면 보너스를 1000으로 , 1000이상이라면 500으로 , 1000미만 이라면 0으로 
SELECT ENAME, SAL, CASE
						WHEN SAL >= 2000 THEN 'HIGH'
						ELSE 
							CASE WHEN SAL >= 1000 THEN 'MID' ELSE 'LOW' END
							END AS 등급
					,CASE
						WHEN SAL >= 2000 THEN 1000
						ELSE 
							CASE WHEN SAL >= 1000 THEN 500 ELSE 0 END
							END AS 보너스
FROM EMP;
						
-- Null 함수
-- 245 page NVL
-- NULL은 미지의 값이다. 연산을 하면 NULL로 나온다, 비교연산은 FALSE로 반환한다.
-- NULL과 아무런 값이 없음 공집합 하고는 전혀 다르다 => selectOne()

-- NVL : NULL로 되어 있는 컬럼을 치환하여 값으로 만듬 => 컬럼의 타입과 같아야 함 NULL -> 값
-- NULLIF : 두개의 컬럼의 값이 같으면 NULL로 나타 내겠다   A와 B같다 -> NULL
-- COALESCE : NULL이 아닌 값이 나올때 까지 검색  NULL인지 판단 B...C....:NULL 'A' 'B > A

-- NULL이 있는 컬럼의 값은 연산에서 NULL이 되기 때문에 대상으로 포함하지 않음.
--문제> 모든사원의 보너스(COMM)의 평균(AVG)을 알고 싶다.
SELECT AVG(COMM) -->550 입니다
	FROM EMP;

SELECT AVG(NVL(COMM,0))-->157
	FROM EMP;

SELECT COMM
	FROM EMP
	WHERE COMM IS NOT NULL;

SELECT COMM, NVL(COMM,0)
	FROM EMP;

--NULL과 공집합의 차이점
SELECT COMM, NVL(COMM,-99)    --진짜 검색된 결과의 값이 NULL 임
	FROM EMP
	WHERE EMPNO='7369'; --7499

SELECT NVL(COMM,0)
	FROM EMP
		WHERE EMPNO='1111';  --1111을 가진 사원번호는 없음
		
		
--문제> 선수테이블에서 성남 일화천마 소속 선수들의 이름과 포지션을 출력
-- 하는데, 포지션이 없을 경우에는 없음 을 출력해달래요 해해해
-- NVL > CASE문으로 변경 NULL 은 과연 SEARCHED일까 아니면 SIMPLE일까 
SELECT PLAYER_NAME , NVL("POSITION",'없음')
	FROM PLAYER p
	WHERE TEAM_ID = 'K08';

SELECT PLAYER_NAME , CASE 
					WHEN "POSITION" IS NULL THEN '없음' 
					ELSE "POSITION" 
					END AS POSITION
	FROM PLAYER
	WHERE TEAM_ID = 'K08';

--문제> 연봉은 급여와 보너스를 합한 금액을 이야기한다. 각사원 정보를 출력하고 연봉을 출력 해주세요.
SELECT MGR + NVL(COMM,'0') AS 연봉 --컬럼의 타입은 자동으로 변하기 때문에 '(single quote)로 되어 있다고 무조건 문자가 아니다.
	FROM EMP;


-- NULLIF 값이 같으면 NULL로
-- 문제> DEPT 정보중 DNAME이 SALES라면 NULL로 변환하여 출력해 주세요
SELECT DEPTNO, DNAME, NULLIF(DNAME, 'SALES') AS "세일을 널로 바꾸어 주어라"
	FROM DEPT d;

-- NULLIF를 사용할 때 주의 해야 할점 -> NULLIF는 자동 형변환이 되지 않기 때문에 반드시 타입에 맞춰서 사용해야 함
SELECT DEPTNO, NULLIF(DEPTNO, 10), NULLIF()
	FROM DEPT d;
SELECT NULLIF(SAL,800)
	FROM EMP d;
		
-- DEPTNO PK 값이 무조건 있어야 하는거 아닌가요? -> DB에 입력되어 있는 값
-- .검색 SELECT는 전혀 상관 없습니다 >> 출력값을 변형 해도 된다.
SELECT NULLIF(DEPTNO,800)
	FROM DEPT d;

-- SIMPLE CASE문으로 작성 가능
SELECT DEPTNO, CASE 
					WHEN DEPTNO=10 THEN NULL 
					ELSE DEPTNO END AS 힝
	FROM DEPT;

-- COALESCE : NULL이 아닌값이 나올때 까지 진행
SELECT e.* ,COALESCE (COMM, MGR, SAL) AS HI --COMM이 NULL이라면 MGR을 출력 / MGR도 NULL이라면 SAL을 출력
	FROM EMP e;

-- group by, having



-- 부서별로 월별 입사자의 평균 급여 출력 : 가로를 세로로 바꾸는 작업
--      1월 2월 3월
--   인사
--   개발

--  ID 202202 1000($) 인사
--  ID 202201 2000($) 개발
--  ID 202204 3000($) 안사