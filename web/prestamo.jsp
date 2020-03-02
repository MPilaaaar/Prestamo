<%-- 
    Document   : prestamo
    Created on : 02-mar-2020, 19:19:33
    Author     : DAW212
--%>

<%@page import="modelo.Cuota"%>
<%@page import="modelo.Prestamo"%>
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
            <% 
                ArrayList <String> meses = (ArrayList<String>) request.getAttribute("meses"); 
                String totpres, cant, inte, tiempo;
                
                String nombre = (String) request.getAttribute("nombre");
                if (nombre == null){ 
                    nombre=""; 
                }
                
                Prestamo  prestamo = (Prestamo) request.getAttribute("totpres");
                if (prestamo == null){
                    tiempo="12";
                    cant = "0"; 
                    inte="0";
                    totpres=""; 
                } 
                else {
                    totpres = String.valueOf(prestamo.getImportePrestamo());
                    cant = String.valueOf(prestamo.getCantidad());
                    inte = String.valueOf(prestamo.getInteres());
                    tiempo = String.valueOf(prestamo.getTiempo());
                }
            %>
            <label for="nombre">Nombre: </label>
            <input type="text" id="nombre" value="<%= nombre %>" name="nombre"/>
            <br>
            <label for="cantidad">Cantidad que solicita: </label>
            <input type="text" id="cantidad" value="<%= cant %>" name="cantidad"/>
            <br>
            <label for="interes">Interes: </label>
            <input type="text" id="interes" value="<%= inte %>" name="interes"/>
            <br>
            <br><label for="mes">Tiempo(meses): </label>
            <select name="tiempo" id="tiempo">
                <% 
                    for (int i = 0; i < meses.size(); i++) {
                       String cadenaSelected="";
                       if ( tiempo.equals(meses.get(i))) {
                           cadenaSelected = "selected";
                       }
                %>
                       <option value="<%= meses.get(i) %>" <%= cadenaSelected %> ><%= meses.get(i) %></option>
                <%  }  %>  
            </select>

            <input type="submit" value="Consultar">
        </form>
            
        <h1>Importe Total Prestamo: <%= totpres %></h1>
        
        <table border="1">
            <% 
                ArrayList<Cuota> cuotas = (ArrayList<Cuota>) request.getAttribute("cuotas");
                if (cuotas!=null) { 
            %>
                    <tr>
                        <th>Nº Cuota</th>
                        <th>Importe</th>
                        <th>Capital</th>
                        <th>Interés</th>
                    </tr>
                    <%
                        for (int i=0; i<cuotas.size(); i++){
                            String impForm = String.format("%.2f", cuotas.get(i).getImporteCuota());
                            String capForm = String.format("%.2f", cuotas.get(i).getCapital());
                            String inteForm = String.format("%.2f", cuotas.get(i).getIntereses());
                    %>
                    <tr>
                        <td><%= cuotas.get(i).getNumeroCuota()  %></td>
                        <td><%= impForm %></td>
                        <td><%= capForm %></td>
                        <td><%= inteForm %></td>
                    </tr>
                    <%  }
                }
           %>
    </body>
</html>
