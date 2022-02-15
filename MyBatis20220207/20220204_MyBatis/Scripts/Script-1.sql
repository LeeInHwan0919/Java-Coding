CREATE TABLE "BD"."INFO" 
   (    "SEQ" NUMBER, 
    "NAME" VARCHAR2(50) NOT NULL ENABLE, 
    "PHONE" VARCHAR2(20), 
    "AUTH" CHAR(1) DEFAULT 'U', 
    "REGDATE" DATE NOT NULL ENABLE, 
     PRIMARY KEY ("SEQ"));
     
    SELECT * FROM USER_SEQUENCES;
   
   
   SELECT * FROM info;
  
  --INFO테이블 SEQ(SEQUENCE:INFO_SEQ), AUTH(DEFAULT CONSTRAINT)

CREATE TABLE INFO(
   SEQ NUMBER PRIMARY KEY, -- COLUMN
   NAME VARCHAR2(50) NOT NULL,
   PHONE VARCHAR2(20),
   AUTH CHAR(1),
   REGDATE DATE NOT NULL
   -- CONSTRAINT  PRIMARY KEY (SEQ) - TABLE
);

DROP TABLE INFO ;

-- ALTER TABLE INFO ADD CONSTRAINT  PRIMARY KEY SEQ - ALTER

-- SEQUENCE 자동으로 증가 되어서 컬럼에 값을 UNIQUE하게 만들기 위해서
-- NEXTVAL, CURRVAL, SESSION
-- 값을 증가(NEXTVAL) 시키지 않았다면 현재 값(CURRVAL)을 가져 올 수 없다
-- 
CREATE SEQUENCE INFO_SEQ START WITH 1 INCREMENT BY 1;
SELECT INFO_SEQ.CURRVAL
   FROM DUAL;

SELECT *
    FROM INFO i;

INSERT INTO INFO(SEQ, NAME, PHONE, REGDATE)
    VALUES(INFO_SEQ.NEXTVAL, '시계','111', SYSDATE);

SELECT *
    FROM INFO i
        WHERE SEQ = '21';
       
       
       
       
SELECT *
FROM JOBS
	WHERE JOB_ID LIKE 'IT%';

SELECT *
FROM JOBS
	WHERE JOB_ID LIKE 'IT'||'%';
       
SELECT *
FROM JOBS;




       
SELECT * FROM JOBS;
       CREATE TABLE "JOBS" 
   (	"JOB_ID" VARCHAR2(10) , 
	"JOB_TITLE" VARCHAR2(35) NOT NULL,
	"MIN_SALARY" NUMBER(6,0), 
	"MAX_SALARY" NUMBER(6,0)
   );
ALTER TABLE "JOBS" ADD CONSTRAINT "JOB_ID_PK" PRIMARY KEY ("JOB_ID");

INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES ('AD_PRES','President',20000,40000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('AD_VP','Administration Vice President',15000,30000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('AD_ASST','Administration Assistant',3000,6000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('FI_MGR','Finance Manager',8200,16000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('FI_ACCOUNT','Accountant',4200,9000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('AC_MGR','Accounting Manager',8200,16000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('AC_ACCOUNT','Public Accountant',4200,9000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('SA_MAN','Sales Manager',10000,20000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('SA_REP','Sales Representative',6000,12000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('PU_MAN','Purchasing Manager',8000,15000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('PU_CLERK','Purchasing Clerk',2500,5500);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('ST_MAN','Stock Manager',5500,8500);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('ST_CLERK','Stock Clerk',2000,5000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('SH_CLERK','Shipping Clerk',2500,5500);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('IT_PROG','Programmer',4000,10000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('MK_MAN','Marketing Manager',9000,15000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('MK_REP','Marketing Representative',4000,9000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('HR_REP','Human Resources Representative',4000,9000);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('PR_REP','Public Relations Representative',4500,10500);
INSERT INTO JOBS (JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY) VALUES	 ('IT_GOO','it programmer',1000,10000);
       
       
       
       
-------------------Dynamic 쿼리-------------
--1) 조건문을 판단해서 값이 있다면 상세검색, 값이 없다면 전체검색IF
	SELECT JOB_ID , JOB_TITLE , MIN_SALARY , MAX_SALARY 
	FROM JOBS
	WHERE JOB_ID='IT_PROG';       
       
       
       
       
       
       
       
