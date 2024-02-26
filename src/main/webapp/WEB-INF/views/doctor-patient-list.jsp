<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %> 

    
    <div class="patients">
        <h2>
            All Patients
        </h2>

        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>phone_number</th>
                    <th>age</th>
                    <th></th>
                </tr>
            <c:forEach items="${patients}" var="p">
                <tr>
                    
                        <td>${p.patient_id}</td>
                        <td>${p.first_name} ${p.last_name}</td>
                        <td>${p.phone_number}</td>
                        <td>${p.age}</td>

                        <td>
                         <a href="/deletePatient?id=${p.patient_id}"
          class="btn btn-danger" role="button">delete</a>
                        </td>

                    
                </tr>
            </c:forEach>
            </thead>
        </table>

        <br>
        
             <a href="/docExaList" 
          class="btn btn-secondary" role="button">patients examination info</a>
          
</div>
<%@include file="includes/footer.jspf" %>