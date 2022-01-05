/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.tienich;

import com.nmt.csdl.GioHang;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hp
 */
public class TienIch {
    public static int demGioHang(Map<Integer, GioHang> giohang){
        int q = 0;
        if(giohang != null)
        for(GioHang g: giohang.values())
            q += g.getSoLuong();
        
        return q;
    }
    
    public static Map<String, String> thongKeGioHang(Map<Integer, GioHang> giohang){
        Long s = 0l;
        int q = 0;
        
        if(giohang != null)
        for(GioHang g: giohang.values()){
            q += g.getSoLuong();
            s += g.getSoLuong() * g.getDonGia();
        }
        
        Map<String, String> kq = new HashMap<>();
        kq.put("counter", String.valueOf(q));
        kq.put("tongTien", String.valueOf(s));
        
        return kq;
    }
}   
