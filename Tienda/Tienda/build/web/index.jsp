<%-- 
    Document   : index
    Created on : 12/02/2022, 08:42:28 AM
    Author     : L
--%>

<%@page import="Beans.productoBeans"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="DAO.productoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <%@include file="commons/cdn.jsp"%>
    </head>
    <body>
        <%@include file="commons/cabecera.jsp"%>
        <div class="container mt-2">
            <div class="row">
                <%
                    List productos = new productoDAO().listar();
                    ListIterator list = productos.listIterator();
                    while (list.hasNext()) {
                    productoBeans p = (productoBeans) list.next();

                %>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header text-center">
                            <label><%= p.getNombre()%></label>
                        </div>
                        <div class="card-body">
                            <i>$ <%= p.getPrecio()%></i>
                            <img src="controladorImg?id=<%= p.getId()%>" width="200" height="180">
                        </div>
                        <div class="card-footer text-center">
                            <label><%= p.getDescripcion()%></label>
                            <div>
                                <a href="controladorP?accion=AgregarCarrito&id=<%= p.getId()%>" class="btn btn-outline-info">Agregar al Carrito</a>
                                <a href="" class="btn btn-danger">Comprar</a>
                            </div>
                        </div>
                    </div>
                    <br>
                </div>
                    <%
                        }
                    %>
            </div>
        </div>
    </body>
</html>
