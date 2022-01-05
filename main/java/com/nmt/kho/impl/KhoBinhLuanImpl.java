/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho.impl;

import com.nmt.csdl.DanhGia;
import com.nmt.kho.KhoBinhLuan;
import org.hibernate.HibernateException;
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
public class KhoBinhLuanImpl implements KhoBinhLuan{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public DanhGia addDanhGia(DanhGia d) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(d);
            
            return d;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
    
}
