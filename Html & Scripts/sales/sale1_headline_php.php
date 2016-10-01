<?php

$sale1_headline = $_POST['sale1_headline'];

// check if a form was submitted
if( !empty( $_POST) ){

// convert form data to json format
    $postArray = array(
      "sale1_headline" => $sale1_headline
    ); //you might need to process any other post fields you have..

$json = json_encode( $postArray );
// make sure there were no problems
//if( json_last_error() != JSON_ERROR_NONE ){
    //exit;  // do your error handling here instead of exiting
// }
$file = 'sale1_headline_json.json';
// write to file
//   note: _server_ path, NOT "web address (url)"!
file_put_contents( $file, $json);
}