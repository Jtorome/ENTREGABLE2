<%-- 
    Document   : Index
    Created on : 24/03/2019, 12:36:10 AM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="headerIndexPas.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <body id="page-top">
        <script type="text/javascript">
            if (${empty InfoUsuario}) {
                window.location="Login.jsp";
            }
        </script>
        <!-- DataTables Example -->
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


<%@ include file="footerIndexCon.jsp" %>