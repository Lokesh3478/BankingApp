<!-- File: src/main/webapp/WEB-INF/views/adminLogin.jsp -->

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/loginstyle.css">
  <title>Admin Login</title>
</head>
<body>
<div class="login-container">
  <div class="login-form">
    <h2>Admin Login</h2>
    <form action="adminLogin" method="post">
      <label for="userId">Admin ID:</label>
      <input type="text" id="userId" name="userId" required><br><br>

      <label for="adminCode">Admin Code:</label>
      <input type="text" id="adminCode" name="adminCode" required><br><br> <!-- New Admin Code Field -->

      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required><br><br>

      <button type="submit">Login</button>
    </form>
  </div>
</div>
</body>
</html>
