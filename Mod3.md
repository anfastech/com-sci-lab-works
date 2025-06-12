Let's go through the key concepts from this module to help you prepare for your exam.

### **Relational Database Design (RDD)**

**Relational database design (RDD)** is a method for modeling information and data using a set of tables with rows and columns [1]. Each row in a table represents a record, and each column represents an attribute of data [1]. The **Structured Query Language (SQL)** is used to manipulate relational databases [1].

RDD organizes data into tables and performs all data access through controlled transactions [2]. It satisfies the **ACID properties**: atomicity, consistency, integrity, and durability [2]. RDD also mandates the use of a database server for data management in applications [2].

### **Four Stages of Relational Database Design**

The design of a relational database is composed of four stages [1, 3]:

1.  **Define Relations/Attributes**: This involves identifying the various tables (which represent entities) and the attributes (which represent properties of those entities) related to each table [1, 3].
2.  **Define Primary Keys**: The attribute or set of attributes that uniquely identifies a record within a table is identified and assigned as the **primary key** [2, 3].
3.  **Define Relationships**: Relationships between different tables are established using **foreign keys** [2, 3]. A foreign key is an attribute in one table that is the primary key of another table [3]. The types of relationships that can exist between tables include:
    *   One to one [4]
    *   One to many [4]
    *   Many to many [4]
    An **entity-relationship diagram** can be used to visually depict entities, their attributes, and the relationships between them [4].
4.  **Normalization**: This is the process of **optimizing the database structure** to simplify its design and avoid redundancy and confusion [4, 5].

### **Normalization**

The **basic objective of normalization is to reduce redundancy**, meaning information should be stored only once [5]. Storing information multiple times wastes storage space and increases the total data size [5]. Normalization helps ensure that when relations (tables) in a database are altered (inserted, deleted, or updated), information is not lost, and inconsistencies are not introduced [5-7].

**Properties of Normalized Relations (Ideal Relations)** [7, 8]:
*   No data value should be unnecessarily duplicated in different rows [7].
*   A value must be specified (and required) for every attribute in a row [7].
*   Each relation should be **self-contained**; deleting a row should not accidentally lose important information [7].
*   Adding new data to one relation should not affect other relations [8].
*   Changing an attribute value in a tuple should be independent of other tuples or relations [8].

An **unnormalized relation** contains **non-atomic values**, meaning a single row may have multiple sets of values for some columns [8, 9]. The goal of normalizing relations to higher normal forms is to achieve these ideal properties [8].

### **Functional Dependency**

A **functional dependency** is a constraint that specifies the relationship between two sets of attributes where one set can accurately determine the value of the other [9]. It is denoted as **X → Y**, where X is the **Determinant** (left side) and Y is the **Dependent** (right side) [9]. Functional dependencies are crucial for understanding advanced concepts in relational database systems [10].

**Examples of Valid Functional Dependencies** [10, 11]:
*   `roll_no` → `{name, dept_name, dept_building}`: `roll_no` can determine `name`, `dept_name`, and `dept_building` [10].
*   `roll_no` → `dept_name`: Since `roll_no` determines the whole set, it can determine its subset `dept_name` [10].
*   `dept_name` → `dept_building`: `dept_name` can accurately identify the `dept_building` [11].

**Examples of Invalid Functional Dependencies** [11, 12]:
*   `name` → `dept_name`: Students with the same name can have different department names [11].
*   `dept_building` → `dept_name`: Multiple departments can be in the same building [11, 12].

**Types of Functional Dependencies** [12]:

1.  **Trivial Functional Dependency**: If **X → Y** and **Y is a subset of X**, it's trivial [12, 13].
    *   *Example*: `{roll_no, name} → name` is trivial because `name` is a subset of `{roll_no, name}` [13].
2.  **Non-Trivial Functional Dependency**: If **X → Y** and **Y is *not* a subset of X**, it's non-trivial [13, 14].
    *   *Example*: `roll_no → name` is non-trivial because `name` is not a subset of `roll_no` [14].
3.  **Multivalued Functional Dependency**: If **a → {b, c}** and there is **no functional dependency between b and c**, it's multivalued [14, 15].
    *   *Example*: `roll_no → {name, age}` is multivalued if `name` and `age` are not dependent on each other (`name → age` or `age → name` doesn't exist) [15].
4.  **Transitive Functional Dependency**: If **a → b** and **b → c**, then **a → c** is a transitive functional dependency [15, 16]. The dependent is indirectly dependent on the determinant [15].
    *   *Example*: `enrol_no → dept` and `dept → building_no`, then `enrol_no → building_no` is transitive [16].

**Armstrong’s Axioms/Properties of Functional Dependencies** [16]:

1.  **Reflexivity**: If Y is a subset of X, then X → Y holds [16].
    *   *Example*: `{roll_no, name} → name` is valid [16].
2.  **Augmentation**: If X → Y is valid, then XZ → YZ is also valid [17].
    *   *Example*: If `{roll_no, name} → dept_building` is valid, then `{roll_no, name, dept_name} → {dept_building, dept_name}` is also valid [17].
3.  **Transitivity**: If X → Y and Y → Z are valid, then X → Z is also valid [17].
    *   *Example*: `roll_no → dept_name` and `dept_name → dept_building`, then `roll_no → dept_building` is valid [17].

Additional rules derived from these axioms include Union (X→Y and X→Z then X→YZ), Decomposition (X→YZ then X→Y and X→Z), and Pseudo-transitivity (X→Y and WY→Z then XW→Z) [18].

### **Normal Forms**

Normalization involves applying a set of rules to a table in a linearly progressive fashion, with efficiency improving with each higher degree of normalization [5].

1.  **First Normal Form (1NF)** [18]:
    *   **Rule**: An attribute (column) of a table cannot hold multiple values; it must hold only **atomic (single) values** [18, 19].
    *   *How to achieve*: If a column has multiple values (e.g., two mobile numbers in `emp_mobile`), create separate rows for each atomic value, duplicating other column data as necessary [19, 20].

2.  **Second Normal Form (2NF)** [19]:
    *   **Conditions**:
        1.  The table must be in **1NF** [20].
        2.  **No non-prime attribute is dependent on a proper subset of any candidate key** of the table [20]. (A non-prime attribute is not part of any candidate key) [20].
    *   *How to achieve*: Decompose the table into smaller tables to remove partial dependencies [21, 22].
    *   *Example*: If `{teacher_id, subject}` is the candidate key and `teacher_age` (non-prime) depends only on `teacher_id` (a subset of the key), split into `teacher_details (teacher_id, teacher_age)` and `teacher_subject (teacher_id, subject)` [21, 22].

3.  **Third Normal Form (3NF)** [22]:
    *   **Conditions**:
        1.  The table must be in **2NF** [23].
        2.  **Transitive functional dependency of non-prime attributes on any super key should be removed** [23].
    *   *How to achieve*: Decompose the table to eliminate transitive dependencies [24, 25].
    *   *Example*: If `emp_id` determines `emp_zip`, and `emp_zip` determines `emp_state`, `emp_city`, and `emp_district`, then `emp_state`, `emp_city`, and `emp_district` are transitively dependent on `emp_id`. Split into `employee (emp_id, emp_name, emp_zip)` and `employee_zip (emp_zip, emp_state, emp_city, emp_district)` [24, 25].

4.  **Boyce-Codd Normal Form (BCNF)** [25]:
    *   Also known as **3.5 Normal Form**, BCNF is an extension of 3NF [25].
    *   **Conditions**:
        1.  The table must be in **3NF** [26].
        2.  For any dependency **A → B**, **A must be a super key** [26].
        *   In simpler terms: For a dependency A → B, A cannot be a non-prime attribute if B is a prime attribute [26].
    *   *How to achieve*: Decompose the table if a non-prime attribute determines a prime attribute [27, 28].
    *   *Example*: In a `student_id, subject, professor` table where `student_id, subject` is the primary key and `professor → subject` exists. Since `subject` is prime but `professor` is non-prime, this violates BCNF. Decompose into `Student (student_id, p_id)` and `Professor (p_id, professor, subject)` [26-30].

5.  **Fourth Normal Form (4NF)** [31]:
    *   **Conditions**:
        1.  It must be in **BCNF** [31].
        2.  It should have **no multi-valued dependency** [32].
    *   A **multi-valued dependency** occurs when two attributes in a table depend on a third attribute but are independent of each other (X->->Y means multiple Y values for a single X value) [32].
    *   *How to achieve*: If a relation has multi-valued dependencies, decompose it into separate tables where the multi-valued attributes are in their own tables linked by the determinant [33, 34].
    *   *Example*: If `Student-ID` determines both `Course` and `Hobby`, and `Course` and `Hobby` are independent, decompose into `Student-ID, Course` and `Student-ID, Hobby` tables [33, 34].

6.  **Fifth Normal Form (5NF) / Projected Normal Form** [35]:
    *   **Conditions**:
        1.  A relation R is in 5NF if and only if every **join dependency** in R is implied by the candidate keys of R [36].
        2.  It must be in **4NF** [36].
        3.  It **cannot be further non-loss decomposed (join dependency)** [36].
    *   A **join dependency (JD)** exists if the join of decomposed sub-relations results in the original relation without loss of information [34, 37].
    *   *How to achieve*: Ensure that any further decomposition would be lossy [36, 38].

### **Decomposition**

**Decomposition** is the process of breaking down a larger relation (table) into smaller relations [28].

**Key principles of decomposition** [28, 39]:
*   It breaks a bigger table into smaller ones [28].
*   There should be **no loss of information**; the original table should be reconstructible from the smaller ones when needed [28, 39].
*   It is needed when a relation is not in an appropriate normal form [39].
*   It eliminates problems like anomalies, inconsistencies, and redundancy [39].

**Types of Decomposition**:

1.  **Lossless Join Decomposition** [40]:
    *   Ensures **no information is lost** from the original relation during decomposition [39].
    *   When the sub-relations are joined back (using natural join), the **same original relation is obtained** [39, 40].
    *   **R1 ⋈ R2 ⋈ ... ⋈ Rn = R** [41].
    *   Also known as **non-additive join decomposition** because no extraneous tuples appear [42].
    *   **Every decomposition must always be lossless** [39].

2.  **Lossy Join Decomposition** [43]:
    *   Occurs when the join of the sub-relations **does not result in the same original relation** [43].
    *   The natural join of the sub-relations is always found to have **some extraneous tuples** (meaning extra rows that were not in the original table) [43].
    *   **R1 ⋈ R2 ⋈ ... ⋈ Rn ⊃ R** (contains the original relation, but also more tuples) [43].
    *   Also known as **careless decomposition** [31]. Extraneous tuples make identifying the original tuples difficult [31].

**Dependency Preservation** [40]:
*   Ensures that **none of the functional dependencies that hold on the original relation are lost** [40].
*   The sub-relations still hold or satisfy the functional dependencies of the original relation [40].

Good luck with your exam!
