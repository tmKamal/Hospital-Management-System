
function priceToQty() {
    var qty=document.getElementById("qty").value;
    var price=document.getElementById("rprice1").value;
    var total= qty*price;
    document.getElementById("price1").innerHTML=total;

    var qty1=document.getElementById("qty1").value;
    var price=document.getElementById("rprice2").value;
    var total= qty1*price;
    document.getElementById("price2").innerHTML=total;

    var qty2=document.getElementById("qty2").value;
    var price=document.getElementById("rprice3").value;
    var total= qty2*price;
    document.getElementById("price3").innerHTML=total;


}

function priceCal() {
    var price=document.getElementById("price1").innerText;
    var price1=document.getElementById("price2").innerText;
    var price2= document.getElementById("price3").innerText;
    var priceInt=parseInt(price,10);
    var price1Int=parseInt(price1,10);
    var price2Int= parseInt(price2,10);
    var subT=price1Int+price2Int+priceInt;
    var shipping=500+subT*0.01;
    var total= subT+shipping;
    document.getElementById("sub-total").innerHTML=subT+".00";
    document.getElementById("shipping").innerHTML=shipping+".00";
    document.getElementById("totalprice").innerHTML=total+".00";

}

/*------------------------
Sign-up
--------------------------- */

function checkPasswordMatch() {
    var password = $("#newPassword").val();
    var confirmPassword = $("#confirmPassword").val();

    if (password != confirmPassword)
        $("#passwordAlert").html("Passwords do not match!");
}

$(document).ready(function () {
    $("#confirmPassword").keyup(checkPasswordMatch);
});




/*====================================================
             CONTACT US JS
 =====================================================*/

function formValidation() {
    var x = document.forms["myForm"]["fname"].value;

    var y=document.forms["myForm"]["contactName"].value;

    var z=document.forms["myForm"]["email"].value;

    var a=document.forms["myForm"]["tp"].value;

    if (x == "") {
        document.getElementById("p2").innerHTML="Name must be filled out";
        return false;
    }
    else if (y==""){
        document.getElementById("p1").innerHTML="Contact name must be filled out";
        return false;
    }

    else if (z==""){
        document.getElementById("p3").innerHTML="Email must be filled out";
        return false;
    }

    else if (a==""){
        document.getElementById("p7").innerHTML=" Phone Number must be filled out";
        return false;
    }

    else if(y!=""){
        document.getElementById("p1").innerHTML="";
        return false;
    }

}

/*-----------
About us
--------------*/
function mySlide1(){
    document.getElementById("mySlides").style.display="block";
    document.getElementById("mySlides1").style.display="none";
    document.getElementById("slides").style.display="none";
}
function mySlide2(){
    document.getElementById("mySlides").style.display="none";
    document.getElementById("mySlides1").style.display="block";
    document.getElementById("slides").style.display="none";
}
function mySlide3(){
    document.getElementById("mySlides").style.display="none";
    document.getElementById("mySlides1").style.display="none";
    document.getElementById("slides").style.display="block";

}

function scrolltop(){
    document.body.scrollTop=0;
    document.documentElement.scrollTop=0;
}

/*-----------------\
about us end
-------------------*/

/*
Index java script
 */




document.querySelector('.item-wrap-main').addEventListener('mouseenter',function () {
    document.querySelector('.product-overlay').style.display='block';

})

document.querySelector('.item-wrap-main').addEventListener('mouseleave',function () {
    document.querySelector('.product-overlay').style.display='none';
})

document.querySelector('.product-overlay').style.display='none';


/*SLIDER=========================
* ==============================*/

//selecting all images
var sliderImages=document.querySelectorAll('.slider-item');

//Selecting Arrows
var arrowLeft=document.querySelector('.arrow-left');
var arrowRight=document.querySelector('.arrow-right');

//Current Image
var currentImage=0;
var slideInterval;

//Clear All Images

function clear() {
    for (var i=0; i<sliderImages.length; i++){
        sliderImages[i].style.display='none';
    }

    clearTimeout(slideInterval);


}

function start() {
    clear();
    sliderImages[0].style.display='block';

    //automatic
    slideInterval = setInterval(nextSlide,4000);

    function nextSlide() {
        sliderImages[currentImage].style.display = 'none';
        currentImage = (currentImage+1)%sliderImages.length;
        sliderImages[currentImage].style.display='block';
    }
    //automatic End

}



start();

function leftClick(){
    //console.log('LEFT currentImage' +currentImage);
    //console.log('LEFT sliderImage' +sliderImages[currentImage]);
    sliderImages[currentImage-1].style.display='block';


    currentImage--;

    //automatic
    slideInterval = setInterval(nextSlide,4000);

    function nextSlide() {
        sliderImages[currentImage].style.display = 'none';
        currentImage = (currentImage+1)%sliderImages.length;
        sliderImages[currentImage].style.display='block';
    }
    //automatic End


}

arrowLeft.addEventListener('click',function () {
    clear();
    if(currentImage===0){
        currentImage=sliderImages.length;
    }
    leftClick();
})

function rightClick() {
    //console.log('RIGHTcurrentImage' +currentImage);
    //console.log('RIGHTsliderImage' +sliderImages[currentImage]);
    sliderImages[currentImage+1].style.display='block';
    currentImage++;

    //automatic
    slideInterval = setInterval(nextSlide,4000);

    function nextSlide() {
        sliderImages[currentImage].style.display = 'none';
        currentImage = (currentImage+1)%sliderImages.length;
        sliderImages[currentImage].style.display='block';
    }
    //automatic End
}

arrowRight.addEventListener('click', function () {
    clear();
    if (currentImage===sliderImages.length-1){
        currentImage=-1;
    }
    rightClick();
})

//Scroll top Button
var scrollbtn=document.getElementById('scroll');
window.onscroll=function () {
    'use strict';
    if(window.pageYOffset>=400){
        document.getElementById('scroll').style.display='block';
    }else {
        document.getElementById('scroll').style.display='none';
    }
}

document.querySelector('#scroll').addEventListener('click',function () {

    document.documentElement.scrollTop = 0;
    document.body.scrollTop = 0;

})



