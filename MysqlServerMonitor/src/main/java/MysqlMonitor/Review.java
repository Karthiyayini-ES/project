package MysqlMonitor;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CountDownLatch;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.json.JSONObject;

import com.mysql.cj.jdbc.ha.ReplicationMySQLConnection;
import com.mysql.cj.protocol.Resultset;

@WebServlet("/result")
public class Review extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res ) throws IOException {
		String  starCount = req.getParameter("starCount");
		String review  =  req.getParameter("TextArea");
		System.out.println(starCount);
		System.out.println(review);
		Connection con = null;
		Statement stateobj = null;
	    HttpSession remove = req.getSession();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectReview","root", "Karthika@1105");
		  stateobj  =  con.createStatement();
		     String userName =  (String) remove.getAttribute("name");
		     userName = "karthiyayinies";
		  if(starCount!="0" && review!="") {
				 String query = "insert into projectReviewDetails values ("+starCount+","+"'"+review+"'"+","+"'"+userName+"'"+")";
			      int rs =  stateobj.executeUpdate(query);
			}
						 ResultSet rs1 = stateobj.executeQuery("select count(*) from projectReviewDetails");

					      JSONObject jsonObj = new JSONObject();
						 while(rs1.next()) {
							jsonObj.put("totalreview",rs1.getObject(1));
							 }
						 ResultSet  rs2 = stateobj.executeQuery("select round(avg(starCount),1) from projectReviewDetails");
				            while(rs2.next()) {
				            	jsonObj.put("totalavg",rs2.getObject(1));
							 }
				            for(int i = 1;i<=5;i++) {
				             ResultSet  rs3 = stateobj.executeQuery("select count(starCount),starCount from projectReviewDetails where starCount = "+i+" group by starCount");
				            while(rs3.next()) {
				            	
				            	jsonObj.put("totalcount"+i,rs3.getObject(1));
				               
							 }
				            }
				            ResultSet  rs4 = stateobj.executeQuery("select * from projectReviewDetails");
				            int count = 0;
				            while(rs4.next()) {
				            	count = count+1;
				            	 JSONObject jsonObj1 = new JSONObject();
				            	 jsonObj1.put("star",rs4.getObject(1));
				              	 jsonObj1.put("review",rs4.getObject(2));
				              	 jsonObj1.put("name",rs4.getObject(3));
				              	jsonObj.put("user"+count, jsonObj1);
				            }
				            
				            PrintWriter pw = res.getWriter(); 
				            pw.println(jsonObj);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	
		
	
	}

}