
<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %>

        <h2>
            Add patient
        </h2>
        
        <form action="/addPatient" method="post">
	<div class="mb-3">
		<input type="text" name="id" value="${_csrf.token}" hidden="">
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
		<label for="exampleInputEmail1" class="form-label">Phone Number
		</label><br> 
		<input type="text" name="pNumber" class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Age</label><br> 
		<input type="number" name="age" class="form-control" required="required">
	</div>

			<button type="submit" class="btn btn-primary">Add</button>
</form>
        
       <%@include file="includes/footer.jspf" %>