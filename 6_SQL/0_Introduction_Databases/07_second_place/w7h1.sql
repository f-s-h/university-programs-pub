-- evaluate second place zehnkampfd
-- corelated suqrequest
with punkte_pp as (
    select distinct name, sum(punkte) as punkte
    from zehnkampfd
    group by name
)
select distinct z.name
from zehnkampfd z, punkte_pp p
where z.name = p.name
and p.punkte = (select max(punkte)
                from punkte_pp
                where not (name = (select name
                                   from punkte_pp
                                   where punkte = (select max(punkte) from punkte_pp)
                          ))
                );

-- based on counting
with punkte_pp as (
    select distinct name, sum(punkte) as punkte
    from zehnkampfd
    group by name
)
select s.name
from punkte_pp s, punkte_pp g
where s.punkte < g.punkte
group by s.name
having count(g) = 1
