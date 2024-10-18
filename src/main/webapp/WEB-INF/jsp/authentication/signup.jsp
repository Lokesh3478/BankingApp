<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}static/signup-style.css">
</head>
<body>
    <h2>Sign Up</h2>

    <form action="signup" method="post">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId" required />
        <c:if test="${not empty userId}">
            <div class="error">${userId}</div>
        </c:if>
        <br/><br/>

        <label for="userName">User Name:</label>
        <input type="text" id="userName" name="userName" required /><br/><br/>

        <label for="mailId">Mail ID:</label>
        <input type="email" id="mailId" name="mailId" required />
        <c:if test="${not empty mailId}">
            <div class="error">${mailId}</div>
        </c:if>
        <br/><br/>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required /><br/><br/>

        <label for="mobileNumber">Mobile Number:</label>
        <input type="text" id="mobileNumber" name="mobileNumber" required />
        <c:if test="${not empty mobileNumber}">
            <div class="error">${mobileNumber}</div>
        </c:if>
        <br/><br/>
        
        <label for="dob">DateOfBirth:</label>
        <input type="date" id="dob" name="dob" required/><br/><br/>

        <input type="submit" value="Sign Up" />
        
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login here</a>.</p>
    </form>
</body>
</html>
