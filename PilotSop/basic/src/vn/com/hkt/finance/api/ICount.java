/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.finance.api;

import vn.com.hkt.pilot.entities.Product;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;


/**
 *
 * @author khanguct
 */
public interface ICount {

    public int countPerson(Enterprise enterprise, Department department);

    public int countEnterprise();

    public int countDepartmentByEnterprise(Enterprise enterprise);

    public int countProductByEnterprise(Enterprise enterprise);

    public int countOperation(Enterprise enter, Department depar, Person person, Product product);
    
    public int countOperation(Enterprise enter, String date);
    
    public int countOperation(Enterprise enter, String classification, String date);
    
}
