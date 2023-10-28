<%-- 
    Document   : list
    Created on : 8 oct 2023, 19:57:46
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
        
        
    </head>
    <body>
        
        <header class="header">
            
            <h2>CENTRO DE ADMINISTRACIÓN</h2>
            <h5>DistributionCompany by LaimeFacundo</h5>
            
            
        </header>
        
        <main>
        
            
            <div class="seccion1">
                <h5>Bienvenidos, en esta sección podras administrar tu stock, ya sea agregar, eliminar como editarlos.:</h5>
                <h6>Haga click en AGREGAR PRODUCTO NUEVO y llene los datos de su nuevo producto, una vez cargados los visualizara en la
                tabla de abajo.</h6>
                                <a class="agregarlink" href="ProductoController?accion=nuevo"> <h3>Agregar producto nuevo</h3>  </a>

        </div>
        
        
        <div class="centro">
        
        <table  cellspacing="1" cellpadding="2" class="tabla">
            <thead class="tablapadding">
                <tr>
                    <th>ID</th>
                    <th>MARCA</th>
                    <th>NOMBRE</th>
                    <th>PRECIO</th>
                    <th>STOCK</th>
                    <th>VENDIDO</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <tbody class="tablapadding">
          
                
                <c:forEach var="producto" items="${list}">
                <tr>
                    <td> <c:out value="${producto.id}"></c:out> </td>
                    <td><c:out value="${producto.marca}"></c:out></td>
                    <td><c:out value="${producto.productoNombre}"></c:out></td>
                    <td>$ <c:out value="${producto.precio}"></c:out></td>
                    <td><c:out value="${producto.stock}"></c:out></td>
                    <td><c:out value="${producto.vendido}"></c:out></td>
                    
                    <td> 
                        <a href="ProductoController?accion=actualizar&id=<c:out value="${producto.id}"></c:out> ">Actualizar</a>
                        <a href="ProductoController?accion=eliminar&id=<c:out value="${producto.id}"></c:out> ">Eliminar</a>
                    
                    </td>
                </tr>
                
                </c:forEach>
                    
            </tbody>
        </table>

        
        </div>

        </main>
        
        
    </body>
</html>
