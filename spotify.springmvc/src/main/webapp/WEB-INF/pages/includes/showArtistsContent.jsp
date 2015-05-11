<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
var app = angular.module('artistCntApp',[]);
app.controller('artistCntCtrl', artistContentController);
function artistContentController($scope, $http,$location){
	var vm=this;
	   vm.artists = ${findArtistViewBean.mapMsgs['jsonArtists']}; 
	   vm.context = "${pageContext.request.contextPath}";
	   vm.init = function(){
	   }
	   
	} 

</script>    
<div ng-app='artistCntApp' ng-controller="artistCntCtrl as vm" data-ng-init="vm.init()">
<div class="panel panel-default">
      <div class="panel-heading">
        <h1>
            <span aria-hidden="true" class="glyphicon glyphicon-user"></span> 
              ${findArtistViewBean.mapMsgs['panelHeaderTitle']} <small>${findArtistViewBean.mapMsgs['panelHeaderSubTitle']}</small>
        </h1>
        <p class="lead">${findArtistViewBean.mapMsgs['panelHeaderDescription']} </p>
      </div>
      <div class="panel-body">
          <div class="table-responsive">
              <div class="panel panel-default">
              		<table class="table table-striped table-condensed" >
            			<tr  ng-repeat="artist in vm.artists.artists.items">
                      		<td>
	                          	<a href="<c:url value="" />"> 
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