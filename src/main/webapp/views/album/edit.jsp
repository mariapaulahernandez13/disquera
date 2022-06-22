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
    <title>Editar álbum</title>
</head>
<body>   
    <h3 id="tituloEdit">Actualizar álbum</h3>
    <section>
        <div class="box">
            <div class="container">
                <div class="form">
                <c:forEach var="album" items="${albumesList}">
                    <h2>Editar el álbum "${album.getNombreAlbum()}"</h2>
                    <form action="album" method="post">
                        <label>Nombre del álbum:</label>
                        <div class="inputBox">
                            <input name="nombreAlbum" id="nombreAlbum" type="text" value="${album.getNombreAlbum()}" placeholder="Nombre">
                            <input hidden name="idAlbum" id="idAlbum" type="number" value="${album.getIdAlbum()}" >
                        </div>
                        <label>Año de publicación:</label>
                        <div class="inputBox">
                            <input name="anioPublicacion" id="anioPublicacion" type="number" value="${album.getAnioPublicacion()}" placeholder="Año de publicación">
                            <input hidden name="idAlbum" id="idAlbum" type="number" value="${album.getIdAlbum()}" >
                        </div>
                        
                        <div class="inputBox">
                            <br>
                            <a id="botonVolver" class="btn btn-primary" href="album?accion=visualizar">Volver</a>
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