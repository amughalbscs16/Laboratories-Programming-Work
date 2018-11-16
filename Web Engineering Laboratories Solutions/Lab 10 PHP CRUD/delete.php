<?php
//including the database connection file
include(".\config\config.php");

//getting id of the data from url
$id = $_GET['id'];

//deleting the row from table
$result = mysqli_query($mysqli, "DELETE FROM users WHERE id=$id");

$mysqli->close();

//redirecting to the display page (index.php in our case)
header("Location:index.php");
?>

