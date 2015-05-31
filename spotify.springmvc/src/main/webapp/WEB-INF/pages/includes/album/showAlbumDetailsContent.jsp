<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angularjs/controllers.js"></script>
 
<script>
var jsonObject = ${showAlbumDetailsViewBean.mapMsgs['jsonAlbumes']};
var jsonObjectAlbumTracks = ${showTracksOfAlbumesListViewComponentBean.mapMsgs['jsonTracks']};

var app = angular.module('showAlbumDetailsCntApp',[]);
app.factory('audio',function ($document) {
	  var audioElement = $document[0].createElement('audio'); 
	  return {
	    audioElement: audioElement,
	    play: function(filename) {
	        audioElement.src = filename;
	        audioElement.autoPlay = false;
	        audioElement.play();
	    }
	    

	  }
	});
	
app.factory('video', function($document) {
    var videoElement = $document[0].createElement('video');
    //alert(videoElement);
    videoElement.autoPlay = false;
    return {
       videoElement: videoElement,
       play: function(filename) {
          videoElement.src = filename;
          videoElement.play();
       },
       resume: function() {
          videoElement.play();
       },
       pause: function() {
          videoElement.pause();
       },
       stop: function() {
          videoElement.pause();
          videoElement.src = videoElement.currentSrc; /** http://stackoverflow.com/a/16978083/1015046 **/
       },
       incVol: function() {
          if(videoElement.volume < 1) {
             videoElement.volume = (videoElement.volume + 0.1).toFixed(2);
          }
          return videoElement.volume;
       },
       decVol: function() {
          if(videoElement.volume > 0) {
             videoElement.volume = (videoElement.volume - 0.1).toFixed(2);
          }
          return videoElement.volume;
       },
       timer: function(callback) {
          videoElement.ontimeupdate = function() {
             callback(videoElement.duration, videoElement.currentTime)
          };
       },
    }
 });
	
app.filter('noFractionCurrency',
		  [ '$filter', '$locale',
		  function(filter, locale) {
		    var currencyFilter = filter('currency');
		    var formats = locale.NUMBER_FORMATS;
		    return function(amount, currencySymbol) {
		      var value = currencyFilter(amount, currencySymbol);
		      var sep = value.indexOf(formats.DECIMAL_SEP);
		      if(amount >= 0) { 
		        return value.substring(1, sep);
		      }
		      return value.substring(1, sep) + ')';
		    };
		  } ]);
	app.controller('showAlbumDetailsContentController', ['$scope','$http','$location','$window',showAlbumDetailsContentController]);
	app.controller('showTracksListController', ['$scope','$http','$location','$window','audio','video',showTracksListController]);
	// Define a simple audio service 
	
	</script>
  <div class="container">
    <div class="panel panel-default" ng-app='showAlbumDetailsCntApp' ng-controller="showAlbumDetailsContentController as vm" 
data-ng-init="vm.init('${pageContext.request.contextPath}')">
      <div class="panel-heading">
            <h1>
              <small><span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span><spring:message
					code="showAlbumDetails.panel.header.title" /></small>
              <mark>&nbsp;{{ vm.jsonObject.name }}</mark>
             
              <button id="btnGuardarCorreo" type="button" class="btn-link" onclick="crearContenidoCapaCorreoOrdinario('Álbum','vm.jsonObject.name','','vm.jsonObject.id' );">
                  <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
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
              <%@ include file="showTracksList.jsp" %>
            </div>
          </div>
       
        
      </div>
    </div>
  </div>
