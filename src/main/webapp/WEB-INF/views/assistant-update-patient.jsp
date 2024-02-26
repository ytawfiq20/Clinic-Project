
<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %> 


        <h2>
            Update patient
        </h2>
<div class="alert alert-danger" role="alert">
${Error}
</div>

    
            <form action="/editPatient" method="post">
	<div class="mb-3">
		<input type="text" name="id" value="${patient.patient_id}" hidden="" >
		
		<label for="exampleInputEmail1" class="form-label">	First Name</label><br> 
		<input type="text" name="fName" value="${patient.first_name}"
		class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Last Name</label><br> 
		<input type="text" name="lName" value="${patient.last_name}"
		class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">Phone Number
		</label><br> 
		<input type="text" name="pNumber" value="${patient.phone_number}" 
		class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Age</label><br> 
		<input type="number" name="age" value="${patient.age}" 
		class="form-control" required="required">
	</div>

			<button type="submit" class="btn btn-primary">update</button>
</form>

    
    <%@include file="includes/footer.jspf" %>