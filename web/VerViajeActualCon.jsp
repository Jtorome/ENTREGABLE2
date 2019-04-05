<%-- 
    Document   : VerViajeActualCon
    Created on : 26/03/2019, 03:03:48 PM
    Author     : juana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ include file="headerIndexCon.jsp" %>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <div class="card mb-3">
            <div class="card-header">
                <i class="fas fa-table"></i>
                Mi viaje actual es:
                <form action="EliminarServicio" method="POST">
                    <input type="text" name="Controller" hidden="" class="fas fa-table" value="Conductor">
                    <input type="submit" class="fas fa-table" value="Eliminar">
                </form>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Hora encuentro</th>
                                <th>Nucleo salida</th>
                                <th>Nucleo llegada</th>
                                <th>Lugar salida</th>
                                <th>Lugar llegada</th>
                                <th>Asientos disponibles</th>
                                <th>Fecha</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${InfoUsuario.getCurrentService()}" var="service">
                                <tr>
                                    <td>${service.getMeetingTime()}</td>
                                    <td>${service.getOutputCore()}</td>
                                    <td>${service.getArrivalNucleus()}</td>
                                    <td>${service.getStartPlace()}</td>
                                    <td>${service.getEndPlace()}</td>
                                    <td>${service.getAvailableSeats()}</td>
                                    <td>${service.getDateSer()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="card mb-3">
            <div class="card-header">
                <i class="fas fa-table"></i>
                Pasajeros:
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Eliminar</th>
                                <th>Nombre</th>
                                <th>Email</th>
                                <th>Celular</th>
                                <th>Calificacion promedio</th>
                                <th>Asientos tomados</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:if test="${!InfoUsuario.getCurrentService().isEmpty()}">
                                <c:forEach items="${InfoUsuario.getCurrentService().get(0).getRidersList()}" var="rider">
                                    <tr>
                                        <td><form action="EliminarPasajeroCon" method="POST">
                                                <input type="txt" name="txtEmail" hidden="" value="${rider.getEmail()}">
                                                <input type="submit" class="fas fa-table" value="Eliminar">
                                            </form></td>
                                        <td>${rider.getName()}</td>
                                        <td>${rider.getEmail()}</td>
                                        <td>${rider.getCellPhone()}</td>
                                        <td>${rider.getAverageScore()}</td>
                                        <td>${InfoUsuario.getCurrentService().get(0).getRiderxSeat().get(rider)}</td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@ include file="footerIndex.jsp" %>
