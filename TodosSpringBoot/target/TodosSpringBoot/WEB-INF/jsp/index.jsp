<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

<title>Property Manager | Home</title>

<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

	<div>
		<ul class="navigation-bar">
			<li><a href="/">Owners</a></li>
			<li><a href="new-user">Create Owner</a></li>
			<li><a href="all-users">All Owners</a></li>
		</ul>
	</div>

	<div>
		<ul class="navigation-bar">
			<li><a href="/">Properties</a></li>
			<li><a href="new-property">Create Property</a></li>
			<li><a href="all-properties">All Properties</a></li>
		</ul>
	</div>



	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Property Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_PROPERTIES'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My Properties</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>PropertyId</th>
								<th>House_Name_Number</th>
								<th>Postcode</th>

								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="property" items="${properties}">
								<tr>
									<td>${property.id}</td>
									<td>${property.house_name_number}</td>
									<td>${property.postcode}</td>

									<td><a href="update-property?id=${property.id}"> <span>&#x1f589;</span></a>
									</td>
									<td><a href="delete-property?id=${property.id}"> <span
											class="close-icon"> <i class="fa fa-trash"></i></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">

			<div class="container">
				<form class="form-horizontal" method="POST" action="save-property">
					<div class="text-center">
						<h3>Manage Property</h3>
					</div>
					<hr />
					<input type="hidden" name="id" value="${property.id}" />
					<div class="form-group">
						<label for="house_name_number">House_Name_Number</label> <input
							type="text" class="form-control" name="house_name_number"
							value="${property.house_name_number}" />
					</div>
					<div class="form-group">
						<label for="postcode">Postcode</label> <input type="text"
							class="form-control" name="postcode" value="${property.postcode}" />
					</div>


					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>








	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Owner Manager</h1>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_USERS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My Owners</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>OwnerId</th>
								<th>FirstName</th>
								<th>LastName</th>
								<th>Phone</th>
								<th>Main_Owner</th>
								<th>Property_ID</th>
								<th>Edit</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>
									<td>${user.id}</td>
									<td>${user.firstName}</td>
									<td>${user.lastName}</td>
									<td>${user.phone}</td>
									<td>${user.main_owner}</td>
									<td>${user.property.id}</td>


									<td><a href="update-user?id=${user.id}"> <span>&#x1f589;</span></a>
									</td>
									<td><a href="delete-user?id=${user.id}"> <span
											class="close-icon"> <i class="fa fa-trash"></i></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">

			<div class="container">
				<form class="form-horizontal" method="POST" action="save-user">
					<div class="text-center">
						<h3>Manage Owner</h3>
					</div>
					<hr />
					<input type="hidden" name="id" value="${user.id}" />
					<div class="form-group">
						<label for="firstName">FirstName</label> <input type="text"
							class="form-control" name="firstName" value="${user.firstName}" />
					</div>
					<div class="form-group">
						<label for="lastName">LastName</label> <input type="text"
							class="form-control" name="lastName" value="${user.lastName}" />
					</div>
					<div class="form-group">
						<label for="phone">Phone</label> <input type="text"
							class="form-control" name="phone" value="${user.phone}" />
					</div>


					<div class="form-group">
						<td>Property_Id</td>
						<!--Notice, this is normal html tag, will not be bound to an object -->
						<td><input name="property_id" type="text" /></td>
					</div>



					<div class="form-group">
						<label for="main_owner">Main_Owner</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="main_owner"
								value="true" /> <span class="col-sm-1">Yes</span> <input
								type="radio" class="col-sm-1" name="main_owner" value="false"
								checked /> <span class="col-sm-1">No</span>
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>
				</form>
			</div>
		</c:when>
	</c:choose>

</body>
</html>