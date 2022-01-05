<%-- 
    Document   : thongke-sanpham
    Created on : 13 thg 11, 2021, 16:15:22
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 class="text-center text-danger">THỐNG KÊ DOANH THU THEO SẢN PHẨM</h2>

<form action="">
    <div class="form-group">
        <label>Từ khóa</label>
        <input type="text" name="kw" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Từ ngày</label>
        <input type="date" name="fromDate" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Đến ngày</label>
        <input type="date" name="toDate" class="form-control"/>
    </div>
    <input type="submit" value="Báo cáo" class="btn btn-success"/>
</form>

<div>
  <canvas id="myProStatsChart"></canvas>
</div>

<table class="table text-white">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${thongKeSanPham}" var="k">
        <tr>
            <td>${k[0]}</td>
            <td>${k[1]}</td>
            <td>${k[2]} VND</td>
        </tr>
    </c:forEach>
</table>

<script>
    let proLabels=[], proInfo=[];
    
    <c:forEach items="${thongKeSanPham}" var="k">
        proLabels.push('${k[1]}')
        proInfo.push(${k[2]})
    </c:forEach>
        
    window.onload = function(){
        cateChart("myProStatsChart", proLabels, proInfo)
    }
</script>
