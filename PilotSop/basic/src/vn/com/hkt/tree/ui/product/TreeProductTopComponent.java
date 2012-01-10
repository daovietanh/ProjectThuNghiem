/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.product;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerManager;
import org.openide.explorer.view.OutlineView;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Node;
import org.openide.util.Lookup;
import vn.com.hkt.basic.api.IProductBN;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//vn.com.hkt.tree.ui.product//TreeProduct//EN",
autostore = false)
@TopComponent.Description(preferredID = "TreeProductTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "vn.com.hkt.tree.ui.product.TreeProductTopComponent")
@ActionReference(path = "Menu/Logistics/Quản Lý Kho" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_TreeProductAction",
preferredID = "TreeProductTopComponent")
public final class TreeProductTopComponent extends TopComponent implements ExplorerManager.Provider, ItemListener {

    private ExplorerManager explorerManager;
    private DefaultComboBoxModel enterpriseModel;
    private List<Enterprise> listEnterprise = new ArrayList<Enterprise>();
    private IProductBN productBN;
    private OutlineView ov;

    public TreeProductTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(TreeProductTopComponent.class, "CTL_TreeProductTopComponent"));
        setToolTipText(NbBundle.getMessage(TreeProductTopComponent.class, "HINT_TreeProductTopComponent"));

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topComponent1 = new org.openide.windows.TopComponent();
        panelTree = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboEnterprise = new javax.swing.JComboBox();

        javax.swing.GroupLayout panelTreeLayout = new javax.swing.GroupLayout(panelTree);
        panelTree.setLayout(panelTreeLayout);
        panelTreeLayout.setHorizontalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        panelTreeLayout.setVerticalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(TreeProductTopComponent.class, "TreeProductTopComponent.jLabel1.text")); // NOI18N

        cboEnterprise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout topComponent1Layout = new javax.swing.GroupLayout(topComponent1);
        topComponent1.setLayout(topComponent1Layout);
        topComponent1Layout.setHorizontalGroup(
            topComponent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        topComponent1Layout.setVerticalGroup(
            topComponent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topComponent1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(topComponent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(topComponent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboEnterprise;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelTree;
    private org.openide.windows.TopComponent topComponent1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        productBN = Lookup.getDefault().lookup(IProductBN.class);
        panelTree.setLayout(new BorderLayout());
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

        explorerManager = new ExplorerManager();
        Object item1 = enterpriseModel.getElementAt(0);
        cboEnterprise.setSelectedItem(item1);
        Enterprise enterprise = (Enterprise) item1;
        ov = new OutlineView("Phòng ban");
        ov.setPropertyColumns(ProductNode.Congtyme_PROPERTY, "Công ty",
                ProductNode.Giamdoc_PROPERTY, "Người chịu trách nhiệm");
        ov.getOutline().setRootVisible(true);
        ov.getOutline().setRowHeight(25);
        panelTree.add(ov, BorderLayout.CENTER);
        Node rootNode = new AbstractNode(new ProductParent(enterprise));
        explorerManager.setRootContext(rootNode);
        explorerManager.getRootContext().setDisplayName("Department");
    }

    @Override
    public void componentClosed() {
        cboEnterprise.removeItemListener(this);
        enterpriseModel.removeAllElements();
        productBN = null;
        panelTree.removeAll();
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

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
            OutlineView ov1 = new OutlineView("Công ty HKT");
          //  ov1 = new OutlineView("Phòng ban");
            ov1.setPropertyColumns(ProductNode.Congtyme_PROPERTY, "Công ty",
                    ProductNode.Giamdoc_PROPERTY, "Người chịu trách nhiệm");
            ov1.getOutline().setRootVisible(true);
            ov1.getOutline().setRowHeight(25);
            panelTree.add(ov1, BorderLayout.CENTER);
            Node rootNode = new AbstractNode(new ProductParent(enterprise1));
            explorerManager.setRootContext(rootNode);
            explorerManager.getRootContext().setDisplayName("Department");
        }

    }
}
