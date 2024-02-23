-- 2022년 1월의 도서 판매 데이터를 기준으로 
-- 저자 별, 카테고리 별 매출액(TOTAL_SALES = 판매량 * 판매가) 을 구하여, 저자 ID(AUTHOR_ID), 저자명(AUTHOR_NAME), 카테고리(CATEGORY), 매출액(SALES) 리스트를 출력하는 SQL문을 작성해주세요.
-- 결과는 저자 ID를 오름차순으로, 저자 ID가 같다면 카테고리를 내림차순 정렬해주세요.

select a.author_id, a.author_name, b.category, sum(b.price * s.sales) as total_sales
  from (select book_id, sales_date, sales
          from book_sales
         where sales_date like '2022-01%'
       ) as s
  join book as b
    on b.book_id = s.book_id
  join author as a
    on a.author_id = b.author_id
 group by a.author_id, b.category
 order by a.author_id asc, b.category desc