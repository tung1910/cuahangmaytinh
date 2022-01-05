/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dieukhien;

import com.nmt.csdl.TaiKhoan;
import com.nmt.dichvu.DichVuTaiKhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author hp
 */
@Controller
public class BoDieuKhienTaiKhoan {
    
    @Autowired
    private DichVuTaiKhoan userDetailsService;
    
    @GetMapping("/dangnhap")
    public String login(){
        return "dangnhap";
    }
    
    @GetMapping("/dangky")
    public String xemDK(Model model){
        model.addAttribute("taikhoan", new TaiKhoan());
        
        return "dangky";
    }
    
    @PostMapping("/dangky")
    public String dangky(Model model,@ModelAttribute(value = "taikhoan") TaiKhoan taiKhoan){
        String errMsg = "";
        if(taiKhoan.getMatKhau().equals(taiKhoan.getXacNhanMK())){
            if(this.userDetailsService.addTaiKhoan(taiKhoan) == true)
                return "redirect:/dangnhap";
            else
                errMsg = "Đã có lỗi xảy ra!";
        }else
            errMsg = "Mật khẩu không khớp";
        
        model.addAttribute("errMsg", errMsg);
        
        return "dangky";
        
    }
}
