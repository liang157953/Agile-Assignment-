/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class CustomerTest {
    private Customer c1,c2;
    public CustomerTest() {
    }
    
    @Before
    public void setUp() {
        c1 = new Customer();
        c2 = new Customer("C1001","Lew","address","contact");
    }

    /**
     * Test of getCustID method, of class Customer.
     */
    @Test
    public void testGetCustID() {
        System.out.println("getCustID");
        
        String expResult = "C1001";
        String result = c2.getCustID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustID method, of class Customer.
     */
    @Test
    public void testSetCustID() {
        System.out.println("setCustID");

        c1.setCustID("C1001");
        String expResult = "C1001";
        String result = c1.getCustID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustName method, of class Customer.
     */
    @Test
    public void testGetCustName() {
        System.out.println("getCustName");
        String expResult = "Lew";
        String result = c2.getCustName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustName method, of class Customer.
     */
    @Test
    public void testSetCustName() {
        System.out.println("setCustName");
        
        c1.setCustName("Lew");
        String expResult = "Lew";
        String result = c1.getCustName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustAddress method, of class Customer.
     */
    @Test
    public void testGetCustAddress() {
        System.out.println("getCustAddress");
        String expResult = "address";
        String result = c2.getCustAddress();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustAddress method, of class Customer.
     */
    @Test
    public void testSetCustAddress() {
        System.out.println("setCustAddress");
        
        c1.setCustAddress("address");
        String expResult = "address";
        String result = c1.getCustAddress();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustContactNo method, of class Customer.
     */
    @Test
    public void testGetCustContactNo() {
        System.out.println("getCustContactNo");
        String expResult = "contact";
        String result = c2.getCustContactNo();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustContactNo method, of class Customer.
     */
    @Test
    public void testSetCustContactNo() {
        System.out.println("setCustContactNo");
        c1.setCustContactNo("contact");
        String expResult = "contact";
        String result = c1.getCustContactNo();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Customer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "Customer{" + "custID=" + "C1001" + ", custName=" + "Lew" + ", custAddress=" + "address" + ", custContactNo=" + "contact" + '}';;
        String result = c2.toString();
        assertEquals(expResult, result);
    }
    
}
