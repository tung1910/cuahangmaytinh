/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.csdl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "danhgia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DanhGia.findAll", query = "SELECT d FROM DanhGia d"),
    @NamedQuery(name = "DanhGia.findByMaDG", query = "SELECT d FROM DanhGia d WHERE d.maDG = :maDG"),
    @NamedQuery(name = "DanhGia.findByBinhLuan", query = "SELECT d FROM DanhGia d WHERE d.binhLuan = :binhLuan"),
    @NamedQuery(name = "DanhGia.findByNgayDang", query = "SELECT d FROM DanhGia d WHERE d.ngayDang = :ngayDang")})
public class DanhGia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaDG")
    private Integer maDG;
    @Size(max = 700)
    @Column(name = "BinhLuan")
    private String binhLuan;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "NgayDang")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayDang;
    @JsonIgnore
    @JoinColumn(name = "MaSP", referencedColumnName = "MaSP")
    @ManyToOne(optional = false)
    private SanPham sanpham;
    @JoinColumn(name = "MaTK", referencedColumnName = "MaTK")
    @ManyToOne(optional = false)
    private TaiKhoan taikhoan;

    public DanhGia() {
    }

    public DanhGia(Integer maDG) {
        this.maDG = maDG;
    }

    public Integer getMaDG() {
        return maDG;
    }

    public void setMaDG(Integer maDG) {
        this.maDG = maDG;
    }

    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }

    public Date getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(Date ngayDang) {
        this.ngayDang = ngayDang;
    }

    public SanPham getMaSP() {
        return sanpham;
    }

    public void setMaSP(SanPham maSP) {
        this.sanpham = maSP;
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
        hash += (maDG != null ? maDG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DanhGia)) {
            return false;
        }
        DanhGia other = (DanhGia) object;
        if ((this.maDG == null && other.maDG != null) || (this.maDG != null && !this.maDG.equals(other.maDG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.DanhGia[ maDG=" + maDG + " ]";
    }
    
}
