<%-- 
    Document   : ListaComentarios
    Created on : 5/04/2019, 01:51:41 AM
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
                        Lista de comentarios
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Eliminar</th>
                                        <th>Fecha</th>
                                        <th>Nombre</th>
                                        <th>Descripcion</th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Eliminar</th>
                                        <th>Fecha</th>
                                        <th>Nombre</th>
                                        <th>Descripcion</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <c:forEach items="${CommentsList}" var="comment">
                                        <tr>
                                            <td><form action="EliminarComentario" method="POST">
                                                    <input type="txt" name="txtEmail" hidden="" value="${comment.getPerson().getEmail()}">
                                                    <input type="txt" name="txtDate" hidden="" value="${comment.getDate()}">
                                                    <input type="txt" name="txtDes" hidden="" value="${comment.getDescription()}">
                                                    <input type="submit" class="fas fa-table" value="Eliminar">
                                                </form></td>
                                            <td>${comment.getDate()}</td>
                                            <td>${comment.getPerson().getName()}</td>
                                            <td>${comment.getDescription()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->


                <%@ include file="footerIndex.jsp" %>