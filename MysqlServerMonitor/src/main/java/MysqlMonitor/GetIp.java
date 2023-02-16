package MysqlMonitor;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/sqlLogin")
public class GetIp extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		
		try {
			/* response.setContentType("application/json"); */
			/* System.out.println("heelo"); */
            String y = null;
            Process p = Runtime.getRuntime().exec("hostname -I");
            InputStream in = p.getInputStream();
            Scanner sc = new Scanner(in);
            y = sc.nextLine();
            String[] words=y.split("\\s");
			/* System.out.println(words[0]); */
           
            
            JSONObject jobj = new JSONObject();
         
            jobj.put("ipAdd", words[0]);

            PrintWriter pobj = response.getWriter();
            pobj.println(jobj);
            

			
		}
		
		catch(Exception ee) {
			
			System.out.println(ee.getMessage());
			
			
		}
		
	}
}