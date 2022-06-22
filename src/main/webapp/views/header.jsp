<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="servlet?direccionar=estilo">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Header</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg  navbar navbar-light fixed-top" style="background-color: #e3f2fd;">
        <a class="navbar-brand " href="#">Disquera</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="servlet?direccionar=inicio">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="genero?accion=visualizar">Género</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="album?accion=visualizar">Álbum</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="cancion?accion=visualizar">Canción</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="artista?accion=visualizar">Artista</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="disquera?accion=visualizar">Disquera</a>
            </li>
          </ul>
        </div>
      </nav>
</body>
</html>