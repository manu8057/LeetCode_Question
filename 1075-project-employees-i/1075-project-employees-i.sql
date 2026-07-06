# Write your MySQL query statement below
select project_id,ROUND(SUM(Employee. experience_years)/COUNT(Project.Project_Id),2) AS average_years
from Project join Employee on Project.employee_id=Employee.employee_id group by project_id;