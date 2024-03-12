-- USER_INFO 테이블과 ONLINE_SALE 테이블에서 
-- 2021년에 가입한 전체 회원들 중 
-- 상품을 구매한 회원수와 상품을 구매한 회원의 비율(=2021년에 가입한 회원 중 상품을 구매한 회원수 / 2021년에 가입한 전체 회원 수)을 년, 월 별로 출력하는 SQL문을 작성해주세요. 
-- 상품을 구매한 회원의 비율은 소수점 두번째자리에서 반올림하고,
-- 전체 결과는 년을 기준으로 오름차순 정렬해주시고 년이 같다면 월을 기준으로 오름차순 정렬해주세요.

select year(s.sales_date) as `year`, month(s.sales_date) as `month`, count(distinct i.user_id) as `purchased_users`,
round(count(distinct i.user_id) / (select count(user_id) from user_info where year(joined) = '2021'), 1) as `purchased_ratio`
  from user_info as i
  join online_sale as s
    on i.user_id = s.user_id
 where year(i.joined) = '2021'
 group by year(s.sales_date), month(s.sales_date)
 order by year(s.sales_date) asc, month(s.sales_date) asc
 ;