(function() {
    'use strict';

    angular
        .module('egenRestaurant', [])
        .controller('MainController', MainController)
        .factory('registrationService', function($rootScope) {
            var registrationService = {};

            registrationService.registrationId = '';

            registrationService.prepForBroadcast = function(regisId) {
                this.registrationId = regisId;
                this.broadcastItem();
            };

            registrationService.broadcastItem = function() {
                $rootScope.$broadcast('handleBroadcast');
            };

            return registrationService;
        })
        .factory('loginService', function($rootScope) {
            var loginService = {};

            //loginService.isDisplay = '';

            loginService.prepForLoginBroadcast = function() {
                //this.isDisplay = status;
                this.broadcastLoginItem();
            };

            loginService.broadcastLoginItem = function() {
                $rootScope.$broadcast('handleLoginBroadcast');
            };

            return loginService;
        });


    function MainController($http, $rootScope) {
        $rootScope.apiServer = 'http://192.168.0.20:8080/RestaurantSystem/api/v1/';
        $rootScope.loginStatus = false;
        var mainCtrl = this;

        mainCtrl.showCloud = function() {
            $(".booking-details").modal("show");
             $(".booking-details").on('shown.bs.modal', function () {
                var nowDate = new Date();
                var todayDate = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
                $('.input-group.date').datepicker({
                    clearBtn: true,
                    autoclose: true,
                    todayHighlight: true,
                    toggleActive: true,
                    startDate: todayDate
                });

                $('.input-daterange').datepicker({
                    clearBtn: true,
                    autoclose: true,
                    todayHighlight: true,
                    toggleActive: true,
                    startDate: todayDate
                });

                $('.clockpicker').clockpicker({
                    placement: 'top',
                    align: 'left'
                });
            });
        };

        mainCtrl.showLoginModal = function() {
            $(".sign-in-modal").modal("show");
        };

        mainCtrl.registerSignOut = function() {
            $rootScope.loginStatus = false;
            $('.home-view').show();
            $(".admin-view").hide();
        }

        mainCtrl.loadCarousel = function() {
            var request = $http.get('../images').then(handleSuccess, handleError);
        };

        function handleSuccess(response) {
            var folder = "../images/";
            var count = 0;
            var eleLi = "";
            var imgEle = "";
            $(response.data).find("a").attr("href", function(i, val) {
                if (val.match(/\.jpg|\.png|\.gif|\.PNG|\.JPG|\.jpeg|\.JPEG/)) {
                    count++;
                    imgEle += "<div class='item'><img class='carousel-img' src='" + folder + val + "'><div class='carousel-caption'></div></div>";
                }
            });

            for (var i = 0; i < count; i++) {
                eleLi += '<li data-target="#carousel-example-generic" data-slide-to="' + i + '"></li>';
            }
            $(".carousel-indicators").html(eleLi);
            $(".carousel-inner").html(imgEle);

            var indEle = $(".carousel-indicators").find('li');
            $(indEle[0]).addClass("active");

            indEle = $(".carousel-inner").find('.item');
            $(indEle[0]).addClass("active");
        }

        function handleError(response) {
            console.log("Error : " + response.data);
        }
    }

})();
