<?php
	//including the database connection file
	include_once(".\config\config.php");

	
	//************* MYSQL PROCEDURE TO CALCULATE TOTAL PRICE OF ALL BOOKS**************

	$sql1 = "SET @totalPrice = 0";
	$sql2 = "CALL total_price(@totalPrice)";
	if (!$mysqli->query($sql1) || !$mysqli->query($sql2)) {
		echo "CALL failed: (" . $mysqli->errno . ") " . $mysqli->error;
	}

	
	$sql3 = "SELECT @totalPrice as sumPrice";	
	if (!($res = $mysqli->query($sql3))) {
		echo "Fetch failed: (" . $mysqli->errno . ") " . $mysqli->error;
	}
	
	$row = $res->fetch_assoc();
	$totalPrice = $row['sumPrice']; 
	
	
	
	//************* MYSQL FUNCTION TO CALCULATE TAX ON TOTAL PRICE **************
	$stmt = $mysqli->prepare("SELECT calTax(?) as newPrice");
	
	$stmt->bind_param("i",$totalPrice);
	$stmt->execute();
	$stmt->bind_result($tax);
	$stmt->fetch();
	mysqli_stmt_close($stmt);
	
	//$stmt = $mysqli->query("SELECT calTax(300) as newPrice;");
	//$row = $stmt->fetch_assoc();
	//	$row['newPrice'];
	
	
	
	// ********** FETCH RESULTS USING PROCEDURE *************************************

	$sql = "CALL selectBooks();";
	$result = mysqli_query($mysqli, $sql);

	if (!$result) {
		echo "CALL failed 1: (" . $mysqli->errno . ") " . $mysqli->error;
		$mysqli->close();
		exit;
	}	
	
	
?>

<html>
<head>
	<title>View Books:: Using Procedure</title>
</head>

<body>
<h1> View books using stored procedure call </h1>


<table width='80%' border=0>

	<tr bgcolor='#CCCCCC'>
		<td>Book</td>
		<td>Author</td>
		<td>ISBN</td>
		<td>Price</td>
	</tr>
	<?php 
		while($res = mysqli_fetch_array($result)) { 
	
			echo "<tr>";
			echo "<td>".$res['book']."</td>";
			echo "<td>".$res['author']."</td>";
			echo "<td>".$res['isbn']."</td>";	
			echo "<td>".$res['price']."</td>";
			echo "</tr>";	
			
		}
		
		$mysqli->close();
	?>
	<tr><td colspan="4">&nbsp;</td></tr>
	<tr><td colspan="4" style="font-size:25px; color:blue; text-align:right;">Total Price: Rs. <?php echo $totalPrice; ?></td></tr>
	
	<tr><td colspan="4">&nbsp;</td></tr>
	<tr><td colspan="4" style="font-size:25px; color:green; text-align:right;">Total Tax: Rs. <?php echo $tax; ?> @ 10%</td></tr>
	
	</table>
</body>
</html>


