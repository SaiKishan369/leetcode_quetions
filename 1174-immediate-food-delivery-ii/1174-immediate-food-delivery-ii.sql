# Write your MySQL query statement below
select round(
    sum(case when d.order_date = d.customer_pref_delivery_date then 1 else 0 end)/(select count(distinct customer_id) from delivery) * 100
    ,2) as immediate_percentage 
from delivery d
join ( 
    select delivery_id, customer_id, min(order_date) as first_order
    from delivery
    group by customer_id
) x
on x.customer_id = d.customer_id and x.first_order = d.order_date;