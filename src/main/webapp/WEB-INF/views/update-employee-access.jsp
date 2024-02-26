
<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %> 
    

        <h2>
            update employee access info
        </h2>
<div class="alert alert-danger" role="alert">
${Error}
</div>
        
        
        <form action="/editEmployeeAccess" method="post">
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	ID</label><br> 
		<input type="text" name="id" value="${id}"
		 class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	User name</label><br> 
		<input type="text" name="uName" class="form-control" required="required">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">Password</label><br> 
		<input type="password" name="password" class="form-control" required="required">
	</div>
	
			<button type="submit" class="btn btn-primary">Add</button>
</form>


<%@include file="includes/footer.jspf" %>