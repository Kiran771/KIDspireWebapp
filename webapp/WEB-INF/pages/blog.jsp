<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="stylesheet" type="text/css"
href="${pageContext.request.contextPath}/css/blog.css">
</head>
<body>
	<jsp:include page="headerUser.jsp" />
	<div class="blog">
		<div class="blogByBs">
			<h1>Finding Joy in the Little Moments</h1>
			<h3><i class="fa-solid fa-fan" style="color: #FFD43B;"></i>By: Alison, Babysitter</h3>
			<p>
			It’s not always about big milestones. Sometimes, it’s a giggle over a silly drawing,
			or a sleepy “thank you” before bedtime. Babysitting taught me more about patience, 
			trust, and kindness than any classroom ever did.Every child is different. Some are
			shy, some are wild dreamers. But they all need someone who listens — not just watches.
			I always carry a small storybook in my bag. It’s nothing fancy. But watching a child
			light up during storytime? That’s my favourite part.
			</p>
			<p>| “Children don’t need perfect. They need presence.”</p>
		</div>
		<div class="babysitterImgBlog">
			<img src="${pageContext.request.contextPath}/resources/blogImg1.JPG">
			
		</div>
	</div>
	<div class=blog2>
		<div class="blogImg2">
			<img src="${pageContext.request.contextPath}/resources/blogImg2.jpg">
			
		</div>
		<div class="blogByRiya">
			<h1>Why I Love Babysitting</h1>
			<h3><i class="fa-solid fa-fan" style="color: #FFD43B;"></i> By:Riya, Happy Parent and Grateful Customer</h3>
			<p>
			I’m often asked — isn’t finding a good babysitter hard?
		    Sometimes, yes. But the days when you find someone who truly cares? Those days make all the difference.
	        From the way my child’s face lights up when their babysitter arrives, to the little conversations 
	        that happen while I’m out — I get to see my child blossom in someone else’s hands, someone who makes 
	        them feel safe and valued.Hiring a babysitter isn’t just about getting time for myself. It’s about 
	        trusting someone who will show my child the same love, patience, and care that I would. It’s about
	        building a relationship of trust that benefits everyone in our family.“You’re not just hiring someone 
	        for a few hours. You’re giving your child a new friend and creating beautiful memories.”
	      	That’s why I love having the right babysitter — because it’s not just about childcare; it’s
	      	about creating a better experience for my child, my family, and myself.
			</p>
		</div>
	</div>
	<div class="quicktip">
		<div class="tips">
		<p>Quick Tip: Always keep emergency contacts on the fridge for babysitters.</p>
		</div>
		<div class="tips">
		<p>Activity Idea: DIY play-dough with just flour, salt, and water!</p>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	

</body>
</html>