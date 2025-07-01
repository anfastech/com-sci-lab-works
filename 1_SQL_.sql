CREATE TABLE customer (
    cust_id VARCHAR(5),
    cust_name VARCHAR(15),
    age numeric,
    phone VARCHAR(10)
);

INSERT INTO customer VALUES ('00001', 'John Doe', 30, '123456789'), ('00002', 'Jane Smith', 25, '987654321'),( '00003', 'Alice Johnson', 28, '555123456'), ('00004', 'Bob Brown', 35, '444987654');


ALTER TABLE customer ADD d_birth DATE;


UPDATE customer SET d_birth = '1990-01-01' WHERE cust_id = '00001';
UPDATE customer SET d_birth = '1995-05-05' WHERE cust_id = '00002';
UPDATE customer SET d_birth = '1992-03-03' WHERE cust_id = '00003';
UPDATE customer SET d_birth = '1988-07-15' WHERE cust_id = '00004';

TRUNCATE TABLE customer;

CREATE TABLE cust_phone AS SELECT cust_name, phone FROM customer;

-----------------------------------------------------------------

CREATE TABLE sales_man (salesman_no INT PRIMARY KEY, s_name VARCHAR(10) NOT NULL, place VARCHAR(10), phone NUMERIC(10) UNIQUE );

INSERT INTO sales_man VALUES 
        (1, 'Sam Lee', 'NYC', 1234567890),
        (2, 'Eva Kim', 'LA', 2345678901),
        (3, 'Tom Fox', 'CHI', 3456789012),
        (4, 'Nina Ray', 'DAL', 4567890123),
        (5, 'Paul Sun', 'SEA', 5678901234);


ALTER TABLE sales_man DROP CONSTRAINT sales_man_phone_key;
ALTER TABLE sales_man DROP CONSTRAINT sales_man_pkey;

ALTER TABLE sales_man ADD PRIMARY KEY (salesman_no);
ALTER TABLE sales_man ADD FOREIGN KEY (salesman_no) REFERENCES sales_man (salesman_no);


CREATE TABLE sales_order (
    order_no INT PRIMARY KEY,
    order_date DATE,
    order_status VARCHAR(10),
    salesman_no INT,
    del_type CHAR(1),
    FOREIGN KEY (salesman_no) REFERENCES sales_man(salesman_no)
);

INSERT INTO sales_order (order_no, order_date, order_status, salesman_no, del_type ) VALUES
    (101, '2024-06-01', 'Pending', 1, 'F'),
    (102, '2024-06-02', 'Shipped', 2, 'P'),
    (103, '2024-06-03', 'Delivered', 3, 'F'),
    (104, '2024-06-04', 'Pending', 4, 'P'),
    (105, '2024-06-05', 'Shipped', 5, 'F');

ALTER TABLE sales_order ADD CHECK (del_type = 'F' OR del_type = 'P');

ALTER TABLE sales_order ADD CHECK (order_status IN ('Pending', 'Shipped', 'Delivered'));

SELECT order_no FROM sales_order WHERE order_date = '2024-06-04';
SELECT order_no FROM sales_order WHERE salesman_no > 3 AND del_type = 'P' ;

UPDATE sales_order SET del_type = 'P' WHERE salesman_no = 3;

DELETE FROM sales_order WHERE salesman_no = 5;

_________________________________________________________________________________________ POSTGRES

CREATE TABLE exam_result (
    rollno INT PRIMARY KEY,
    student_name VARCHAR(100),
    avg_score NUMERIC(5,2),
    grade CHAR(1)
);

INSERT INTO exam_result (rollno, student_name, avg_score) VALUES
(1, 'Alice Johnson', 95.5),
(2, 'Bob Smith', 82.0),
(3, 'Charlie Brown', 68.5),
(4, 'Diana Prince', 55.0),
(5, 'Evan Williams', 42.3),
(6, 'Fiona Green', 76.8),
(7, 'George Harris', 91.2),
(8, 'Hannah Clark', 62.7),
(9, 'Ian Scott', 49.9),
(10, 'Jenny Adams', 100.0);


DO $$
DECLARE
    rec record;
    grd char(1);
BEGIN
    FOR rec IN SELECT * FROM exam_result
    LOOP
        IF rec.avg_score BETWEEN 90 AND 100 THEN
            grd := 'A';
        ELSIF rec.avg_score BETWEEN 75 AND 89 THEN
            grd := 'B';
        ELSIF rec.avg_score BETWEEN 60 AND 74 THEN
            grd := 'C';
        ELSIF rec.avg_score BETWEEN 50 AND 59 THEN
            grd := 'D';
        ELSE
            grd := 'E';
        END IF;
        UPDATE exam_result SET grade = grd WHERE rollno = rec.rollno;
    END LOOP;
END $$;

_________________________________________________________________________________________ POSTGRES 2 (AREA)

DO $$ 
DECLARE
    r integer;
    ar numeric(10,2);
BEGIN
    CREATE TABLE areas (radius integer, area numeric(5,2));
    r := 3;
    FOR r IN 3..7 
    LOOP
        ar:= 3.14*r*r;
        INSERT INTO areas VALUES (r, ar);
    END LOOP;
END $$;

_________________________________________________________________________________________ POSTGRES 3 (ELECTRICITY)

DO $$
DECLARE
    rate int;
    amt int;
    u int := 300;  
    C int := 1234;
BEGIN
    IF u <= 100 THEN
        rate := 3;
    ELSIF u <= 250 THEN
        rate := 4;
    ELSIF u <= 500 THEN
        rate := 5;
    ELSE 
        rate := 6;
    END IF;
    amt := rate*u;
    RAISE NOTICE 'Customer_no: % | Units Consumed: % | Bill Amount: %', C, u, amt;  
END $$;

_________________________________________________________________________________________ POSTGRES 4 (FIBONACCI)

-- Create a table to store results
CREATE TABLE fibonacci_results (
    position int,
    value int
);

-- Generate and store Fibonacci numbers
DO $$
DECLARE
    a int := 1;
    b int := 0;
    c int := 0;
    n int := 20;
    counter int := 0;
BEGIN
    LOOP
        EXIT WHEN counter >= n;
        INSERT INTO fibonacci_results VALUES (counter, c);
        c := a + b;
        a := b;
        b := c;
        counter := counter + 1;
    END LOOP;
END $$;

-- View results
SELECT * FROM fibonacci_results ORDER BY position;

