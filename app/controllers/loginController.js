(function() {
    'use strict';

    var app = angular.module('egenRestaurant');
    app.controller('LoginController', ['$scope', 'loginService', '$http', '$rootScope', function($scope, loginService, $http, $rootScope) {
        var loginCtrl = this;
        loginCtrl.loginService = loginService;

        loginCtrl.loginObj = {
            username: "admin",
            password: "admin123"
        }

        loginCtrl.submitLogin = function() {
            var url = $rootScope.apiServer + "login/" + loginCtrl.loginObj.username + '/' + loginCtrl.loginObj.password;
            var request = $http.get(url).then(handleSuccess, handleError);


        };

        function handleSuccess(response) {
            if (response.data.status == "true") {
                $rootScope.loginStatus = true;
                $(".sign-in-modal").modal("hide");
                $(".home-view").hide();
                $(".home-view").hide();
                loginService.prepForLoginBroadcast();
            }
        };

        function handleError(response) {
            console.log(response);
        };

    }]);

}());
