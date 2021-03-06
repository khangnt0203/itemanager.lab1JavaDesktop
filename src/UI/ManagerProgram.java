/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import DAO.ItemDAO;
import DTO.ItemModel;
import DTO.SupModel;
import DAO.SupDAO;
import DTO.ItemDTO;

import DTO.SupplierDTO;

import Util.Connection;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.util.logging.resources.logging;

/**
 *
 * @author Khang
 */
public class ManagerProgram extends javax.swing.JFrame {

    Connection dbAccess;

    SupDAO supDAO;
    SupModel supModel;
    boolean addSup = false;

    ItemDAO itemDAO;
    ItemModel itemModel;
    boolean addItem = false;
    Vector dataItem = new Vector();
    Vector<String> headerItem = new Vector<>();
    DefaultTableModel modelItem;

    int SUCCESS = 1;

    void loadSup() {
        try {
            List<SupplierDTO> sup = supDAO.getAllSup();
            for (SupplierDTO s : sup) {
                supDAO.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void loadItem() {
        try {
            itemDAO = ItemDAO.getAllItem();
            for (ItemDTO i : itemDAO) {
                Vector row = new Vector();
                row.add(i.getItemCode());
                row.add(i.getItemName());
                row.add(i.getSupplier());
                row.add(i.getUnit());
                row.add(i.getPrice());
                row.add(i.isSupplying());
                dataItem.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ManagerProgram() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Item Manager");
        dbAccess = new Connection();

        supDAO = new SupDAO();
        loadSup();
        supModel = new SupModel(supDAO);
        tblSupList.setModel(supModel);

        itemDAO = new ItemDAO();
        loadItem();
        itemModel = new ItemModel(itemDAO);

        headerItem.add("Item Code");
        headerItem.add("Item Name");
        headerItem.add("Supplier");
        headerItem.add("Unit");
        headerItem.add("Price");
        headerItem.add("Supplying");
        modelItem = (DefaultTableModel) tblItemList.getModel();
        modelItem.setDataVector(dataItem, headerItem);
        this.cbSupplier.setModel(new DefaultComboBoxModel(supDAO));

        tblItemList.updateUI();
        tblSupList.updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbItem = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSupList = new javax.swing.JTable();
        lbSupList = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbSupCode = new javax.swing.JLabel();
        txtSupCode = new javax.swing.JTextField();
        lbSupName = new javax.swing.JLabel();
        txtSupName = new javax.swing.JTextField();
        lbAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lbColloborating = new javax.swing.JLabel();
        chkColloborating = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        btnSupNew = new javax.swing.JButton();
        btnSupSave = new javax.swing.JButton();
        btnSupDel = new javax.swing.JButton();
        jpItem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItemList = new javax.swing.JTable();
        lbItemList = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbItemCode = new javax.swing.JLabel();
        txtItemCode = new javax.swing.JTextField();
        lbItemName = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        lbSupplier = new javax.swing.JLabel();
        cbSupplier = new javax.swing.JComboBox<>();
        lbUnit = new javax.swing.JLabel();
        txtUnit = new javax.swing.JTextField();
        lbPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lbSupplying = new javax.swing.JLabel();
        chkSupplying = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        btnItemNew = new javax.swing.JButton();
        btnItemSave = new javax.swing.JButton();
        btnItemDel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblSupList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSupList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupListMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblSupListMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblSupList);

        lbSupList.setText("Supplier List");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Supplier Detail"));
        jPanel8.setLayout(new java.awt.GridLayout(4, 2));

        lbSupCode.setText("Supplier Code");
        jPanel8.add(lbSupCode);
        jPanel8.add(txtSupCode);

        lbSupName.setText("Supplier Name");
        jPanel8.add(lbSupName);
        jPanel8.add(txtSupName);

        lbAddress.setText("Address");
        jPanel8.add(lbAddress);
        jPanel8.add(txtAddress);

        lbColloborating.setText("Colloborating");
        jPanel8.add(lbColloborating);
        jPanel8.add(chkColloborating);

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        btnSupNew.setText("New");
        btnSupNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupNewActionPerformed(evt);
            }
        });
        jPanel9.add(btnSupNew);

        btnSupSave.setText("Save");
        btnSupSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupSaveActionPerformed(evt);
            }
        });
        jPanel9.add(btnSupSave);

        btnSupDel.setText("Delete");
        btnSupDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupDelActionPerformed(evt);
            }
        });
        jPanel9.add(btnSupDel);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSupList)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lbSupList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1088, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tbItem.addTab("Manager Supplier", jPanel1);

        tblItemList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblItemList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemListMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblItemListMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblItemList);

        lbItemList.setText("Item List");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Item Detail"));
        jPanel3.setLayout(new java.awt.GridLayout(6, 2));

        lbItemCode.setText("Item Code");
        jPanel3.add(lbItemCode);
        jPanel3.add(txtItemCode);

        lbItemName.setText("Item Name");
        jPanel3.add(lbItemName);
        jPanel3.add(txtItemName);

        lbSupplier.setText("Supplier");
        jPanel3.add(lbSupplier);

        cbSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSupplierActionPerformed(evt);
            }
        });
        jPanel3.add(cbSupplier);

        lbUnit.setText("Unit");
        jPanel3.add(lbUnit);
        jPanel3.add(txtUnit);

        lbPrice.setText("Price");
        jPanel3.add(lbPrice);
        jPanel3.add(txtPrice);

        lbSupplying.setText("Supllying");
        jPanel3.add(lbSupplying);
        jPanel3.add(chkSupplying);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        btnItemNew.setText("New");
        btnItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemNewActionPerformed(evt);
            }
        });
        jPanel4.add(btnItemNew);

        btnItemSave.setText("Save");
        btnItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemSaveActionPerformed(evt);
            }
        });
        jPanel4.add(btnItemSave);

        btnItemDel.setText("Delete");
        btnItemDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemDelActionPerformed(evt);
            }
        });
        jPanel4.add(btnItemDel);

        javax.swing.GroupLayout jpItemLayout = new javax.swing.GroupLayout(jpItem);
        jpItem.setLayout(jpItemLayout);
        jpItemLayout.setHorizontalGroup(
            jpItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbItemList)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpItemLayout.setVerticalGroup(
            jpItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpItemLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpItemLayout.createSequentialGroup()
                        .addComponent(lbItemList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbItem.addTab("Manager Item", jpItem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbItem)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbItem, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblItemListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemListMouseReleased
        // TODO add your handling code here:
        int row = tblItemList.getSelectedRow();
        int col = tblItemList.getSelectedColumn();
        tblItemList.getCellEditor(row, col).cancelCellEditing();
    }//GEN-LAST:event_tblItemListMouseReleased

    private void tblItemListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemListMouseClicked
        // TODO add your handling code here:
        addItem = false;
        txtItemCode.setEditable(false);
        int pos = tblItemList.getSelectedRow();
        String find = tblItemList.getModel().getValueAt(pos, 0).toString();
        for (int i = 0; i < itemDAO.size(); i++) {
            if (find.equals(itemDAO.get(i).getItemCode())) {
                ItemDTO item = itemModel.getItems().get(i);
                txtItemCode.setText(item.getItemCode());
                txtItemName.setText(item.getItemName());
                txtItemCode.setEditable(false);
                int index = supDAO.find(item.getSupplier().getSupCode());
                cbSupplier.setSelectedIndex(index);
                txtUnit.setText(item.getUnit());
                txtPrice.setText("" + item.getPrice());
                chkSupplying.setSelected(item.isSupplying());
            }
        }

    }//GEN-LAST:event_tblItemListMouseClicked

    private void btnItemDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemDelActionPerformed
        int r = JOptionPane.showConfirmDialog(this, "Do you want to remove?", "Remove?", JOptionPane.YES_NO_OPTION);
        if (r == JOptionPane.YES_OPTION) {
            int selectedRow = tblItemList.getSelectedRow();
            String code = tblItemList.getValueAt(selectedRow, 0).toString();
            try {
                if (ItemDAO.delete(code) == SUCCESS) {
                    dataItem.remove(selectedRow);
                }
                JOptionPane.showMessageDialog(this, "Data remove");
            } catch (Exception e) {
                
            }
        }
        tblItemList.updateUI();
    }//GEN-LAST:event_btnItemDelActionPerformed

    private void btnItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemNewActionPerformed
        // TODO add your handling code here:
        txtItemCode.setEditable(true);
        txtItemCode.setText("");
        txtItemName.setText("");
        cbSupplier.setSelectedIndex(0);
        txtUnit.setText("");
        txtPrice.setText("");
        txtItemCode.requestFocus();
        chkSupplying.setSelected(true);
        addItem = true;
    }//GEN-LAST:event_btnItemNewActionPerformed
   
      public boolean validItem(){
        String code=txtItemCode.getText();
        if(!code.matches("[a-zA-Z0-9]{1,10}")){
            JOptionPane.showMessageDialog(rootPane, "Wrong code (no special char and has 1 to 10 char) <not white space>");
            txtItemCode.requestFocus();
            return false;
        }else{
            try {
                boolean check=itemDAO.checkCode(code);
                if(check==true){
                    JOptionPane.showMessageDialog(rootPane, "Code is valid!");
                    txtItemCode.requestFocus();
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }       
        }
        String name=txtItemName.getText();
        if(name.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Wrong name, must not be empty and maximum 50 characters");
            txtItemName.requestFocus();
            return false;
        }
        String unit=txtUnit.getText();
        if(unit.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Wrong unit, must not be empty and maximum 50 characters");
            txtUnit.requestFocus();
            return false;
        }
        if(txtPrice.getText().matches("[1-9][0-9]*\\.[0-9]+") || txtPrice.getText().matches("[1-9][0-9]*")){           
            return true;
        }else{
            JOptionPane.showMessageDialog(rootPane, "Please input a float number");
            txtPrice.requestFocus();
            return false;
        }
                
    }
    private void btnItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemSaveActionPerformed
        // TODO add your handling code here:
     
        String itemCode = txtItemCode.getText();
        String itemName = txtItemName.getText();
        SupplierDTO sup = (SupplierDTO) cbSupplier.getSelectedItem();
        String unit = txtUnit.getText();
        float price = Float.parseFloat(txtPrice.getText());
        boolean supplying = chkSupplying.isSelected();
        ItemDTO it = new ItemDTO(itemCode, itemName, sup, unit, price, supplying);
        if (addItem == true) {
            
            if (validItem()) {
                try {
                    int result = ItemDAO.insert(it);
                    if (result == SUCCESS) {
                        Vector row = new Vector();
                        row.add(itemCode);
                        row.add(itemName);
                        row.add(sup);
                        row.add(unit);
                        row.add(price);
                        row.add(supplying);
                        dataItem.add(row);
                 
                        JOptionPane.showMessageDialog(this, "Items has been added!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Cannot Insert");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                int result = ItemDAO.update(it);
                if (result == SUCCESS) {
                    int selectedRow = tblItemList.getSelectedRow();
                    itemDAO.get(selectedRow).setItemName(itemName);
                    itemDAO.get(selectedRow).setSupplier(sup);
                    itemDAO.get(selectedRow).setUnit(unit);
                    itemDAO.get(selectedRow).setPrice(price);
                    itemDAO.get(selectedRow).setSupplying(supplying);
                
                    JOptionPane.showMessageDialog(rootPane, "Item has been updated!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tblItemList.updateUI();
        tblSupList.updateUI();
    }//GEN-LAST:event_btnItemSaveActionPerformed

    private void tblSupListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupListMouseClicked
        // TODO add your handling code here:
        addSup = false;
        txtSupCode.setEditable(false);
        tblItemList.updateUI();
        int pos = tblSupList.getSelectedRow();
        String find = tblSupList.getModel().getValueAt(pos, 0).toString();
        for (int i = 0; i < supDAO.size(); i++) {
            if (find.equals(supDAO.get(i).getSupCode())) {
                SupplierDTO sup = supModel.getSup().get(i);
                txtSupCode.setText(sup.getSupCode());
                txtSupName.setText(sup.getSupName());
                txtAddress.setText(sup.getAddress());
                chkColloborating.setSelected(sup.isColloborating());
            }
        }
    }//GEN-LAST:event_tblSupListMouseClicked

    private void tblSupListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupListMouseReleased
        // TODO add your handling code here:
        int row = tblSupList.getSelectedRow();
        int col = tblSupList.getSelectedColumn();
        tblSupList.getCellEditor(row, col).cancelCellEditing();
    }//GEN-LAST:event_tblSupListMouseReleased

    private void btnSupNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupNewActionPerformed
        // TODO add your handling code here:
        addSup = true;
        txtSupCode.setEditable(true);
        txtAddress.setText("");
        txtSupCode.setText("");
        txtSupName.setText("");
        chkColloborating.setSelected(false);
        txtSupCode.requestFocus();
    }//GEN-LAST:event_btnSupNewActionPerformed

    public boolean validSup() {
        String code = txtSupCode.getText();
        if (!code.matches("[a-zA-Z0-9]{1,10}")) {
            JOptionPane.showMessageDialog(rootPane, "Wrong code (no special char and has 1 to 10 char) <not white space>");
            txtSupCode.requestFocus();
            return false;
        } else {
            try {
                boolean check = supDAO.checkCode(code);
                if (check == true) {
                    JOptionPane.showMessageDialog(rootPane, "Code is valid!");
                    txtSupCode.requestFocus();
                    return false;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }

        }
        String name = txtSupName.getText();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Wrong name, must not be empty and maximum 50 characters");
            txtSupName.requestFocus();
            return false;
        }
        String addr = txtAddress.getText();
        if (addr.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Wrong address, must not be empty and maximum 50 characters");
            txtAddress.requestFocus();
            return false;
        }
        return true;
    }
    private void btnSupSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupSaveActionPerformed
        // TODO add your handling code here:
        String supCode = txtSupCode.getText();
        String supName = txtSupName.getText();
        String address = txtAddress.getText();
        boolean colloborating = chkColloborating.isSelected();
        SupplierDTO newSup = new SupplierDTO(supCode, supName, address, colloborating);
        if (addSup == true) {

            if (validSup()) {
                try {
                    if (SupDAO.insert(newSup) == SUCCESS) {
                        supDAO.add(newSup);
                        JOptionPane.showMessageDialog(this, "Supplier has been added!");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (addSup == false) {
            try {
                if (SupDAO.update(newSup) == SUCCESS) {
                    int selectSup = tblSupList.getSelectedRow();
                    supDAO.get(selectSup).setSupName(supName);
                    supDAO.get(selectSup).setAddress(address);
                    supDAO.get(selectSup).setColloborating(colloborating);
                    JOptionPane.showMessageDialog(this, "Supplier has been updated!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tblSupList.updateUI();
        tblItemList.updateUI();
    }//GEN-LAST:event_btnSupSaveActionPerformed

    private void btnSupDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupDelActionPerformed
        // TODO add your handling code here:
        try {
            boolean check = itemDAO.checkSupCodeTblItem(txtSupCode.getText());
            if (check) {
                JOptionPane.showMessageDialog(this, "This Supplier still has Item! Delete all items and Try again!");
            } else {
                int selectSup = tblSupList.getSelectedRow();
                String sup = supDAO.get(selectSup).toString();
                int r = JOptionPane.showConfirmDialog(this, "Delete: " + sup + " ?", "Remove?", JOptionPane.YES_NO_OPTION);
                if (r == JOptionPane.YES_OPTION) {

                    try {
                        String supCode = tblSupList.getValueAt(selectSup, 0).toString();
                        if (SupDAO.delete(supCode) == SUCCESS) {
                            supDAO.remove(selectSup);
                            tblSupList.updateUI();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnSupDelActionPerformed

    private void cbSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSupplierActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManagerProgram.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerProgram.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerProgram.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerProgram.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerProgram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnItemDel;
    private javax.swing.JButton btnItemNew;
    private javax.swing.JButton btnItemSave;
    private javax.swing.JButton btnSupDel;
    private javax.swing.JButton btnSupNew;
    private javax.swing.JButton btnSupSave;
    private javax.swing.JComboBox<String> cbSupplier;
    private javax.swing.JCheckBox chkColloborating;
    private javax.swing.JCheckBox chkSupplying;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpItem;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbColloborating;
    private javax.swing.JLabel lbItemCode;
    private javax.swing.JLabel lbItemList;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbSupCode;
    private javax.swing.JLabel lbSupList;
    private javax.swing.JLabel lbSupName;
    private javax.swing.JLabel lbSupplier;
    private javax.swing.JLabel lbSupplying;
    private javax.swing.JLabel lbUnit;
    private javax.swing.JTabbedPane tbItem;
    private javax.swing.JTable tblItemList;
    private javax.swing.JTable tblSupList;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSupCode;
    private javax.swing.JTextField txtSupName;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
