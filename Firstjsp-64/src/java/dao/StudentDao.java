package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import utill.DbUtill;

public class StudentDao {

    static PreparedStatement ps;
    static ResultSet rs;
    static String sql;

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        sql = "select * from student";

        try {
            ps = DbUtill.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("contactNo"));

                students.add(s);

            }
            System.out.println(students);

            rs.close();
            ps.close();
            DbUtill.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return students;

    }

    public static int saveStudent(Student s) {
        int status = 0;
        sql = "insert into student(name, email, contactNo) values(?,?,?)";

        try {
            ps = DbUtill.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getContactNo());

            status = ps.executeUpdate();

            System.out.println(status);

            ps.close();
            DbUtill.getCon().close();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }
    
    
    
    public static void deleteStudent(int id){
        
        sql = "delete from student where id = ? ";
        
        try {
            ps= DbUtill.getCon().prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            ps.close();
            DbUtill.getCon().close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public static Student getById(int id ){
        Student s = null;
        
        sql = "select * from student where id=?";
        
        try {
            ps = DbUtill.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                s= new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("contactNo")
                );
              
            }
            
            rs.close();
            ps.close();
            DbUtill.getCon().close();
                        
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return s;
    
    
    }
    
    
    
    public static int updateStudent(Student s){
        int status = 0;
        
        sql ="update student set name=?, email=?, contactNo=? where id=?";
        
        try {
            ps = DbUtill.getCon().prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getContactNo());
            ps.setInt(4, s.getId());
            
            status = ps.executeUpdate();
            
            System.out.println(status);
            
            ps.close();
            DbUtill.getCon().close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    
    }
    

}
