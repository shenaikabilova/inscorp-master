package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.policy.GO;
import kabilova.tu.inscorp.model.policy.Policy;
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
@WebServlet("/searchGOUpdate")
public class SearchGOUpdate extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String policyID = request.getParameter("searchGOByID");
        GO go = new GO();
        go.setPolicaID(policyID);
        PolicyServer policyServer = new PolicyServer(go);

        request.setAttribute("policy", policyServer.getPolicyByPolicyNum());
        RequestDispatcher view = request.getRequestDispatcher("insurer/insurerGoUpdate.jsp");
        view.forward(request, response);
    }
}