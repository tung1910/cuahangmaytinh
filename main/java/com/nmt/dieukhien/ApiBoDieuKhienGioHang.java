/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dieukhien;

import com.nmt.csdl.GioHang;
import com.nmt.dichvu.DichVuHoaDon;
import com.nmt.tienich.TienIch;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
public class ApiBoDieuKhienGioHang {
    
    @Autowired
    private DichVuHoaDon dichVuHoaDon;
    
    @PostMapping(path = "/api/giohang")
    public int addToGioHang(@RequestBody GioHang params, HttpSession session){
        Map<Integer, GioHang> giohang = (Map<Integer, GioHang>) session.getAttribute("giohang");
        if (giohang == null)
            giohang = new HashMap<>();
        
        int maSP = params.getMaSP();
        if(giohang.containsKey(maSP) == true){ // san pham da co trong gio
            GioHang g = giohang.get(maSP);
            g.setSoLuong(g.getSoLuong() + 1);
        } else { // san pham chua co trong gio
            giohang.put(maSP, params);
        }
        
        session.setAttribute("giohang", giohang);
        
        return TienIch.demGioHang(giohang);
    }
    
    @PutMapping("/api/giohang")
    public ResponseEntity<Map<String, String>> updateGioHang(@RequestBody GioHang params, HttpSession session){
        Map<Integer, GioHang> giohang = (Map<Integer, GioHang>) session.getAttribute("giohang");
        if (giohang == null)
            giohang = new HashMap<>();
        
        int maSP = params.getMaSP();
        if(giohang.containsKey(maSP) == true){ // san pham da co trong gio
            GioHang g = giohang.get(maSP);
            g.setSoLuong(params.getSoLuong());
        }
        session.setAttribute("giohang", giohang);
        
        return new ResponseEntity<>(TienIch.thongKeGioHang(giohang), HttpStatus.OK);
    }
    
    @DeleteMapping("/api/giohang/{maSP}")
    public ResponseEntity<Map<String, String>> deleteItemsGioHang(@PathVariable(value = "maSP") int maSP, HttpSession session){
        Map<Integer, GioHang> giohang = (Map<Integer, GioHang>) session.getAttribute("giohang");
        if(giohang != null && giohang.containsKey(maSP)){
            giohang.remove(maSP);
            
            session.setAttribute("giohang", giohang);
        }
        
        return new ResponseEntity<>(TienIch.thongKeGioHang(giohang), HttpStatus.OK);
    }
    
    @PostMapping("/api/thanhtoan")
    public HttpStatus thanhToan(HttpSession session){
        if(this.dichVuHoaDon.addDonHang((Map<Integer, GioHang>) session.getAttribute("giohang")) == true){
            session.removeAttribute("giohang");
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}