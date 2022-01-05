/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu.impl;

import com.nmt.dichvu.DichVuThongKe;
import com.nmt.kho.KhoThongKe;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class DichVuThongKeImpl implements DichVuThongKe{

    @Autowired
    private KhoThongKe khoThongKe;
    
    @Override
    public List<Object[]> thongKeLoai() {
        return this.khoThongKe.thongKeLoai();
    }

    @Override
    public List<Object[]> thongKeSanPham(String kw, Date fromDate, Date toDate) {
        return this.khoThongKe.thongKeSanPham(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> tkeSanPhamThang(String string, Date date, Date date1) {
        return this.khoThongKe.tkeSanPhamThang(string, date, date1);
    }
    
}
