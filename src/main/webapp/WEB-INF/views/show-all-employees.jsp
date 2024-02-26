<%@include file="includes/header.jspf" %>
<%@include file="includes/navbar.jspf" %> 
    
    <div class="Employees">
        <h2>
            All Employees
        </h2>

        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>first working day</th>
                    <th>salary</th>
                    <th>bonus</th>
                    <th>discount</th>
                    <th>phone_number</th>
                    <th>age</th>
                    <th></th>
                    <th></th>
                </tr>
            <c:forEach items="${employees}" var="emp">
                <tr>
                    
                        <td>${emp.emp_id}</td>
                        <td>${emp.first_name} ${emp.last_name}</td>
                        <td>${emp.first_day_work}</td>
                        <td>${emp.salary}</td>
                        <td>${emp.bonus}</td>
                        <td>${emp.discount}</td>
                        <td>${emp.phone_number}</td>
                        <td>${emp.age}</td>
                        <td>
                        <a href="/editEmployee?id=${emp.emp_id}" 
                        class="btn btn-primary" role="button">
                        update</a>
                        </td>
                        
                        <td>
                        <a href="/deleteEmployee?id=${emp.emp_id}"
                        class="btn btn-danger" role="button">
                        delete</a>
                        </td>

                    
                </tr>
            </c:forEach>
            </thead>
        </table>

        <br>

     <a href="/addEmployee" 
          class="btn btn-secondary" role="button">add employee</a>
          

    </div>

<%@include file="includes/footer.jspf" %>