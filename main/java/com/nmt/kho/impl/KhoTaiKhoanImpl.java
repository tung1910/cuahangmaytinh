/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho.impl;

import com.nmt.csdl.TaiKhoan;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nmt.kho.KhoTaiKhoan;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author hp
 */
@Repository
@Transactional
public class KhoTaiKhoanImpl implements KhoTaiKhoan{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public TaiKhoan getTaiKhoanTheoMa(int maTK) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(TaiKhoan.class, maTK);
    }

    @Override
    public boolean addTaiKhoan(TaiKhoan taikhoan) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(taikhoan);
            
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        
        return false;
    }

    @Override
    public List<TaiKhoan> geTaiKhoans(String tenDN) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TaiKhoan> query = builder.createQuery(TaiKhoan.class);
        Root root = query.from(TaiKhoan.class);
        query = query.select(root);
        
        if(!tenDN.isEmpty()){
            Predicate p = builder.equal(root.get("tenDN").as(String.class), tenDN.trim());
            query = query.where(p);
        }
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }
    
}
