var app = angular.module('app', []);

app.controller('resultController',function($scope) {
  $scope.canoeList = [ {
	  id : 0,
      status:1,
      size: "test",
      number: 2,
      url : "test"
  }
 ];

 $scope.addCanoe=function(canoeId,canoeStatus,canoeSize,canoeNumber,canoeUrl){
	 console.log(canoeId+' '+ canoeStatus+' '+ canoeSize+' '+ canoeNumber+' '+ canoeUrl);
     strStatus='';
     strSize='';
     if(canoeStatus==1){
         strStatus='Available';
     }
     else{
         strStatus='Occupied';
     }
     
    /* if(canoeSize==2){
    	 strSize="Twice";   	 
     }
     else{
    	 strSize='Single';	
     }*/

    this.canoeList.push({
        id: canoeId,
        status: strStatus,
        size: canoeSize,
        numer: canoeNumber,
        url: canoeUrl

    });
 };
  $scope.clear=function(){
     this.canoeList=[ {
        id : 0,
        status:1,
        size: "test",
        number: 2,
        url : "test"
     }
     ];
};
});

function getCanoe(canoeId,canoeStatus,canoeSize,canoeNumber,canoeUrl) {
	//console.log(canoeId+' '+ canoeStatus+' '+ canoeSize+' '+ canoeNumber+' '+ canoeUrl);
	var scope = angular.element(document.getElementById("resultController")).scope();
	scope.$apply(function() {
		scope.addCanoe(canoeId,canoeStatus,canoeSize,canoeNumber,canoeUrl);
	});
}
function clearList(){
	var scope = angular.element(document.getElementById("resultController")).scope();
	scope.$apply(function() {
		scope.clear();
	});
}
function getAllCanoesAjax(){
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		url: '/canoe',
		success : function(canoe) {
		    clearList();
			$.each(canoe, function(index, canoe) {
			    getCanoe(canoe.id, canoe.status, canoe.size, canoe.number, canoe.url);
			});
		},
		error : function() {
		}
	});
}
function getCanoeAjax(){
	clearList();
        id=$('#searchInput').val();
        if(id==""){
          //  getAllCanoesAjax();
          console.log("no input value");
        }
        else{
            $.ajax({
                type : 'GET',
                dataType : 'JSON',
                url: '/canoe/'+id,
                success : function(canoe) {
                       
                      // console.log(canoe.id+' '+ canoe.status+' '+ canoe.size+' '+ canoe.number+' '+ canoe.url);
                       getCanoe(canoe.id, canoe.status, canoe.size, canoe.number, canoe.url);
                },
                error : function() {
                    alert("Fail");
                }
            });
        }

}
function getCanoesByStatus(status){
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		url: 'canoe/findbystatus/'+status,
		success : function(canoe) {
            clearList();
			$.each(canoe, function(index, canoe) {
				getCanoe(canoe.id, canoe.status, canoe.size, canoe.number, canoe.url);
			});
		},
		error : function() {
		}
	});
}
function getCanoesBySize(size){
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		url: 'canoe/findbysize/'+size,
		success : function(canoe) {
            clearList();
			$.each(canoe, function(index, canoe) {
				getCanoe(canoe.id, canoe.status, canoe.size, canoe.number, canoe.url);
			});
		},
		error : function() {
		}
	});
}

