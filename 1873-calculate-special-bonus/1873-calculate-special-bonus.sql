# Write your MySQL query statement below
select  employee_id,CASE 
                         when employee_id%2!=0 AND name NOT Like 'm%' then salary
                         ELSE 0
                    END AS bonus
from Employees ORDER BY employee_id;