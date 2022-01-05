<%-- 
    Document   : header
    Created on : 28 thg 8, 2021, 20:35:19
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="<c:url value="/css/w3.css" />" rel="stylesheet"/> 


<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" style="display:none;z-index:2;width:30%;min-width:250px" id="mySidebar">
    <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button text-body">Đóng Menu</a>
    <c:forEach var="lh" items="${loaihangs}">
        <c:url value="/" var="lhP">
            <c:param name="MaLH" value="${lh.maLH}"></c:param>
        </c:url>
        <a class="w3-bar-item text-body" href="${lhP}">${lh.tenLH}</a> 
    </c:forEach>
</nav>

<div class="w3-top w3-auto" style="max-width:1110px">
    <div class="w3-bar w3-white w3-wide w3-padding-10 w3-card">
        <a href="<c:url value="/"/>" class="w3-bar-item w3-button"><i class="fa fa-home w3-margin-right"></i><b>NMT</b> Gaming</a>
        <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
            <div class="w3-button w3-padding-5 w3-right" onclick="w3_open()">☰</div>
        </div>
        <div class="w3-right w3-hide-small">
            <a href="<c:url value="/giohang" />" class="w3-button w3-padding-large" >
                <i class="fas fa-cart-arrow-down"></i>
                <div class="w3-badge w3-right w3-small w3-red" id="cartCounter">${cartCounter}</div>
            </a>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="w3-bar-item active">
                    <a class="fa fa-user text-danger" href="<c:url value="/dangnhap"/> ">Đăng nhập</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="w3-bar-item active">
                    <a href="<c:url value="/"/> ">
                        <c:if test="${nguoiDungHienTai.hinhDD != null}">
                            <img style="width:30px;" src="${nguoiDungHienTai.hinhDD}" class="rounded-circle"/>
                        </c:if>
                        <c:if test="${nguoiDungHienTai.hinhDD == null}">
                            <i class="fa fa-user" aria-hidden="true"></i>
                        </c:if>
                        ${pageContext.request.userPrincipal.name}
                    </a>
                </li>
                <li class="w3-bar-item active">
                    <a class="w3-bar text-danger" href="<c:url value="/logout"/> ">Đăng xuất</a>
                </li>
            </c:if>
        </div>
    </div>
</div>

