# Write your MySQL query statement below
select A.id from weather A Join weather B ON DATEDIFF(A.recordDate,B.recordDate)=1 AND A.temperature>B.temperature;