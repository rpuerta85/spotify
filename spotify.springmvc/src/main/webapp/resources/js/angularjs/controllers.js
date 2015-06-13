function showArtistDetailsContentController($scope, $http,$location,$window){
	
	var vm=this;
	   vm.jsonObject =""; 
	   vm.context = "${pageContext.request.contextPath}";
	   vm.limit = 5;
	   vm.urlMoreResult = "";
	   vm.moreResult = function(){
		   $http({
	            url: vm.context+"/"+vm.urlMoreResult+"/"+vm.jsonObject.id+"?limit="+vm.limit,
	            method: "GET",
	            headers: {
	            	'Content-Type' :'application/x-www-form-urlencoded;charset=UTF-8'
	            	 },
	            data:"" 
	       
	         }).success(function(data, status, headers, config) {
	        	alert(data)
	        	 
	        }).error(function(data, status, headers, config) {
	        	$scope.status = status;
	            alert("fail:"+status);
	        });
		  
	   }
	   vm.init = function(context,csrf,userId){
		   vm.jsonObject = $window.jsonObject;
		   vm.context = context;
		   vm.urlMoreResult = $window.urlMoreResult; 
	    }
	   
	} 
function showAlbumesListController($scope, $http,$location,$window){
	var vm=this;
	   vm.jsonObject =""; 
	   vm.context = "${pageContext.request.contextPath}";
	   vm.init = function(context,csrf,userId){
		   vm.jsonObject = $window.jsonObjectArtistAlbumes;
		   //alert(JSON.stringify(vm.jsonObject));
	    }
	} 

function showAlbumDetailsContentController($scope, $http,$location,$window){
	
	var vm=this;
	   vm.jsonObject =""; 
	   vm.context = "${pageContext.request.contextPath}";
	   vm.urlMoreResult = "";
	   vm.init = function(context){
		   vm.jsonObject = $window.jsonObject;
		   vm.context = context;
		   //vm.urlMoreResult = $window.urlMoreResult; 
	    }
	   
	} 

function showTracksListController($scope, $http,$location,$window,audio,video){
	var vm=this;
	   vm.jsonObject =""; 
	   vm.context = "${pageContext.request.contextPath}";
	   vm.init = function(context){
		   vm.jsonObject = $window.jsonObjectAlbumTracks;
		   vm.context = context;
		   //alert(JSON.stringify(vm.jsonObject));
	    },
	    vm.songSelect = function(songPath) {
	    	//audio.play(songPath); 
	    }
	    ,
	    vm.kk = function(songPath){
	    	audio.play(songPath);
	    	//video.play(songPath)
	    }
	
	   
	} 
function tracksContentController($scope, $http,$location,$window){
	var vm=this;
	   vm.json = "";//$window.jsonObject; 
	   vm.context = "";
	   vm.limit = 5;
	   vm.init = function(context,jsonObject){
		   //vm.tracks = $window.jsonObject;//tambien funciona
		   vm.json = window[jsonObject];
		   vm.context = context;
	    }
	} 

function auditoFactory($document) {
	  var audioElement = $document[0].createElement('audio'); 
	  return {
	    audioElement: audioElement,
	    play: function(filename) {
	        audioElement.src = filename;
	        audioElement.autoPlay = false;
	        audioElement.play();
	    }
	    

	  }
	};
function videoFactory($document) {
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
	          videoElement.src = videoElement.currentSrc; 
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
	 }

function durationTrackFilter(filter, locale) {
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
  }

function showUsersContentController($scope, $http,$location,$window){
	var vm=this;
	   vm.jsonObject =""; 
	   vm.context = "${pageContext.request.contextPath}";
	   vm.csrf = "";
	   vm.init = function(context,csrf){
		   vm.jsonObject = $window.jsonObject;
		   vm.csrf = csrf;
		   vm.context = context;
	    }
	   
	  /*//esto seria para hacerlo por ajax , pero mejor por href con spring
	   * vm.showUser = function(user){
		   $http({
	            url: vm.context+"/user/show/"+user.idUUID,
	            method: "GET",
	            headers: {
	            	'Content-Type' :'application/x-www-form-urlencoded;charset=UTF-8'
	            	 },
	            data:"" 
	       
	         }).success(function(data, status, headers, config) {
	        	//alert(data)
	        	 
	        }).error(function(data, status, headers, config) {
	        	$scope.status = status;
	            alert("fail:"+status);
	        });
		  
	   }*/
	   
	   
	   
	   
	   
	} 