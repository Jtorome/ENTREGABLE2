<%-- 
    Document   : LoginConductor
    Created on : 24/03/2019, 02:11:50 AM
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
        <title>Iniciar sesion</title>
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
        <div class="card card-login mx-auto mt-5">
            <div class="card-header">Login</div>
            <div class="card-body">
                <form action="LoginConductor" method="POST">
                    <div class="form-group">
                        <label for="lblEmail">Correo</label>
                        <input type="email" name="txtEmail" class="form-control" placeholder="Ingrese correo" required="required" autofocus="autofocus">
                    </div>
                    <div class="form-group">
                        <label for="lblPassword">Contraseña</label>
                        <input type="password" name="txtPassword" class="form-control" placeholder="Password" required="required">
                    </div>
                    <div class="form-group">
                        <div class="checkbox">
                            <label>
                                Recordar contraseña
                                <input type="checkbox" value="remember-me" name="chkRecordar">
                            </label>
                        </div>
                    </div>
                    <input name="btnAceptar" type="submit" class="btn btn-primary btn-block" value="Iniciar sesion como conductor"/>
                </form>
                <div class="text-center">
                    <a class="d-block small mt-3" href="/Entregable2/Register">Registrarme</a>
                    <a class="d-block small mt-3" href="/Entregable2/Login">Atras.</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
