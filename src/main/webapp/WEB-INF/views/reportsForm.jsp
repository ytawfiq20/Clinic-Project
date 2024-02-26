<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %>

<h2>
Choose patient name to get report about him
</h2>
<hr>

<form action="/patientReport" method="get">
	<div class="mb-3">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		<label for="exampleInputEmail1" class="form-label">	Patient Number</label><br>
		
			<select name="id" class="form-select" aria-label="Default select example">
			<option selected>Open this select menu and choose patient name</option>
			<c:forEach items="${map}" var="id">
				<option value="${id.key}">${id.value}</option>
			</c:forEach>
			</select> 
		
		
	</div>
	
	<button type="submit" class="btn btn-primary">Search</button>
	
</form>



<%@include file="includes/footer.jspf" %>