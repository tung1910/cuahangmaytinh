/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho.impl;

import com.nmt.csdl.ChiTietHoaDon;
import com.nmt.csdl.GioHang;
import com.nmt.csdl.HoaDon;
import com.nmt.csdl.TaiKhoan;
import com.nmt.kho.KhoHoaDon;
import com.nmt.kho.KhoSanPham;
import com.nmt.kho.KhoTaiKhoan;
import com.nmt.tienich.TienIch;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
@Repository
@Transactional
public class KhoHoaDonImpl implements KhoHoaDon {

    @Autowired
    private KhoTaiKhoan khoTaiKhoan;

    @Autowired
    private KhoSanPham khoSanPham;

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addDonHang(Map<Integer, GioHang> giohang) {
        try {
            Session s = sessionFactory.getObject().getCurrentSession();

            TaiKhoan t = new TaiKhoan();
            HoaDon hd = new HoaDon();
            hd.setMaTK(t);
            hd.setNgayDatHang(new Date());

            Map<String, String> thongke = TienIch.thongKeGioHang(giohang);
            hd.setTongTien(Long.parseLong(thongke.get("tongTien")));

            s.save(hd);

            for (GioHang g : giohang.values()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaHD(hd);
                cthd.setMaSP(this.khoSanPham.getSanPhamTheoMa(g.getMaSP()));
                cthd.setDonGiaBanRa(g.getDonGia());
                cthd.setSoLuongBan(g.getSoLuong());

                s.save(cthd);
            }
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
