-- MEMBER_PROFILE 테이블에서 
-- 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문을 작성해주세요.
-- 이때 전화번호가 NULL인 경우는 출력대상에서 제외시켜 주시고
-- 결과는 회원ID를 기준으로 오름차순 정렬해주세요.
select member_id, member_name, gender, date_format(date_of_birth, '%Y-%m-%d') as date_of_birth
  from member_profile
 where tlno is not null and gender = 'W' and month(date_of_birth) = 3
 order by member_id asc;