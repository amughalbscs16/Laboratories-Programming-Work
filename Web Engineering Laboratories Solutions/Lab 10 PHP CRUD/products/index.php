<?php include_once("validate-session.php");?>


<?php
//including the database connection file
include_once("..\config\config.php");

//fetching data in descending order (lastest entry first)
$result = mysqli_query($mysqli, "SELECT * FROM products WHERE login_id=".$_SESSION['id']." ORDER BY id DESC");
?>


<html>
<head>
	<title>Products List</title>
</head>

<body>
	<?php include_once("header.php");?>
	
	<table width='70%' border=0>
		<tr bgcolor='#CCCCCC'>
			<td></td>
			<td>Name</td>
			<td>Quantity</td>
			<td>Price (Rs.)</td>
			<td>Update</td>
		</tr>
		<?php
		while($res = mysqli_fetch_array($result)) {		
			echo "<tr>";
			echo "<td><img src='".$res['img_path']."' border='0' width='100px;'></td>";			
			echo "<td>".$res['name']."</td>";
			echo "<td>".$res['qty']."</td>";
			echo "<td>".$res['price']."</td>";
			echo "<td><a href=\"edit.php?id=$res[id]\">Edit</a> | <a href=\"delete.php?id=$res[id]\" onClick=\"return confirm('Are you sure you want to delete?')\">Delete</a></td>";		
		}
		?>
	</table>	
</body>
</html>
