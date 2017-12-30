package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.server.web.UserServer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        String username = request.getParameter("username");

        Insurer insurer = new Insurer();
        insurer.setUsername(username);
        UserServer userServer = new UserServer(insurer);

        List<Insurer> result = new ArrayList<>();
        result.add((Insurer) userServer.loadByUsername());
        insurer.setId(userServer.loadByUsername().getId());
        userServer.delete();

        request.setAttribute("errmsg", "Застрахователният агент е изтрит!");
        RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
        view.forward(request,response);

    }
}
