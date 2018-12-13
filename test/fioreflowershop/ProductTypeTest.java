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
 * @author User
 */
public class ProductTypeTest {
    private ProductType pt1,pt2;
    
    public ProductTypeTest() {
    }
    
    @Before
    public void setUp() {
        pt1 = new ProductType();
        pt2 = new ProductType("PT1001","Fresh Flowers","The flowers that will be wither..");        
    }

    /**
     * Test of getProductTypeDesc method, of class ProductType.
     */
    @Test
    public void testGetProductTypeDesc() {
        System.out.println("getProductTypeDesc");
        String expResult = "The flowers that will be wither..";
        String result = pt2.getProductTypeDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductTypeDesc method, of class ProductType.
     */
    @Test
    public void testSetProductTypeDesc() {
        System.out.println("setProductTypeDesc");
        pt1.setProductTypeDesc("The flowers that will be wither..");
        String expResult = "The flowers that will be wither..";
        String result = pt1.getProductTypeDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductTypeID method, of class ProductType.
     */
    @Test
    public void testGetProductTypeID() {
        System.out.println("getProductTypeID");
        
        String expResult = "PT1001";
        String result = pt2.getProductTypeID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductTypeID method, of class ProductType.
     */
    @Test
    public void testSetProductTypeID() {
        System.out.println("setProductTypeID");
        pt1.setProductTypeID("PT1001");
        String expResult = "PT1001";
        String result = pt1.getProductTypeID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductTypeName method, of class ProductType.
     */
    @Test
    public void testGetProductTypeName() {
        System.out.println("getProductTypeName");
       
        String expResult = "Fresh Flowers";
        String result = pt2.getProductTypeName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProductTypeName method, of class ProductType.
     */
    @Test
    public void testSetProductTypeName() {
        System.out.println("setProductTypeName");
        pt1.setProductTypeName("Fresh Flowers");
        String expResult = "Fresh Flowers";
        String result = pt1.getProductTypeName();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ProductType.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "ProductType{" + "productTypeID=" + "PT1001" + ", productTypeName=" + "Fresh Flowers" + ", productTypeDesc=" + "The flowers that will be wither.."+ '}';
        String result = pt2.toString();
        assertEquals(expResult, result);
    }
    
}