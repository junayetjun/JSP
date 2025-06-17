
package servelet;

import dao.EmpDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Emp;

@WebServlet("/empServelet")
public class EmpServelet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if("add".equals(action)){
            Emp emp = new Emp();
            emp.setName(request.getParameter("name"));
            emp.setSalary(Float.parseFloat(request.getParameter("salary")));
    
    
            EmpDao.saveEmp(emp);
            
            response.sendRedirect("allemp.jsp");
    }
        else if("update".equals(action)){
            Emp emp = new Emp();
            emp.setName(request.getParameter("name"));
            emp.setSalary(Float.parseFloat(request.getParameter("salary")));                
            emp.setId(Integer.parseInt(request.getParameter("id")));
            EmpDao.updateEmp(emp);
            
            response.sendRedirect("allemp.jsp");
                }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if("delete".equals(action)){
            EmpDao.deleteEmp(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("allemp.jsp");
        }
        
        else if("edit".equals(action)){
            Emp e = EmpDao.getById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("emp", e);
            request.getRequestDispatcher("edittemp.jsp").forward(request, response);
        
        }
    
        
    
    }
    
    
    
    
    
    
    
    
    
}
