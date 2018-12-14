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
 * @author acer
 */
public class ProductTest {
    private Product p1,p2;
    private ProductType pt = new ProductType("PT1001","Fresh Flowers","The flowers that will be wither...");
    
    public ProductTest() {
    }
    
    @Before
    public void setUp() {
        p1 = new Product();
        p2 = new Product("P1001","Flowers","DESC","Red",60.00,5,pt,"month");
    }

    /**
     * Test of getProductPromotionMonth method, of class Product.
     */
    @Test
    public void testGetProductPromotionMonth() {
        System.out.println("getProductPromotionMonth");
        
        String expResult = "month";
        String result = p2.getProductPromotionMonth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setProductPromotionMonth method, of class Product.
     */
    @Test
    public void testSetProductPromotionMonth() {
        System.out.println("setProductPromotionMonth");
        
        p1.setProductPromotionMonth("month");
        String expResult = "month";
        String result = p1.getProductPromotionMonth();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductDesc method, of class Product.
     */
    @Test
    public void testGetProductDesc() {
        System.out.println("getProductDesc");
        
        String expResult = "DESC";
        String result = p2.getProductDesc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setProductDesc method, of class Product.
     */
    @Test
    public void testSetProductDesc() {
        System.out.println("setProductDesc");
        String productDesc = "DESC";
        p1.setProductDesc("DESC");
        String expResult = "DESC";
        String result = p1.getProductDesc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductColor method, of class Product.
     */
    @Test
    public void testGetProductColor() {
        System.out.println("getProductColor");
        
        String expResult = "Red";
        String result = p2.getProductColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setProductColor method, of class Product.
     */
    @Test
    public void testSetProductColor() {
        System.out.println("setProductColor");
        p1.setProductColor("Red");
        String expResult = "Red";
        String result = p1.getProductColor();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getProductID method, of class Product.
     */
    @Test
    public void testGetProductID() {
        System.out.println("getProductID");
        
        String expResult = "P1001";
        String result = p2.getProductID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setProductID method, of class Product.
     */
    @Test
    public void testSetProductID() {
        System.out.println("setProductID");
        p1.setProductID("P1001");
        String expResult = "P1001";
        String result = p1.getProductID();
                
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
 
    }

    /**
     * Test of getProductName method, of class Product.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        
        String expResult = "Flowers";
        String result = p2.getProductName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setProductName method, of class Product.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        p1.setProductName("Flowers");
        String expResult = "Flowers";
        String result = p1.getProductName();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductPrice method, of class Product.
     */
    @Test
    public void testGetProductPrice() {
        System.out.println("getProductPrice");
        
        double expResult = 60.00;
        double result = p2.getProductPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setProductPrice method, of class Product.
     */
    @Test
    public void testSetProductPrice() {
        System.out.println("setProductPrice");
        double productPrice = 60.00;
        p1.setProductPrice(productPrice);
        
        double expResult = productPrice;
        double result = p1.getProductPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getProductQuantity method, of class Product.
     */
    @Test
    public void testGetProductQuantity() {
        System.out.println("getProductQuantity");
        
        int expResult = 5;
        int result = p2.getProductQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setProductQuantity method, of class Product.
     */
    @Test
    public void testSetProductQuantity() {
        System.out.println("setProductQuantity");
        p1.setProductQuantity(5);
        int expResult = 5;
        int result = p1.getProductQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getProductType method, of class Product.
     */
    @Test
    public void testGetProductType() {
        System.out.println("getProductType");
        
        ProductType expResult = pt;
        ProductType result = p2.getProductType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setProductType method, of class Product.
     */
    @Test
    public void testSetProductType() {
        System.out.println("setProductType");
        
        p1.setProductType(pt);
        ProductType expResult = pt;
        ProductType result = p1.getProductType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "Product{" + "productID=" + "P1001" + ", productName=" + "Flowers" + ", productDesc=" + "DESC" + ", productColor=" + "Red" + ", productPrice=" + 60.00 + ", productQuantity=" + 5 + ", productType=" + pt + ", productPromotionMonth=" + "month" + '}';
        String result = p2.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}