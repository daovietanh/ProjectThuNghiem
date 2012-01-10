/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListEnterprisePanel.java
 *
 * Created on Nov 23, 2011, 2:16:58 PM
 */
package vn.com.hkt.erm.enterprise.ui;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author longnt
 */
public class ListEnterprisePanel extends javax.swing.JPanel {


    /** Creates new form ListEnterprisePanel */
    public ListEnterprisePanel() {
        initComponents();
        JComboBox cboEnterprise = new JComboBox();
        JComboBox cboPerson = new JComboBox();
        
        tableListE.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(cboEnterprise));
        tableListE.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(cboPerson));
    }

    @Override
    public String toString() {
        return "Enterprise Base";
    }
    
    
    public JTable getTableListE() {
        return tableListE;
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
        tableListE = new javax.swing.JTable();

        tableListE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên công ty", "Mã công ty", "Công ty mẹ", "Giám đốc", "Logo", "Slogan"
            }
        ));
        jScrollPane1.setViewportView(tableListE);

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
    public javax.swing.JTable tableListE;
    // End of variables declaration//GEN-END:variables
}
