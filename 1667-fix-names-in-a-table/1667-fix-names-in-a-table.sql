# Write your MySQL query statement below
select user_id ,CONCAT(upper(LEFT(name,1)),lower(substring(name,2))) AS name from users ORDER BY user_id;