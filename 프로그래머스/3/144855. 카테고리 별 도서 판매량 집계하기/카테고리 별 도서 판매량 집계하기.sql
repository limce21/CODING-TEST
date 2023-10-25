-- 코드를 입력하세요
SELECT category, sum(sales) as TOTAL_SALES
from book
inner join book_sales
on book.book_id = book_sales.book_id
where sales_date >= '2022-01-01' and sales_date < '2022-02-01'
group by category
order by category