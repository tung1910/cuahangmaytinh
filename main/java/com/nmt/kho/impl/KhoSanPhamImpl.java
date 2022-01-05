/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho.impl;

import com.nmt.csdl.ChiTietHoaDon;
import com.nmt.csdl.DanhGia;
import com.nmt.csdl.SanPham;
import com.nmt.kho.KhoSanPham;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class KhoSanPhamImpl implements KhoSanPham{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<SanPham> getSanPhams(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SanPham> query = builder.createQuery(SanPham.class);
        Root root = query.from(SanPham.class);
        query = query.select(root);
        
        query = query.orderBy(builder.desc(root.get("maSP")));
        
        if (kw !=null) {
            Predicate p = builder.like(root.get("tenSP").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        query = query.orderBy(builder.desc(root.get("maSP")));
        
        Query q = session.createQuery(query);
        
        int max = 9;
        q.setMaxResults(max);
        q.setFirstResult((page - 1) * max);
        
        return q.getResultList();
    }

    @Override
    public long demSanPham() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From SanPham");
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdate(SanPham sanPham) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(sanPham);
                    
            return true;
        } catch (Exception ex) {
            System.err.println("~~ ADD PRODUCT ERRPR ~~" + ex.getMessage());
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public SanPham getSanPhamTheoMa(int maSP) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(SanPham.class, maSP);
    }

    @Override
    public List<Object[]> getHotSanPhams(int num) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rS = query.from(SanPham.class);
        Root rC = query.from(ChiTietHoaDon.class);
        
        query = query.where(builder.equal(rC.get("sanpham"), rS.get("maSP")));
        query.multiselect(rS.get("maSP"), rS.get("tenSP"), rS.get("donGia"), rS.get("hinhSP"), builder.count(rS.get("maSP")));
        
        query = query.groupBy(rS.get("maSP"));
        query = query.orderBy(builder.desc(builder.count(rS.get("maSP"))));
        
        Query q = session.createQuery(query);
        q.setMaxResults(num);
        
        return q.getResultList();
    }

    @Override
    public List<Object[]> getMostDiscussSanPhams(int num) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rS = query.from(SanPham.class);
        Root rD = query.from(DanhGia.class);
        
        query = query.where(builder.equal(rD.get("sanpham"), rS.get("maSP")));
        query.multiselect(rS.get("maSP"), rS.get("tenSP"), rS.get("donGia"), rS.get("hinhSP"), builder.count(rS.get("maSP")));
        
        query = query.groupBy(rS.get("maSP"));
        query = query.orderBy(builder.desc(builder.count(rS.get("maSP"))), builder.desc(rS.get("maSP")));
        
        Query q = session.createQuery(query);
        q.setMaxResults(num);
        
        return q.getResultList();
    }

}
