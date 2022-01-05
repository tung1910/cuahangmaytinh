<%-- 
    Document   : dangky
    Created on : 2 thg 11, 2021, 16:27:15
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="<c:url value="/css/k3.css" />" rel="stylesheet"/> 
<hr>

<h1 class="text-center text-danger">Đăng Ký</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/dangky" var="action" />

<form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="taikhoan">
    <div class="container">
        <p>Vui lòng điền vào biểu mẫu này để tạo một tài khoản.</p>
        <hr>
        <label for="hoTen">Họ và Tên</label>
        <input type="text" id="hoTen" path="hoTen" class="form-control" placeholder="Nhập họ tên không dấu" required/>
        
        <label for="tenDN">Tên đăng nhập</label>
        <input type="text" id="tenDN" path="tenDN" class="form-control" placeholder="Nhập tên đăng nhập" required/>
        
        <label for="matKhau">Mật khẩu</label>
        <input type="password" id="matKhau" path="matKhau" class="form-control" placeholder="Nhập mật khẩu" required/>
        
        <label for="xacNhanMK">Xác Nhận Mật khẩu</label>
        <input type="password" id="xacNhanMK" path="xacNhanMK" class="form-control" placeholder="Lập lại mật khẩu" required/>
        
        <label for="email">Email</label>
        <input type="email" id="email" path="email" class="form-control" placeholder=" Nhập email" required/>
        
        <label for="hinhDD">Hình Đại Diện</label>
        <input type="file" id="hinhDD" path="file" class="form-control" required/>

       <button type="submit">Đăng Ký</button>
    </div>
</form>