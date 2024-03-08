-- DEVELOPERS 테이블에서 
-- Front End 스킬을 가진 개발자의 정보를 조회하려 합니다.
-- 조건에 맞는 개발자의 ID, 이메일, 이름, 성을 조회하는 SQL 문을 작성해 주세요.
-- 결과는 ID를 기준으로 오름차순 정렬해 주세요.

-- 비트연산자 풀이
select id, email, first_name, last_name
  from developers
 where skill_code & (select sum(code)
                       from skillcodes
                      where category = 'Front End'
                    )
 order by id

-- 조인을 이용
select id, email, first_name, last_name
  from developers
  join (select code
          from skillcodes
         where category = 'Front End'
       ) as s
    on skill_code & s.code
 order by id 
