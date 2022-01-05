/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.dieukhien;

import com.nmt.csdl.DanhGia;
import com.nmt.csdl.TaiKhoan;
import com.nmt.dichvu.DichVuBinhLuan;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
public class ApiBoDieuKhienBinhLuan {

    @Autowired
    private DichVuBinhLuan dichVuBinhLuan;

    @PostMapping(path = "/api/add-binhluan", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<DanhGia> addDanhGia(@RequestBody Map<String, String> params, HttpSession session) {
        TaiKhoan tk = (TaiKhoan) session.getAttribute("nguoiDungHienTai");
        if (tk != null)
            try {

                String binhLuan = params.get("binhLuan");
                int maSP = Integer.parseInt(params.get("maSP"));

                DanhGia d = this.dichVuBinhLuan.addDanhGia(binhLuan, maSP, tk);

                return new ResponseEntity<>(d, HttpStatus.CREATED);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
