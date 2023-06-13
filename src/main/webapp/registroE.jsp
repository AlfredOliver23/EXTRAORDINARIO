<%-- 
    Document   : registroE
    Created on : 8 jun 2023, 07:15:03
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Muy Bien mushasho</title>
    <style>
        body {
            background-color: #f9f9f9;
        }

        .confetti-container {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            pointer-events: none;
            z-index: 9999;
        }

        .confetti {
            position: absolute;
            width: 10px;
            height: 10px;
            background-color: #f00;
            border-radius: 50%;
            opacity: 0.7;
        }
    </style>
    </head>
    <body>
    <h1>¡Sí se pudo, bro!</h1>
    <a href="./index.html">Regresar al menú</a>

    <div class="ConsultarUsuarios">
        <a href="ConsultarUsuarios.jsp">Consultar a todos los Usuarios</a>
    </div>

    <div class="ConsultarMascotas">
        <a href="ConsultarMascotas.jsp">Consultar a todos los Perros</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/confetti-js"></script>
    <script>
        // Función para lanzar confeti
        function launchConfetti() {
            const confettiContainer = document.createElement("div");
            confettiContainer.classList.add("confetti-container");
            document.body.appendChild(confettiContainer);

            const confettiSettings = { target: confettiContainer };
            const confetti = new ConfettiGenerator(confettiSettings);
            confetti.render();

            setTimeout(() => {
                confetti.clear();
                document.body.removeChild(confettiContainer);
            }, 5000); // Duración del efecto de confeti en milisegundos (5 segundos en este caso)
        }

        // Lanzar confeti al cargar la página
        window.addEventListener("load", launchConfetti);
    </script>
    </body>
</html>
