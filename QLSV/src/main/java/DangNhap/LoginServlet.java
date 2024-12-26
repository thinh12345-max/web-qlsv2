package DangNhap;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAOImpl;
import com.DB.DBConnect;
import US.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());

			HttpSession session = request.getSession();

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			if ("sinhvien@gmail.com".equals(email) && "sinhvien".equals(password)) {
				User us = new User();
				us.setTenGV("SinhVien");
				session.setAttribute("userobj", us);
				response.sendRedirect("SinhVien/SinhVienHome.jsp");
			} else {

				User us = dao.login(email, password);
				if (us != null) {
					session.setAttribute("userobj", us);
					response.sendRedirect("GiangVienHome.jsp");
				} else {
					session.setAttribute("failedMsg", "Email & Password Invalid");
					response.sendRedirect("login.jsp");
				}
			}

//			User us = new User();
//			us.setEmail(email);
//			us.setPassword(password);			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}