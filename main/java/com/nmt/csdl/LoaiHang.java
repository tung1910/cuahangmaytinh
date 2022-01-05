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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "loaihang")
public class LoaiHang implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaLH")
    private Integer maLH;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TenLH")
    private String tenLH;
    @Lob
    @Size(max = 65535)
    @Column(name = "MoTa")
    private String moTa;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "loaihang")
    private Collection<SanPham> sps;
    

    public LoaiHang() {
    }

    public LoaiHang(Integer maLH) {
        this.maLH = maLH;
    }

    public LoaiHang(Integer maLH, String tenLH) {
        this.maLH = maLH;
        this.tenLH = tenLH;
    }

    public Integer getMaLH() {
        return maLH;
    }

    public void setMaLH(Integer maLH) {
        this.maLH = maLH;
    }

    public String getTenLH() {
        return tenLH;
    }

    public void setTenLH(String tenLH) {
        this.tenLH = tenLH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @XmlTransient
    public Collection<SanPham> getSanPhams() {
        return sps;
    }

    public void setSanPhams(Collection<SanPham> sanPhams) {
        this.sps = sanPhams;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLH != null ? maLH.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiHang)) {
            return false;
        }
        LoaiHang other = (LoaiHang) object;
        if ((this.maLH == null && other.maLH != null) || (this.maLH != null && !this.maLH.equals(other.maLH))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.LoaiHang[ maLH=" + maLH + " ]";
    }
}
