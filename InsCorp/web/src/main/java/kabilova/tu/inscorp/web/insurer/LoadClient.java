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
@WebServlet("/loadClient")
public class LoadClient extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchByEgn = request.getParameter("searchEGN");

        System.out.println("1: " + request.getServletPath());

        Insured insured = new Insured();
        insured.setEgn(searchByEgn);
        InsuredServer insuredServer = new InsuredServer(insured);

        List<Insured> result = new ArrayList<>();
        result.add(insuredServer.loadByEgn());

        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/insurer/addNewMPS.jsp");
        rd.forward(request, response);

    }
}
