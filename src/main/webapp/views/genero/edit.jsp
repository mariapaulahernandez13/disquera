<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file = "../header.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="servlet?direccionar=estilo">
    <title>Actualizar género</title>
</head>
<body>
    <h3 id="tituloEdit">Actualizar género</h3>

    <section>
        <div class="box">
            <div class="container">
                <div class="form">
                <c:forEach var="genero" items="${generosList}">
                    <h2>Editar el genero "${genero.getNombreGenero()}"</h2>
                    <form action="genero" method="post">
                        <label>Nombre del género:</label>
                        <div class="inputBox">
                            <input name="nombreGenero" id="nombreGenero" type="text" value="${genero.getNombreGenero()}" placeholder="Nombre">
                            <input hidden name="idGenero" id="idGenero" type="text" value="${genero.getIdGenero()}" >
                        </div>
                        <label hidden>Estado del género:</label>
                        <div>
                            <input hidden type="checkbox" name="estadoGenero" id="estadoGenero" value="${genero.isEstadoGenero()}" checked class="form-check-input">
                            <label hidden for="estadoGenero"> Activo</label>
                        </div>
                        
                        <div class="inputBox">
                            <br>
                            <a id="botonVolver" class="btn btn-primary" href="genero?accion=visualizar">Volver</a>
                            <input type="submit"  class="btn btn-success" name="accion" value="Editar">
                        </div>
                    </form>
                </c:forEach>
                </div>
            </div>
        </div>
    </section>
      <%@include file = "../footer.jsp" %>
</body>
</html>