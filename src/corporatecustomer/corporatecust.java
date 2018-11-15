/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corporatecustomer;

import fioreflowershop.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class corporatecust {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        CorporateCustomer corporatecust = new CorporateCustomer(1000.00,0.0,"Unclear","C1001","Koh Liao Liao","pv16,jalan setapak","011-39958399");
        List<Order> order = new ArrayList<Order>();
        Staff staff = new Staff("S1001","Lim Yong Qi","019-7272566");
        List<Payment> paymentList = new ArrayList<Payment>();
        paymentList.add(new Payment("P1001","10-11-2018",100.00,"UnPaid"));
        paymentList.add(new Payment("P1002","11-11-2018",200.00,"UnPaid"));
        paymentList.add(new Payment("P1003","15-11-2018",100.00,"UnPaid"));
        order.add(new Order("O1001","Give to my girlfriend ","11-11-2018","Process",corporatecust,paymentList.get(0),staff));
        order.add(new Order("O1002","No Description","15-11-2018","Process",corporatecust,paymentList.get(1),staff));
        order.add(new Order("O1003","Please say happy birthday to the receiver","15-11-2018","Process",corporatecust,paymentList.get(2),staff));
        double totaldebt =0.0;
        for(int i =0; i <order.size();i++){
            if(order.get(i).getCorporateCustomer().equals(corporatecust)){
                if(order.get(i).getPayment().getPaymentStatus().equals("UnPaid")){
                System.out.println(i+1 +". " + order.get(i).getPayment().getPaymentID() + "\t "+order.get(i).getPayment().getPaymentDate() + "\t " + order.get(i).getPayment().getTotalAmount() + "0" + "\t " + order.get(i).getPayment().getPaymentStatus());
                totaldebt += order.get(i).getPayment().getTotalAmount();
            }
           }
        }
            System.out.println("********************************************");
            System.out.println("Total Debt Amount :RM " + totaldebt + "0");
            corporatecust.setCreditAmount(totaldebt);
            char selection;
            do{
            System.out.print("Do You want to build a snowman? (y/n) : ");
            selection = (scan.next().charAt(0));
            switch(selection){
                case 'Y':
                    selection = 'y';
                    break;
                case 'N':
                    selection = 'n';
                    break;
            }
            if(selection != 'y' &&selection !='n'){
                System.out.println("Please Enter y/n only");
            }    
            }while(selection != 'y' &&selection !='n');
            
        if(selection == 'y'){
            System.out.println("Paid Successful");
         for(int i =0; i <order.size();i++){
            if(order.get(i).getCorporateCustomer().equals(corporatecust)){
                if(order.get(i).getPayment().getPaymentStatus().equals("UnPaid")){
                    order.get(i).getPayment().setPaymentStatus("Paid");
                System.out.println(i+1+". " + order.get(i).getPayment().getPaymentID() + "\t "+order.get(i).getPayment().getPaymentDate() + "\t " + order.get(i).getPayment().getTotalAmount() + "0 \t " + order.get(i).getPayment().getPaymentStatus());
                totaldebt += order.get(i).getPayment().getTotalAmount();
            }
           }
         } 
        }
        else if(selection == 'n'){
            System.out.println("\nOn The Way Back To Menu...");
        }
    }
}

