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
 * @author asus
 */
public class PickUpTest {
     private PickUp p1, p2;
     private Staff staff = new Staff("S1001","Lim Yong Qi","019-7272566");
     private Customer customer = new Customer("C1001","Koh Liao Liao","pv16,jalan setapak","011-39958399");
     private Payment payment = new Payment("PA1001","10/11/2018",100.0,"Paid");
     private Order order = new Order("O" + "1001","Give to my girlfriend ","11/11/2018","Process",customer,payment,staff,"Customer");
    
    public PickUpTest() {
       
    }
    
    
    @Before
    public void setUp() {
     p1 = new PickUp();
     p2 = new PickUp("PU1001","12/12/2018","1400","12/12/2018","1410","Standby",staff,order);
    
    }

    /**
     * Test of getRequirePickUpDate method, of class PickUp.
     */
    @Test
    public void testGetRequirePickUpDate() {
        System.out.println("getRequirePickUpDate");   
        String expResult = "12/12/2018";
        String result = p2.getRequirePickUpDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }
    /**
     * Test of setRequirePickUpDate method, of class PickUp.
     */
    @Test
    public void testSetRequirePickUpDate() {
        System.out.println("setRequirePickUpDate");
        p1.setPickupDate("12/12/2018");
        String expResult = "12/12/2018";
        String result = p1.getPickupDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of getRequirePickUpTime method, of class PickUp.
     */
    @Test
    public void testGetRequirePickUpTime() {
        System.out.println("getRequirePickUpTime");
        String expResult = "1400";
        String result = p2.getRequirePickUpTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of setRequirePickUpTime method, of class PickUp.
     */
    @Test
    public void testSetRequirePickUpTime() {
        System.out.println("setRequirePickUpTime");
         p1.setRequirePickUpDate("1410");
        String expResult = "1410";
        String result = p1.getRequirePickUpDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPickupNo method, of class PickUp.
     */
    @Test
    public void testGetPickupNo() {
        System.out.println("getPickupNo");
       String expResult = "PU1001";
        String result = p2.getPickupNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPickupNo method, of class PickUp.
     */
    @Test
    public void testSetPickupNo() {
        System.out.println("setPickupNo");
        p1.setPickupNo("PU1002");
        String expResult = "PU1002";
        String result = p1.getPickupNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPickupDate method, of class PickUp.
     */
    @Test
    public void testGetPickupDate() {
        System.out.println("getPickupDate");
        String expResult = "12/12/2018";
        String result = p2.getRequirePickUpDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPickupDate method, of class PickUp.
     */
    @Test
    public void testSetPickupDate() {
        System.out.println("setPickupDate");
         p1.setPickupDate("12/12/2018");
        String expResult = "12/12/2018";
        String result = p1.getPickupDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPickupTime method, of class PickUp.
     */
    @Test
    public void testGetPickupTime() {
        System.out.println("getPickupTime");
        String expResult = "1410";
        String result = p2.getPickupTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPickupTime method, of class PickUp.
     */
    @Test
    public void testSetPickupTime() {
        System.out.println("setPickupTime");
        p1.setPickupTime("1420");
        String expResult = "1420";
        String result = p1.getPickupTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPickupStatus method, of class PickUp.
     */
    @Test
    public void testGetPickupStatus() {
        System.out.println("getPickupStatus");
        String expResult = "Standby";
        String result = p2.getPickupStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPickupStatus method, of class PickUp.
     */
    @Test
    public void testSetPickupStatus() {
        System.out.println("setPickupStatus");
        p1.setPickupStatus("Standby");
        String expResult = "Standby";
        String result = p1.getPickupStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStaff method, of class PickUp.
     */
    @Test
    public void testGetStaff() {
        System.out.println("getStaff");
        Staff expResult = staff;
        Staff result = p2.getStaff();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStaff method, of class PickUp.
     */
    @Test
    public void testSetStaff() {
        System.out.println("setStaff");
        p1.setStaff(staff);
        Staff expResult = staff;
        Staff result = p1.getStaff();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrder method, of class PickUp.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
       Order expResult = order;
        Order result = p2.getOrder();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrder method, of class PickUp.
     */
    @Test
    public void testSetOrder() {
        System.out.println("setOrder");
        
        p1.setOrder(order);
        Order expResult = order;
        Order result = p1.getOrder();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class PickUp.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "PickUp{" + "pickupNo=" + "PU1001" + ", requirePickUpDate=" + "12/12/2018" + ", requirePickUpTime=" + "1400" + ", pickupDate=" + "12/12/2018" + ", pickupTime=" + "1410" + ", pickupStatus=" + "Standby" + ", staff=" + staff + ", order=" + order + '}';
        String result = p2.toString();
        assertEquals(expResult, result);
    }
    
}