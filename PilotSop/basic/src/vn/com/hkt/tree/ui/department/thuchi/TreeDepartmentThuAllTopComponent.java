/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.department.thuchi;

import java.awt.GridLayout;
import javax.swing.JPanel;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.explorer.ExplorerUtils;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//vn.com.hkt.tree.ui.department.thuchi//TreeDepartmentThuAll//EN",
autostore = false)
@TopComponent.Description(preferredID = "TreeDepartmentThuAllTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "vn.com.hkt.tree.ui.department.thuchi.TreeDepartmentThuAllTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_TreeDepartmentThuAllAction",
preferredID = "TreeDepartmentThuAllTopComponent")
public final class TreeDepartmentThuAllTopComponent extends TopComponent {

    private PanelThu panelThu = new PanelThu();

    public TreeDepartmentThuAllTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(TreeDepartmentThuAllTopComponent.class, "CTL_TreeDepartmentThuAllTopComponent"));
        setToolTipText(NbBundle.getMessage(TreeDepartmentThuAllTopComponent.class, "HINT_TreeDepartmentThuAllTopComponent"));

        panelTong.setLayout(new GridLayout(2, 1));
        panelTree.setLayout(new GridLayout());
        panelTong.add(panelTree);
        panelTong.add(panelChart);
        associateLookup(ExplorerUtils.createLookup(panelThu.getExplorerManager(), getActionMap()));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelButton = new javax.swing.JPanel();
        buttonTongQuan = new javax.swing.JButton();
        buttonThu = new javax.swing.JButton();
        buttonChi = new javax.swing.JButton();
        buttonCanBang = new javax.swing.JButton();
        panelTong = new javax.swing.JPanel();
        panelTree = new javax.swing.JPanel();
        panelChart = new javax.swing.JPanel();

        org.openide.awt.Mnemonics.setLocalizedText(buttonTongQuan, org.openide.util.NbBundle.getMessage(TreeDepartmentThuAllTopComponent.class, "TreeDepartmentThuAllTopComponent.buttonTongQuan.text")); // NOI18N
        buttonTongQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTongQuanActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(buttonThu, org.openide.util.NbBundle.getMessage(TreeDepartmentThuAllTopComponent.class, "TreeDepartmentThuAllTopComponent.buttonThu.text")); // NOI18N
        buttonThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonThuActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(buttonChi, org.openide.util.NbBundle.getMessage(TreeDepartmentThuAllTopComponent.class, "TreeDepartmentThuAllTopComponent.buttonChi.text")); // NOI18N
        buttonChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChiActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(buttonCanBang, org.openide.util.NbBundle.getMessage(TreeDepartmentThuAllTopComponent.class, "TreeDepartmentThuAllTopComponent.buttonCanBang.text")); // NOI18N
        buttonCanBang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCanBangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonTongQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonThu, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonChi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCanBang, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonThu)
                    .addComponent(buttonChi)
                    .addComponent(buttonCanBang)
                    .addComponent(buttonTongQuan))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTreeLayout = new javax.swing.GroupLayout(panelTree);
        panelTree.setLayout(panelTreeLayout);
        panelTreeLayout.setHorizontalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );
        panelTreeLayout.setVerticalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelChartLayout = new javax.swing.GroupLayout(panelChart);
        panelChart.setLayout(panelChartLayout);
        panelChartLayout.setHorizontalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );
        panelChartLayout.setVerticalGroup(
            panelChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelTongLayout = new javax.swing.GroupLayout(panelTong);
        panelTong.setLayout(panelTongLayout);
        panelTongLayout.setHorizontalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTongLayout.setVerticalGroup(
            panelTongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTongLayout.createSequentialGroup()
                .addComponent(panelTree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTongQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTongQuanActionPerformed
        this.close();
        TreeDepartmentThuChiAllTopComponent tc = (TreeDepartmentThuChiAllTopComponent) WindowManager.getDefault().findTopComponent("TreeDepartmentThuChiAllTopComponent");
        tc.open();
    }//GEN-LAST:event_buttonTongQuanActionPerformed

    private void buttonThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonThuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonThuActionPerformed

    private void buttonChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChiActionPerformed
         this.close();
        TreeDepartmentChiAllTopComponent tc = (TreeDepartmentChiAllTopComponent) WindowManager.getDefault().findTopComponent("TreeDepartmentChiAllTopComponent");
        tc.open();
    }//GEN-LAST:event_buttonChiActionPerformed

    private void buttonCanBangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCanBangActionPerformed
         this.close();
        TreeDepartmentCanBangAllTopComponent tc = (TreeDepartmentCanBangAllTopComponent) WindowManager.getDefault().findTopComponent("TreeDepartmentCanBangAllTopComponent");
        tc.open();
    }//GEN-LAST:event_buttonCanBangActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCanBang;
    private javax.swing.JButton buttonChi;
    private javax.swing.JButton buttonThu;
    private javax.swing.JButton buttonTongQuan;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelChart;
    private javax.swing.JPanel panelTong;
    private javax.swing.JPanel panelTree;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        panelChart.setLayout(new GridLayout());
        panelChart.add(new ChartMonthThuChiDepartment(panelThu.getEnterprise()));
        panelTree.removeAll();
        panelTree.add(panelThu);
        buttonThu.setEnabled(false);
    }

    public JPanel getPanelChart() {
        return panelChart;
    }

    @Override
    public void componentClosed() {
        panelChart.removeAll();
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
}
