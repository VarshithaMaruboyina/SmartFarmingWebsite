<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {box-sizing: border-box}
.mySlides1, .mySlides2 {display: none}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -22px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a grey background color */
.prev:hover, .next:hover {
  background-color: #f1f1f1;
  color: black;
}
</style>
</head>
<body style="background-color:rgba(32, 106, 93, 0.6)">
<a style="font-size:40px;color:black;text-decoration:none;"href="/buytechnologies"><< back</a>

<p></p>
<div class="slideshow-container">
  <div class="mySlides1">
    <img src="/displaystockimg1/${s.sid}" style="width:100%">
  </div>

  <div class="mySlides1">
    <img src="/displaystockimg2/${s.sid}"style="width:100%">
  </div>


  <a class="prev" onclick="plusSlides(-1, 0)">&#10094;</a>
  <a class="next" onclick="plusSlides(1, 0)">&#10095;</a>
</div>


<center>
<h1>${s.name}</h1>
<h1>${s.price }</h1>
<c:choose>
 <c:when test="${s.quantity == 0}">
    <p style="color:red">***out of stock***</p>
  </c:when>
  <c:otherwise>
 <font size="30px"> <a href="/addcart/${s.sid}" style="text-decoration:none;font-size:40px;color:white;background-color:black;padding-left:10px;padding-right:10px;padding-bottom:3px;padding-top:1px;">add to cart</a></font>
  </c:otherwise>
</c:choose>
</center>











<script>
var slideIndex = [1,1];
var slideId = ["mySlides1"]
showSlides(1, 0);
showSlides(1, 1);

function plusSlides(n, no) {
  showSlides(slideIndex[no] += n, no);
}

function showSlides(n, no) {
  var i;
  var x = document.getElementsByClassName(slideId[no]);
  if (n > x.length) {slideIndex[no] = 1}    
  if (n < 1) {slideIndex[no] = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex[no]-1].style.display = "block";  
}
</script>
</body>
</html>