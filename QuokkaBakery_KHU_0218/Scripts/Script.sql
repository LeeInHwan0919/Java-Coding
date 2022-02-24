CREATE TABLE ADMIN(
    SEQ NUMBER PRIMARY KEY,  --COLUMN
    ID VARCHAR2(15) NOT NULL,
    PW VARCHAR2 (20) NOT NULL,
    NAME VARCHAR2(100) NOT NULL,
    BIRTHDATE VARCHAR2 (10) NOT NULL,
    PHONENUM VARCHAR2 (15) NOT NULL
);

CREATE SEQUENCE SEQ
    START WITH 1
    INCREMENT BY 1;



SELECT *
    FROM ADMIN a ;

DROP TABLE ADMIN;


INSERT INTO ADMIN (SEQ, ID, PW, NAME, BIRTHDATE, PHONENUM) VALUES (SEQ.NEXTVAL, 'Goobee', '456123','황인경', '1999-01-08','01012345678');
INSERT INTO ADMIN (SEQ, ID, PW, NAME, BIRTHDATE, PHONENUM ) VALUES (SEQ.NEXTVAL, 'Goobee', '456','이인환', '1990-09-19' );
INSERT INTO ADMIN (SEQ, ID, PW, NAME, BIRTHDATE, PHONENUM ) VALUES (SEQ.NEXTVAL, 'SQLMASTER', '123','김휘웅', '1990-01-11' );