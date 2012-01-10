/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.department;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.lang.String;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import vn.com.hkt.basic.api.IPersonBN;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Mission;
import vn.com.hkt.pilot.entities.Person;

/**
 *
 * @author VietAnh
 */
public class PersonChildren extends Children.Keys{
     private List<Person> list = new ArrayList<Person>();
    private IPersonBN personBN = Lookup.getDefault().lookup(IPersonBN.class);
    public static String Giamdoc_PROPERTY = "TruongPhong";
    public static String Congtyme_PROPERTY = "CongTy";
    private Person person;
    private Department department;
    private Mission mission;
    public PersonChildren(boolean lazy) {
        super(lazy);
    }

    public PersonChildren(Mission m, Department department) {      
        this.mission = m;
        this.department = department;
    }
    
    
    public PersonChildren(Person p, Department department,Mission m) {
        this.mission = m ;
        this.person = p;
        this.department = department;
    }
    
      public PersonChildren(Department department) {
        
        this.department = department;
    }

    @Override
    protected Node[] createNodes(Object key) {     
        
        final Person person1 = (Person) key;

        
        Node result = new AbstractNode(new PersonChildren(person1, department,mission), Lookups.singleton(person1)) {

            @Override
            protected Sheet createSheet() {
                Sheet sheet = Sheet.createDefault();
                Sheet.Set set = Sheet.createPropertiesSet();

                //JOptionPane.showMessageDialog(null, "Create Nodes");
                Property giamDocProperty = new PropertySupport.ReadOnly<String>(Giamdoc_PROPERTY, String.class, "Trưởng phòng", "aaa") {
                    
                    
                    
                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        //JOptionPane.showMessageDialog(null, "Create Node 2");
                        return person1.getFirstName()+person1.getLastName();
                    }

                    @Override
                    public PropertyEditor getPropertyEditor() {
//                        JOptionPane.showMessageDialog(null, "Create Node property editor");
                        return new PropertyEditorSupport();
                    }
                };

                Property congTyMeProperty =
                        new PropertySupport.ReadOnly<String>(Congtyme_PROPERTY, String.class, "Công ty", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                //JOptionPane.showMessageDialog(null, "get last name"+ person1.getLastName());
                                return person1.getEnterpriseID();
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(giamDocProperty);
                set.put(congTyMeProperty);
                
                
                
                
                
                
                
                this.setIconBaseWithExtension("vn/com/hkt/tree/ui/department/a.gif");
                sheet.put(set);
                return sheet;
            }
        };


        result.setDisplayName(person1.getLastName());
        return new Node[]{result};

    }

    @Override
    protected void addNotify() {
        //JOptionPane.showMessageDialog(null, "Department "+ department.getDepartmentName());
        //JOptionPane.showMessageDialog(null, "Mission "+ mission.getMissionName());
        if (person != null){
            Person[] persons = new Person[0];
            setKeys(persons);
        }
        else
        if (department != null) {
            list = personBN.getAllPerson();
            super.addNotify();
            Vector instr = new Vector();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDepartmentName().equals(department.getDepartmentName()) && list.get(i).getPosition().equals(mission.getMissionName())) {
                   // JOptionPane.showMessageDialog(null, "Lastname = "+ list.get(i).getLastName());
                    Person person1 = new Person();
                    person1.setDepartmentName(list.get(i).getDepartmentName());
                    person1.setEnterpriseID(list.get(i).getEnterpriseID());
                    person1.setFirstName(list.get(i).getFirstName());
                    person1.setLastName(list.get(i).getLastName());
                    person1.setPersonID(list.get(i).getPersonID());
                    instr.addElement(person1);
                }

            }

            //JOptionPane.showMessageDialog(null, "So per"+ instr.size());
            Person[] persons = new Person[instr.size()];
            for (int i = 0; i < instr.size(); i++) {
                persons[i] = (Person) instr.elementAt(i);
            }
            setKeys(persons);
        }

    }

}
