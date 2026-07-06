# Write your MySQL query statement below
select  user_id,COUNT(user_id) AS  followers_count from Followers group by user_id order by  user_id;