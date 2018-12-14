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
public class OrderListTest {
    private OrderList o1,o2;
    private Customer customer = new Customer("C1001","Koh Liao Liao","pv16,jalan setapak","011-39958399"); 
    private Payment payment = new Payment("PA1001","10-11-2018",100.0,"Paid");
    private Staff staff = new Staff("S1001","Lim Yong Qi","019-7272566");
    private ProductType productType = new ProductType("PT1001","Fresh Flowers","The flowers that will be wither...");
    private Product product = new Product("P1001","Flowers and Chocolates Gift","DESC...","Red",60.00,5, productType);
    private Order order = new Order("O1001","Give to my girlfriend ","11-11-2018","Process",customer,payment,staff,"Customer");
    
    public OrderListTest() {
    }
    
    @Before
    public void setUp() {
        o1 = new OrderList();
        o2 = new OrderList(order,product,2);
    }

    /**
     * Test of getOrder method, of class OrderList.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        
        Order expResult = order;
        Order result = o2.getOrder();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrder method, of class OrderList.
     */
    @Test
    public void testSetOrder() {
        System.out.println("setOrder");
        
        o1.setOrder(order);
        Order expResult = order;
        Order result = o1.getOrder();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getProduct method, of class OrderList.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        
        Product expResult = product;
        Product result = o2.getProduct();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setProduct method, of class OrderList.
     */
    @Test
    public void testSetProduct() {
        System.out.println("setProduct");
        
        o1.setProduct(product);
        Product expResult = product;
        Product result = o1.getProduct();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantity method, of class OrderList.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        
        int expResult = 2;
        int result = o2.getQuantity();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuantity method, of class OrderList.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        
        o1.setQuantity(2);
        int expResult = 2;
        int result = o1.getQuantity();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class OrderList.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "OrderList{" + "order=" + order + ", product=" + product + ", quantity=" + 2 + '}';;
        String result = o2.toString();
        assertEquals(expResult, result);
    }
    
}
