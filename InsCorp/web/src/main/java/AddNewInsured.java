import kabilova.tu.inscorp.user.Insured;

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
        String firstName = request.getParameter("firstName");
        String secondName = request.getParameter("secondName");
        String lastName = request.getParameter("lastName");
        String EGN = request.getParameter("EGN");
        int postCode = Integer.parseInt(request.getParameter("postCode"));
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        String address = request.getParameter("address");

    }
}
