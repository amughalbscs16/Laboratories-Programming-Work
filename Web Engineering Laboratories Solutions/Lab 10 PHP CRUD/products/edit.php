<?php include_once("validate-session.php");?>


<?php
// including the database connection file
include_once("..\config\config.php");

if(isset($_POST['update']))
{	
	$id = $_POST['id'];
	
	$name = $_POST['name'];
	$qty = $_POST['qty'];
	$price = $_POST['price'];	
	
	// checking empty fields
	if(empty($name) || empty($qty) || empty($price)) {
				
		if(empty($name)) {
			echo "<font color='red'>Name field is empty.</font><br/>";
		}
		
		if(empty($qty)) {
			echo "<font color='red'>Quantity field is empty.</font><br/>";
		}
		
		if(empty($price)) {
			echo "<font color='red'>Price field is empty.</font><br/>";
		}		
	} else {	
		$target_dir = "images/";
		$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
		$uploadOk = 1;
		$imageFileType = pathinfo($target_file,PATHINFO_EXTENSION);
		
		if(!empty($_FILES['fileToUpload']['name'])){
			// Check if image file is a actual image or fake image
			$check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
			
			if($check !== false) {
				$uploadOk = 1;
			} else {
				echo "File is not an image.";
				$uploadOk = 0;
			}
						
			// Check file size
			if ($_FILES["fileToUpload"]["size"] > 500000) {
				echo "Sorry, your file is too large.";
				$uploadOk = 0;
			}
			
			// Allow certain file formats
			if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"
			&& $imageFileType != "gif" ) {
				echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
				$uploadOk = 0;
			}
			// Check if $uploadOk is set to 0 by an error
			if ($uploadOk == 0) {
				echo "Sorry, your file was not uploaded.";
			} 
			else { // if everything is ok, try to upload file
				if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
					echo 'file uploaded!!';
					$result = mysqli_query($mysqli, "UPDATE products SET name='$name', qty='$qty', price='$price', img_path='$target_file' WHERE id=$id");
					if(!$result){
						echo mysqli_error($mysqli);
						exit;
						
					}
					header("Location: index.php");
					//echo "The file ". basename( $_FILES["fileToUpload"]["name"]). " has been uploaded.";
					
				} else {
					echo "Sorry, there was an error uploading your file.";
					exit;
				}
			}			
		}
		else{
			//updating the table
			$result = mysqli_query($mysqli, "UPDATE products SET name='$name', qty='$qty', price='$price' WHERE id=$id");
			
			//redirectig to the display page. In our case, it is index.php
			header("Location: index.php");
			
		}
		
	}
	
}
?>
<?php
//getting id from url
$id = $_GET['id'];

//selecting data associated with this particular id
$result = mysqli_query($mysqli, "SELECT id, name, qty, price, img_path, login_id FROM products WHERE id=$id");

while($res = mysqli_fetch_array($result)){
	$name = $res['name'];
	$qty = $res['qty'];
	$price = $res['price'];
	$imagePath = $res['img_path'];
}
?>
<html>
<head>	
	<title>Edit Data</title>
</head>

<body>
	<?php include_once("header.php");?>
	<br/><br/>
	
	<form name="form1" method="post" action="edit.php" enctype="multipart/form-data">
		<table border="0">
			<tr> 
				<td>Name</td>
				<td><input type="text" name="name" value="<?php echo $name;?>"></td>
			</tr>
			<tr> 
				<td>Quantity</td>
				<td><input type="text" name="qty" value="<?php echo $qty;?>"></td>
			</tr>
			<tr> 
				<td>Price</td>
				<td><input type="text" name="price" value="<?php echo $price;?>"></td>
			</tr>
			<tr> 
				<td>Product Image</td>
				<td><img src="<?php echo $imagePath;?>" width="100px;" /></td>
			</tr>
			<tr> 
				<td>Select Product Image</td>
				<td><input type="file" name="fileToUpload" id="fileToUpload"></td>
			</tr>
			
			<tr>
				<td><input type="hidden" name="id" value=<?php echo $_GET['id'];?>></td>
				<td><input type="submit" name="update" value="Update"></td>
			</tr>
		</table>
	</form>
</body>
</html>
