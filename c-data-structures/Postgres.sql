_________________________________ (1)

1. Write a program code to calculate the area of a circle for a value of radius varying from 3 to 7. Store the radius and the corresponding value of the calculated area in an empty table named Areas with fields Radius and Area.

DO $$
DECLARE
    r INT;
    a DECIMAL(10,2);
BEGIN
    CREATE TABLE areas (radius INT, area DECIMAL(10,2));
    FOR r IN 3..7 LOOP
        a := PI() * r * r;
        INSERT INTO areas (radius, area) VALUES (r, a);
    END LOOP;
END $$;

_________________________________ (2) (PROCEDURE)

2.  Create a procedure to print Fibonacci numbers up to a limit, where the limit is passed as an argument.

CREATE OR REPLACE PROCEDURE print_fibonacci(n INT)
LANGUAGE plpgsql
AS $$
DECLARE
    a INT := 0;
    b INT := 1;
    c INT;
BEGIN
    RAISE NOTICE 'Fibonacci Series up to %:', n;

    WHILE a <=n LOOP
        RAISE NOTICE '%', a;
        c := a + b;
        a := b;
        b := c;
    END LOOP;
END;
$$;


To call the procedure :

CALL print_fibonacci(50);

_________________________________ (3) (PROCEDURE)

3. Create a procedure to print factorials of the numbers from 1 to 10.

CREATE OR REPLACE PROCEDURE print_factorials()
LANGUAGE plpgsql
AS $$
DECLARE
    i INT;
    j INT;
    fact BIGINT;
BEGIN
    RAISE NOTICE 'Factorials from 1 to 10:';

    FOR i IN 1..10 LOOP
        fact := 1;
        FOR j IN 1..i LOOP
            fact := fact*j;
        END LOOP;

        RAISE NOTICE 'Factorial of % is %', i, fact;
    END LOOP;
END;
$$;


To call the procedure :

CALL print_factorials();

_________________________________ (1)

1. Write a program block to calculate the electricity bill by accepting cust_no and units_consumed.

DO $$
DECLARE
    rate INT;
    amt INT;
    u INT := 300;
    c INT := 1234;
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
    RAISE NOTICE 'Customer_no: % | Unit Consumed: % | Bill Amount: %',c,u,amt;
END $$;


_________________________________ (2) (FUNCTION)

2. Create a function to check whether a given number is prime or not.

CREATE OR REPLACE FUNCTION is_prime(n INT)
RETURNS BOOLEAN
LANGUAGE plpgsql
AS $$
DECLARE
    i INT;
BEGIN
    IF n < 2 THEN
        RETURN FALSE;
    END IF;

    FOR i IN 2..FLOOR(SQRT(n)) LOOP
        IF n % i = 0 THEN
            RETURN FALSE;
        END IF;
    END LOOP;

    RETURN TRUE;
END;
$$;

Select the function 

SELECT is_prime(7);