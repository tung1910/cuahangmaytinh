/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu;

import com.nmt.csdl.DanhGia;
import com.nmt.csdl.TaiKhoan;

/**
 *
 * @author hp
 */
public interface DichVuBinhLuan {
    DanhGia addDanhGia(String binhLuan, int maSP, TaiKhoan nguoiTao);
}
