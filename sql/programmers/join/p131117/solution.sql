-- FOOD_PRODUCT와 FOOD_ORDER 테이블에서 
-- 생산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출을 조회하는 SQL문을 작성해주세요. 
-- 이때 결과는 총매출을 기준으로 내림차순 정렬해주시고 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬해주세요.

select p.product_id, p.product_name, sum(p.price * o.amount) as `total_sales`
  from food_product as p
  join food_order as o
    on p.product_id = o.product_id
 where o.produce_date like '2022-05%'
 group by p.product_name
 order by `total_sales` desc, p.product_id asc