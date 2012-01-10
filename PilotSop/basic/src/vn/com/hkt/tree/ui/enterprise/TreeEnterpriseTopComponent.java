/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.enterprise;

import vn.com.hkt.pilot.entities.Enterprise;
import java.awt.BorderLayout;
import java.util.Collection;
import org.openide.util.LookupEvent;
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
import org.openide.util.LookupListener;
import org.openide.util.Utilities;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//vn.com.hkt.tree.ui//TreeEnterprise//EN",
autostore = false)
@TopComponent.Description(preferredID = "TreeEnterpriseTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "vn.com.hkt.tree.ui.TreeEnterpriseTopComponent")
@ActionReference(path = "Menu/Thị Trường" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_TreeEnterpriseAction",
preferredID = "TreeEnterpriseTopComponent")
public final class TreeEnterpriseTopComponent extends TopComponent implements ExplorerManager.Provider, LookupListener {

    private ExplorerManager explorerManager;
    private EnterpriseParent enterpriseParent;
    private Lookup.Result<Enterprise> result = null;
    private OutlineView ov;
    private Node rootNode;

    public TreeEnterpriseTopComponent() {

        initComponents();
        setName(NbBundle.getMessage(TreeEnterpriseTopComponent.class, "CTL_TreeEnterpriseTopComponent"));
        setToolTipText(NbBundle.getMessage(TreeEnterpriseTopComponent.class, "HINT_TreeEnterpriseTopComponent"));


        panelTree.setLayout(new BorderLayout());
       // associateLookup(ExplorerUtils.createLookup(explorerManager, getActionMap()));

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTree = new javax.swing.JPanel();

        javax.swing.GroupLayout panelTreeLayout = new javax.swing.GroupLayout(panelTree);
        panelTree.setLayout(panelTreeLayout);
        panelTreeLayout.setHorizontalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
        );
        panelTreeLayout.setVerticalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelTree;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {

        explorerManager = new ExplorerManager();
        enterpriseParent = new EnterpriseParent();

        rootNode = new AbstractNode(enterpriseParent);
        ov = new OutlineView("Tên công ty");
        ov.setPropertyColumns(EnterpriseNode.Giamdoc_PROPERTY, "Giám đốc",
                EnterpriseNode.Congtyme_PROPERTY, "Công ty mẹ");

        ov.getOutline().setRootVisible(true);
        ov.getOutline().setRowHeight(25);
        panelTree.add(ov, BorderLayout.CENTER);

        explorerManager.setRootContext(rootNode);
        explorerManager.getRootContext().setDisplayName("Enterprise");


        result = Utilities.actionsGlobalContext().lookupResult(Enterprise.class);
        result.addLookupListener(this);
    }

    @Override
    public void componentClosed() {
        panelTree.remove(ov);
        result.removeLookupListener(this);
        result = null;
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
    public void resultChanged(LookupEvent le) {
        Collection<? extends Enterprise> allEvents = result.allInstances();
        if (!allEvents.isEmpty()) {
            Enterprise enterprise = allEvents.iterator().next();
        }
    }
}
