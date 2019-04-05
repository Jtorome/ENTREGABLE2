<%-- 
    Document   : ComentarCon
    Created on : 4/04/2019, 11:20:51 PM
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
        <title>Comentar</title>
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
    <div class="container">
        <div class="card card-login mx-auto mt-5">
            <div class="card-header">Comentar</div>
            <div class="card-body">
                <form action="ComentarCon" method="POST">
                    <div class="form-group">
                        <label for="lblEmail">Comentario</label>
                        <input type="text" name="txtComentario" class="form-control" placeholder="Muy buena pagina" required="required" autofocus="autofocus">
                    </div>
                    <input name="btnAceptar" type="submit" class="btn btn-primary btn-block" value="Comentar"/>
                </form>
                <div class="text-center">
                    <a class="d-block small mt-3" href="/Entregable2/IndexConductor">Atras.</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>