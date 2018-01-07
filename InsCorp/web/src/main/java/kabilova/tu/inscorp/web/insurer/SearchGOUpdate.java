package kabilova.tu.inscorp.web.insurer;

import kabilova.tu.inscorp.model.exception.InsCorpException;
import kabilova.tu.inscorp.server.web.PolicyGOServer;
import kabilova.tu.inscorp.server.web.PolicyServer;
import kabilova.tu.inscorp.model.policy.GO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

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
        boolean canUpdate = false;
        if(policyID.trim().equals("")) {
            request.setAttribute("msg", "Моля, попълнете всички полета!");
            RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
            view.forward(request, response);
        } else {
            GO go = new GO();
            go.setPolicaID(policyID);
            PolicyGOServer policyServer = new PolicyGOServer(go);

            try {
                go.setId(policyServer.getPolicyByPolicyNum().getId());
                go.setInsured(policyServer.getPolicyByPolicyNum().getInsured());
            } catch (InsCorpException e) {
                request.setAttribute("msg", e.getMessage());
                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                view.forward(request, response);
            }

            for( GO p : policyServer.loadActivePoliciesGO(go.getInsured(), Calendar.getInstance())) {
                if(p.getId() != go.getId()) {
                    canUpdate = true;
                    break;
                }
            }

            if(canUpdate) {
                try {
                    request.setAttribute("policy", policyServer.getPolicyByPolicyNum());
                } catch (InsCorpException e) {
                    request.setAttribute("msg", e.getMessage());
                    RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                    view.forward(request, response);
                }
                RequestDispatcher view = request.getRequestDispatcher("insurer/insurerGoUpdate.jsp");
                view.forward(request, response);
            } else {
                request.setAttribute("msg", "Не може да се редактира изтекла полица!");
                RequestDispatcher view = request.getRequestDispatcher("insurer/Msg.jsp");
                view.forward(request, response);
            }
        }
    }
}