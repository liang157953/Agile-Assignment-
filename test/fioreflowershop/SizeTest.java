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
public class SizeTest {
    private Size size1,size2;
    public SizeTest() {      
    }
    
    @Before
    public void setUp() {
        size1 = new Size();
        size2 = new Size("SZ1001","Medium",5.00);
    }

    /**
     * Test of getSizeID method, of class Size.
     */
    @Test
    public void testGetSizeID() {
        System.out.println("getSizeID");
        String expResult = "SZ1001";
        String result = size2.getSizeID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSizeID method, of class Size.
     */
    @Test
    public void testSetSizeID() {
        System.out.println("setSizeID");
        size1.setSizeID("SZ1001");
        String expResult = "SZ1001";
        String result = size1.getSizeID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSizeDesc method, of class Size.
     */
    @Test
    public void testGetSizeDesc() {
        System.out.println("getSizeDesc");
         String expResult = "Medium";
        String result = size2.getSizeDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSizeDesc method, of class Size.
     */
    @Test
    public void testSetSizeDesc() {
        System.out.println("setSizeDesc");
        size1.setSizeDesc("Medium");
        String expResult = "Medium";
        String result = size1.getSizeDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSizePrice method, of class Size.
     */
    @Test
    public void testGetSizePrice() {
        System.out.println("getSizePrice");
        double expResult = 5.0;
        double result = size2.getSizePrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setSizePrice method, of class Size.
     */
    @Test
    public void testSetSizePrice() {
        System.out.println("setSizePrice");
        double accPrice = 15.00;
        size1.setSizePrice(accPrice);
        
        double expResult = accPrice;
        double result = size1.getSizePrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Size.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Size{" + "sizeID=" + "SZ1001" + ", sizeDesc=" + "Medium" + ", sizePrice=" + 5.0+ '}';
        String result = size2.toString();
        assertEquals(expResult, result);
    }
    
}