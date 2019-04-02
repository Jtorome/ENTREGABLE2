<%-- 
    Document   : ServiciosPorCalificar
    Created on : 31/03/2019, 10:44:32 PM
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
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-table"></i>
                        Servicios por calificar
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Calificacion y descripcion.</th>
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
                                        <th>Calificacion y descripcion.</th>
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
                                    <c:forEach items="${InfoUsuario.getUnqualifiedService()}" var="service">
                                        <tr>
                                            <td><form action="CalificarServicioPas" method="POST"><select type="number" name="nbScore" class="form-control" required="required" autofocus>
                                                        <option value=1>1</option>
                                                        <option value=2>2</option>
                                                        <option value=3>3</option>
                                                        <option value=4>4</option>
                                                        <option value=5>5</option>
                                                    </select>
                                                    <input type="txt" name="txtDescription" class="form-control" placeholder="Descripcion:">
                                                    <input type="txt" name="txtMeetingTime" hidden="" value="${service.getMeetingTime()}">
                                                    <input type="txt" name="txtEmail" hidden="" value="${service.getDriver().getEmail()}">
                                                    <input type="txt" name="txtDateSer" hidden="" value="${service.getDateSer()}">
                                                    <input type="submit" class="fas fa-table" value="Calificar"></form></td>
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