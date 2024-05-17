WITH RECURSIVE GenerationTree AS (
    SELECT 
        ID,
        PARENT_ID,
        SIZE_OF_COLONY,
        DIFFERENTIATION_DATE,
        GENOTYPE,
        1 AS GENERATION
    FROM 
        ECOLI_DATA
    WHERE 
        PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT 
        e.ID,
        e.PARENT_ID,
        e.SIZE_OF_COLONY,
        e.DIFFERENTIATION_DATE,
        e.GENOTYPE,
        gt.GENERATION + 1
    FROM 
        ECOLI_DATA e
    INNER JOIN 
        GenerationTree gt ON e.PARENT_ID = gt.ID
)

SELECT 
    COUNT(gt.ID) AS COUNT,
    gt.GENERATION
FROM 
    GenerationTree gt
LEFT JOIN 
    ECOLI_DATA e ON gt.ID = e.PARENT_ID
WHERE 
    e.ID IS NULL
GROUP BY 
    gt.GENERATION
ORDER BY 
    gt.GENERATION;
