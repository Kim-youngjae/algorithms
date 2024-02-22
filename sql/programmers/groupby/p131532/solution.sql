-- USER_INFO 테이블과 ONLINE_SALE 테이블에서
-- 년, 월, 성별 별로 상품을 구매한 회원수를 집계하는 SQL문을 작성해주세요. 
-- 결과는 년, 월, 성별을 기준으로 오름차순 정렬해주세요. 
-- 이때, 성별 정보가 없는 경우 결과에서 제외해주세요.

# select year(s.sales_date) as YEAR, month(s.sales_date) as MONTH, i.GENDER, count(s.sales_amount) as USERS
#   from USER_INFO as i
#   join ONLINE_SALE as s
#     on i.user_id = s.user_id
#  group by YEAR, MONTH, GENDER having gender is not null
#  order by YEAR, MONTH, GENDER

select year(sales_date) as `year`, month(sales_date) as `month`, gender, count(distinct(i.user_id)) as users
 from USER_INFO as i
  join ONLINE_SALE as s
    on i.user_id = s.user_id
 group by `year`, `month`, gender having gender is not null
 order by year(sales_date), month(sales_date), gender