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
    <title>Editar canción</title>
</head>
<body>
  <h3 id="tituloEdit">Actualizar canción</h3>

  <section>
    <div class="box">
        <div class="container">
            <div class="form">
            <c:forEach var="cancion" items="${cancionesList}">
                <h2>Editar la canción "${cancion.getNombreCancion()}"</h2>
                <form action="cancion" method="post">
                    <label>Nombre:</label>
                    <div class="inputBox">
                        <input name="nombreCancion" id="nombreCancion" type="text" value="${cancion.getNombreCancion()}" placeholder="Nombre de la canción">
                        <input hidden name="idCancion" id="idCancion" type="number" value="${cancion.getIdCancion()}" >
                    </div>
                    <label for="fechaGrabacion" class="col-sm-2 col-form-label">Fecha de grabación:</label>
                    <div class="inputbox col-sm-10">
                        <input name="fechaGrabacion" type="number" class="form-control" id="fechaGrabacion" value="${cancion.getFechaGrabacion()}" placeholder="Seleccione la fecha de grabación">
                    </div>
                    <label>Duración:</label>
                    <div class="inputBox">
                        <input name="duracionCancion" id="duracionCancion" type="text" value="${cancion.getDuracionCancion()}" placeholder="Duración de la canción">
                    </div>
                    <label hidden>Estado:</label>
                    <div>
                        <input hidden type="checkbox" name="estadoCancion" id="estadoCancion" value="${cancion.isEstadoCancion()}" checked class="form-check-input">
                        <label hidden for="estadoCancion"> Activo</label>
                    </div>
                    
                    <div class="inputBox">
                        <br>
                        <a id="botonVolver" class="btn btn-primary" href="cancion?accion=visualizar">Volver</a>
                        <button type="submit" class="btn btn-success" name="accion" value="Editar">Enviar</button>
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