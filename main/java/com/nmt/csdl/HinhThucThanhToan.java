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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "hinhthucthanhtoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HinhThucThanhToan.findAll", query = "SELECT h FROM HinhThucThanhToan h"),
    @NamedQuery(name = "HinhThucThanhToan.findByMaHT", query = "SELECT h FROM HinhThucThanhToan h WHERE h.maHT = :maHT"),
    @NamedQuery(name = "HinhThucThanhToan.findByTenHT", query = "SELECT h FROM HinhThucThanhToan h WHERE h.tenHT = :tenHT")})
public class HinhThucThanhToan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaHT")
    private Integer maHT;
    @Size(max = 200)
    @Column(name = "TenHT")
    private String tenHT;
    @Lob
    @Size(max = 65535)
    @Column(name = "MoTa")
    private String moTa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maHD")
    private Collection<HoaDon> hds;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(Integer maHT) {
        this.maHT = maHT;
    }

    public Integer getMaHT() {
        return maHT;
    }

    public void setMaHT(Integer maHT) {
        this.maHT = maHT;
    }

    public String getTenHT() {
        return tenHT;
    }

    public void setTenHT(String tenHT) {
        this.tenHT = tenHT;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @XmlTransient
    public Collection<HoaDon> getHoaDonCollection() {
        return hds;
    }

    public void setHoaDonCollection(Collection<HoaDon> hoaDonCollection) {
        this.hds = hoaDonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHT != null ? maHT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HinhThucThanhToan)) {
            return false;
        }
        HinhThucThanhToan other = (HinhThucThanhToan) object;
        if ((this.maHT == null && other.maHT != null) || (this.maHT != null && !this.maHT.equals(other.maHT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.HinhThucThanhToan[ maHT=" + maHT + " ]";
    }
    
}
