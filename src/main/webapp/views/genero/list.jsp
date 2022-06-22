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
    <title>Listar género</title>
</head>
<body>
      <h3 id="tituloEdit">Consultar Género</h3>

      <table class="table table-hover text-center">
        <thead class="thead  text-center">
          <tr>
            <th scope="col" colspan="5">Datos Género</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Identificación</td>
            <td>Nombre</td>
            <td>Estado</td>
            <td>Cambio de estado</td>
            <td>Acciones</td>
          </tr>
        </tbody>
        <tr>
            <td colspan="5">
                <a id="botonList3" class="btn btn-primary" href="genero?accion=registrar" role="button">Agregar género</a>
            </td>
        </tr>

        <c:forEach var="genero" items="${generosList}">         
          <tr>
            <td>${genero.getIdGenero()}</td>
            <td>${genero.getNombreGenero()}</td>
            <c:if test = "${genero.isEstadoGenero() == true}">
                <td><span class="badge bg-success active">Activo</span></td> 
              </c:if>
              <c:if test = "${genero.isEstadoGenero() == false}">
                  <td><span class="badge bg-danger active">Inactivo</span></td> 
            </c:if>

            <c:if test="${genero.isEstadoGenero() == true}">
              <td>
                <a href="genero?accion=estado&idGenero=${genero.getIdGenero()}&estadoGenero=false"><button class="btn btn-warning" type="button">Inactivar</button> </a> 
              </td> 
            </c:if>
            <c:if test="${genero.isEstadoGenero() == false}">
              <td>
                <a href="genero?accion=estado&idGenero=${genero.getIdGenero()}&estadoGenero=true"><button class="btn btn-info" type="button">Activar</button> </a>
              </td> 
            </c:if>
            <td>
              <a id="botonList1" class="btn btn-danger" href="genero?accion=eliminar&idGenero=${genero.getIdGenero()}" role="button">Eliminar género</a>
              <a id="botonList2" class="btn btn-success" href="genero?accion=editar&idGenero=${genero.getIdGenero()}" role="button">Actualizar género</a>
            </td>
          <tr>
        </c:forEach>
      </table>
      <%@include file = "../footer.jsp" %>
</body>
</html>