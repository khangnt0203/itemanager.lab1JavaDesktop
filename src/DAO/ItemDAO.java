/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ItemDTO;
import DTO.SupplierDTO;
import static Util.Connection.openConnection;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Khang
 */
public class ItemDAO extends Vector<ItemDTO> {

    public ItemDAO() {
        super();
    }

    public int find(String itemCode) {
        for (int i = 0; i < this.size(); i++) {
            if (itemCode.equals(this.get(i).getItemCode())) {
                return i;
            }
        }
        return -1;
    }

    public ItemDTO findItem(String itemCode) {
        int i = find(itemCode);
        return i < 0 ? null : this.get(i);
    }

    public static ItemDAO getAllItem() throws Exception {
//        List<Item> list = new ArrayList<>();
        ItemDAO it = new ItemDAO();
        SupDAO sup = new SupDAO();
        String sql = "Select itemCode, itemName, supCode, unit, price, supplying  "
                + "from tblItems ";
        //Suppliers s = new Suppliers();
        try (Connection c = openConnection();
                Statement sm = c.createStatement()) {
            ResultSet rs = sm.executeQuery(sql);
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                String supplierCode = rs.getString(3);
                // System.out.println(s.findSupplier(supplierCode));
                SupplierDTO supplier = sup.findSupplier(supplierCode);
                String unit = rs.getString(4);
                int price = rs.getInt(5);
                boolean supplying = rs.getBoolean(6);
                ItemDTO items = new ItemDTO(code, name, supplier, unit, price, supplying);
                it.add(items);
            }
        }
        return it;
    }

    public static int insert(ItemDTO it) throws Exception {
        String sql = "Insert into tblItems Values(?,?,?,?,?,?)";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, it.getItemCode());
            ps.setString(2, it.getItemName());
            ps.setString(3, it.getSupplier().getSupCode());
            ps.setString(4, it.getUnit());
            ps.setFloat(5, it.getPrice());
            ps.setBoolean(6, it.isSupplying());
            return ps.executeUpdate();
        }
    }

    public static int update(ItemDTO it) throws Exception {
        String sql = "update tblItems set itemName= ? , supCode = ?,unit = ?,price = ?,supplying = ? where itemCode = ?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, it.getItemName());
            ps.setString(2, it.getSupplier().getSupCode());
            ps.setString(3, it.getUnit());
            ps.setFloat(4, it.getPrice());
            ps.setBoolean(5, it.isSupplying());
            ps.setString(6, it.getItemCode());
            return ps.executeUpdate();
        }
    }

    public static int delete(String itemCode) throws Exception {
        String sql = "Delete From tblItems Where itemCode=?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, itemCode);
            return ps.executeUpdate();
        }
    }

    public boolean checkSupCodeTblItem(String code) throws Exception {
        String sql = "select itemCode from tblItems where supCode like ?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        }
    }

    public boolean checkCode(String itemCode) throws Exception {
        String sql = "select itemCode from tblItems where itemCode=?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, itemCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        }
    }
}
