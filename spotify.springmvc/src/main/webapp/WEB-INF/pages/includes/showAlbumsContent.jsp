<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<script>
var app = angular.module('albumsCntApp',[]);
app.controller('albumsCntCtrl', artistContentController);
function artistContentController($scope, $http,$location){
	var vm=this;
	   vm.albums = ${findFavoriteFormBean.mapMsgs['jsonArtists']}; 
	   vm.context = "${pageContext.request.contextPath}";
	
	} 

</script>    
<div ng-app='albumsCntApp' ng-controller="albumsCntCtrl as vm" >
<div class="panel panel-default">
      <div class="panel-heading">
        <h1>
            <span aria-hidden="true" class="glyphicon glyphicon-user"></span> 
             <spring:message code="showAlbumsView.panel.header.title" /> <small><spring:message code="showAlbumsView.panel.header.subtitle" /></small>
        </h1>
        <p class="lead"><spring:message code="showAlbumsView.panel.header.description" /> </p>
      </div>
      <div class="panel-body">
          <div class="table-responsive">
              <div class="panel panel-default">
              		<table class="table table-striped table-condensed" >
            			<tr  ng-repeat="album in vm.albums.albums.items">
                      		<td>
	                          	<a href="<c:url value="" />"> 
	                          		<button type="button" class="btn btn-primary">
	                            			<img  width="64" height="64" title="" alt=""  ng-src="{{album.images[0].url}}">
	                          		</button>
                        		</a>
                      		</td>
                      		<td>
                      			<h2>{{album.name}}</h2>
                      		</td>
                    	</tr>
               		</table>
                </div>
           </div>
      </div>
</div>


     
</div>