<%-- 
    Document   : dangnhap
    Created on : 21 thg 10, 2021, 18:12:17
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="<c:url value="/css/d3.css" />" rel="stylesheet"/> 
<hr>

<h1 class="text-center text-danger">Đăng Nhập</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">Đã có lỗi xảy ra! Vui lòng quay lại sau!</div>
</c:if>
<c:if test="${param.accessDenied != null}">
    <div class="alert alert-danger">
        Bạn không có quyền truy cập!!!
    </div>
</c:if>

<c:url value="/dangnhap" var="action" />

<form method="post" action="${action}" src="<c:url value="/img/MNT.png"/>">
    <div class="imgcontainer">
        <img src="<c:url value="/img/img_avatar2.png"/>" alt="Avatar" class="avatar">
    </div>
    <label for="tenDN"><b>Tên Đăng Nhập</b></label>
    <input type="text" id="tenDN" placeholder="Nhập tên đăng nhập" name="tenDN" required />

    <label for="matKhau"><b>Mật khẩu</b></label>
    <input type="password" id="tenDN" placeholder="Nhập mật khẩu" name="matKhau" required />
    <button type="submit">Đăng Nhập</button>
    <div class="container">
        <label></label>
        <span class="psw">Bạn chưa <a href="<c:url value="/dangky"/>">có tài khoản?</a></span>
    </div>
</form>