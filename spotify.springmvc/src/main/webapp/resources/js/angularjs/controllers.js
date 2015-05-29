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
	    	video.play(songPath);
	    	//audio.play(songPath); 
	    	//alert(songPath);	
	    }
	
	   
	} 
