# Write your MySQL query statement below
select round(
    sum(case when d.order_date = d.customer_pref_delivery_date  then 1 end )/(select count(distinct customer_id) from delivery) * 100
    ,2) as immediate_percentage 
    from delivery d
    join (select customer_id,min(order_date) as first_orderdate from delivery group by customer_id)x
    on d.customer_id = x.customer_id and d.order_date = x.first_orderdate;