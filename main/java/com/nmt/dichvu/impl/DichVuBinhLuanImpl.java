/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu.impl;

import com.nmt.csdl.DanhGia;
import com.nmt.csdl.SanPham;
import com.nmt.csdl.TaiKhoan;
import com.nmt.dichvu.DichVuBinhLuan;
import com.nmt.kho.KhoBinhLuan;
import com.nmt.kho.KhoSanPham;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nmt.kho.KhoTaiKhoan;

/**
 *
 * @author hp
 */
@Service
public class DichVuBinhLuanImpl implements DichVuBinhLuan{
    
    @Autowired
    private KhoSanPham khoSanPham;
    
//    @Autowired
//    private KhoTaiKhoan khoTaiKhoan;
    
    @Autowired
    private KhoBinhLuan khoBinhLuan;

    @Override
    public DanhGia addDanhGia(String binhLuan, int maSP, TaiKhoan nguoiTao) {
        SanPham s = this.khoSanPham.getSanPhamTheoMa(maSP);
//        TaiKhoan t = this.khoTaiKhoan.getTaiKhoanTheoMa(7);
        
        DanhGia d = new DanhGia();
        d.setBinhLuan(binhLuan);
        d.setMaSP(s);
        d.setMaTK(nguoiTao);
        d.setNgayDang(new Date());
        
        return this.khoBinhLuan.addDanhGia(d);
    }
    
}
