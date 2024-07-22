package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Doa.UserDao;
import Model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao dao;

    public UserController() {
        super();
        dao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String forward = "";

        if (action != null) {
            switch (action.toLowerCase()) {
                case "delete":
                    int userId = Integer.parseInt(request.getParameter("userId"));
                    dao.deleteUser(userId);
                    forward = "/user-list.jsp";
                    request.setAttribute("users", dao.getAllUsers());
                    break;
                case "edit":
                    forward = "/user-form.jsp";
                    int editUserId = Integer.parseInt(request.getParameter("userId"));
                    User user = dao.getUserById(editUserId);
                    request.setAttribute("user", user);
                    break;
                case "listuser":
                    forward = "/user-list.jsp";
                    request.setAttribute("users", dao.getAllUsers());
                    break;
                default:
                    forward = "/user-form.jsp";
                    break;
            }
        } else {
            forward = "/user-form.jsp";
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        user.setPassword(request.getParameter("password")); // Ensure this is correct

        String userId = request.getParameter("userid");
        if (userId == null || userId.isEmpty()) {
            dao.addUser(user);
            System.out.println("User is added");
        } else {
            user.setId(Integer.parseInt(userId));
            dao.updateUser(user);
            System.out.println("User is updated");
        }

        // Redirect to the user list after saving/updating
        RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);
    }
}
