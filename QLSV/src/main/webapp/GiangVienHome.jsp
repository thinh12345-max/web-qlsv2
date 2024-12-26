<%@ page import="java.sql.Connection"%>
<%@ page import="java.util.List"%>
<%@ page import="DAO.UserDAOImpl"%>
<%@ page import="US.User"%>
<%@ page import="com.DB.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sách Sinh Viên</title>
<%@include file="all_component/Bootstrap.jsp"%>
</head>
<body>

	<%@include file="all_component/navbar.jsp"%>
	<%
	Connection connection = DBConnect.getConn();
	UserDAOImpl dao = new UserDAOImpl(connection);
	User user = (User) session.getAttribute("userobj");
	List<User> list = null;
	if (user != null) {
		list = dao.getGiangVienSinhVienList(user.getMaHP());
	} else {
		session.setAttribute("failedMsg", "Bạn chưa đăng nhập.");
		response.sendRedirect("login.jsp");
		return;
	}
	%>

	<table class="table table-striped">
		<thead class="bg-info text-white">
			<tr>
				<th scope="col">Mã Học Phần</th>
				<th scope="col">Tên Học Phần</th>
				<th scope="col">Tên Giảng Viên</th>
				<th scope="col">Tên Sinh Viên</th>
				<th scope="col">Xoá Sinh Viên</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (list != null && !list.isEmpty()) {
				for (User u : list) {
			%>
			<tr>
				<th scope="row"><%=u.getMaHP()%></th>
				<td><%=u.getTenHP()%></td>
				<td><%=u.getTenGV()%></td>
				<td><%=u.getTenSV()%></td>
				<td><a href="delete?MaHP=<%=u.getMaHP()%>" class="btn btn-sm btn-danger">Delete</a></td>
			</tr>
			<%
			}
			} else {
			%>
			<tr>
				<td colspan="5" class="text-center">Không có sinh viên liên
					quan.</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>
