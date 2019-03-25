<%-- 
    Document   : ProgramarViaje
    Created on : 24/03/2019, 08:46:55 PM
    Author     : juana
--%>

<%@ include file="headerIndexCon.jsp" %>

<form action="ProgramarViaje" method="POST">
    <div class="form-group">
        <div class="form-row">
            <div class="col-md-3">
                <label for="lblMeetingTime">Hora de encuetro</label>
                <div class="form-group">
                    <input type="number" name="txtHours" class="col-md-3" placeholder="HH" required="required" autofocus="autofocus">
                    <a>:</a>
                    <input type="number" name="txtMinutes" class="col-md-3" placeholder="Mn" required="required">
                </div>
            </div>
            <div class="col-md-2">
                <label for="lblOutPutCore">Nucleo de salida:</label>
                <select type="text" name="txtOutPutCore" class="form-control" required="required" autofocus>
                    <option value="Volador">Volador</option>
                    <option value="Minas">Minas</option>
                    <option value="Rio">Rio</option>
                </select>
            </div>
            <div class="col-md-2">
                <label for="lblArrivalNucleus">Nucleo de llegada:</label>
                <select type="text" name="txtArrivalNucleus" class="form-control" required="required" autofocus>
                    <option value="Volador">Volador</option>
                    <option value="Minas">Minas</option>
                    <option value="Rio">Rio</option>
                </select>
            </div>
            <div class="col-md-2">
                <label for="lblStartPlace">Lugar de inicio:</label>
                <input type="text" name="txtStartPlace" class="form-control" placeholder="Lugar de salida:" required="required">
            </div>
            <div class="col-md-2">
                <label for="lblEndPlace">Lugar de fin:</label>
                <input type="text" name="txtEndPlace" class="form-control" placeholder="Lugar de llegada:" required="required">
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="form-row">
            <div class="col-md-2">
                <label for="lblAvailableSeats">Asientos disponibles:</label>
                <input type="number" name="txtAvailableSeats" class="form-control" placeholder="Asientos disponibles:" required="required">
            </div>
            <div class="col-md-2">
                <label for="lblDateSer">Dia del viaje:</label>
                <select type="text" name="txtDateSer" class="form-control" required="required" autofocus>
                    <option value="Hoy">Hoy</option>
                    <option value="Mañana">Mañana</option>
                </select>
            </div>
        </div>
    </div>
    <input name="btnRegistrarme" type="submit" class="btn btn-primary btn-block" value="Programar viaje"/>
</form>

<%@ include file="footerIndexCon.jsp" %>
