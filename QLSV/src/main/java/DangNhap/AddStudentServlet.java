package DangNhap;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DB.DBConnect;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String tenSV = request.getParameter("tenSV");
        String maHP = request.getParameter("maHP");

        try {
            Connection connection = DBConnect.getConn();
            String sql = "INSERT INTO sinhvien (TenSV, MaHP) VALUES (?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, tenSV);
            pst.setInt(2, Integer.parseInt(maHP));

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                request.getSession().setAttribute("successMsg", "Thêm sinh viên thành công!");
            } else {
                request.getSession().setAttribute("errorMsg", "Thêm sinh viên thất bại!");
            }
            response.sendRedirect("SinhVien/SinhVienHome.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("errorMsg", "Lỗi khi thêm sinh viên!");
            response.sendRedirect("SinhVIen/add_student.jsp");
        }
    }
}
