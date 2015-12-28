"use strict"
$(document).keypress(function(e) {
  if(e.which == 13) {
    $("#start").trigger("click");
  }
});

var isCurrentStatus = "check";
$(document).ready(function(){
    var bookingDetails;

    var folder = "images/";
    var count = 0;
    var eleLi = "";
    var imgEle = "";
    $.ajax({
        url : folder,
        success: function (data) {
            console.log("blah");
            $(data).find("a").attr("href", function (i, val) {
                if( val.match(/\.jpg|\.png|\.gif|\.PNG|\.JPG|\.jpeg|\.JPEG/)) {
                    count++;
                    imgEle += "<div class='item'><img class='carousel-img' src='"+ folder + val +"'><div class='carousel-caption'></div></div>";
                }
            });
            //console.log(data);

            for(var i = 0; i < count; i++){
                eleLi += '<li data-target="#carousel-example-generic" data-slide-to="'+i+'"></li>';
            }
            $(".carousel-indicators").html(eleLi);
            $(".carousel-inner").html(imgEle);

            var indEle = $(".carousel-indicators").find('li');
            $(indEle[0]).addClass("active");

            indEle = $(".carousel-inner").find('.item');
            $(indEle[0]).addClass("active");
        }
    });

    $(".party-type-radio").change(function(){
        if($(this).attr("value") === 'multi'){
            $(".multiple-date").show();
            $(".single-date").hide();
        }else{
            $(".multiple-date").hide();
            $(".single-date").show();
        }
    });

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

    $("#avail").click(function(){
        console.log(isCurrentStatus);
        if(isCurrentStatus === "next"){
            $("#register-here").hide();
            $("#contact-details").show();
            $(".btn-back").show();
        }else{
          isCurrentStatus = checkAvailability(this);  
        }
    });

    $(".btn-back").click(function(){
        $("#register-here").show();
        $("#contact-details").hide();
        $(".btn-back").hide();
    });
    $('#booking-modal').on('hidden.bs.modal', function () {
        $("#register-here").show();
        $("#contact-details").hide();
        $(".btn-back").hide();
    });

    $("#signin").click(function(){
        $('.sign-in-modal').modal('show');
    });

    $(".btn-search").click(function(){
        var bookingNum = '12345';
        getBookingDetails(bookingNum, fillForm);

    });
});

function getBookingDetails(bookingNum, callBack){
    // have ajax to get booking details

    var details = {
        partyType : "Single",
        occasion : "party name",
        date : "10/12/2015",
        startTime: "1 PM",
        endTime: "2 PM",
        partySize: 5,
        fname: "Dhiraj",
        lname: "Sharma",
        pNumber : "1234567890",
        email: "gadha@dhiraj.com",
        address : "1100 W Corral Ave #154",
        additionDeatils : "xyz"

    }
    callBack(details);
}

function fillForm(formInfo){
    window.location = "http://localhost:63342/Restaurant_System/search.html";
    //console.log(formInfo);
}

function checkAvailability(element){
    if($(element).attr("slot-available") === "true"){
            $(element).text("Next");
            isCurrentStatus = "next";
        }else{
        var resultObj = {
            data :[{
                date: "12/25/2015",
                time: "1-2 PM"
            },{
                date: "12/25/2015",
                time: "3-4 PM"
            },{
                date: "12/26/2015",
                time: "11-12 AM"
            },{
                date: "12/26/2015",
                time: "12-1 AM"
            }]
        }

        var ele = "";
        $.each(resultObj.data, function(index, val){
            ele += "<div>"+val.date+" : "+ val.time +"</div>"
        });
        $(".result-data").html(ele);
        $(".show-result").show();
        }

        // with ajax
        /*
            var resultList = result.data
            if(resultList && resultList.length == 0){
                change btn text to "next"
            }else{
                iterator on objto display other available slots
            }

        */
        return isCurrentStatus;
}