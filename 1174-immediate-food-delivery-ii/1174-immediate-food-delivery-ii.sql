# Write your MySQL query statement below
select
round(sum(case when order_date = customer_pref_delivery_date then 1 else 0 end)/count(*)*100, 2) as immediate_percentage 
from delivery c
join (
    select customer_id, min(order_date) as first_date
    from delivery
    group by customer_id
) x
on c.customer_id = x.customer_id and c.order_date = x.first_date;