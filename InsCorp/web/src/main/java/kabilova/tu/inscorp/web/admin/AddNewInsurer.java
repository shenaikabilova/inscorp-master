package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.server.web.UserServer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ShenaiKabilova
 */
@WebServlet("/adminPanelAddInsurer")
public class AddNewInsurer extends HttpServlet{
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String pass1 = request.getParameter("password1");
        String pass2 = request.getParameter("password2");
        if(pass1.equals(pass2)) {
            int insurerID = Integer.getInteger(request.getParameter("insurerID"));
            String firstName = request.getParameter("insurerFirstName");
            String secondName = request.getParameter("insurerSecondName");
            String lastName = request.getParameter("insurerLastName");
            String username = request.getParameter("username");
            String phoneNumber = request.getParameter("phoneNumber");
            String email = request.getParameter("email");

            UserServer userServer = new UserServer(new Insurer(insurerID, firstName, secondName, lastName, username, pass1,
                                                       phoneNumber, email));
            userServer.createUser();
        }

    }
}
