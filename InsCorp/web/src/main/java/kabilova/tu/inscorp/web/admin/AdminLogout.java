package kabilova.tu.inscorp.web.admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * Created by ShenaiKabilova
 */
@WebServlet("/AdminLogout")
public class AdminLogout extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession newsession = request.getSession(false);
        if(newsession != null) {
            newsession.removeAttribute("username");
            newsession.removeAttribute("password");
            request.getSession().invalidate();
        }
        response.sendRedirect("/AdminLogin");
    }
}