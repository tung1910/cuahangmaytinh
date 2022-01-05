/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho;

import java.util.Date;
import java.util.List;

/**
 *
 * @author hp
 */
public interface KhoThongKe {
    List<Object[]> thongKeLoai();
    List<Object[]> thongKeSanPham(String kw, Date fromDate, Date toDate);
    List<Object[]> tkeSanPhamThang(String kw, Date fromDate, Date toDate);
}
