(function() {
    'use strict';

    var app = angular.module('egenRestaurant');
    app.controller('EditRegisController', ['$scope', 'registrationService', '$http', '$rootScope', function($scope, regService, $http, $rootScope) {
        var editRegCtrl = this;
        editRegCtrl.regService = regService;
        editRegCtrl.currentRegId = "";

        $scope.$on('handleBroadcast', function() {
            editRegCtrl.currentRegId = regService.registrationId;
            editRegCtrl.getRegistrationDetails();
            $(".edit-reservations").modal('show');

        });

        editRegCtrl.getRegistrationDetails = function() {
            $http.get($rootScope.apiServer + 'reservation/' + editRegCtrl.currentRegId).then(function(response) {
                editRegCtrl.reservationObj = response.data;
            }, function(response) {
                console.log('Error : ' + response);
            });
        };

        editRegCtrl.updateRegistration = function() {
            $http.put($rootScope.apiServer + 'reservation/' + editRegCtrl.currentRegId, editRegCtrl.reservationObj).then(function(response) {
                if(response.data.status === 'success'){
                    $(".edit-reservations").modal('hide');
                }
            }, function(response) {
                console.log('Error : ' + response);
            });
        }

    }]);

}());
