<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Banking Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/customer-dashboard-style.css">
</head>
<body>
<div class="alert-messages">
    <%@include file="components/form-result.jsp"%>
</div>
<div class="sidebar">
    <h2>Navigation</h2>
    <a href="#" class="nav-link" onclick="showSection('all-pages')">All Pages</a>
    <a href="#" class="nav-link" onclick="showSection('my-banking')">My Banking</a>
    <a href="#" class="nav-link" onclick="showSection('profile')">Profile</a>
</div>

<main>
    <!-- All Pages Section -->
    <section class="section" id="all-pages">
        <h2>All Pages</h2>
        <a href="#" class="button">View Balance</a>
        <a href="#" class="button">History</a>
        <a href="#" class="button">Send Money</a>
        <a href="${pageContext.request.contextPath}/addAccountForm" class="button">Add Bank A/c or Credit Card</a>
    </section>

    <!-- My Banking Section -->
    <section class="section" id="my-banking">
        <h2>My Banking</h2>
        <a href="#" class="button">Send Money</a>
        <a href="#" class="button">Manage Accounts</a>
        <a href="#" class="button">Transaction History</a>
        <a href="#" class="button">Pay to Mobile Number</a>
        <a href="#" class="button">ePassbook</a>
    </section>

    <!-- Profile Section -->
    <section class="section" id="profile">
        <h2>Profile</h2>
        <a href="#" class="button">De-Register</a>
        <a href="#" class="button">View Balance/Statement</a>
        <a href="#" class="button">Change MPIN</a>
        <a href="#" class="button">Forgot MPIN</a>
        <a href="#" class="button">Change Passcode</a>
        <a href="#" class="button">My Accounts</a>
        <a href="#" class="button">Logout</a>
    </section>
</main>
<script>
    function showSection(sectionId) {
        const sections = document.querySelectorAll('.section');
        sections.forEach(section => section.classList.remove('active'));
        document.getElementById(sectionId).classList.add('active');
    }
    showSection('all-pages');

    function openModal() {
        document.getElementById('add-account-form').style.display = 'flex';
    }

    function closeModal() {
        document.getElementById('add-account-form').style.display = 'none';
    }

    function verifyOtp() {
        alert('OTP verification triggered!');
    }
</script>
</body>
</html>
