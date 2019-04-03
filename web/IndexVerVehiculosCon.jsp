<%-- 
    Document   : IndexVerVehiculosCon
    Created on : 26/03/2019, 04:32:44 PM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="headerIndexCon.jsp" %>
<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" href="#" id="OpcionDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <i class="fas fa-fw fa-folder"></i>
        <span>Menu vehiculos.</span>
    </a>
    <div class="dropdown-menu" aria-labelledby="OpcionDropdown">
        <h6 class="dropdown-header">Sobre vehiculos:</h6>
        <a class="dropdown-item" href="IndexAddVehiCon.jsp">Registrar vehiculo.</a>
        <div class="dropdown-divider"></div>
        <h6 class="dropdown-header">Other Pages:</h6>
        <a class="dropdown-item" href="404.html">404 Page</a>
        <a class="dropdown-item" href="blank.html">Blank Page</a>
    </div>
</li>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <div class="card mb-3">
            <div class="card-header">
                <i class="fas fa-table"></i>
                Mis vehiculos
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Eliminar</th>
                                <th>Placa</th>
                                <th>Color</th>
                                <th>Tipo de vehiculo</th>
                                <th>Modelo de vehiculo</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Eliminar</th>
                                <th>Placa</th>
                                <th>Color</th>
                                <th>Tipo de vehiculo</th>
                                <th>Modelo de vehiculo</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${InfoUsuario.getVehiclesList()}" var="vehi">
                                <tr>
                                    <td><form action="EliminarVehiculoCon" method="POST">
                                            <input type="txt" name="txtLicensePlate" hidden="" value="${vehi.getLicensePlate()}">
                                            <input type="submit" class="fas fa-table" value="Eliminar"></form></td>
                                    <td>${vehi.getLicensePlate()}</td>
                                    <td>${vehi.getColor()}</td>
                                    <td>${vehi.getVehicleType()}</td>
                                    <td>${vehi.getVehiculeModel()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@ include file="footerIndex.jsp" %> 
