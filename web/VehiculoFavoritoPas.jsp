<%-- 
    Document   : VehiculoFavoritoPas
    Created on : 4/04/2019, 06:30:13 PM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="headerIndexPas.jsp" %>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <div class="card mb-3">
            <div class="card-header">
                <i class="fas fa-table"></i>
                Vehiculos favoritos:
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Usado en</th>
                                <th>Tipo</th>
                                <th>Modelo</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>servicios</th>
                                <th>Tipo</th>
                                <th>Modelo</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${FavoriteVehicle}" var="Vehicle">
                                <tr>
                                    <td>${Vehicle.split(",")[2]}</td>
                                    <td>${Vehicle.split(",")[0]}</td>
                                    <td>${Vehicle.split(",")[1]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@ include file="footerIndex.jsp" %>