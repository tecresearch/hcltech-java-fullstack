create table transactions(
transaction_id serial primary key ,
user_id int,
payment_ethod varchar(255),
amount decimal(10,2),
transaction_date date,
status varchar(255)
);

INSERT INTO transactions VALUES
(102, 203, 'Debit Card', 150.00, '2025-03-01', 'Failed'),
(103, 204, 'PayPal', 350.75, '2025-04-10', 'Pending'),
(104, 203, 'Bank Transfer', 500.00, '2025-05-05', 'Failed'),
(105, 203, 'Cash', 100.00, '2025-06-12', 'Failed'),
(106, 203, 'Credit Card', 250.50, '2025-07-22', 'Failed'),
(107, 203, 'Credit Card', 75.25, '2025-08-30', 'Failed'),
(108, 203, 'Credit Card', 300.10, '2025-09-15', 'Failed'),
(109, 210, 'Debit Card', 180.80, '2025-10-01', 'Completed'),
(110, 211, 'Wire Transfer', 400.00, '2025-11-20', 'Completed');
truncate transactions;



select user_id , count(status) as failed_transactions,count( distinct payment_ethod) as distinct_payment_methods 
from transactions
where  status='Failed' and (select count(status) from transactions where status='Failed')>5
group by user_id;


 --using subquery

SELECT user_id, (
    SELECT count(distinct payment_ethod) as distinct_payment_methods
)
, 
(
    SELECT  COUNT(status) AS failed_transactions
)
FROM transactions
WHERE status = 'Failed'
GROUP BY user_id;


--Using Comon Table Expressions

WITH failed_transaction AS (
    SELECT user_id, count(distinct payment_ethod) as distinct_payment_methods
    FROM transactions
    WHERE status = 'Failed'
	group by user_id
),
status_count AS (
    SELECT user_id, COUNT(status) AS failed_transactions
    FROM transactions
    WHERE status = 'Failed'
    GROUP BY user_id
)


SELECT ft.user_id, ft.distinct_payment_methods, sc.failed_transactions
FROM failed_transaction ft, status_count sc;


--using functions
select * from transactions;

CREATE OR REPLACE FUNCTION status_count()
RETURNS int AS $$
DECLARE
    failed_count integer;
BEGIN
    SELECT count(status) INTO failed_count FROM transactions WHERE status='Failed';
    RETURN failed_count;
END;
$$ LANGUAGE plpgsql;

(select status_count());

select user_id , (select status_count()) as failed_transactions,count( distinct payment_ethod) as distinct_payment_methods 
from transactions
where  status='Failed' and (select status_count())>5
group by user_id;



select user_id, count(status) as failed_transactions, count( distinct payment_ethod) as failed_payment_methods
from transactions t
group by user_id
HAVING count(t.status)>5;


select * from transactions;





