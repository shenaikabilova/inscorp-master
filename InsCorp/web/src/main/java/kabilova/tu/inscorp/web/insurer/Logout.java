package kabilova.tu.inscorp.web.insurer;

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
@WebServlet("/logout")
public class Logout extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession newsession = request.getSession(false);
        if(newsession != null) {
            newsession.removeAttribute("username");
            newsession.removeAttribute("password");
            request.getSession().invalidate();
        }
        response.sendRedirect("insurer/login.jsp");
    }
}
