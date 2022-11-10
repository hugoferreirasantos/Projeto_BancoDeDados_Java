<?php
require_once "conexao.php";

$consulta = $pdo->query("SELECT * FROM  Agenda");
echo "<table border=1>
<tr>
  <td>ID</td>
  <td>NOME</td>
  <td>EVENTO</td>
  <td>DESCRIÇÃO DO EVENTO</td>
</tr>";

while($linha = $consulta->fetch(PDO::FETCH_ASSOC)){
    echo"
    <tr>
    <td>{$linha['id']}</td>
    <td>{$linha['nome']}</td>
    <td>{$linha['evento']}</td>
    <td>{$linha['descEvento']}</td>
    </tr>
    ";
}



?>