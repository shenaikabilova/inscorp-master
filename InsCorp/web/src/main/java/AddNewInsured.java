import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.server.web.UserServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ShenaiKabilova
 */
@WebServlet("/addNewInsured")
public class AddNewInsured extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String EGN = request.getParameter("EGN");
        int    postCode = Integer.parseInt(request.getParameter("postCode"));
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");

        UserServer userServer = new UserServer(new Insured(firstName, secondName, lastName, username, password, EGN, postCode, country,
                                                           city, address, phoneNumber, email));
        userServer.createUser();
    }
}
