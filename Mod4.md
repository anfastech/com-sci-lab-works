To prepare you for your exam, let's go through the key concepts and commands of SQL as covered in the provided module notes.

### 1. Introduction to SQL Concepts

**SQL** (pronounced "ess-que-el") stands for **Structured Query Language** [1]. It was initially created in the 1970s and is the standard language for relational database management systems, according to ANSI (American National Standards Institute) [1]. SQL is used to **communicate with a database** [1].

Database administrators, developers writing data integration scripts, and data analysts setting up analytical queries all regularly use SQL [1]. SQL statements are employed to perform tasks such as updating or retrieving data from a database [2]. While most database systems utilize SQL, they often have their own proprietary extensions. However, standard SQL commands like "Select", "Insert", "Update", "Delete", "Create", and "Drop" are widely used to manage databases [2].

**Key capabilities of SQL include** [3]:
*   Executing queries against a database [3].
*   Retrieving data from a database [3].
*   Inserting, updating, and deleting records in a database [3].
*   Creating new databases, tables, stored procedures, and views [3].
*   Setting permissions on tables, procedures, and views [3].

### 2. Types of SQL Commands

SQL commands are categorized based on the functions they perform, such as building database objects, manipulating objects, populating tables, updating data, deleting data, performing queries, controlling access, and overall database administration [4].

*   **Data Definition Language (DDL)**:
    *   DDL is the part of SQL that allows a database user to **create and restructure database objects**, like tables [4].
    *   Fundamental DDL commands include [5]:
        *   `CREATE TABLE` [5]
        *   `ALTER TABLE` [5]
        *   `DROP TABLE` [5]
        *   `CREATE INDEX` [5]
        *   `ALTER INDEX` [5]
        *   `DROP INDEX` [5]
        *   `CREATE VIEW` [5]
        *   `DROP VIEW` [5]

*   **Data Manipulation Language (DML)**:
    *   DML is the part of SQL used to **manipulate data within objects** of a relational database [5].
    *   The three basic DML commands are [5]:
        *   `INSERT` [5]
        *   `UPDATE` [5]
        *   `DELETE` [5]

*   **Data Query Language (DQL)**:
    *   DQL, though comprising only one base command, is a central focus for modern relational database users [5, 6].
    *   The base command is `SELECT` [6].
    *   This command, along with options and clauses, is used to compose queries against a relational database [6]. A **query** is an inquiry to the database for information [6].

*   **Data Control Language (DCL)**:
    *   DCL commands in SQL allow you to **control access to data** within the database [6, 7].
    *   These commands are typically used to create objects related to user access and manage privilege distribution among users [7].
    *   Some DCL commands include [7]:
        *   `ALTER PASSWORD` [7]
        *   `GRANT` [7]
        *   `REVOKE` [7]
        *   `CREATE SYNONYM` [7]

*   **Transactional Control Commands**:
    *   These commands allow the user to **manage database transactions** [7].
    *   Key commands are [7, 8]:
        *   `COMMIT`: Saves database transactions [7].
        *   `ROLLBACK`: Undoes database transactions [7].
        *   `SAVEPOINT`: Creates points within groups of transactions to which you can `ROLLBACK` [8].
        *   `SET TRANSACTION`: Places a name on a transaction [8].

### 3. SQL Data Types

Data types define the kind of values that can be stored in a column.

*   **CHARACTER [(length)] or CHAR [(length)]**:
    *   Accepts character strings, including Unicode, of a fixed length [8].
    *   The length `n` must be specified, e.g., `CHARACTER(n)`. If no length is specified, the default is 1 [8].
    *   Minimum length is 1, and maximum can be up to the table page size. Strings larger than page size can be stored as a Character Large Object (CLOB) [9].
    *   `CHARACTER(0)` is not allowed [9].
    *   Examples: `CHAR(10)` or `CHARACTER(10)` can store 'Race car', 'RACECAR ', '24865', '1998-10-25' [9]. Blank characters are truncated [9].

*   **BOOLEAN**:
    *   Supports the storage of two values: **TRUE** or **FALSE** [9].
    *   No parameters are required for declaration [9].
    *   Use case-insensitive keywords `TRUE` or `FALSE` to assign values or for comparisons [10]. Assigning any other value raises an error [10].
    *   Examples: `TRUE`, `true`, `True`, `False` are valid. `1`, `0`, `Yes`, `No` are invalid [10].

### 4. Database and Table Operations

These commands fall under DDL and are used to manage the structure of your database.

*   **`CREATE DATABASE`**:
    *   Used to create a new SQL database [10].
    *   Syntax: `CREATE DATABASE databasename;` [10]
    *   Example: `CREATE DATABASE testDB;` [11]

*   **`DROP DATABASE`**:
    *   Used to drop (delete) an existing SQL database [11].
    *   Syntax: `DROP DATABASE databasename;` [11]
    *   Example: `DROP DATABASE testDB;` [11]

*   **`CREATE TABLE`**:
    *   Used to create a new table in a database [11].
    *   Syntax: `CREATE TABLE table_name (column1 datatype, column2 datatype, ...);` [11]
    *   Example: `CREATE TABLE Persons(PersonID int, LastName varchar(255), FirstName varchar(255), Address varchar(255), City varchar(255));` [11]

*   **`DROP TABLE`**:
    *   Used to drop (delete) an existing table in a database [12].
    *   **Caution**: Deleting a table results in the loss of all information stored in it [12].
    *   Syntax: `DROP TABLE table_name;` [12]
    *   Example: `DROP TABLE Shippers;` [12]

*   **`TRUNCATE TABLE`**:
    *   Used to delete **data inside a table**, but **not the table itself** [12].
    *   Syntax: `TRUNCATE TABLE table_name;` [12]

*   **`ALTER TABLE`**:
    *   Used to **add, delete, or modify columns** in an existing table [13, 14].
    *   Also used to **add and drop various constraints** on an existing table [13, 14].
    *   **ADD Column**: `ALTER TABLE table_name ADD column_name datatype;` [14]
        *   Example: `ALTER TABLE Persons ADD DateOfBirth date;` [14]
    *   **DROP COLUMN**: `ALTER TABLE table_name DROP COLUMN column_name;` (Note: Some database systems may not allow this) [15]
    *   **ALTER/MODIFY COLUMN (Change Data Type)**: `ALTER TABLE table_name ALTER COLUMN column_name datatype;` or `ALTER TABLE table_name MODIFY COLUMN column_name datatype;` [15]

*   **`SQL RENAME`**:
    *   Used to **change the name of a table** or a database object [15].
    *   If you change an object's name, any existing references to the old name must be manually updated [15].
    *   Syntax: `RENAME old_table_name TO new_table_name;` [16]
    *   Example: `RENAME employee TO my_employee;` [16]

### 5. SQL Constraints

Constraints are rules applied to the type of data in a table, specifying limits on what can be stored in a particular column [16]. They can be specified when creating a table (`CREATE TABLE`) or after creation (`ALTER TABLE`) [17].

*   **`NOT NULL`**:
    *   Ensures a field will **never accept a null value** [18]. You cannot insert a new row without providing a value for this field [18].
    *   Example: `CREATE TABLE Student(ID int(6) NOT NULL, NAME varchar(10) NOT NULL, ADDRESS varchar(20));` [18]

*   **`UNIQUE`**:
    *   Helps to **uniquely identify each row** in the table; all rows for a particular column must have unique values [19].
    *   A table can have more than one `UNIQUE` column [19].
    *   Example: `CREATE TABLE Student(ID int(6) NOT NULL UNIQUE, NAME varchar(10), ADDRESS varchar(20));` [19]

*   **`PRIMARY KEY`**:
    *   A field that **uniquely identifies each row** in the table [19].
    *   A primary key field cannot contain `NULL` values and all rows must have unique values for this field [20]. It's a combination of `NOT NULL` and `UNIQUE` constraints [20].
    *   A table can have **only one primary key** [20].
    *   Example: `CREATE TABLE Student(ID int(6) NOT NULL UNIQUE, NAME varchar(10), ADDRESS varchar(20), PRIMARY KEY(ID));` [20]

*   **`FOREIGN KEY`**:
    *   A field in one table that uniquely identifies each row of **another table** [21]. This field points to the primary key of another table, creating a link between tables [21].
    *   Example: In the `Orders` table, `C_ID` is a foreign key referencing the `C_ID` (primary key) in the `Customers` table [21, 22].
    *   Syntax: `FOREIGN KEY (C_ID) REFERENCES Customers(C_ID)` [22]

*   **`CHECK`**:
    *   Allows you to specify a **condition for a field** that must be satisfied when entering values for that field [22].
    *   Example: `CREATE TABLE Student(ID int(6) NOT NULL, NAME varchar(10) NOT NULL, AGE int NOT NULL CHECK (AGE >= 18));` This prevents entering an age less than 18 [22, 23].

*   **`DEFAULT`**:
    *   Provides a **default value for a field** [23]. If a user does not specify a value for this field when inserting new records, the default value will be assigned [23].
    *   Example: `CREATE TABLE Student(ID int(6) NOT NULL, NAME varchar(10) NOT NULL, AGE int DEFAULT 18);` [24]

### 6. SQL Statements and Clauses

These are core components for interacting with data.

*   **`SELECT` Statement**:
    *   Used to **select data from a database** [12]. The returned data is stored in a result table, called the result-set [25].
    *   Syntax: `SELECT column1, column2, ... FROM table_name;` [25]
    *   To select all fields: `SELECT * FROM table_name;` [25]
    *   `DISTINCT` keyword selects only unique values for a column [25].
        *   Example: `SELECT DISTINCT Country FROM Customers;` [25]

*   **`WHERE` Clause**:
    *   Used to **filter records** and extract only those that fulfill a specified condition [25].
    *   Syntax: `SELECT column1, column2, ... FROM table_name WHERE condition;` [25]
    *   Text values require single quotes (e.g., `'Mexico'`), while numeric fields do not (e.g., `CustomerID=1`) [26].
    *   **Operators in `WHERE` Clause**:
        *   **`AND`**: Displays a record if **all** conditions separated by `AND` are `TRUE` [26, 27].
            *   Example: `SELECT * FROM Customers WHERE Country='Germany' AND City='Berlin';` [27]
        *   **`OR`**: Displays a record if **any** of the conditions separated by `OR` is `TRUE` [27].
            *   Example: `SELECT * FROM Customers WHERE City='Berlin' OR City='München';` [27]
        *   **`NOT`**: Displays a record if the condition(s) is `NOT TRUE` [28].
            *   Example: `SELECT * FROM Customers WHERE NOT Country='Germany';` [28]
        *   `AND`, `OR`, and `NOT` can be combined [28].

*   **`ORDER BY` Keyword**:
    *   Used to **sort the result-set** in ascending (`ASC`, default) or descending (`DESC`) order [28, 29].
    *   Syntax: `SELECT column1, column2, ... FROM table_name ORDER BY column1, column2, ... ASC|DESC;` [29]
    *   Example (Ascending): `SELECT * FROM Customers ORDER BY Country;` [29]
    *   Example (Descending): `SELECT * FROM Customers ORDER BY Country DESC;` [29]
    *   Can sort by multiple columns: `SELECT * FROM Customers ORDER BY Country, CustomerName;` [30]

*   **`INSERT INTO` Statement**:
    *   Used to **insert new records** into a table [30].
    *   **Two ways to write it**:
        1.  **Specify column names and values**: `INSERT INTO table_name (column1, column2, ...) VALUES (value1, value2, ...);` [30]
            *   Example: `INSERT INTO Customers(CustomerName, ContactName, Address, City, PostalCode, Country) VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');` [31]
        2.  **Specify only values (for all columns, order must match table definition)**: `INSERT INTO table_name VALUES (value1, value2, ...);` [31]

*   **`UPDATE` Statement**:
    *   Used to **modify existing records** in a table [32].
    *   The `WHERE` clause is crucial to specify which records to update [32]. Without it, all records in the table will be updated [32].
    *   Syntax: `UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;` [32]
    *   Example: `UPDATE Customers SET ContactName = 'Alfred Schmidt', City = 'Frankfurt' WHERE CustomerID = 1;` [32]

*   **`DELETE` Statement**:
    *   Used to **delete existing records** from a table [13].
    *   The `WHERE` clause determines which records will be deleted [13]. Without it, all records in the table will be deleted (similar to `TRUNCATE` but logs individual row deletions) [13].
    *   Syntax: `DELETE FROM table_name WHERE condition;` [13]
    *   Example: `DELETE FROM Customers WHERE CustomerName='Alfreds Futterkiste';` [13]

### 7. SQL Functions

SQL provides various functions to perform operations on data.

*   **Aggregate Functions**:
    *   These functions group values of multiple rows based on certain criteria to form a single, meaningful value [24]. They are commonly used with the `GROUP BY` clause.
    *   **`AVG()`**: Returns the average value of a numeric column [24].
        *   Example: `SELECT AVG(salary) FROM Emp;` [33]
    *   **`COUNT()`**: Returns the number of rows [33]. Can be based on a condition or count distinct values [33, 34].
        *   Example: `SELECT COUNT(name) FROM Emp WHERE salary = 8000;` [34]
        *   Example (Distinct): `SELECT COUNT(DISTINCT salary) FROM emp;` [34]
    *   **`FIRST()`**: Returns the first value of a selected column [34, 35].
        *   Example: `SELECT FIRST(salary) FROM Emp;` [35]
    *   **`LAST()`**: Returns the last value of the selected column [35, 36].
        *   Example: `SELECT LAST(salary) FROM emp;` [36]
    *   **`MAX()`**: Returns the maximum value from a selected column [36].
        *   Example: `SELECT MAX(salary) FROM emp;` [37]
    *   **`MIN()`**: Returns the minimum value from a selected column [37].
        *   Example: `SELECT MIN(salary) FROM emp;` [38]
    *   **`SUM()`**: Returns the total sum of a selected numeric column's values [38].
        *   Example: `SELECT SUM(salary) FROM emp;` [38]

*   **Built-in Functions**:
    *   SQL has many built-in functions categorized as **String**, **Numeric**, and **Date functions** [38, 39].
    *   **String Functions** are used to perform operations on input strings and return an output string [39]. Examples include:
        *   `ASCII()`: Finds the ASCII value of a character [39].
        *   `CHAR_LENGTH()` / `LENGTH()` / `CHARACTER_LENGTH()`: Find the length of a string/word [39, 40].
        *   `CONCAT()`: Adds two words or strings [41].
        *   `CONCAT_WS()`: Adds strings with a specified concatenating symbol [41].
        *   `INSTR()`: Finds the occurrence of a character/substring [42].
        *   `LCASE()` / `LOWER()`: Converts a string to lower case [40, 43].
        *   `LEFT()`: Selects a substring from the left of a given size [40].
        *   `LOCATE()`: Finds the nth position of a word in a string [43].
        *   `LPAD()`: Pads a string on the left to a given size with a specified symbol [43].
        *   `LTRIM()`: Removes a substring from the left of the original string [44].
        *   `MID()`: Finds a word from a given position and size [44].
        *   `POSITION()`: Finds the position of the first occurrence of an alphabet [44].
        *   `REPEAT()`: Repeats a given string a specified number of times [44].
        *   `REPLACE()`: Replaces occurrences of a substring within a string [45].
        *   `REVERSE()`: Reverses a string [45].
        *   `RIGHT()`: Selects a substring from the right end of a given size [45].
        *   `RPAD()`: Pads a string on the right to a given size with a specified symbol [46].
        *   `RTRIM()`: Removes a substring from the right of the original string [46].
        *   `SPACE()`: Writes a given number of spaces [46].
        *   `STRCMP()`: Compares two strings, returning 0 (same), -1 (string1 smaller), or 1 (string1 larger) [46, 47].
        *   `SUBSTR()` / `SUBSTRING()`: Find a substring from a string from a given position [47].
        *   `SUBSTRING_INDEX()`: Finds a substring before a given symbol [47].
        *   `TRIM()`: Cuts a given symbol from the string [48].
        *   `UCASE()`: Makes a string upper case [48].

### 8. Set Operations

SQL set operations are used for **combining data from one or more tables** [48]. Each `SELECT` statement used with these operators must have the **same number of columns**, columns with **similar data types**, and columns in the **same order** [49].

*   **`UNION` / `UNION ALL`**:
    *   **`UNION`**: Combines the result-set of two or more `SELECT` queries and **removes duplicate values** [49, 50].
    *   **`UNION ALL`**: Combines results and **allows duplicate values** [50].

*   **`INTERSECT`**:
    *   Combines result-sets and returns **only those values that are common** in both result sets [51]. It does not consider duplicate values [51].

*   **`MINUS`**:
    *   Subtracts the result set obtained by the second `SELECT` query from the first [52].
    *   Returns **only those rows which are unique in the first `SELECT` query** and not common to both [52].

### 9. Subqueries

A **Subquery** is a query embedded within another query [53]. The outer query is called the **main query**, and the inner query is the **subquery** [54].

*   **Important Rules for Subqueries**:
    *   Can be placed in `WHERE`, `HAVING`, and `FROM` clauses [54].
    *   Can be used with `SELECT`, `UPDATE`, `INSERT`, `DELETE` statements along with expression or comparison operators (`=`, `>`, `>=`, `<=`, `LIKE`) [54].
    *   The subquery generally **executes first**, and its output is used for the main query's condition [54].
    *   Must be **enclosed in parentheses** [54].
    *   Are typically on the **right side of the comparison operator** [55].
    *   `ORDER BY` cannot be used in a subquery, but `GROUP BY` can achieve similar functionality [55].
    *   Use single-row operators with single-row subqueries and multiple-row operators with multiple-row subqueries [55].

*   **Syntax Example with `SELECT`**:
    ```sql
    SELECT column_name
    FROM table_name
    WHERE column_name expression operator ( SELECT COLUMN_NAME from TABLE_NAME WHERE ... );
    ```
    *   Example: To display name, location, phone number of students from `DATABASE` table whose section is 'A' [56].
        ```sql
        SELECT NAME, LOCATION, PHONE_NUMBER from DATABASE
        WHERE ROLL_NO IN (SELECT ROLL_NO from STUDENT where SECTION='A');
        ```
        The inner query first gets `ROLL_NO`s for section 'A', then the outer query uses these `ROLL_NO`s to fetch details [57].

*   **`INSERT` with Subquery**:
    *   Example: `INSERT INTO Student1 ( SELECT * FROM Student2);` This inserts all rows from `Student2` into `Student1` [58].

*   **`DELETE` with Subquery**:
    *   Example: `DELETE FROM Student2 WHERE ROLL_NO IN (SELECT ROLL_NO FROM Student1 WHERE LOCATION = 'chennai');` This deletes students from `Student2` whose roll numbers exist in `Student1` and have 'chennai' location [59].

*   **`UPDATE` with Subquery**:
    *   Example: `UPDATE Student2 SET NAME='geeks' WHERE LOCATION IN ( SELECT LOCATION FROM Student1 WHERE NAME IN ('Raju','Ravi'));` This updates names in `Student2` based on locations found in `Student1` for 'Raju' or 'Ravi' [59, 60].

### 10. SQL Correlated Subqueries

Correlated subqueries are used for **row-by-row processing** [60]. Each subquery is executed **once for every row of the outer query** [60].

*   A correlated subquery is evaluated for each row processed by the parent `SELECT`, `UPDATE`, or `DELETE` statement [60].
*   It's useful when a subquery needs to return a different result set for each candidate row considered by the main query [61].
*   **Nested vs. Correlated Subqueries**:
    *   A normal nested subquery runs once, returning values for the main query [62].
    *   A correlated subquery executes for **each candidate row of the outer query**, meaning the inner query is driven by the outer query [62].
*   Can also use `ANY` and `ALL` operators in correlated subqueries [62].

*   **Example (Correlated `SELECT`)**: Find employees earning more than their department's average salary [62, 63].
    ```sql
    SELECT last_name, salary, department_id
    FROM employees outer
    WHERE salary > (SELECT AVG(salary) FROM employees WHERE department_id = outer.department_id);
    ```
    Here, `outer.department_id` links the inner query to the current row being processed by the outer query [63].

*   **Correlated `UPDATE`**: Update rows in one table based on rows from another [63].
    ```sql
    UPDATE table1 alias1 SET column = (SELECT expression FROM table2 alias2 WHERE alias1.column = alias2.column);
    ```

*   **Correlated `DELETE`**: Delete rows in one table based on rows from another [63].
    ```sql
    DELETE FROM table1 alias1 WHERE column1 operator (SELECT expression FROM table2 alias2 WHERE alias1.column = alias2.column);
    ```

*   **Using the `EXISTS` Operator**:
    *   Tests for the **existence of rows** in the subquery's result set [64].
    *   If a row is found, the condition is `TRUE`, and the search stops [64]. If not found, the condition is `FALSE` [64].
    *   Example (`EXISTS`): Find employees with at least one person reporting to them [64, 65].
        ```sql
        SELECT employee_id, last_name, job_id, department_id
        FROM employees outer
        WHERE EXISTS ( SELECT 'X' FROM employees WHERE manager_id = outer.employee_id);
        ```
    *   Example (`NOT EXISTS`): Find departments with no employees [65].
        ```sql
        SELECT department_id, department_name FROM departments d
        WHERE NOT EXISTS (SELECT 'X' FROM employees WHERE department_id= d.department_id);
        ```

### 11. `GROUP BY` Clause

The `GROUP BY` clause is used with the `SELECT` statement to **organize similar data into groups** [65]. It combines multiple records in one or more columns using aggregate functions (like `min()`, `max()`, `avg()`, `count()`, `sum()`) [66]. It uses a **split-apply-combine** strategy [66]:
*   **Split phase**: Divides data into groups [66].
*   **Apply phase**: Applies the aggregate function to each group, generating a single value [66].
*   **Combine phase**: Combines the groups with single values into a single result [66].

*   **Points to Remember**:
    *   Always used with `SELECT` [66].
    *   Aggregates results based on selected columns using aggregate functions [67].
    *   Returns only one result per group of data [67].
    *   Always follows the `WHERE` clause [67].
    *   Always precedes the `ORDER BY` clause [67].
    *   Example: `SELECT name, SUM(sal) FROM emp GROUP BY name;` [67]

### 12. `HAVING` Clause

The `HAVING` clause is used as a **conditional clause with the `GROUP BY` clause** [67]. It returns rows only where aggregate function results match given conditions [68].

*   **Distinction from `WHERE`**:
    *   `WHERE` clause deals with **non-aggregated or individual records** [68].
    *   `HAVING` clause restricts data on **group records** rather than individual records [68].
*   `WHERE` and `HAVING` can be used in the same query [68].
*   Example: To group by `DeptID` and filter groups where `AVG(Salary) > 3000` [68, 69].

### 13. JOINs and Their Types

A SQL `JOIN` statement is used to **combine data or rows from two or more tables** based on a common field between them [69].

*   **Types of Joins**:

    1.  **`INNER JOIN`**:
        *   Selects all rows from both tables as long as the join condition is satisfied [69].
        *   Combines rows where the common field has the **same value** in both tables [70].
        *   `JOIN` is synonymous with `INNER JOIN` [70].
        *   Syntax: `SELECT table1.column1, table2.column1 FROM table1 INNER JOIN table2 ON table1.matching_column = table2.matching_column;` [70]
        *   Example: `SELECT StudentCourse.COURSE_ID, Student.NAME, Student.AGE FROM Student INNER JOIN StudentCourse ON Student.ROLL_NO = StudentCourse.ROLL_NO;` [71]

    2.  **`LEFT JOIN` (or `LEFT OUTER JOIN`)**:
        *   Returns **all rows from the left table** and matching rows from the right table [71].
        *   If no match is found on the right side, the result-set will contain `NULL` values for the right table's columns [71].
        *   Syntax: `SELECT table1.column1, table2.column1 FROM table1 LEFT JOIN table2 ON table1.matching_column = table2.matching_column;` [72]

    3.  **`RIGHT JOIN` (or `RIGHT OUTER JOIN`)**:
        *   Returns **all rows from the right table** and matching rows from the left table [72, 73].
        *   If no match is found on the left side, the result-set will contain `NULL` values for the left table's columns [73].
        *   Syntax: `SELECT table1.column1, table2.column1 FROM table1 RIGHT JOIN table2 ON table1.matching_column = table2.matching_column;` [73]

    4.  **`FULL JOIN` (or `FULL OUTER JOIN`)**:
        *   Combines the results of both `LEFT JOIN` and `RIGHT JOIN` [74].
        *   The result-set contains **all rows from both tables** [74].
        *   For rows where there is no matching record in the other table, the columns from that table will contain `NULL` values [74].
        *   Syntax: `SELECT table1.column1, table2.column1 FROM table1 FULL JOIN table2 ON table1.matching_column = table2.matching_column;` [74, 75]

### 14. Views in SQL

Views in SQL are considered **virtual tables** [75]. They do not store data themselves but represent the data from one or more underlying tables [75].

*   **Creation of a View**:
    *   A view can be created from a single table or multiple tables using the `CREATE VIEW` statement [76].
    *   Syntax: `CREATE VIEW view_name AS SELECT column1, column2 FROM table_name WHERE condition;` [76]
    *   **From a single table**: You can select specific columns and rows.
        *   Example: `CREATE VIEW DetailsView AS SELECT NAME, ADDRESS FROM Student_Details WHERE STU_ID < 4;` [77]
    *   **From multiple tables**: You include multiple tables in the `SELECT` statement, usually with a join condition [77].
        *   Example: `CREATE VIEW MarksView AS SELECT Student_Detail.NAME, Student_Detail.ADDRESS, Student_Marks.MARKS FROM Student_Detail, Student_Mark WHERE Student_Detail.NAME = Student_Marks.NAME;` [78]
    *   You can query a view just like a table: `SELECT * FROM DetailsView;` [77]

*   **Deleting a View**:
    *   A view can be deleted using the `DROP VIEW` statement [78].
    *   Syntax: `DROP VIEW view_name;` [78]
    *   Example: `DROP VIEW MarksView;` [79]

This comprehensive overview covers the core SQL concepts, commands, and features detailed in your module notes. Good luck with your exam!
