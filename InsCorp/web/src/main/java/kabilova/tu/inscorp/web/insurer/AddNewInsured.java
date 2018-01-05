package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.user.Insured;
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
@WebServlet("/addNewInsured")
public class AddNewInsured extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        if(pass1.equals(pass2)) {
            String firstName = request.getParameter("firstName");
            String secondName = request.getParameter("secondName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String EGN = request.getParameter("EGN");
            int postCode = Integer.parseInt(request.getParameter("postCode"));
            String country = request.getParameter("country");
            String city = request.getParameter("city");
            String address = request.getParameter("address");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");

            if(firstName.trim().equals("") || secondName.trim().equals("") || lastName.trim().equals("") ||
               username.trim().equals("") || EGN.trim().equals("") || postCode==0 || country.trim().equals("") ||
               city.trim().equals("") || address.trim().equals("") || phoneNumber.trim().equals("") || email.trim().equals("")) {
                request.setAttribute("msg", "Моля, попълнете всички полета!");
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

                UserServer userServer = new UserServer(new Insured(firstName, secondName, lastName, username, String.format("%1$032x", passEncrypt), EGN, postCode, country,
                        city, address, phoneNumber, email));
                try {
                    userServer.createUser();
                } catch (InsCorpException e) {
                    request.setAttribute("msg", e.getMessage());
                    RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                    view.forward(request, response);
                }

                request.setAttribute("msg", "Успешен запис");
                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                view.forward(request, response);
            }
        }
        else {
            request.setAttribute("msg", "Моля въведете еднакви пароли!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        }
    }
}
