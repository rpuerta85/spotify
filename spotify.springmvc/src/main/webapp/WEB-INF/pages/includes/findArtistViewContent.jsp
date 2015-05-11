<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <div class="panel panel-default">
      <div class="panel-heading">
        <h1>
          <span aria-hidden="true" class="glyphicon glyphicon-user"></span> 
          ${findArtistViewBean.mapMsgs['panelHeaderTitle']} <small>${findArtistViewBean.mapMsgs['panelHeaderSubTitle']}</small>
        </h1>
        <p class="lead">${findArtistViewBean.mapMsgs['panelHeaderDescription']}</p>
      </div>
      <div class="panel-body">
        <form action="" method="post" class="form-horizontal">
	          <div class="form-group">
	            <label class="col-sm-2 control-label" for="artista">${findArtistViewBean.mapMsgs['formFindArtistLabelValue']}</label>
	            <div class="col-sm-4">
	                <input type="text" required="required" placeholder="${findArtistViewBean.mapMsgs['formFindArtistInputTextPlaceholder']}" id="artistName" name="artistName" class="form-control">
	           		<c:if test="${findArtistViewBean.success==false}">
	           			<span class="error2">${findArtistViewBean.mapMsgs['formFindArtistArtistNameMsgError']}</span>	 
	            	</c:if>
	            </div>
	          </div>
	          <div class="form-group">
	            <button class="col-sm-offset-2 col-sm-1 btn btn-primary" type="submit">${findArtistViewBean.mapMsgs['formFindArtistButtonSubmitName']}</button>
	          </div>
	          <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
		</form>
      </div>
  </div>
