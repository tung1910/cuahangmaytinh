<%--
    Document   : product
    Created on : 30 thg 8, 2021, 16:34:45
    Author     : hp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<br><br>

<h1 class="text-center text-danger">QUẢN LÝ SẢN PHẨM</h1>

<c:url value="/admin/sanphams" var="action" />

<form:form method="post" action="${action}" modelAttribute="sanpham" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div" />
    
    <div class="form-group">
        <label for="tenSP">Tên sản phẩm</label>
        <form:input type="text" id="tenSP" path="tenSP" cssClass="form-control" />
        <form:errors path="tenSP" cssClass="text-danger" element="div" />
    </div>
    <div class="form-group">
        <label for="moTa">Mô tả</label>
        <form:textarea id="moTa" path="moTa" cssClass="form-control" ></form:textarea>
    </div>
    <div class="form-group">
        <label for="soLuongTon">Số Lượng</label>
        <form:input type="text" id="soLuongTon" path="soLuongTon" cssClass="form-control" />
        <form:errors path="soLuongTon" cssClass="text-danger" element="div" />
    </div>
    <div class="form-group">
        <label for="baoHanh">Bảo Hành</label>
        <form:input type="text" id="baoHanh" path="baoHanh" cssClass="form-control" />
        <form:errors path="baoHanh" cssClass="text-danger" element="div" />
    </div>
    <div class="form-group">
        <label for="donGia">Giá</label>
        <form:input type="text" id="donGia" path="donGia" cssClass="form-control" />
        <form:errors path="donGia" cssClass="text-danger" element="div" />
    </div>
    <div class="form-group">
        <label for="loaihang">Loại Hàng</label>
        <form:select id="loaihang" path="loaihang" cssClass="form-control">
            <c:forEach var="lh" items="${loaihangs}" >
                <option value="${lh.maLH}">${lh.tenLH}</option>
            </c:forEach>
        </form:select>
        <form:errors path="loaihang" cssClass="text-danger" element="div" />
    </div>
    <div class="form-group">
        <label for="file">Ảnh sản phẩm</label>
        <form:input type="file" id="file" path="file" cssClass="form-control" />
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm sản phẩm" class="btn btn-danger" />
    </div>
</form:form>