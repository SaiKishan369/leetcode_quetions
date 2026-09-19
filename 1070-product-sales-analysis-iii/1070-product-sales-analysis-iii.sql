# Write your MySQL query statement below
select s.product_id, s.year as first_year, s.quantity, s.price
from sales s
join (
    select product_id, min(year) as first_year, quantity, price
    from sales
    group by product_id
)x
on s.product_id = x.product_id and s.year = x.first_year;