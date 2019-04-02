<%-- 
    Document   : Index
    Created on : 24/03/2019, 12:36:10 AM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="headerIndexPas.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <div id="content-wrapper">
            <div class="container-fluid">
                <form action="IndexPasajero" method="GET"><input type="submit" hidden=""></form>
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-table"></i>
                        Servicios disponibles
                        <form action="IndexPasajero" method="GET">
                            <input type="submit" class="fas fa-table" value="Actualizar">
                        </form>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Tomar y numero de asientos.</th>
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
                                        <th>Tomar y numero de asientos.</th>
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
                                            <td><form action="TomarServicioPas" method="POST"><select type="number" name="txtSeats" class="form-control" required="required" autofocus>
                                                        <option value=1>1</option>
                                                        <option value=2>2</option>
                                                    </select>
                                                    <input type="txt" name="txtMeetingTime" hidden="" value="${service.getMeetingTime()}">
                                                    <input type="txt" name="txtEmail" hidden="" value="${service.getDriver().getEmail()}">
                                                    <input type="txt" name="txtDateSer" hidden="" value="${service.getDateSer()}">
                                                    <input type="submit" class="fas fa-table" value="Tomar"></form></td>
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


                <%@ include file="footerIndexPas.jsp" %>