/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.departmentperson;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 *
 * @author VietAnh
 */
public class DepartmentParent extends Children.Keys {
    private List<Department> list = new ArrayList<Department> ();
    private IDepartmentBN departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class) ;
    public static String Congty_PROPERTY="Công Ty"; 
    public static String Truongphong_PROPERTY="Trưởng Phòng"; 
    public static String Sanpham_PROPERTY ="Sản Phẩm";
    private Department department;
    private Enterprise enterprise ;
    
    public DepartmentParent(Enterprise e){
        this.enterprise = e;
    }
    
    public DepartmentParent(){
        //list = departmentBN.getAllDepartment();
        //JOptionPane.showMessageDialog(null, "Constructor...");
    }
    
    
    
    @Override
    protected Node[] createNodes(Object t) {
        final Department d = (Department) t;
        Node result ;
        //JOptionPane.showMessageDialog(null, "Createnew node chil...");
        result = new AbstractNode(new DepartmentChildren(d),Lookups.singleton(t)){
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
        };
        result.setDisplayName(d.getDepartmentName());
        return new Node[]{result};
    }
    
    
    @Override
    protected void addNotify(){
        super.addNotify();
        Vector instr = new Vector();
        for (Department bean: list){
            if (bean.getDepartmentParent().trim().length()== 0){
                instr.addElement(bean);
            }
        }
        
        Department[] departments = new Department[instr.size()];
        for(int i=0;i<instr.size();i++){
            departments[i] = (Department) instr.elementAt(i);
        }
        setKeys(departments);
    }
    
    
}
