<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin-dashboard-style.css">
  <title>Add Branch</title>
</head>
<body>
<div class="container">
  <h1>Add Branch Form</h1>
  <form action="addBranch" method="post">
    <label for="ifscCode">IFSC Code:</label>
    <input type="text" id="ifscCode" name="ifscCode">

    <label for="branchName">Branch Name:</label>
    <input type="text" id="branchName" name="branchName">

    <label for="branchAddress">Branch Address:</label>
    <input type="text" id="branchAddress" name="branchAddress">

    <input type="submit" value="Submit">
  </form>
</div>
</body>
</html>
