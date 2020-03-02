<%-- 
    Document   : prestamo
    Created on : 02-mar-2020, 19:19:33
    Author     : DAW212
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Banco Bosco</h1>
        <h3>Solicitud de Préstamos</h3>
        <form action="prestamo" method="post">
            
            <% ArrayList<String> meses = (ArrayList<String>) request.getAttribute("meses"); 
                
                
            %>
            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" name="nombre"/>
            <br>
            <label for="cantidad">Cantidad que solicita: </label>
            <input type="text" id="cantidad"  name="cantidad"/>
            <br>
            <label for="interes">Interes: </label>
            <input type="text" id="interes"  name="interes"/>
            <br>
            <br><label for="mes">Tiempo(meses): </label>
            <select name="anyo" id="anyo">
                <% for(int i = 0; i < meses.size(); i++){ 
                    
                %>
                <option value="<%= meses.get(i) %>" ><%= meses.get(i) %> </option>
                <% } %>
            </select>

            <input type="submit" value="Consultar">
        </form>
            
            <h1>Importe Total Prestamo: </h1>
    </body>
</html>
