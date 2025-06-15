<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Student"%>
<%@page import="dao.StudentDao"%>
<%@page import="java.util.*" %>

<%@include file="header.jsp" %>

<br>
<br>
<br>


<%
 List<Student> list=StudentDao.getAllStudents();
 request.setAttribute("list", list);

%>

<div class="container">
    <h1 class="text-primary text-center">All Student</h1> 

    <table class="table table-striped">

        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Contact Number</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="s">
            <tr>
                <td>${s.getId()}</td>
                <td>${s.getName()}</td>
                <td>${s.getEmail()}</td>
                <td>${s.getContactNo()}</td>
                <td>
                    <button type="submit" class="btn btn-primary">Edit</button>
                    <a href="deletestudent.jsp?id=${s.id}" class="btn btn-danger"
                       onclick="return confirm('Are you sure you want to delete this student');">Delete</a>
                </td>

            </tr>

        </c:forEach>

        </tbody>


    </table>

</div>

<br>
<br>
<br> 
<br>
<br>
<br>    
<br>
<br>
<br>
<br>
<br>
<br>


<%@include file="footer.jsp" %>