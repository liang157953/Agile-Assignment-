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
public class OrderTest {
    private Order o1,o2;
    private Customer customer = new Customer("C1001","Koh Liao Liao","pv16,jalan setapak","011-39958399"); 
    private Payment payment = new Payment("PA1001","10-11-2018",100.0,"Paid");
    private Staff staff = new Staff("S1001","Lim Yong Qi","019-7272566");
    private Order order = new Order("O1001","Give to my girlfriend ","11-11-2018","Process",customer,payment,staff,"Customer");
    
    public OrderTest() {
    }
    
    @Before
    public void setUp() {
        o1 = new Order();
        o2 = new Order("O1001","Give to my girlfriend ","11-11-2018","Process",customer,payment,staff,"Customer");
    }

    /**
     * Test of getOrderID method, of class Order.
     */
    @Test
    public void testGetOrderID() {
        System.out.println("getOrderID");
        
        String expResult = "O1001";
        String result = o2.getOrderID();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrderID method, of class Order.
     */
    @Test
    public void testSetOrderID() {
        System.out.println("setOrderID");
        
        o1.setOrderID("O1001");
        String expResult = "O1001";
        String result = o1.getOrderID();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrderDesc method, of class Order.
     */
    @Test
    public void testGetOrderDesc() {
        System.out.println("getOrderDesc");
        
        String expResult = "Give to my girlfriend ";
        String result = o2.getOrderDesc();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrderDesc method, of class Order.
     */
    @Test
    public void testSetOrderDesc() {
        System.out.println("setOrderDesc");
        
        o1.setOrderDesc("Give to my girlfriend ");
        String expResult = "Give to my girlfriend ";
        String result = o1.getOrderDesc();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrderDate method, of class Order.
     */
    @Test
    public void testGetOrderDate() {
        System.out.println("getOrderDate");
        
        String expResult = "11-11-2018";
        String result = o2.getOrderDate();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrderDate method, of class Order.
     */
    @Test
    public void testSetOrderDate() {
        System.out.println("setOrderDate");
        
        o1.setOrderDate("11-11-2018");
        String expResult = "11-11-2018";
        String result = o1.getOrderDate();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrderStatus method, of class Order.
     */
    @Test
    public void testGetOrderStatus() {
        System.out.println("getOrderStatus");
        
        String expResult = "Process";
        String result = o2.getOrderStatus();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrderStatus method, of class Order.
     */
    @Test
    public void testSetOrderStatus() {
        System.out.println("setOrderStatus");
        
        o1.setOrderStatus("Process");
        String expResult = "Process";
        String result = o1.getOrderStatus();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomer method, of class Order.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        
        Customer expResult = customer;
        Customer result = o2.getCustomer();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustomer method, of class Order.
     */
    @Test
    public void testSetCustomer() {
        System.out.println("setCustomer");
        
        o1.setCustomer(customer);
        Customer expResult = customer;
        Customer result = o1.getCustomer();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getPayment method, of class Order.
     */
    @Test
    public void testGetPayment() {
        System.out.println("getPayment");
        
        Payment expResult = payment;
        Payment result = o2.getPayment();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setPayment method, of class Order.
     */
    @Test
    public void testSetPayment() {
        System.out.println("setPayment");
        
        o1.setPayment(payment);
        Payment expResult = payment;
        Payment result = o1.getPayment();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getStaff method, of class Order.
     */
    @Test
    public void testGetStaff() {
        System.out.println("getStaff");
        
        Staff expResult = staff;
        Staff result = o2.getStaff();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setStaff method, of class Order.
     */
    @Test
    public void testSetStaff() {
        System.out.println("setStaff");
        
        o1.setStaff(staff);
        Staff expResult = staff;
        Staff result = o1.getStaff();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Order.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "Order{" + "orderID=" + "O1001" + ", orderDesc=" + "Give to my girlfriend " + ", orderDate=" + "11-11-2018" + ", orderStatus=" + "Process" + ", customer=" + customer + ", payment=" + payment + ", staff=" + staff + '}';
        String result = o2.toString();
        assertEquals(expResult, result);
    }
    
}
