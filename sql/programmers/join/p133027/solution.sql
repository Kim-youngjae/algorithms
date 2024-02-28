-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이
-- 큰 순서대로 
-- 상위 3개의 맛을 조회하는 SQL 문을 작성해주세요.

-- 풀이1
select h.flavor
  from july as j
  join first_half as h
    on j.flavor = h.flavor
 group by j.flavor
 order by (sum(j.total_order) + h.total_order) desc 
 limit 3
 
 -- 풀이2
select t.flavor
  from(select h.flavor, sum(h.total_order + j.total_order) as `total`
         from july as j
         join first_half as h
           on h.flavor = j.flavor
        group by h.flavor
  ) as t
  order by `total` desc 
  limit 3