<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %> 

	<h2>
	Doctor patients examination info list
	</h2>
<div class="alert alert-danger" role="alert">
${Error}
</div>
	 <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>patient id</th>
                    <th>medecine</th>
                    <th>status</th>
                    <th>examination date</th>
                    <th>Re examination date</th>
                    <th>id</th>
                    <th></th>
                </tr>

			<c:forEach items="${info}" var="i">
			<tr>
				<td>${i.patient_id}</td>
				<td>${i.medecine}</td>
				<td>${i.status}</td>
				<td>${i.exa_date}</td>
				<td>${i.re_exa_date}</td>
				<td>${i.id}</td>
				
				<td>
				<a href="/delExaInfo?id=${i.id}" 
                        class="btn btn-danger" role="button">
                        delete</a>
                </td>

               </tr>
			</c:forEach>
            </thead>
        </table>

<%@include file="includes/footer.jspf" %>

