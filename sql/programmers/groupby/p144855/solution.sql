-- 2022년 1월의 카테고리 별 도서 판매량을 합산하고
-- 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력하는 SQL문
-- 결과는 카테고리명을 기준으로 오름차순 정렬해주세요.

-- select b.category, sum(s.sales) as total_sales
--   from book_sales as s
--   join book as b
--     on s.book_id = b.book_id
--  where sales_date like '2022-01%'
--  group by b.category
--  order by b.category asc;

select b.category, sum(sales) as total_sales
from (select book_id, sales_date, sales
        from book_sales
       where sales_date like '2022-01%'
      ) as s
join book as b on b.book_id = s.book_id
group by b.category
order by b.category