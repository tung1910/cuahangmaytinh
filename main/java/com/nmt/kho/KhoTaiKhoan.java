/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho;

import com.nmt.csdl.TaiKhoan;
import java.util.List;

/**
 *
 * @author hp
 */
public interface KhoTaiKhoan {
    TaiKhoan getTaiKhoanTheoMa(int maTK);
    boolean addTaiKhoan (TaiKhoan taikhoan);
    List<TaiKhoan> geTaiKhoans (String tenDN);
}
