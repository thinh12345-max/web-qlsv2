<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Sinh Viên</title>
    <%@include file="../all_component/Bootstrap.jsp"%>
</head>
<body>
    <%@include file="../all_component/navbar.jsp"%>
    <div class="container mt-4">
        <h2>Thêm Sinh Viên Mới</h2>
        <form action="../addStudent" method="post">
            <div class="mb-3">
                <label for="tenSV" class="form-label">Tên Sinh Viên</label>
                <input type="text" class="form-control" id="tenSV" name="tenSV" required>
            </div>
            <div class="mb-3">
                <label for="maHP" class="form-label">Mã Học Phần</label>
                <input type="number" class="form-control" id="maHP" name="maHP" required>
            </div>
            <button type="submit" class="btn btn-primary">Thêm</button>
        </form>
    </div>
</body>
</html>
