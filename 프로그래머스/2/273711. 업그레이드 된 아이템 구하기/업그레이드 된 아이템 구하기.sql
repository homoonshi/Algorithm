SELECT DISTINCT INFO.ITEM_ID, INFO.ITEM_NAME, INFO.RARITY
FROM (SELECT T.ITEM_ID
     FROM ITEM_TREE T
      WHERE T.PARENT_ITEM_ID IN (SELECT I.ITEM_ID
                         FROM ITEM_INFO I
                         WHERE I.RARITY = 'RARE')
     ) P JOIN ITEM_INFO AS INFO ON P.ITEM_ID = INFO.ITEM_ID
ORDER BY INFO.ITEM_ID DESC