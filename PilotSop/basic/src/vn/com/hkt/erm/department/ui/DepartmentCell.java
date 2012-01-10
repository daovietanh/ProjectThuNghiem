/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.erm.department.ui;

import java.awt.event.ItemEvent;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.basic.api.IEnterpriseBN;
import vn.com.hkt.basic.api.IPersonBN;
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
import vn.com.hkt.basic.api.IProductBN;
import vn.com.hkt.pilot.entities.Product;

/**
 *
 * @author longnt
 */
public class DepartmentCell extends AbstractCellEditor implements TableCellEditor, ItemListener {

    private Component component;
    private JComboBox cboEnterprise, cboPerson, cboDepartmentParent, cboProduct;
    private JTextField txtNameD, txtIdD, txtPhancap;
    private DefaultComboBoxModel modelPerson, modelEnter, modelDepartmentParent, modelProduct;
    private IEnterpriseBN enterpriseBN;
    private IPersonBN personBN;
    private IDepartmentBN departmentBN;
    private IProductBN productBN;
    private Enterprise enterprise;

    public DepartmentCell() {
        this.enterpriseBN = Lookup.getDefault().lookup(IEnterpriseBN.class);
        this.personBN = Lookup.getDefault().lookup(IPersonBN.class);
        this.departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class);
        this.productBN = Lookup.getDefault().lookup(IProductBN.class);
        enterprise = new Enterprise();

        txtIdD = new JTextField();
        txtPhancap = new JTextField();
        txtNameD = new JTextField();
        txtNameD.setText(" ");
        txtIdD.setText(" ");
        txtPhancap.setText(" ");

        modelEnter = new DefaultComboBoxModel();
        modelEnter.addElement(" ");
        modelPerson = new DefaultComboBoxModel();
        modelPerson.addElement(" ");
        modelDepartmentParent = new DefaultComboBoxModel();
        modelDepartmentParent.addElement(" ");

        modelProduct = new DefaultComboBoxModel();
        modelProduct.addElement(" ");



        List<Enterprise> list = new ArrayList<Enterprise>();
        list = enterpriseBN.getAllEnterprise();
        for (Enterprise bean : list) {
            modelEnter.addElement(bean);
        }

        List<Person> list1 = new ArrayList<Person>();
        list1 = personBN.getAllPerson();
        for (Person bean : list1) {
            modelPerson.addElement(bean);
        }

        List<Department> list2 = new ArrayList<Department>();
        list2 = departmentBN.getAllDepartment();
        for (Department bean : list2) {
            modelDepartmentParent.addElement(bean);
        }
        List<Product> list3 = new ArrayList<Product>();
        list3 = productBN.getAllProduct();

        for (Product bean : list3) {
            modelProduct.addElement(bean);
        }


        cboEnterprise = new JComboBox(modelEnter);
        cboEnterprise.addItemListener(this);
        cboPerson = new JComboBox(modelPerson);
        cboDepartmentParent = new JComboBox(modelDepartmentParent);
        cboProduct = new JComboBox(modelProduct);

        // Set index = null for combobox
        cboEnterprise.setSelectedIndex(0);
        cboPerson.setSelectedIndex(0);
        cboDepartmentParent.setSelectedIndex(0);
        cboProduct.setSelectedIndex(0);

    }

    public JTextField getTxtIdD() {
        return txtIdD;
    }

    public JTextField getTxtNameD() {
        return txtNameD;
    }

    @Override
    public Object getCellEditorValue() {
        if (component == txtIdD) {
            return txtIdD.getText();
        } else if (component == txtPhancap) {
            return txtPhancap.getText();
        } else if (component == txtNameD) {
            return txtNameD.getText();
        } else if (component == cboEnterprise) {
            return cboEnterprise.getSelectedItem();
        } else if (component == cboDepartmentParent) {
            return cboDepartmentParent.getSelectedItem();
        } else if (component == cboPerson) {
            return cboPerson.getSelectedItem();
        } else {
            return cboProduct.getSelectedItem();
        }

    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (column == 1) {
            if (row == 0) {
                component = txtNameD;
            }
            if (row == 1) {
                component = txtIdD;
            }
            if (row == 2) {
                component = cboEnterprise;
            }
            if (row == 3) {
                component = cboPerson;
            }
            if (row == 4) {
                component = txtPhancap;
            }
            if (row == 5) {
                component = cboDepartmentParent;
            }
            if (row == 6) {
                component = cboProduct;
            }
        }
        return component;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        if (comboBox == cboEnterprise) {
            modelDepartmentParent.removeAllElements();
            modelProduct.removeAllElements();
            modelDepartmentParent.addElement(" ");
            modelProduct.addElement(" ");
            List<Department> list2 = new ArrayList<Department>();
            if (cboEnterprise.getSelectedItem().toString().trim().length() != 0) {
                enterprise = (Enterprise) cboEnterprise.getSelectedItem();
                list2 = departmentBN.filterDepartmentByEnterprise(enterprise);
                if (list2.isEmpty()) {
                    list2 = departmentBN.getAllDepartment();
                }
                for (Department bean : list2) {
                    modelDepartmentParent.addElement(bean);
                }
                List<Product> list3 = new ArrayList<Product>();
                list3 = productBN.getByEnterprise(enterprise);
                if (list3.isEmpty()) {
                    list3 = productBN.getAllProduct();
                }
                for (Product bean : list3) {
                    modelProduct.addElement(bean);
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn công ty");
        }
    }
}
