<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
  <style>
 
  .hero_area {
  position: relative;
  min-height: 100vh;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
      -ms-flex-direction: column;
          flex-direction: column;
}

.hero_area .hero-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}

.hero_area .hero-bg img {
  width: 100%;
  height: 100%;
  -o-object-fit: cover;
     object-fit: cover;
}

.hero_area .hero-bg::before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;

}

.sub_page .hero_area {
  min-height: auto;
}

.sub_page .hero_area .hero_bg_box {
  display: none;
}

.header_section {
  padding: 15px 0;
}

.header_section .container-fluid {
  padding-right: 25px;
  padding-left: 25px;
}

.navbar-brand {
  font-family: 'Dancing Script', cursive;
}

.navbar-brand span {
  font-weight: bold;
  font-size: 32px;
  color: #ffffff;
}

.custom_nav-container {
  padding: 0;
}

.custom_nav-container .navbar-nav {
  margin-left: auto;
}

.custom_nav-container .navbar-nav .nav-item .nav-link {
  padding: 5px 20px;
  color: #ffffff;
  text-align: center;
  text-transform: uppercase;
  -webkit-transition: all 0.3s;
  transition: all 0.3s;
}

.custom_nav-container .navbar-nav .nav-item .nav-link svg {
  width: 17px;
  height: auto;
  fill: #ffffff;
  margin-bottom: 2px;
}

.custom_nav-container .navbar-nav .nav-item .nav-link:hover {
  color: #81b214;
}

.custom_nav-container .navbar-nav .nav-item .nav-link:hover svg {
  fill: #81b214;
}

.custom_nav-container .navbar-nav .nav-item.active .nav-link {
  color: #ffffff;
  background-color: #81b214;
}

.custom_nav-container .nav_search-btn {
  width: 35px;
  height: 35px;
  padding: 0;
  border: none;
  color: #ffffff;
}

.custom_nav-container .nav_search-btn:hover {
  color: #81b214;
}

.custom_nav-container .navbar-toggler {
  outline: none;
}

.custom_nav-container .navbar-toggler {
  padding: 0;
  width: 37px;
  height: 42px;
  -webkit-transition: all 0.3s;
  transition: all 0.3s;
}

.custom_nav-container .navbar-toggler span {
  display: block;
  width: 35px;
  height: 4px;
  background-color: #ffffff;
  margin: 7px 0;
  -webkit-transition: all 0.3s;
  transition: all 0.3s;
  position: relative;
  border-radius: 5px;
  transition: all 0.3s;
}

.custom_nav-container .navbar-toggler span::before, .custom_nav-container .navbar-toggler span::after {
  content: "";
  position: absolute;
  left: 0;
  height: 100%;
  width: 100%;
  background-color: #ffffff;
  top: -10px;
  border-radius: 5px;
  -webkit-transition: all 0.3s;
  transition: all 0.3s;
}

.custom_nav-container .navbar-toggler span::after {
  top: 10px;
}

.custom_nav-container .navbar-toggler[aria-expanded="true"] {
  -webkit-transform: rotate(360deg);
          transform: rotate(360deg);
}

.custom_nav-container .navbar-toggler[aria-expanded="true"] span {
  -webkit-transform: rotate(45deg);
          transform: rotate(45deg);
}

.custom_nav-container .navbar-toggler[aria-expanded="true"] span::before, .custom_nav-container .navbar-toggler[aria-expanded="true"] span::after {
  -webkit-transform: rotate(90deg);
          transform: rotate(90deg);
  top: 0;
}
  
  
  </style>
 
   
  <title> admin </title>


</head>
<body style="background-color:rgba(32, 106, 93, 0.6)" >

    
  <div class="hero_area">
    <div class="hero-bg">
     <img src="images/hero-bg.jpg" alt="">
    </div>
    <!-- header section strats -->
    <header class="header_section">
      <div class="container">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
          <a class="navbar-brand" href="index.html">
            <span>
            <i> Smart Farming</i>
            </span>
          </a>

          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class=""> </span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav  ">
              <li class="nav-item ">
                <a class="nav-link" href="/adminhome">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/addtechnologyform"> Add Technologies</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/viewtechnology">View Technology</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/addstockform">Add Stock</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="/viewstock">View Stock</a>
              </li>
               
               <li class="nav-item">
                <a class="nav-link" href="/home">Logout</a>
              </li>
              
              
               <div class="form-inline">
                <a style="color:white;text-decoration:none;"class="nav-link" href="/schemeform">SCHEMES</a>
              </div>
              

            </ul>
          </div>
        </nav>
         </div>
    </header>
        <!-- slider section -->
    <section class="slider_section ">
      <div id="customCarousel1" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container ">
              <div class="row">
                <div class="col-md-7 col-lg-6 mx-auto ">
                  <div class="detail-box">
                    <h1>
                      View Stock
                    </h1>
                    <p>
 
                    </p>
                   
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item ">
            <div class="container ">
              <div class="row">
                <div class="col-md-7 col-lg-6 mx-auto ">
                  <div class="detail-box">
                    <h1>
                      View Stock
                    </h1>
                    <p>
                    

                     
                    </p>
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="container ">
              <div class="row">
                <div class="col-md-7 col-lg-6 mx-auto ">
                  <div class="detail-box">
                    <h1>
                     View Stock
                    </h1>
                    <p>
                    
                    </p>
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="container">
          <ol class="carousel-indicators">
            <li data-target="#customCarousel1" data-slide-to="0" class="active"></li>
            <li data-target="#customCarousel1" data-slide-to="1"></li>
            <li data-target="#customCarousel1" data-slide-to="2"></li>
          </ol>
        </div>
      </div>

    </section>
    <!-- end slider section -->
    </div>
    
    
    
    
    
    
    
    
    
    
    
 <table align=center border=4>
<tr >
<td>ID</td>
<td>IMAGE</td>
<td>NAME</td>
<td>QUANTITY</td>
<td>PRICE</td>
<td>delete</td>
<td>update</td>
</tr>
 <c:forEach var="it" items="${s}">
<tr bordercolor="white">
<td>${it.sid}</td>
<td><img name="simage1" src="/displaystockimg/${it.sid}" width="150" height="100" ></td>
<td>${it.name}</td>
<td>${it.quantity}</td>
<td>${it.price}</td>
<td> <a  href="/deletestock/${it.sid}">delete</a> </td>
<td> <a  href="/updateform/${it.sid}">update</a> </td>
</tr>
</c:forEach>
</table>
     
    <!-- end header section -->

  



  <!-- jQery -->
  <script src="js/jquery-3.4.1.min.js"></script>
  <!-- popper js -->
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
  </script>
  <!-- bootstrap js -->
  <script src="js/bootstrap.js"></script>
  <!-- owl slider -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
  </script>
  <!-- custom js -->
  <script src="js/custom.js"></script>
  <!-- Google Map -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCh39n5U-4IoWpsVGUHWdqB6puEkhRLdmI&callback=myMap">
  </script>
  <!-- End Google Map -->

</body>

</html>