/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.nmt.csdl.TaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nmt.dichvu.DichVuTaiKhoan;
import com.nmt.kho.KhoTaiKhoan;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author hp
 */
@Service("userDetailsService")
public class DichVuTaiKhoanImpl implements DichVuTaiKhoan{
    
    @Autowired
    private KhoTaiKhoan khoTaiKhoan;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public TaiKhoan getTaiKhoanTheoMa(int maTK) {
        return this.khoTaiKhoan.getTaiKhoanTheoMa(maTK);
    }

    @Override
    public boolean addTaiKhoan(TaiKhoan taikhoan) {
        try {
            String pass = taikhoan.getMatKhau();
            taikhoan.setMatKhau(this.passwordEncoder.encode(pass));
            taikhoan.setLoaiTK(TaiKhoan.USER);
            
            Map m = this.cloudinary.uploader().upload(taikhoan.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            taikhoan.setHinhDD((String) m.get("secure_url"));
            
            return this.khoTaiKhoan.addTaiKhoan(taikhoan);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public List<TaiKhoan> geTaiKhoans(String tenDN) {
        return this.khoTaiKhoan.geTaiKhoans(tenDN);
    }

    @Override
    public UserDetails loadUserByUsername(String tenDN) throws UsernameNotFoundException {
        List<TaiKhoan> tks = this.geTaiKhoans(tenDN);
        if(tks.isEmpty())
            throw new UsernameNotFoundException("Tài khoản không tồn tại!!!");
        
        TaiKhoan tk = tks.get(0);
        
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(tk.getLoaiTK()));
        
        return new org.springframework.security.core.userdetails.User(tk.getTenDN(), tk.getMatKhau(), auth);
    }
}
