/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author khanguct
 */
@Entity
public class Department {
    
    @Id
    private String DepartmentID;
    private String DepartmentName;
    private String EnterpriseID;
    private String PersonID;// Truong du an
    private String departmentParent;//Dự án mẹ
    private String productID; //  ma San pham

    /**
     * @return the DepartmentID
     */
    public String getDepartmentID() {
        return DepartmentID;
    }

    /**
     * @param DepartmentID the DepartmentID to set
     */
    public void setDepartmentID(String DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    /**
     * @return the DepartmentName
     */
    public String getDepartmentName() {
        return DepartmentName;
    }

    /**
     * @param DepartmentName the DepartmentName to set
     */
    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    /**
     * @return the EnterpriseID
     */
    public String getEnterpriseID() {
        return EnterpriseID;
    }

    /**
     * @param EnterpriseID the EnterpriseID to set
     */
    public void setEnterpriseID(String EnterpriseID) {
        this.EnterpriseID = EnterpriseID;
    }

    /**
     * @return the PersonID
     */
    public String getPersonID() {
        return PersonID;
    }

    /**
     * @param PersonID the PersonID to set
     */
    public void setPersonID(String PersonID) {
        this.PersonID = PersonID;
    }

    public String getDepartmentParent() {
        return departmentParent;
    }

    public void setDepartmentParent(String departmentParent) {
        this.departmentParent = departmentParent;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    
    public Department(String DepartmentID, String DepartmentName, String EnterpriseID, String PersonID,String _departmentParent,String _productID) {
        this.DepartmentID = DepartmentID;
        this.DepartmentName = DepartmentName;
        this.EnterpriseID = EnterpriseID;
        this.PersonID = PersonID;
        this.departmentParent=_departmentParent;
        this.productID=_productID;
    }
    public Department(){
        super();
    }
    @Override
    public String toString(){
        return this.DepartmentName;
    }
    
    
}
