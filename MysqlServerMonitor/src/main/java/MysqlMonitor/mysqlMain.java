/*
 * package MysqlMonitor;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.annotation.WebServlet; import
 * javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest;
 * import javax.servlet.http.HttpServletResponse; import java.io.BufferedReader;
 * import java.io.IOException; import java.io.InputStreamReader; import
 * java.io.PrintWriter; import java.util.HashMap; import java.util.Map;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import com.jcraft.jsch.JSchException; import
 * com.pastdev.jsch.DefaultSessionFactory; import
 * com.pastdev.jsch.command.CommandRunner;
 * 
 * 
 * @WebServlet("/mysqlServer") public class mysqlMain extends HttpServlet{
 * 
 * public void service(HttpServletRequest req ,HttpServletResponse res) throws
 * IOException{
 * 
 * String username = req.getParameter("UserName"); String host =
 * req.getParameter("IpAddress"); String password =
 * req.getParameter("Password"); String sqlType = req.getParameter("sqltype");
 * String startStop = req.getParameter("startStop");
 * 
 * 
 * String worksql = request.getParameter("switch"); HttpSession sess =
 * request.getSession(); PrintWriter out = response.getWriter(); String ip =
 * (String)sess.getAttribute("ip"); String name =
 * request.getParameter("lapusername"); String sqltype =
 * request.getParameter("sqlType"); String password =
 * request.getParameter("lappass");
 * 
 * DefaultSessionFactory sessionFactory = new DefaultSessionFactory( username,
 * host, 22 ); Map props = new HashMap<String, String>();
 * props.put("StrictHostKeyChecking", "no"); sessionFactory.setConfig(props);
 * sessionFactory.setPassword(password);
 * 
 * CommandRunner runner = new CommandRunner(sessionFactory);
 * 
 * PrintWriter out = res.getWriter(); String command = "";
 * if(sqlType.equals("MySQL;")) { if(startStop.equals("ON;")) {
 * command="sudo systemctl start mysql"; } else if(startStop.equals("OFF;")){
 * System.out.println("hello"); command="sudo systemctl stop mysql"; } else {
 * command="service mysql status "; } } else { if(startStop.equals("ON;")) {
 * command="sudo systemctl start postgresql"; } else
 * if(startStop.equals("OFF;")){ command="sudo systemctl stop postgresql"; }
 * else { command="sudo service postgresql status "; } }
 * CommandRunner.ExecuteResult result = null; CommandRunner.ExecuteResult
 * statusresult = null;
 * 
 * try { result = runner.execute(command); } catch (JSchException | IOException
 * e) { e.printStackTrace(); }
 * 
 * 
 * if (result.getStderr().isEmpty()) { try { if(sqlType.equals("MySQL;")) {
 * statusresult = runner.execute("sudo service mysql status "); } else {
 * statusresult = runner.execute("sudo service postgresql status "); }
 * 
 * } catch (JSchException | IOException e) { e.printStackTrace(); }
 * 
 * if (statusresult.getStderr().isEmpty()) {
 * out.println(statusresult.getStdout()); } } else {
 * out.println(result.getStderr()); }
 * 
 * runner.close();
 * 
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 */