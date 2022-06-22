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
    <title>Agregar artista</title>
</head>
<body>
  <%@include file = "../header.jsp" %>
      <h3 id="tituloEdit">Registrar artista</h3>

      <form action="artista" method="post" class="text-center">    
        <div class="form-group row">
            <label for="noDocumento" class="col-sm-2 col-form-label">Número de documento</label>
            <div class="col-sm-10">
              <input type="number" class="form-control" name="noDocumento" id="noDocumento" placeholder="Digite aquí su número de documento">
            </div>
        </div>
        <div class="form-group row">
            <label for="tipoDocumento" class="col-sm-2 col-form-label">Tipo de documento</label>
            <select id="tipoDocumento" name="tipoDocumento" class="form-control col-sm-10">
              <option selected>Seleccione su tipo de documento</option>
              <option id="tipoDocumento" name="tipoDocumento">Cédula de ciudadanía</option>
              <option id="tipoDocumento" name="tipoDocumento">Cédula de extranjería</option>
              <option id="tipoDocumento" name="tipoDocumento">Tarjeta de identidad</option>
            </select>
          </div>
        </div>
        <div class="form-group row">
            <label for="nombreArtista" class="col-sm-2 col-form-label">Nombre</label>
            <div class="col-sm-10">
                 <input type="text" class="form-control" id="nombreArtista" name="nombreArtista" placeholder="Digite aquí su nombre">
            </div>
        </div>
        <div class="form-group row">
            <label for="apellidoArtista" class="col-sm-2 col-form-label">Apellido</label>
            <div class="col-sm-10">
                 <input type="text" class="form-control" id="apellidoArtista" name="apellidoArtista" placeholder="Digite aquí su apellido">
            </div>
        </div>
        <div class="form-group row">
            <label for="nombreArtistico" class="col-sm-2 col-form-label">Nombre artístico</label>
            <div class="col-sm-10">
                 <input type="text" class="form-control" id="nombreArtistico" name="nombreArtistico" placeholder="Digite aquí su nombre artítico">
            </div>
        </div>
        <div class="form-group row">
            <label for="feNacimArtista" class="col-sm-2 col-form-label">Fecha de nacimiento</label>
            <div class="col-sm-10">
                 <input type="number" class="form-control" id="feNacimArtista" name="feNacimArtista" placeholder="Seleccione su fecha de nacimiento">
            </div>
        </div>
        <div class="form-group row">
            <label for="emailArtista" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                 <input type="email" class="form-control" id="emailArtista" name="emailArtista" placeholder="Digite aquí su correo electrónico">
            </div>
        </div>
        <fieldset class="form-group">
            <div class="row">
            <legend class="col-form-label col-sm-2 pt-0">Estado</legend>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="estadoArtista" id="estadoArtista" value="option1" checked>
                        <label class="form-check-label" for="estadoArtista">Activo</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="estadoArtista" id="estadoArtista" value="option2" checked>
                        <label class="form-check-label" for="estadoArtista">Inactivo</label>
                    </div>
                </div>
            </div>
        </fieldset>
        <div class="form-group row">
          <div class="col-sm-10">
            <a id="botonVolver" class="btn btn-primary" href="artista?accion=visualizar">Volver</a>
            <button type="submit" class="btn btn-success" name="accion" value="Registrar">Enviar</button>
          </div>
        </div>
      </form>
      <%@include file = "../footer.jsp" %>
</body>
</html>