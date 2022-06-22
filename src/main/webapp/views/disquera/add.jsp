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
    <title>Agregar disquera</title>
</head>
<body>    
      <h3 id="tituloEdit">Registrar disquera</h3>

      <form action="disquera" method="post" class="text-center">
        <div class="form-group row">
            <label for="nitDisquera" class="col-sm-2 col-form-label">Nit</label>
            <div class="col-sm-10">
                 <input type="number" class="form-control" id="nitDisquera" name="nitDisquera" placeholder="Digite aquí el nit de la disquera">
            </div>
        </div>
        <div class="form-group row">
            <label for="nombreDisquera" class="col-sm-2 col-form-label">Nombre</label>
            <div class="col-sm-10">
                 <input type="text" class="form-control" id="nombreDisquera" name="nombreDisquera" placeholder="Digite aquí el nombre de la disquera">
            </div>
        </div>
        <div class="form-group row">
            <label for="telefonoDisquera" class="col-sm-2 col-form-label">Teléfono</label>
            <div class="col-sm-10">
                 <input type="number" class="form-control" id="telefonoDisquera" name="telefonoDisquera" placeholder="Digite el teléfono de la disquera">
            </div>
        </div>
        <div class="form-group row">
            <label for="direccionDisquera" class="col-sm-2 col-form-label">Dirección</label>
            <div class="col-sm-10">
                 <input type="text" class="form-control" id="direccionDisquera" name="direccionDisquera" placeholder="Digite aquí la dirección de la disquera">
            </div>
        </div>
        <fieldset class="form-group">
            <div class="row">
            <legend class="col-form-label col-sm-2 pt-0">Estado</legend>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="estadoDisquera" id="estadoDisquera" value="estadoDisquera" checked>
                        <label class="form-check-label" for="estadoDisquera">Activa</label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="estadoDisquera" id="estadoDisquera" value="estadoDisquera">
                        <label class="form-check-label" for="estadoDisquera">Inactiva</label>
                    </div>
                </div>
            </div>
        </fieldset>
        <div class="form-group row">
          <div class="col-sm-10">
            <button type="submit" class="btn btn-success" name="accion" value="Registrar">Enviar</button>
            <a id="botonVolver" class="btn btn-primary" href="disquera?accion=visualizar">Volver</a>
          </div>
        </div>
      </form>
      <%@include file = "../footer.jsp" %>
</body>
</html>