
<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %> 
    


        <h2>
            Update patient examination info
        </h2>

<div class="alert alert-danger" role="alert">
${Error}
</div>


    
                <form action="/editPatientExaInfo" method="post">
	<div class="mb-3">
			<input type="text" name="id" value="${patient.id}" hidden="" />
            <input type="text" name="patient_id" value="${patient.patient_id}"
             hidden=""/>
		
		<label for="exampleInputEmail1" class="form-label">	Medicine</label><br> 
		<input type="text" name="medecine" value="${patient.medecine}" 
		class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Status</label><br> 
		<input type="text" name="status" value="${patient.status}"
		class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">Examination Date
		</label><br> 
		<input type="date" name="date" value="${patient.exa_date}" 
		class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Re Examination Date
		</label><br> 
		<input type="date" name="re_exa_date" value="${patient.re_exa_date}"  
		class="form-control" required="required">
	</div>

			<button type="submit" class="btn btn-primary">update</button>
</form>

  <%@include file="includes/footer.jspf" %>
  
  
  