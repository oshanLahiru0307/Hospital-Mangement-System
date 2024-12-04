package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Doa.doctorDao;
import Model.Doctor;
import Model.User;

/**
 * Servlet implementation class DoctorController
 */
@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private doctorDao docDao;  
	
    public DoctorController() {
        super();
        docDao = new doctorDao();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		String forward = "";
		
		if (action != null) {
            switch (action.toLowerCase()) {
                case "delete":
                    int userId = Integer.parseInt(request.getParameter("userId"));
                    docDao.deleteDoctor(userId);
                    forward = "/DoctorList.jsp";
                    request.setAttribute("users", docDao.getAllDoctors());
                    break;
                case "edit":
                    forward = "/EditRegistration.jsp";
                    int editUserId = Integer.parseInt(request.getParameter("userId"));
                    Doctor doctor = docDao.getDoctorById(editUserId);
                    request.setAttribute("user", doctor);
                    break;
                case "listuser":
                    forward = "/DoctorList.jsp";
                    request.setAttribute("doctors", docDao.getAllDoctors());
                    break;
                default:
                    forward = "/DoctorList.jsp";
                    break;
            }
        } else {
            forward = "/DoctorList.jsp";
        }
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Doctor doctor = new Doctor();
		doctor.setDoc_Name(request.getParameter("name"));
		doctor.setDoc_Email(request.getParameter("type"));
		doctor.setDoc_Email(request.getParameter("email"));
		doctor.setDoc_Email(request.getParameter("regid"));
		doctor.setDoc_Phone(request.getParameter("phone"));
		doctor.setDoc_Password(request.getParameter("password")); // Ensure this is correct

        String userId = request.getParameter("userid");
        if (userId == null || userId.isEmpty()) {
        	docDao.addDoctor(doctor);
            System.out.println("User is added");
        } else {
        	doctor.setDoc_Id(Integer.parseInt(userId));
            docDao.updateDoctor(doctor);
            System.out.println("User is updated");
        }

        // Redirect to the user list after saving/updating
        RequestDispatcher view = request.getRequestDispatcher("/DoctorList.jsp");
        request.setAttribute("doctors", docDao.getAllDoctors());
        view.forward(request, response);
    }
	
	
}


