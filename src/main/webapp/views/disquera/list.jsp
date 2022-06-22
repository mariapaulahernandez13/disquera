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
    <title>Listar canción</title>
</head>
<body>
      <h3 id="tituloEdit">Consultar disquera</h3>

      <table class="table table-hover text-center">
        <thead class="thead  text-center">
          <tr>
            <th scope="col" colspan="8">Datos canción</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Identificación</td>
            <td>Nit</td>
            <td>Nombre</td>
            <td>Teléfono</td>
            <td>Direccion de la disquera</td>
            <td>Estado</td>
            <td>Cambio de estado</td>
            <td>Acciones</td>
          </tr>
        </tbody>
        <tr>
            <td colspan="8">
                <a id="botonList3" class="btn btn-primary" href="disquera?accion=registrar" role="button">Agregar disquera</a>
            </td>
        </tr>

        <c:forEach var="disquera" items="${disquerasList}">         
          <tr>
            <td>${disquera.getNitDisquera()}</td>
            <td>${disquera.getIdDisquera()}</td>
            <td>${disquera.getNombreCancion()}</td>
            <td>${disquera.getTelefonoDisquera()}</td>
            <td>${cancion.getDireccionDisquera()}</td>
            <c:if test = "${disquera.isEstadoDisquera() == true}">
                <td><span class="badge bg-success active">Activo</span></td> 
              </c:if>
              <c:if test = "${disquera.isEstadoDisquera() == false}">
                  <td><span class="badge bg-danger active">Inactivo</span></td> 
            </c:if>

            <c:if test="${disquera.isEstadoDisquera() == true}">
              <td>
                <a href="disquera?accion=estado&idDisquera=${disquera.getIdDisquera()}&estadoDisquera=false"><button class="btn btn-warning" type="button">Inactivar</button> </a> 
              </td> 
            </c:if>
            <c:if test="${disquera.isEstadoDisquera() == false}">
              <td>
                <a href="disquera?accion=estado&idDisquera=${disquera.getIdDisquera()}&estadoDisquera=true"><button class="btn btn-info" type="button">Activar</button> </a>
              </td> 
            </c:if>
            <td>
              <a id="botonList1" class="btn btn-danger" href="disquera?accion=eliminar&idDisquera=${disquera.getIdDisquera()}" role="button">Eliminar</a>
              <a id="botonList2" class="btn btn-success" href="disquera?accion=editar&idDisquera=${disquera.getIdDisquera()}" role="button">Actualizar</a>
            </td>
          <tr>
        </c:forEach>
      </table>
      <%@include file = "../footer.jsp" %>
</body>
</html>