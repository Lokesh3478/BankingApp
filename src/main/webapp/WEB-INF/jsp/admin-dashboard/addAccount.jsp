<%@page contentType="text/html; ISO-8859-1" %>
<%@page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin-dashboard-style.css">
    <title>Add Account</title>
</head>
<body>
<div class="container">
    <h1>Add Account Form</h1>
    <h2>${modalMessage}</h2>
    <form action="addAccount" method="post">
        <label for="accountNo">Account Number:</label>
        <input type="text" id="accountNo" name="accountNo">
        <c:if test="${not empty accountNo}">
            <div class="error">${accountNo}</div>
        </c:if>

        <label for="accountTypeId">Account Type ID:</label>
        <input type="text" id="accountTypeId" name="accountTypeId">
        <c:if test="${not empty accountTypeId}">
            <div class="error">${accountTypeId}</div>
        </c:if>

        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId">
        <c:if test="${not empty userId}">
            <div class="error">${userId}</div>
        </c:if>

        <label for="aadhaarNumber">Aadhar Number:</label>
        <input type="text" id="aadhaarNumber" name="aadhaarNumber">
        <c:if test="${not empty aadhaarNumber}">
            <div class="error">${aadhaarNumber}</div>
        </c:if>

        <label for="mobileNumber">Mobile Number:</label>
        <input type="text" id="mobileNumber" name="mobileNumber">
        <c:if test="${not empty mobileNumber}">
            <div class="error">${mobileNumber}</div>
        </c:if>

        <label for="ifscCode">IFSC Code:</label>
        <input type="text" id="ifscCode" name="ifscCode">
        <c:if test="${not empty ifscCode}">
            <div class="error">${ifscCode}</div>
        </c:if>

        <label for="balance">Balance:</label>
        <input type="text" id="balance" name="balance">

        <label for="dateOfCreation">Date of Creation:</label>
        <input type="date" id="dateOfCreation" name="dateOfCreation">

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
