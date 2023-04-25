package com.codeWithRohit.studentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;




public class StudentDao {

	public static boolean insertStudentIntoDB(Student st) {
        boolean f = false;
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            //Create connection..
            con = ConnectionProvider.createConnection();
            
            String q = "INSERT INTO durgesh_jdbc_studentmanagement.students (sname, sphone, scity) VALUES (?, ?, ?)";
            
            //Prepared statement
            pstmt = con.prepareStatement(q);
            pstmt.setString(1, st.getStuentName());
            pstmt.setString(2, st.getStudentphone());
            pstmt.setString(3, st.getStudentCity());
            pstmt.executeUpdate();
     
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Close connection and prepared statement objects
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f;
    }
	
	public static void updateStudent(Student st) {
		Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            //Create connection..
            con = ConnectionProvider.createConnection();
            
            //String q = "update durgesh_jdbc_studentmanagement.students set sname="+st.getStuentName()+ ", scity="+st.getStudentCity()+ "where sid="+st.getStudentId();
            String q = "update durgesh_jdbc_studentmanagement.students set sname=?, scity=? where sid=?";
            
            //Prepared statement
              pstmt = con.prepareStatement(q);
              pstmt.setString(1, st.getStuentName());
              pstmt.setString(2, st.getStudentCity());
              pstmt.setInt(3, st.getStudentId());
              pstmt.executeUpdate();
            
            
     
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Close connection and prepared statement objects
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	public static boolean deletStudent(int stId) {
		boolean response=false;
		Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            //Create connection..
            con = ConnectionProvider.createConnection();
            
            String q = "delete from durgesh_jdbc_studentmanagement.students where sid=?";
            
            //Prepared statement
            pstmt = con.prepareStatement(q);
            pstmt.setInt(1, stId);
            
            pstmt.executeUpdate();
     
            response = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Close connection and prepared statement objects
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return response;
		
	}

	public static void displayAllStudents() {
		Connection con = null;
		Statement stmt=null;
        
        try {
            //Create connection..
            con = ConnectionProvider.createConnection();
            
            String q = "select * from durgesh_jdbc_studentManagement.students";
            
            //create statement
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q);
            
            while(rs.next()) {
            	//Display all details of student
            	System.out.println("Id : " + rs.getInt("sid"));
            	System.out.println("Name : " + rs.getString("sname"));
            	System.out.println("Phone No. : " + rs.getString("sphone"));
            	System.out.println("City : " + rs.getString("scity"));
            	System.out.println("-----------------------------------------------");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Close connection and prepared statement objects
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
}





	

