package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.user.Admin;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.server.web.UserServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

        if(username.trim().equals("") || password.trim().equals("")) {
            request.setAttribute("msg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        } else {
            MessageDigest m;
            BigInteger passEncrypt = null;
            try {
                m = MessageDigest.getInstance("MD5");
                m.update(password.getBytes(), 0, password.length());
                passEncrypt = new BigInteger(1, m.digest());
                System.out.println(String.format("%1$032x", passEncrypt));
            } catch (NoSuchAlgorithmException e1) {
                e1.printStackTrace();
            }

            UserServer userServer = new UserServer(new Insurer(username,  String.format("%1$032x", passEncrypt)));

            if (userServer.loadUser(username, String.format("%1$032x", passEncrypt)) instanceof Insurer) {
                HttpSession session = request.getSession(true);
                session.setAttribute("id", userServer.loadUser(username, String.format("%1$032x", passEncrypt)).getId());
                session.setAttribute("username", userServer.loadUser(username, String.format("%1$032x", passEncrypt)).getUsername());
                session.setAttribute("password", userServer.loadUser(username, String.format("%1$032x", passEncrypt)).getPassword());

//            Cookie loginCookie = new Cookie("user", username);
//            loginCookie.setMaxAge(60*60*24);
//            response.addCookie(loginCookie);
                response.sendRedirect("insurer/insurer.jsp");
            } else {
                RequestDispatcher view = request.getRequestDispatcher("insurer/login.jsp");
                view.forward(request, response);
            }
        }
    }
}
