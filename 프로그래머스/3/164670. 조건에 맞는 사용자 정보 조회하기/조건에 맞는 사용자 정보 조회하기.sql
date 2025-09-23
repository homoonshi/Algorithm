SELECT U.USER_ID, 
        U.NICKNAME, 
        U.CITY || ' ' || U.STREET_ADDRESS1 || ' ' || U.STREET_ADDRESS2 AS "전체주소",
        SUBSTR(U.TLNO, 1, 3) || '-' || SUBSTR(U.TLNO, 4, 4) || '-' || SUBSTR(U.TLNO, 8, 4) AS "전화번호"
FROM USED_GOODS_USER U 
WHERE U.USER_ID IN (SELECT B2.WRITER_ID
                    FROM USED_GOODS_BOARD B2
                    GROUP BY B2.WRITER_ID
                    HAVING COUNT(*)>=3)
ORDER BY U.USER_ID DESC