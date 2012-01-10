/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.product.thuchi;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import vn.com.hkt.pilot.entities.Product;
import vn.com.hkt.basic.api.IProductBN;
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
import vn.com.hkt.finance.spi.CalculateSPI;
import vn.com.hkt.pilot.datetime.utils.DateTimeUtils;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 *
 * @author longnt
 */
public class ProductChildrenTongQuan extends Children.Keys {

    private List<Product> list = new ArrayList<Product>();
    private IProductBN productBN = Lookup.getDefault().lookup(IProductBN.class);
    public static String ThuMonth1_PROPERTY = "ThuM1";
    public static String ChiMonth1_PROPERTY = "ChiM1";
    public static String Lai1_PROPERTY = "LaiM1";
    public static String ThuMonth2_PROPERTY = "ThuM2";
    public static String ChiMonth2_PROPERTY = "ChiM2";
    public static String Lai2_PROPERTY = "LaiM2";
    public static String ThuMonth3_PROPERTY = "ThuM3";
    public static String ChiMonth3_PROPERTY = "ChiM3";
    public static String Lai3_PROPERTY = "LaiM3";
    public static String ThuYear1_PROPERTY = "ThuY1";
    public static String ChiYear1_PROPERTY = "ChiY1";
    public static String LaiYear1_PROPERTY = "LaiY1";
    public static String ThuYear2_PROPERTY = "ThuY2";
    public static String ChiYear2_PROPERTY = "ChiY2";
    public static String LaiYear2_PROPERTY = "LaiY2";
    public static String ThuAll_PROPERTY = "ThuAll";
    public static String ChiAll_PROPERTY = "ChiAll";
    public static String LaiAll_PROPERTY = "LaiAll";
    private Product Product;
    private Enterprise enterprise;
    private CalculateSPI calculateSPI;
    private DateTimeUtils dateTimeUtils;
    private String month1, month2, month3, year1, year2;

    public ProductChildrenTongQuan(boolean lazy) {
        super(lazy);
    }

    public ProductChildrenTongQuan(Product product, Enterprise enterprise) {
        this.Product = product;
        this.enterprise = enterprise;

        calculateSPI = new CalculateSPI();
        dateTimeUtils = new DateTimeUtils();
        month1 = dateTimeUtils.getCurrentMonth() + "/" + dateTimeUtils.getCurrentYear();
        month2 = String.valueOf(dateTimeUtils.addMonth(-1)) + "/" + dateTimeUtils.addYearWithMonth(-1);
        month3 = String.valueOf(dateTimeUtils.addMonth(-2)) + "/" + dateTimeUtils.addYearWithMonth(-2);
        year1 = String.valueOf(dateTimeUtils.getCurrentYear());
        year2 = String.valueOf(dateTimeUtils.getCurrentYear() - 1);
    }

    @Override
    protected Node[] createNodes(Object key) {

        final Product product1 = (Product) key;
        Node result;
        result = new AbstractNode(new ProductChildrenTongQuan(product1, enterprise), Lookups.singleton(product1)) {

            @Override
            protected Sheet createSheet() {
                Sheet sheet = Sheet.createDefault();
                Sheet.Set set = Sheet.createPropertiesSet();

                Property thuMonth1Property = new PropertySupport.ReadOnly<String>(ThuMonth1_PROPERTY, String.class, "ThuM1", "aaa") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return String.valueOf(calculateSPI.calculateImportByMonthOfProduct(enterprise, product1, month1));
                    }

                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
                };
                set.put(thuMonth1Property);
                Property chiMonth1Property =
                        new PropertySupport.ReadOnly<String>(ChiMonth1_PROPERTY, String.class, "ChiM1", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportByMonthOfProduct(enterprise, product1, month1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiMonth1Property);
                Property thuMonth2Property =
                        new PropertySupport.ReadOnly<String>(ThuMonth2_PROPERTY, String.class, "ThuM2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByMonthOfProduct(enterprise, product1, month2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(thuMonth2Property);
                Property chiMonth2Property =
                        new PropertySupport.ReadOnly<String>(ChiMonth2_PROPERTY, String.class, "ChiM2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportByMonthOfProduct(enterprise, product1, month2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiMonth2Property);
                Property thuMonth3Property =
                        new PropertySupport.ReadOnly<String>(ThuMonth3_PROPERTY, String.class, "ThuM3", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByMonthOfProduct(enterprise, product1, month3));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(thuMonth3Property);
                Property chiMonth3Property =
                        new PropertySupport.ReadOnly<String>(ChiMonth3_PROPERTY, String.class, "ChiM3", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportByMonthOfProduct(enterprise, product1, month3));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiMonth3Property);
                Property laiMonth1Property =
                        new PropertySupport.ReadOnly<String>(Lai1_PROPERTY, String.class, "LaiM1", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByMonthOfProduct(enterprise, product1, month1) - calculateSPI.calculateExportByMonthOfProduct(enterprise, product1, month1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(laiMonth1Property);
                Property laiMonth2Property =
                        new PropertySupport.ReadOnly<String>(Lai2_PROPERTY, String.class, "LaiM2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByMonthOfProduct(enterprise, product1, month2) - calculateSPI.calculateExportByMonthOfProduct(enterprise, product1, month2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(laiMonth2Property);
                Property lMaionth3Property =
                        new PropertySupport.ReadOnly<String>(Lai3_PROPERTY, String.class, "LaiM3", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByMonthOfProduct(enterprise, product1, month3) - calculateSPI.calculateExportByMonthOfProduct(enterprise, product1, month3));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(lMaionth3Property);
                Property thuYear1Property =
                        new PropertySupport.ReadOnly<String>(ThuYear1_PROPERTY, String.class, "ThuY1", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByYearOfProduct(enterprise, product1, year1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(thuYear1Property);
                Property chiYear1Property =
                        new PropertySupport.ReadOnly<String>(ChiYear1_PROPERTY, String.class, "ChiY1", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportByYearOfProduct(enterprise, product1, year1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiYear1Property);
                Property laiYear1Property =
                        new PropertySupport.ReadOnly<String>(LaiYear1_PROPERTY, String.class, "LaiY1", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByYearOfProduct(enterprise, product1, year1) - calculateSPI.calculateExportByYearOfProduct(enterprise, product1, year1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(laiYear1Property);

                Property thuYear2Property =
                        new PropertySupport.ReadOnly<String>(ThuYear2_PROPERTY, String.class, "ThuY2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByYearOfProduct(enterprise, product1, year2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(thuYear2Property);
                Property chiYear2Property =
                        new PropertySupport.ReadOnly<String>(ChiYear2_PROPERTY, String.class, "ChiY2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportByYearOfProduct(enterprise, product1, year2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiYear2Property);
                Property laiYear2Property =
                        new PropertySupport.ReadOnly<String>(LaiYear2_PROPERTY, String.class, "LaiY2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByYearOfProduct(enterprise, product1, year2) - calculateSPI.calculateExportByYearOfProduct(enterprise, product1, year2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(laiYear2Property);
                Property thuAllProperty =
                        new PropertySupport.ReadOnly<String>(ThuAll_PROPERTY, String.class, "ThuAll", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportAllOfProduct(enterprise, product1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(thuAllProperty);
                Property chiAllProperty =
                        new PropertySupport.ReadOnly<String>(ChiAll_PROPERTY, String.class, "ChiAll", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportAllOfProduct(enterprise, product1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiAllProperty);
                Property laiAllProperty =
                        new PropertySupport.ReadOnly<String>(LaiAll_PROPERTY, String.class, "LaiAll", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportAllOfProduct(enterprise, product1) - calculateSPI.calculateExportAllOfProduct(enterprise, product1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(laiAllProperty);
                sheet.put(set);
                return sheet;
            }
        };
        result.setDisplayName(product1.getProductName());
        return new Node[]{result};
    }

    @Override
    protected void addNotify() {
        super.addNotify();
        if (enterprise != null) {
            list = productBN.getByEnterprise(enterprise);
            Vector instr = new Vector();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProductgroups().equals(Product.getProductName())) {
                    Product product1 = new Product();
                    product1.setProductName(list.get(i).getProductName());
                    //Product1.setDirector(list.get(i).getDirector());
                    product1.setProductgroups(list.get(i).getProductgroups());
                    instr.addElement(product1);
                }

            }

            Product[] products = new Product[instr.size()];
            for (int i = 0; i < instr.size(); i++) {
                products[i] = (Product) instr.elementAt(i);
            }
            setKeys(products);

        }
    }
}
