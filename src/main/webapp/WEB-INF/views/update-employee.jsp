
<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %> 


        <h2>
            Update employee
        </h2>
<div class="alert alert-danger" role="alert">
${Error}
</div>


    
                <form action="/editEmployee" method="post">
	<div class="mb-3">
		<input type="text" name="id" value="${employee.emp_id}" hidden="" />
		
		<label for="exampleInputEmail1" class="form-label">	First Name</label><br> 
		<input type="text" name="fName" value="${employee.first_name}"
		class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Last Name</label><br> 
		<input type="text" name="lName" value="${employee.last_name}"
		class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">First working day
		</label><br> 
		<input type="date" name="fDay" value="${employee.first_day_work}"
		class="form-control" >
	</div>
	
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Salary</label><br> 
		<input type="number" name="salary" value="${employee.salary}"
		class="form-control" >
	</div>
	
		<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Bonus</label><br> 
		<input type="number" name="bonus" value="${employee.bonus}" 
		class="form-control" >
	</div>
	
		<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Discount</label><br> 
		<input type="number" name="discount" value="${employee.discount}" 
		class="form-control" >
	</div>
	
		<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Phone number</label><br> 
		<input type="text" name="pNumber" value="${employee.phone_number}"
		class="form-control" required="required">
	</div>
	
			<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Age</label><br> 
		<input type="text" name="age" value="${employee.age}"
		class="form-control" required="required">
	</div>

			<button type="submit" class="btn btn-primary">update</button>
</form>

<%@include file="includes/footer.jspf" %>

