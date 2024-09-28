<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/src/main/webapp/static/loginstyle.css">
    <title>Stellar Hub</title>
   
</head>
<body>
    <div class="login-container">
        <div class="login-form">
            <h2>Login</h2>
            <form id="loginForm" action="/login" method="post">
                <div class="form-group">
                    <label for="userId">UserID</label>
                    <input type="text" id="userId" name="userId" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" class="btn">Login</button>
            </form>
        </div>
    </div>
</body>
</html>
