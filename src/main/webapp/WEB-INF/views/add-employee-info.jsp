
<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %>

    
        <h2>
            Add employee
        </h2>
<div class="alert alert-danger" role="alert">
${Error}
</div>
    
    
    <form action="/addEmployee" method="post">
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	First Name</label><br> 
		<input type="text" name="fName" value=""
		 class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Last Name</label><br> 
		<input type="text" name="lName" class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">First Working day
		</label><br> 
		<input type="date" name="fDay" class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Salary</label><br> 
		<input type="number" name="salary" value="0.0" class="form-control">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Bonus</label><br> 
		<input type="number" name="bonus" value="0.0" class="form-control">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Discount</label><br> 
		<input type="text" name="discount" value="0.0" class="form-control">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Phone number</label><br> 
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

