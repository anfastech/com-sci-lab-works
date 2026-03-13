<html>
<body>

<h2>Enter the number</h2><br>

<form action="" method="POST">
<input type="text" name="number">
<input type="submit">
</form>

</body>
</html>

<?php

if($_POST)
{
$no = $_POST['number'];

$sum = 0;

for($i=1;$i<$no;$i++)
{
if($no % $i == 0)
$sum = $sum + $i;
}

if($sum == $no)
echo "$no is a perfect";
else if($sum > $no)
echo "$no is abundant";
else
echo "$no is deficient";
}

?>