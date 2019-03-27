<%-- 
    Document   : IndexAggVehicon
    Created on : 26/03/2019, 04:32:58 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ include file="headerIndexCon.jsp" %>
</ul>
<div id="content-wrapper">
    <div class="container-fluid">
        <form action="AddVehiculo" method="POST">
            <div class="form-group">
                <div class="form-row">
                    <div class="col-md-6">
                        <label for="lblLincensePlate">Placa</label>
                        <input type="text" name="txtLicensePlate" class="form-control" placeholder="Ingrese la placa del vehiculo" required="required" autofocus="autofocus">
                    </div>
                    <div class="col-md-6">
                        <label for="lblColor">Color</label>
                        <input type="text" name="txtColor" class="form-control" placeholder="Ingrese el color del vehiculo" required="required">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="form-row">
                    <div class="col-md-3">
                        <label for="lblType">Tipo de vehiculo</label>
                        <select type="email" name="txtType" class="form-control" required="required" autofocus>
                            <option value="Carro">Carro</option>
                            <option value="Moto">Moto</option>
                        </select>
                    </div>
                    <div class="col-md-6">
                        <label for="lblModel">Modelo del vehiculo</label>
                        <input type="text" name="txtModel" class="form-control" placeholder="Ingrese el modelo." required="required">
                    </div>
                </div>
            </div>
            <input name="btnRegistrarme" type="submit" class="btn btn-primary btn-block" value="Registrar vehiculo"/>
        </form>
        <%@ include file="footerIndexCon.jsp" %>

