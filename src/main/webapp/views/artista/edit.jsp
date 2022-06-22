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
    <title>Editar artista</title>
</head>
<body>
  <%@include file = "../header.jsp" %>
      <h3 id="tituloEdit">Actualizar artista</h3>
    <section>
      <div class="box">
        <div class="container">
            <div class="form">
            <c:forEach var="artista" items="${artistasList}">
                <h2>Editar el artista "${artista.getNombreArtista()}"</h2>
                <form action="artista" method="post">
                    <label>Número de documento:</label>
                    <div class="inputBox">
                        <input name="noDocumento" id="noDocumento" type="text" value="${artista.getNoDocumento()}" placeholder="Número de documento">
                        <input hidden name="idArtista" id="idArtista" type="text" value="${artista.getIdArtista()}" >
                    </div>
                    <label>Tipo de documento:</label>
                    <div class="inputBox">
                        <input name="tipoDocumento" id="tipoDocumento" type="text" value="${artista.getTipoDocumento()}" placeholder="Nombre">
                        <input hidden name="idArtista" id="idArtista" type="text" value="${artista.getIdArtista()}" >
                    </div>
                    <label>Nombre del artista:</label>
                    <div class="inputBox">
                        <input name="nombreArtista" id="nombreArtista" type="text" value="${artista.getNombreArtista()}" placeholder="Nombre">
                        <input hidden name="idArtista" id="idArtista" type="text" value="${artista.getIdArtista()}" >
                    </div>
                    <label>Apellido del artista:</label>
                    <div class="inputBox">
                        <input name="apellidoArtista" id="apellidoArtista" type="text" value="${artista.getApellidoArtista()}" placeholder="Apellido">
                        <input hidden name="idArtista" id="idArtista" type="text" value="${artista.getIdArtista()}" >
                    </div>
                    <label>Nombre artistico:</label>
                    <div class="inputBox">
                        <input name="nombreArtistico" id="nombreArtistico" type="text" value="${artista.getNombreArtistico()}" placeholder="Nombre artistico">
                        <input hidden name="idArtista" id="idArtista" type="text" value="${artista.getIdArtista()}" >
                    </div>
                    <label>Fecha de nacimiento:</label>
                    <div class="inputBox">
                        <input name="feNacimArtista" id="feNacimArtista" type="text" value="${artista.getFeNacimArtista()}" placeholder="Fecha de nacimiento">
                        <input hidden name="idArtista" id="idArtista" type="text" value="${artista.getIdArtista()}" >
                    </div>
                    <label>Correo del artista:</label>
                    <div class="inputBox">
                        <input name="emailArtista" id="emailArtista" type="text" value="${artista.getEmailArtista()}" placeholder="Correo">
                        <input hidden name="idArtista" id="idArtista" type="text" value="${artista.getIdArtista()}" >
                    </div>
                    <label hidden>Estado del artista:</label>
                    <div>
                        <input hidden type="checkbox" name="estadoArtista" id="estadoArtista" value="${artista.isEstadoArtista()}" checked class="form-check-input">
                        <label hidden for="estadoArtista"> Activo</label>
                    </div>
                    
                    <div class="inputBox">
                        <br>
                        <a id="botonVolver" class="btn btn-primary" href="artista?accion=visualizar">Volver</a>
                        <button type="submit" class="btn btn-success" name="accion" value="Editar">Actulizar</button>
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