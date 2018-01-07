package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.server.web.InsuredServer;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/deleteInsured")
public class DeleteInsured extends HttpServlet{
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String egn = request.getParameter("clientEGN");
        if(egn.trim().equals("")) {
            request.setAttribute("msg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        } else {
            Insured insured = new Insured();
            insured.setEgn(egn);

            InsuredServer insuredServer = new InsuredServer(insured);
            try {
                insured.setId(insuredServer.loadByEgn().getId());
            } catch (InsCorpException e) {
//                String errorMsg = new String(e.getMessage().getBytes(), "UTF-8");
                request.setAttribute("msg", e.getMessage());
                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                view.forward(request, response);
            }
            try {
                insuredServer.delete();

                request.setAttribute("msg", "Успешно изтриване");
                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                view.forward(request, response);

            } catch (InsCorpException e) {
//                String errorMsg = new String(e.getMessage().getBytes(), "UTF-8");
                request.setAttribute("msg", e.getMessage());
                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                view.forward(request, response);
            }
        }
    }
}
