<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/babysitter.css ">
</head>
<body>
	<jsp:include page="headerUser.jsp" />
	<div class="slideshow-container">
		<div class="outer-wrapper">
			<div class="adjustment">
				<img class="imageslides"
					src="${pageContext.request.contextPath}/resources/image1.jpg">
				<img class="imageslides"
					src="${pageContext.request.contextPath}/resources/image3.jpg">
				<img class="imageslides"
					src="${pageContext.request.contextPath}/resources/image4.jpg">
				<img class="imageslides"
					src="${pageContext.request.contextPath}/resources/image6.jpg">
			</div>
		</div>
	</div>
	<div class="aboutService">
		<h2>Why parents trust us</h2>
		<div class="whyTrustUs">
			<div class="reason">
				<p>✔ Background-verified Babysitters</p>
			</div>
			<div class="reason">
				<p>✔ 24/7 Customer Support</p>
			</div>
			<div class="reason">
				<p>✔ Affordable and Flexible Plans</p>
			</div>
		</div>
	</div>

	<div class="titleDesign">
		<h1>Choose your Babysitter</h1>
	</div>
	<c:if test="${empty babysitters}">
		<p class="no-results">No babysitters found for your search.</p>
	</c:if>
	<c:if test="${not empty babysitters}">
		<c:forEach var="babysitter" items="${babysitters}" varStatus="loop">
			<c:if test="${loop.index % 4 == 0}">
				<c:if test="${loop.index > 0}">
					</div>
				</c:if>
				<div class="babysitters">
			</c:if>
			<div class="profileImg">
				<c:choose>
					<c:when test="${babysitter.babysitterId == 1}">
						<img
							src="${pageContext.request.contextPath}/resources/profile1.JPG"
							alt="Profile 1">
					</c:when>
					<c:when test="${babysitter.babysitterId == 3}">
						<img
							src="${pageContext.request.contextPath}/resources/profile2.JPG"
							alt="Profile 2">
					</c:when>
					<c:when test="${babysitter.babysitterId == 4}">
						<img
							src="${pageContext.request.contextPath}/resources/profile3.JPG"
							alt="Profile 3">
					</c:when>
					<c:when test="${babysitter.babysitterId == 5}">
						<img
							src="${pageContext.request.contextPath}/resources/profile4.jpg"
							alt="Profile 4">
					</c:when>
					<c:when test="${babysitter.babysitterId == 6}">
						<img
							src="${pageContext.request.contextPath}/resources/profile5.JPG"
							alt="Profile 1">
					</c:when>
					<c:when test="${babysitter.babysitterId == 7}">
						<img
							src="${pageContext.request.contextPath}/resources/profile6.JPG"
							alt="Profile 2">
					</c:when>
					<c:when test="${babysitter.babysitterId == 8}">
						<img
							src="${pageContext.request.contextPath}/resources/profile7.JPG"
							alt="Profile 3">
					</c:when>
					<c:when test="${babysitter.babysitterId == 9}">
						<img
							src="${pageContext.request.contextPath}/resources/profile8.JPG"
							alt="Profile 4">
					</c:when>
					<c:otherwise>
						<img
							src="${pageContext.request.contextPath}/resources/profile9.jpg"
							alt="Default Profile">
					</c:otherwise>

				</c:choose>
				<h3>Name: ${babysitter.name}</h3>
				<h3>Experience: ${babysitter.experience}</h3>
			</div>
			<c:if test="${loop.last}">
				</div>
			</c:if>
		</c:forEach>
	</c:if>
	<div class="offer">
		<h2>🎉 20% OFF In Your First Booking! 🎉</h2>
		<p>Book your first babysitter today and enjoy a special welcome
			discount.</p>
	</div>
	<jsp:include page="footer.jsp" />

	<script src="${pageContext.request.contextPath }/js/babysitter.js"></script>
</body>
</html>