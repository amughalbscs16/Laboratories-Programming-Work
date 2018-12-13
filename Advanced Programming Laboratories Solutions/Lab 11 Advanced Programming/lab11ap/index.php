<?php
if(isset($_POST['submit']))
{
	if(isset($_POST['username']) && isset($_POST['pass']))
	{
		if($_POST['username']=="admin" && $_POST['pass']=="admin")
		{
			echo "<div id='sucfail'>Login</div>";
		}
		else{
			echo "<div id='sucfail'>Failed</div>";
		}
	}
}
?>

<!DOCTYPE html>
<html>
<head>
	<title>LAB 11</title>
</head>
<body>

<FORM method="post">
	<input type="" name="username" id="user" placeholder="Username" required="">
	<input type="password" name="pass" id="pass" placeholder="Password" required="">
	<input type="submit" name="submit" value="login" id="login">
</FORM>
</body>
</html>