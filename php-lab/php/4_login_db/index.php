<html>
<body>

<h1>Login</h1>

<form action="" method="POST">

Username: <input type="text" name="usr"><br><br>
Password: <input type="password" name="pass"><br><br>

<input type="submit" value="login">

</form>

</body>
</html>

<?php

if ($_POST)
{
$usrname = $_POST['usr'];
$passwd = $_POST['pass'];

$con = pg_connect("host=localhost dbname=postgres user=postgres password=1234");

if ($con)
{
echo "Successfully Connected.";

$qry = "SELECT * FROM public.login where username='$usrname' and password='$passwd'";

$result = pg_query($con,$qry);

$nos = pg_num_rows($result);

if ($nos)
echo "<br>$usrname, You are Logged Successfully...";
else
echo "Incorrect username or password";

}
else
{
echo "Error Connecting to the database";
}

}

?>