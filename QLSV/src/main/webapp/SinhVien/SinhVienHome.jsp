<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet"%>
<%@ page import="com.DB.DBConnect"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sinh Viên</title>
    <%@include file="../all_component/Bootstrap.jsp"%>
</head>
<body>
    <%@include file="../all_component/navbar.jsp"%>
    <div class="container">
        <h2 class="mt-4">Danh Sách Sinh Viên</h2>
        <table class="table table-striped">
            <thead class="bg-info text-white">
                <tr>
                    <th>ID</th>
                    <th>Tên Sinh Viên</th>
                    <th>Mã Học Phần</th>
                    <th>Tên Học Phần</th>
                    <th>Tên Giảng Viên</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Connection connection = DBConnect.getConn();
                    String sql = "SELECT sinhvien.id AS ID, sinhvien.TenSV AS TenSV, " +
                                 "giangvien.MaHP AS MaHP, giangvien.TenHP AS TenHP, giangvien.TenGV AS TenGV " +
                                 "FROM sinhvien " +
                                 "INNER JOIN giangvien ON sinhvien.MaHP = giangvien.MaHP";
                    try (PreparedStatement pst = connection.prepareStatement(sql);
                         ResultSet rs = pst.executeQuery()) {
                        boolean hasData = false;
                        while (rs.next()) {
                            hasData = true;
                %>
                <tr>
                    <td><%= rs.getInt("ID") %></td>
                    <td><%= rs.getString("TenSV") %></td>
                    <td><%= rs.getInt("MaHP") %></td>
                    <td><%= rs.getString("TenHP") %></td>
                    <td><%= rs.getString("TenGV") %></td>
                </tr>
                <%
                        }
                        if (!hasData) {
                %>
                <tr>
                    <td colspan="5" class="text-center">Không có sinh viên liên quan.</td>
                </tr>
                <%
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                %>
                <tr>
                    <td colspan="5" class="text-center text-danger">Lỗi khi tải dữ liệu.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        
    </div>
    <a href="add_student.jsp" class="btn btn-primary mb-3">Thêm Sinh Viên</a>
</body>
</html>