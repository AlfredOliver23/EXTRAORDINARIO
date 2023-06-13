<%-- 
    Document   : EditarUsuarios
    Created on : 8 jun 2023, 13:20:00
    Author     : user
--%>

<%@page import="Control.AccionesPropietario"%>
<%@page import="Modelo.Propietario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualizar Registro de Propieatarios!</h1>
        
        <form method="post" name="actualizarDatos" action="actualizarPropietario" >
            <table border="2">
                <%
                    int  id = Integer.parseInt(request.getParameter("id_pro"));
                    
                    Propietario e = AccionesPropietario.buscarPropietarioById(id);
                    %>
                    
                <tr>
                    <td>Id</td>
                    <td><input type="hidden" name="id2" value="<%=e.getId_pro()%>"
 ></td>
                </tr>
                <tr>
                    <td>Correo :</td>
                            <td><input type="text" name="correo2" size="30" value="<%=e.getCorreo()%>"></td>
                        </tr>
                        
                
                <tr>
                        <td>Nombre :</td>
                            <td><input type="text" name="nombre2" size="30"value="
    <%=e.getNombre()%>"></td>
                        </tr>
                        <tr>
                        <td>Apellido Paterno :</td>
                            <td><input type="text" name="appat2" size="30"value="
    <%=e.getNombre()%>"></td>
                        </tr>
                        <tr>
                        <td>Apellido Materno :</td>
                            <td><input type="text" name="apmat2" size="30"value="
    <%=e.getNombre()%>"></td>
                        </tr>
                        <tr>
                            <td>Password :</td>
                            <td><input type="text" name="password2" size="30" value="<%=e.getPass()%>"></td>
                        </tr>
                        <tr>
                            <td>Dirrecion :</td>
                            <td><input type="text" name="email2" size="30" value="<%=e.getDir()%>"></td>
                        </tr>
                        
                        <tr>
                        <td colspan="2"><input type="submit"
                                               value="Actualizar Propietario"></td>
                        </tr>
            </table>
        </form>
    </body>
</html>
