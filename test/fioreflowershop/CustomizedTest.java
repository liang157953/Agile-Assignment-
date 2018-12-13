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
public class CustomizedTest {
    private Customized c1,c2;
    private Customer customer = new Customer("C1001","Koh Liao Liao","pv16,jalan setapak","011-39958399"); 
    private Payment payment = new Payment("PA1001","10-11-2018",100.0,"Paid");
    private Staff staff = new Staff("S1001","Lim Yong Qi","019-7272566");
    private ProductType productType = new ProductType("PT1001","Fresh Flowers","The flowers that will be wither...");
    private Product product = new Product("P1001","Flowers and Chocolates Gift","DESC...","Red",60.00,5, productType);
    private Size size = new Size("SZ1001","SizeDesc",15.00);
    private Style style = new Style("S1001","StyleDesc",30.00);
    private Accessories accessories = new Accessories("A1001", "AccDesc",20.00);
    private Order order = new Order("O1001","Give to my girlfriend ","11-11-2018","Process",customer,payment,staff,"Customer");
    
    public CustomizedTest() {
    }
    
    @Before
    public void setUp() {
        c1 = new Customized();
        c2 = new Customized("C1001",product,size,style,accessories,order);
    }

    /**
     * Test of getCustomizedID method, of class Customized.
     */
    @Test
    public void testGetCustomizedID() {
        System.out.println("getCustomizedID");
        
        String expResult = "C1001";
        String result = c2.getCustomizedID();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustomizedID method, of class Customized.
     */
    @Test
    public void testSetCustomizedID() {
        System.out.println("setCustomizedID");

        c1.setCustomizedID("C1001");
        String expResult = "C1001";
        String result = c1.getCustomizedID();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getProduct method, of class Customized.
     */
    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        
        Product expResult = product;
        Product result = c2.getProduct();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setProduct method, of class Customized.
     */
    @Test
    public void testSetProduct() {
        System.out.println("setProduct");
        
        c1.setProduct(product);
        Product expResult = product;
        Product result = c1.getProduct();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class Customized.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        
        Size expResult = size;
        Size result = c2.getSize();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setSize method, of class Customized.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        
        c1.setSize(size);
        Size expResult = size;
        Size result = c1.getSize();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getStyle method, of class Customized.
     */
    @Test
    public void testGetStyle() {
        System.out.println("getStyle");
        
        Style expResult = style;
        Style result = c2.getStyle();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setStyle method, of class Customized.
     */
    @Test
    public void testSetStyle() {
        System.out.println("setStyle");
        
        c1.setSize(size);
        Size expResult = size;
        Size result = c1.getSize();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccessories method, of class Customized.
     */
    @Test
    public void testGetAccessories() {
        System.out.println("getAccessories");
        
        Accessories expResult = accessories;
        Accessories result = c2.getAccessories();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setAccessories method, of class Customized.
     */
    @Test
    public void testSetAccessories() {
        System.out.println("setAccessories");
        
        c1.setAccessories(accessories);
        Accessories expResult = accessories;
        Accessories result = c1.getAccessories();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrder method, of class Customized.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        
        Order expResult = order;
        Order result = c2.getOrder();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setOrder method, of class Customized.
     */
    @Test
    public void testSetOrder() {
        System.out.println("setOrder");
        
        c1.setOrder(order);
        Order expResult = order;
        Order result = c1.getOrder();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Customized.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "Customized{" + "customizedID=" + "C1001" + ", product=" + product + ", size=" + size + ", style=" + style + ", accessories=" + accessories + ", order=" + order + '}';
        String result = c2.toString();
        assertEquals(expResult, result);
    }
    
}
