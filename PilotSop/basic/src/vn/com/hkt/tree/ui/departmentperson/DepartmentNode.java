/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.departmentperson;

import java.awt.Image;
import java.lang.reflect.InvocationTargetException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;
import vn.com.hkt.pilot.entities.Department;

/**
 *
 * @author VietAnh
 */
public class DepartmentNode extends AbstractNode {
    public static String Congty_PROPERTY="Công Ty"; 
    public static String Truongphong_PROPERTY="Trưởng Phòng"; 
    public static String Sanpham_PROPERTY ="Sản Phẩm";
    private Department d;
    
    public DepartmentNode(Department d) {
        super(Children.LEAF,Lookup.getDefault());
        this.d = d;
        setDisplayName(d.getDepartmentName());
    }
    

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
            return sheet;            
        }
    
    @Override
    public Image getIcon(int type){
        return ImageUtilities.loadImage("vn/com/newp/ui/department/a.gif");
    }
    
    @Override
    public Image getOpenedIcon(int i){
        return getIcon(i);
    }
}
