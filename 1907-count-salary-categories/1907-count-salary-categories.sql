# Write your MySQL query statement below
SELECT 'Low Salary' As category ,sum(CASE WHEN income<20000 THEN 1 else 0 END) AS accounts_count FROM accounts
UNION ALL
SELECT 'Average Salary' AS category ,sum(CASE WHEN income BETWEEN 20000 AND 50000 THEN 1 else 0 END) AS accounts_count FROM accounts
UNION ALL
SELECT 'High Salary' AS category ,sum(CASE WHEN income>50000 THEN 1 else 0 END) AS accounts_count FROM accounts