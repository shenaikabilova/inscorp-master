package kabilova.tu.inscorp.web.admin;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.user.Insurer;
import kabilova.tu.inscorp.server.web.UserServer;

import javax.servlet.RequestDispatcher;
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
        String username = request.getParameter("username");

        if(username.trim().equals("")){
            request.setAttribute("errmsg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        } else {
            Insurer insurer = new Insurer();
            insurer.setUsername(username);
            UserServer userServer = new UserServer(insurer);

            try {
                insurer.setId(userServer.loadByUsername().getId());
            } catch (InsCorpException e) {
//                String errorMsg = new String(e.getMessage().getBytes(), "UTF-8");
                request.setAttribute("errmsg", e.getMessage());
                RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                view.forward(request, response);
            }
            try {
                userServer.delete();
            } catch (InsCorpException e) {
                request.setAttribute("errmsg", e.getMessage());
                RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
                view.forward(request, response);
            }

            request.setAttribute("errmsg", "Застрахователният агент е изтрит!");
            RequestDispatcher view = request.getRequestDispatcher("admin/AdminPanelMsg.jsp");
            view.forward(request, response);
        }
    }
}
