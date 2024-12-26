package DangNhap;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAOImpl;
import com.DB.DBConnect;

@WebServlet("/delete")
public class Delete extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int maHP = Integer.parseInt(request.getParameter("MaHP"));
        
        Connection conn = DBConnect.getConn();
        UserDAOImpl dao = new UserDAOImpl(conn);
        boolean isDeleted = dao.deleteSV(maHP);
        
        if (isDeleted) {
            response.sendRedirect("GiangVienHome.jsp"); 
        } else {
            response.sendRedirect("GiangVienHome.jsp");
        }
    }
}


