(function () {
    'use strict';
 
    var app= angular.module('egenRestaurant');
    app.controller('SearchController', ['$scope','registrationService','$http','$rootScope', function ($scope, regService, $http, $rootScope) {
       var searchCtrl = this; 
       searchCtrl.searchTxt = "";
       searchCtrl.reservationId = "";

    searchCtrl.findRegistration = function(){
       $http.get($rootScope.apiServer + 'reservation/code/' + searchCtrl.searchTxt).then(function(response) {
          searchCtrl.reservationId = response.data.reservation_id;
           regService.prepForBroadcast(searchCtrl.reservationId);

        }, function(response) {
            console.log('Error : ' + response);
        });
    }  

    $scope.$on('handleBroadcast', function() {
      searchCtrl.reservationId = regService.registrationId;
    });

    }]);
 
}());
