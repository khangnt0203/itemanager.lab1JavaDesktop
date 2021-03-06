/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.SupDAO;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Khang
 */
public class SupModel extends AbstractTableModel{
    SupDAO sup = null;
    
    public SupModel (SupDAO sup)
    {
        this.sup=sup;
    }
    
    public SupDAO getSup()
    {
        return sup;
    }
    
    public int getRowCount()
    {
        return sup.size();
    }
    
    public int getColumnCount()
    {
        return 3;
    }
    
    @Override 
    public String getColumnName (int column)
    {
        String columnName="";
        switch(column)
        {
            case 0: columnName="Supplier Code:";break;
            case 1: columnName="Supplier Name:";break;
            case 2: columnName="Address";break;
            case 3: columnName="Colloboration";break;
        }
        return columnName;
    }
    
    public Object getValueAt(int row, int column)
    {
        SupplierDTO s = sup.get(row);
        Object obj = null;
        switch(column)
        {
            case 0: obj=s.getSupCode();break;
            case 1: obj=s.getSupName();break;
            case 2: obj=s.getAddress();break;
            case 3: obj=s.isColloborating();break;
        }
        return obj;
    }
}
