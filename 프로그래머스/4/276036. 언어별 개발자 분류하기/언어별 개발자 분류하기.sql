SELECT
    CASE
        WHEN SKILL_CODE & (
            SELECT SUM(CODE)
            FROM SKILLCODES
            WHERE CATEGORY = 'Front End'
        ) > 0
        AND SKILL_CODE & (
            SELECT CODE
            FROM SKILLCODES
            WHERE NAME = 'Python'
        ) THEN 'A'
        WHEN SKILL_CODE & (
            SELECT CODE
            FROM SKILLCODES
            WHERE NAME = 'C#'
        ) THEN 'B'
        ELSE 'C'
    END AS GRADE,
    ID,
    EMAIL
FROM DEVELOPERS
WHERE SKILL_CODE & (
    SELECT SUM(CODE)
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
) > 0
    OR
    SKILL_CODE & (
        SELECT CODE
        FROM SKILLCODES
        WHERE NAME = 'C#'
    )
ORDER BY 1, 2