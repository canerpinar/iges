/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function mouseUp() {
   
    document.getElementById("img_serkan").style.display = "block";
}
function mouseout(){
    document.getElementById("img_serkan").style.display = "none";
}
function mouseUpYuzme() {
   
    document.getElementById("img_serkan_trans").style.display = "block";
}
function mouseoutYuzme(){
    document.getElementById("img_serkan_trans").style.display = "none";
}
$(document).ready(function (){
    //21.02.2016 çalışmıyor kayıt gerçekleştiğinde bu mesaj olacak
    var deger=$("input:hidden").attr("value");//kaydınız başarılı mesajı vermek

alert(deger);
    
    $("#hareket").animate({

				

			},500).animate({

				marginTop:"10px",

				width:"200px"

			},1000);

    $("#hareket_2").animate({

				

			},500).animate({

				marginTop:"10px",

				width:"200px"

			},1000);			

    
});
