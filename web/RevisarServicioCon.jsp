<%-- 
    Document   : RevisarServicioCon
    Created on : 1/04/2019, 01:00:17 AM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="headerIndexCon.jsp" %>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <div id="content-wrapper">
            <div class="container-fluid">
                <div class="card mb-3">
                    <div class="card-header">
                        <i class="fas fa-table"></i>
                        Informacion sobre pasajeros:
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Correo</th>
                                        <th>Celular</th>
                                        <th>Promedio de calificaciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${service.getRidersList()}" var="rider">
                                        <tr>
                                            <td>${rider.getName()}</td>
                                            <td>${rider.getEmail()}</td>
                                            <td>${rider.getCellPhone()}</td>
                                            <td>${rider.getAverageScore()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <%@ include file="footerIndex.jsp" %>