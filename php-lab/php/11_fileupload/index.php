<?php

if ($_SERVER['REQUEST_METHOD'] == "POST") 
{
    $targetDir = "uploads/";
    $targetFile = $targetDir . basename($_FILES["fileToUpload"]["name"]);
    if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $targetFile)) 
{        echo "File uploaded successfully";    }    else 
{        echo "Error uploading file";    }

}

?>

<form method="post" enctype="multipart/form-data">

Select file:

<input type="file" name="fileToUpload">

<input type="submit" value="Upload">

</form>