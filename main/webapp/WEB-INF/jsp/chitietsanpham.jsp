<%-- 
    Document   : chitietsanpham
    Created on : 27 thg 9, 2021, 11:29:27
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="<c:url value="/css/style.css"/>" rel="stylesheet"/> 
<br><br>

<h1 class="text-center text-danger">Chi Tiết Sản Phẩm</h1>

<div class="row">
        <div class="col-md-6 content">
            <c:choose>
                <c:when test="${sanpham.hinhSP != null && sanpham.hinhSP.startsWith('https') == true}">
                    <img class="card-img-top img-fluid" src="<c:url value="${sanpham.hinhSP}" />" alt="${sanpham.tenSP}" />
                </c:when>
                <c:when test="${sanpham.hinhSP == null || sanpham.hinhSP.startsWith('https') == false}">
                    <img class="card-img-top img-fluid" src="<c:url value="/img/vsmart.png" />" alt="${sanpham.tenSP}" />
                </c:when>
            </c:choose>
        </div>
        <div class="col-md-6">
            <h2>${sanpham.tenSP}</h2>
            <h3 class="text-danger">${sanpham.donGia} VND</h3>
            <a>${sanpham.moTa}</a>
            <hr>
            <b>Bảo hành: ${sanpham.baoHanh} tháng</b>
            <br><br><br>
            <div>
                <input type="button" onclick="addToGioHang(${sanpham.maSP}, '${sanpham.tenSP}', ${sanpham.donGia})" value="Thêm vào giỏ" class="btn btn-danger" />
            </div>
        </div>
</div>
<br><br>
<form>
    <div class="form-group">
        <textarea class="form-control" id="maDG" placeholder="Nhập đánh giá của bạn"></textarea>
        <br>
        <input type="submit" onclick="addDanhGia(${sanpham.maSP})" 
               value="Gửi bình luận" class="btn btn-danger" />
    </div>
</form>        

<div id="khuvucBL">
    <c:forEach var="bl" items="${sanpham.danhGias}" >
        <div class="row">
            <div class="col-md-2">
                <img class="rounded-circle img-fluid" src="<c:url value="/img/vsmart.png" />"/>
            </div>
            <div class="col-md-10 my-date">
                <p class="text-white">${bl.binhLuan}</p>
                <i>${bl.ngayDang}</i>
            </div>
        </div>
    </c:forEach>
</div>
<br><br>

<script>
    window.onload = function () {
        let dates = document.querySelectorAll(".my-date > i")
        for (let i = 0; i < dates.length; i++) {
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow()
        }
    }
</script>