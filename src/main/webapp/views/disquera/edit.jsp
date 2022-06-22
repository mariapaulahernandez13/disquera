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
  <h3 id="tituloEdit">Actualizar disquera</h3>

  <section>
    <div class="box">
        <div class="container">
            <div class="form">
            <c:forEach var="disquera" items="${disquerasList}">
                <h2>Editar la disquera "${disquera.getNombreDisquera()}"</h2>
                <form action="disquera" method="post">
                    <label for="nitDisquera" class="inputBox">Nit:</label>
                    <div class="inputbox col-sm-10">
                        <input name="nitDisquera" type="number" class="form-control" id="nitDisquera" value="${disquera.getNitDisquera()}" placeholder="Nit de la disquera">
                    </div>
                    <label>Nombre:</label>
                    <div class="inputBox">
                        <input name="getNombreDisquera" id="getNombreDisquera" type="text" value="${disquera.getNombreDisquera()}" placeholder="Nombre de la disquera">
                        <input hidden name="idDisqura" id="idDisqura" type="number" value="${disquera.getIdDisquera()}" >
                    </div>
                    <label for="telefonoDisquera" class="inputBox">Teléfono:</label>
                    <div class="inputbox col-sm-10">
                        <input name="telefonoDisquera" type="number" class="form-control" id="telefonoDisquera" value="${disquera.getTelefonoDisquera()}" placeholder="Teléfono">
                    </div>
                    <label>Dirección:</label>
                    <div class="inputBox">
                        <input name="direccionDisquera" id="direccionDisquera" type="text" value="${disquera.getDireccionDisquera()}" placeholder="Dirección">
                    </div>
                    <label hidden>Estado:</label>
                    <div>
                        <input hidden type="checkbox" name="estadoDisquera" id="estadoDisquera" value="${estadoDisquera.isEstadoDisquera()}" checked class="form-check-input">
                        <label hidden for="estadoDisquera"> Activo</label>
                    </div>
                    
                    <div class="inputBox">
                        <br>
                        <a id="botonVolver" class="btn btn-primary" href="disquera?accion=visualizar">Volver</a>
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