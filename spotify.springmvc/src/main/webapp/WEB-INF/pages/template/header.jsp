<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}
</style>
<div role="navigation" class="navbar navbar-default" id="nav">
        <div class="navbar-header">
          <button aria-controls="navbar" aria-expanded="false" data-target="#navbar" data-toggle="collapse" class="navbar-toggle collapsed" type="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a href="${pageContext.request.contextPath}/" class="navbar-brand"><span aria-hidden="true" class="glyphicon glyphicon-home"> </span></a>
        </div>
        <div class="navbar-collapse collapse navbar-responsive-collapse" id="navbar">
          <ul class="nav navbar-nav">
            <li><a href="/artista/buscar"><span aria-hidden="true" class="glyphicon glyphicon-user"></span>&nbsp; Intérpretes</a></li>
            <li><a href="/album/buscar"><span aria-hidden="true" class="glyphicon glyphicon-folder-open"></span>&nbsp; Álbumes</a></li>
            <li><a href="/tema/buscar"><span aria-hidden="true" class="glyphicon glyphicon-music"></span>&nbsp; Temas</a></li>
                            </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="pull-right">
    		<!-- El formalario de autenticacion de muestra SOLO si no estamos logeados, es decir, si no tenemos nombre de usuario -->
    		<c:if test="${pageContext.request.userPrincipal.name == null}">
                  <form method="post" action="<c:url value='/j_spring_security_check' />" role="form" class="navbar-form navbar-right form-inline">
	                  <div class="form-group">
	                      <input type="text" required="required" class="form-control" name="username" id="username" placeholder="Usuario">
	                  </div>
	                  <div class="form-group">
	                    <input type="password" required="required" class="form-control" name="password" id="password" placeholder="Password">
	                  </div>
	                  <button class="btn btn-success btn-xlarge" type="submit">Login <span aria-hidden="true" class="glyphicon glyphicon-log-in naranja"></span></button>
	                  <input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
                </form>
             </c:if>
              <!-- Este formulario solo se muestra si tenemos el ROLO ROLE_USER -->
               <sec:authorize access="hasRole('ROLE_USER')">
					<!-- For login user -->
					<form action="${pageContext.request.contextPath}/logout" method="get" id="logoutForm">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
					<script>
						function formSubmit() {
							document.getElementById("logoutForm").submit();
						}
					</script>
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<h4>
							Usuario : ${pageContext.request.userPrincipal.name} | <a
								href="javascript:formSubmit()" class="btn btn-warning btn-xlarge" role="button"> Logout</a>
						</h4>
					</c:if>
				</sec:authorize>
                          </li>
          </ul>
        </div><!--/.navbar -->
         
    </div>
    <c:if test="${not empty error}">
		<div class="error">${error}</div>
	</c:if>
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>