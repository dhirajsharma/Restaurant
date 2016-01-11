(function() {
    'use strict';

    var app = angular.module('egenRestaurant');
    app.controller('AdminController', ['$scope', 'registrationService', 'loginService', '$http', '$rootScope', '$interval', function($scope, regService, loginService, $http, $rootScope, $interval) {
        var adminCtrl = this;
        adminCtrl.regService = regService;
        adminCtrl.loginService = loginService;

        adminCtrl.viewRegistration = function(regisId) {
            regService.prepForBroadcast(regisId);

        };

        adminCtrl.showLists = function() {
            $("#adminTabs").removeClass('ng-hide').addClass('ng-show');
            $('.admin-view').show();
            adminCtrl.getAllReservations();

            $interval( function(){ adminCtrl.getAllReservations(); }, 10000);    

            adminCtrl.getAllCustomers();
        }

        $scope.$on('handleBroadcast', function() {
            adminCtrl.registrationId = regService.registrationId;
        });

        $scope.$on('handleLoginBroadcast', function() {
            adminCtrl.showLists();
        });

        adminCtrl.getAllReservations = function() {
            $http.get($rootScope.apiServer + 'reservation').then(function(response) {
                adminCtrl.registrationList = response.data;
            }, function(response) {
                console.log('Error : ' + response);
            });
        };

        adminCtrl.getAllCustomers = function() {
            $http.get($rootScope.apiServer + 'customer').then(function(response) {
                adminCtrl.customerList = response.data;
            }, function(response) {
                console.log('Error : ' + response);
            });
        };

    }]);



}());
