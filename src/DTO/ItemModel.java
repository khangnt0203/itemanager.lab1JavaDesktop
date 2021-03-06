/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.ItemDAO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Khang
 */
public class ItemModel extends AbstractTableModel{
    ItemDAO items=null;
    
    public ItemModel(ItemDAO items) {
        this.items=items;
    }

    public ItemDAO getItems() {
        return items;
    }

    public void setItems(ItemDAO items) {
        this.items = items;
    }
    
    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int row, int column) {
        ItemDTO item = items.get(row);
        Object obj=null;
        switch(column) {
            case 0 : obj = item.getItemCode(); break;
            case 1 : obj = item.getItemName(); break;
            case 2 : obj = item.getSupplier().getSupCode(); break;
            case 3 : obj = item.getUnit(); break;
            case 4 : obj = item.getPrice(); break;
            case 5 : obj = item.isSupplying(); break;
        }
        return obj;
    }
    
    
    
}
