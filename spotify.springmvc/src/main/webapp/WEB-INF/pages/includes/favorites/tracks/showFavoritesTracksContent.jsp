<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angularjs/controllers.js"></script>
<script>
var app = angular.module('tracksCntApp',[]);
app.controller('tracksCntCtrl', tracksContentController);
window.jsonObject = ${findFavoritesTracksViewBean.mapMsgs['jsonArtists']};
</script>    
<div ng-app='tracksCntApp' ng-controller="tracksCntCtrl as vm" data-ng-init="vm.init('${pageContext.request.contextPath}','jsonObject')" >
<div class="panel panel-default">
      <div class="panel-heading">
        <h1>
            <span aria-hidden="true" class="glyphicon glyphicon-music"></span> 
            <spring:message code="showTracksView.panel.header.title" /> 
            <small><spring:message code="showTracksView.panel.header.subtitle" /><kbd>"${findFavoritesTracksViewBean.mapMsgs['favoriteName']}"</kbd></small>
        </h1>
        <p class="lead"><spring:message code="showTracksView.panel.header.description" /> </p>
      </div>
      <div class="panel-body">
          <div class="table-responsive">
              <div class="panel panel-default">
              		<table class="table table-striped table-condensed" >
            			<tr  ng-repeat="track in vm.json.tracks.items">
                      		<td>
	                          	<a ng-href="${pageContext.request.contextPath}/${findFavoritesTracksViewBean.mapMsgs['showTrackDetailsUrl']}/{{track.id}}?idArtist={{track.artists[0].id}}&limit={{vm.limit}}"> 
	                          		<button type="button" class="btn btn-primary">
	                            			
	                            			<img  width="64" height="64" title="" alt=""  ng-src="{{track.album.images[0].url}}">
	                            			<span  title="popularity" class="badge">{{track.popularity}}</span>
	                          		</button>
                        		</a>
                      		</td>
                      		<td>
                      			<h2>{{track.name}}</h2>
                      		</td>
                    	</tr>
               		</table>
                </div>
           </div>
      </div>
</div>


     
</div>