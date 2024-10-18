<%@page contentType="text/html; ISO-8859-1" %>
<%@page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/loginstyle.css">
</head>

<body>
    <div class="login-container">
        <div class="login-form">
            <h2>Login</h2>
            <form action="login" method="post">
                <label for="userId">User ID:</label>
                <input type="text" id="userId" name="userId">
                <c:if test="${not empty userId}">
                    <div class="error">${userId}</div>
                </c:if>
                <br><br>

                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
                <c:if test="${not empty invalidPassword}">
                    <div class="error">${invalidPassword}</div>
                </c:if>
                <br><br>

                <button type="submit">Login</button>
            </form>

        </div>


        <p>Don't have an account? <a href="signup">Sign up here</a></p>
    </div>
</body>
</html>
