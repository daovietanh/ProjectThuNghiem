/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelTongQuan.java
 *
 * Created on Jan 3, 2012, 2:39:21 PM
 */
package vn.com.hkt.tree.ui.product.thuchi;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.OutlineView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import org.openide.windows.WindowManager;
import vn.com.hkt.basic.api.IProductBN;
import vn.com.hkt.pilot.datetime.utils.DateTimeUtils;
import vn.com.hkt.pilot.entities.Product;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 *
 * @author longnt
 */
public class PanelTongQuan extends javax.swing.JPanel implements ExplorerManager.Provider, ItemListener {

    private ExplorerManager explorerManager;
    private ProductParentTongQuan ProductParent;
    private OutlineView ov;
    private Node rootNode;
    private Product product;
    private DateTimeUtils dateTimeUtils;
    private String month1, year2;
    private DefaultTableModel model;
    private DefaultComboBoxModel enterpriseModel;
    private List<Enterprise> listEnterprise = new ArrayList<Enterprise>();
    private IProductBN productBN;
    private Enterprise enterprise;

    /** Creates new form PanelTongQuan */
    public PanelTongQuan() {
        initComponents();
        productBN = Lookup.getDefault().lookup(IProductBN.class);
        enterpriseModel = new DefaultComboBoxModel();
        if (enterpriseModel.getSize() == 0) {
            listEnterprise = productBN.enterpriseHasProduct();
            if (listEnterprise != null) {
                for (Enterprise enterprise1 : listEnterprise) {
                    enterpriseModel.addElement(enterprise1);
                }
            }
        }
        cboEnterprise.setModel(enterpriseModel);
        cboEnterprise.addItemListener(this);
        Object item1 = enterpriseModel.getElementAt(0);
        //cboEnterprise.setSelectedItem(item1);
        enterprise = (Enterprise) item1;
        panelTree.setLayout(new BorderLayout());
        product = new Product();
        dateTimeUtils = new DateTimeUtils();
        month1 = dateTimeUtils.getCurrentMonth() + "/" + dateTimeUtils.getCurrentYear();

        year2 = String.valueOf(dateTimeUtils.getCurrentYear() - 1);
        explorerManager = new ExplorerManager();
        ProductParent = new ProductParentTongQuan(product, enterprise);

        rootNode = new AbstractNode(ProductParent);
        ov = new OutlineView("Tên công ty");
        ov.setPropertyColumns(ProductParentTongQuan.ThuMonth1_PROPERTY, "Thu",
                ProductParentTongQuan.ChiMonth1_PROPERTY, "Chi",
                ProductParentTongQuan.Lai1_PROPERTY, "Lãi(lỗ)",
                ProductParentTongQuan.ThuYear1_PROPERTY, "Thu",
                ProductParentTongQuan.ChiYear1_PROPERTY, "Chi",
                ProductParentTongQuan.LaiYear1_PROPERTY, "Lãi(lỗ)",
                ProductParentTongQuan.ThuAll_PROPERTY, "Thu",
                ProductParentTongQuan.ChiAll_PROPERTY, "Chi",
                ProductParentTongQuan.LaiAll_PROPERTY, "Lãi(lỗ)");

        ov.getOutline().setRootVisible(true);
        ov.getOutline().setRowHeight(25);
        ov.getOutline().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ov.getOutline().getColumnModel().getColumn(0).setPreferredWidth(400);
        //JOptionPane.showMessageDialog(null,  ov.getOutline().getColumnModel().getColumn(1).getPreferredWidth());

        panelTree.add(ov, BorderLayout.CENTER);
        // setLocationRelativeTo(null); 

        explorerManager.setRootContext(rootNode);
        explorerManager.getRootContext().setDisplayName("Product");


        String[] header = {"Tree Product", month1, year2, "All"};
        model = new DefaultTableModel(header, 0);
        tableTitle.setModel(model);

        // Tạo title cho table Outline
        tableTitle.getColumnModel().getColumn(0).setPreferredWidth(350);
        //tableTitle.getColumnModel().getColumn(0).setMaxWidth(125);
        //tableTitle.getColumnModel().getColumn(0).setMinWidth(125);
        tableTitle.getColumnModel().getColumn(1).setPreferredWidth(225);
        tableTitle.getColumnModel().getColumn(2).setPreferredWidth(225);
        tableTitle.getColumnModel().getColumn(3).setPreferredWidth(225);

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableTitle = new javax.swing.JTable();
        panelTree = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboEnterprise = new javax.swing.JComboBox();

        tableTitle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tree Enterprise", "12/2011", "11/2011", "10/2011", "2011", "2010", "All"
            }
        ));
        jScrollPane1.setViewportView(tableTitle);

        javax.swing.GroupLayout panelTreeLayout = new javax.swing.GroupLayout(panelTree);
        panelTree.setLayout(panelTreeLayout);
        panelTreeLayout.setHorizontalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelTreeLayout.setVerticalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 259, Short.MAX_VALUE)
        );

        jLabel2.setText(org.openide.util.NbBundle.getMessage(PanelTongQuan.class, "PanelTongQuan.jLabel2.text")); // NOI18N

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboEnterprise;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelTree;
    private javax.swing.JTable tableTitle;
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
            panelTree.removeAll();
            Enterprise enterprise1 = (Enterprise) item;
            OutlineView ov1 = new OutlineView("Phòng ban");
            // ov1 = new OutlineView("Phòng ban");
            ov1 = new OutlineView("Tên công ty");
            ov1.setPropertyColumns(ProductParentTongQuan.ThuMonth1_PROPERTY, "Thu",
                    ProductParentTongQuan.ChiMonth1_PROPERTY, "Chi",
                    ProductParentTongQuan.Lai1_PROPERTY, "Lãi(lỗ)",
                    ProductParentTongQuan.ThuYear1_PROPERTY, "Thu",
                    ProductParentTongQuan.ChiYear1_PROPERTY, "Chi",
                    ProductParentTongQuan.LaiYear1_PROPERTY, "Lãi(lỗ)",
                    ProductParentTongQuan.ThuAll_PROPERTY, "Thu",
                    ProductParentTongQuan.ChiAll_PROPERTY, "Chi",
                    ProductParentTongQuan.LaiAll_PROPERTY, "Lãi(lỗ)");

            ov1.getOutline().setRootVisible(true);
            ov1.getOutline().setRowHeight(25);
            ov1.getOutline().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
               ov1.getOutline().getColumnModel().getColumn(0).setPreferredWidth(400);
            panelTree.add(ov1, BorderLayout.CENTER);
            Node rootNode1 = new AbstractNode(new ProductParentTongQuan(product, enterprise1));
            explorerManager.setRootContext(rootNode1);
            explorerManager.getRootContext().setDisplayName("Operation");
            TreeProductThuChiAllTopComponent tc = (TreeProductThuChiAllTopComponent) WindowManager.getDefault().findTopComponent("TreeProductThuChiAllTopComponent");
            if (tc != null) {
               
                tc.close();
                tc.open();
                 tc.getPanelChart().removeAll();
                tc.getPanelChart().add(new ChartMonthThuChiProduct(enterprise1));
            }


        }

    }
}
