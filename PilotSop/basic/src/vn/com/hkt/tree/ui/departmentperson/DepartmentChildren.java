/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.departmentperson;

import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Lookup;
import org.openide.util.actions.Presenter;
import org.openide.util.lookup.Lookups;
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.erm.department.ui.DepartmentTopComponent;
import vn.com.hkt.pilot.entities.Department;

/**
 *
 * @author VietAnh
 */
public class DepartmentChildren extends Children.Keys{
    private List<Department> list = new ArrayList<Department> ();
    private IDepartmentBN departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class) ;
    public static String Congty_PROPERTY="Công Ty"; 
    public static String Truongphong_PROPERTY="Trưởng Phòng"; 
    public static String Sanpham_PROPERTY ="Sản Phẩm";
    private Department department;
    
    DepartmentChildren(Department d) {
        this.department = d;
    }
    
    DepartmentChildren(){
        list = departmentBN.getAllDepartment();
    }

    @Override
    protected Node[] createNodes(Object t) {
        //throw new UnsupportedOperationException("Not supported yet.");
        final Department d = (Department) t;
        Node result ;
        result = new AbstractNode(new DepartmentChildren(d),Lookups.singleton(d)){
            @Override
            protected Sheet createSheet(){
                Sheet sheet = Sheet.createDefault();
                Sheet.Set set = Sheet.createPropertiesSet();
                Property congtyProperty = new PropertySupport.ReadOnly<String>(Congty_PROPERTY,String.class,"Cong ty","a") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return d.getDepartmentName();
                    }
                };
                set.put(congtyProperty);
                
                Property truongphongProperty = new PropertySupport.ReadOnly<String>(Truongphong_PROPERTY,String.class,"Truong Phong","a") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return d.getPersonID();
                    }
                };
                set.put(truongphongProperty);
                Property sanphamProperty= new PropertySupport.ReadOnly<String>(Sanpham_PROPERTY,String.class,"San Pham","a"){

            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return d.getProductID();
            }
            };
            set.put(sanphamProperty);
            
            sheet.put(set);
            this.setIconBaseWithExtension("vn/com/newp/ui/department/a.gif");
            return sheet;            
            }
            
            @Override
            public Action[] getActions(boolean popup) {
                return new Action [] {new MyAction()};
            }
            
            
            class MyAction extends AbstractAction implements Presenter.Popup {

                public MyAction () {
                    putValue (NAME, "Do Something");
                }

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Department department = getLookup().lookup(Department.class);

                    JOptionPane.showMessageDialog(null, "Hello from " + department.getDepartmentName() );
                    if (e.getSource()==mni1){
                        DepartmentTopComponent dc = new DepartmentTopComponent();
                        dc.getDepartmentPanel().getTableD().setModel(new javax.swing.table.DefaultTableModel(
                                    new Object[][]{
                                        {"Tên dự án", department.getDepartmentName()},
                                        {"Mã dự án", department.getDepartmentID()},
                                        {"Công ty", department.getEnterpriseID()},
                                        {"Trưởng dự án", department.getPersonID()},
                                        {"Phân cấp", " "},
                                        {"Phòng ban mẹ", department.getDepartmentParent()},
                                        {"Sản phẩm dịch vụ", department.getProductID()}
                                    },
                                    new String[]{
                                        "", ""
                                    })); 
                        dc.open();

                    }
                    if (e.getSource()==mni2){
                        JOptionPane.showMessageDialog(null, "Menu 2 clicked" );
                    }
                }
                JMenuItem mni1 = new JMenuItem("Sua");
                JMenuItem mni2 = new JMenuItem("Thoat");
                @Override
                public JMenuItem getPopupPresenter() {
                    JMenu menu = new JMenu("Menu");
                    menu.add(new JMenuItem(this));
                    mni1.addActionListener(this);
                    mni2.addActionListener(this);
                    menu.add(mni1);
                    menu.add(mni2);
                    return menu;
                }

            } 
            
            
            
        };

        result.setDisplayName(d.getDepartmentName());
        return new Node[]{result};
    }
    
    protected void addNotify(){
        list = departmentBN.getAllDepartment();
        super.addNotify();
        Vector instr = new Vector();
        for (int i=0;i< list.size(); i++){
            if (list.get(i).getDepartmentParent().equals(department.getDepartmentName())){
                Department d = new Department();
                d.setDepartmentID(list.get(i).getDepartmentID());
                d.setDepartmentName(list.get(i).getDepartmentName());
                d.setPersonID(list.get(i).getPersonID());
                d.setProductID(list.get(i).getProductID());
                instr.addElement(d);
            }
        }
        
        Department departments[] = new Department[instr.size()];
        for (int i=0;i<instr.size();i++){
            departments[i] = (Department) instr.elementAt(i);
        }
        setKeys(departments);
    }
    
    
    
    
   

    
    
    
    
    
}
