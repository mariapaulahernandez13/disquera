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
    <title>Listar artista</title>
</head>
<body>
  <%@include file = "../header.jsp" %>
      <h3 id="tituloEdit">Consultar artista</h3>

      <table class="table table-hover">
        <thead class="thead  text-center">
          <tr>
            <th scope="col" colspan="11">Datos artista</th>
          </tr>
        </thead>
        <tbody><center>
          <tr>
            <td>Identificación</td>
            <td>Número de documento</td>
            <td>Tipo de documento</td>
            <td>Nombre</td>
            <td>Apellido</td>
            <td>Nombre artistico</td>
            <td>Fecha de nacimiento</td>
            <td>Correo electrónico</td>
            <td>Estado</td>
            <td>Cambio de estado</td>
            <td>Acciones</td>
          </tr></center>
        </tbody>
        <tr>
            <td colspan="11">
                <a id="botonList3" class="btn btn-primary" href="servlet?direccionar=addArtista" role="button">Agregar artista</a>
            </td>
        </tr>

        <c:forEach var="artista" items="${artistasList}">         
          <tr>
            <td>${artista.getIdArtista()}</td>
            <td>${artista.getNoDocumento()}</td>
            <td>${artista.getTipoDocumento()}</td>
            <td>${artista.getNombreArtista()}</td>
            <td>${artista.getApellidoArtista()}</td>
            <td>${artista.getNombreArtistico()}</td>
            <td>${artista.getFeNacimArtista()}</td>
            <td>${artista.getEmailArtista()}</td>
            <c:if test = "${artista.isEstadoArtista() == true}">
                <td><span class="badge bg-success active">Activo</span></td> 
              </c:if>
              <c:if test = "${artista.isEstadoArtista() == false}">
                  <td><span class="badge bg-danger active">Inactivo</span></td> 
            </c:if>

            <c:if test="${artista.isEstadoArtista() == true}">
              <td>
                <a href="artista?accion=estado&idArtista=${artista.getIdArtista()}&estadoArtista=false"><button class="btn btn-warning" type="button">Inactivar</button> </a> 
              </td> 
            </c:if>
            <c:if test="${artista.isEstadoArtista() == false}">
              <td>
                <a href="artista?accion=estado&idArtista=${artista.getIdArtista()}&estadoArtista=true"><button class="btn btn-info" type="button">Activar</button> </a>
              </td> 
            </c:if>
            <td>
              <a id="botonList1" class="btn btn-danger" href="artista?accion=eliminar&idArtista=${artista.getIdArtista()}" role="button">Eliminar</a>
              <a id="botonList2" class="btn btn-success" href="artista?accion=editar&idArtista=${artista.getIdArtista()}" role="button">Actualizar</a>
            </td>
          <tr>
        </c:forEach>
      </table>
      <%@include file = "../footer.jsp" %>
</body>
</html>