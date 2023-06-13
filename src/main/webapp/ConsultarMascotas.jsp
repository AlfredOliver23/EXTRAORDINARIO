<%@ page import="Modelo.Mascota" %>
<%@ page import="ControlMascota.AccionesMascota" %>
<%@ page import="java.util.List" %><%--
    Document   : ConsultarMascotas
    Created on : 8 jun 2023, 13:19:04
    Author     : user
--%>

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
    <h1>Tabla de todos los Perros!</h1><br>

    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>id perro</th>
            <th>Id dueno</th>
            <th>Raza id</th>
            <th>Nacimiento</th>
            <th>Nombre</th>
            <th>Imagen</th>
            <th>Tamano</th>
            <th>Peso</th>
            <th>Sexo</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <%
            List<Mascota> lista = AccionesMascota.buscarAllPerros();

            for(Mascota e : lista) {
        %>
        <tr>
            <td><%=e.getMascota_id()%></td>
            <td><%=e.getPropietario_id()%></td>
            <td><%=e.getRaza()%></td>
            <td><%=e.getNacimiento()%></td>
            <td><%=e.getNombre_mas()%></td>
            <td><%=e.getImagen_per()%></td>
            <td><%=e.getTamano()%></td>
            <td><%=e.getPeso()%></td>
            <td><%=e.getSexo()%></td>
            <td><a href="EditarMascotas.jsp?id=<%=e.getMascota_id()%>" class="btn btn-primary">Editar</a></td>
            <td><a href="borrarMascota.jsp?id=<%=e.getMascota_id()%>" class="btn btn-danger">Borrar</a></td>
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
