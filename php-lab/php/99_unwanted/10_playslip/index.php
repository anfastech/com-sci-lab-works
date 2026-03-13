<!DOCTYPE html>
<html>
<body>

<h1>Employee Pay Slip Generation</h1>

<form method="POST">

Name:<br>
<input type="text" name="name"><br><br>

Basic Salary:<br>
<input type="number" name="basic_salary"><br><br>

Designation:<br>

<select name="designation">
<option value="Manager">Manager</option>
<option value="Supervisor">Supervisor</option>
<option value="Clerk">Clerk</option>
<option value="Peon">Peon</option>
</select>

<br><br>

<input type="submit" value="Generate Pay Slip">

</form>

<?php

function calculateHRA($basicSalary)
{    return 0.25 * $basicSalary;
}

function calculateAllowances($designation)
{
    switch ($designation) 
{
        case "Manager":            return array(1000, 500);
        case "Supervisor":            return array(750, 200);
        case "Clerk":            return array(500, 100);
        case "Peon":            return array(250, 0);
    }

}

function calculateTax($gross)
{
    if ($gross <= 2500)        return 0;
    else if ($gross <= 4000)        return 0.03 * $gross;
    else if ($gross <= 5000)        return 0.05 * $gross;
    else        return 0.08 * $gross;

}

if ($_POST) 
{
    $name = $_POST['name'];    $basic = $_POST['basic_salary'];    $des = $_POST['designation'];
    $hra = calculateHRA($basic);
    $allow = calculateAllowances($des);
    $convey = $allow[0];    $extra = $allow[1];
    $gross = $basic + $hra + $convey + $extra;
    $tax = calculateTax($gross);
    $net = $gross - $tax;
    echo "<h2>Payslip</h2>";
    echo "Name : $name <br>";    echo "Designation : $des <br>";    echo "Basic Salary : $basic <br>";    echo "HRA : $hra <br>";    echo "Conveyance : $convey <br>";    echo "Extra Allowance : $extra <br>";    echo "Gross Salary : $gross <br>";    echo "Income Tax : $tax <br>";    echo "Net Salary : $net <br>";

}

?>

</body>
</html>