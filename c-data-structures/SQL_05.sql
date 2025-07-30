1. Create a table customer (cust_no varchar(5), cust_name varchar(15), age number, phone varchar (10))

Table: customer

Table Structure :
| Field Name | Data Type        | Description     |
| ---------- | ---------------- | --------------- |
| cust_no    | VARCHAR (5)      | Customer ID     |
| cust_name  | VARCHAR (15)     | Customer Name   |
| age        | INT              | Age of customer |
| phone      | VARCHAR (10)     | Phone number    |

-- a) Create the customer table
CREATE TABLE customer (
    cust_no VARCHAR(5),
    cust_name VARCHAR(15),
    age INT,
    phone VARCHAR(10)
);

-- Insert 5 records
INSERT INTO customer VALUES
('C001', 'Anu', 23, '9876543210'),
('C002', 'Ben', 31, '9123456789'),
('C003', 'Ciya', 29, '9786543210'),
('C004', 'Dan', 35, '9345671234'),
('C005', 'Esha', 28, '9998877665');

-- Display all records
SELECT * FROM customer;

-- b) Add a new field 'd_birth' with DATE datatype
ALTER TABLE customer ADD d_birth DATE;

-- c) Create another table cust_phone with fields cust_name and phone from customer
CREATE TABLE cust_phone AS
SELECT cust_name, phone FROM customer;

-- d) Remove the field 'age'
ALTER TABLE customer DROP COLUMN age;

-- e) Change the size of 'cust_name' to 25
ALTER TABLE customer ALTER COLUMN cust_name TYPE VARCHAR(25);

-- f) Delete all the records from the table
DELETE FROM customer;

-- g) Rename the table customer to cust
ALTER TABLE customer RENAME TO cust;

-- h) Drop the table
DROP TABLE cust;



2. Create A Table Employee With Fields (EmpID, EName, Salary, Department, and Age). Insert Some Records. Write SQL Queries Using Aggregate Functions And Group By Clause.

Table: employee

Table Structure :
| Field Name | Data Type   | Description            |
| ---------- | ----------- | ---------------------- |
| EmpID      | INT         | Employee ID            |
| EName      | VARCHAR(25) | Employee Name          |
| Salary     | INT         | Salary of the employee |
| Department | VARCHAR(20) | Department name        |
| Age        | INT         | Age of employee        |


-- Create employee table
CREATE TABLE employee (
    EmpID INT,
    EName VARCHAR(25),
    Salary INT,
    Department VARCHAR(20),
    Age INT
);

-- Insert sample records
INSERT INTO employee VALUES
(101, 'Alice', 50000, 'Sales', 30),
(102, 'Bob', 60000, 'HR', 45),
(103, 'Charlie', 70000, 'Sales', 38),
(104, 'Diana', 80000, 'IT', 29),
(105, 'Eve', 55000, 'HR', 50);

-- A. Display the total number of employees
SELECT COUNT(*) AS total_employees FROM employee;

-- B. Name and age of the oldest employee of each department
SELECT Department, EName, Age
FROM employee e1
WHERE Age = (
    SELECT MAX(Age) FROM employee e2 WHERE e1.Department = e2.Department
);

-- C. Average age of employees in each department
SELECT Department, AVG(Age) AS avg_age
FROM employee
GROUP BY Department;

-- D. Departments and their average salaries
SELECT Department, AVG(Salary) AS avg_salary
FROM employee
GROUP BY Department;

-- E. Lowest salary in employee table
SELECT MIN(Salary) AS lowest_salary FROM employee;

-- F. Highest salary in Sales department
SELECT MAX(Salary) AS highest_salary_sales
FROM employee
WHERE Department = 'Sales';
