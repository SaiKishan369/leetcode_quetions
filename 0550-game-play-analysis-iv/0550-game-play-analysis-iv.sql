# Write your MySQL query statement below
select round(
    count(a.player_id)/(select count(distinct player_id) from activity)
    ,2) as fraction
from activity a
join (
    select *,min(event_date) as first_date
    from activity 
    group by player_id
) x
on x.player_id = a.player_id
and a.event_date = date_add(x.first_date,interval 1 day);