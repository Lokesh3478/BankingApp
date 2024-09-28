
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
    <h2>Sign Up</h2>

    <form action="signup" method="post">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId" required /><br/><br/>

        <label for="userName">User Name:</label>
        <input type="text" id="userName" name="userName" required /><br/><br/>

        <label for="mailId">Mail ID:</label>
        <input type="email" id="mailId" name="mailId" required /><br/><br/>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required /><br/><br/>

        <label for="mobileNumber">Mobile Number:</label>
        <input type="text" id="mobileNumber" name="mobileNumber" required /><br/><br/>
        
        <label for="dateOfBirth">DateOfBirth:</label>
        <input type="date" id="dateOfBirth" name="dateOfBirth" required/><br/><br/>

        <input type="submit" value="Sign Up" />
        
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login here</a>.</p>
    </form>
</body>
</html>
