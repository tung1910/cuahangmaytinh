/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dieukhien;

import com.nmt.csdl.SanPham;
import com.nmt.dichvu.DichVuSanPham;
//import com.nmt.xacnhan.TrinhXacThucUngDungWeb;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author hp
 */
@Controller
public class BoDieuKhienSanPham {
    
//    @Autowired
//    private TrinhXacThucUngDungWeb trinhXacThucSanPham;
//    
    @Autowired
    private DichVuSanPham dichVuSanPham;
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.setValidator(trinhXacThucSanPham);
//    }
    
    
    @GetMapping("/sanphams/{maSP}")
    public String detail(Model model, @PathVariable(value = "maSP") int maSP){
        model.addAttribute("sanpham", this.dichVuSanPham.getSanPhamTheoMa(maSP));
        
        return "chitietsanpham";
    }
    
    @GetMapping("/admin/sanphams")
    public String List(Model model){
        model.addAttribute("sanpham", new SanPham());
        
        return "sanpham";
    }
    
    @PostMapping("/admin/sanphams")
    public String add(Model model, @ModelAttribute(value = "sanpham") @Valid SanPham sanPham, BindingResult result){
        
        if(!result.hasErrors()){
            if(this.dichVuSanPham.addOrUpdate(sanPham) == true)
                
                return "redirect:/";
            else
                model.addAttribute("errMsg", "Something wrong!!!");
        }
        
        return "sanpham";
    }
}
