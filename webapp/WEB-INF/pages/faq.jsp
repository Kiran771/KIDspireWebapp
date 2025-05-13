<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/faq.css">
</head>
<body>
	<jsp:include page="headerUser.jsp" />
	<div class="faqContainer">
		<h2>You have got questions?</h2>
		<h2>We've got answers!</h2>
		<p>Everything you need to know about KIDspire</p>
	</div>
	<div class=qnaContainer>
		<div class="qna">
			<p>
				1. What is this system for?<br> This platform helps parents and
				guardians find, view, and manage babysitters based on experience,
				availability, and contact information.<br> 2. How do I find a
				babysitter?<br> You can search for babysitters using their
				name, experience, or ID. You can also sort them by age, experience,
				or availability to find the best match for your needs.<br>
				3. How do I contact a babysitter?<br> Each babysitter profile
				includes a valid 10-digit contact number (starting with ‘98’).
				Simply click on the profile and use the number to call or message
				them directly.<br> 4. Is the babysitter’s information verified?<br>
				We aim to include only accurate and updated information. However, we
				recommend personally contacting the babysitter for further details
				and verification.
			</p>
		</div>
		<div class="workImg">
			<img src="${pageContext.request.contextPath}/resources/workImg.jpg">
		</div>
	</div>
	<div class="stillqnaContainer">
		<div class="qnabtn">
			<div class="stillqna">
				<h3>Still have questions?</h3>
				<p>can’t find the answer you are looking for? Please contact our
					team.</p>
			</div>
			<div class="buttonGetStarted">
				<button>Get Started</button>
			</div>
		</div>

	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>