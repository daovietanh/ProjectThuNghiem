
package vn.com.hkt.basic.api;

import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;
import java.util.List;

/**
 *
 * @author khanguct
 */
public interface IPersonBN {
    
    public boolean insertPerson(Person person);
    
    public boolean updatePerson(Person person);
    
    public boolean deletePerson(Person person);
    
    public List<Person> getAllPerson();
    
    public Person getPersonByID(String id);
    
     public List<Person> filterPersonByID(String id);

    public List<Person> filterPersonByName(String name);
    
    public List<Person> filterPersonByLastName(String name);

    public List<Person> filterDepartmentByEnterprise(Enterprise enterprise);
}

