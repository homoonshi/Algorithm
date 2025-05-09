SELECT I.ITEM_ID, I.ITEM_NAME, I.RARITY 
FROM (
    SELECT ITEM_ID
    FROM ITEM_TREE 
    WHERE ITEM_ID NOT IN (
        SELECT DISTINCT PARENT_ITEM_ID
        FROM ITEM_TREE
        WHERE PARENT_ITEM_ID IS NOT NULL
    )
) T JOIN ITEM_INFO I ON T.ITEM_ID = I.ITEM_ID
ORDER BY I.ITEM_ID DESC;