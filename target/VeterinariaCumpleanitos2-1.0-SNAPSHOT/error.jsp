<%-- 
    Document   : error
    Created on : 8 jun 2023, 07:14:44
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>¡Ups! Ha ocurrido un error.</h1>
    <p>Todos tus datos serán borrados en:</p>
    <div id="countdown"></div>

    <script>
        // Función para iniciar la cuenta regresiva
        function startCountdown() {
            var countdownElement = document.getElementById('countdown');
            var count = 10; // Cambia este valor al número de segundos que deseas para la cuenta regresiva

            var countdownInterval = setInterval(function() {
                countdownElement.innerHTML = count;
                count--;

                if (count < 0) {
                    clearInterval(countdownInterval);
                    redirectToHomePage();
                }
            }, 1000);
        }

        // Función para redireccionar a la página de inicio
        function redirectToHomePage() {
            // Aquí debes colocar la URL de tu página de inicio
            var homePageURL = "https://github.com/";
            window.location.href = homePageURL;
        }

        // Iniciar la cuenta regresiva al cargar la página
        window.onload = function() {
            startCountdown();
        };
    </script>    </body>
</html>
