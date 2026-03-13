<?php

$con = pg_connect("host=localhost dbname=postgres user=postgres password=1234");

$sql = "INSERT INTO product(itemname,unitprice) VALUES
('Laptop',800),
('Smartphone',500),
('Tablet',250),
('Headphones',100),
('Smartwatch',150)";

pg_query($con, $sql);

$result = pg_query($con, "SELECT * FROM product");

echo "<table border=1>";

echo "<tr>
<th>Item Code</th>
<th>Item Name</th>
<th>Unit Price</th>
</tr>";

while ($row = pg_fetch_assoc($result)) 
{
    echo "<tr>";
    echo "<td>" . $row['itemcode'] . "</td>";    echo "<td>" . $row['itemname'] . "</td>";    echo "<td>" . $row['unitprice'] . "</td>";
    echo "</tr>";

}

echo "</table>";

pg_close($con);

?>