/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelThu.java
 *
 * Created on Jan 3, 2012, 3:31:43 PM
 */
package vn.com.hkt.tree.ui.department.thuchi;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.OutlineView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import org.openide.windows.WindowManager;
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.pilot.datetime.utils.DateTimeUtils;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 *
 * @author longnt
 */
public class PanelThu extends javax.swing.JPanel implements ExplorerManager.Provider, ItemListener {

    private ExplorerManager explorerManager;
    private DepartmentParentTongQuan departmentParent;
    private OutlineView ov;
    private Node rootNode;
    private Department department;
    private DateTimeUtils dateTimeUtils;
    private String month1, month2, month3, year1, year2;
    private DefaultTableModel model;
    private DefaultComboBoxModel enterpriseModel;
    private List<Enterprise> listEnterprise = new ArrayList<Enterprise>();
    private IDepartmentBN departmentBN;
    private Enterprise enterprise;

    /** Creates new form PanelThu */
    public PanelThu() {
        initComponents();
        departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class);
        enterpriseModel = new DefaultComboBoxModel();
        if (enterpriseModel.getSize() == 0) {
            listEnterprise = departmentBN.enterpriseHasDepartment();
            if (listEnterprise != null) {
                for (Enterprise enterprise1 : listEnterprise) {
                    enterpriseModel.addElement(enterprise1);
                }
            }
        }
        cboEnterprise.setModel(enterpriseModel);
        cboEnterprise.addItemListener(this);
        Object item1 = enterpriseModel.getElementAt(0);
        cboEnterprise.setSelectedItem(item1);
        enterprise = (Enterprise) item1;
        panelTree.setLayout(new BorderLayout());
        department = new Department();
        dateTimeUtils = new DateTimeUtils();
        month1 = dateTimeUtils.getCurrentMonth() + "/" + dateTimeUtils.getCurrentYear();
        month2 = String.valueOf(dateTimeUtils.addMonth(-1)) + "/" + dateTimeUtils.addYearWithMonth(-1);
        month3 = String.valueOf(dateTimeUtils.addMonth(-2)) + "/" + dateTimeUtils.addYearWithMonth(-2);
        year1 = String.valueOf(dateTimeUtils.getCurrentYear());
        year2 = String.valueOf(dateTimeUtils.getCurrentYear() - 1);
        explorerManager = new ExplorerManager();
        departmentParent = new DepartmentParentTongQuan(department, enterprise);

        rootNode = new AbstractNode(departmentParent);
        ov = new OutlineView("Tên công ty");
        ov.setPropertyColumns(DepartmentParentTongQuan.ThuMonth1_PROPERTY, month1,
                DepartmentParentTongQuan.ThuMonth2_PROPERTY, month2,
                DepartmentParentTongQuan.ThuMonth3_PROPERTY, month3,
                DepartmentParentTongQuan.ThuYear1_PROPERTY, year1,
                DepartmentParentTongQuan.ThuYear2_PROPERTY, year2,
                DepartmentParentTongQuan.ThuAll_PROPERTY, "All");
        ov.getOutline().setRootVisible(true);
        ov.getOutline().setRowHeight(25);
        ov.getOutline().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         ov.getOutline().getColumnModel().getColumn(0).setPreferredWidth(400);
        //JOptionPane.showMessageDialog(null,  ov.getOutline().getColumnModel().getColumn(1).getPreferredWidth());

        panelTree.add(ov, BorderLayout.CENTER);
        // setLocationRelativeTo(null); 

        explorerManager.setRootContext(rootNode);
        explorerManager.getRootContext().setDisplayName("Department");

    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTree = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboEnterprise = new javax.swing.JComboBox();

        javax.swing.GroupLayout panelTreeLayout = new javax.swing.GroupLayout(panelTree);
        panelTree.setLayout(panelTreeLayout);
        panelTreeLayout.setHorizontalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelTreeLayout.setVerticalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        jLabel2.setText(org.openide.util.NbBundle.getMessage(PanelThu.class, "PanelThu.jLabel2.text")); // NOI18N

        cboEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(cboEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboEnterprise;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelTree;
    // End of variables declaration//GEN-END:variables

    @Override
    public ExplorerManager getExplorerManager() {
        return explorerManager;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        Object item = comboBox.getSelectedItem();
        if (comboBox == cboEnterprise) {
            //panelTree.removeAll();
            Enterprise enterprise1 = (Enterprise) item;
            OutlineView ov1 = new OutlineView("Phòng ban");
            // ov1 = new OutlineView("Phòng ban");
            ov1 = new OutlineView("Tên công ty");
            ov1.setPropertyColumns(DepartmentParentTongQuan.ThuMonth1_PROPERTY, "Thu",
                    DepartmentParentTongQuan.ChiMonth1_PROPERTY, "Chi",
                    DepartmentParentTongQuan.Lai1_PROPERTY, "Lãi(lỗ)",
                    DepartmentParentTongQuan.ThuYear1_PROPERTY, "Thu",
                    DepartmentParentTongQuan.ChiYear1_PROPERTY, "Chi",
                    DepartmentParentTongQuan.LaiYear1_PROPERTY, "Lãi(lỗ)",
                    DepartmentParentTongQuan.ThuAll_PROPERTY, "Thu",
                    DepartmentParentTongQuan.ChiAll_PROPERTY, "Chi",
                    DepartmentParentTongQuan.LaiAll_PROPERTY, "Lãi(lỗ)");

            ov1.getOutline().setRootVisible(true);
            ov1.getOutline().setRowHeight(25);
            ov1.getOutline().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
             ov1.getOutline().getColumnModel().getColumn(0).setPreferredWidth(400);
            panelTree.add(ov1, BorderLayout.CENTER);
            Node rootNode1 = new AbstractNode(new DepartmentParentTongQuan(department, enterprise1));
            explorerManager.setRootContext(rootNode1);
            explorerManager.getRootContext().setDisplayName("Operation");
            TreeDepartmentThuAllTopComponent tc = (TreeDepartmentThuAllTopComponent) WindowManager.getDefault().findTopComponent("TreeDepartmentThuAllTopComponent");
            if (tc != null) {

                tc.close();
                tc.open();
                tc.getPanelChart().removeAll();
                tc.getPanelChart().add(new ChartMonthThuChiDepartment(enterprise1));
            }


        }
    }
}