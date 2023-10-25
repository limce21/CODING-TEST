-- 코드를 입력하세요
SELECT book.author_id, author_name, category, sum(book_sales.sales * book.price) as total_sales
from author, book, book_sales
where author.author_id = book.author_id and book.book_id = book_sales.book_id
    and sales_date >= '2022-01-01' and sales_date < '2022-02-01'
group by author.author_id, book.category
order by author.author_id, book.category desc