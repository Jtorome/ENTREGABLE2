<%-- 
    Document   : MejorCalificadosPas
    Created on : 3/04/2019, 11:52:38 AM
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
                Pasajeros con mejor promedio:
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Calificacion promedio</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Nombre</th>
                                <th>Calificacion promedio</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${BestRiders}" var="rider">
                                <tr>
                                    <td>${rider.getName()}</td>
                                    <td>${rider.getAverageScore()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@ include file="footerIndex.jsp" %>