<%-- 
    Document   : admin-trai
    Created on : 12 thg 11, 2021, 18:27:54
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar bg-dark">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/thongke-loaihang"/>">Thống kê sản phẩm theo loại</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/thongke-sanpham"/>">Thống kê doanh thu theo sản phẩm</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/thongke-sanpham-theothang"/>">Thống kê doanh thu theo thời gian</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/"/>">Trang Chủ</a>
    </li>
  </ul>

</nav>
