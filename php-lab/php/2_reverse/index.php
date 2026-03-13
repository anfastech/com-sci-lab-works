<html>
<body>

<h2>Enter the string</h2><br>

<form action="" method="POST">
<input type="text" name="string1">
<input type="submit" value="Reverse">
</form>

</body>
</html>

<?php

function reverse()
{
$str = $_POST['string1'];

echo "Before reverse: ".$str."<br><br>";

$length = strlen($str);

echo "After reverse:";

for($i = ($length-1); $i >= 0; $i--)
{
echo $str[$i];
}

}

reverse();

?>