--20220126
-- 207page where절 조건절
-- FTS(full table scan) 
-- 옵티마이저 규칙 : RBO(Rule Base Optimizer) vs CBO(Cost Base Optimizer)
-- 실행규칙(excution plain)
-- WHERE 절에는 PK를 사용하세요 => INDEX로 되어 있기 때문에 속도가 빠름
-- equi ROWID/ non-equi 범위
-- INDEX가 여러개인 복합키는 PK A, PK B  A와 B가 순차적으로 INDEX로 생성. 따라서 검색 WHERE A='1' AND B = '2'

SELECT *
	FROM PLAYER p 
	WHERE E_PLAYER_NAME = '코난';
	
--1) K- 리그 일부 선수들의 이름과 포지션， 백넘버를 알고 싶다.
--2) 조건은 소속팀이 삼성블루왕즈(K02)이거나 전남드래곤즈(K07)에 소속된 선수들 중에서
--3) 포지션이 미드펼더 (MF :Mid Fielder) 이면서 ，
--4) 키는 170 센티미터 이 상， 180 이하여야 한다.

--테이블 : PLAYER 
--컬럼 : 이름(PLAYER_NAME), 포지션("POSITION"), 등번호(BACKNO)

SELECT PLAYER_NAME , "POSITION" , BACK_NO 
	FROM PLAYER p;
	
SELECT PLAYER_NAME , "POSITION" , BACK_NO 
	FROM PLAYER p;

-- LIKE SQL연산자 : %를 앞에 사용하지 마세요
-- 					만약에 사용한다면 단어의 길이로 판단
SELECT *
	FROM TEAM t 
--	WHERE TEAM_NAME LIKE '%블루윙즈';
--	WHERE TEAM_NAME LIKE '삼성%';
	WHERE TEAM_NAME LIKE '%드래곤즈'; 

SELECT PLAYER_NAME , "POSITION" , BACK_NO, TEAM_ID
	FROM PLAYER p 
		WHERE TEAM_ID  = 'K02' OR TEAM_ID = 'K07';

-- OR절이 여러개인 경우 SQL연산자인 IN절 사용
SELECT PLAYER_NAME , "POSITION" , BACK_NO, TEAM_ID
	FROM PLAYER p 
		WHERE TEAM_ID  IN ('K02', 'K07');

	
-- SQL연산자는 ()를 제외하고 가장 우선순위가 높다.
	--AND, OR는 AND가 먼저 실행
SELECT PLAYER_NAME , "POSITION" , BACK_NO, TEAM_ID
	FROM PLAYER p 
		WHERE (TEAM_ID  = 'K02' OR TEAM_ID = 'K07') AND "POSITION" = 'MF';
	
SELECT PLAYER_NAME , "POSITION" , BACK_NO, TEAM_ID
	FROM PLAYER p 
		WHERE TEAM_ID  IN ('K02', 'K07') AND "POSITION" = 'MF';
	

-- 문제 삼성은 FW공격수와 전남은 MF만 선수들의 정보를 출력
SELECT *
	FROM PLAYER p 
		WHERE (TEAM_ID = 'K02' AND "POSITION" ='FW') OR (TEAM_ID = 'K07' AND "POSITION" = 'MF');
	
SELECT PLAYER_NAME , "POSITION" , BACK_NO, TEAM_ID
	FROM PLAYER p 
		WHERE (TEAM_ID, "POSITION") IN (('K02', 'FW'),('K07','MF'));

SELECT PLAYER_NAME , "POSITION" , BACK_NO, TEAM_ID
	FROM PLAYER p 
	WHERE HEIGHT <= 170 OR HEIGHT >= 180;

SELECT PLAYER_NAME , "POSITION" , BACK_NO, TEAM_ID
	FROM PLAYER p 
	WHERE  HEIGHT >= 180 OR HEIGHT <= 170;
	
-- BETWEEN  ~AND ~ SQL 연산자는
-- 이상 이하의 조건만 처리 가능
-- 작은 값이 앞에 있어야 함
SELECT PLAYER_NAME , "POSITION" , BACK_NO, TEAM_ID
	FROM PLAYER p 
	WHERE HEIGHT  BETWEEN 170 AND 180;

SELECT PLAYER_NAME , "POSITION" , BACK_NO, TEAM_ID
	FROM PLAYER p 
	WHERE HEIGHT  BETWEEN 180 AND 170;
	
--문제 > 선수들 중에서 키가 170 초과 이거나 180 미만인 사람
-- SQL 연산자 중 부정연산자 NOT
SELECT PLAYER_NAME , "POSITION" , BACK_NO, TEAM_ID
	FROM PLAYER p 
	WHERE NOT HEIGHT > 170 OR HEIGHT > 180;
	
--미드필더(MF) 아닌 선수들의 정보를 출력
-- 부정연산자 NOT은 반드시 컬럼앞에 있어야 한다.

SELECT PLAYER_NAME , "POSITION" , BACK_NO, TEAM_ID
	FROM PLAYER p 
--	WHERE NOT "POSITION" = 'MF';
--	WHERE "POSITION" != 'MF';
--	WHERE  "POSITION" ^= 'MF';
	WHERE "POSITION" <> 'MF';

-- 근데 SQL연산자인 IS 와 같이 쓸때는 다름
SELECT *
	FROM EMP
		WHERE COMM IS NOT NULL;
		
--1) K- 리그 일부 선수들의 이름과 포지션， 백넘버를 알고 싶다.
--2) 조건은 소속팀이 삼성블루왕즈(K02)이거나 전남드래곤즈(K07)에 소속된 선수들 중에서
--3) 포지션이 미드펼더 (MF :Mid Fielder) 이면서 ，
--4) 키는 170 센티미터 이 상， 180 이하여야 한다.
SELECT PLAYER_NAME 이름, "POSITION" AS 포지션, BACK_NO "백 넘버"
	FROM PLAYER p 
		WHERE (TEAM_ID ='K02' OR TEAM_ID = 'K07')
			AND "POSITION" ='MF'
			AND HEIGHT >= 170 AND HEIGHT <=180;
		
SELECT PLAYER_NAME 이름, "POSITION" AS 포지션, BACK_NO "백 넘버"
	FROM PLAYER p 
		WHERE TEAM_ID IN ('K02', 'K07')
			AND "POSITION" = 'MF'
			AND HEIGHT  BETWEEN 170 AND 180;
	
