/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogMaintenance;

import fioreflowershop.Product;
import fioreflowershop.ProductType;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asus
 */
public class ProductMaintenanceTest {
    private List<Product> prodList = new ArrayList<Product>();
    private List<ProductType> prodTypeList = new ArrayList<ProductType>();
    public ProductMaintenanceTest() {
    }
    
    @Before
    public void setUp() {
        prodTypeList.add(new ProductType("PT1001","Fresh Flowers","The flowers that will be wither..."));
        prodTypeList.add(new ProductType("PT1002","Bouquets","An attractively arranged bunch of flowers, especially one presented as a gift or carried at a ceremony."));
        prodTypeList.add(new ProductType("PT1003","Floral Arrangements","Flower arrangement is an organization of design and color towards creating an ambience using flowers, foliage and other floral accessories"));
        
        prodList.add(new Product("P1001","Flowers and Chocolates Gift","DESC...","Red",60.00,5,prodTypeList.get(0)));
        prodList.add(new Product("P1002","Ladies Gift Hamper","DESC...","Red",65.00,5,prodTypeList.get(1)));
        prodList.add(new Product("P1003","Christmas Treats Gift Box","DESC...","White",15.00,3,prodTypeList.get(1)));
        prodList.add(new Product("P1004","Honeybee","DESC...","Yellow",30.00,5,prodTypeList.get(0)));
        prodList.add(new Product("P1005","Starry Night","DESC...","Blue",45.00,5,prodTypeList.get(2)));
    }

    @Test
    public void testCustomerViewProducts() throws Exception {
        System.out.println("CustomerViewProducts");
        String selection="3";
        Boolean expResult = true;
        Boolean result = ProductMaintenance.CustomerViewProducts(prodList, prodTypeList,selection);
        assertEquals(expResult, result);
        
        if(expResult){
            System.out.println("View Successfully");
        }else{
            System.out.println("Failed to View. Invalid Options");
        }
    }

}
