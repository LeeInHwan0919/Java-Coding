-- 20220128
-- NULL 미지의 값을 얘기함
-- 값으로 찾을 수가 없다

SELECT NULL+1, NULL || 'A'
	FROM DUAL;
	
SELECT *
	FROM EMP e 
		WHERE NULL > 1;
	
SELECT *
	FROM EMP e 
--		WHERE COMM = NULL ;
--		WHERE COMM IS NULL;
--		WHERE COMM IS NOT NULL;
		WHERE NOT COMM IS NULL;

--ROWNUM -절차적 숫자
-- RDBMS가 순차적으로 출력하는 순번
-- 하위 숫자가 없으면, 상위 숫자를 만들어 내지 못함
SELECT ROWNUM, PLAYER_ID 
	FROM PLAYER p ;

SELECT ROWNUM, PLAYER_ID 
	FROM PLAYER p 
	WHERE ROWNUM =2;

SELECT ROWNUM, PLAYER_ID 
	FROM PLAYER p 
	WHERE ROWNUM <3;

-- SUBQUERY 중에서 FROM 절의 테이블을 가상으로 만들어 사용하는 방법 => INLINE VIEW
-- 선수들을 키가 큰 순서대로 10명을 이름 순으로 출력해 주세요
-- 테이블 : 플레이어
-- 셀렉트 : 선수
-- 조건 : 키가큰, 10명, 이름 순

SELECT PLAYER_NAME, HEIGHT 
	FROM PLAYER p 
		WHERE HEIGHT IS NOT NULL
		AND ROWNUM <11
		ORDER BY HEIGHT DESC;
	
SELECT ROWNUM , tmp.PLAYER_NAME , tmp.HEIGHT 
	FROM (SELECT  PLAYER_NAME , HEIGHT 
			FROM PLAYER p 
				WHERE HEIGHT IS NOT NULL
				ORDER BY HEIGHT DESC
		 )tmp
		 WHERE  ROWNUM <=10;
		
-- 문자열에 관련된 함수
-- LOWER, UPPER
SELECT E_PLAYER_NAME, LOWER(E_PLAYER_NAME) 소문자이름, 
	UPPER(E_PLAYER_NAME) AS "대문자 이름"  , UPPER('가') 
		FROM PLAYER p 
		WHERE E_PLAYER_NAME IS NOT NULL
		AND UPPER(E_PLAYER_NAME) LIKE UPPER('kim%');

SELECT HEIGHT , WEIGHT , PLAYER_NAME, PLAYER_NAME || '(' || BACK_NO  || ')' 이름, --ORACLE
	CONCAT(CONCAT(PLAYER_NAME,BACK_NO),HEIGHT) 
	FROM PLAYER p ;

-- NULL의 연산은 NULL이지만 NULL ||(CONCAT) 1 의 NULL은 없다고 뜸
SELECT 1+1, '1'+1, CONCAT('가',1), NULL + 1, NULL || 1 , CONCAT(NULL,1) 
	FROM DUAL;

SELECT PLAYER_NAME , LENGTH (PLAYER_NAME), SUBSTR(PLAYER_NAME, -1,3), -- 시작값은 0,1 음수이면 뒤에서 부터
	SUBSTR(PLAYER_NAME, 5,3) -- 결과값이 없으면 NULL 
	FROM PLAYER p 
		WHERE LENGTH (PLAYER_NAME) = 4 ;

SELECT '   xxyzzaabbcc   ', TRIM('   xxyzzaabbcc   '), LTRIM('xxyzzaabbcc', 'bxzy')  
	FROM DUAL;
	
-- 사원번호 202202001
SELECT EMPNO , DEPTNO , LPAD(EMPNO, 6, '-') , EMPNO  || LPAD('1', 6, '0'), EMPNO || LPAD('111',6,'0'), -- 값, 크기, 채울값
	-- goodee0228 -> goodee****
	LPAD('****',10,'GOODEE0228')
	FROM EMP e  ;

SELECT PLAYER_ID , RPAD(SUBSTR(PLAYER_ID,1,4), LENGTH(PLAYER_ID), '*') 
	FROM PLAYER p ;

SELECT DNAME , RPAD(SUBSTR(DNAME,1,5), LENGTH(DNAME), '.') DATA
	FROM DEPT d ;
	
SELECT INSTR('happy new year', 'new') , INSTR('happy new year', 'on')
	FROM DUAL;

--233page 숫자형 함수
SELECT ABS(-1), ABS(0), ABS(10), SIGN(9), SIGN(0), SIGN(-1000) , MOD(10,3), --나머지
	POWER(10,2), ROUND(10/4), ROUND(3.145, 2), --2 
	TRUNC(10/4)
	FROM DUAL;

-- CEIL / FLOOR
SELECT CEIL (1.8), FLOOR(1.8), CEIL(1), FLOOR(1),
	CEIL (-0.1), FLOOR(-0.1) 
	FROM DUAL;

-- 235PAGE 날짜형 함수 : 일정관리
-- 날짜는 java java.util.Data / java.utilCalendar / <=> 문자열 변경 java.util.SimpleDateFormat("")
-- javascript 2022 1 28 -> '2022 01 28'
-- TO_CHAR, TO_DATE()

SELECT SYSDATE -- 년 월 일 -> 숫자? 1 문자? 01
	FROM DUAL;

-- EXTRACT , TO_NUMBER + TO_CHAR 
SELECT HIREDATE , EXTRACT (YEAR FROM HIREDATE) 년, EXTRACT (MONTH FROM HIREDATE) 월, EXTRACT (DAY FROM HIREDATE) 일,
	--TO_CHAR (HIREDATE, 'YYYYMMDD'), TO_CHAR (HIREDATE, 'MM'), TO_NUMBER(TO_CHAR(HIREDATE, 'DD')),
	TO_CHAR (HIREDATE, 'YYYY MM DD')
	FROM EMP e ;

-- 한달 전 한달 후 혹은 몇달 후
-- 한달 후 
SELECT SYSDATE , ADD_MONTHS('20220131', -2), ADD_MONTHS('20220131', -12)
	FROM DUAL;

SELECT '맞아용', '01' + 1 -- 자동으로 DB는 값을 변환하여 사용함
	FROM DUAL
		WHERE '01'=1;

SELECT LEVEL
	FROM DUAL
		CONNECT BY LEVEL <= 12;
	
-- 238 PAGE 변환형 함수
	--1) 명시적 함수 : 수동변환
	--2) 암시적 함수 : 자동변환 
-- 컬럼이 DATE 타입이라면 INSERT 시 VALUES('20220128')
	
	--날짜타입으로 값(문자)을 변경한다면 구분자가 없을 경우 반드시 길이는 맞춰줘야 한다
SELECT TO_DATE('2022-01-01-1-4-2', 'YYYY-MM-DD HH24:MI:SS')
	TO_DATE('20220101142', 'YYYYMMDDHH24MISS')
	FROM DUAL;
	
-- 날짜타입(DATE) 을 문자 FORMAT으로 변경 함
-- TO_CHAR 
SELECT  TO_CHAR(SYSDATE , 'YYYY') 
	FROM DUAL;

-- CHAR
INSERT INTO PLAYER (PLAYER_ID, PLAYER_NAME, TEAM_ID)
VALUES ('77', '이상규', 'K01');

UPDATE PLAYER SET JOIN_YYYY = '77' WHERE PLAYER_ID ='77';
UPDATE PLAYER SET NATION  = '77' WHERE PLAYER_ID ='77';

SELECT  *
	FROM PLAYER p 
		WHERE PLAYER_ID = JOIN_YYYY 
		AND PLAYER_ID = NATION ; 

SELECT *
	FROM PLAYER p 
		WHERE TO_NUMBER(PLAYER_ID) = TO_NUMBER(NATION);  
	
SELECT  PLAYER_NAME 
	FROM PLAYER p 
		WHERE PLAYER_ID = '77'
--		AND TO_NUMBER(PLAYER_ID) = TO_NUMBER(NATION); 
--		AND TO_NUMBER(PLAYER_ID) = TO_NUMBER(JOIN_YYYY);
--		AND PLAYER_ID = JOIN_YYYY ; -- CHAR : CHAR 
--		AND PLAYER_ID = NATION ; -- CHAR : VARCHAR
--		AND PLAYER_ID = TRIM(NATION);
--		AND TRIM(PLAYER_ID) = NATION ; -- 트림으로 쪼개면 CHAR로 바뀜
		AND TO_CHAR(PLAYER_ID) = TO_CHAR(NATION);  
--ORACLE  12C 이상부터 추가된 JSON TABLE




	
	
	
	