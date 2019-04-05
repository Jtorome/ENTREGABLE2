<%-- 
    Document   : ListaConductores
    Created on : 5/04/2019, 12:28:42 AM
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
                        Lista conductores
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Eliminar</th>
                                        <th>Nombre</th>
                                        <th>Correo</th>
                                        <th>Celular</th>
                                        <th>Numero de viajes</th>
                                        <th>Acumulado de calificaciones</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Eliminar</th>
                                        <th>Nombre</th>
                                        <th>Correo</th>
                                        <th>Celular</th>
                                        <th>Numero de viajes</th>
                                        <th>Acumulado de calificaciones</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <c:forEach items="${DriversList}" var="driver">
                                        <tr>
                                            <td><form action="EliminarConductor" method="POST">
                                                    <input type="txt" name="txtEmail" hidden="" value="${service.getDriver().getEmail()}">
                                                    <input type="submit" class="fas fa-table" value="Tomar">
                                                </form></td>
                                            <td>${driver.getName()}</td>
                                            <td>${driver.getEmail()}</td>
                                            <td>${driver.getCellPhone()}</td>
                                            <td>${driver.getServiceListDri().size()}</td>
                                            <td>${driver.getAccumulatedRating()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->


                <%@ include file="footerIndex.jsp" %>