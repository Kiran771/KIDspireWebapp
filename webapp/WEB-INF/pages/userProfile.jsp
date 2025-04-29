<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet" type="text/css"
href="${pageContext.request.contextPath}/css/userProfile.css">

</head>
<body>
	<jsp:include page="headerUser.jsp" />
	<div class="profile-container">
        <div class="cover-image"></div>
        <div class="profile-info">
            <div class="profile-picture">
                <img src="${pageContext.request.contextPath}/resources/profile.jpg" alt="Profile Picture" style="width: 100%; height: 100%; border-radius: 50%;">
            </div>
            <div class="profile-details">
                <h1>Riya Shah</h1>
                <p>riya.shah@gmail.com</p>
            </div>
            <button class="view-profile-btn">View Profile</button>
        </div>
        
          <div class="details-container">
            
            <div class="change-section">
                <h2>Change Password</h2>
                
                    <label for="current-password">Current Password</label>
                    <input type="password" id="current-password" name="current-password" required>
                    
                    <label for="new-password">New Password</label>
                    <input type="password" id="new-password" name="new-password" required>
                    
                    <label for="confirm-password">Confirm New Password</label>
                    <input type="password" id="confirm-password" name="confirm-password" required>
                    
                    <button type="submit" class="save-btn">Save Changes</button>
            </div>

            <div class="change-section">
                <h2>Other Info Changes</h2>
               
                    <label for="full-name">Full Name</label>
                    <input type="text" id="full-name" name="full-name" value="Riya Shah" required>
                    
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" value="riya.shah@gmail.com" required>
                    
                    <label for="phone">Phone Number</label>
                    <input type="tel" id="phone" name="phone" placeholder="Enter your phone number">
                    
                    <button type="submit" class="save-btn">Save Changes</button>
               
            </div>
        </div>
    </div>

</body>
</html>