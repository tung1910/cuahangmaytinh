/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nmt.kho;

import com.nmt.csdl.GioHang;
import java.util.Map;

/**
 *
 * @author hp
 */
public interface KhoHoaDon {
    boolean addDonHang (Map<Integer, GioHang> giohang);
}
