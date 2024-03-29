/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OperationPanel.java
 *
 * Created on Nov 23, 2011, 4:33:23 PM
 */
package vn.com.hkt.bom.operation.ui;

import javax.swing.JTable;
import org.openide.windows.WindowManager;

/**
 *
 * @author longnt
 */
public class OperationPanel extends javax.swing.JPanel {

    /** Creates new form OperationPanel */
    public OperationPanel() {
        initComponents();
        tableO.getColumnModel().getColumn(1).setCellEditor(new OperationCell());
    }

    public JTable getTableO() {
        return tableO;
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
        tableO = new javax.swing.JTable();

        tableO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Tên nghiệp vụ", " "},
                {"Mã nghiệp vụ", " "},
                {"Ngày tháng năm", " "},
                {"Sản phảm dịch vụ", " "},
                {"Công ty", " "},
                {"Bộ phận (Phòng)", " "},
                {"Người chịu trách nhiệm", " "},
                {"Phân loại", " "},
                {"Số lượng", "0"},
                {"Đơn giá", "0"},
                {"Tổng giá", "0"},
                {"Đơn vị tính", " "},
                {"Đơn vị đo", " "}
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
        tableO.setRowHeight(25);
        tableO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableO);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOMouseClicked
        if (evt.getClickCount() == 2) {
            if (tableO.getSelectedRow() == 7) {
                EditPhanLoaiDialog editPhanLoaiDialog = new EditPhanLoaiDialog();
                editPhanLoaiDialog.setVisible(true);
 
            }

        }
        //  ctrlPress = false;

    }//GEN-LAST:event_tableOMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableO;
    // End of variables declaration//GEN-END:variables
}
