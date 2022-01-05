/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nmt.csdl.SanPham;
import com.nmt.dichvu.DichVuSanPham;
import com.nmt.kho.KhoSanPham;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class DichVuSanPhamImpl implements DichVuSanPham{
    
    @Autowired
    private KhoSanPham khoSanPham;
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<SanPham> getSanPhams(String kw, int page) {
        return this.khoSanPham.getSanPhams(kw, page);
    }

    @Override
    public long demSanPham() {
        return this.khoSanPham.demSanPham();
    }

    @Override
    public boolean addOrUpdate(SanPham sanPham) {
        try {
            Map m = this.cloudinary.uploader().upload(sanPham.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            sanPham.setHinhSP((String) m.get("secure_url"));
            
            return this.khoSanPham.addOrUpdate(sanPham);
        } catch(IOException ex) {
            System.err.println("~~ ADD PRODUCT ~~" + ex.getMessage());
        }
        
        return false; 
    }

    @Override
    public SanPham getSanPhamTheoMa(int maSP) {
        return this.khoSanPham.getSanPhamTheoMa(maSP);
    }

    @Override
    public List<Object[]> getHotSanPhams(int num) {
        return this.khoSanPham.getHotSanPhams(num);
    }

    @Override
    public List<Object[]> getMostDiscussSanPhams(int i) {
        return this.khoSanPham.getMostDiscussSanPhams(i);
    }
    
    
}
