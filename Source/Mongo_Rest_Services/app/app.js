'use strict';

// Declare app level module which depends on views, and components
var app  = angular.module('mongoapp', [
    'ngRoute'
    ,'mongoapp.services'
])
app.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/Create_To_Do_List_for_household_tasks',{
        templateUrl : 'create_a_task.html',
        controller : 'createtodolistCntrl'
    }).
        when('/read_a_task',{
        templateUrl : 'read_a_task.html',
        controller : 'readtodolistCntrl'
    }).
        when('/delete_a_task',{
        templateUrl : 'delete_a_task.html',
        controller : 'deletetodolistCntrl'
    }).
    when('/update_a_task',{
        templateUrl : 'update_a_task.html',
        controller : 'updatetodolistCntrl'
    }).
    otherwise({
        redirectTo: '/register'
    });
}])
    var userData;
app.controller('createtodolistCntrl',['$scope','$location','$http', function ($scope,$location,$http) {
        var url = "https://api.mongolab.com/api/1/databases/my_rest_services/collections/firstcollection?apiKey=zcUmswACz4ryvnSECs2aHAYVktV_Voad";
        $scope.createTask = function (data) {
            //Post the data to the database to create task.

            var res = $http.post(url, data);


            res.success(function(result, status, headers, config) {
                $location.path('/Create_To_Do_List_for_household_tasks');
                console.log(result);
            });
            res.error(function(data, status, headers, config) {
                console.log(data);
                alert("There was some issue while adding the task. Please try again.")
            });


        }
    }])

    .controller('readtodolistCntrl',['$scope','$location','$http', function ($scope,$location,$http) {
        var url = "https://api.mongolab.com/api/1/databases/my_rest_services/collections/firstcollection?apiKey=zcUmswACz4ryvnSECs2aHAYVktV_Voad";
        $scope.readTask = function (data) {
            // search the database for a task.


            var res = $http.search(url, data);

            res.success(function(result, status, headers, config) {
                $location.path('/read_a_task');
                console.log(result);
            });
            res.error(function(data, status, headers, config) {
                console.log(data);
                alert("There was some issue while searching for the task. Please try again.")
            });
        }
    }])


    .controller('deletetodolistCntrl',['$scope','$location','$http', function ($scope,$location,$http) {
        var url = "https://api.mongolab.com/api/1/databases/my_rest_services/collections/firstcollection?apiKey=zcUmswACz4ryvnSECs2aHAYVktV_Voad";
        $scope.deleteTask = function (data) {
            // search and delete the database for a task.

            var res = $http.remove(url, data);
            res.success(function(result, status, headers, config) {
                $location.path('/delete_a_task');
                console.log(result);
            });
            res.error(function(data, status, headers, config) {
                console.log(data);
                alert("There was some issue while deleting this task. Please try again.")
            });
        }
    }])
    .controller('updatetodolistCntrl',['$scope','$location','$http', function ($scope,$location,$http) {
        var url = "https://api.mongolab.com/api/1/databases/my_rest_services/collections/firstcollection?apiKey=zcUmswACz4ryvnSECs2aHAYVktV_Voad";
        $scope.updateTask = function (data) {
            // search and delete the database for a task.

            var res = $http.update(url, data);
            res.success(function(result, status, headers, config) {
                $location.path('/update_a_task');
                console.log(result);
            });
            res.error(function(data, status, headers, config) {
                console.log(data);
                alert("There was some issue while updating this task. Please try again.")
            });
        }
    }]);
