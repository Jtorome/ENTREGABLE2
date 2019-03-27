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
                <form action="EliminarServicioCon" method="POST">
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
                                <th>Conductor</th>
                                <th>Fecha</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Hora encuentro</th>
                                <th>Nucleo salida</th>
                                <th>Nucleo llegada</th>
                                <th>Lugar salida</th>
                                <th>Lugar llegada</th>
                                <th>Asientos disponibles</th>
                                <th>Conductor</th>
                                <th>Fecha</th>
                                <th></th>
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
                                    <td>${service.getDriver().getName()}</td>
                                    <td>${service.getDateSer()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@ include file="footerIndexCon.jsp" %>
