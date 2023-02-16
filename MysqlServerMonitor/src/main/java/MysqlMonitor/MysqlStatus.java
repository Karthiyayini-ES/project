//package MysqlMonitor;
//
//import com.jcraft.jsch.*;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.security.Provider.Service;
//import java.util.Map;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//@WebServlet("/mysqlServer")
//public class MysqlStatus extends HttpServlet{
//	
//     public void doGet(HttpServletRequest req ,HttpServletResponse res) throws IOException {
//			
//        String username = req.getParameter("UserName");
//        String host = req.getParameter("IpAddress");
//        String password = req.getParameter("Password");
//        String sqlType = req.getParameter("sqltype");
//        System.out.println("hello1111");
//		/*
//		 * System.out.println("ab"+username); System.out.println(host);
//		 * System.out.println(password); System.out.println(sqlType);
//		 */
//        
//        Session session = null;
//        ChannelExec channel = null;
//
//        try {
//            try {
//				session = new JSch().getSession(username, host, 22);
//			} catch (JSchException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            session.setPassword(password);
//            session.setConfig("StrictHostKeyChecking", "no");
//           session.connect();
//            channel = (ChannelExec) session.openChannel("exec");
//            
//            if(sqlType.equals("MySQL;")) {
//            
//            channel.setCommand("printf "+"'"+password+"'" +"| sudo -S service mysql status");
//            }
//            else {
//              
//            	 channel.setCommand("service postgresql status");
//            }
//            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
//            channel.setOutputStream(responseStream);
//            channel.connect();
//
//            
//				/* Thread.sleep(2000); */
//
//            
////            printf "Jerry07#meenu" | sudo -S sudo service mysql start
//            
//            JSONObject js = new JSONObject();
//            
//            String responseString = new String(responseStream.toByteArray());
//         
//			/* System.out.println(responseString); */
//         
//            try {
//            	
//				js.put("MysqlStatus",responseString);
//				
//			} catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            PrintWriter pw = res.getWriter();
//            pw.println(js);
//    
//        } catch (JSchException e) {
//			e.printStackTrace();
//		}
//        finally {
//            if (session != null) {
//                session.disconnect();
//            }
//            if (channel != null) {
//                channel.disconnect();
//            } 
//        }
//    }
//
//
//}