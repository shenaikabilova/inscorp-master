package kabilova.tu.inscorp.web.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by ShenaiKabilova
 */
@SuppressWarnings("serial")
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);

            request.setCharacterEncoding("UTF-8");

            out.println("<html>");
            out.println("<body>");
            out.println("<center><form action='adminLogin' method='post'");
            out.println("<h3><center>Вход за аминистратор</center></h3>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td><label for='username'>Потребителско име</label></td>");
            out.println("<td><input type='text' class='field' name='username' placeholder='Потребителско име' maxlength='50'><br/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><label for='password'>Парола</label></td>");
            out.println("<td><input type='password' class='field' name='password' placeholder='Парола' maxlength='50'><br/></td>");
            out.println("</tr><tr><td></td>");
            out.println("<td><input type='submit' value='Вход' name='login'></td></tr></table></form></center>");
            out.println("</body></html>");
        }
}
