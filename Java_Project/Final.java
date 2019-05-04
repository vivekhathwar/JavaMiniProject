import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Final {
	Cell[][] Schedule;
	ArrayList<Doctor> doctors=new ArrayList<Doctor>();
	
    void createTable(){
        Doctor[] docts= (Doctor[]) doctors.toArray(new Doctor[doctors.size()]);
        createSchedule tt=new createSchedule(docts);
        
        Schedule=tt.getSchedule();
    }
    
    public Cell[][] getSchedule(){
    	return Schedule;
    }
    
    ArrayList<Doctor> getDoctors() {
    	return doctors;
    }
    
    Cell[][] addDoctor(){
    	try {
    		doctors.removeAll(doctors);
    		Statement stmt;
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/doctors","root","venkateshbn");
            stmt = conn.createStatement();
            
            ResultSet rs= stmt.executeQuery("select * from docnames;");
            while(rs.next()) {
            	doctors.add(new Doctor(rs.getString(1),18));
            	System.out.println(rs.getString(1));
            }
            for(Doctor d: doctors) {
            	d.timeLeft=18;
            }
    	}
    	
    	catch(Exception e)
        {
            System.out.println("Exception occurred is"+ e);
        }
    	
    	createTable();
    	return Schedule;
    }
    
    Cell[][] removeDoctor(String name){
    	try {
    		doctors.removeAll(doctors);
    		Statement stmt;
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/doctors","root","venkateshbn");
            stmt = conn.createStatement();
            
            
            
            String query4 = "delete from docnames where name="+"'"+name+"'"+";";
            stmt.executeUpdate(query4);
            
            String query5 = "delete from docs where name="+"'"+name+"'"+";";
            stmt.executeUpdate(query5);
            
            ResultSet rs = stmt.executeQuery("select * from docnames;");
            while(rs.next()) {
            	doctors.add(new Doctor(rs.getString(1),18));
            	System.out.println(rs.getString(1));
            }
            for(Doctor d: doctors) {
            	d.timeLeft=18;
            }
    	}
    	
    	catch(Exception e)
        {
            System.out.println("Exception occurred is"+ e);
        }
    	
    	createTable();
    	return Schedule;
    }
}