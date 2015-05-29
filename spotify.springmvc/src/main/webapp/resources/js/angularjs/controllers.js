function showArtistDetailsContentController($scope, $http,$location,$window){
	
	var vm=this;
	   vm.jsonObject =""; 
	   vm.context = "${pageContext.request.contextPath}";
	   vm.init = function(context,csrf,userId){
		   vm.jsonObject = $window.jsonObject;
		   //alert(JSON.stringify(vm.jsonObject));
	    }
	} 