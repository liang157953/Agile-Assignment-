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
public class PaymentTest {
    private Payment p1,p2;
    public PaymentTest() {
    }
    
    @Before
    public void setUp() {
        p1 = new Payment();
        p2 = new Payment("PA1001","10-11-2018",100.0,"Paid");
    }

    /**
     * Test of getPaymentID method, of class Payment.
     */
    @Test
    public void testGetPaymentID() {
        System.out.println("getPaymentID");
        
        String expResult = "PA1001";
        String result = p2.getPaymentID();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setPaymentID method, of class Payment.
     */
    @Test
    public void testSetPaymentID() {
        System.out.println("setPaymentID");
        
        p1.setPaymentID("PA1001");
        String expResult = "PA1001";
        String result = p1.getPaymentID();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getPaymentDate method, of class Payment.
     */
    @Test
    public void testGetPaymentDate() {
        System.out.println("getPaymentDate");
        
        String expResult = "10-11-2018";
        String result = p2.getPaymentDate();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setPaymentDate method, of class Payment.
     */
    @Test
    public void testSetPaymentDate() {
        System.out.println("setPaymentDate");
        
        p1.setPaymentDate("10-11-2018");
        String expResult = "10-11-2018";
        String result = p1.getPaymentDate();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getTotalAmount method, of class Payment.
     */
    @Test
    public void testGetTotalAmount() {
        System.out.println("getTotalAmount");
        
        double expResult = 100.00;
        double result = p2.getTotalAmount();
        
        assertEquals(expResult, result,0.0);
    }

    /**
     * Test of setTotalAmount method, of class Payment.
     */
    @Test
    public void testSetTotalAmount() {
        System.out.println("setTotalAmount");
        
        p1.setTotalAmount(100.00);
        double expResult = 100.00;
        double result = p1.getTotalAmount();
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getPaymentStatus method, of class Payment.
     */
    @Test
    public void testGetPaymentStatus() {
        System.out.println("getPaymentStatus");
        
        String expResult = "Paid";
        String result = p2.getPaymentStatus();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setPaymentStatus method, of class Payment.
     */
    @Test
    public void testSetPaymentStatus() {
        System.out.println("setPaymentStatus");
        
        p1.setPaymentStatus("Paid");
        String expResult = "Paid";
        String result = p1.getPaymentStatus();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Payment.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        String expResult = "Payment{" + "paymentID=" + "PA1001" + ", paymentDate=" + "10-11-2018" + ", totalAmount=" + 100.00 + ", paymentStatus=" + "Paid" + '}';
        String result = p2.toString();
        assertEquals(expResult, result);
    }
    
}
