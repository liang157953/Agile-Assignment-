/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corporatecustomer;

import fioreflowershop.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class corporatecust {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        CorporateCustomer selectedcust = new CorporateCustomer();
        List<CorporateCustomer> corporateList = new ArrayList<CorporateCustomer>();
       corporateList.add(new CorporateCustomer(1000.00,400.00,"Unclear","C1001","Koh Liao Liao","pv16,jalan setapak","011-39958399"));
       corporateList.add(new CorporateCustomer(1000.00,400.00,"Unclear","C1002","Koh Liao Liao","pv16,jalan setapak","011-39958399"));
        List<Order> order = new ArrayList<Order>();
        Staff staff = new Staff("S1001","Lim Yong Qi","019-7272566");
        List<Payment> paymentList = new ArrayList<Payment>();
        paymentList.add(new Payment("P1001","10-11-2018",100.00,"UnPaid"));
        paymentList.add(new Payment("P1002","11-11-2018",200.00,"UnPaid"));
        paymentList.add(new Payment("P1003","15-11-2018",100.00,"UnPaid"));
        order.add(new Order("O1001","Give to my girlfriend ",null,"Process",corporateList.get(0),paymentList.get(0),staff));
        order.add(new Order("O1002","No Description",null,"Process",corporateList.get(0),paymentList.get(1),staff));
        order.add(new Order("O1003","Please say happy birthday to the receiver",null,"Process",corporateList.get(0),paymentList.get(2),staff));
        double totaldebt =0.0;
        Scanner string = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        String custID = string.nextLine();
            for(int i=0;i <corporateList.size();i++){
                if(corporateList.get(i).getCustID().equals(custID))
                {
                    selectedcust = corporateList.get(i);
                }
            }
            System.out.println("No.PaymentID \t Amount Status");
            System.out.println("********************************");
        for(int i =0; i <order.size();i++){
            if(order.get(i).getCorporateCustomer().equals(selectedcust)){
                if(order.get(i).getPayment().getPaymentStatus().equals("UnPaid")){
                System.out.println(i+1 +". " + order.get(i).getPayment().getPaymentID() + "\t " + order.get(i).getPayment().getTotalAmount() + "0" + "\t " + order.get(i).getPayment().getPaymentStatus());
                totaldebt += order.get(i).getPayment().getTotalAmount();
            }
           }
        }
            System.out.println("********************************************");
            System.out.println("Total Debt Amount :RM " + totaldebt + "0");
            selectedcust.setCreditAmount(totaldebt);
            char selection;
            do{
            System.out.print("Do You want to make a payment? (y/n) : ");
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
            String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
            System.out.println("Paid Successful");
            System.out.println("No.PaymentID \t Paid Date \t Amount \t Status");
            System.out.println("***********************************************************************");
         for(int i =0; i <order.size();i++){
            if(order.get(i).getCorporateCustomer().equals(selectedcust)){
                if(order.get(i).getPayment().getPaymentStatus().equals("UnPaid")){
                    order.get(i).getPayment().setPaymentStatus("Paid");
                     order.get(i).getPayment().setPaymentDate(date);
                System.out.println(i+1+". " + order.get(i).getPayment().getPaymentID() + "\t "+order.get(i).getPayment().getPaymentDate() + "\t " + order.get(i).getPayment().getTotalAmount() + "0 \t " + order.get(i).getPayment().getPaymentStatus());
                totaldebt += order.get(i).getPayment().getTotalAmount();
                
            }
           }
         } System.out.println("\nOn The Way Back To Menu...");
        }
        else if(selection == 'n'){
            System.out.println("\nOn The Way Back To Menu...");
        }
    }
}

