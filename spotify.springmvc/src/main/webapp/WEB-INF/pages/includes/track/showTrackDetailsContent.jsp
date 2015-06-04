<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angularjs/controllers.js"></script>
 
<script>
var jsonObject = ${showTrackDetailsViewBean.mapMsgs['jsonTracks']};
var jsonObjectArtistAlbumes = ${showAlbumesOfArtistListViewComponentBean.mapMsgs['jsonAlbumes']};
var app = angular.module('showTrackDetailsCntApp',[]);
app.factory('audio',auditoFactory);
app.factory('video', videoFactory);
app.filter('noFractionCurrency', [ '$filter', '$locale',durationTrackFilter ]);
app.controller('showAlbumDetailsContentController', ['$scope','$http','$location','$window',showAlbumDetailsContentController]);
app.controller('showAlbumesListController', ['$scope','$http','$location','$window',showAlbumesListController]);
app.controller('showTracksListController', ['$scope','$http','$location','$window','audio','video',showTracksListController]);
	</script>
  <div class="container">
    <div class="panel panel-default" ng-app='showTrackDetailsCntApp' ng-controller="showAlbumDetailsContentController as vm" 
data-ng-init="vm.init('${pageContext.request.contextPath}')">
      <div class="panel-heading">
            <h1>
              <small><span class="glyphicon glyphicon-music" aria-hidden="true"></span><spring:message
					code="showTrackDetails.panel.header.title" /></small>
              <mark>&nbsp;{{ vm.jsonObject.name }}</mark>
               <button id="btnGuardarCorreo" type="button" class="btn-link" onclick="crearContenidoCapaCorreoOrdinario('Álbum','vm.jsonObject.name','','vm.jsonObject.id' );">
                  <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
             </button>
            </h1>
          </div>

          <div class="panel-body">
            <div class="row">
              <div class="col-md-6">
                <p class="text-left">
                  <img ng-src="{{ vm.jsonObject.album.images[0].url }}" class="img-responsive" alt="Imagen {{ vm.jsonObject.name }}">
                </p>  
              </div>
              <div class="col-md-6">
                <p><spring:message
					code="showArtistDetails.panel.header.title" /> 
					<a ng-href="${pageContext.request.contextPath}/${showTrackDetailsViewBean.mapMsgs['showArtistDetailsUrl']}/{{ vm.jsonObject.artists[0].id }}" title="<spring:message
					code="showTrackDetails.link.artist.title" />">
                  {{ vm.jsonObject.artists[0].name }}
                </a></p>
                <p><spring:message
					code="showAlbumDetails.panel.header.title" /><a ng-href="${pageContext.request.contextPath}/${showTrackDetailsViewBean.mapMsgs['showAlbumDetailsUrl']}/{{ vm.jsonObject.album.id }}" title="<spring:message
					code="showTrackDetails.link.album.title" />">
                  {{ vm.jsonObject.album.name }}
                </a></p>
                <p> <spring:message
					code="showTrackDetails.track.button.duration.title" /> {{vm.jsonObject.duration_ms / 60000 | noFractionCurrency }}:{{(vm.jsonObject.duration_ms /1000)%60 | noFractionCurrency }}
                </p>
                <button   ng-controller="showTracksListController as vm2" ng-click="vm2.kk(vm.jsonObject.preview_url)" type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-modal-sm" title="<spring:message
					code="showTrackDetails.track.button.playSong.title" />">
                  <spring:message
					code="showTrackDetails.track.button.playSong.title" /> &raquo;
                </button>
                <div class="modal fade bs-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel1" aria-hidden="true">
                  <div class="modal-dialog modal-sm">
                    <div class="modal-content">
                    <!-- <video id="video" controls>
                      </video>   -->
                        <audio controls="controls" preload="none"> 
                    </div>
                  </div>
                </div>
                <hr>
                <p>
                  <a ng-href='{{ vm.jsonObject.external_urls.spotify }}' target='_blank' 
                     title='Escuchar en Spotify'>
                     <img src="${pageContext.request.contextPath}/resources/images/logoSpotify.png" class="img-responsive" alt="Spotify"><br>
                  </a>
                </p>

              </div>
            </div>
        
        </div>
    </div>
  </div>
  