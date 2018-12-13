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
public class DeliveryTest {
    private Delivery d1,d2;
    private Customer customer = new Customer("C1001","Koh Liao Liao","pv16,jalan setapak","011-39958399"); 
    private Payment payment = new Payment("PA1001","10-11-2018",100.0,"Paid");
    private Staff staff = new Staff("S1001","Lim Yong Qi","019-7272566");
    private Order order = new Order("O1001","Give to my girlfriend ","11-11-2018","Process",customer,payment,staff,"Customer");
    public DeliveryTest() {
    }
    
    @Before
    public void setUp() {
        d1 = new Delivery();
        d2 = new Delivery("T1101","25-20,PV16","Setapak","019-7132686","25 November 2018","1200","26 November 2018","1200","Processing",staff,order,1);
    }

    /**
     * Test of getTrackingNo method, of class Delivery.
     */
    @Test
    public void testGetTrackingNo() {
        System.out.println("getTrackingNo");
        
        String expResult = "T1101";
        String result = d2.getTrackingNo();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getDeliveryAddress method, of class Delivery.
     */
    @Test
    public void testGetDeliveryAddress() {
        System.out.println("getDeliveryAddress");
        
        String expResult = "25-20,PV16";
        String result = d2.getDeliveryAddress();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getState method, of class Delivery.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        
        String expResult = "Setapak";
        String result = d2.getState();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getDeliveryContactNo method, of class Delivery.
     */
    @Test
    public void testGetDeliveryContactNo() {
        System.out.println("getDeliveryContactNo");
        
        String expResult = "019-7132686";
        String result = d2.getDeliveryContactNo();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequireDeliveryDate method, of class Delivery.
     */
    @Test
    public void testGetRequireDeliveryDate() {
        System.out.println("getRequireDeliveryDate");
        
        String expResult = "25 November 2018";
        String result = d2.getRequireDeliveryDate();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getRequireDeliveryTime method, of class Delivery.
     */
    @Test
    public void testGetRequireDeliveryTime() {
        System.out.println("getRequireDeliveryTime");
        
        String expResult = "1200";
        String result = d2.getRequireDeliveryTime();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getArrivalDate method, of class Delivery.
     */
    @Test
    public void testGetArrivalDate() {
        System.out.println("getArrivalDate");
        
        String expResult = "26 November 2018";
        String result = d2.getArrivalDate();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getArrivalTime method, of class Delivery.
     */
    @Test
    public void testGetArrivalTime() {
        System.out.println("getArrivalTime");
        
        String expResult = "1200";
        String result = d2.getArrivalTime();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getDeliveryStatus method, of class Delivery.
     */
    @Test
    public void testGetDeliveryStatus() {
        System.out.println("getDeliveryStatus");
        
        String expResult = "Processing";
        String result = d2.getDeliveryStatus();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getStaff method, of class Delivery.
     */
    @Test
    public void testGetStaff() {
        System.out.println("getStaff");
        
        Staff expResult = staff;
        Staff result = d2.getStaff();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrder method, of class Delivery.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        
        Order expResult = order;
        Order result = d2.getOrder();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getPriorityLevel method, of class Delivery.
     */
    @Test
    public void testGetPriorityLevel() {
        System.out.println("getPriorityLevel");
        
        int expResult = 1;
        int result = d2.getPriorityLevel();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setTrackingNo method, of class Delivery.
     */
    @Test
    public void testSetTrackingNo() {
        System.out.println("setTrackingNo");
        
        d1.setTrackingNo("T1101");
        String expResult = "T1101";
        String result = d1.getTrackingNo();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setDeliveryAddress method, of class Delivery.
     */
    @Test
    public void testSetDeliveryAddress() {
        System.out.println("setDeliveryAddress");
        
        d1.setTrackingNo("25-20,PV16");
        String expResult = "25-20,PV16";
        String result = d1.getTrackingNo();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setState method, of class Delivery.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        
        d1.setState("Setapak");
        String expResult = "Setapak";
        String result = d1.getState();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setDeliveryContactNo method, of class Delivery.
     */
    @Test
    public void testSetDeliveryContactNo() {
        System.out.println("setDeliveryContactNo");
        
        d1.setDeliveryContactNo("019-7132686");
        String expResult = "019-7132686";
        String result = d1.getDeliveryContactNo();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setRequireDeliveryDate method, of class Delivery.
     */
    @Test
    public void testSetRequireDeliveryDate() {
        System.out.println("setRequireDeliveryDate");
        
        d1.setRequireDeliveryDate("25 November 2018");
        String expResult = "25 November 2018";
        String result = d1.getRequireDeliveryDate();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setRequireDeliveryTime method, of class Delivery.
     */
    @Test
    public void testSetRequireDeliveryTime() {
        System.out.println("setRequireDeliveryTime");
       
        d1.setRequireDeliveryTime("1200");
        String expResult = "1200";
        String result = d1.getRequireDeliveryTime();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setArrivalDate method, of class Delivery.
     */
    @Test
    public void testSetArrivalDate() {
        System.out.println("setArrivalDate");
        
        d1.setArrivalDate("26 November 2018");
        String expResult = "26 November 2018";
        String result = d1.getArrivalDate();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setArrivalTime method, of class Delivery.
     */
    @Test
    public void testSetArrivalTime() {
        System.out.println("setArrivalTime");
        
        d1.setArrivalTime("1200");
        String expResult = "1200";
        String result = d1.getArrivalTime();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setDeliveryStatus method, of class Delivery.
     */
    @Test
    public void testSetDeliveryStatus() {
        System.out.println("setDeliveryStatus");
        
        d1.setDeliveryStatus("Processing");
        String expResult = "Processing";
        String result = d1.getDeliveryStatus();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setStaff method, of class Delivery.
     */
    @Test
    public void testSetStaff() {
        System.out.println("setStaff");
        
        d1.setStaff(staff);
        Staff expResult = staff;
        Staff result = d1.getStaff();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrder method, of class Delivery.
     */
    @Test
    public void testSetOrder() {
        System.out.println("setOrder");
        
        d1.setOrder(order);
        Order expResult = order;
        Order result = d1.getOrder();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setPriorityLevel method, of class Delivery.
     */
    @Test
    public void testSetPriorityLevel() {
        System.out.println("setPriorityLevel");
        
        d1.setPriorityLevel(1);
        int expResult = 1;
        int result = d1.getPriorityLevel();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Delivery.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "Delivery{" + "trackingNo=" + "T1101" + ", deliveryAddress=" + "25-20,PV16" + ", state=" + "Setapak" + ", deliveryContactNo=" + "019-7132686" + ", requireDeliveryDate=" + "25 November 2018" + ", requireDeliveryTime=" + "1200" + ", arrivalDate=" + "26 November 2018" + ", arrivalTime=" + "1200" + ", deliveryStatus=" + "Processing" + ", staff=" + staff + ", order=" + order + ", priorityLevel=" + 1 + '}';;
        String result = d2.toString();
        assertEquals(expResult, result);
    }
    
}
