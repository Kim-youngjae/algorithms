select book_id, date_format(published_date, '%Y-%m-%d') as published_date
from book
where category = '인문' and published_date like '2021%'
order by published_date asc;