<%-- 
    Document   : IndexAdmin
    Created on : 5/04/2019, 12:15:42 AM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="headerIndexAdmin.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <div id="content-wrapper">
            <div class="container-fluid">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-table"></i>
                        Servicios disponibles
                        <form action="IndexAdmin" method="GET">
                            <input type="submit" class="fas fa-table" value="Actualizar">
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
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <c:forEach items="${AvailableService}" var="service">
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
                <!-- /.container-fluid -->


                <%@ include file="footerIndex.jsp" %>