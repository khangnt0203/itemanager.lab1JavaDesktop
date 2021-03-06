/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SupplierDTO;
import static Util.Connection.openConnection;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Khang
 */
public class SupDAO extends Vector<SupplierDTO> {

    public SupDAO() {
        super();
    }

    public int find(String SupCode) {
        try {
            List<SupplierDTO> list = getAllSup();
            for (int i = 0; i < list.size(); i++) {
                if (SupCode.equals(list.get(i).getSupCode())) {
                    return i;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public SupplierDTO findSupplier(String SupCode) {
        try {
            List<SupplierDTO> list = getAllSup();
            int i = find(SupCode);
            return i < 0 ? null : list.get(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SupDAO getAllSup() throws Exception {
       SupDAO sup = new SupDAO();
        try (Connection c = openConnection();
                Statement sm = c.createStatement()) {
            ResultSet rs = sm.executeQuery("SELECT supCode, supName, address, collaborating FROM tblSuppliers");
            while (rs.next()) {
                String supCode = rs.getString("supCode");
                String supName = rs.getString("supName");
                String address = rs.getString("address");
                boolean collaborating = rs.getBoolean("collaborating");
                SupplierDTO s = new SupplierDTO(supCode, supName, address, collaborating);
                sup.add(s);
            }
        }
        return sup;
    }

    public static int insert(SupplierDTO sup) throws Exception {
        String sql = "Insert tblSuppliers Values(?,?,?,?)";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, sup.getSupCode());
            ps.setString(2, sup.getSupName());
            ps.setString(3, sup.getAddress());
            ps.setBoolean(4, sup.isColloborating());
            return ps.executeUpdate();
        }
    }

    public static SupplierDTO getSupplierByCode(String supCode) throws Exception {
        String sql = "Select supCode, supName, address, collaborating From tblSuppliers Where supCode=?";
        try (Connection c = openConnection();
                PreparedStatement sm = c.prepareStatement(sql)) {
            sm.setString(1, supCode);
            ResultSet rs = sm.executeQuery();
            if (rs.next()) {
                SupplierDTO e = new SupplierDTO(rs.getString("supCode"), rs.getString("supName"), rs.getString("address"), rs.getBoolean("colloborating"));
                return e;
            }
        }
        return null;
    }

    public static int update(SupplierDTO sup) throws Exception {
        String sql = "Update tblSuppliers set supName =?, address=?, collaborating=? where supCode =?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, sup.getSupName());
            ps.setString(2, sup.getAddress());
            ps.setBoolean(3, sup.isColloborating());
            ps.setString(4, sup.getSupCode());
            return ps.executeUpdate();
        }
    }

    public static int delete(String supCode) throws Exception {
        String sql = "Delete From tblSuppliers Where supCode=?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, supCode);
            return ps.executeUpdate();
        }
    }
    
    public boolean checkCode(String supCode) throws Exception{
        String sql = "select supCode from tblSuppliers where supCode=?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, supCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        }
    }

}
