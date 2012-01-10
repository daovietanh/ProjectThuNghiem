/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.department;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.nodes.Sheet;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import vn.com.hkt.basic.api.IPersonBN;
import vn.com.hkt.pilot.dialog.dao.MissionBN;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Mission;
import vn.com.hkt.pilot.entities.Person;

/**
 *
 * @author VietAnh
 */
public class PersonParent extends Children.Keys{
     private List<Person> list = new ArrayList<Person>();
    private IPersonBN personBN = Lookup.getDefault().lookup(IPersonBN.class);
    private MissionBN missionBN = new MissionBN();
    public static String Giamdoc_PROPERTY = "TruongPhong";
    public static String Congtyme_PROPERTY = "CongTy";
    private Person person;
    private Department department;

    public PersonParent(boolean lazy) {
        super(lazy);
    }

    public PersonParent(Person person, Department department) {
        
        this.person = person;
        this.department = department;
    }
      public PersonParent(Department department) {
        
        this.department = department;
    }

    @Override
    protected Node[] createNodes(Object key) {     
        
        final Mission mission1 = (Mission) key;

        
        Node result = new AbstractNode(new PersonChildren(mission1,department), Lookups.singleton(mission1)) {

            @Override
            protected Sheet createSheet() {
                Sheet sheet = Sheet.createDefault();
                Sheet.Set set = Sheet.createPropertiesSet();

                /*Property giamDocProperty = new PropertySupport.ReadOnly<String>(Giamdoc_PROPERTY, String.class, "Trưởng phòng", "aaa") {
Giamdoc_PROPERTY
                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return person1.getDepartmentName();
                    }

                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
                };
                set.put(giamDocProperty);
                Property congTyMeProperty =
                        new PropertySupport.ReadOnly<String>(Congtyme_PROPERTY, String.class, "Công ty", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                JOptionPane.showMessageDialog(null, "get last name"+ person1.getLastName());
                                return person1.getLastName();
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(congTyMeProperty);
                 * 
                 */
                sheet.put(set);
                return sheet;
            }
        };


        result.setDisplayName(mission1.getMissionName());
        return new Node[]{result};

    }

    @Override
    protected void addNotify() {
//        if (department != null) {
//            list = personBN.getAllPerson();
//            
//            JOptionPane.showMessageDialog(null, "Department"+ department);
//            JOptionPane.showMessageDialog(null, "List per = "+ list.size());
//            super.addNotify();
//            Vector instr = new Vector();
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i).getDepartmentName().trim().length() == 0) {
//                    JOptionPane.showMessageDialog(null, "EnterpriseID Lastname = "+ list.get(i).getLastName());
//                    Person person1 = new Person();
//                    person1.setDepartmentName(list.get(i).getDepartmentName());
//                    person1.setEnterpriseID(list.get(i).getEnterpriseID());
//                    person1.setFirstName(list.get(i).getFirstName());
//                    person1.setLastName(list.get(i).getLastName());
//                    person1.setPersonID(list.get(i).getPersonID());
//                    instr.addElement(person1);
//                }
//
//            }
//
//            JOptionPane.showMessageDialog(null, "So per"+ instr.size());
//            Person[] persons = new Person[instr.size()];
//            for (int i = 0; i < instr.size(); i++) {
//                persons[i] = (Person) instr.elementAt(i);
//            }
        
            List<Mission> listMission = new ArrayList<Mission>();
            listMission = missionBN.getAllMission();
            setKeys(listMission);

        //}

    }

}

