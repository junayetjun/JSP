<%@page import="model.Student" %>
<%@page import="dao.StudentDao" %>


<%
    
String id = request.getParameter("id");
Student s = StudentDao.getById(Integer.parseInt(id));



%>

<%@include file="header.jsp" %>


<div class="container my-3">
    <div class="bg-info text-center">
        <h1 class="jumborton">Update Student</h1>
    </div>
    <!--    start form-->
    <form action="editstudent.jsp"  method="post">
        <input type="hidden" name="id" value="<%=s.getId()%>" />

        <div class="row">
            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" value="<%=s.getName()%>" placeholder="Full Name">
            </div>

            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Email</label>
                <input type="text" class="form-control" id="email" name="email" value="<%=s.getEmail()%>" placeholder="example@gmail.com">
            </div>        
        </div>
  


        <div class="row">
            <div class="col-md-6">
                <label for="exampleInputEmail1" class="form-label">Contact Number</label>
                <input type="text" class="form-control" id="contactNo" name="contactNo" value="<%=s.getContactNo()%>" placeholder="+880159325884">
            </div>

        </div>

        <div class="row mt-3 text-center">
            <div class="col-md-6">
                <button type="submit" class="btn btn-success text-center" >Update</button>

            </div>

            <div class="col-md-6">
                <button type="reset" class="btn btn-danger text-center" >Reset</button>

            </div>
        </div>
    </form>

    <!--end form    -->
</div>