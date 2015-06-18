$(document).ready(function () {
	
	
	
	
	document.getElementById("myForm").reset();

		var info = get("info");
		
		if(info){
			
			$("#myModal").modal({show: true}).modal({backdrop: "static"});
			
			$(".modal-body").find("p").text(info);
			
			var i = 1;
	        setInterval(function () {

	            if(i == 0) {

	                $("#myModal").modal('hide');
	            }
	            i--;
	        }, 25000);
			
		}
	
		//kullancı email i alındı
        var userEmail = getCookie("email");

        
        //ana path alındı
        var rootUrl = getAbsolutePath();
        
        
        //json ın çekileceği adres belirlendi
        var url = rootUrl + 'rest/getPerson/' +userEmail.replace(/"/g, "");
        
        var selectUrl = rootUrl+'rest/getDepProvider/';
        
        var getYearUrl = rootUrl+'rest/getYearProvider/';
        
        $('#selectFakulte button').on('click',function(){

            if(confirm('Bütün bilgileriniz değiştirilecek emin misiniz')){
            	
            	var year = $('#selectFakulte select:last').val();

                var dep = $('#selectFakulte select:nth-child(2)').val();

                var fac = $('#selectFakulte select:first').val();

                $("td").has("input").find("input").val('');

                $.ajax({
                    url:rootUrl+'rest/getCourseProvider/'+year+"/"+dep+"/"+fac,
                    dataType:'json',
                    success: function(json){

                        var m = 1;

                        $.each(json,function(key,value){

                            var termNo = value.courseTerm;

                            var k =0;

                            if($("section[id='donem"+ termNo +"']").find("table tbody tr:last td:nth-child(2) input").val() != 0){

                                $("section[id='donem"+ termNo +"']").find("a[id^=addRow]").trigger("click");

                            }

                            if($("#donem"+termNo).length==0){

                                var maxDonem = parseInt($("nav ul li").eq(-3).text());

                                while(maxDonem<termNo){

                                    $("nav ul li:last").find("button").trigger("click");

                                    maxDonem++;

                                }

                            }

                            $("section[id='donem"+ termNo +"']").find("tbody tr").each(function(){

                                $(this).find("td").each(function(){

                                    console.log("td lere bakiliyor");

                                    if(k==0){

                                        if($(this).has("input").find("input").val() == 0) {

                                        	var deger = value.courseCode;

                                            if(deger.search('<td>')!=-1){
                                                
                                                deger="";
                                                
                                            }

                                            $(this).has("input").find("input").val(deger);


                                        }else{

                                            m=0;

                                            return false;

                                        }


                                    }else if(k==1){

                                        if($(this).has("input").find("input").val() == 0) {

                                            $(this).has("input").find("input").val(value.courseName);
                                            console.log("desp girildi");

                                        }else{

                                            m=0;

                                            return false;

                                        }

                                    }else if(k==3){

                                        if($(this).has("input").find("input").val() == 0) {

                                            $(this).has("input").find("input").val(value.courseCredit);

                                            console.log("kredi girildi");

                                        }else{

                                            m=0;

                                            return false;

                                        }

                                    }

                                    k++;


                                });

                                k=0;

                                if(m == 1){

                                    return false;

                                }

                                m=1;

                            });

                        });

                    }
                });
                
                setTimeout(function(){
            		
                	$('table tbody tr td:nth-child(3) select').val('null');
               
                	$('table tbody tr td:last-child input').trigger('focusout');
                	
                    updateTable();

                }, 1500);
                

            }
            
          

            
            

        });
        
        $("#selectFakulte select").first().on('change',function(){

        	$('#selectFakulte select:nth-child(3)').empty();

            $('#selectFakulte select:nth-child(2)').empty();
            
            var firstVal = $(this).val();
            
            console.log(firstVal);

            $.ajax({

                url:selectUrl+firstVal,
                dataType: 'json',
                success: function(json){

                	$('#selectFakulte select:nth-child(2)').append('<option>seçiniz</option>');
                
                    $.each(json,function(key,value){

                        var bolumAdi = value.dep_name;

                        $('#selectFakulte select:nth-child(2)').append('<option value="'+bolumAdi+'">'+bolumAdi+'</option>');

                        console.log($('#selectFakulte select').last()[0]);

                        console.log(value.dep_name);

                        /*$.each(value.dep_name,function(key,value){

                            console.log(key);

                        });*/

                    });

                }

            });
            
            updateTable();

        });
        
        
        $('#selectFakulte select:nth-child(2)').on('change',function(){

        	$('#selectFakulte select:nth-child(3)').empty();
        	
        	var firstVal = $(this).val();

            var years = new Array();

            var yearsName = new Array();

            $.ajax({
                url:getYearUrl+firstVal,
                dataType:'json',
                success: function(json){

                	$('#selectFakulte select:nth-child(3)').append('<option>seçiniz</option>');

                    var  i =0;

                    $.each(json,function(key,value){

                        var year = value.year;

                        years[i]=year;

                        i++;

                    });

                    var controlZero= 0

                    for(var i=0;i<years.length;i++){

                        yearsName[i] = parseInt(years[i].substring(0,4));

                        if(yearsName[i] != 0){

                            yearsName[i] = yearsName[i]-1;
                        }else{
                            controlZero=1;
                        }

                    }

                    if(controlZero==1){

                        yearsName[0]=yearsName[1];

                    }

                    for(var i=0;i<yearsName.length;i++){


                        if(i==0){

                            yearsName[i] = yearsName[i].toString()+" öncesi";

                        }else if(i!=yearsName.length-1){

                            yearsName[i] = yearsName[i].toString() +" - "+(yearsName[i+1]).toString();

                        }else{

                            yearsName[i] = yearsName[i].toString() + " sonrasi"

                        }


                    }


                    for(var i=0;i<yearsName.length;i++){

                        $('#selectFakulte select:nth-child(3)').append('<option value="'+years[i]+'">'+yearsName[i]+'</option>');

                    }

                    for(var i=0;i<years.length;i++){

                        console.log(years[i]);

                    }



                }
            });
            
            updateTable();

        });
        
        

    $.ajax({
            url: url.replace('"',''),
            dataType: 'json',
            success: function(json) {

                var m= 1;

                //json okuma bölümü

                $.each(json.courses,function(key,value){

                    var termNo = value.term;

                    var k = 0;

                    console.log("course a bakiliyor");


                    //otomatik dönem eklenmesi

                    if($("#donem"+termNo).length==0){

                        var maxDonem = parseInt($("nav ul li").eq(-3).text());

                        while(maxDonem<termNo){

                            $("nav ul li:last").find("button").trigger("click");

                            maxDonem++;

                        }

                    }


                    if($("section[id='donem"+ termNo +"']").find("table tbody tr:last td:last input").val() != 0){

                        $("section[id='donem"+ termNo +"']").find("a[id^=addRow]").trigger("click");

                    }
                  
                    $("section[id='donem"+ termNo +"']").find("tbody tr").each(function(){                 	 
                    	 
                        console.log(this);

                        $(this).find("td").each(function(){

                            console.log("td lere bakiliyor");

                            if(k==0){

                                if($(this).has("input").find("input").val() == 0) {

                                    $(this).has("input").find("input").val(value.courseCode);
                                    
                                    console.log("code girildi");

                                }else{

                                    m=0;

                                    return false;

                                }


                            }else if(k==1){

                                if($(this).has("input").find("input").val() == 0) {

                                    $(this).has("input").find("input").val(value.courseDescription);
                                    
                                    console.log("desp girildi");

                                }else{

                                    m=0;

                                    return false;

                                }

                            }else if(k==2){

                                $(this).has("select").find("select").val(value.courseGrade);

                            }else if(k==3){

                                if($(this).has("input").find("input").val() == 0) {

                                    $(this).has("input").find("input").val(value.credit);
                                    
                                    console.log("kredi girildi");

                                }else{

                                    m=0;

                                    return false;

                                }

                            }

                            k++;


                        });

                        k=0;

                        if(m == 1){

                            return false;

                        }

                        m=1;

                    });


                    updateTable();

                });
                
                updateTable();
            }


        });

    //insertion of section and insertion of no at navbar


    $("nav ul li:last").find("button").click(function () {

        var donemSayisi = parseInt($("nav ul li").eq(-3).find("a").text()) + 1;

        $("#collapseElements ul li").last().prev().before('<li class="page-scroll"><a href="#donem' + donemSayisi + '">' + donemSayisi + '</a></li>');

        if (donemSayisi % 2 == 1) {

        	$('section').last().after('<section id="donem' + donemSayisi + '" class="tempRow1"><div class="container"><div class="row">' +
                    '<div id="planTable' + donemSayisi + '" class="col-md-9"><div class="panel-heading text-center"> <h4>' + donemSayisi + '.DÖNEM</h4> </div><table class="table table-bordered"> <thead> <tr> <th><h4>Ders Kodu</h4></th> <th><h4>Ders Adı</h4></th> <th><h4>Ders Notu</h4></th> <th><h4>Ders Kredisi</h4></th> </tr> </thead> <tbody> <tr id="row_' + donemSayisi + '_1"> <td><input name="' + donemSayisi + '_1_1"></td> <td><input name="' + donemSayisi + '_1_2"></td> <td><select name="' + donemSayisi + '_1_3"> <option value="null">seçiniz</option><option value="4">aa</option> <option value="3.5">ba</option> <option value="3">bb</option> <option value="2.5">cb</option> <option value="2">cc</option> <option value="1.5">dc</option> <option value="1">dd</option> <option value="0">ff</option> </select></td> <td><input name="' + donemSayisi + '_1_4" value="0"></td> </tr> <tr id="row_' + donemSayisi + '_2"> <td><input name="' + donemSayisi + '_2_1"></td> <td><input name="' + donemSayisi + '_2_2"></td> <td><select name="' + donemSayisi + '_2_3"><option value="null">seçiniz</option> <option value="4">aa</option> <option value="3.5">ba</option> <option value="3">bb</option> <option value="2.5">cb</option> <option value="2">cc</option> <option value="1.5">dc</option> <option value="1">dd</option> <option value="0">ff</option> </select></td> <td><input name="' + donemSayisi + '_2_4" value="0"></td> </tr> <tr id="row_' + donemSayisi + '_3"> <td><input name="' + donemSayisi + '_3_1"></td> <td><input name="' + donemSayisi + '_3_2"></td> <td><select name="' + donemSayisi + '_3_3"><option value="null">seçiniz</option> <option value="4">aa</option> <option value="3.5">ba</option> <option value="3">bb</option> <option value="2.5">cb</option> <option value="2">cc</option> <option value="1.5">dc</option> <option value="1">dd</option> <option value="0">ff</option> </select></td> <td><input name="' + donemSayisi + '_3_4" value="0"></td> </tr> </tbody> <tfoot> <tr> <td></td> <td></td> <td><a id="removeRow' + donemSayisi + '" class="btn btn-md btn-danger">Ders Çıkar</a></td> <td><a id="addRow' + donemSayisi + '" class="btn btn-md btn-success">Ders Ekle</a></td> </tr> </tfoot> </table></div>' +
                    '</div></div></section>');


        } else {

        	$('section').last().after('<section id="donem' + donemSayisi + '" class="tempRow2"><div class="container"><div class="row">' +
                    '<div id="planTable' + donemSayisi + '" class="col-md-9"><div class="panel-heading text-center"> <h4>' + donemSayisi + '.DÖNEM</h4> </div><table class="table table-bordered"> <thead> <tr> <th><h4>Ders Kodu</h4></th> <th><h4>Ders Adı</h4></th> <th><h4>Ders Notu</h4></th> <th><h4>Ders Kredisi</h4></th> </tr> </thead> <tbody> <tr id="row_' + donemSayisi + '_1"> <td><input name="' + donemSayisi + '_1_1"></td> <td><input name="' + donemSayisi + '_1_2"></td> <td><select name="' + donemSayisi + '_1_3"><option value="null">seçiniz</option> <option value="4">aa</option> <option value="3.5">ba</option> <option value="3">bb</option> <option value="2.5">cb</option> <option value="2">cc</option> <option value="1.5">dc</option> <option value="1">dd</option> <option value="0">ff</option> </select></td> <td><input name="' + donemSayisi + '_1_4" value="0"></td> </tr> <tr id="row_' + donemSayisi + '_2"> <td><input name="' + donemSayisi + '_2_1"></td> <td><input name="' + donemSayisi + '_2_2"></td> <td><select name="' + donemSayisi + '_2_3"> <option value="null">seçiniz</option><option value="4">aa</option> <option value="3.5">ba</option> <option value="3">bb</option> <option value="2.5">cb</option> <option value="2">cc</option> <option value="1.5">dc</option> <option value="1">dd</option> <option value="0">ff</option> </select></td> <td><input name="' + donemSayisi + '_2_4" value="0"></td> </tr> <tr id="row_' + donemSayisi + '_3"> <td><input name="' + donemSayisi + '_3_1"></td> <td><input name="' + donemSayisi + '_3_2"></td> <td><select name="' + donemSayisi + '_3_3"><option value="null">seçiniz</option> <option value="4">aa</option> <option value="3.5">ba</option> <option value="3">bb</option> <option value="2.5">cb</option> <option value="2">cc</option> <option value="1.5">dc</option> <option value="1">dd</option> <option value="0">ff</option> </select></td> <td><input name="' + donemSayisi + '_3_4" value="0"></td> </tr> </tbody> <tfoot> <tr> <td></td> <td></td> <td><a id="removeRow' + donemSayisi + '" class="btn btn-md btn-danger">Ders Çıkar</a></td> <td><a id="addRow' + donemSayisi + '" class="btn btn-md btn-success">Ders Ekle</a></td> </tr> </tfoot> </table></div>' +
                    '</div></div></section>');

        }

        updateTable();

    });

    //deletion of section and deletion of no at navbar

    $("nav ul li:last").prev().find("button").click(function () {

        var lastPageNo = parseInt($(this).closest("ul").find("li").eq(-3).text());

        if (lastPageNo > 1) {

            $(this).closest("ul").find("li").eq(-3).remove();

            $("#donem" + lastPageNo).remove();

            updateTable()

        }


    });

    //insertion of a row from specific table

    $('body').on('click', "a[id^='addRow']", function () {



        var idName = $(this).attr("id");

        console.log(idName);

        var no = idName.match(/[\d\.]+/);

        console.log(no);

        var lastRowId = $(this).closest("table").find('tbody tr:last')[0].id;

        console.log(lastRowId);

        var lastRowName = $(this).closest("table").find('tbody tr:last-child td:first-child input')[0].name;

        console.log(lastRowName);

        var lastRowNo = parseInt(lastRowName.split("_",3)[1])+1;

        console.log(lastRowNo);

        $('#donem' + no + ' tbody tr').last().after("<tr id='row_" + no + "_" + lastRowNo + "'><td><input name='" + no + "_" + lastRowNo + "_1'></td><td><input name='" + no + "_" + lastRowNo + "_2'> </td><td><select name='" + no + "_" + lastRowNo + "_3'><option value='null'>seçiniz</option><option value='4'>aa</option><option value='3.5'>ba</option><option value='3'>bb</option><option value='2.5'>cb</option><option value='2'>cc</option><option value='1.5'>dc</option><option value='1'>dd</option><option value='0'>ff</option></select></td><td><input name='" + no + "_" + lastRowNo + "_4' value='0'></td></tr>");

        $(this).closest("table").load();

        updateTable();

    });

    //deletion of a row from specific table

    $('body').on('click', "a[id^='removeRow']", function () {

        console.log("remove basıldı");

        var lastRowId = $(this).closest("table").find('tbody tr:last')[0].id;

        console.log("last row id : " +lastRowId);

        var lastRowNo = parseInt(lastRowId.split("_",3)[2]);

        console.log("last row no : " +lastRowNo);

        if (lastRowNo > 1) {

            $(this).closest("table").find("tbody tr:last").remove();

            $(this).closest("table").load();

            updateTable();

        }

    });

    $("body").on('keyup', 'section table tbody tr td:last-child input', function(){
    	updateTable();
    });


    $("body").on('change', 'section table tbody tr td:nth-child(3) select', function () {
    	updateTable();
    });



    //do empty input when you focus on input has zero

    $('body').on('focusin', 'section tbody tr td:last-child input', function () {

        if ($(this).val() == 0) {

            $(this).val(null);

        }
        updateTable();

    });

    $('body').on('focusout', 'section tbody tr td:last-child input', function () {

    	if (!$(this).val()) {

            $(this).val(0);

        }

        updateTable();

    });

    $("body").on('click','#logout',function(event){

        if(!confirm("Çıkmak istediğinize emin misiniz?")){

            event.preventDefault();

        }

    });
    
    
    function updateTable() {

        var grade;

        var ffKredi = 0;

        var gecersizKredi = 0;

        var alınanToplamKredi = 0;

        var verilenKredi = 0;

        var basariPuan;

        var toplamBasariPuan = 0;

        var notOrt = 0;

        $('section').each(function () {

            $(this).find('table tbody tr td:nth-child(3)').each(function () {

                grade = $(this).find('select').val();

                //console.log("not : " +grade);

                if (!isNaN(grade)) {

                    var credit = $(this).next().find("input").val();

                    //console.log($(this).next()[0]);

                    //console.log("credit : "+credit);

                    basariPuan = credit * grade;

                    toplamBasariPuan = basariPuan + toplamBasariPuan;

                    // console.log("basari:  " +toplamBasariPuan);

                }


            });

            $('#degerTablo').find('table tbody tr:nth-child(3) td:nth-child(2)').text(toplamBasariPuan);

        });

        var kredi;

        $('section').each(function () {

            $(this).find('table tbody tr td:last-child').each(function () {

                if (!isNaN($(this).find('input').val())) {

                    kredi = parseFloat($(this).find('input').val());

                    alınanToplamKredi = alınanToplamKredi + kredi;
                }

            });

        });



        $('section').each(function () {

            $(this).find('table tbody tr td:nth-child(3)').each(function () {

                var grade = $(this).find('select').val();

                var kre = parseFloat($(this).next().find('input').val());

                //console.log("grade : " + grade);

                //console.log("kredi : " + kre);

                if (isNaN(grade)) {

                    gecersizKredi = gecersizKredi + kre;



                } else if (grade == 0) {

                    ffKredi = ffKredi + kre;
                }


                console.log(gecersizKredi);



            });

        });

        alınanToplamKredi = alınanToplamKredi-gecersizKredi;

        console.log(alınanToplamKredi);

        verilenKredi = alınanToplamKredi-ffKredi;

        $('#degerTablo tbody tr:nth-child(2) td:nth-child(2)').text(verilenKredi);

        notOrt = toplamBasariPuan/alınanToplamKredi;

        $('#degerTablo tbody tr:nth-child(4) td:nth-child(2)').text(notOrt.toFixed(2));

        $('#degerTablo').find('table tbody tr:nth-child(1) td:nth-child(2)').text(alınanToplamKredi);
    }

    function getAbsolutePath() {
        var loc = window.location;
        var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
        return loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));
    }






    function getCookie(name)
    {
      var re = new RegExp(name + "=([^;]+)");
      var value = re.exec(document.cookie);
      return (value != null) ? unescape(value[1]) : null;
    }
    
    function get(name){
        if(name=(new RegExp('[?&]'+encodeURIComponent(name)+'=([^&]*)')).exec(location.search))
            return decodeURIComponent(name[1]);
    }
});