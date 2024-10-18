<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 18-10-2024
  Time: 03:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>form-result</title>
    <link rel="stylesheet" href="components/form-result-style.css">
</head>
<body>
  <!-- Success Alert -->
  <c:if test="${not empty successAlert}">
    <div class="success-alert" id="sucess">${successAlert}</div>
  </c:if>

  <!-- Error Alert -->
  <c:if test="${not empty errorAlert}">
    <div class="error-alert" id="error">${errorAlert}</div>
  </c:if>
  <script>
    window.onload = function() {
      // Show success or error alert based on the message
      var successAlert = document.getElementById("success");
      var errorAlert = document.getElementById("error");

      // If there's a success message, show it
      if (successAlert) {
        successAlert.style.display = "block";
        setTimeout(function() {
          successAlert.style.display = "none"; // Hide after 5 seconds
        }, 5000);
      }

      // If there's an error message, show it
      if (errorAlert) {
        errorAlert.style.display = "block";
        setTimeout(function() {
          errorAlert.style.display = "none"; // Hide after 5 seconds
        }, 5000);
      }
    };
  </script>
</body>
</html>
