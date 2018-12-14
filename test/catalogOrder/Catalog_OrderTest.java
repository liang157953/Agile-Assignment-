/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogOrder;

import fioreflowershop.CorporateCustomer;
import fioreflowershop.Customer;
import fioreflowershop.Order;
import fioreflowershop.Payment;
import fioreflowershop.Product;
import fioreflowershop.ProductType;
import fioreflowershop.Staff;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class Catalog_OrderTest {
    
    public Catalog_OrderTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of CatalogOrderM method, of class Catalog_Order.
     */
    @Test
    public void testCatalogOrderM() throws Exception {
        System.out.println("CatalogOrderM");
        List<ProductType> listProdType = null;
        List<Product> listProduct = null;
        List<Order> orderDataList = null;
        List<Customer> customerList = null;
        List<Staff> staffList = null;
        List<Payment> paymentList = null;
        List<CorporateCustomer> corporateCustList = null;
        List<Order> expResult = null;
        List<Order> result = Catalog_Order.CatalogOrderM(listProdType, listProduct, orderDataList, customerList, staffList, paymentList, corporateCustList);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CheckAlphabetic method, of class Catalog_Order.
     */
    @Test
    public void testCheckAlphabetic() throws Exception {
        System.out.println("CheckAlphabetic");
        char input = ' ';
        boolean expResult = false;
        boolean result = Catalog_Order.CheckAlphabetic(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
