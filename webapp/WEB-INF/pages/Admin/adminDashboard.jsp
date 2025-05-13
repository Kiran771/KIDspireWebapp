<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/adminDashboard.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<section id="content">
		<main>
			<h1>DashBoard</h1>
			<div class="box-info">
				<div class="info">
					<i class="fa-solid fa-person"></i>
					<div class="data">
						<h4>Total Babysitter</h4>
						<h3>${totalBabysitters}</h3>
					</div>
				</div>
				<div class="info">
					<i class='bx bxs-user-account icon-user'></i>
					<div class="data">
						<h4>Total Users</h4>
						<h3>${totalusers}</h3>
					</div>
				</div>
				<div class="info">
					<i class="fa-solid fa-person-breastfeeding"></i>
					<div class="data">
						<h4>Available babysitters</h4>
						<h3>${availableBabysitters}</h3>
					</div>
				</div>
			</div>
			<div class="box-info">
				<div class="info">
					<i class="fa-solid fa-bookmark"></i>
					<div class="data">
						<h4>Booked Babysitter</h4>
						<h3>${unavailableBabysitters}</h3>
					</div>
				</div>
				<div class="info">
					<i class='bx bx-registered icon-registered'></i>
					<div class="data">
						<h4>Recent Users</h4>
						<h3>${newUsers}</h3>
					</div>
				</div>
				<div class="info">
					<i class="fa-solid fa-user-check"></i>
					<div class="data">
						<h4>Growth</h4>
						<h3>10%</h3>
					</div>
				</div>
			</div>

			<div class="table-space">
				<div class="button">
					<a
						href="${pageContext.request.contextPath}/babysitterMngController?action=add"
						class="btn btn-primary">Add Babysitter</a>
				</div>
				<table>
					<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Age</th>
							<th>Experience</th>
							<th>Email</th>
							<th>Contact Number</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody id="babysitterTableBody">
						<c:forEach var="babysitter" items="${babysitters}">
							<tr>
								<td>${babysitter.babysitterId}</td>
								<td>${babysitter.name}</td>
								<td>${babysitter.age}</td>
								<td>${babysitter.experience}</td>
								<td>${babysitter.email}</td>
								<td>${babysitter.contactNumber}</td>
								<td>${babysitter.status}</td>
								<td><a
									href="${pageContext.request.contextPath}/babysitterMngController?action=edit&babysitterId=${babysitter.babysitterId}"
									class="btn btn-edit"><i class="fa-regular fa-pen-to-square"></i></a>
									<form
										action="${pageContext.request.contextPath}/babysitterMngController"
										method="post" style="display: inline;">
										<input type="hidden" name="action" value="delete"> <input
											type="hidden" name="babysitterId"
											value="${babysitter.babysitterId}">
										<button type="submit" class="btn btn-danger"
											onclick="return confirm('Are you sure you want to delete ${babysitter.name}?')"
											aria-label="Delete babysitter">
											<i class="fas fa-trash"></i>
										</button>
									</form></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</main>
	</section>

	<script src="${pageContext.request.contextPath }/js/adminDashboard.js"></script>


</body>
</html>