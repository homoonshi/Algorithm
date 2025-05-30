SELECT 
    U.USER_ID, 
    U.NICKNAME,
    CONCAT(CITY,' ', STREET_ADDRESS1,' ', STREET_ADDRESS2) AS "전체주소",
    CONCAT(SUBSTR(TLNO, 1, 3),'-',SUBSTR(TLNO, 4, 4),'-',SUBSTR(TLNO,8, 4)) AS "전화번호"
FROM 
(
    SELECT B.WRITER_ID, COUNT(B.WRITER_ID) AS C
    FROM USED_GOODS_BOARD B
    GROUP BY B.WRITER_ID
) AS B JOIN USED_GOODS_USER U ON B.WRITER_ID = U.USER_ID
WHERE C >= 3
ORDER BY U.USER_ID DESC;