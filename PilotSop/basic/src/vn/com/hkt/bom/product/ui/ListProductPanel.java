/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListProductPanel.java
 *
 * Created on Nov 23, 2011, 4:18:55 PM
 */
package vn.com.hkt.bom.product.ui;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author longnt
 */
public class ListProductPanel extends javax.swing.JPanel {

    /** Creates new form ListProductPanel */
    public ListProductPanel() {
        initComponents();

        JComboBox cboEnterprise = new JComboBox();
        JComboBox cboPerson = new JComboBox();
        JComboBox cboDepartment = new JComboBox();

        tableListPr.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(cboEnterprise));
        tableListPr.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(cboDepartment));
        tableListPr.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(cboPerson));
    }

    public JTable getTableListPr() {
        return tableListPr;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableListPr = new javax.swing.JTable();

        tableListPr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên sản phẩm dịch vụ",  "Mã sản phẩm dịch vụ", "Công ty", "Bộ phận (Phòng)", "Người chịu trách nhiệm", "Nhóm sản phẩm"
            }
        ));
        jScrollPane1.setViewportView(tableListPr);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableListPr;
    // End of variables declaration//GEN-END:variables
}
