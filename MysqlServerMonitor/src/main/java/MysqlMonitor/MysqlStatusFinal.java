package MysqlMonitor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * Servlet implementation class MysqlStatusFinal
 */
@MultipartConfig
@WebServlet(asyncSupported = true, urlPatterns = { "/mysqlServer" })
public class MysqlStatusFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MysqlStatusFinal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("succe12ss");
		String username = request.getParameter("UserName");
        String host = request.getParameter("IpAddress");
        String password = request.getParameter("Password");
        String sqlType = request.getParameter("sqltype");
      
		/*
		 * System.out.println("ab"+username); System.out.println(host);
		 * System.out.println(password); System.out.println(sqlType);
		 */
        System.out.println("here2");
        
        Session session = null;
        ChannelExec channel = null;

        try {
            try {
				session = new JSch().getSession(username, host, 22);
			} catch (JSchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
           session.connect();
            channel = (ChannelExec) session.openChannel("exec");
            
            if(sqlType.equals("MySQL;")) {
            
            channel.setCommand("printf "+"'"+password+"'" +"| sudo -S service mysql status");
            }
            else {
              
            	 channel.setCommand("service postgresql status");
            }
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            channel.connect();

            
				/* Thread.sleep(2000); */
				/* System.out.println("my sql is running"); */

            
//            printf "Jerry07#meenu" | sudo -S sudo service mysql start
            
            JSONObject js = new JSONObject();
            
            String responseString = new String(responseStream.toByteArray());
         
			/* System.out.println(responseString); */
         
            try {
            	
				js.put("MysqlStatus",responseString);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            response.getWriter().println(js.toString());
    
        } catch (JSchException e) {
			e.printStackTrace();
		}
        finally {
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            } 
        }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("su");
 	}

}
