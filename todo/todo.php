<?php 
//echo '<p>Hello World</p>'; 

$script_request = $_POST['json_data'];

$conn = new mysqli("127.0.0.1", "root", "", "trest", 3306);

if ($conn->connect_errno) {
    echo "Не удалось подключиться к MySQL: (" . $conn->connect_errno . ") " . $conn->connect_error;
}

$obj = json_decode($script_request);
//email:userEmail,password:userPassword,username
//print $obj->{'email'}; // 12345
//print $obj->{'password'};
//print $obj->{'username'};
//echo 'action='.$obj->{'action'}.' username='.$obj->{'username'}.' email='.$obj->{'email'}.' password='.$obj->{'password'};
if(strcmp($obj->{'action'},'register')===0){
    $sql = "SELECT email,password,name FROM todousers WHERE email='".$obj->{'email'};
    $result = $conn->query($sql);
    if ($result->num_rows > 0) {
        
            $response=array('result'=>'Error','show'=>'Registration error. User with e-mail '.$obj->{'email'}.' already exists.','username'=>'');
    }
    else{

            $sql = "insert into todousers (name,email,password) values(".$obj->{'username'}.",".$obj->{'email'}.",".$obj->{'password'}.")";

            if ($conn->query($sql) === TRUE) {
                $array = array('result'=>'success','show'=>'User '.$obj->{'username'}.' created successfully.','username'=>'');
            }
            else {
               $array = array('result'=>'error','show'=>'User '.$obj->{'username'}.' could not be created','username'=>'');
            }  
    }

}
elseif(strcmp($obj->{'action'},'auth')===0){
    $sql = "SELECT email,pswd,name FROM todousers WHERE email='".$obj->{'email'}."' AND pswd='".$obj->{'password'}."'";
   // echo "\nSELECT email,pswd,name FROM todousers WHERE email='".$obj->{'email'}."' and pswd='".$obj->{'password'}."'\n";
    $result = $conn->query($sql);
    //echo '\nresult_rows='.$result->num_rows.'\n';
    //if($result === TRUE){
        if ($result->num_rows > 0) {
            //echo 111111;
            while($row = $result->fetch_assoc()) {
                $array = array('result'=>'success','show'=>'User '.$row['name'].' recognized.','username'=>$row['name']);
                break;
            }
        }
        else{
            //echo 222222;
            $array = array('result'=>'error','show'=>'User '.$obj->{'email'}.' can not be authenticate','username'=>'');
        }
    // }
    // else{
    //     $array = array('result'=>'error','show'=>'User '.$obj->{'email'}.' can not be authenticate','username'=>'');
    // }
}

echo json_encode($array);

$conn->close();



?>