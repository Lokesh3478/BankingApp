<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Enter OTP</title>
</head>
<body>
<h2>OTP Verification</h2>
<p>An OTP has been sent to your registered number.</p>
<form action="${pageContext.request.contextPath}/customer-dashboard/verify-otp" method="POST">
    <input type="text" name="otp" placeholder="Enter OTP" required>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <button type="submit">Verify OTP</button>
</form>
</body>
</html>
