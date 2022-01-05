<%-- 
    Document   : thongke-loaihang
    Created on : 12 thg 11, 2021, 19:48:02
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h2 class="text-center text-danger">THỐNG KÊ SẢN PHẨM THEO LOẠI</h2>

<div>
  <canvas id="myCateStatsChart"></canvas>
</div>

<table class="table text-white">
    <tr>
        <th>Mã loại hàng</th>
        <th>Tên loại hàng</th>
        <th>Số lượng sản phẩm</th>
    </tr>
    <c:forEach items="${thongKeLoai}" var="t">
        <tr class="text-white">
            <td>${t[0]}</td>
            <td>${t[1]}</td>
            <td>${t[2]}</td>
        </tr>
    </c:forEach>
</table>

<script>
    let cateLabels=[], cateInfo=[];
    
    <c:forEach items="${thongKeLoai}" var="t">
        cateLabels.push('${t[1]}')
        cateInfo.push(${t[2]})
    </c:forEach>
        
    window.onload = function(){
        cateChart("myCateStatsChart", cateLabels, cateInfo)
    }
</script>