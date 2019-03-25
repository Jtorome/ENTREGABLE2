<%-- 
    Document   : Registro
    Created on : 24/03/2019, 10:43:47 AM
    Author     : juana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Registrar</title>
        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <link href="css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <script src="js/sweetalert.min.js" type="text/javascript"/>

        <script>
            swal("BUEN TRABAJO!", "Se realizo el proceso con exito!", "success")
        </script>
    </head>
    <body class="bg-dark" onload="mensaje()">

        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Login</div>
                <div class="card-body">
                    <div class="text-center">
                        <a class="btn btn-primary btn-block" href="RegisterPasajero">Registrarme como pasajero</a>
                        <a class="btn btn-primary btn-block" href="RegisterConductor">Registrarme como conductor</a>
                        <a class="btn btn-primary btn-block" href="Start">Atras</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
