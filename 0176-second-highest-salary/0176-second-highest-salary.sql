# Write your MySQL query statement below
select MAX(Salary) AS SecondHighestSalary from employee where salary<(select Max(salary) from employee);