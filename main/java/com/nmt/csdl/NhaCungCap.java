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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "nhacungcap")
public class NhaCungCap implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaNCC")
    private Integer maNCC;
    @Size(max = 100)
    @Column(name = "TenNCC")
    private String tenNCC;
    @Size(max = 25)
    @Column(name = "DThoai")
    private String dThoai;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "Email")
    private String email;
    @Size(max = 250)
    @Column(name = "Website")
    private String website;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhacungcap")
    private Collection<SanPhamNhaCungCap> spnccs;
    

    public NhaCungCap() {
    }

    public NhaCungCap(Integer maNCC) {
        this.maNCC = maNCC;
    }

    public Integer getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(Integer maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDThoai() {
        return dThoai;
    }

    public void setDThoai(String dThoai) {
        this.dThoai = dThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @XmlTransient
    public Collection<SanPhamNhaCungCap> getSanPhamNhaCungCapCollection() {
        return spnccs;
    }

    public void setSanPhamNhaCungCapCollection(Collection<SanPhamNhaCungCap> sanPhamNhaCungCapCollection) {
        this.spnccs = sanPhamNhaCungCapCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNCC != null ? maNCC.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhaCungCap)) {
            return false;
        }
        NhaCungCap other = (NhaCungCap) object;
        if ((this.maNCC == null && other.maNCC != null) || (this.maNCC != null && !this.maNCC.equals(other.maNCC))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nmt.csdl.NhaCungCap[ maNCC=" + maNCC + " ]";
    }
}
