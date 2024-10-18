<%@page isErrorPage="true" contentType="text/html; ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/admin-dashboard-style.css">
  <title>Add Account Type</title>
</head>
<body>
<div class="container">
  <h1>Add Account Type Form</h1>
  <!-- Corrected form tag -->
  <form action="addAccountType" method="post">

    <label for="accountTypeId">Account Type ID:</label>
    <input type="text" id="accountTypeId" name="accountTypeId" required>

    <label for="accountTypeName">Account Type Name:</label>
    <input type="text" id="accountTypeName" name="accountTypeName" required>

    <label for="interestRate">Interest Rate:</label>
    <input type="text" id="interestRate" name="interestRate" required>

    <label for="minimumBalance">Minimum Balance:</label>
    <input type="text" id="minimumBalance" name="minimumBalance" required>

    <label for="overdraftLimit">Overdraft Limit:</label>
    <input type="text" id="overdraftLimit" name="overdraftLimit" required>

    <label for="withdrawalLimit">Withdrawal Limit:</label>
    <input type="text" id="withdrawalLimit" name="withdrawalLimit" required>

    <label for="depositLimit">Deposit Limit:</label>
    <input type="text" id="depositLimit" name="depositLimit" required>

    <label>Is Minor Account:</label>
    <input type="radio" id="minorAccountYes" name="isMinorAccount" value="true" required>
    <label for="minorAccountYes">Yes</label>

    <input type="radio" id="minorAccountNo" name="isMinorAccount" value="false" required>
    <label for="minorAccountNo">No</label>

    <input type="submit" value="Submit">
  </form>

</div>
</body>
</html>
