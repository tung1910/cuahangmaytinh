/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.cauhinh;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 *
 * @author hp
 */
public class BoKhoiTao extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
            CauHinhHibernate.class,
            CauHinhTiles.class,
            CauHinhBaoMat.class
        };
    }
    
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
            CauHinhNguCanhUngDungWeb.class
        };    
    }
    
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
}
