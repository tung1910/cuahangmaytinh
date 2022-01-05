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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "nhanvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n"),
    @NamedQuery(name = "NhanVien.findByMaNV", query = "SELECT n FROM NhanVien n WHERE n.maNV = :maNV"),
    @NamedQuery(name = "NhanVien.findByHo", query = "SELECT n FROM NhanVien n WHERE n.ho = :ho"),
    @NamedQuery(name = "NhanVien.findByTen", query = "SELECT n FROM NhanVien n WHERE n.ten = :ten"),
    @NamedQuery(name = "NhanVien.findByGioiTinh", query = "SELECT n FROM NhanVien n WHERE n.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "NhanVien.findByNgaySinh", query = "SELECT n FROM NhanVien n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "NhanVien.findByDThoai", query = "SELECT n FROM NhanVien n WHERE n.dThoai = :dThoai"),
    @NamedQuery(name = "NhanVien.findByDiaChi", query = "SELECT n FROM NhanVien n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "NhanVien.findByEmail", query = "SELECT n FROM NhanVien n WHERE n.email = :email")})
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaNV")
    private Integer maNV;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Ho")
    private String ho;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Ten")
    private String ten;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GioiTinh")
    private short gioiTinh;
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySinh;
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
    @JoinColumns({
        @JoinColumn(name = "MaNV", referencedColumnName = "MaTK", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private TaiKhoan taikhoan;
    public NhanVien() {
    }

    public NhanVien(Integer maNV) {
        this.maNV = maNV;
    }

    public NhanVien(Integer maNV, String ho, String ten, short gioiTinh) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public TaiKhoan getTaiKhoan() {
        return taikhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taikhoan = taiKhoan;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.NhanVien[ maNV=" + maNV + " ]";
    }
    
}
