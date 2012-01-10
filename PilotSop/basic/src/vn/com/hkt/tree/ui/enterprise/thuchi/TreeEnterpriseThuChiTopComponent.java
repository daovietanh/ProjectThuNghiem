/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.enterprise.thuchi;

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
import vn.com.hkt.pilot.datetime.utils.DateTimeUtils;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//vn.com.hkt.tree.ui.enterprise.thuchi//TreeEnterpriseThuChi//EN",
autostore = false)
@TopComponent.Description(preferredID = "TreeEnterpriseThuChiTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "vn.com.hkt.tree.ui.enterprise.thuchi.TreeEnterpriseThuChiTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_TreeEnterpriseThuChiAction",
preferredID = "TreeEnterpriseThuChiTopComponent")
public final class TreeEnterpriseThuChiTopComponent extends TopComponent implements ExplorerManager.Provider, LookupListener  {

    private ExplorerManager explorerManager;
    private EnterpriseParent enterpriseParent;
    private Lookup.Result<Enterprise> result = null;
    private OutlineView ov;
    private Node rootNode;
    private Enterprise enterprise;
    public TreeEnterpriseThuChiTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(TreeEnterpriseThuChiTopComponent.class, "CTL_TreeEnterpriseThuChiTopComponent"));
        setToolTipText(NbBundle.getMessage(TreeEnterpriseThuChiTopComponent.class, "HINT_TreeEnterpriseThuChiTopComponent"));
        panelTree.setLayout(new BorderLayout());
        enterprise = new Enterprise();
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelTreeLayout.setVerticalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelTree;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
       explorerManager = new ExplorerManager();
        enterpriseParent = new EnterpriseParent(enterprise);

        rootNode = new AbstractNode(enterpriseParent);
        ov = new OutlineView("Tên công ty");
        ov.setPropertyColumns(EnterpriseNode.Giamdoc_PROPERTY, "All Thu",
                EnterpriseNode.Congtyme_PROPERTY, "All Chi");

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
