-- return all lectures, that shall not be heard before the third semester
with recursive vor as (
    select *, 1 as cnt
    from voraussetzen
    union
    select vo.vorgaenger, v.nachfolger, vo.cnt + 1
    from vor vo, voraussetzen v
    where vo.nachfolger = v.vorgaenger
)
select distinct v.vorlnr, v.titel
from vorlesungen v, vor vo
where v.vorlnr = vo.nachfolger
    and vo.cnt >= 2