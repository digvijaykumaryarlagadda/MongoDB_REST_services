/**
 * Created by raghu on 2/29/16.
 */
var services = angular.module("mongoapp.services", []);

var url = "http://localhost:8080/Mongo_Rest_Service_Middleware/restService/user";

services.factory('MongoRESTService', function($http) {
    return {
        create_a_task: function(username, password, callback) {

            var res = $http.get(url+"?name="+username+"&password="+password);

            res.success(function(data, status, headers, config) {
                console.log(data);
                callback(data);
            });
            res.error(function(data, status, headers, config) {
                console.log(data);
            });
        },

        read_a_task: function(user) {
            console.log(user);
            var res = $http.post(url, user);

            res.success(function(data, status, headers, config) {
                console.log(data);
            });
            res.error(function(data, status, headers, config) {
                console.log(data);
            });
        },

        update_a_task: function(username, password, callback) {

            var res = $http.get(url+"?name="+username+"&password="+password);

            res.success(function(data, status, headers, config) {
                console.log(data);
                callback(data);
            });
            res.error(function(data, status, headers, config) {
                console.log(data);
            });
        },

        delete_a_task: function(username, password, callback) {

            var res = $http.get(url+"?name="+username+"&password="+password);

            res.success(function(data, status, headers, config) {
                console.log(data);
                callback(data);
            });
            res.error(function(data, status, headers, config) {
                console.log(data);
            });
        }
    }
});