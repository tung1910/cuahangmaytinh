/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu.impl;

import com.nmt.csdl.LoaiHang;
import com.nmt.dichvu.DichVuLoaiHang;
import com.nmt.kho.KhoLoaiHang;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class DichVuLoaiHangImpl implements DichVuLoaiHang{
    
    @Autowired
    private KhoLoaiHang khoLoaiHang;
    
    @Override
    public List<LoaiHang> getLoaiHangs() {
        return this.khoLoaiHang.getLoaiHangs();
    }    

    @Override
    public LoaiHang getLoaiHangTheoMa(int maLH) {
        
        return this.khoLoaiHang.getLoaiHangTheoMa(maLH);
    }
    
}
