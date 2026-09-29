select distinct(a.num) as consecutiveNums
from logs a
join logs b on a.id +1 = b.id
join logs c on c.id=a.id+2
where a.num=b.num and c.num = a.num;