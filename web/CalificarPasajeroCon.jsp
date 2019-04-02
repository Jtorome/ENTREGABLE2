<%-- 
    Document   : CalificarPasajeroCon
    Created on : 1/04/2019, 10:48:49 PM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="headerIndexCon.jsp" %>
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
                        Pasajeros por calificar
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Calificacion y descripcion.</th>
                                        <th>Nombre</th>
                                        <th>Correo</th>
                                        <th>Celular</th>
                                        <th>Calificacion promedio</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Calificacion y descripcion.</th>
                                        <th>Nombre</th>
                                        <th>Correo</th>
                                        <th>Celular</th>
                                        <th>Calificacion promedio</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <c:forEach items="${InfoUsuario.getUnqualifiedRider()}" var="rider">
                                        <tr>
                                            <td><form action="CalificarPasajeroCon" method="POST"><select type="number" name="nbScore" class="form-control" required="required" autofocus>
                                                        <option value=1>1</option>
                                                        <option value=2>2</option>
                                                        <option value=3>3</option>
                                                        <option value=4>4</option>
                                                        <option value=5>5</option>
                                                    </select>
                                                    <input type="txt" name="txtDescription" class="form-control" placeholder="Descripcion:">
                                                    <input type="txt" name="txtEmail" hidden="" value="${rider.getEmail()}">
                                                    <input type="submit" class="fas fa-table" value="Calificar"></form></td>
                                            <td>${rider.getName()}</td>
                                            <td>${rider.getEmail()}</td>
                                            <td>${rider.getCellPhone()}</td>
                                            <td>${rider.getAverageScore()}</td>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->


                <%@ include file="footerIndexCon.jsp" %>
