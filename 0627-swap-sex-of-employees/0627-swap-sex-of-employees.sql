# Write your MySQL query statement below
update Salary set sex= CASE when sex='m' then 'f'
                  ELSE 'm'
            END;