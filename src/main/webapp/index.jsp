<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file = "views/header.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="servlet?direccionar=estilo">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Disquera</title>
</head>
<body>
      <div class="card1 border-dark text-center bg-light mb-3" style="width: 20rem;">
        <div class="card-body"  style="max-width: 18rem;">
            <div class="card-header bg-light mb-5">
                <h5 class="card-title">Bienvenido</h5>
            </div>
            <h6 class="card-subtitle mb-2 text-muted">Listar:</h6><br>
            <span class="material-icons md-dark">play_circle_filled</span>
            <a href="genero?accion=visualizar" class="card-link">Género</a><br><br>
            <span class="material-icons md-dark">playlist_play</span>
            <a href="album?accion=visualizar" class="card-link">Álbum</a><br><br>
            <span class="material-icons md-dark">perm_identity</span>
            <a href="artista?accion=visualizar" class="card-link">Artista</a><br><br>
            <span class="material-icons md-dark">mic</span>
            <a href="cancion?accion=visualizar" class="card-link">Canción</a><br><br>
            <span class="material-icons md-dark" >album</span>
            <a href="disquera?accion=visualizar" class="card-link">Disquera</a>
        </div>
      </div>
      <%@include file = "views/footer.jsp" %>
</body>
</html>