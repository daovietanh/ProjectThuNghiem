/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.bom.operation.ui;

/**
 *
 * @author longnt
 */
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;
import vn.com.hkt.pilot.entities.Product;
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.basic.api.IEnterpriseBN;
import vn.com.hkt.basic.api.IPersonBN;
import vn.com.hkt.basic.api.IProductBN;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.TableCellEditor;
import org.openide.util.Lookup;
import vn.com.hkt.pilot.dialog.api.IClassification;
import vn.com.hkt.pilot.dialog.dao.ClassificationBN;
import vn.com.hkt.pilot.entities.Classification;

/**
 *
 * @author longnt
 */
public class OperationCell extends AbstractCellEditor implements TableCellEditor {

    private Component component;
    private JComboBox cboEnterprise, cboPerson, cboProduct, cboDepartment, cboUnit, cboPhanloai;
    private JTextField txtNameO, txtIdO, txtSoluong, txtDongia, txtTonggia, txtDonviTinh;
    private JSpinner spinnerDate;
    private Date date;
    private JSpinner.DateEditor dateEditor;
    private DefaultComboBoxModel modelPerson, modelEnter, modelDepartment, modelProduct, modelPhanloai;
    private IEnterpriseBN enterpriseDAO;
    private IProductBN productBN;
    private IPersonBN personBN;
    private IDepartmentBN departmentBN;
    private ClassificationBN iClassification;

    // private OperationCell operationCell = new OperationCell();
    public OperationCell() {
        this.productBN = Lookup.getDefault().lookup(IProductBN.class);
        this.personBN = Lookup.getDefault().lookup(IPersonBN.class);
        this.enterpriseDAO = Lookup.getDefault().lookup(IEnterpriseBN.class);
        this.departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class);
        iClassification = new ClassificationBN();
        txtIdO = new JTextField();
        txtNameO = new JTextField();
        txtSoluong = new JTextField();
        txtDongia = new JTextField();
        txtTonggia = new JTextField();

        txtDongia.setText("0");
        txtIdO.setText(" ");
        txtNameO.setText(" ");
       // txtTonggia.setText("0");
         txtSoluong.setText("0");

        modelEnter = new DefaultComboBoxModel();
        modelEnter.addElement(" ");
        modelPerson = new DefaultComboBoxModel();
        modelPerson.addElement(" ");
        modelDepartment = new DefaultComboBoxModel();
        modelDepartment.addElement(" ");
        modelProduct = new DefaultComboBoxModel();
        modelProduct.addElement(" ");
        modelPhanloai = new DefaultComboBoxModel();
        modelPhanloai.addElement(" "); 


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

        List<Department> list2 = new ArrayList<Department>();
        list2 = departmentBN.getAllDepartment();
        for (Department bean : list2) {
            modelDepartment.addElement(bean);
        }

        List<Product> list3 = new ArrayList<Product>();
        list3 = productBN.getAllProduct();
        for (Product bean : list3) {
            modelProduct.addElement(bean);
        }
        
        List<Classification> list4 = new ArrayList<Classification>();
        list4 = iClassification.getAllClassification();
        for (Classification bean : list4) {
            modelPhanloai.addElement(bean);
        }

        cboEnterprise = new JComboBox(modelEnter);
        cboPerson = new JComboBox(modelPerson);
        cboDepartment = new JComboBox(modelDepartment);
        cboProduct = new JComboBox(modelProduct);
        cboPhanloai = new JComboBox(modelPhanloai);


        // Set index = null for combobox
        cboEnterprise.setSelectedIndex(0);
        cboPerson.setSelectedIndex(0);
        cboDepartment.setSelectedIndex(0);
        cboProduct.setSelectedIndex(0);

        cboUnit = new JComboBox();

        //txtDongia = new JTextField();
        txtDonviTinh = new JTextField();
       // txtTonggia = new JTextField();

        date = new Date();

        spinnerDate = new JSpinner(new SpinnerDateModel(date, null, null, Calendar.YEAR));
        dateEditor = new JSpinner.DateEditor(spinnerDate, "dd/MM/yyyy");
        spinnerDate.setEditor(dateEditor);
    }

    public JComboBox getCboPhanloai() {
        return cboPhanloai;
    }

    public JTextField getTxtDongia() {
        return txtDongia;
    }

    public JTextField getTxtNameO() {
        return txtNameO;
    }

    public JTextField getTxtSoluong() {
        return txtSoluong;
    }

    public JTextField getTxtTonggia() {
        return txtTonggia;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {


        if (column == 1) {
            if (row == 0) {

                component = txtNameO;
            }
            if (row == 1) {

                component = txtIdO;
            }
            if (row == 4) {
                component = cboEnterprise;
            }
            if (row == 8) {
                component = txtSoluong;
            }
            if (row == 2) {
                component = spinnerDate;
            }
            if (row == 7) {
                component = cboPhanloai;
            }
            if (row == 3) {
                component = cboProduct;
            }
            if (row == 5) {
                component = cboDepartment;
            }
            if (row == 6) {
                component = cboPerson;
            }
            if (row == 9) {
                component = txtDongia;
            }
            if (row == 10) {
                component = txtTonggia;
            }
            if (row == 11) {
                component = txtDonviTinh;
            }
            if (row == 12) {
                component = cboUnit;
            }

        }

        return component;
    }

    @Override
    public Object getCellEditorValue() {

        if (component == txtIdO) {
            return txtIdO.getText();
        } else if (component == spinnerDate) {
            return dateEditor.getFormat().format(spinnerDate.getValue());
        } else if (component == txtNameO) {
            return txtNameO.getText();
        } else if (component == cboPhanloai) {
            return cboPhanloai.getSelectedItem();
        } else if (component == cboEnterprise) {
            return cboEnterprise.getSelectedItem();
        } else if (component == cboDepartment) {
            return cboDepartment.getSelectedItem();
        } else if (component == cboPerson) {
            return cboPerson.getSelectedItem();
        } else if (component == cboProduct) {
            return cboProduct.getSelectedItem();
        } else if (component == cboUnit) {
            return cboUnit.getSelectedItem();
        } else if (component == txtDongia) {
            return txtDongia.getText();
        } else if (component == txtSoluong) {
            return txtSoluong.getText();      
        } else if (component == txtDonviTinh) {
            return txtDonviTinh.getText();
        } 
        else {        
           // if(Integer.parseInt(txtDongia.getText())!=)
            txtTonggia.setText(String.valueOf((Integer.parseInt(txtDongia.getText()))*Integer.parseInt(txtSoluong.getText())));
            return txtTonggia.getText();
        }

    }

    public JTextField getTxtIdO() {
        return txtIdO;
    }
}
