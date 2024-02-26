<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %>

	<h2>
	Add info to existing patient
	</h2>
	
<div class="alert alert-danger" role="alert">
${Error}
</div>

	<form action="/addExaInfo" method="post">
	<div class="mb-3">
		<input type="text" name="id" value="${patient.patient_id}" hidden="" />
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Medecine</label><br> 
		<input type="text" name="medecine" value="" class="form-control">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">Status
		</label><br> 
		<input type="text" name="status" value="" class="form-control">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Examination date
		</label><br> 
		<input type="date" name="exa_date" value="" required="required" 
		class="form-control">
	</div>

	<button type="submit" class="btn btn-primary">Add</button>
	</form>
	
<%@include file="includes/footer.jspf" %>

