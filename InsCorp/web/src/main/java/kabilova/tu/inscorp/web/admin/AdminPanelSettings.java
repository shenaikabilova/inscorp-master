package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.exception.InsCorpException;
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
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ShenaiKabilova
 */
@WebServlet("/adminPanelSettings")
public class AdminPanelSettings extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        if(pass1.equals(pass2) && !pass1.trim().equals("") && !pass2.trim().equals("") ) {
            int adminID = request.getParameter("adminID") != "" ? Integer.parseInt(request.getParameter("adminID")) : 0;
            String firstName = request.getParameter("firstName");
            String secondName = request.getParameter("secondName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");

            if (adminID == 0 || firstName.trim().equals("") || secondName.trim().equals("") || lastName.trim().equals("") ||
                    username.trim().equals("")  || phoneNumber.trim().equals("") || email.trim().equals("")) {
                request.setAttribute("errmsg", "Моля, попълнете всички полета!");
                RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                view.forward(request, response);
            } else {
                MessageDigest m;
                BigInteger passEncrypt = null;
                try {
                    m = MessageDigest.getInstance("MD5");
                    m.update(pass1.getBytes(), 0, pass1.length());
                    passEncrypt = new BigInteger(1, m.digest());
                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                }

                UserServer userServer = new UserServer(new Admin(adminID, firstName, secondName, lastName, username, String.format("%1$032x", passEncrypt),
                        phoneNumber, email));
//                try {
                    userServer.update();
//                } catch (InsCorpException e) {
//                    String errorMsg = new String(e.getMessage().getBytes(), "UTF-8");
//                    request.setAttribute("errmsg", "Неуспешен запис: " + errorMsg);
//                    RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
//                    view.forward(request, response);
//                }

//            SendMail sendMail = new SendMail();
//            sendMail.sendMail(insurerID, pass1, email);

                request.setAttribute("errmsg", "Успешен запис!");
                RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                view.forward(request, response);
            }
        }
        else{
            request.setAttribute("errmsg", "Моля въведете еднакви пароли!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        }
    }
}