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
public class AccessoriesTest {
    private Accessories a1, a2;
    
    public AccessoriesTest() {
    }
    
    @Before
    public void setUp() {
        a1 = new Accessories();
        a2 = new Accessories("A1001", "Pikachu",15.00);
    }

    /**
     * Test of getAccID method, of class Accessories.
     */
    @Test
    public void testGetAccID() {
        System.out.println("getAccID");

        String expResult = "A1001";
        String result = a2.getAccID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAccID method, of class Accessories.
     */
    @Test
    public void testSetAccID() {
        System.out.println("setAccID");
        String accID = "A1001";
        a1.setAccID(accID);
        
        String expResult = "A1001";
        String result = a1.getAccID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccDesc method, of class Accessories.
     */
    @Test
    public void testGetAccDesc() {
        System.out.println("getAccDesc");
        String expResult = "Pikachu";
        String result = a2.getAccDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAccDesc method, of class Accessories.
     */
    @Test
    public void testSetAccDesc() {
        System.out.println("setAccDesc");
        String accDesc = "Pikachu";
        a1.setAccDesc(accDesc);
        
        String expResult = "Pikachu";
        String result = a1.getAccDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAccPrice method, of class Accessories.
     */
    @Test
    public void testGetAccPrice() {
        System.out.println("getAccPrice");

        double expResult = 15.00;
        double result = a2.getAccPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAccPrice method, of class Accessories.
     */
    @Test
    public void testSetAccPrice() {
        System.out.println("setAccPrice");
        double accPrice = 15.00;
        a1.setAccPrice(accPrice);
        
        double expResult = accPrice;
        double result = a1.getAccPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Accessories.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Accessories{" + "accID=" + "A1001" + ", accDesc=" + "Pikachu" + ", accPrice=" + 15.00 + '}';
        String result = a2.toString();
        assertEquals(expResult, result);
    }
    
}
