<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angularjs/controllers.js"></script>
<script>
</script>    
<div>
<div class="container">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h1>
            <span class="glyphicon glyphicon-wrench" aria-hidden="true"></span> 
            Usuarios: <small>Dar de alta un nuevo usuario</small>
        </h1>
        <p class="lead">Desde aquí puede añadir un nuevo usuario:</p>
      </div>
      <div class="panel-body">
       <%@ include file="../../forms/userForm.jsp" %>
        <a href="">
            <span class="glyphicon glyphicon-arrow-left" aria-hidden="true">&nbsp;</span>
        </a>
      </div>
    </div>
  </div>


     
</div>