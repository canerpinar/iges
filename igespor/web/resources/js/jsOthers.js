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
    

    
    $("#hareket").animate({

				marginLeft:"300px"

			},500).animate({

				marginTop:"100px",

				width:"200px"

			},1000);

			

    
});
