<%@page contentType="text.html" pageEncoding="UTF-8" import="org.egmaza.apiservlet.webapp.headers.models.*"%>
<%
Carro carro = (Carro) session.getAttribute("carro");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carro de Compras</title>
</head>
<body>
    <h1>Carro de Compras</h1>
    <% if(carro == null || carro.getItems().isEmpty()){ %>

    <p>lo sentimos, no hay productos en el carro de compras!</p>

    <%}
    else{%>

    <table>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Total</th>
        </tr>

        <% for(ItemCarro item : carro.getItems()){ %>

        <tr>
            <th><%=item.getProducto().getId()%></th>
            <th><%=item.getProducto().getNombre()%></th>
            <th><%=item.getProducto().getPrecio()%></th>
            <th><%=item.getCantidad()%></th>
            <th><%=item.getImporte()%></th>
        </tr>

    <% } %>

        <tr>
            <td colspan="4" style="text-align: right">Total</td>
            <td><%=carro.getTotal()%></td>
        </tr>
    </table>

    <%}%>
    <p><a href="<%=request.getContextPath()%>/productos">Segir comprando</a></p>
    <p><a href="<%=request.getContextPath()%>/index.html">Volver al inicio</a></p>
</body>
</html>