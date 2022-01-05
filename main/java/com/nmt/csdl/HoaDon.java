/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.csdl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "hoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HoaDon.findAll", query = "SELECT h FROM HoaDon h"),
    @NamedQuery(name = "HoaDon.findByMaHD", query = "SELECT h FROM HoaDon h WHERE h.maHD = :maHD"),
    @NamedQuery(name = "HoaDon.findByNgayDatHang", query = "SELECT h FROM HoaDon h WHERE h.ngayDatHang = :ngayDatHang"),
    @NamedQuery(name = "HoaDon.findByTongTien", query = "SELECT h FROM HoaDon h WHERE h.tongTien = :tongTien"),
    @NamedQuery(name = "HoaDon.findByTrangThai", query = "SELECT h FROM HoaDon h WHERE h.trangThai = :trangThai")})
public class HoaDon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaHD")
    private Integer maHD;
    @Column(name = "NgayDatHang")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDatHang;
    @Column(name = "TongTien")
    private Long tongTien;
    @Column(name = "TrangThai")
    private Boolean trangThai;
    @JoinColumn(name = "MaHT", referencedColumnName = "MaHT")
    @ManyToOne(optional = false)
    private HinhThucThanhToan hinhthucthanhtoan;
    @JoinColumn(name = "MaTK", referencedColumnName = "MaTK")
    @ManyToOne(optional = false)
    private TaiKhoan taikhoan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hoadon")
    private Collection<ChiTietHoaDon> cthds;

    public HoaDon() {
        ngayDatHang = new Date();
    }

    public HoaDon(Integer maHD) {
        this.maHD = maHD;
    }

    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public HinhThucThanhToan getMaHT() {
        return hinhthucthanhtoan;
    }

    public void setMaHT(HinhThucThanhToan maHT) {
        this.hinhthucthanhtoan = maHT;
    }

    public TaiKhoan getMaTK() {
        return taikhoan;
    }

    public void setMaTK(TaiKhoan maTK) {
        this.taikhoan = maTK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHD != null ? maHD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HoaDon)) {
            return false;
        }
        HoaDon other = (HoaDon) object;
        if ((this.maHD == null && other.maHD != null) || (this.maHD != null && !this.maHD.equals(other.maHD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.HoaDon[ maHD=" + maHD + " ]";
    }

    /**
     * @return the tongTien
     */
    public Long getTongTien() {
        return tongTien;
    }

    /**
     * @param tongTien the tongTien to set
     */
    public void setTongTien(Long tongTien) {
        this.tongTien = tongTien;
    }

    /**
     * @return the cthds
     */
    public Collection<ChiTietHoaDon> getCthds() {
        return cthds;
    }

    /**
     * @param cthds the cthds to set
     */
    public void setCthds(Collection<ChiTietHoaDon> cthds) {
        this.cthds = cthds;
    }
    
}
