-- earliest semester, a lecture can be heard
with recursive vor as (
    select *, 1 as count
    from voraussetzen
    union
    select vo.vorgaenger, v.nachfolger, vo.count + 1
    from vor vo, voraussetzen v
    where vo.nachfolger = v.vorgaenger
)
select v.vorgaenger as vorlnr, max(v.count) as earliest_semester
from vor v
group by v.vorgaenger;