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
public class StyleTest {
    private Style s1,s2;
    public StyleTest() {
    }
    
    @Before
    public void setUp() {
        s1 = new Style();
        s2 = new Style("ST1001","Standard",10.0);
    }

    /**
     * Test of getStyleID method, of class Style.
     */
    @Test
    public void testGetStyleID() {
        System.out.println("getStyleID");
        String expResult = "ST1001";
        String result = s2.getStyleID();
        assertEquals(expResult, result);

    }

    /**
     * Test of setStyleID method, of class Style.
     */
    @Test
    public void testSetStyleID() {
        System.out.println("setStyleID");
        s1.setStyleID("contact");
        String expResult = "contact";
        String result = s1.getStyleID();
        
        assertEquals(expResult, result);

    }

    /**
     * Test of getStyleDesc method, of class Style.
     */
    @Test
    public void testGetStyleDesc() {
        System.out.println("getStyleDesc");
        String expResult = "Standard";
        String result = s2.getStyleDesc();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStyleDesc method, of class Style.
     */
    @Test
    public void testSetStyleDesc() {
        System.out.println("setStyleDesc");
        s1.setStyleDesc("Standard");
        String expResult = "Standard";
        String result = s1.getStyleDesc();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getStylePrice method, of class Style.
     */
    @Test
    public void testGetStylePrice() {
        System.out.println("getStylePrice");
        double expResult = 10.0;
        double result = s2.getStylePrice();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of setStylePrice method, of class Style.
     */
    @Test
    public void testSetStylePrice() {
        System.out.println("setStylePrice");
        double stylePrice = 15.00;
        s1.setStylePrice(stylePrice);
        
        double expResult = stylePrice;
        double result = s1.getStylePrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class Style.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Style{" + "styleID=" + "ST1001" + ", styleDesc=" + "Standard" + ", stylePrice=" + 10.0+ '}';
        String result = s2.toString();
        assertEquals(expResult, result);
    }
    
}