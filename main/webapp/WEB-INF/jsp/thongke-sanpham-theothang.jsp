<%-- 
    Document   : thongke-sanpham-theothang
    Created on : 13 thg 11, 2021, 20:15:58
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 class="text-center text-danger">THỐNG KÊ DOANH THU THEO THÁNG</h2>

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
  <canvas id="myProMonthStatsChart"></canvas>
</div>

<table class="table text-white">
    <tr>
        <th>Tháng</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${tkSanPhamThang}" var="s">
        <tr>
            <td>${s[0]}/${s[1]}</td>
            <td>${s[2]} VND</td>
        </tr>
    </c:forEach>
</table>

<script>
    let proLabels=[], proInfo=[];
    
    <c:forEach items="${tkSanPhamThang}" var="p">
        proLabels.push('${p[0]}/${p[1]}')
        proInfo.push(${p[2]})
    </c:forEach>
        
    window.onload = function(){
        cateChart("myProMonthStatsChart", proLabels, proInfo)
    }
</script>
