<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 15-10-2024
  Time: 06:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="pop-up-style.css">
    <title>pop-up</title>
</head>
<body>
<!-- pop-up.jsp -->
<div id="successModal" class="modal">
    <div class="modal-content">
        <p id="modalMessage">Account Added Successfully</p> <!-- Success message placeholder -->
    </div>
</div>

<script>
    // Modal functionality
    var modal = document.getElementById("successModal");
    var closeBtn = document.getElementsByClassName("close")[0];

</script>

</body>
</html>
