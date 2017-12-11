<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "eventosbd";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$convidado = htmlspecialchars($_POST["convidado"]);
$email = htmlspecialchars($_POST["email"]);
$evento_id = htmlspecialchars($_POST["evento_id"]);


$sql = "INSERT INTO convidados (convidado, email, evento_id)
VALUES ('$convidado', '$email', '$evento_id')";

if ($conn->query($sql) === TRUE) {
    $last_id = $conn->insert_id;
   
    $convidado = array("id" => $last_id,  
                      "convidado" => $convidado,
                      "email" => $email,
                      "evento_id" => $evento_id);
    echo json_encode($convidado);
} else {
    $proposta = array("id" => 0,
                      "cliente" => "", 
                      "email" => "",
                      "proposta" => "",
                      "carro_id" => 0);
    echo json_encode($proposta);
}

$conn->close();
?>