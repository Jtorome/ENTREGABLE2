<%-- 
    Document   : HoraMasConcurridaCon
    Created on : 4/04/2019, 05:39:56 PM
    Author     : juana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="headerIndexCon.jsp" %>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <div class="card mb-3">
            <div class="card-header">
                <i class="fas fa-table"></i>
                Hora más concurrida:
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Servicios hechos a esa hora</th>
                                <th>Hora de encuentro</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                                <th>Servicios hechos a esa hora</th>
                                <th>Hora de encuentro</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <c:forEach items="${FavoriteHour}" var="Hour">
                                <tr>
                                    <td>${Hour.split(",")[1]}</td>
                                    <td>${Hour.split(",")[0]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@ include file="footerIndex.jsp" %>