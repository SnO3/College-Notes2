<?php
	require_once 'login.php'

	$db_server = mysql_connect($db_hostname, $db_user, $db_pass);
	if(!$db_server) die("Problem connecting to server: " . mysql_error());

	mysql_select_db($db_database) or die('Could not select database: ' . mysql_error());

	//initialize result to get all info from table ts_ppl
	$query= "SELECT * FROM ts_ppl";
	$result= mysql_query($query);

	for($i = 0; $i<mysql_num_fields($result); ++$i)
	{
		for($j = 0; $j<mysql_num_rows($result); ++$j)
		{
			"INSERT INTO ts_ppl(customer_id,customer_name,address1,address2,city,state,zip,home phone,business phone,email,license,year,make,model,engine,vin,mileage,date)"
		}
	}
?>