<%-- 
    Document   : IndexConductor
    Created on : 24/03/2019, 07:28:01 PM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="headerIndexCon.jsp" %>
<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" href="#" id="OpcionDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <i class="fas fa-fw fa-folder"></i>
        <span>Bla</span>
    </a>
    <div class="dropdown-menu" aria-labelledby="OpcionDropdown">
        <h6 class="dropdown-header">Bla servicios:</h6>
        <a class="dropdown-item" href="ProgramarViaje.jsp">Programar viaje</a>
        <a class="dropdown-item" href="VerViajeActualCon.jsp">Ver viaje acual.</a>
        <a class="dropdown-item" href="forgot-password.html">Forgot Password</a>
        <div class="dropdown-divider"></div>
        <h6 class="dropdown-header">Other Pages:</h6>
        <a class="dropdown-item" href="404.html">404 Page</a>
        <a class="dropdown-item" href="blank.html">Blank Page</a>
    </div>
</li>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <form action="IndexConductor" method="GET"><input type="submit" hidden=""></form>
        <div class="card mb-3">
            <div class="card-header">
                <i class="fas fa-table"></i>
                Servicios disponibles
                <form action="IndexConductor" method="GET">
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

        <%@ include file="footerIndexCon.jsp" %>