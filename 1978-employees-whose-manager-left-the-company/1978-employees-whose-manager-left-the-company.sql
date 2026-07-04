# Write your MySQL query statement below
select employee_id from Employees where salary<30000 AND manager_id Not in (select employee_id from Employees) order by employee_id;