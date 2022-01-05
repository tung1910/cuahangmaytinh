/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.csdl;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "sanpham_nhacungcap")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanPhamNhaCungCap.findAll", query = "SELECT s FROM SanPhamNhaCungCap s"),
    @NamedQuery(name = "SanPhamNhaCungCap.findByNgayMua", query = "SELECT s FROM SanPhamNhaCungCap s WHERE s.ngayMua = :ngayMua"),
    @NamedQuery(name = "SanPhamNhaCungCap.findBySoLuongMua", query = "SELECT s FROM SanPhamNhaCungCap s WHERE s.soLuongMua = :soLuongMua"),
    @NamedQuery(name = "SanPhamNhaCungCap.findByDonGiaMuaVao", query = "SELECT s FROM SanPhamNhaCungCap s WHERE s.donGiaMuaVao = :donGiaMuaVao")})
public class SanPhamNhaCungCap implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayMua")
    @Temporal(TemporalType.DATE)
    private Date ngayMua;
    @Size(max = 250)
    @Column(name = "SoLuongMua")
    private String soLuongMua;
    @Column(name = "DonGiaMuaVao")
    private Long donGiaMuaVao;
    @JoinColumn(name = "MaNCC", referencedColumnName = "MaNCC")
    @ManyToOne(optional = false)
    private NhaCungCap nhacungcap;
    @JoinColumn(name = "MaSP", referencedColumnName = "MaSP")
    @ManyToOne(optional = false)
    private SanPham sanpham;

    public SanPhamNhaCungCap() {
    }

    public SanPhamNhaCungCap(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(String soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public Long getDonGiaMuaVao() {
        return donGiaMuaVao;
    }

    public void setDonGiaMuaVao(Long donGiaMuaVao) {
        this.donGiaMuaVao = donGiaMuaVao;
    }

    public NhaCungCap getMaNCC() {
        return nhacungcap;
    }

    public void setMaNCC(NhaCungCap maNCC) {
        this.nhacungcap = maNCC;
    }

    public SanPham getMaSP() {
        return sanpham;
    }

    public void setMaSP(SanPham maSP) {
        this.sanpham = maSP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ngayMua != null ? ngayMua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanPhamNhaCungCap)) {
            return false;
        }
        SanPhamNhaCungCap other = (SanPhamNhaCungCap) object;
        if ((this.ngayMua == null && other.ngayMua != null) || (this.ngayMua != null && !this.ngayMua.equals(other.ngayMua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.SanPhamNhaCungCap[ ngayMua=" + ngayMua + " ]";
    }
    
}
