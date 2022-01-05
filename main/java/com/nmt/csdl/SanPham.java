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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "sanpham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s"),
    @NamedQuery(name = "SanPham.findByMaSP", query = "SELECT s FROM SanPham s WHERE s.maSP = :maSP"),
    @NamedQuery(name = "SanPham.findByTenSP", query = "SELECT s FROM SanPham s WHERE s.tenSP = :tenSP"),
    @NamedQuery(name = "SanPham.findBySoLuongTon", query = "SELECT s FROM SanPham s WHERE s.soLuongTon = :soLuongTon"),
    @NamedQuery(name = "SanPham.findByDonGia", query = "SELECT s FROM SanPham s WHERE s.donGia = :donGia"),
    @NamedQuery(name = "SanPham.findByBaoHanh", query = "SELECT s FROM SanPham s WHERE s.baoHanh = :baoHanh"),
    @NamedQuery(name = "SanPham.findByHinhSP", query = "SELECT s FROM SanPham s WHERE s.hinhSP = :hinhSP"),
    @NamedQuery(name = "SanPham.findByGiaKhuyenMai", query = "SELECT s FROM SanPham s WHERE s.giaKhuyenMai = :giaKhuyenMai"),
    @NamedQuery(name = "SanPham.findByNgayTao", query = "SELECT s FROM SanPham s WHERE s.ngayTao = :ngayTao")})
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaSP")
    private Integer maSP;
    @Basic(optional = false)
    @NotNull(message = "{sanpham.tenSP.myErr}")
    @Size(min = 5, max = 100, message = "{sanpham.tenSP.LenErr}")
    @Column(name = "TenSP")
    private String tenSP;
    @Min(value = 100000, message = "{sanpham.donGia.minErr}")
    @Max(value = 50000000, message = "{sanpham.donGia.maxErr}")
    @Column(name = "DonGia")
    private Long donGia;
    @Column(name = "GiaKhuyenMai")
    private Long giaKhuyenMai;
    @Lob
    @Size(max = 65535, message = "{sanpham.moTa.LenErr}")
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "HinhSP")
    private String hinhSP;
    @Size(max = 500, message = "{sanpham.soLuongTon.LenErr}")
    @Column(name = "SoLuongTon")
    private String soLuongTon;
    @Size(max = 45)
    @Column(name = "BaoHanh")
    private String baoHanh;
    @Column(name = "NgayTao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayTao;
    @JoinColumn(name = "MaLH", referencedColumnName = "MaLH")
    @ManyToOne(optional = false)
    @NotNull
    private LoaiHang loaihang;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanpham")
    private Collection<SanPhamNhaCungCap> spnccs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanpham")
    private Collection<ChiTietHoaDon> cthds;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sanpham", fetch = FetchType.EAGER)
    private Collection<DanhGia> dgs;
    @ManyToMany
    @JoinTable(
            name = "sanpham_nhacungcap", joinColumns = {@JoinColumn(name = "MaSP")},
                              inverseJoinColumns = {@JoinColumn(name = "MaNCC")}
    )
    private Collection<NhaCungCap> nccs;
    
    @Transient
    private MultipartFile file;

    public SanPham() {
    }

    public SanPham(Integer maSP) {
        this.maSP = maSP;
    }

    public SanPham(Integer maSP, String tenSP) {
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public Integer getMaSP() {
        return maSP;
    }

    public void setMaSP(Integer maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(String soLuongTon) {
        this.soLuongTon = soLuongTon;
    }


    public String getBaoHanh() {
        return baoHanh;
    }

    public void setBaoHanh(String baoHanh) {
        this.baoHanh = baoHanh;
    }


    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @XmlTransient
    public Collection<SanPhamNhaCungCap> getSanPhamNhaCungCaps() {
        return spnccs;
    }

    public void setSanPhamNhaCungCaps(Collection<SanPhamNhaCungCap> sanPhamNhaCungCaps) {
        this.spnccs = sanPhamNhaCungCaps;
    }

    @XmlTransient
    public Collection<ChiTietHoaDon> getChiTietHoaDons() {
        return cthds;
    }

    public void setChiTietHoaDons(Collection<ChiTietHoaDon> chiTietHoaDons) {
        this.cthds = chiTietHoaDons;
    }

    @XmlTransient
    public Collection<DanhGia> getDanhGias() {
        return dgs;
    }

    public void setDanhGias(Collection<DanhGia> danhGias) {
        this.dgs = danhGias;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maSP != null ? maSP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanPham)) {
            return false;
        }
        SanPham other = (SanPham) object;
        if ((this.maSP == null && other.maSP != null) || (this.maSP != null && !this.maSP.equals(other.maSP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.SanPham[ maSP=" + maSP + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }


    public Long getGiaKhuyenMai() {
        return giaKhuyenMai;
    }

    public void setGiaKhuyenMai(Long giaKhuyenMai) {
        this.giaKhuyenMai = giaKhuyenMai;
    }
    
    /**
     * @return the loaihang
     */
    public LoaiHang getLoaihang() {
        return loaihang;
    }

    /**
     * @param loaihang the loaihang to set
     */
    public void setLoaihang(LoaiHang loaihang) {
        this.loaihang = loaihang;
    }
    
    /**
     * @return the nccs
     */
    public Collection<NhaCungCap> getNccs() {
        return nccs;
    }

    /**
     * @param nccs the nccs to set
     */
    public void setNccs(Collection<NhaCungCap> nccs) {
        this.nccs = nccs;
    }

    /**
     * @return the hinhSP
     */
    public String getHinhSP() {
        return hinhSP;
    }

    /**
     * @param hinhSP the hinhSP to set
     */
    public void setHinhSP(String hinhSP) {
        this.hinhSP = hinhSP;
    }

    public Long getDonGia() {
        return donGia;
    }

    public void setDonGia(Long donGia) {
        this.donGia = donGia;
    }
}
