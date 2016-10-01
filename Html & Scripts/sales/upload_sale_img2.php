<?php
$ftp_server = "********";
$ftp_user_name = "********";
$ftp_user_pass = "********";

$destination_file = "sale_img2.png";
$source_file = $_FILES['uploadedfile']['tmp_name'];
$uploadOk = 1;

// set up basic connection
$conn_id = ftp_connect($ftp_server);
ftp_pasv($conn_id, true);

// login with username and password
$login_result = ftp_login($conn_id, $ftp_user_name, $ftp_user_pass); 

// check connection
if ((!$conn_id) || (!$login_result)) { 
    echo "FTP connection has failed!";
    echo "Attempted to connect to ftp_server"; 
    exit; 
} else {
    echo "Connected to ftp_server"."<br>"."<br>";
}

if ($uploadOk) {
	// upload the file
	$destination_path = "/public_html/balloons_north/sales/";
	$upload = ftp_put($conn_id, $destination_path.$destination_file, $source_file, FTP_BINARY); 

	// check upload status
	if (!$upload) { 
    	echo "FTP upload has failed!"."<br>"."<br>";
	} else {
	    echo "Uploaded to ftp_server as $destination_file"."<br>"."<br>";
	}
} else {
	echo "Sorry, your file was not uploaded."."<br>"."<br>";

}
// close the FTP stream 
ftp_close($conn_id);
?>