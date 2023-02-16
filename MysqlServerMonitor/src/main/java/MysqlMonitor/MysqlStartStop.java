package MysqlMonitor;

import com.jcraft.jsch.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Provider.Service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
@WebServlet("/mysqlServerStartStop")
public class MysqlStartStop extends HttpServlet{
	
     public void service(HttpServletRequest req ,HttpServletResponse res) throws IOException {
			System.out.println("hellofffffff");
        String username = req.getParameter("UserName");
        String host = req.getParameter("IpAddress");
        String password = req.getParameter("Password");
        String sqlType = req.getParameter("sqltype");
        String startStop = req.getParameter("startStop");
        System.out.println("a"+username);
        System.out.println(host);
        System.out.println(password);
        System.out.println(sqlType);
        System.out.println("starstop2  "+startStop);
        
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
            
            if(sqlType.equals("MySQL")) {
            	if(startStop.equals("ON;")) {
					 System.out.println("hello1"); 
            		channel.setCommand("printf "+"'"+password+"'" +"| sudo -S sudo service mysql start");
					 System.out.println("hello2"); 
            	}
            	else {
            		System.out.println("stopmy");
            		channel.setCommand("printf "+"'"+password+"'" +"| sudo -S sudo service mysql stop");
            	}
				
            }
            else {
            	System.out.println("varakoodathu");
            	if(startStop.equalsIgnoreCase("ON")) {
           	     System.out.println("hello11");
           		channel.setCommand("printf "+"'"+password+"'" +"| sudo -S sudo service mysql start");
           	     System.out.println("hello22");
           	}
           	else {
           		System.out.println("secondOff");
           		channel.setCommand("printf "+"'"+password+"'" +"| sudo -S sudo service mysql stop");
           	}
            }
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            channel.connect();

            while (channel.isConnected()) {
				/* Thread.sleep(2000); */
				/* System.out.println("my sql is running"); */

            }
//            printf "Jerry07#meenu" | sudo -S sudo service mysql start


            String responseString = new String(responseStream.toByteArray());
          
            System.out.println(responseString);
            JSONObject jsp = new JSONObject();
            try {
				jsp.put("MysqlStatusstartstop",responseString);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            PrintWriter pw = res.getWriter();
            pw.println(jsp);
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


}