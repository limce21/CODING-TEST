-- 코드를 입력하세요
select category, price max_price, product_name
from food_product
where (category, price) in (select category, max(price)
                   from food_product
                   where category in ('국','김치','과자','식용유')
                   group by category
                   )
order by price desc