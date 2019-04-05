<%-- 
    Document   : MejorCalificadosCon
    Created on : 3/04/2019, 12:37:50 AM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="headerIndexCon.jsp" %>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <div class="card mb-3">
            <div class="card-header">
                <i class="fas fa-table"></i>
                Conductores con mejor acumulado:
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Acumulado de calificaciones</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Nombre</th>
                                <th>Acumulado de calificaciones</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${BestDrivers}" var="driver">
                                <tr>
                                    <td>${driver.getName()}</td>
                                    <td>${driver.getAccumulatedRating()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@ include file="footerIndex.jsp" %>