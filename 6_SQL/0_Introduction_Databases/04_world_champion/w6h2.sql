-- Evaluates the winner of the championship
with Finale as (
    select s.team, sum(e.tore) as tore
    from spieler s, einsatz e
    where e.datum = (select max(e2.datum) from einsatz e2)
    and s.spielerid = e.spielerid
    group by s.team
)
select f.team
from finale f
where f.tore = (select max(f2.tore) from finale f2)
