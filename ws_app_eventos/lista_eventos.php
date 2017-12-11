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

$sql = "SELECT * FROM eventos";
$result = $conn->query($sql);

$eventos = array();


if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        $evento[] = array("id"=>utf8_encode($row['id']),
                         "nome"=>utf8_encode($row["nome"]),
                         "local"=>utf8_encode($row["local"]),
 			 "atracao"=>utf8_encode($row["atracao"]),
 			 "data"=>utf8_encode($row["data"]),
                         "detalhes"=>utf8_encode($row["detalhes"]),
                         "preco"=>utf8_encode($row["preco"]));                        
    }
 
}

$conn->close();


//$carros = array("eventos"=> $eventos);
echo json_encode($evento, JSON_PRETTY_PRINT);