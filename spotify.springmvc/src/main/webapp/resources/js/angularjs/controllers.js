
function artistContentController($scope, $http,$location,dataFactory){
	var vm=this;
	    vm.isChannelCreate = false;
	    vm.context = "${pageContext.request.contextPath}";
	    vm.csrfToken = "${_csrf.token}";
	    //vm.kk =JSON.parse('{\"kk\":${indexView.toJson(indexView.listDrowDownMenus)}}');  
	   // vm.memoryCommandRepository = descargasFactory.getMemoryCommandRepository();//new MemoryCommandRepository(null,{},[],[],[],[],null,[]);
	    $scope.$watch(function () { return dataFactory.getMemoryCommandRepository(); }, function (newValue, oldValue) {
	        if (newValue !== oldValue) {
	        	vm.memoryCommandRepository = newValue;

	        }
	    });
	    
	    vm.init = function(context,csrfToken){
	    	vm.csrfToken = csrfToken;
	    	vm.context = context;
	    },
	    vm.countMessagesOfTimeLine = function(idTimeLine){
	  		return indexCntFunctionPackage.CountUnReadedMessagesOfTimeLine(idTimeLine,vm.memoryCommandRepository.arrayMessages,vm.memoryCommandRepository.userId);
	    },
	    vm.getTimelineNameFromUserIdAndTimelineType = function(userId,timeLine){
	    	return indexCntFunctionPackage.GetTimelineNameFromUserIdAndTimelineType(userId,timeLine,vm.memoryCommandRepository);
	    },
	    vm.getTimeLineImageFromTimeLineType = function(timeLineType){
	    	return indexCntFunctionPackage.GetTimeLineImageFromTimeLineType(timeLineType,vm.context);
	    },
	    vm.removeTimeLine = function(timeLine){
	    	indexCntFunctionPackage.ShowConfirmDialog();
	    },
	    vm.getLastMessageFromTimeline = function(idTimeLine){
	    	return indexCntFunctionPackage.
	    	GetLastMessageFromTimeline(idTimeLine, vm.memoryCommandRepository.arrayMessages,
	    			vm.memoryCommandRepository.channelId).substring(0,constantsPackage.CharactersMaximumCountInLastMessageOfTimeLine);
	    	
	    },
	    vm.setTimeLineToUnReadedFromReadedMessage = function(messageCommandObject,memoryCommandRepository){
		   chatCntFunctionPackage.SetTimeLineIdOpenedToTrueOrFalse(memoryCommandRepository,messageCommandObject.params.timeline.id,false);
	    };
	} 
	