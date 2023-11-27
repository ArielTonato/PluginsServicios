<?php

include_once 'seleccion.php';

$opcion = $_SERVER['REQUEST_METHOD'];
switch($opcion){
    case 'GET':
        if(isset($_GET['cedula'])){
            Crud::buscarEstudiante($_GET['cedula']);
        }else{
            Crud::verEstudiantes();
        }

        break;
    case 'POST':
        Crud::ingresarEstudiante();
        break;
    case 'PUT':
        $cedula = $_GET['cedula'];
        $nombre = $_GET['nombre'];
        $apellido = $_GET['apellido'];
        $direccion = $_GET['direccion'];
        $telefono = $_GET['telefono'];
        Crud::actualizarEstudiante($cedula,$nombre,$apellido,$direccion,$telefono);
        break;
    case 'DELETE':
        $cedula = $_GET['cedula'] ;
        Crud::eliminarEstudiante($cedula);
        break;      
}