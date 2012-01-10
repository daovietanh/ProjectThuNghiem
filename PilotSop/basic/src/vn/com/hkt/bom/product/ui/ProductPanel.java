/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ProductPanel.java
 *
 * Created on Nov 23, 2011, 4:15:46 PM
 */
package vn.com.hkt.bom.product.ui;

import vn.com.hkt.bom.product.ui.ProductCell;
import javax.swing.JTable;

/**
 *
 * @author longnt
 */
public class ProductPanel extends javax.swing.JPanel {

    /** Creates new form ProductPanel */
    public ProductPanel() {
        initComponents();
        tableProduct.getColumnModel().getColumn(1).setCellEditor(new ProductCell());
    }

    public JTable getTableProduct() {
        return tableProduct;
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
        tableProduct = new javax.swing.JTable();

        tableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tên sản phẩm dịch vụ", " "},
                {"Mã sản phẩm dịch vụ", " "},
                {"Công ty", " "},
                {"Bộ phân (Phòng)", " "},
                {"Người chịu trách nhiệm", " "},
                {"Nhóm sản phẩm", " "}
            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProduct.setRowHeight(25);
        jScrollPane1.setViewportView(tableProduct);

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
    private javax.swing.JTable tableProduct;
    // End of variables declaration//GEN-END:variables
}