//엥귤러 모듈을 만들고 계속 쓸것이기 때문에 변수에 넣어준다. []안은 앵귤러의 특정 라이브러리(dependencies)를 넣어주는것
var memberListModule = angular.module("member-list",[]);
//member-list-controller 컨트롤러 만듦, function($scope)-> Model model 같은 느낌의 인자
memberListModule.controller("member-list-controller", function($scope, $http){
    // var memberList = [ 
    //     {"id":"1", "name":"승일", "checked":true},
    //     {"id":"2","name":"jesus", "checked":false},
    //     {"id":"3", "name":"승일", "checked":true},
    //     {"id":"4","name":"jesus", "checked":false},
    //     {"id":"5", "name":"승일", "checked":true},
    //     {"id":"6","name":"jesus", "checked":false},
    //     {"id":"7", "name":"승일", "checked":true},
    //     {"id":"8","name":"jesus", "checked":false}
    // ];
	
	var memberList = [];
	
    $http({
        method:"GET",
        url:"/MavenPrj/admin/get-member-list"
    }).then(function(response){
        $scope.list = response.data;
    });

    $scope.allCheck = false;
    $scope.list = memberList;
    $scope.delButtonClick = function(){
        
    	/*for(var i=0; i<$scope.list.length; i++){	
            if(memberList[i].checked){
                memberList.splice(i,1);
                i--;
            }
        }*/
        
        for(var i=0; i<$scope.list.length; i++){
        	if(memberList[$scope.list.length-1-i].checked)
        		$scope.list.splice(size-1-i,1);
        }
    };
    $scope.selAllCkbClick = function(){
        for(var i=0; i<$scope.list.length; i++){
            $scope.list[i].checked = $scope.allCheck;
        };
    }
    
    $scope.searchButtonClick = function(){
    	$http({
            method:"GET",
            url:"/MavenPrj/admin/get-member-list?id="+$scope.queryText
        }).then(function(response){
            $scope.list = response.data;
        });
    }
    
});
