-- 회원 ID와 상품 ID를 조회하고 싶음
select user_id, product_id from online_sale
-- 회원ID와 상품ID를 묶어서 카운트한 결과가 2개 이상인 것으로만 조회
group by user_id, product_id having count(*) > 1
-- 회원ID는 오름차순, 상품ID는 내림차순으로 정렬
order by user_id, product_id desc;