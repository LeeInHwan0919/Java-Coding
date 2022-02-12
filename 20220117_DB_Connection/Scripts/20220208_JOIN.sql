--JOIN
-- 원래 정규화 되기 전에 테이블로 구성
-- EQUI(등가) 조인 : 1대1로 값이 연결되는 것
--NON EQUI(비등가) 조인 : 범위의 값과 연결되는 것

-- 선수들의 정보를 출력. 팀명도 알고싶다.

SELECT *
	FROM PLAYER p , TEAM t ; -- CARTESIAN PRODUCT 카테시안 프로덕트
	
SELECT *
	FROM PLAYER p CROSS JOIN TEAM t ;
	
SELECT PLAYER_ID , PLAYER_NAME , TEAM_NAME, p.TEAM_ID 
	FROM PLAYER p , TEAM t 
	WHERE p.TEAM_ID = t.TEAM_ID ;

-- ANSI/ISO 표준에선 JOIN 절 + ON() + USING()
-- JOIN (INNER JOIN)
SELECT PLAYER_ID , PLAYER_NAME , TEAM_NAME, p.TEAM_ID 
	FROM PLAYER p JOIN TEAM t 
	ON p.TEAM_ID = t.TEAM_ID ;

-- FROM 절에서의 ALIAS를 선언되어 있다면 반드시 사용해야 한다.
SELECT PLAYER_ID , PLAYER_NAME , TEAM_NAME, PLAYER.TEAM_ID 
	FROM PLAYER  JOIN TEAM 
	ON PLAYER.TEAM_ID = TEAM.TEAM_ID ;


-- 문제> 팀테이블과 구장테이블 관계를 이용해서 소속팀이 가지고 있는 전용 구장의 정보와 함께 출력

-- INDEX를 가지고 있기 때문에
-- NL, SORT MERGE, HASH 조인이 있음
SELECT TEAM_NAME , t.STADIUM_ID 
	FROM TEAM t JOIN STADIUM s 
	ON t.STADIUM_ID  = s.STADIUM_ID ;

-- 문제> 일정에 따른 팀의 팀명(HOMETEAM, AWAYTEAM)과 구장명(STADIUM_NAME)을 보고싶다.

SELECT t.TEAM_NAME  AS "팀 이름", t.TEAM_NAME  AS "이름?"
	FROM SCHEDULE s JOIN TEAM t 
	ON s.STADIUM_ID = t.STADIUM_ID ;

SELECT STADIUM_ID , HOMETEAM_ID , AWAYTEAM_ID , SCHE_DATE 
	FROM SCHEDULE s ;

SELECT STADIUM_ID , STADIUM_NAME 
	FROM STADIUM s ;

SELECT TEAM_ID , TEAM_NAME 
	FROM TEAM t ;

-- 조인은 순서대로 2개씩 발생 함
SELECT SCHE_DATE , st.STADIUM_NAME "구장명" ,t1.TEAM_NAME "홈팀", t2.TEAM_NAME "원정팀"
	FROM SCHEDULE s JOIN TEAM t1 
		ON s.HOMETEAM_ID = t1.TEAM_ID 
			JOIN TEAM t2
		ON s.AWAYTEAM_ID = t2.TEAM_ID 
			JOIN STADIUM st 
		ON s.STADIUM_ID = st.STADIUM_ID ;

SELECT SCHE_DATE , st.STADIUM_NAME "구장명" ,t1.TEAM_NAME "홈팀", t2.TEAM_NAME "원정팀"
	FROM SCHEDULE s , TEAM t1 , TEAM t2 , STADIUM st 
		WHERE s.HOMETEAM_ID = t1.TEAM_ID 
			AND s.AWAYTEAM_ID = t2.TEAM_ID 
			AND s.STADIUM_ID = st.STADIUM_ID ;

-- NON-EQUI JOIN 비등가. 범위를 가지고 있음
CREATE TABLE SAL_FRADE (
	GRADE NUMBER,
	LOSAL NUMBER,
	HISAL NUMBER 
);

INSERT INTO SAL_FRADE VALUES(1,700,1200);
INSERT INTO SAL_FRADE VALUES(2,1201,1400);
INSERT INTO SAL_FRADE VALUES(3,1401,2000);
INSERT INTO SAL_FRADE VALUES(4,2001,3000);
INSERT INTO SAL_FRADE VALUES(5,3001,9999);

SELECT *
	FROM SAL_FRADE ;

-- 문제 > EMP테이블에서 각 사원의 급여정보를 SAL_GRADE 테이블 이용하여 등급을 출력
-- JOIN 되는 KEY로 되어있는 FK가 없고 , 같은 값을 가진 컬럼이 없다
SELECT SAL, GRADE 
	FROM EMP e, SAL_GRADE sg2 
	WHERE e.SAL BETWEEN sg2.LOSAL AND sg2.HISAL ;

SELECT *
	FROM EMP e 
	ORDER BY SAL DESC;

-- JOIN은 ANSI/ISO 표준에서는 STANDARD JOIN은 
-- INNER JOIN : ON절 , USING절
--				자동 발생. NATURAL JOIN 
-- OUTER JOIN 
-- CROSS JOIN

-- 중복되는 컬럼도 같이 나오고 순서는 선행->후행
SELECT e.*, d.*
	FROM EMP e JOIN DEPT d 
	ON e.DEPTNO = d.DEPTNO ;

-- USING을 사용하면 중복되는 컬럼은 하나로 출력되고 맨 앞으로 출력된다
SELECT *
	FROM EMP e JOIN DEPT d 
	USING(DEPTNO) ;

-- USING의 결과와 같지만 만약 같은 컬럼과 값이 여러개가 있다면 모두 조인의 대상을 선정함
SELECT *
	FROM EMP e NATURAL JOIN DEPT d ;

-- DEPT 복사해서 NATURAL JOIN을 사용해 본다
CREATE TABLE DEPT_TEMP AS SELECT * FROM DEPT d ;

-- 컬럼명 모두 같고, 타입도 모두 같음
SELECT * 
	FROM DEPT_TEMP NATURAL JOIN DEPT d  ;

SELECT *
	FROM DEPT_TEMP dt JOIN DEPT d 
	ON dt.DEPTNO = d.DEPTNO 
--	AND dt.DNAME = d.DNAME
	WHERE dt.DNAME = d.DNAME
	AND dt.DEPTNO  = 10;

SELECT *
	FROM DEPT_TEMP JOIN DEPT d 
	USING(DEPTNO, DNAME, LOC);

SELECT *
	FROM DEPT_TEMP dt NATURAL JOIN DEPT d ;
-- 10	ACCOUNTING	NEW YORK = 10	ACCOUNTING	NEW YORK
-- 10 = 10
-- 10	ACCOUNTING = 10	ACCOUNTING

SELECT *
	FROM DEPT_TEMP dt  JOIN DEPT d 
	USING(DEPTNO, LOC, DNAME);

-- 문제> 팀과 스타디움 테이블을 스타디움 ID로 JOIN하여 팀 이름 , 스타디움 ID , 스타디움 이름을 찾아라
-- NATURAL JOIN
-- JOIN ON
SELECT TEAM_NAME , s.STADIUM_ID , STADIUM_NAME 
	FROM STADIUM s JOIN TEAM t 
	ON s.STADIUM_ID = t.STADIUM_ID ;

-- USING 
SELECT TEAM_NAME , STADIUM_ID , STADIUM_NAME 
	FROM STADIUM s JOIN TEAM t 
	USING (STADIUM_ID);

-- FROM 절
SELECT 	TEAM_NAME, s.STADIUM_NAME  
	FROM TEAM t , STADIUM s 
	WHERE t.STADIUM_ID = s.STADIUM_ID;

SELECT TEAM_NAME , STADIUM_ID , STADIUM_NAME 
	FROM STADIUM s NATURAL JOIN TEAM t ;

SELECT TEAM_NAME , STADIUM_ID , STADIUM_NAME 
	FROM STADIUM s JOIN TEAM t 
	USING (STADIUM_ID, DDD, ADDRESS);




