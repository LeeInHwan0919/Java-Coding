-- 20220120
-- SELECT는 FROM절의 테이블을 반복하여 사용할 수 있다.
SELECT PLAYER_ID , PLAYER_NAME || '(' || BACK_NO , HEIGHT , HEIGHT FROM PLAYER p;

SELECT * FROM USER_TAB_PRIVS_MADE;  -- SYSTEM사용자 부여한 권한
SELECT * FROM USER_TAB_PRIVS_RECD;  --  SYSTEM에게 부여된 권한