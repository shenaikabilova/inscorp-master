package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.bl.mail.SendMail;
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
@WebServlet("/insurerSettingsUpdate")
public class InsurerSettingsUpdate extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        if(pass1.equals(pass2)) {
            int id = Integer.parseInt(request.getParameter("insID"));
            int insurerID = Integer.parseInt(request.getParameter("insurerID"));
            String firstName = request.getParameter("insurerFirstName");
            String secondName = request.getParameter("insurerSecondName");
            String lastName = request.getParameter("insurerLastName");
            String username = request.getParameter("username");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("e-mail");

            if (id==0 || insurerID == 0 || firstName.trim().equals("") || secondName.trim().equals("") || lastName.trim().equals("") ||
                    username.trim().equals("") || phoneNumber.trim().equals("") || email.trim().equals("")) {
                request.setAttribute("errmsg", "Моля, попълнете всички полета!");
                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                view.forward(request, response);
            } else {
                MessageDigest m;
                BigInteger passEncrypt = null;
                try {
                    m = MessageDigest.getInstance("MD5");
                    m.update(pass1.getBytes(), 0, pass1.length());
                    passEncrypt = new BigInteger(1, m.digest());
                    System.out.println(String.format("%1$032x", passEncrypt));
                } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                }

                UserServer userServer = new UserServer(new Insurer(id, insurerID, firstName, secondName, lastName, username, String.format("%1$032x", passEncrypt),
                        phoneNumber, email));
                    userServer.update();

                SendMail sendMail = new SendMail();
                sendMail.sendMail(insurerID, pass1, email);

                request.setAttribute("errmsg", "Успешен запис!");
                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                view.forward(request, response);
            }
        }
        else{
            request.setAttribute("errmsg", "Моля въведете еднакви пароли!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        }
    }
}
