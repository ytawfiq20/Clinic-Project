
<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %>
    
        <h2>
            Assistant login
        </h2>
<div class="alert alert-danger" role="alert">
${Error}
</div>

    
    <form action="/assistantLogin" method="post">
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	User Name</label><br> 
		<input type="text" name="username" value="${id}"
		 class="form-control">
	</div>
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Password</label><br> 
		<input type="password" name="password" class="form-control">
	</div>
	
				<button type="submit" class="btn btn-primary">login</button>
</form>

       <%@include file="includes/footer.jspf" %>