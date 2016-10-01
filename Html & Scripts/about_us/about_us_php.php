<?php
// check if a form was submitted
if( !empty( $_POST ) ){

// convert form data to json format
    $postArray = array(
      "about_us_text" => $_POST['about_us_text']
    ); //you might need to process any other post fields you have..

$json = json_encode( $postArray );
// make sure there were no problems
//if( json_last_error() != JSON_ERROR_NONE ){
    //exit;  // do your error handling here instead of exiting
// }
$file = 'about_us_json.json';
// write to file
//   note: _server_ path, NOT "web address (url)"!
file_put_contents( $file, $json);
}