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
    <title>Agregar álbum</title>
</head>
<body >    
      <h3 id="tituloEdit">Registrar álbum</h3>

      <form action="album" method="post" class="text-center">   
        <div class="form-group row">
            <label for="nombreAlbum" class="col-sm-2 col-form-label">Nombre</label>
            <div class="col-sm-10">
                 <input type="text" class="form-control" id="nombreAlbum" name="nombreAlbum" placeholder="Digite aquí el nombre del álbum">
            </div>
        </div>
        <div class="form-group row">
            <label for="anioPublicacion" class="col-sm-2 col-form-label">Año de publicación</label>
            <div class="col-sm-10">
                 <input type="number" class="form-control" id="anioPublicacion" name="anioPublicacion" placeholder="Seleccione el año de publicación">
            </div>
        </div>
        <fieldset class="form-group">
            <div class="row">
            <legend class="col-form-label col-sm-2 pt-0">Estado</legend>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="estadoAlbum" id="estadoAlbum" value="option1" checked>
                        <label class="form-check-label" name="estadoAlbum" for="estadoAlbum">Activo</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="estadoAlbum" id="estadoAlbum" value="option2" checked>
                        <label class="form-check-label" name="estadoAlbum" for="estadoAlbum">Inactivo</label>
                    </div>
                </div>
            </div>
        </fieldset>
        <div class="form-group row">
          <div class="col-sm-10">
            <a id="botonVolver" class="btn btn-primary" href="album?accion=visualizar">Volver</a>
            <button type="submit" class="btn btn-success" name="accion" value="Registrar">Enviar</button>
          </div>
        </div>
      </form>
      <%@include file = "../footer.jsp" %>
</body>
</html>