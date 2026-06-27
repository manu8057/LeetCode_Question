# Write your MySQL query statement below
select MAX(num) AS num from (Select num from MyNumbers  group by num having Count(num)=1) t ;