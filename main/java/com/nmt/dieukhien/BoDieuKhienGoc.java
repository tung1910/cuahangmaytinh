/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dieukhien;

import com.nmt.csdl.GioHang;
import com.nmt.csdl.LoaiHang;
import com.nmt.dichvu.DichVuLoaiHang;
import com.nmt.dichvu.DichVuSanPham;
import com.nmt.tienich.TienIch;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hp
 */
@Controller
@ControllerAdvice
public class BoDieuKhienGoc {
    
    @Autowired
    private DichVuLoaiHang dichVuLoaiHang;
    
    @Autowired
    private DichVuSanPham dichVuSanPham;
    
    @ModelAttribute
    public void commonAttr(Model model, HttpSession session){
        model.addAttribute("loaihangs", this.dichVuLoaiHang.getLoaiHangs());
        model.addAttribute("cartCounter", TienIch.demGioHang((Map<Integer, GioHang>) session.getAttribute("giohang")));
        model.addAttribute("nguoiDungHienTai", session.getAttribute("nguoiDungHienTai"));
    }
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params, HttpSession session){
        
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        String maLH = params.get("MaLH");
        if(maLH == null){
            model.addAttribute("sanphams", this.dichVuSanPham.getSanPhams(kw, page));
        }
        else{
            LoaiHang lh = this.dichVuLoaiHang.getLoaiHangTheoMa(Integer.parseInt(maLH));
            model.addAttribute("sanphams", lh.getSanPhams());
        }
            
        model.addAttribute("counter", this.dichVuSanPham.demSanPham());
        model.addAttribute("hotSanPhams", this.dichVuSanPham.getHotSanPhams(6));
        model.addAttribute("disSanPhams", this.dichVuSanPham.getMostDiscussSanPhams(6));
        
        
        return "index";
    }
}
