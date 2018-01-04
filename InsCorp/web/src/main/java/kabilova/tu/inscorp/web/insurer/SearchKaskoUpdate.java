package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.policy.Kasko;
import kabilova.tu.inscorp.server.web.PolicyServer;

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
@WebServlet("/searchKaskoUpdate")
public class SearchKaskoUpdate extends HttpServlet{
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String policyID = request.getParameter("searchKaskoByID");
        if(policyID.trim().equals("")) {
            request.setAttribute("msg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        } else {
            Kasko kasko = new Kasko();
            kasko.setPolicaID(policyID);
            PolicyServer policyServer = new PolicyServer(kasko);

            request.setAttribute("policy", policyServer.getPolicyByPolicyNum());
            RequestDispatcher view = request.getRequestDispatcher("insurer/insurerKaskoUpdate.jsp");
            view.forward(request, response);
        }
    }
}
