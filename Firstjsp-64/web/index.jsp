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
    
    <h1 class="text-dark text-center " style="background-color: #d9d9d9" >All Student Details</h1> 
    
    
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <a class="navbar-brand" href="addstudentform.jsp" "><button class="btn btn-info me-md-2" type="button" style="width: 200px; 
                  height: 40px;  background-color: #2ed6db;  animation-name: example;
                  animation-iteration-count: infinite; animation-duration: 4s"><h5>Add New Student</h5></button></a>
  
  <style>
       @keyframes example {
  0%   {background-color: red;}
  25%   {background-color: danger;}
  25%   {background-color: warning;}
  25%  {background-color: yellow;}
  25%  {background-color: info;}
  100% {background-color: white;}
}
  </style>
 
        
    </div>
    

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
                        <a href="editstudentform.jsp?id=${s.id}" class="btn btn-primary">Edit</a>
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