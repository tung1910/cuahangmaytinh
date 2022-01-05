<%-- 
    Document   : index
    Created on : 6 thg 9, 2021, 09:38:36
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link href="<c:url value="/css/style.css"/>" rel="stylesheet"/> 
<hr>
<header class="w3-display-container w3-content w3-wide" style="max-width:1500px;" id="home">
    <div id="demo" class="carousel slide" data-ride="carousel">
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1"></li>
            <li data-target="#demo" data-slide-to="2"></li>
        </ul>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="card-img-top img-fluid" src="<c:url value="/img/demo1.png" />" alt="ASUS"> 
            </div>
            <div class="carousel-item">
                <img class="card-img-top img-fluid" src="<c:url value="/img/demo2.png" />" alt="TUF GAMING">  
            </div>
            <div class="carousel-item">
                <img class="card-img-top img-fluid" src="<c:url value="/img/demo3.png" />" alt="HP">  
            </div>
        </div>
        <a class="carousel-control-prev" href="#demo" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#demo" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
    <hr>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div>
            <a href="<c:url value="/admin/sanphams"/>" class="btn btn-danger">Quản lý sản phẩm</a>
            <a href="<c:url value="/admin/thongke-loaihang"/>" class="btn btn-danger">Thống kê báo cáo</a>
        </div>
    </sec:authorize>
</header>

<form action="" id="sanpham">
    <div class="row">
        <div class="col-md-11">
            <input class="form-control" style="height: 107%" type="text" name="kw" placeholder="Nhập từ khóa để tìm kiếm"/>
        </div>
        <div>
            <input type="submit" value="Tìm" class="btn btn-danger"/>
        </div>
    </div>
</form>


<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(counter/9)}" var="i">
            <li class="page-item"><a class="page-link" href="<c:url value="/" />?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</div>

<div class="row">
    <c:forEach var="s" items="${sanphams}">
        <div class="col-md-4 col-xs-12">
            <div class="card content" style="width:100%; height: 100%">
                <a href="<c:url value="/sanphams/${s.maSP}"/>" style="height: 250px">
                    <c:choose>
                        <c:when test="${s.hinhSP != null && s.hinhSP.startsWith('https') == true}">                    
                            <img class="img-fluid" width="460" height="345" src="<c:url value="${s.hinhSP}" />" alt="${s.tenSP}" />
                        </c:when>

                        <c:when test="${s.hinhSP == null || s.hinhSP.startsWith('https') == false}">
                            <img class="img-fluid" width="460" height="345" src="<c:url value="/img/vsmart.png" />" alt="${s.tenSP}" />
                        </c:when>
                    </c:choose>
                </a>
                <div class="card-body">
                    <h6 class="card-title text-body">${s.tenSP}</h6>
                    <p class="card-text text-body">${s.donGia} VND</p>
                    <div class="text-center" >
                        <a href="<c:url value="/sanphams/${s.maSP}" />" class="btn btn-primary">Mua Ngay</a>
                        <a href="#" class="btn btn-primary" onclick="addToGioHang(${s.maSP}, '${s.tenSP}', ${s.donGia})">Thêm vào giỏ</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>    
</div>
<hr><hr>
<div class="alert alert-success" id="banchay">
    <h2>Các Sản Phẩm Bán Chạy</h2>
</div>
<hr>
<div class="row">
    <c:forEach var="s" items="${hotSanPhams}">
        <div class="col-md-4 col-xs-12">
            <div class="card content">
                <a href="<c:url value="/sanphams/${s[0]}" />" style="height: 250px">
                    <c:choose>
                        <c:when test="${s[3] != null && s[3].startsWith('https') == true}">
                            <img class="card-img-top img-fluid" src="<c:url value="${s[3]}" />" alt="${s[1]}" />
                        </c:when>

                        <c:when test="${s[3] == null || s[3].startsWith('https') == false}">
                            <img class="card-img-top img-fluid" src="<c:url value="/img/vsmart.png" />" alt="${s[1]}" />
                        </c:when>
                    </c:choose>
                </a>

                <div class="card-body">
                    <h6 class="card-title text-body">${s[1]}</h6>
                    <p class="card-text text-body">${s[2]} VND</p>
                    <p class="text-danger">Số lượt mua: ${s[4]}</p>
                    <div>
                        <a href="<c:url value="/sanphams/${s[0]}" />" class="btn btn-primary">Mua Ngay</a>
                        <a href="#" class="btn btn-primary" onclick="addToGioHang(${s[0]}, '${s[1]}', ${s[2]})" >Thêm vào giỏ</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>    
</div>
<hr><hr>
<div class="alert alert-success" id="quantam">
    <h2>Các Sản Phẩm Hot Nhất</h2>
</div>
<hr>
<div class="row">
    <c:forEach var="s" items="${disSanPhams}">
        <div class="col-md-4 col-xs-12">
            <div class="card content">
                <a href="<c:url value="/sanphams/${s[0]}" />" style="height: 250px">
                    <c:choose>
                        <c:when test="${s[3] != null && s[3].startsWith('https') == true}">
                            <img class="card-img-top img-fluid" src="<c:url value="${s[3]}" />" alt="${s[1]}" />
                        </c:when>

                        <c:when test="${s[3] == null || s[3].startsWith('https') == false}">
                            <img class="card-img-top img-fluid" src="<c:url value="/img/vsmart.png" />" alt="${s[1]}" />
                        </c:when>
                    </c:choose>
                </a>

                <div class="card-body">
                    <h6 class="card-title text-body">${s[1]}</h6>
                    <p class="card-text text-body">${s[2]} VND</p>
                    <p class="text-danger">Số lượt bình luận: ${s[4]}</p>
                    <div>
                        <a href="<c:url value="/sanphams/${s[0]}" />" class="btn btn-primary">Mua Ngay</a>
                        <a href="#" class="btn btn-primary" onclick="addToGioHang(${s[0]}, '${s[1]}', ${s[2]})" >Thêm vào giỏ</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>    
</div>