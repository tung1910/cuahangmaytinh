/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu.impl;

import com.nmt.csdl.GioHang;
import com.nmt.dichvu.DichVuHoaDon;
import com.nmt.kho.KhoHoaDon;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class DichVuHoaDonImpl implements DichVuHoaDon{
    
    @Autowired
    private KhoHoaDon khoHoaDon;

    @Override
    public boolean addDonHang(Map<Integer, GioHang> giohang) {
        if(giohang != null)
            return this.khoHoaDon.addDonHang(giohang);
        
        return false;
    }
    
}
