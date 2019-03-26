<%-- 
    Document   : AddVehiculo
    Created on : 24/03/2019, 04:17:49 PM
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
        if (${empty InfoUsuario}) {
            window.location="RegisterConductor";
        }
    </script>
    <div class="container">
        <div class="card card-register mx-auto mt-5">
            <div class="card-header">Registrar vehiculo</div>
            <div class="card-body">
                <form method="POST" action="AddVehiculo">
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                                <label for="lblLincensePlate">Placa</label>
                                <input type="text" name="txtLicensePlate" class="form-control" placeholder="Ingrese la placa del vehiculo" required="required" autofocus="autofocus">
                            </div>
                            <div class="col-md-6">
                                <label for="lblColor">Color</label>
                                <input type="text" name="txtColor" class="form-control" placeholder="Ingrese el color del vehiculo" required="required">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-3">
                                <label for="lblType">Tipo de vehiculo</label>
                                <select type="email" name="txtType" class="form-control" required="required" autofocus>
                                    <option value="Carro">Carro</option>
                                    <option value="Moto">Moto</option>
                                </select>
                            </div>
                            <div class="col-md-6">
                                <label for="lblModel">Modelo del vehiculo</label>
                                <input type="text" name="txtModel" class="form-control" placeholder="Ingrese el modelo." required="required">
                            </div>
                        </div>
                    </div>
                    <input name="btnRegistrarme" type="submit" class="btn btn-primary btn-block" value="Registrar vehiculo"/>
                </form>
                <div class="text-center">
                    <a class="d-block small mt-3" href="LoginConductor">Cancelar</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
