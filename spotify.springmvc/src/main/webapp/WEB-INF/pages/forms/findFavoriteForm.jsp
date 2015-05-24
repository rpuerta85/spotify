<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <form action="${findFavoriteFormBean.mapMsgs['formFindFavoriteAction']}" method="${findFavoriteFormBean.mapMsgs['formFindFavoriteMethod']}" class="form-horizontal">
	          <div class="form-group">
	            <label class="col-sm-2 control-label" for="artistName">${findFavoriteFormBean.mapMsgs['formFindFavoriteLabelValue']}</label>
	            <div class="col-sm-4">
	                <input type="text" required="required" placeholder="${findFavoriteFormBean.mapMsgs['formFindFavoriteInputTextPlaceholder']}" id="${findFavoriteFormBean.mapMsgs['formFindFavoriteInputTextId']}" name="${findFavoriteFormBean.mapMsgs['formFindFavoriteInputTextName']}" class="form-control">
	           		<c:if test="${findFavoriteFormBean.success==false}">
	           			<span class="error2">${findFavoriteFormBean.mapMsgs['formFindFavoriteNameMsgError']}</span>	 
	            	</c:if>
	            </div>
	          </div>
	          <div class="form-group">
	            <button class="col-sm-offset-2 col-sm-1 btn btn-primary" type="submit">${findFavoriteFormBean.mapMsgs['formFindFavoriteButtonSubmitName']}</button>
	          </div>
	          <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
</form>