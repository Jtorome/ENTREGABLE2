<%-- 
    Document   : indexHeaderPas
    Created on : 26/03/2019, 03:08:01 PM
    Author     : jujma
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

        <title>index</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

        <!-- Page level plugin CSS-->
        <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugin JavaScript-->
        <script src="vendor/chart.js/Chart.min.js"></script>
        <script src="vendor/datatables/jquery.dataTables.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin.min.js"></script>

        <!-- Demo scripts for this page-->
        <script src="js/demo/datatables-demo.js"></script>
        <script src="js/demo/chart-area-demo.js"></script>
        <link href="css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <script src="js/sweetalert.min.js" type="text/javascript"/></script>
</head>
<body id="page-top">
    <script type="text/javascript">
        if (${empty InfoUsuario}) {
            window.location = "/Entregable2/Login";
        }
        if (${!empty stError}) {
            swal("Mensaje", "${stError}", "error");
        }
        if (${!empty stExito}){
            swal("Mensaje", "${stExito}", "success");
        }
    </script>
    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

        <a class="navbar-brand mr-1" href="/Entregable2/IndexPasajero">S.T.A.I.N</a>
        <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
            <i class="fas fa-bars"></i>
        </button>
        <a class="navbar-brand mr-1" href="/Entregable2/IndexPasajero">PASAJERO</a>
        <i class="fas fa-2x fa-male "></i>
        <ul class="navbar-nav ml-auto mr-0 mr-md-3 my-2 my-md-0">
            <li class="nav-item dropdown no-arrow">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user-circle fa-fw"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
                    <a class="dropdown-item" href="/Entregable2/VerPerfilPas">Ver perfil</a>
                    <div class="dropdown-divider"></div>
                    <form action="LogOut" method="POST">
                        <input name="btnAceptar" type="submit" class="dropdown-item" value="Cerrar sesion"/>
                    </form>
                </div>
            </li>
        </ul>

    </nav>

    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="sidebar navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Opciones</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <h6 class="dropdown-header">Sobre servicios:</h6>
                    <a class="dropdown-item" href="/Entregable2/VerViajeActualPas">Informacion de mi viaje.</a>
                    <a class="dropdown-item" href="/Entregable2/VerHistorialPas">Ver mi historial.</a>
                    <div class="dropdown-divider"></div>
                    <h6 class="dropdown-header">Otras paginas</h6>
                    <a class="dropdown-item" href="/Entregable2/CalificarServicioPas">Calificar (${InfoUsuario.getUnqualifiedService().size()})</a>
                    <a class="dropdown-item" href="/Entregable2/Comentar">Comentar</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="OpcionDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Tops</span>
                </a>
                <div class="dropdown-menu" aria-labelledby="OpcionDropdown">
                    <h6 class="dropdown-header">Sobre servicios:</h6>
                    <form action="RutaFavorita" method="POST">
                        <input type="text" name="cual" hidden="" value="Pasajero">
                        <input type="submit" class="dropdown-item" value="Ruta favorita.">
                    </form>
                    <form action="HoraMasConcurrida" method="POST">
                        <input type="text" name="cual" hidden="" value="Pasajero">
                        <input type="submit" class="dropdown-item" value="hora favorita.">
                    </form>
                    <form action="VehiculoFavorito" method="POST">
                        <input type="text" name="cual" hidden="" value="Pasajero">
                        <input type="submit" class="dropdown-item" value="Vehiculo favorito.">
                    </form>
                    <div class="dropdown-divider"></div>
                    <h6 class="dropdown-header">Sobre conductores:</h6>
                    <form action="MejorConductores" method="POST">
                        <input type="text" name="cual" hidden="" value="Pasajero">
                        <input type="submit" class="dropdown-item" value="Mejor calificados.">
                    </form>
                    <form action="MasViajesConductor" method="POST">
                        <input type="text" name="cual" hidden="" value="Pasajero">
                        <input type="submit" class="dropdown-item" value="Mas viajes hechos.">
                    </form>
                    <h6 class="dropdown-header">Sobre Pasajeros:</h6>
                    <form action="MejorPasajeros" method="POST">
                        <input type="text" name="cual" hidden="" value="Pasajero">
                        <input type="submit" class="dropdown-item" value="Mejor calificados.">
                    </form>
                </div>
            </li>