<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Enter OTP</title>
    <script>
        function toggleMpinForm(isOtpValid) {
            var mpinForm = document.getElementById("mpin-form");
            if (isOtpValid) {
                mpinForm.style.display = "block";
            } else {
                mpinForm.style.display = "none";
            }
        }
    </script>
</head>
<div>${otpResult}</div>
<body onload="toggleMpinForm(${otpResult})">
<h2>OTP Verification</h2>
<p>An OTP has been sent to your registered number.</p>
<div class="otp-form">
    <form action="${pageContext.request.contextPath}/customer-dashboard/verify-otp" method="POST">
        <input type="text" name="otp" placeholder="Enter OTP" required>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <button type="submit">Verify OTP</button>
    </form>
</div>

<!-- Hidden form for entering MPIN -->
<div id="mpin-form" style="display:none;">
    <h3>Enter MPIN</h3>
    <form action="${pageContext.request.contextPath}/customer-dashboard/setMpin" method="POST">
        <input type="password" name="mpin" placeholder="Enter MPIN" required>
        <button type="submit">Set MPIN</button>
    </form>
</div>
</body>
</html>
