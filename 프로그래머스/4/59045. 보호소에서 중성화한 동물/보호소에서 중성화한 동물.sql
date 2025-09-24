SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME 
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.SEX_UPON_INTAKE in ('Intact Male', 'Intact Female')
AND O.SEX_UPON_OUTCOME in ('Spayed Female', 'Neutered Male')
ORDER BY I.ANIMAL_ID ASC

-- Spayed Female, Spayed Female // Intact 중성화 X