package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.user.Admin;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.server.web.UserServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
@WebServlet("/insurerlogin")
public class InsurerLogin extends HttpServlet{
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserServer userServer = new UserServer(new Insurer(username, password));
        if(userServer.loadUser(username, password) instanceof Insurer) {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.sendRedirect("insurer/insurer.jsp");
        }
        else {
            RequestDispatcher view = request.getRequestDispatcher("insurer/login.jsp");
            view.forward(request, response);
        }
    }
}
