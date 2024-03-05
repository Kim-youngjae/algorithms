-- 천재지변으로 인해 일부 데이터가 유실되었습니다. 
-- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.

select o.animal_id, o.name
  from animal_outs as o
  left join animal_ins as i
    on i.animal_id = o.animal_id
 where i.datetime is null
 order by o.animal_id, o.name
