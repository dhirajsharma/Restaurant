(function() {
    'use strict';

    var app = angular.module('egenRestaurant');
    app.controller('RegistrationController', ['$scope','$rootScope','$http',  function($scope, $rootScope,$http) {
        var regCtrl = this;

        regCtrl.reservationObj = {
            "reservation_party_size": "",
            "reservation_occasion": "",
            "reservation_start_date": "",
            "reservation_end_date": "",
            "reservation_start_time": "",
            "reservation_end_time": "",
            "reservation_additional_details": "",
            "customer_firstname": "",
            "customer_lastname": "",
            "customer_phone": "",
            "customer_email": "",
            "customer_streetAddress": "",
            "customer_suiteAddress": "",
            "customer_city": "",
            "customer_state": "",
            "customer_zip": ""
        };


        regCtrl.setDays = function($event) {
            var currentEle = $event.target;
            if ($(currentEle).find('input[type="radio"]').attr("value") === 'multi') {
                $(".multiple-date").show();
                $(".single-date").hide();
            } else {
                $(".multiple-date").hide();
                $(".single-date").show();
            }
        };

        /* 
         TODO : 
         create a json 
         ajax: post to save that in the server
        */
        regCtrl.saveRegistration = function() {
           var stDate = regCtrl.reservationObj.reservation_start_date;
           var dt = new Date(stDate);  
           var finalDate = dt.getFullYear()+"-"+ (dt.getMonth()+1)+"-"+dt.getDate();
           regCtrl.reservationObj.reservation_start_date = finalDate;


           var edDate = regCtrl.reservationObj.reservation_end_date;
           var ed = new Date(edDate);  
           var finalEndDate = ed.getFullYear()+"-"+ (ed.getMonth()+1)+"-"+ed.getDate();
           regCtrl.reservationObj.reservation_end_date = finalEndDate;  

            console.log(regCtrl.reservationObj.reservation_start_time);
            console.log(regCtrl.reservationObj.reservation_end_time);
           var stTime = regCtrl.reservationObj.reservation_start_time+":00";
           var enTime = regCtrl.reservationObj.reservation_end_time+":00";

           regCtrl.reservationObj.reservation_start_time = stTime;
           regCtrl.reservationObj.reservation_end_time = enTime; 

           regCtrl.reservationObj.reservation_bookedBy = "Customer"; 


           $http.post($rootScope.apiServer + 'reservation', regCtrl.reservationObj).then(function(response) {
               console.log(response.data); 
            }, function(response) {
                console.log('Error : ' + response);
            });
            
        };

    }]);

}());
