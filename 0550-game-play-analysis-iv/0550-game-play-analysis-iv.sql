# Write your MySQL query statement below
select round(count(a.player_id)/(select count(distinct(player_id)) from activity),2) as fraction
from activity a
join (
    select *, min(event_date) as firstLogin
    from activity 
    group by player_id
) first_date
on a.player_id=first_date.player_id
and a.event_date = date_add(first_date.firstLogin,interval 1 day);