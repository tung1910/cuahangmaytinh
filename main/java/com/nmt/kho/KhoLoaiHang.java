/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho;

import com.nmt.csdl.LoaiHang;
import java.util.List;

/**
 *
 * @author hp
 */
public interface KhoLoaiHang {
    List<LoaiHang> getLoaiHangs();
    LoaiHang getLoaiHangTheoMa(int maLH);
}
