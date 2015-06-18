/**
 * Created by oktaysahinsadoglu on 1.05.2015.
 */
$(document).ready(function(){



    var errorLoginText=get("errorlog");

    var errorRegText=get("errorreg");

    var isSuccessful = get("isSuccessful");

    if(errorLoginText){
            

        $("#signin").find("div").first().next().addClass('has-error');
        
        $("#signin").find("div").first().addClass("has-error");

        $("#myModal").modal({show: true}).modal({backdrop: "static"});

        $(".modal-body").find("p").text(errorLoginText);

        if(errorLoginText==="Database hatasi"){

            $(".modal-body").find("p").text("Database sorgusunda hata oluştu");

            $(".modal-header").find("h4").text("Database Bilgi");

        }

       var i = 1;
        setInterval(function () {

            if(i == 0) {

                $("#myModal").modal('hide');
            }
            i--;
        }, 2500);



    }

    if(errorRegText){

        $("#myModal").modal({show: true}).modal({backdrop: "static"});

        $(".modal-body").find("p").text(errorRegText);

        //$(".modal-content").css("background-color","#df691a");

        if(errorRegText==="dbhata"){

            $(".modal-body").find("p").text("Database sorgusunda hata oluştu");

            $(".modal-header").find("h4").text("Database Bilgi");

        }

        var i = 1;
        setInterval(function () {

            if(i == 0) {

                $("#myModal").modal('hide');
            }
            i--;
        }, 1000);


    }
    if(isSuccessful){

        $("#myModal").modal({show: true}).modal({backdrop: "static"});

        $(".modal-header").find("h4").text("Kayıt Bilgi");

        $(".modal-body").find("p").text(isSuccessful);

      //  $(".modal-content").css("background-color","#df691a");

        var i = 1;
        setInterval(function () {

            if(i == 0) {

                $("#myModal").modal('hide');
            }
            i--;
        }, 1000);

    }

});





function get(name){
    if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
        return decodeURIComponent(name[1]);
}