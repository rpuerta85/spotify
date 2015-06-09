<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<script>
var app = angular.module('artistCntApp',[]);
app.controller('artistCntCtrl', artistContentController);
function artistContentController($scope, $http,$location){
	var vm=this;
	   vm.artists = ${findFavoritesArtistsViewBean.mapMsgs['jsonArtists']}; 
	   vm.context = "${pageContext.request.contextPath}";
	   vm.limit = 5;
	   vm.moreResult = function(){
		   vm.limit +=5;
		   return vm.limit;
	   }
	} 

</script>    
<div ng-app='artistCntApp' ng-controller="artistCntCtrl as vm" >
<div class="panel panel-default">
      <div class="panel-heading">
        <h1>
            <span aria-hidden="true" class="glyphicon glyphicon-user"></span> 
             <spring:message code="showArtistsView.panel.header.title" /> 
             <small><spring:message code="showArtistsView.panel.header.subtitle" />
             <kbd>"${findFavoritesArtistsViewBean.mapMsgs['favoriteText']}"</kbd></small>
        </h1>
        <p class="lead"><spring:message code="showArtistsView.panel.header.description" /> </p>
      </div>
      <div class="panel-body">
          <div class="table-responsive">
              <div class="panel panel-default">
              		<table class="table table-striped table-condensed" >
            			<tr  ng-repeat="artist in vm.artists.artists.items">
                      		<td>
	                          	<a ng-href="${pageContext.request.contextPath}/${findFavoritesArtistsViewBean.mapMsgs['showArtistDetailsUrl']}/{{artist.id}}?limit={{vm.limit}}"> 
	                          		<button type="button" class="btn btn-primary">
	                            			
	                            			<img  width="64" height="64" title="" alt=""  ng-src="{{artist.images[0].url}}">
	                            			<span  title="messagesCount" class="badge">{{artist.popularity}}</span>
	                          		</button>
                        		</a>
                      		</td>
                      		<td>
                      			<h2>{{artist.name}}</h2>
                      		</td>
                    	</tr>
               		</table>
                </div>
           </div>
      </div>
</div>


     
</div>