/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dichvu;

import com.nmt.csdl.SanPham;
import java.util.List;

/**
 *
 * @author hp
 */
public interface DichVuSanPham {
    List<SanPham> getSanPhams(String kw, int page);
    List<Object[]> getHotSanPhams(int num);
    List<Object[]> getMostDiscussSanPhams(int num);
    long demSanPham();
    boolean addOrUpdate(SanPham sanPham);
    SanPham getSanPhamTheoMa(int maSP);
}
