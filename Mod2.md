Given that your exam is today, let's go through the key concepts of Module 2 to help you prepare. This module focuses on the **Entity-Relationship (ER) Model**, **Relational Data Model**, **Integrity Rules**, **Relational Algebra**, and **SQL Joins** [1, 2].

---

### 1. Entity-Relationship (ER) Model

The **ER Data Model** is based on real-world objects and their relationships, serving as a foundational step for database design [3]. It helps you plan the database pictorially using **ER diagrams** [3]. An ER model is a **high-level data model** used to define data elements and their relationships for a specified system, developing a **conceptual design** for the database [4].

An ER diagram essentially breaks down requirements into **entities, attributes, and relationships** [4].

#### **A. Entities**
In a database, an **entity** (also known as a Table) groups related data under one name, helping identify where data is stored [5]. In the real world, every object forms an entity [6].
*   **Examples**: In a school database, `Student`, `Teacher`, `Subject`, and `Class` are entities. Each entity has its own group of related information, e.g., a `Student` has `ID`, `name`, `address`, `DOB`, `class` [6].
*   **Entity Set**: An **entity set** is a group of entities that possess the **same set of attributes** [6]. Each entity within an entity set has its own unique values for attributes, making it distinct [7]. In a database, an entity set is represented by a **Table** [7]. In an ER diagram, an entity set is always represented with a **rectangle**, while a single entity (instance) is not represented [7, 8].

**Types of Entities**:
*   **Strong Entity**:
    *   Not dependent on any other entity in the schema [8].
    *   Always has a **primary key** [8, 9].
    *   Represented by a **single rectangle** [8, 10].
    *   The relationship between two strong entities is represented by a **single diamond** [8, 10].
    *   Various strong entities, when combined, create a strong entity set [8].
*   **Weak Entity**:
    *   **Dependent on a strong entity** for its existence [8, 9].
    *   **Does not have a primary key**; instead, it has a **partial discriminator key** [9].
    *   Represented by a **double rectangle** [9, 10].
    *   The relation between one strong and one weak entity is represented by a **double diamond** [9, 10].
    *   **Always has total participation**, unlike strong entities which may or may not [10].
*   **Composite Entity**:
    *   Entities participating in **many-to-many relationships** [10].
    *   Apart from the two main entities, a **hidden entity** (or new table) is created for the relationship, with a primary key formed by using the primary keys of the other two entities [10, 11].
    *   **Example**: For `Students` enrolling in `Courses` (a many-to-many relationship), a new table `STUD_COURSE` (an `Enrolment` entity) is created, containing primary keys from both `STUDENT` and `COURSE` to form its composite primary key [11].
*   **Recursive Entity**:
    *   Exists when a **relation exists between the same entities** [11].
    *   **Example**: The mapping between a `manager` and an `employee` (where a manager is also an employee) [12].

#### **B. Attributes**
**Attributes** are the properties or characteristics of an entity; they are also known as **columns** of a table [12]. An attribute is a list of all related information of an entity that has a valid value [12]. Attributes can have single values, multiple values, or a range of values, and contain specific data types [13].

**Types of Attributes**:
*   **Simple Attribute**: Values that **cannot be divided further** (e.g., `STUDENT_ID`, `Passport Number`) [13, 14].
*   **Composite Attribute**: An attribute **composed of many other attributes** [14].
    *   **Example**: `Address` (comprising `Street`, `City`, `State`, `Country`) [14]. In an ER diagram, it's represented by an oval comprising other ovals [14].
*   **Stored Attribute**: The attribute whose value is **physically stored in the database** and from which other attributes can be derived [14, 15].
    *   **Example**: `Date of Birth` (used to derive `Age`) [14].
*   **Derived Attribute**: An attribute whose **value can be obtained from other attributes** in the database [15].
    *   **Example**: `Age` (derived from `Date of Birth` and current date), `Average salary`, `total marks` [15].
*   **Single-Valued Attribute**: Attributes that will have **only one value** (e.g., `EMPLOYEE_ID`, `passport#`, `driving license#`) [15, 16].
*   **Multi-Valued Attribute**: Attributes that can have **more than one value** at any point in time (e.g., a person having multiple `email addresses` or `houses`) [16].
*   **Descriptive Attribute**: Attributes of a **relationship** [16].
    *   **Example**: In an `Employee` "works for" `Department` relationship, `DATE_OF_JOIN` can be a descriptive attribute of the "works for" relationship [16, 17].

#### **C. Relationship**
An **association between two entity types** is called a **relationship** [17]. Entities participate in relationships, which are represented by a **diamond shape** in ER diagrams [17]. A set of relationships of a similar type is called a **relationship set** [18].

**Types of Relationships**:
*   **One-to-One Relationship**: Each record of one table is related to **only one record** of the other table [19].
    *   **Example**: A `Person` can have only one `Passport`, and each `Passport` belongs to only one `Person` [19]. These are not very common but are used for security purposes (e.g., storing sensitive data in a separate table) [19, 20].
*   **One-to-Many or Many-to-One Relationship**: Each record of one table can be related to **one or more records** of the other table [20]. This is the **most common** relationship [20].
    *   **Example**: A `Customer` can have many `Accounts`, but each `Account` is held by only one `Customer` [21].
*   **Many-to-Many Relationship**: Each record of the first table can be related to one or more records of the second table, and vice-versa [22]. This relationship is often linked by a **'linking table' or 'associate table'**, which contains the primary keys of the two related tables as its own fields [22].
    *   **Example**: A `Customer` can buy many `Products`, and a `Product` can be bought by many `Customers` [18].

**Degree of Relationship**: The number of participating entities in a relationship defines its degree [18].
*   **Binary**: Degree 2 (e.g., `Teacher` teaches `Students`) [23].
*   **Ternary**: Degree 3 [23].
*   **n-ary**: Degree n [23].

---

### 2. Keys

A **DBMS key** is an attribute or set of attributes that helps you to **identify a row (tuple) uniquely** in a table (relation) [23]. Keys allow you to establish and enforce identity and integrity in relationships between tables [24].

**Types of Keys**:
*   **Super Key**: A group of single or multiple attributes that uniquely identifies rows in a table [25]. A super key may have additional attributes not strictly needed for unique identification [25].
    *   **Example**: `(EMPLOYEE_ID, EMPLOYEE_NAME)` could be a super key, even though `EMPLOYEE_ID` alone might be unique [25].
*   **Primary Key**: A column or group of columns that **uniquely identify every row** in that table [26].
    *   **Rules**:
        *   Two rows **cannot have the same primary key value** [26].
        *   It **must have a value for every row** (cannot be null) [27].
        *   Its value **cannot be modified or updated** if any foreign key refers to it [27].
    *   A table can have **only one primary key** [26, 27].
*   **Candidate Key**: A set of attributes that **uniquely identify tuples** in a table, and it is a **super key with no repeated attributes** [27].
    *   The **Primary key should be selected from the candidate keys** [27].
    *   Every table must have at least one candidate key [27].
    *   **Properties**: Must contain unique values, may have multiple attributes, must not contain null values, should contain minimum fields for uniqueness, and uniquely identify each record [28].
    *   **Example**: In an `EMPLOYEE` table, `ID`, `SSN`, `Passport_Number`, `License_Number` could all be candidate keys, from which `ID` might be chosen as the primary key [28].
*   **Alternate Key**: All the **candidate keys that are not chosen as the primary key** are called alternate keys [29].
*   **Foreign Key**: A column in one table that **points to the primary key of another table**, establishing a link between the two tables [29].
    *   The table containing the foreign key is called the **child table** or **referencing table**, and the table containing the primary key it refers to is the **master** or **referenced table** (parent table) [30-32].
    *   **Example**: `Department_Id` in an `EMPLOYEE` table can be a foreign key referencing the `DEPARTMENT` table's primary key [30].
*   **Composite Key**: A primary key that consists of **more than one attribute** [30]. Also known as a **Concatenated Key** [30].

---

### 3. Enhanced Entity-Relationship (EER) Model

**EER modeling** is an extension of the traditional ER model designed to handle more **complex database structures** [30]. It incorporates additional concepts:
*   **Specialization**: Creating **more specific sub-entities** from a generalized entity [33].
*   **Generalization**: The process of **combining multiple entity types into a higher-level entity** [33].
*   **Categorization (Union Types)**: Allows an entity to be associated with **multiple parent entities** that are not necessarily related [33, 34]. This is useful for complex hierarchical relationships [33].
*   **Aggregation**: Treats relationships as **higher-level entities**, useful for modeling interactions between multiple entity sets [34].

EER introduces **subclasses and superclasses**, allowing entities to inherit attributes and relationships, similar to object-oriented programming [33]. EER diagrams use special notations to incorporate these concepts [34].

---

### 4. Relational Data Model

The relational data model describes data using **relations**, which are essentially **tables** organized into rows and columns [35].
*   **Relation**: A table [35].
*   **Attribute**: A column header of a table [35].
*   **Tuple**: A row in a table, representing a record [35].
*   **Domain**: A set of possible, **atomic (indivisible)** values for a given attribute [36].
    *   **Example**: The domain for a `FirstName` attribute would be a set of names [36].

---

### 5. Integrity Rules/Constraints

**Integrity constraints** are a set of rules that ensure the **quality and consistency of information** in a database [36]. They guard against accidental damage to the database during data insertion, updating, and other processes [37].

**Types of Integrity Constraints**:
1.  **Domain Constraints**: Define a **valid set of values for an attribute** [37]. The attribute's value must fall within its defined data type and allowed values (e.g., string, integer, date) [37].
2.  **Entity Integrity Constraints**: States that a **primary key value cannot be null** [37]. This is crucial because primary keys are used to uniquely identify individual rows, and a null value would prevent this identification [31].
3.  **Referential Integrity Constraints (Foreign Key Constraint)**: Ensures that values in a foreign key column (in the child table) **must exist as a primary key** in the referenced (parent) table, or be null [31, 32].
    *   **Insert Constraint**: A value cannot be inserted into the child table if it does not exist in the master table's primary key [38, 39].
    *   **Delete Constraint**: A value cannot be deleted from the master table if it is still referenced by a foreign key in the child table [39].
4.  **Key Constraints**: Relate to the uniqueness and identification properties of keys within an entity set [39]. An entity set can have multiple keys, but only one is chosen as the primary key [39].

---

### 6. Relational Algebra

**Relational Algebra** is a **procedural query language** used to query database tables to access data [40]. In relational algebra, both the **input and output are relations (tables)** [40]. It operates on entire tables at once, rather than iterating row by row [40, 41].

The primary operations are:
1.  **Select (σ)**:
    *   Used to **fetch rows (tuples) from a table** that satisfy a given condition [41].
    *   **Syntax**: `σp(r)` where `σ` is the select predicate, `r` is the relation name, and `p` is the prepositional logic condition [42].
    *   **Example**: `σage > 17 (Student)` fetches all students older than 17 [42, 43]. `σage > 17 and gender = 'Male' (Student)` fetches male students older than 17 [43].
2.  **Project (∏)**:
    *   Used to **project (display) only a certain set of attributes (columns)** from a relation [43, 44].
    *   Automatically **removes duplicate data** from the projected columns [44].
    *   **Syntax**: `∏A1, A2...(r)` where `A1, A2` are attribute names [44].
    *   **Example**: `∏Name, Age (Student)` will show only the `Name` and `Age` columns from the `Student` table [44].
3.  **Union (∪)**:
    *   Used to **combine data from two relations** (tables or temporary relations) [44].
    *   Requires that the relations have the **same number of attributes and the same attribute domains** [45].
    *   **Automatically eliminates duplicate tuples** from the result [45].
    *   **Syntax**: `A ∪ B` [45].
    *   **Example**: `∏Student(RegularClass) ∪ ∏Student(ExtraClass)` gives names of students attending either regular or extra classes, without repetition [45, 46].
4.  **Set Difference (-)**:
    *   Used to find data present in **one relation but not in another** [46].
    *   Also applicable on two relations with the same number of attributes and domains [46].
    *   **Syntax**: `A - B` [46].
    *   **Example**: `∏Student(RegularClass) - ∏Student(ExtraClass)` finds students attending regular classes but not extra classes [46].
5.  **Cartesian Product (X)**:
    *   Used to **combine data from two different relations into one**, creating all possible pairs of rows from the two tables [47].
    *   **Syntax**: `A X B` [47].
    *   **Example**: `σtime = 'morning' (RegularClass X ExtraClass)` could combine records from both tables where the time attribute is 'morning' (assuming both tables have a `time` attribute) [47].
6.  **Rename (ρ)**:
    *   Used to **rename the output relation** of any query operation or to simply rename a relation (table) [47, 48].
    *   **Syntax**: `ρ(RelationNew, RelationOld)` [48].

---

### 7. SQL Joins

**SQL JOIN clauses** are fundamental for database management systems, enabling the **combination of data from multiple tables** based on logical relationships between columns [48, 49]. They allow efficient data retrieval by using common key values shared across tables [49].

#### **A. Types of JOINs**:

1.  **INNER JOIN**:
    *   Selects **all rows from both tables as long as the condition is satisfied** (i.e., a match exists in both tables) [50].
    *   Creates a result set by combining rows where the value of the common field is the same [50].
    *   `JOIN` keyword is synonymous with `INNER JOIN` [51].
    *   **Syntax**:
        ```sql
        SELECT table1.column1, table2.column1 FROM table1
        INNER JOIN table2
        ON table1.matching_column = table2.matching_column;
        ```
    *   **Example**: To get student names and ages enrolled in courses:
        ```sql
        SELECT StudentCourse.COURSE_ID, Student.NAME, Student.AGE FROM Student
        INNER JOIN StudentCourse
        ON Student.ROLL_NO = StudentCourse.ROLL_NO;
        ```
2.  **LEFT JOIN (LEFT OUTER JOIN)**:
    *   Returns **all rows from the table on the left side** of the join [51, 52].
    *   Returns **matching rows from the table on the right side** [52].
    *   For rows from the left table that have **no matching row on the right side, the result set will contain `NULL`** values for the right table's columns [52].
    *   **Syntax**:
        ```sql
        SELECT table1.column1, table2.column1 FROM table1
        LEFT JOIN table2
        ON table1.matching_column = table2.matching_column;
        ```
    *   **Example**: To get all student names and their course IDs (even if they aren't enrolled):
        ```sql
        SELECT Student.NAME, StudentCourse.COURSE_ID FROM Student
        LEFT JOIN StudentCourse
        ON StudentCourse.ROLL_NO = Student.ROLL_NO;
        ```
3.  **RIGHT JOIN (RIGHT OUTER JOIN)**:
    *   Returns **all rows from the table on the right side** of the join [53, 54].
    *   Returns **matching rows for the table on the left side** [54].
    *   For rows from the right table that have **no matching row on the left side, the result set will contain `NULL`** values for the left table's columns [54].
    *   **Syntax**:
        ```sql
        SELECT table1.column1, table2.column1 FROM table1
        RIGHT JOIN table2
        ON table1.matching_column = table2.matching_column;
        ```
    *   **Example**: To get all course IDs and the names of students enrolled in them (even if a course has no enrolled student):
        ```sql
        SELECT Student.NAME, StudentCourse.COURSE_ID FROM Student
        RIGHT JOIN StudentCourse
        ON StudentCourse.ROLL_NO = Student.ROLL_NO;
        ```
4.  **FULL JOIN (FULL OUTER JOIN)**:
    *   Combines the results of both **`LEFT JOIN` and `RIGHT JOIN`** [55].
    *   The result set will contain **all rows from both tables** [55].
    *   For rows where there is no matching record in the other table, the result set will contain **`NULL` values** for the missing fields [55, 56].
    *   **Syntax**:
        ```sql
        SELECT table1.column1, table2.column1 FROM table1
        FULL JOIN table2
        ON table1.matching_column = table2.matching_column;
        ```
    *   **Example**: To get all student names and all course IDs, showing NULLs where no match exists:
        ```sql
        SELECT Student.NAME, StudentCourse.COURSE_ID FROM Student
        FULL JOIN StudentCourse
        ON StudentCourse.ROLL_NO = Student.ROLL_NO;
        ```
5.  **Natural Join (?)**:
    *   Joins tables based on **common columns that have the same name and data type** in both tables being joined [57, 58].
    *   The DBMS automatically identifies these common columns and joins based on their matching values [58].
    *   **Syntax (Relational Algebra)**: `(Employee) ? (Department)` [1].

---

Remember, this is a comprehensive overview covering all sections of Module 2. Good luck with your exam!
