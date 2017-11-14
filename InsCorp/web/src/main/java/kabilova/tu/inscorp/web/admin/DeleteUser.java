package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.user.Insurer;
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
@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID;

        if(!(userID = request.getParameter("userID")).isEmpty()) {
            Insurer insurer = new Insurer();
            insurer.setId(Integer.parseInt(userID));
            UserServer userServer = new UserServer(insurer);
            userServer.delete();
        }
    }
}
