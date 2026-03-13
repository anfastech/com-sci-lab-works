<html>
<body>
<form action="" method="POST">
<h1>
<center>BIO DATA</center>
</h1>

Name: <input type="text" name="name1"><br>
Address: <textarea name="address1"></textarea><br>
Age: <input type="text" name="age1"><br>
Mobile: <input type="text" name="mobile1"><br>
Email: <input type="text" name="email1"><br>
Qualification: <input type="text" name="qualification1"><br>

<input type="submit" value="Display">
</form>
</body>
</html>

<?php
if($_POST)
{
echo "<h1><center>BIO DATA</center></h1>";
echo "Name: ".$_POST["name1"]."<br>";
echo "Address: ".$_POST["address1"]."<br>";
echo "Age: ".$_POST["age1"]."<br>";
echo "Mobile: ".$_POST["mobile1"]."<br>";
echo "Email: ".$_POST["email1"]."<br>";
echo "Qualification: ".$_POST["qualification1"]."<br>";
}
?>