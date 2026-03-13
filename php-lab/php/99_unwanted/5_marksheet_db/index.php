<html>
<body>

<h1>Marksheet</h1>

<form method="POST">

Regno: <input type="text" name="txtreg" required>

<input type="submit" value="Get Result">

</form>

</body>
</html>

<?php

if ($_SERVER['REQUEST_METHOD'] == 'POST')
{

$rg = $_POST['txtreg'];

$con = pg_connect("host=localhost dbname=postgres user=postgres password=1234");

if (!$con)
{
die("Connection failed");
}
else
{
echo "Successfully Connected.<br>";
}

$qry = "SELECT * FROM public.result WHERE regno = $1";

$result = pg_query_params($con,$qry,array($rg));

if ($result)
{
$nos = pg_num_rows($result);

if ($nos > 0)
{

while ($row = pg_fetch_assoc($result))
{
echo "<br>Regno: ".$row['regno'];
echo " Name: ".$row['name'];
echo " Marks: ".$row['marks'];
echo " Grade: ".$row['grade'];
}

}

else
{
echo "No results found";
}

}

pg_close($con);

}

?>