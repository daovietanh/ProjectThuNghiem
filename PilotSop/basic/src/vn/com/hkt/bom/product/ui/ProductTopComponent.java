/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.bom.product.ui;

import vn.com.hkt.pilot.entities.Product;
import vn.com.hkt.basic.api.IProductBN;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//vn.com.hkt.bom.product.ui//Product//EN",
autostore = false)
@TopComponent.Description(preferredID = "ProductTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "vn.com.hkt.bom.product.ui.ProductTopComponent")
@ActionReference(path = "Menu/Nhập Số Liệu" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_ProductAction",
preferredID = "ProductTopComponent")
public final class ProductTopComponent extends TopComponent implements ActionListener {

    private ProductPanel productPanel = new ProductPanel();
    private IProductBN productBN;

    public ProductTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(ProductTopComponent.class, "CTL_ProductTopComponent"));
        setToolTipText(NbBundle.getMessage(ProductTopComponent.class, "HINT_ProductTopComponent"));
        panelForm.setLayout(new GridLayout());
        panelForm.add(productPanel);

        buttonEdit.setEnabled(false);

        buttonSaveDS.addActionListener(this);
        buttonEdit.addActionListener(this);
        buttonExit.addActionListener(this);
        buttonHelp.addActionListener(this);
        buttonReset.addActionListener(this);
        buttonSave.addActionListener(this);
        this.productBN = Lookup.getDefault().lookup(IProductBN.class);
    }

    public ProductPanel getProductPanel() {
        return productPanel;
    }

    public JPanel getPanelForm() {
        return panelForm;
    }

    public JButton getButtonEdit() {
        return buttonEdit;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelForm = new javax.swing.JPanel();
        panelButton = new javax.swing.JPanel();
        buttonReset = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        buttonHelp = new javax.swing.JButton();
        buttonSaveDS = new javax.swing.JButton();

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );

        panelButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.openide.awt.Mnemonics.setLocalizedText(buttonReset, org.openide.util.NbBundle.getMessage(ProductTopComponent.class, "ProductTopComponent.buttonReset.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonEdit, org.openide.util.NbBundle.getMessage(ProductTopComponent.class, "ProductTopComponent.buttonEdit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonSave, org.openide.util.NbBundle.getMessage(ProductTopComponent.class, "ProductTopComponent.buttonSave.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonExit, org.openide.util.NbBundle.getMessage(ProductTopComponent.class, "ProductTopComponent.buttonExit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonHelp, org.openide.util.NbBundle.getMessage(ProductTopComponent.class, "ProductTopComponent.buttonHelp.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonSaveDS, org.openide.util.NbBundle.getMessage(ProductTopComponent.class, "ProductTopComponent.buttonSaveDS.text")); // NOI18N

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSaveDS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonReset)
                    .addComponent(buttonEdit)
                    .addComponent(buttonSave)
                    .addComponent(buttonExit)
                    .addComponent(buttonHelp)
                    .addComponent(buttonSaveDS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonSaveDS;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelForm;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
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
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        ListProductTopComponent listProductTopComponent = new ListProductTopComponent();

        if (button == buttonSaveDS) {
            update();
            reset();
            listProductTopComponent.open();
            this.close();
        }
        if (button == buttonReset) {
            reset();
            buttonEdit.setEnabled(false);
            productPanel.getTableProduct().setEnabled(true);
        }
        if (button == buttonExit) {
            this.close();
        }
        if (button == buttonSave) {

            update();
            this.close();
            this.open();
            reset();
        }
        if (button == buttonEdit) {
            buttonEdit.setEnabled(false);
            productPanel.getTableProduct().setEnabled(true);
        }
    }

    // reset lại table mỗi khi save hoặc muốn điền mới
    public void reset() {
        productPanel.getTableProduct().setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {"Tên sản phẩm dịch vụ", " "},
                    {"Mã sản phẩm dịch vụ", " "},
                    {"Công ty", " "},
                    {"Bộ phân (Phòng)", " "},
                    {"Người chịu trách nhiệm", " "},
                    {"Nhóm sản phẩm", " "}
                },
                new String[]{
                    "", ""
                }) {

            boolean[] canEdit = new boolean[]{
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        productPanel.getTableProduct().getColumnModel().getColumn(1).setCellEditor(new ProductCell());
    }

//    public void save() {
//        Product bean = null;
//
//        String id = productPanel.getTableProduct().getValueAt(1, 1).toString().trim();
//        String name = productPanel.getTableProduct().getValueAt(0, 1).toString().trim();
//        String cty = productPanel.getTableProduct().getValueAt(2, 1).toString().trim();
//        String bophan = productPanel.getTableProduct().getValueAt(3, 1).toString().trim();
//        String person = productPanel.getTableProduct().getValueAt(4, 1).toString().trim();
//
//        bean = new Product(id, name, cty, bophan, person);
//
//        productBN.insertProduct(bean);
//
//    }
    public void update() {
        Product bean = null;

        String id = productPanel.getTableProduct().getValueAt(1, 1).toString().trim();
        String name = productPanel.getTableProduct().getValueAt(0, 1).toString().trim();
        String cty = productPanel.getTableProduct().getValueAt(2, 1).toString().trim();
        String bophan = productPanel.getTableProduct().getValueAt(3, 1).toString().trim();
        String person = productPanel.getTableProduct().getValueAt(4, 1).toString().trim();
        String nhomsp = productPanel.getTableProduct().getValueAt(5, 1).toString().trim();
        bean = new Product(id, name, cty, bophan, person, nhomsp);

        if (productPanel.getTableProduct().getValueAt(0, 1).toString().trim().length() != 0) {
            productBN.updateProduct(bean);
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập tên");
        }
    }
}
