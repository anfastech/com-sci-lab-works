<?php

$con = pg_connect("host=localhost dbname=postgres user=postgres password=1234");

if ($_POST) 
{
    $accno = $_POST['accno'];    $amount = $_POST['amount'];    $type = $_POST['transaction'];
    $result = pg_query_params($con, "SELECT balance FROM bank WHERE accno=$1", array($accno));
    $row = pg_fetch_assoc($result);
    $balance = $row['balance'];
    if ($type == "deposit")        $new = $balance + $amount;
    else        $new = $balance - $amount;
    pg_query_params($con, "UPDATE bank SET balance=$1 WHERE accno=$2", array($new, $accno));
    echo "New Balance : " . $new;

}

?>

<html>
<body>

<h2>Bank Transaction</h2>

<form method="POST">

Account Number:
<input type="text" name="accno"><br><br>

Amount:
<input type="text" name="amount"><br><br>

<input type="radio" name="transaction" value="deposit">Deposit
<input type="radio" name="transaction" value="withdrawal">Withdrawal

<br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>