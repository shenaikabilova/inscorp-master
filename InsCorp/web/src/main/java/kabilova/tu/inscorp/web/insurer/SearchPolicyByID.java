package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.policy.GO;
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
@WebServlet(urlPatterns = {"/searchGOByID", "/searchKaskoByID"})
public class SearchPolicyByID extends HttpServlet {
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String policyID = request.getParameter("searchByID");
        if(policyID.trim().equals("")) {
            request.setAttribute("msg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        } else {
            PolicyServer policyServer;
            RequestDispatcher rd = null;

            if (request.getServletPath().equals("/searchGOByID")) {
                GO go = new GO();
                go.setPolicaID(policyID);
                policyServer = new PolicyServer(go);
                request.setAttribute("result", policyServer.getPolicyByPolicyNum());
                rd = request.getRequestDispatcher("insurer/searchGOByIdResult.jsp");
            } else if (request.getServletPath().equals("/searchKaskoByID")) {
                Kasko kasko = new Kasko();
                kasko.setPolicaID(policyID);
                policyServer = new PolicyServer(kasko);
                request.setAttribute("result", policyServer.getPolicyByPolicyNum());
                rd = request.getRequestDispatcher("insurer/searchKaskoByIdResult.jsp");
            }

            rd.forward(request, response);
        }
    }
}
