<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %>
    
    
    <h2>Online Booking</h2>
<div class="alert alert-danger" role="alert">
${Error}
</div>
<div>
<form action="/patientRegister" method="post">
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	First Name</label><br> 
		<input type="text" name="fName" class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Last Name</label><br> 
		<input type="text" name="lName" class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">Phone Number</label><br> 
		<input type="text" name="pNumber" class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">Age</label><br> 
		<input type="text" name="age" class="form-control" required="required">
	</div>

			<button type="submit" class="btn btn-primary">Register</button>
</form>
</div>

<%@include file="includes/footer.jspf" %>


