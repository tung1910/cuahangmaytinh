/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dinhdang;

import com.nmt.csdl.LoaiHang;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author hp
 */
public class DinhDangLoaiHang implements Formatter<LoaiHang>{

    @Override
    public String print(LoaiHang object, Locale locale) {
        return String.valueOf(object.getMaLH());
    }

    @Override
    public LoaiHang parse(String maLH, Locale locale) throws ParseException {
        LoaiHang lh = new LoaiHang();
        lh.setMaLH(Integer.parseInt(maLH));
        
        return lh;
    }
    
}
