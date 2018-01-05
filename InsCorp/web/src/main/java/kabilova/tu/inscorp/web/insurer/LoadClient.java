package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.user.Insured;
import kabilova.tu.inscorp.server.web.InsuredServer;

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
@WebServlet(urlPatterns = {"/loadClient", "/loadInsuredForUpdate"})
public class LoadClient extends HttpServlet {
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchByEgn = request.getParameter("searchEGN");

        if(searchByEgn.trim().equals("")) {
            request.setAttribute("msg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        } else {
            Insured insured = new Insured();
            insured.setEgn(searchByEgn);
            InsuredServer insuredServer = new InsuredServer(insured);

            request.setAttribute("result", insuredServer.loadByEgn());
            RequestDispatcher rd = null;
            if(request.getServletPath().equals("/loadClient")) {
                rd = request.getRequestDispatcher("insurer/addNewMPS.jsp");
            }
            else if(request.getServletPath().equals("/loadInsuredForUpdate")) {
                rd = request.getRequestDispatcher("insurer/updateInsured.jsp");
            }
            rd.forward(request, response);
        }
    }
}
