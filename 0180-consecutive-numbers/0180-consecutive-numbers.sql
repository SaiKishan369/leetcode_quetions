# Write your MySQL query statement below
select distinct(a.num) as ConsecutiveNums
from Logs a
join Logs b
on a.id=b.id +1 
join Logs c
on a.id=c.id+2
where a.num = b.num && a.num = c.num;