/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho.impl;

import com.nmt.csdl.LoaiHang;
import com.nmt.kho.KhoLoaiHang;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hp
 */
@Repository
@Transactional
public class KhoLoaiHangImpl implements KhoLoaiHang{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<LoaiHang> getLoaiHangs(){
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From LoaiHang");
        
        return q.getResultList();
    }

    @Override
    public LoaiHang getLoaiHangTheoMa(int maLH) {
        Session s = sessionFactory.getObject().getCurrentSession();
        
        return s.get(LoaiHang.class, maLH);
    }
    
}
