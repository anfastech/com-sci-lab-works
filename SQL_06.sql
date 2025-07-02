 1.Create a table Hospital with the fields (DoctorID, DoctorName, Department, Qualification, Experience). Write the queries to perform the following.
 
  Table: hospital

| Field Name    | Data Type   | Description              |
| ------------- | ----------- | ------------------------ |
| doctorid      | VARCHAR(5)  | Doctor ID                |
| doctorname    | VARCHAR(25) | Doctor Name              |
| department    | VARCHAR(20) | Department               |
| qualification | VARCHAR(10) | Qualification            |
| experience    | INT         | Experience in years      |

-- Create hospital table
CREATE TABLE hospital (
    doctorid VARCHAR(5),
    doctorname VARCHAR(25),
    department VARCHAR(20),
    qualification VARCHAR(10),
    experience INT
);

-- a) Insert 5 records
INSERT INTO hospital VALUES
('D001', 'Dr. Riya', 'Cardiology', 'MD', 10),
('D002', 'Dr. Manoj', 'Skin', 'MBBS', 3),
('D003', 'Dr. Neha', 'Ortho', 'MS', 4),
('D004', 'Dr. Arun', 'Skin', 'MD', 6),
('D005', 'Dr. Mitra', 'Skin', 'MBBS', 6),
('D006', 'Dr. Priya', 'Neurology', 'MBBS', 2);

-- b) Display all doctors
SELECT * FROM hospital;

-- c) Display doctors with qualification 'MD'
SELECT * FROM hospital WHERE qualification = 'MD';

-- d) Doctors with >5 years experience but NOT 'MD'
SELECT * FROM hospital
WHERE experience > 5 AND qualification != 'MD';

-- e) Doctors in 'Skin' department
SELECT * FROM hospital WHERE department = 'Skin';

-- f) Update experience of doctor with ID 'D003' to 5
UPDATE hospital
SET experience = 5
WHERE doctorid = 'D003';

-- g) Delete doctor with ID 'D005'
DELETE FROM hospital WHERE doctorid = 'D005';



2. Create a table Product with the fields (Product_Code (Primary Key), Product_Name, Category, Quantity, Price). Insert some records. Write the queries to perform the following.

 Table: Product

| Field Name    | Data Type    | Description            |
| ------------- | ------------ | ---------------------- |
| Product_code | VARCHAR(10)  | Primary Key            |
| Product_Name | VARCHAR(30)  | Product Name           |
| Category      | VARCHAR(20)  | Category (e.g., paste) |
| Quantity      | INT          | Quantity in stock      |
| Price         | DECIMAL(6,2) | Product price          |

-- Create Product table
CREATE TABLE Product (
    Product_code VARCHAR(10) PRIMARY KEY,
    Product_Name VARCHAR(30),
    Category VARCHAR(20),
    Quantity INT,
    Price DECIMAL(6,2)
);

-- Insert sample records
INSERT INTO Product VALUES
('P001', 'Surf Excel', 'washingpowder', 80, 45.00),
('P002', 'Colgate', 'paste', 120, 35.00),
('P003', 'Santoor', 'bathsoap', 60, 25.00),
('P004', 'Lifebuoy', 'bathsoap', 510, 20.00),
('P005', 'Pepsodent', 'paste', 90, 30.00);

-- a) Display records in descending order of Product_Name
SELECT * FROM Product ORDER BY Product_Name DESC;

-- b) Product_Code, Product_Name with price between 20 and 50
SELECT Product_code, Product_Name
FROM Product
WHERE Price BETWEEN 20 AND 50;

-- c) Products in category 'bathsoap', 'paste', or 'washingpowder'
SELECT * FROM Product
WHERE Category IN ('bathsoap', 'paste', 'washingpowder');

-- d) Products with Quantity < 100 or > 500
SELECT * FROM Product
WHERE Quantity < 100 OR Quantity > 500;

-- e) Products where name starts with 's' or 'S'
SELECT * FROM Product
WHERE Product_Name ILIKE 's%';

-- f) Products NOT in category 'paste'
SELECT * FROM Product
WHERE Category != 'paste';


