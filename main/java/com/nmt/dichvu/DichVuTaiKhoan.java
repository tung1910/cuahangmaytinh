/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu;

import com.nmt.csdl.TaiKhoan;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author hp
 */
public interface DichVuTaiKhoan extends UserDetailsService{
    TaiKhoan getTaiKhoanTheoMa(int maTK);
    boolean addTaiKhoan (TaiKhoan taikhoan);
    List<TaiKhoan> geTaiKhoans (String tenDN);
}
