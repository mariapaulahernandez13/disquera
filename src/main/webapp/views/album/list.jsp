<%@ page language = "java" contentType = "text/html; charset=utf-8" pageEncoding = "utf-8"%>
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
    <title>Listar álbum</title>
</head>
<body>
        <h3 id="tituloEdit">Consultar álbum</h3>

      <table class="table table-hover">
        <thead class="thead  text-center">
          <tr>
            <th scope="col" colspan="6">Datos álbum</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Identificación</td>
            <td>Nombre</td>
            <td>Año publicación</td>
            <td>Estado</td>
            <td>Cambio de estado</td>
            <td>Acciones</td>
          </tr>
        </tbody>
        <tr>
            <td colspan="6">
                <a id="botonList3" class="btn btn-primary" href="servlet?direccionar=addAlbum" role="button">Agregar álbum</a>
            </td>
        </tr>

        <c:forEach var="album" items="${albumesList}">         
          <tr>
            <td>${album.getIdAlbum()}</td>
            <td>${album.getNombreAlbum()}</td>
            <td>${album.getAnioPublicacion()}</td>
            <c:if test = "${album.isEstadoAlbum() == true}">
              <td><span class="badge bg-success active">Activo</span></td> 
            </c:if>
            <c:if test = "${album.isEstadoAlbum() == false}">
              <td><span class="badge bg-danger active">Inactivo</span></td> 
            </c:if>

            <c:if test="${album.isEstadoAlbum() == true}">
              <td>
                <a href="album?accion=estado&idAlbum=${album.getIdAlbum()}&estadoAlbum=false"><button class="btn btn-warning" type="button">Inactivar</button> </a> 
              </td> 
            </c:if>
            <c:if test="${album.isEstadoAlbum() == false}">
              <td>
                <a href="album?accion=estado&idAlbum=${album.getIdAlbum()}&estadoAlbum=true"><button class="btn btn-info" type="button">Activar</button> </a>
              </td> 
            </c:if>
            <td>
              <a id="botonList1" class="btn btn-danger" href="album?accion=eliminar&idAlbum=${album.getIdAlbum()}" role="button">Eliminar álbum</a>
              <a id="botonList2" class="btn btn-success" href="album?accion=editar&idAlbum=${album.getIdAlbum()}" role="button">Actualizar álbum</a>
            </td>
          <tr>
        </c:forEach>
      </table>
      <%@include file = "../footer.jsp" %>
</body>
</html>