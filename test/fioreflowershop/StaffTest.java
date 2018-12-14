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
public class StaffTest {
    private Staff s1,s2;
    public StaffTest() {
    }
    
    @Before
    public void setUp() {
        s1 = new Staff();
        s2 = new Staff("S1001","Lim","0197788991");
    }

    /**
     * Test of getStaffID method, of class Staff.
     */
    @Test
    public void testGetStaffID() {
        System.out.println("getStaffID");
        
        String expResult = "S1001";
        String result = s2.getStaffID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setStaffID method, of class Staff.
     */
    @Test
    public void testSetStaffID() {
        System.out.println("setStaffID");
        String staffID = "S1001";
        s1.setStaffID("S1001");
        String expResult = "S1001";
        String result = s1.getStaffID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getStaffName method, of class Staff.
     */
    @Test
    public void testGetStaffName() {
        System.out.println("getStaffName");
        String expResult = "Lim";
        String result = s2.getStaffName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setStaffName method, of class Staff.
     */
    @Test
    public void testSetStaffName() {
        System.out.println("setStaffName");
        s1.setStaffName("Lew");
        String expResult = "Lew";
        String result = s1.getStaffName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getStaffContactNo method, of class Staff.
     */
    @Test
    public void testGetStaffContactNo() {
        System.out.println("getStaffContactNo");
        Staff instance = new Staff();
        String expResult = "0197788991";
        String result = s2.getStaffContactNo();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setStaffContactNo method, of class Staff.
     */
    @Test
    public void testSetStaffContactNo() {
        System.out.println("setStaffContactNo");
        String staffContactNo = "0197788991";
        s1.setStaffContactNo("0197788991");
        String expResult = "0197788991";
        String result = s1.getStaffContactNo();
        
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of toString method, of class Staff.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        
        String expResult = "Staff{" + "staffID=" + "S1001" + ", staffName=" + "Lim" + ", staffContactNo=" + "0197788991" + '}';;
        String result = s2.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}