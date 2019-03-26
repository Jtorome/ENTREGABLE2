<%-- 
    Document   : IndexVerVehiculosCon
    Created on : 26/03/2019, 04:32:44 PM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="headerIndexCon.jsp" %>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <form action="IndexConductor" method="GET"><input type="submit" hidden=""></form>
        <div class="card mb-3">
            <div class="card-header">
                <i class="fas fa-table"></i>
                Servicios disponibles
                <form action="IndexConductor" method="GET">
                    <input type="submit" class="fas fa-table" value="Actualizar">
                </form>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Placa</th>
                                <th>Color</th>
                                <th>Tipo de vehiculo</th>
                                <th>Modelo de vehiculo</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Placa</th>
                                <th>Color</th>
                                <th>Tipo de vehiculo</th>
                                <th>Modelo de vehiculo</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${InfoUsuario.getVehiclesList()}" var="vehi">
                                <tr>
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

        <%@ include file="footerIndexCon.jsp" %> 
