<%@ include file="header.jsp" %>
        <form method="POST" action="./CreatePerson">
            Email <input type="text" name="email" /><br /><br />
            Password: <input type="password" name="password" /><br /><br />
            Name: <input type="text" name="name" /><br /><br />
            CellPhone: <input type="text" name="cellphone" /><br /><br />
            <input type="submit" value="Registrarme" />
        </form>
        
        <c:if test="${not empty people}">
            <table class="tg">
            <tr>
                <th width="80">email</th>
                <th width="100">password</th>
                <th width="120">Name</th>
                <th width="140">cellphone</th>
            </tr>
            <c:forEach items="${people}" var="pro">
                <tr>
                    <td>${pro.getEmail()}</td>
                    <td>${pro.getPassword()}</td>
                    <td>${pro.getName()}</td>
                    <td>${pro.getCellPhone()}</td>
                </tr>
            </c:forEach>
            </table>
        </c:if>
<%@ include file="footer.jsp" %>
