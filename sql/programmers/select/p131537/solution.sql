Select Date_Format(sales_date, '%Y-%m-%d') As sales_date, product_id, user_id, sales_amount
  From ONLINE_SALE
 Group By sales_date, product_id, user_id, sales_amount
Having Year(sales_date) = '2022' and Month(sales_date) = '03'

Union All

Select Date_Format(sales_date, '%Y-%m-%d') As sales_date, product_id, NULL As user_id, sales_amount
  From OFFLINE_SALE
Group By sales_date, product_id, user_id, sales_amount
Having Year(sales_date) = '2022' and Month(sales_date) = '03'   

 Order By sales_date, product_id, user_id;