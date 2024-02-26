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
                    <th>Update old info</th>
                    <th>Add new examination info</th>
                </tr>
            <c:forEach items="${patients}" var="p">
                <tr>
                    
                        <td>${p.patient_id}</td>
                        <td>${p.first_name} ${p.last_name}</td>
                        <td>${p.phone_number}</td>
                        <td>${p.age}</td>
                        <td>
                        <a href="/editPatient?id=${p.patient_id}" 
                        class="btn btn-primary" role="button">
                        update</a>
                        </td>
                        
                        <td>
                        <a href="/addExaInfo?id=${p.patient_id}" 
                        class="btn btn-secondary" role="button">
                        add</a>
                        </td>

                    
                </tr>
            </c:forEach>
            </thead>
        </table>

        <br>

     <a href="/addPatient" 
          class="btn btn-secondary" role="button">add new patient</a>
       
     <a href="/patientsExaList" 
          class="btn btn-secondary" role="button">examination info</a>
                      
 
</div>

<%@include file="includes/footer.jspf" %>
