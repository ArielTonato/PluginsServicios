<?php 
include_once 'conexion.php';
class Crud{
    public static function verEstudiantes(){
        $conexion = new Conexion();
        $conectar = $conexion ->conectar();
        $consulta = "SELECT * FROM estudiante";
        $resultado = $conectar->prepare($consulta);
        $resultado->execute();
        $data = $resultado->fetchAll(PDO::FETCH_ASSOC);
        echo json_encode($data);
    }


    public static function ingresarEstudiante(){
        $conexion = new Conexion();
        $conectar = $conexion ->conectar();
        $cedula = $_POST['cedula'];
        $nombre = $_POST['nombre'];
        $apellido = $_POST['apellido'];
        $direccion = $_POST['direccion'];
        $telefono = $_POST['telefono'];
        $consulta = "INSERT INTO estudiante (cedula, nombre, apellido, direccion, telefono) 
        VALUES ('$cedula','$nombre','$apellido','$direccion','$telefono')";
        $resultado = $conectar -> prepare($consulta);
        echo json_encode($_POST);
        $resultado -> execute();
    }

    public static function buscarEstudiante($cedula){
        $conexion = new Conexion();
        $conectar = $conexion ->conectar();
        $consulta = "SELECT * FROM estudiante WHERE cedula = '$cedula'";
        $resultado = $conectar->prepare($consulta);
        $resultado->execute();
        $data = $resultado->fetchAll(PDO::FETCH_ASSOC);
        echo json_encode($data);
    }

    public static function actualizarEstudiante($cedula, $nombre, $apellido, $direccion, $telefono){
        $conexion = new Conexion();
        $conectar = $conexion ->conectar();
        $consulta = "UPDATE estudiante SET nombre='$nombre', apellido='$apellido', direccion='$direccion', telefono='$direccion'
        WHERE cedula = '$cedula'";
        $resultado = $conectar -> prepare($consulta);
        $resultado -> execute();

    }

    public static function eliminarEstudiante($cedula){
        $conexion = new Conexion();
        $conectar = $conexion ->conectar();
        $consulta = "DELETE FROM estudiante WHERE cedula = '$cedula'";
        $resultado = $conectar -> prepare($consulta);
        $resultado -> execute();
    }
}