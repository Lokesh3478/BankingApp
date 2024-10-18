<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin-dashboard-style.css">
    <title>Dashboard Home</title>
</head>
<body>
<div class="container">
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/admin-dashboard/home">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/admin-dashboard/section2/section2Home">Section 2</a></li>
            <li><a href="${pageContext.request.contextPath}/admin-dashboard/section3/section3Home">Section 3</a></li>
            <li><a href="${pageContext.request.contextPath}/admin-dashboard/section4/section4Home">Section 4</a></li>
        </ul>
    </nav>

    <h1>Dashboard Home</h1>
    <p>Welcome to the banking system dashboard!</p>

    <div class="form-section">
        <h2>Add Account</h2>
        <a href="${pageContext.request.contextPath}/admin-dashboard/addAccount" class="button">Go to Add Account</a>
    </div>

    <div class="form-section">
        <h2>Add Branch</h2>
        <a href="${pageContext.request.contextPath}/admin-dashboard/addBranch" class="button">Go to Add Branch</a>
    </div>

    <div class="form-section">
        <h2>Add Account Type</h2>
        <a href="${pageContext.request.contextPath}/admin-dashboard/addAccountType" class="button">Go to Add Account Type</a>
    </div>
</div>
</body>
</html>
