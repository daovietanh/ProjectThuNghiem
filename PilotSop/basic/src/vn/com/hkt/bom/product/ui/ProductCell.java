/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.bom.product.ui;

import java.awt.event.ItemEvent;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;
import vn.com.hkt.pilot.entities.Product;
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.basic.api.IEnterpriseBN;
import vn.com.hkt.basic.api.IPersonBN;
import vn.com.hkt.basic.api.IProductBN;
import java.awt.Component;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import org.openide.util.Lookup;

/**
 *
 * @author longnt
 */
public class ProductCell extends AbstractCellEditor implements TableCellEditor, ItemListener {

    private Component component;
    private JComboBox cboEnterprise, cboPerson, cboDepartment, cboProductParent;
    private JTextField txtNamePro, txtIdPro;
    private DefaultComboBoxModel modelPerson, modelEnter, modelDepartment, modelProductParent;
    private IEnterpriseBN enterpriseDAO;
    private IPersonBN personBN;
    private IDepartmentBN departmentBN;
    private IProductBN productBN;
    private Enterprise enterprise;

    public ProductCell() {

        this.enterpriseDAO = Lookup.getDefault().lookup(IEnterpriseBN.class);
        this.personBN = Lookup.getDefault().lookup(IPersonBN.class);
        this.departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class);
        this.productBN = Lookup.getDefault().lookup(IProductBN.class);
        enterprise = new Enterprise();
        txtIdPro = new JTextField();
        txtNamePro = new JTextField();

        modelEnter = new DefaultComboBoxModel();
        modelEnter.addElement(" ");
        modelPerson = new DefaultComboBoxModel();
        modelPerson.addElement(" ");
        modelDepartment = new DefaultComboBoxModel();
        modelDepartment.addElement(" ");
        modelProductParent = new DefaultComboBoxModel();
        modelProductParent.addElement(" ");

        List<Enterprise> list = new ArrayList<Enterprise>();
        list = enterpriseDAO.getAllEnterprise();
        for (Enterprise bean : list) {
            modelEnter.addElement(bean);
        }

        List<Person> list1 = new ArrayList<Person>();
        list1 = personBN.getAllPerson();
        for (Person bean : list1) {
            modelPerson.addElement(bean);
        }
        
        List<Product> list3 = new ArrayList<Product>();
        list3 = productBN.getAllProduct();
        for (Product bean : list3) {
            modelProductParent.addElement(bean);
        }

        List<Department> list2 = new ArrayList<Department>();
        list2 = departmentBN.getAllDepartment();
        for (Department bean : list2) {
            modelDepartment.addElement(bean);
        }

        cboEnterprise = new JComboBox(modelEnter);
        cboEnterprise.addItemListener(this);
        cboPerson = new JComboBox(modelPerson);
        cboDepartment = new JComboBox(modelDepartment);
        cboProductParent = new JComboBox(modelProductParent);

        // Set index = null for combobox
        cboEnterprise.setSelectedIndex(0);
        cboPerson.setSelectedIndex(0);
        cboDepartment.setSelectedIndex(0);
        cboProductParent.setSelectedIndex(0);
        txtIdPro.setText(" ");
        txtNamePro.setText(" ");
    }

    public JTextField getTxtIdPro() {
        return txtIdPro;
    }

    public JTextField getTxtNamePro() {
        return txtNamePro;
    }

    @Override
    public Object getCellEditorValue() {
        if (component == txtIdPro) {
            return txtIdPro.getText();
        } else if (component == cboDepartment) {
            return cboDepartment.getSelectedItem();
        } else if (component == txtNamePro) {
            return txtNamePro.getText();
        } else if (component == cboEnterprise) {
            return cboEnterprise.getSelectedItem();
        } else if (component == cboProductParent) {
            return cboProductParent.getSelectedItem();
        } else {
            return cboPerson.getSelectedItem();
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (column == 1) {
            if (row == 0) {
                component = txtNamePro;
            }
            if (row == 1) {
                component = txtIdPro;
            }
            if (row == 2) {
                component = cboEnterprise;
            }
            if (row == 3) {
                component = cboDepartment;
            }
            if (row == 4) {
                component = cboPerson;
            }
            if (row == 5) {
                component = cboProductParent;
            }
        }
        return component;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        if (comboBox == cboEnterprise) {
            if (cboEnterprise.getSelectedItem().toString().trim().length() != 0) {
                enterprise = (Enterprise) cboEnterprise.getSelectedItem();
                modelDepartment.removeAllElements();
                modelProductParent.removeAllElements();
                modelProductParent.addElement(" ");
                modelDepartment.addElement(" ");
                List<Product> list3 = new ArrayList<Product>();
                list3 = productBN.getByEnterprise(enterprise);
                if (list3.isEmpty()) {
                    list3 = productBN.getAllProduct();
                }
                for (Product bean : list3) {
                    modelProductParent.addElement(bean);
                }

                List<Department> list2 = new ArrayList<Department>();
                list2 = departmentBN.filterDepartmentByEnterprise(enterprise);
                if (list2.isEmpty()) {
                    list2 = departmentBN.getAllDepartment();
                }
                for (Department bean : list2) {
                    modelDepartment.addElement(bean);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn công ty");
        }
    }
}
