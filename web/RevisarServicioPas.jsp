<%-- 
    Document   : RevisarServicioPas
    Created on : 2/04/2019, 12:40:09 AM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="headerIndexPas.jsp" %>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <div id="content-wrapper">
            <div class="container-fluid">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-table"></i>
                        Información sobre el viaje:
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
                                <tbody>
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
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-table"></i>
                        Informacion del conductor:
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Correo</th>
                                        <th>Celular</th>
                                        <th>Numero de servicios</th>
                                        <th>Acumulado de calificaciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${service.getDriver().getName()}</td>
                                        <td>${service.getDriver().getEmail()}</td>
                                        <td>${service.getDriver().getCellPhone()}</td>
                                        <td>${service.getDriver().getServicesNumber()}</td>
                                        <td>${service.getDriver().getAccumulatedRating()}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-table"></i>
                        Informacion del vehiculo:
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Placa</th>
                                        <th>Color</th>
                                        <th>Tipo</th>
                                        <th>Modelo</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${service.getVehicle().getLicensePlate()}</td>
                                        <td>${service.getVehicle().getColor()}</td>
                                        <td>${service.getVehicle().getVehicleType()}</td>
                                        <td>${service.getVehicle().getVehiculeModel()}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <%@ include file="footerIndexPas.jsp" %>