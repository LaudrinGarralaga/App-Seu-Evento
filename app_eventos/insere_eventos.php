<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "app_seuevento";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$nome = htmlspecialchars($_POST["nome"]);
$local = htmlspecialchars($_POST["local"]);
$atracao = htmlspecialchars($_POST["atracao"]);
$data = htmlspecialchars($_POST["data"]);
$detalhes = htmlspecialchars($_POST["detalhes"]);



$sql = "INSERT INTO eventos(nome, local, atracao, data, detalhes)
VALUES ('$nome', '$local', '$atracao', '$data', '$detalhes')";

if ($conn->query($sql) === TRUE) {
    $last_id = $conn->insert_id;
   
    $evento = array("id" => $last_id,  
                      "nome" => $nome,
                      "local" => $local,
                      "atracao" => $atracao,
                      "data" => $data,
                      "detalhes" => $detalhes);
                      
    echo json_encode($evento);
} else {
    $evento = array("id" => 0,
                      "nome" => "",
                      "local" => "",
                      "atracao" => "",
                      "data" => "",         
		      "detalhes" => "");
                                                
    echo json_encode($evento);
}

$conn->close();
?>