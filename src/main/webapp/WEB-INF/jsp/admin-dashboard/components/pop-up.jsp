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
        <span class="close">&times;</span>
        <p id="modalMessage">${modalMessage}</p> <!-- Success message placeholder -->
    </div>
</div>

<script>
    // Modal functionality
    var modal = document.getElementById("successModal");
    var closeBtn = document.getElementsByClassName("close")[0];

    // Check if modalMessage exists and show modal
    <c:if test="${not empty modalMessage}">
    modal.style.display = "block";
    </c:if>

    // Close modal on button click or outside modal click
    closeBtn.onclick = function() {
        modal.style.display = "none";
        window.location.href = window.location.href; // Reload the same page
    }

    window.onclick = function(event) {
        if (event.target === modal) {
            modal.style.display = "none";
            window.location.href = window.location.href; // Reload the same page
        }
    }
</script>

</body>
</html>
