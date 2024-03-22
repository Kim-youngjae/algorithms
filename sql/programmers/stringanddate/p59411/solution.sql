-- 입양을 간 동물 중, 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회하는 SQL문을 작성해주세요.
-- 이때 결과는 보호 기간이 긴 순으로 조회해야 합니다.

select i.animal_id, i.name
  from animal_ins as i
  join animal_outs as o
    on i.animal_id = o.animal_id
 order by datediff(o.datetime, i.datetime) + 1 desc 
 limit 2