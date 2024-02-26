<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %>

<c:choose>

	<c:when test="${empty exaInfo}">
		<div class="alert alert-danger" role="alert">
			${Error}
		</div>
		 <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>phone_number</th>
                    <th>age</th>
                </tr>

                <tr>
                        <td>${patientInfo.patient_id}</td>
                        <td>${patientInfo.first_name} ${patientInfo.last_name}</td>
                        <td>${patientInfo.phone_number}</td>
                        <td>${patientInfo.age}</td>
                </tr>
            </thead>
        </table>

	</c:when>

	<c:otherwise>
		 <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>phone_number</th>
                    <th>age</th>
                    <th>medicine</th>
                    <th>status</th>
                    <th>Examination date</th>
                    <th>Re Examination date</th>
                </tr>
            <c:forEach items="${exaInfo}" var="e">
                <tr>
                    
                        <td>${patientInfo.patient_id}</td>
                        <td>${patientInfo.first_name} ${patientInfo.last_name}</td>
                        <td>${patientInfo.phone_number}</td>
                        <td>${patientInfo.age}</td>
                        <td>${e.medecine}</td>
                        <td>${e.status}</td>
                        <td>${e.exa_date}</td>
                        <td>${e.re_exa_date}</td>

                </tr>
            </c:forEach>
            </thead>
        </table>
	</c:otherwise>
</c:choose>



<%@include file="includes/footer.jspf" %>