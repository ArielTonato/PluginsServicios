<?php 

class Conexion{
    public function conectar(){
        try{
            $conexion = new PDO("mysql:host=localhost;dbname=pruebas","root","admin");
        }catch(Exception $e){
            echo $e -> getMessage();
        }
        return $conexion;
    }
}
