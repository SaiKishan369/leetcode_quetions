# Write your MySQL query statement below
select r.contest_id, round(
    count(distinct r.user_id)/(select count(*) from users) * 100
    ,2
) as percentage
from register r
group by contest_id
order by percentage desc, contest_id;