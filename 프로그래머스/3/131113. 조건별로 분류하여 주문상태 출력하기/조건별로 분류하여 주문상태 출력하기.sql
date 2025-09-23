SELECT O.ORDER_ID, O.PRODUCT_ID, TO_CHAR(O.OUT_DATE, 'YYYY-MM-DD'), 
    CASE WHEN O.ORDER_ID IN (SELECT O2.ORDER_ID
                            FROM FOOD_ORDER O2
                            WHERE OUT_DATE < TO_DATE('2022-05-02', 'YYYY-MM-DD'))
        THEN '출고완료'
        WHEN O.ORDER_ID IN (SELECT O2.ORDER_ID
                            FROM FOOD_ORDER O2
                            WHERE OUT_DATE IS NULL) 
                            THEN '출고미정'
        ELSE '출고대기' END AS 출고여부
FROM FOOD_ORDER O
ORDER BY O.ORDER_ID ASC