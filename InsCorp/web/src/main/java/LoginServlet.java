import kabilova.tu.inscorp.web.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ShenaiKabilova
 */
@WebServlet(urlPatterns = {"/login", "/adminLogin"})
public class LoginServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Login login = new Login();
//        try {
//            UserDao dao = new UserDaoImpl();
//            if(dao.loadUser(username, password) instanceof Admin) {
//                Cookie loginCookie = new Cookie("user", username);
//                loginCookie.setMaxAge(60*60*24);
//                response.addCookie(loginCookie);
//                response.sendRedirect("admin/addStudent.jsp");
////                RequestDispatcher view = request.getRequestDispatcher("admin/addStudent.jsp");
////                view.forward(request, response);
//            } else if (dao.loadUser(username, password) instanceof Student){
////                Cookie loginCookie = new Cookie("user", username);
////                loginCookie.setMaxAge(60*60*24);
////                response.addCookie(loginCookie);
////                response.sendRedirect("student/AfterLogin.jsp");
//
//                HttpSession session = request.getSession(true);
//                session.setAttribute("username", username);
//                session.setAttribute("password", password);
//                response.sendRedirect("student/AfterLogin.jsp");
//            } else {
//                RequestDispatcher view = request.getRequestDispatcher("student/login.jsp");
//                view.forward(request, response);
//            }
//        } catch (IllegalArgumentException e) {
//            //TODO изведи грешката на подходящо място
//            RequestDispatcher view = request.getRequestDispatcher("adminLoginPanel.jsp");
//            view.forward(request, response);
        }
}
