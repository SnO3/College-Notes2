<?php
	require_once 'login.php';
	$db_server = mysql_connect($db_hostname, $db_user, $db_pass);

	if(!$db_server) die('Unsable to connect: ' . mysql_error());

	mysql_select_db($db_database) or die('Unsable to select db: ' . mysql_error());

	$query = "SELECT * FROM ts_ppl";
	$result = mysql_query($query);

	if (!$result) die("Database access failed: " . mysql_error());

	echo mysql_result($result, 0,1);
	echo mysql_num_fields($result);
?>