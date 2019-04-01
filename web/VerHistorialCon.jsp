<%-- 
    Document   : VerHistorialCon
    Created on : 1/04/2019, 12:40:52 AM
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
                Mi historial
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Revisar</th>
                                <th>Hora encuentro</th>
                                <th>Nucleo salida</th>
                                <th>Nucleo llegada</th>
                                <th>Lugar salida</th>
                                <th>Lugar llegada</th>
                                <th>Numero de pasajeros</th>
                                <th>Calificacion promedio</th>
                                <th>Fecha</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Revisar</th>
                                <th>Hora encuentro</th>
                                <th>Nucleo salida</th>
                                <th>Nucleo llegada</th>
                                <th>Lugar salida</th>
                                <th>Lugar llegada</th>
                                <th>Numero de pasajeros</th>
                                <th>Calificacion promedio</th>
                                <th>Fecha</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${InfoUsuario.getServiceListDri()}" var="service">
                                <tr>
                                    <td><form action="RevisarServicioCon" method="POST">
                                            <input type="txt" name="txtMeetingTime" hidden="" value="${service.getMeetingTime()}">
                                            <input type="txt" name="txtEmail" hidden="" value="${service.getDriver().getEmail()}">
                                            <input type="txt" name="txtDateSer" hidden="" value="${service.getDateSer()}">
                                            <input type="submit" class="fas fa-table" value="Revisar"></form></td>
                                    <td>${service.getMeetingTime()}</td>
                                    <td>${service.getOutputCore()}</td>
                                    <td>${service.getArrivalNucleus()}</td>
                                    <td>${service.getStartPlace()}</td>
                                    <td>${service.getEndPlace()}</td>
                                    <td>${service.getRidersList().size()}</td>
                                    <td>${service.getAverageScoreSer()}</td>
                                    <td>${service.getDateSer()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@ include file="footerIndexCon.jsp" %>