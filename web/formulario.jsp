<%-- 
    Document   : formulario
    Created on : 8 oct 2023, 19:57:53
    Author     : estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            <link rel="stylesheet" href="CSS/boostrap.css"/>
        <link rel="stylesheet" href="CSS/style.css"/>
        <link rel="stylesheet" href="CSS/styleform.css"/>
        
        
    </head>
    <body>
        
        
        <main>
        
        
        
        <div class="formulario">
            
        <h3>Agregar/Actualizar</h3>
        
        
        
        <form action="ProductoController" method="POST">
            <p>
        <label for="marca">Marca:</label>
        <input type="text" name="marca" id="marca" value="<c:out value="${producto.marca}"></c:out>" required><br><br>
            </p>
            
            <p>
        <label for="productoNombre">Nombre del Producto:</label>
        <input type="text" name="productoNombre" id="productoNombre" value="<c:out value="${producto.productoNombre}"></c:out>"  required><br><br>
</p>

<p>
        <label for="precio">Precio:</label>
        <input type="number" step="0.01" name="precio" id="precio" value="<c:out value="${producto.precio}"></c:out>"  required><br><br>
</p

<p>
        <label for="stock">Stock:</label>
        <input type="number" name="stock" id="stock" value="<c:out value="${producto.stock}"></c:out>"  required><br><br>
</p>

<p>
        <label for="vendido">Cantidad Vendida:</label>
        <input type="number" name="vendido" id="vendido" value="<c:out value="${producto.vendido}"></c:out>" required><br><br>
</p>

<p>
    <input type="hidden" name="id" value="<c:out value="${producto.id}"></c:out>">
        <input type="submit" value="Guardar Producto">
       
        
</p>         
            
            
        </form>
        
        
        
        
        </div>
        
        </main>
    </body>
</html>
