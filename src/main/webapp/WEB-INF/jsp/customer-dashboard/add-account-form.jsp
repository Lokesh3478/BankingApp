<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 17-10-2024
  Time: 09:14
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Bank Account or Credit Card</title>
</head>
<body>
<div id="add-account-form" class="modal">
    <div class="add-account-form">
        <h2>Add Bank Account or Credit Card</h2>
        <form action="${pageContext.request.contextPath}/submitDetails" method="POST">
            <label>
                <input type="radio" name="identifier" value="mobile" checked> Mobile Number
            </label>
            <label>
                <input type="radio" name="identifier" value="aadhaar"> Aadhaar Number
            </label>
            <br><br>

            <input type="text" id="inputField" name="mobileNumber" placeholder="Enter your mobile number" required>
            <c:if test="${not empty mobileNumber}">
                <div class ="error">${mobileNumber}</div>
            </c:if>
            <c:if test="${not empty aadhaarNumber}">
                <div class ="error">${aadhaarNumber}</div>
            </c:if>
            <br><br>

            <button type="submit">Submit</button>
        </form>

        <button onclick="/addAccount">Close</button>
    </div>
</div>

<script>
    // Dynamically change the input field based on the selected option
    document.addEventListener('DOMContentLoaded', () => {
        const radioButtons = document.querySelectorAll('input[name="identifier"]');
        const inputField = document.getElementById('inputField');

        radioButtons.forEach(radio => {
            radio.addEventListener('change', () => {
                inputField.value = ''; // Clear input field

                if (radio.value === 'mobile') {
                    inputField.placeholder = 'Enter your mobile number';
                    inputField.name = 'mobileNumber'; // Set name to mobileNumber
                    inputField.pattern = '[0-9]{10}';
                    inputField.title = 'Please enter a valid 10-digit mobile number';
                } else if (radio.value === 'aadhaar') {
                    inputField.placeholder = 'Enter your Aadhaar number';
                    inputField.name = 'aadhaarNumber'; // Set name to aadhaarNumber
                    inputField.pattern = '[0-9]{12}';
                    inputField.title = 'Please enter a valid 12-digit Aadhaar number';
                }
            });
        });
    });

</script>
</body>
</html>
