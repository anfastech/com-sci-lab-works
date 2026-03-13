<?php

if(isset($_GET['number']))
{

$number = $_GET['number'];

echo "<h2>Multiplication Table for $number</h2>";

echo "<table border='1'>";

for($i=1;$i<=10;$i++)
{
echo "<tr><td>$number x $i = ".($number*$i)."</td></tr>";
}

echo "</table>";

}

else
{
echo "Please enter a number";
}

?>