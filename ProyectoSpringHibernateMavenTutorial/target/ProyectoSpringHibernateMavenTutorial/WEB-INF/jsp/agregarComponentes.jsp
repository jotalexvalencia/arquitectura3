<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Componentes</title>
</head>
<body>
 <h4>${mensaje} : ${usuarioForm.nombre}</h4>
 <spring:url var="salir" value="/inicializarLogin.html"/>
 <a href="${lista}" >Salir</a>
</body>
 
<h4>${mensajeComponente}</h4>
<c:choose>
    <c:when test="${mensajeComponente !='Agregar Componente'}">
        <!--<c:url var="accionComponente" value="actualizarComponentes.html"/>-->
        <spring:url var="accionComponente" value="/actualizarComponentes.html"/>
    </c:when>
    <c:otherwise>
        <!--<c:url var="accionComponente" value="agregarComponentes.html"/>-->
        <spring:url var="accionComponente" value="/agregarComponentes.html"/>
    </c:otherwise>
</c:choose>
 
<form:form id="agregar" modelAttribute="componenteForm" method="post" action="${accionComponente}">
 <table width="400px" height="150px">
  <tr>
  <form:hidden path="id" />
  <td><form:label path="nombre">Nombre</form:label></td>
  <td><form:input  path="nombre"/></td>
  </tr>
  <tr>
  <td><form:label path="version">Versión</form:label></td>
  <td><form:input  path="version"/></td>
  </tr>
  <tr>
  <td><form:label path="tipo">Tipo</form:label></td>
  <td><form:input  path="tipo"/></td>
  </tr>
  <tr>
  <td><form:label path="extension">Extensión</form:label></td>
  <td><form:input  path="extension"/></td>
  </tr>
 
  <tr><td></td><td>
  <c:choose>
      <c:when test="${mensajeComponente !='Agregar Componente'}">
          <input type="submit" value="Modificar" />
      </c:when>
      <c:otherwise>
          <input type="submit" value="Agregar" />
      </c:otherwise>
  </c:choose>
  </td></tr>
 </table>
</form:form>
<spring:url var="lista" value="/mostrarComponentes.html"/>
<a href="${lista}" >Ver Lista de componentes</a>
</html>