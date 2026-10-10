# Write your MySQL query statement below
select x.activity_date as day, 
count(distinct x.user_id) as active_users
from (
    select * from activity
    where activity_type in 
    ('open_session', 'end_session', 'scroll_down', 'send_message')
and  activity_date between date_sub('2019-07-27',interval 29 day) and '2019-07-27'
) x
group by day;