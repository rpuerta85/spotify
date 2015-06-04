<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page session="true"%>
<%@ include file="template/layout.jsp" %>
<div  class="container" id="cntBody" >
		<%@ include file="includes/homeContent.jsp" %> 
<%@ include file="template/footer.jsp" %> 
</div>
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
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>


	</sec:authorize>
	
 
	
	
	
</body>
</html>