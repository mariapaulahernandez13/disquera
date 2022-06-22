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
    <title>Agregar canción</title>
</head>
<body>    
      <h3 id="tituloEdit">Registrar canción</h3>

      <form action="cancion" method="post" class="text-center">
        <div class="form-group row">
            <label for="nombreCancion" class="col-sm-2 col-form-label">Nombre</label>
            <div class="col-sm-10">
                 <input type="text" class="form-control" id="nombreCancion" name="nombreCancion" placeholder="Digite aquí el nombre de la canción">
            </div>
        </div>
        <div class="form-group row">
            <label for="fechaGrabacion" class="col-sm-2 col-form-label">Fecha de grabación</label>
            <div class="col-sm-10">
                 <input type="number" class="form-control" id="fechaGrabacion" name="fechaGrabacion" placeholder="Seleccione la fecha de grabación">
            </div>
        </div>
        <div class="form-group row">
            <label for="duracionCancion" class="col-sm-2 col-form-label">Duración</label>
            <div class="col-sm-10">
                 <input type="text" class="form-control" id="duracionCancion" name="duraciónCancion" placeholder="Digite aquí la duración de la canción">
            </div>
        </div>
        <fieldset class="form-group">
            <div class="row">
            <legend class="col-form-label col-sm-2 pt-0">Estado</legend>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="estadoCancion" id="estadoCancion" value="estadoCancion" checked>
                        <label class="form-check-label" for="estadoCancion">Activo</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="estadoCancion" id="estadoCancion" value="estadoCancion">
                        <label class="form-check-label" for="estadoCancion">Inactivo</label>
                    </div>
                </div>
            </div>
        </fieldset>
        <div class="form-group row">
          <div class="col-sm-10">
            <button type="submit" class="btn btn-success" name="accion" value="Registrar">Enviar</button>
            <a id="botonVolver" class="btn btn-primary" href="cancion?accion=visualizar">Volver</a>
          </div>
        </div>
      </form>
      <%@include file = "../footer.jsp" %>
</body>
</html>