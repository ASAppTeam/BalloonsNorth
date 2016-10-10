<?php
// check if a form was submitted

if( !empty( $_POST ) ){

// convert form data to json format
    $postArray = array(
    	"sale1" => array(
      "sale1_headline" => $_POST['sale1_headline'],
      "sale1_details" => $_POST['sale1_details']),
    	"sale2" => array(
      "sale2_headline" => $_POST['sale2_headline'],
      "sale2_details" => $_POST['sale2_details']),
    	"sale3" => array(
      "sale3_headline" => $_POST['sale3_headline'],
      "sale3_details" => $_POST['sale3_details']),
    	"sale4" => array(
      "sale4_headline" => $_POST['sale4_headline'],
      "sale4_details" => $_POST['sale4_details']),
    ); //you might need to process any other post fields you have..

$json = json_encode( $postArray );
// make sure there were no problems
//if( json_last_error() != JSON_ERROR_NONE ){
    //exit;  // do your error handling here instead of exiting
// }
$file = 'sales_json.json';
// write to file
//   note: _server_ path, NOT "web address (url)"!
file_put_contents($file, $json);
}