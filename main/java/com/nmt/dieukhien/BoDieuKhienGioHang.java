/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dieukhien;

import com.nmt.csdl.GioHang;
import com.nmt.tienich.TienIch;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author hp
 */
@Controller
public class BoDieuKhienGioHang {
    
    @GetMapping("/giohang")
    public String giohang(Model model, HttpSession session){
        Map<Integer, GioHang> giohang = (Map<Integer, GioHang>) session.getAttribute("giohang");
        if(giohang != null)
            model.addAttribute("giohangs", giohang.values());
        else
            model.addAttribute("giohangs", null);
        
        model.addAttribute("thongKeGioHang", TienIch.thongKeGioHang(giohang));
        
        return "giohang";
    }
}
