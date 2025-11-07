<%@page contentType="text.html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Carro de Compras</title>
</head>
<body>
    <h1>Carro de Compras</h1>
    <c:choose>
    <c:when test="${sessionScope.carro == null || sessionScope.carro.items.isEmpty()}">
        <p>lo sentimos, no hay productos en el carro de compras!</p>
    </c:when>
    <c:otherwise>
        <form name="formcarro" action="${pageContext.request.contextPath}/carro/actualizar" method="post">
        <table>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Cantidad</th>
                <th>Total</th>
                <th>borrar</th>
            </tr>

            <c:forEach items="${carro.items}" var="item">

            <tr>
                <td>${item.producto.id}</td>
                <td>${item.producto.nombre}</td>
                <td>${item.producto.precio}</td>
                <td><input type="text" size="4" name="cant_${item.producto.id}" value="${item.cantidad}"</td>
                <td>${item.importe}</td>
                <td><input type="checkbox" value="${item.producto.id}" name="deleteProductos" /></td>
            </tr>

            </c:forEach>

            <tr>
                <td colspan="4" style="text-align: right">Total</td>
                <td>${carro.total}</td>
            </tr>
        </table>
        <a href="javascript:document.formcarro.submit();">Actualizar</a>
    </form>
    </c:otherwise>
    </c:choose>
    <p><a href="${pageContext.request.contextPath}/productos">Segir comprando</a></p>
    <p><a href="${pageContext.request.contextPath}/index.html">Volver al inicio</a></p>
</body>
</html>