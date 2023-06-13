<%-- 
    Document   : ConsultarUsuarios
    Created on : 8 jun 2023, 13:19:46
    Author     : user
--%>
<%@page import="Modelo.Propietario"%>
<%@page import="Control.AccionesPropietario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }
        table {
            width: 100%;
            margin-bottom: 1rem;
            color: #212529;
        }
        table th,
        table td {
            padding: 0.75rem;
            vertical-align: top;
            border-top: 1px solid #dee2e6;
        }
        table thead th {
            vertical-align: bottom;
            border-bottom: 2px solid #dee2e6;
        }
        table tbody + tbody {
            border-top: 2px solid #dee2e6;
        }
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Tabla de todos los Usuarios!</h1><br>

    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>id</th>
            <th>Correo</th>
            <th>Nombre</th>
            <th>Apellido Paterno</th>
            <th>Apellido Materno</th>
            <th>Direccion</th>
            <th>Contrasena</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <%
            List<Propietario> lista = AccionesPropietario.buscarAllPropietarios();

            for(Propietario e : lista) {
        %>
        <tr>
            <td><%=e.getId_pro()%></td>
            <td><%=e.getCorreo()%></td>
            <td><%=e.getNombre()%></td>
            <td><%=e.getAppat()%></td>
            <td><%=e.getApmat()%></td>
            <td><%=e.getDir()%></td>
            <td><%=e.getPass()%></td>
            <td><a href="EditarUsuarios.jsp?id=<%=e.getId_pro()%>" class="btn btn-primary">Editar</a></td>
            <td><a href="borrarPropietario.jsp?id=<%=e.getId_pro()%>" class="btn btn-danger">Borrar</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <a href="index.html" class="btn btn-secondary">Regresar al menú Principal</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
