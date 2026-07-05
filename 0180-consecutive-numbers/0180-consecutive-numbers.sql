# Write your MySQL query statement below
select DISTINCT num AS ConsecutiveNums from (select num,lag(num) over(order by id) AS pre,
lead(num) over(order by id) AS nt from logs)t where num=pre AND num=nt;