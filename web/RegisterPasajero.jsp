<%-- 
    Document   : Registrarme
    Created on : 23/03/2019, 11:03:24 PM
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

        <title>Registro</title>

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
        <script src="js/sweetalert.min.js" type="text/javascript"/></script>
</head>
<body class="bg-dark">
    <script>
        if (${!empty stError}) {
            swal("Mensaje", "${stError}", "error");
        }
    </script>
    <div class="container">
        <div class="card card-register mx-auto mt-5">
            <div class="card-header">Registrar como pasajero</div>
            <div class="card-body">
                <form method="POST" action="RegisterPasajero">
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                                <label for="lblNombre">Nombre</label>
                                <input type="text" name="txtName" class="form-control" placeholder="Ingrese su nombre" required="required" autofocus="autofocus">
                            </div>
                            <div class="col-md-6">
                                <label for="lblCelular">Celular</label>
                                <input type="text" name="txtCellphone" class="form-control" placeholder="Ingrese su celular" required="required">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                                <label for="lblCorreo">Correo</label>
                                <input type="txt" name="txtEmail" class="form-control" placeholder="Ingrese antes del @unal.edu.co" required="required">
                            </div>
                            <div class="col-md-6">
                                <label for="lblContrasena">Contraseña</label>
                                <input type="password" name="txtPassword" class="form-control" placeholder="Ingrese su contraseña" required="required">
                            </div>
                        </div>
                    </div>
                    <input name="btnRegistrarme" type="submit" class="btn btn-primary btn-block" value="Registrarme como pasajero"/>
                </form>
                <div class="text-center">
                    <a class="d-block small mt-3" href="/Entregable2/Login">Iniciar sesion</a>
                    <a class="d-block small mt-3" href="/Entregable2/Register">Atras.</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
