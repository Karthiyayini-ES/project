package MysqlMonitor;
	
	import java.io.Console;
	import java.io.IOException;
	import java.net.http.HttpRequest;
	import java.sql.*;
	import java.net.http.HttpResponse;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.util.ArrayList;
	import java.util.FormatFlagsConversionMismatchException;
	import java.util.function.IntBinaryOperator;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;
	import javax.sound.midi.Soundbank;
	import javax.swing.text.DefaultEditorKit.InsertBreakAction;

	import org.apache.catalina.connector.Response;
	import org.apache.jasper.tagplugins.jstl.core.If;

	import com.mysql.cj.exceptions.RSAException;
	import com.mysql.cj.protocol.x.ContinuousOutputStream;

	//import com.mysql.cj.xdevapi.Statement;
	@WebServlet("/Login")
	public class Login extends HttpServlet{
		public void service(HttpServletRequest req ,HttpServletResponse res) throws ServletException, IOException {
			String nameSignIn = req.getParameter("nameSignIn");
			String passSignIn = req.getParameter("passSignIn");
			String nameSignUp = req.getParameter("nameSignUp");
			System.out.println(nameSignIn);
			String passSignUp = req.getParameter("passSignUp");
			System.out.println(passSignIn);
			String process = req.getParameter("type");
//			String SignUp = req.getParameter("SignUp");
			Connection con = null;
			Statement stateobj = null;
	        HttpSession message=req.getSession();  
	        HttpSession remove = req.getSession();
	        boolean flag = true;
	       message.setAttribute("check", "true");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login","root", "Karthika@1105");
			    
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
		      System.out.println(e.getMessage());
			}
	       
			if(process.equals("SignUp")){
				try {
				
		        String query = "insert into Details values ("+"'"+nameSignUp+"'"+","+"'"+passSignUp+"'"+")";
		        stateobj =  con.createStatement();
		        int rs =  stateobj.executeUpdate(query);
		        remove.setAttribute("name",nameSignUp);
		        remove.setAttribute("password",passSignUp);
		        RequestDispatcher rd = req.getRequestDispatcher("/AppiliManager.html");
				rd.forward(req, res);
		        
		       
	          }
				catch(Exception e){
//				    e.printStackTrace();
					message.setAttribute("Result","Check the details");
					RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
					 
					rd.forward(req, res);
					
					System.out.println(e.getMessage());
				}
				
				
				
			}
			else if(process.equals("SignIn")) {
				
				try {
				
				String query = "select * from Details";
		        stateobj =  con.createStatement();
		        ResultSet rs1 =  stateobj.executeQuery(query);
				while(rs1.next()) {
		         
					if(rs1.getObject(1).equals(nameSignIn) && 	rs1.getObject(2).equals(passSignIn)) {
					       remove.setAttribute("name",nameSignIn);
					        remove.setAttribute("password",passSignIn);
					        
				      System.out.println("login successful");
				      RequestDispatcher rd = req.getRequestDispatcher("/AppiliManager.html");
						rd.forward(req, res);
				      flag = false;
				      
				      
				    
					}
				}

				      
				if(flag==true) {
				System.out.println("signIn not successfull");
				message.setAttribute("ResultsignIn","Check the details in login page");
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.forward(req, res);
				
					
						}

				}
			
				catch (Exception e) {
					message.setAttribute("ResultsignIn","Check the details in login page");
					System.out.println(e.getMessage());
				}
			
			
		}
			else if(process.equals("Logout")) {
				remove.removeAttribute("name");
				remove.removeAttribute("password");
			   System.out.println("Logout Successfully");
			   RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
				 
				rd.forward(req, res);
				
			   
			}
			
			
		}}
	

