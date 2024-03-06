-- PRODUCT 테이블과 OFFLINE_SALE 테이블에서 
-- 상품코드 별 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성해주세요. 
-- 결과는 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬해주세요.

select p.product_code, (p.price * sum(o.sales_amount)) as `sales`
  from product as p
  join offline_sale as o
    on p.product_id = o.product_id
 group by p.product_id
 order by `sales` desc, p.product_code