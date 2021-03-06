<%-- 
    Document   : VerPerfilCon
    Created on : 4/04/2019, 09:50:19 PM
    Author     : juana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="headerIndexCon.jsp" %>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <div class="form-group">
            <div class="form-row">
                <div class="col-md-2">
                    <label for="lblLincensePlate">Correo</label>
                    <a class="form-control">${InfoUsuario.getEmail()}</a>
                </div>
                <div class="col-md-3">
                    <label for="lblColor">Nombre</label>
                    <a class="form-control">${InfoUsuario.getName()}</a>
                </div>
                <div class="col-md-3">
                    <label for="lblColor">Cambiar contraseña</label>
                    <form action="CambioContra" method="POST">
                        <input type="password" name="txtPassword" class="form-control" placeholder="Contraseña actual." required="required">
                        <input type="password" name="txtPasswordNew" class="form-control" placeholder="Nueva contraseña." required="required">
                        <input type="text" name="cual" hidden="" value="Conductor">
                        <input name="btnCambiar" type="submit" class="btn btn-primary btn-block" value="Cambiar">
                    </form>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="form-row">
                <div class="col-md-2">
                    <label for="lblType">Numero de viajes hechos.</label>
                    <a class="form-control">${InfoUsuario.getServiceListDri().size()}</a>
                </div>
                <div class="col-md-6">
                    <label for="lblModel">Acumulado de calificaciones</label>
                    <a class="form-control">${InfoUsuario.getAccumulatedRating()}</a>
                </div>
            </div>
        </div>
        <%@ include file="footerIndex.jsp" %>