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
public class CorporateCustomerTest {
    private CorporateCustomer co1,co2;
    public CorporateCustomerTest() {
    }
    
    @Before
    public void setUp() {
        co1 = new CorporateCustomer();
        co2 = new CorporateCustomer(150.00,50.00,"status","CO1001","Lew","address","contact");
    }

    /**
     * Test of getCreditLimit method, of class CorporateCustomer.
     */
    @Test
    public void testGetCreditLimit() {
        System.out.println("getCreditLimit");
        double expResult = 150.00;
        double result = co2.getCreditLimit();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCreditLimit method, of class CorporateCustomer.
     */
    @Test
    public void testSetCreditLimit() {
        System.out.println("setCreditLimit");
        double creditLimit = 150;
        double expResult = 150.00;
        co1.setCreditLimit(creditLimit);
        double result = co1.getCreditLimit();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getCreditAmount method, of class CorporateCustomer.
     */
    @Test
    public void testGetCreditAmount() {
        System.out.println("getCreditAmount");

        double expResult = 50;
        double result = co2.getCreditAmount();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setCreditAmount method, of class CorporateCustomer.
     */
    @Test
    public void testSetCreditAmount() {
        System.out.println("setCreditAmount");
        double creditAmount = 50;
        double expResult = 50.00;
        co1.setCreditAmount(creditAmount);
        double result = co1.getCreditAmount();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getStatus method, of class CorporateCustomer.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        
        String expResult = "status";
        String result = co2.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatus method, of class CorporateCustomer.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "status";
        co1.setStatus(status);
        
        String expResult = "status";
        String result = co1.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class CorporateCustomer.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "CorporateCustomer{" + "creditLimit=" + 150.00 + ", creditAmount=" + 50.00 + ", status=" + "status" + '}';
        String result = co2.toString();
        assertEquals(expResult, result);
    }
    
}
