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

/**
 * Created by ShenaiKabilova
 */
@WebServlet("/loadInsuredForUpdate")
public class LoadInsuredForUpdate extends HttpServlet{
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchByEgn = request.getParameter("searchEGN");

        System.out.println("1: " + request.getServletPath());

        Insured insured = new Insured();
        insured.setEgn(searchByEgn);
        InsuredServer insuredServer = new InsuredServer(insured);

        request.setAttribute("result", insuredServer.loadByEgn());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/insurer/updateInsured.jsp");
        rd.forward(request, response);
    }
}
