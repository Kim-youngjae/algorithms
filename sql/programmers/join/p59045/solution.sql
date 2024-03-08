-- 보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다.
-- 보호소에 들어올 당시에는 중성화되지 않았지만, 
-- 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 
-- 아이디 순으로 조회하는 SQL 문을 작성해주세요.

select i.animal_id, i.animal_type, i.name
  from animal_ins as i
  join animal_outs as o
    on i.animal_id = o.animal_id
 where i.sex_upon_intake like 'Intact%' and (o.sex_upon_outcome like 'Neutered%' or o.sex_upon_outcome like 'Spayed%')
 order by i.animal_id