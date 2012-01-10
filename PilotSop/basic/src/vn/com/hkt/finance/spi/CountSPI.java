/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.finance.spi;

import vn.com.hkt.finance.api.ICount;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.basic.api.IEnterpriseBN;
import vn.com.hkt.basic.api.IOperationBN;
import vn.com.hkt.basic.api.IPersonBN;
import vn.com.hkt.basic.api.IProductBN;
import vn.com.hkt.pilot.entities.Operation;
import vn.com.hkt.pilot.entities.Product;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;

/**
 *
 * @author khanguct
 */
@ServiceProvider(service = ICount.class)
public class CountSPI implements ICount {

    private IPersonBN personBN;
    private IEnterpriseBN enterpriseBN;
    private IProductBN productBN;
    private IOperationBN operationBN;
    private IDepartmentBN departmentBN;

    public CountSPI() {

        this.enterpriseBN = Lookup.getDefault().lookup(IEnterpriseBN.class);
        this.operationBN = Lookup.getDefault().lookup(IOperationBN.class);
        this.personBN = Lookup.getDefault().lookup(IPersonBN.class);
        this.productBN = Lookup.getDefault().lookup(IProductBN.class);
        this.departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class);
    }

    @Override
    public int countPerson(Enterprise enterprise, Department department) {
        int S = 0;
        List<Person> result = new ArrayList<Person>();
        List<Person> list = personBN.getAllPerson();
        if (!list.isEmpty()) {
            for (Person bean : list) {
                if ((bean.getEnterpriseID().equals(enterprise.getEnterpriseID()))
                        && (bean.getDepartmentName().equals(department.getDepartmentName()))) {
                    result.add(bean);
                }
            }
        }
        if (!result.isEmpty()) {
            S = result.size();
        }
        return S;
    }

    @Override
    public int countEnterprise() {
        int S = 0;
        List<Enterprise> list = enterpriseBN.getAllEnterprise();
        if (!list.isEmpty()) {
            S = list.size();
        }
        return S;
    }

    @Override
    public int countDepartmentByEnterprise(Enterprise enterprise) {
         int S=0;
        List<Department> result = new ArrayList<Department>();
        List<Department> list = departmentBN.getAllDepartment();
        if(!list.isEmpty()){
            for(Department bean:list){
                if(bean.getEnterpriseID().equals(enterprise.getEnterpriseID())){
                    result.add(bean);
                }
            }
        }
        if(!result.isEmpty()){
            S=result.size();
        }
        return S;
    }

    @Override
    public int countProductByEnterprise(Enterprise enterprise) {
        int S=0;
        List<Product> result= new ArrayList<Product>();
        List<Product> list = new ArrayList<Product>();
        list=productBN.getAllProduct();
        if(!list.isEmpty()){
            for(Product bean:list){
                if(bean.getEnterpriseID().equals(enterprise.getEnterpriseID())){
                    result.add(bean);
                }
            }
        }
        
        if(!result.isEmpty()){
            S=result.size();
        }
        
        return S;        
    }

    @Override
    public int countOperation(Enterprise enter, Department depar, Person person, Product product) {
       int S=0;
        List<Operation> list = new ArrayList<Operation>();
        list=operationBN.getAllOperation();
        if(!list.isEmpty()){
           for(Operation bean: list){
               if((bean.getDepartmentID().equals(depar.getDepartmentID())) && (bean.getPersonID().equals(person.getPersonID()))
                       && (bean.getProductID().equals(product.getProductID()))){
                   S++;
               }
           }
        }
        return S;
    }

    @Override
    public int countOperation(Enterprise enter, String date) {
        
        int S=0;
        int i;
        List<Operation> list = operationBN.filterOperationByDate(date);
        if(!list.isEmpty()){
            for(i=0;i<list.size();i++){
                if(list.get(i).getEnterpriseID().equals(enter.getEnterpriseID())){
                    S++;
                }
            }
        }
        return S;
    }

    @Override
    public int countOperation(Enterprise enter, String classification, String date) {
        int S=0;
        int i;
        List<Operation> list = operationBN.filterOperationByDate(date);
        if(!list.isEmpty()){
            for(i=0;i<list.size();i++){
                if((list.get(i).getEnterpriseID().equals(enter.getEnterpriseName())) && 
                        (list.get(i).getClassification().equals(classification))){
                    S++;
                }
            }
        }
        return S;
    }
}
