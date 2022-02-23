--서브쿼리
-- 쿼리안에 ()통해서 먼저 실행되는 쿼리 : Main쿼리

-- SCALA SUBQUERY
-- SELECT, WHERE, HAVING, ORDER BY, INSERT, UPDATE

-- INLINE VIEW
-- FROM

--문제) 정남일 선수가 포함된 팀의 선수명, 포지션, 백넘버 를 
SELECT PLAYER_NAME , "POSITION" , BACK_NO 
	FROM PLAYER p 
		WHERE TEAM_ID  = (SELECT TEAM_ID 
							FROM PLAYER p2 
							WHERE PLAYER_NAME ='정남일');

-- 문제) 모든 축구선수들의 평균 키 보다 작은 선수들을 출력
SELECT PLAYER_NAME 
	FROM PLAYER p 
		WHERE HEIGHT < (SELECT AVG(HEIGHT)
							FROM PLAYER p2);

--문제) 정남일 선수의 포지션과 팀이 같은 선수들의 정보를 보고싶다.
SELECT PLAYER_NAME 
	FROM PLAYER p 
		WHERE "POSITION" = (SELECT "POSITION" FROM PLAYER p2 WHERE PLAYER_NAME='정남일')
			AND TEAM_ID = (SELECT TEAM_ID  FROM PLAYER p2 WHERE PLAYER_NAME='정남일');

SELECT *
	FROM PLAYER p 
	WHERE ("POSITION", TEAM_ID) IN (SELECT "POSITION", TEAM_ID  FROM PLAYER p2 WHERE PLAYER_NAME='정남일');

SELECT *
	FROM PLAYER p 
		WHERE PLAYER_NAME ='정현수';

SELECT *
	FROM TEAM t
		WHERE TEAM_ID IN (SELECT TEAM_ID 
							FROM PLAYER p 
								WHERE PLAYER_NAME ='정현수');		

-- 소속팀별 키가 가장 작은 선수들의 정보를 출력
-- 서브쿼리의 결과가 여러개 나오는 다중행 서브쿼리를 사용 + IN절의 컬럼을 2개 적으면 2개의 컬럼은 AND가 된다.
SELECT TEAM_ID , PLAYER_NAME , "POSITION" , BACK_NO , HEIGHT 
	FROM PLAYER p
	WHERE (TEAM_ID ,HEIGHT) IN (SELECT TEAM_ID , MIN(HEIGHT) 
						FROM PLAYER p 
						GROUP BY TEAM_ID);

SELECT MIN(HEIGHT) 
	FROM PLAYER p ;

--조건의 결과가 ~~별 GROUP BY 를 통해서 쿼리의 결과를 만들고 INLINE VIEW로 사용하여
-- PLAYER 테이블과 조인
SELECT pmain.TEAM_ID , PLAYER_NAME , "POSITION" , BACK_NO 
	FROM PLAYER pmain JOIN (
					SELECT TEAM_ID , MIN(HEIGHT) 
						FROM PLAYER p 
						GROUP BY TEAM_ID) psub
	ON pmain.TEAM_ID = psub.TEAM_ID 
	AND PMAIN.HEIGHT = psub.HEIGHT ;

--연관서브 쿼리
SELECT TEAM_ID , PLAYER_NAME 
	FROM PLAYER p 
		WHERE (TEAM_ID, HEIGHT) IN (SELECT TEAM_ID, MIN(HEIGHT)
										FROM PLAYER p2 
											WHERE p.TEAM_ID  = p2.TEAM_ID
											GROUP BY TEAM_ID);

--문제> 선수들의 소속된 팀의 평균키보다 작은 선수들을 출력


SELECT TEAM_ID , PLAYER_NAME , BACK_NO , HEIGHT 
	FROM PLAYER p 
	WHERE HEIGHT <( 
			SELECT AVG(HEIGHT) 
				FROM PLAYER p2
					WHERE p.TEAM_ID = p2.TEAM_ID);

SELECT TEAM_ID , AVG(HEIGHT) 
	FROM PLAYER p 
		GROUP BY TEAM_ID 
		
SELECT p2.TEAM_ID ,PLAYER_NAME , HEIGHT , AVGH 
	FROM PLAYER p2 JOIN (SELECT TEAM_ID, AVG(HEIGHT) AVGH
							FROM PLAYER p
							GROUP BY TEAM_ID)p3 
		ON p2.TEAM_ID = p3.TEAM_ID 
		WHERE p2.HEIGHT < p3.AVGH;

--문제> 선수들의 정보를 출력 소속된 팀의 평균키도 같이 출력
SELECT TEAM_ID ,PLAYER_NAME , HEIGHT , (SELECT AVG(HEIGHT) FROM PLAYER p2 WHERE p1.TEAM_ID = p2.TEAM_ID) AVGH
	FROM PLAYER p1;
	
-- 문제> 선수들의 정보를 출력 축구선수에 소속된 전체 키의 평균도 같이 출력(팀명, 선수이름, 백넘버, 키, 전체평균)
SELECT TEAM_ID ,PLAYER_NAME , HEIGHT , (SELECT AVG(HEIGHT) FROM PLAYER p2) 전체평균
	FROM PLAYER p1;

-- EXISTS 결과가 나왔다면 출력. 아니면 대상을 판단하지 않는다
-- EXISTS 서브 쿼리를 사용하여 20120501 부터 20120502 사이에 경기가 있는 경기장을 조회하는 SQL문이다
SELECT *
	FROM STADIUM s ;
SELECT *
	FROM SCHEDULE s ;

SELECT *
	FROM STADIUM s , SCHEDULE s2 
	WHERE s.STADIUM_ID = s2.STADIUM_ID 
	AND SCHE_DATE BETWEEN '20120501' AND '20120502';

-- EXISTS는 연관서브쿼리의 결과가 있다면 그 연산된 ROW를 대상으로 선정한다.
SELECT *
	FROM STADIUM s 
	WHERE EXISTS (SELECT 'ASLDK;FJ;ASKLDJF;ALSK'
					FROM SCHEDULE s2
					WHERE s.STADIUM_ID=s2.STADIUM_ID
					AND SCHE_DATE BETWEEN '20120501' AND '20120502');	
				
-- 문제>평균 키가. 삼성 블루윙즈팀의 평균키보다 작은 팀의 이름과 해당 팀의 평균키를 구하는 문제
SELECT t.TEAM_ID , t.TEAM_NAME , ROUND(AVG(HEIGHT)) 평균키 
	FROM PLAYER p JOIN TEAM t 
	ON p.TEAM_ID = t.TEAM_ID 
	GROUP BY t.TEAM_ID , TEAM_NAME 
	HAVING AVG(p.HEIGHT ) < (SELECT AVG(HEIGHT) 
								FROM PLAYER p2 
									WHERE TEAM_ID = 'K02');
			
-- UPDATE 문 => 역정규화
-- TEAM 테이블에 STADIUM_NAME의 컬럼을 추가하고 해당 내용을 STADIUM 테이블에서 검색하여 UPDATE해주세요
ALTER TABLE TEAM ADD (STADIUM_NAME VARCHAR2(40));

SELECT *
	FROM TEAM t ;

UPDATE  TEAM t SET STADIUM_NAME = (SELECT STADIUM_NAME 
									FROM STADIUM s
									WHERE s.STADIUM_ID= t.STADIUM_ID);
-- INSERT 문
-- 서브쿼리를 통해서 SEQUENCE TABLE 없이 자동으로 입력이 될때 만다 1씩 증가되는 쿼리를 작성
DELETE FROM INFO;
SELECT *
	FROM INFO i ;
-- SEQ는 PK로 되어 있기 때문에 UNIQUE KEY가 되어 있어서 중복값이 들어갈 수 없다.
-- 처음에 값을 입력할 때는 공집합 -> 집계 함수 실행 -> NULL -> NVL -> 0
INSERT INTO GD.INFO
(SEQ, NAME, PHONE, AUTH, REGDATE)
VALUES((SELECT NVL(MAX(SEQ),0)  FROM INFO)+1, '둘리', '101', 'U', SYSDATE);



