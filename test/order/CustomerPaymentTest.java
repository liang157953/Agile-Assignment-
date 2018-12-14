/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import fioreflowershop.Payment;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CustomerPaymentTest {
    private List<Payment> paylist = new ArrayList<Payment>();
    public CustomerPaymentTest() {
       
    }
    
    @Before
    public void setUp() {
        paylist.add(new Payment("PA1001","10/11/2018",100.0,"Paid"));
        paylist.add(new Payment("PA1002","11/11/2018",200.0,"UnPaid"));
        paylist.add(new Payment("PA1003","15/11/2018",100.0,"UnPaid"));
    }

    /**
     * Test of MakePayment method, of class CustomerPayment.
     */
    @Test
    public void testMakePayment() throws Exception {
        System.out.println("MakePayment");

        char selection = 'Y';
        Boolean expResult = true;
        Boolean result = CustomerPayment.MakePayment(paylist, selection,"PA1002");
        assertEquals(expResult, result);
        
        if(expResult){
            System.out.println("Payment Successfully");
        }else{
            System.out.println("Update Failed. No such PaymentID");
        }
    }
    
}
