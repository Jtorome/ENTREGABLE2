<%-- 
    Document   : RutaFavoritaPas
    Created on : 4/04/2019, 04:06:09 PM
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
                Ruta favorita
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Veces tomada</th>
                                <th>Nucleo de salida</th>
                                <th>Nucleo de llegada</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Veces tomada</th>
                                <th>Nucleo de salida</th>
                                <th>Nucleo de llegada</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${FavoriteRoute}" var="Route">
                                <tr>
                                    <td>${Route.split(",")[2]}</td>
                                    <td>${Route.split(",")[0]}</td>
                                    <td>${Route.split(",")[1]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@ include file="footerIndex.jsp" %>