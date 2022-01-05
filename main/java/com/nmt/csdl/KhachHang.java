/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.csdl;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "khachhang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k"),
    @NamedQuery(name = "KhachHang.findByMaKH", query = "SELECT k FROM KhachHang k WHERE k.maKH = :maKH"),
    @NamedQuery(name = "KhachHang.findByTen", query = "SELECT k FROM KhachHang k WHERE k.ten = :ten"),
    @NamedQuery(name = "KhachHang.findByGioiTinh", query = "SELECT k FROM KhachHang k WHERE k.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "KhachHang.findByDThoai", query = "SELECT k FROM KhachHang k WHERE k.dThoai = :dThoai"),
    @NamedQuery(name = "KhachHang.findByDiaChi", query = "SELECT k FROM KhachHang k WHERE k.diaChi = :diaChi"),
    @NamedQuery(name = "KhachHang.findByEmail", query = "SELECT k FROM KhachHang k WHERE k.email = :email")})
public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaKH")
    private Integer maKH;
    @Size(max = 100)
    @Column(name = "Ten")
    private String ten;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GioiTinh")
    private short gioiTinh;
    @Size(max = 25)
    @Column(name = "DThoai")
    private String dThoai;
    @Size(max = 100)
    @Column(name = "DiaChi")
    private String diaChi;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "Email")
    private String email;
    
    

    public KhachHang() {
    }

    public KhachHang(Integer maKH) {
        this.maKH = maKH;
    }

    public KhachHang(Integer maKH, short gioiTinh) {
        this.maKH = maKH;
        this.gioiTinh = gioiTinh;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public short getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(short gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDThoai() {
        return dThoai;
    }

    public void setDThoai(String dThoai) {
        this.dThoai = dThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maKH != null ? maKH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.maKH == null && other.maKH != null) || (this.maKH != null && !this.maKH.equals(other.maKH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.KhachHang[ maKH=" + maKH + " ]";
    }
}
