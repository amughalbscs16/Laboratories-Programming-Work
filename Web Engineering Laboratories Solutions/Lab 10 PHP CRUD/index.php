<?php
//including the database connection file
include_once(".\config\config.php");

$result = mysqli_query($mysqli, "SELECT * FROM users ORDER BY id DESC;"); // using mysqli_query instead
?>

<html>
<head>	
	<title>Homepage</title>
</head>

<body>
<a href="add.html">Add New Data</a><br/><br/>

<a href="view-books.php">View Books</a><br/><br/>

<a href=".\products\index.php">View Products</a><br/><br/>


<h1> User Table </h1>
<table width='80%' border=0>

	<tr bgcolor='#CCCCCC'>
		<th>ID</th>
		<th>Name</th>
		<th>Age</th>
		<th>Email</th>
		<th>Update</th>
	</tr>
	<?php 
		while($res = mysqli_fetch_array($result)) { 		
			echo "<tr>";
			echo "<td>".$res['id']."</td>";
			echo "<td>".$res['name']."</td>";
			echo "<td>".$res['age']."</td>";
			echo "<td>".$res['email']."</td>";	
			echo "<td><a href=\"edit.php?id=$res[id]\">Edit</a> | <a href=\"delete.php?id=$res[id]\" onClick=\"return confirm('Are you sure you want to delete?')\">Delete</a></td>";		
		}
		$mysqli->close();
	?>
	</table>
</body>
</html>
