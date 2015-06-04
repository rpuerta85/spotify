<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
 <div class="panel panel-default">
      <div class="panel-heading">
        <h1>
          <span aria-hidden="true" class="glyphicon glyphicon-folder-open"></span> 
          <spring:message code="findAlbumView.panel.header.title" /><small><spring:message code="findAlbumView.panel.header.subtitle" /></small>
        </h1>
        <p class="lead"><spring:message code="findAlbumView.panel.header.description" /></p>
      </div>
      <div class="panel-body">
		 <%@ include file="../../forms/findFavoriteForm.jsp" %> 
      </div>
  </div>
