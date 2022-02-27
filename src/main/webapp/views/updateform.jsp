<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=number]{
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  margin-left:400px;
  margin-right:400px;
}
</style>
<body style="background-color:rgba(32, 106, 93, 0.6)">

<h1 align="center">Update Stock</h1>
<div>
  <form method="post" action="/updatestock">
    <label for="fname"></label>
    <input type="hidden" name="sid" value="${sid}">

    <label for="lname"></label>
    <input type="text" id="lname" name="price" placeholder="Enter Price" required>

 <label for="lname"></label>
    <input type="number" id="lname" name="quantity" placeholder="Enter Quantity" required>


   
  
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>


