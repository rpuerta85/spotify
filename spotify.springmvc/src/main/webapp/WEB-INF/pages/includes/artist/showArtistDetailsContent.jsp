<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angularjs/controllers.js"></script>
 
<script>
var jsonObject = ${showArtistDetailsViewBean.mapMsgs['jsonArtists']};
var jsonObjectArtistAlbumes = ${showAlbumesOfArtistListViewComponentBean.mapMsgs['jsonAlbumes']};
var urlMoreResult = "${showArtistDetailsViewBean.mapMsgs['showArtistDetailsUrl']}";

var app = angular.module('showArtistDetailsCntApp',[]);
	app.controller('showArtistDetailsContentController', ['$scope','$http','$location','$window',showArtistDetailsContentController]);
	app.controller('showAlbumesListController', ['$scope','$http','$location','$window',showAlbumesListController]);

	</script>
<div class="panel panel-default" 
ng-app='showArtistDetailsCntApp' ng-controller="showArtistDetailsContentController as vm" 
data-ng-init="vm.init('${pageContext.request.contextPath}','${_csrf.token}','${indexView.mapMsgs['userId']}')">

	<div class="panel-heading">
		<h1>
			<small><span aria-hidden="true"
				class="glyphicon glyphicon-user"></span> <spring:message
					code="showArtistDetails.panel.header.title" /></small>
			<mark>
				{{ vm.jsonObject.name }}
				<!-- ${findFavoriteFormBean.mapMsgs['formFindFavoriteNameMsgError']} -->
			</mark>
			<!-- <a href="">
                  <span class="glyphicon glyphicon-star-empty" aria-hidden="true" title="Marcar Artista Favorito"></span>
              </a>-->

			<button
				onclick="crearContenidoCapaCorreoOrdinario('Intérprete','Pink Floyd','/rusuariofavoritos/0k17h0D3J5VfsdmQ1iZtE9/1/new','0k17h0D3J5VfsdmQ1iZtE9' );"
				class="btn-link" type="button" id="btnGuardarCorreo">
				<span aria-hidden="true" class="glyphicon glyphicon-star-empty"></span>
			</button>
		</h1>
	</div>

    <div class="panel-body">

          <div class="row">
            <div class="col-md-4">
              <p class="text-left">
                <img ng-src="{{ vm.jsonObject.images[0].url }}" class="img-responsive" alt="Imagen {{ vm.jsonObject.name }}"><br>
                <a ng-href='{{ vm.jsonObject.external_urls.spotify }}' target='_blank' 
                   title='Escuchar en Spotify'>
                   <img src="${pageContext.request.contextPath}/resources/images/logoSpotify.png" class="img-responsive" alt="Spotify"><br>
                </a>
              </p>
            </div>
            <div class="col-md-8">
					<%@ include file="showAlbumesList.jsp" %>
             <a ng-href="${pageContext.request.contextPath}/${showArtistDetailsViewBean.mapMsgs['showAlbumDetailsUrl']}/{{vm.jsonObject.id}}"
                   class="btn btn-info" role="button">
                  Más resultados &raquo;
   			 </a> 
   			 <!--  <a ng-click="vm.moreResult()"
                   class="btn btn-info" role="button">
                  Más resultados2 &raquo;
   			 </a>  -->
            </div>
          </div>
        
        
      </div>
</div>
