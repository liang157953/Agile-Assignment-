 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import fioreflowershop.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author acer
 */
public class CustomerPayment {
    
    private static Scanner scan = new Scanner(System.in);
    public static char choice = 'n';
    
    
    public static List<Payment> MakePayment(List<Payment> paylist) throws IOException{
        
        System.out.println("***************************************");
        System.out.println("     UnPaid Payment List" );
        System.out.println("***************************************");
        
        System.out.println("No.PaymentID \t Paid Date \t Amount \tStatus");
        System.out.println("**************************************************************");
        for(int i=0; i<paylist.size();i++)
        {
            if(paylist.get(i).getPaymentStatus().equals("UnPaid")){
                
                System.out.println( i +"   " 
                                   +paylist.get(i).getPaymentID() + "\t " 
                                   +paylist.get(i).getPaymentDate()+ "\t " 
                                   +paylist.get(i).getTotalAmount()+ "\t        "
                                   +paylist.get(i).getPaymentStatus());
            }
        }
        char selection;
        String ID ="";
        do{
            System.out.print("\nDo You want to make a payment? (y/n) : ");
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

    if(selection == 'y'){;
        System.out.print("Please enter the Payment ID you want to pay : ");
        ID = scan.next();
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        System.out.println("\n\t*Paid Successful*");
        System.out.println("***************************************");
        System.out.println("     Updated Payment List" );
        System.out.println("***************************************");
        System.out.println("No.PaymentID \t Paid Date \t Amount \t Status");
        System.out.println("*******************************************************************");

     for(int i =0; i <paylist.size();i++){
        if(paylist.get(i).getPaymentID().equals(ID)){
                if(paylist.get(i).getPaymentStatus().equals("UnPaid")){
                    paylist.get(i).setPaymentStatus("Paid");
                    paylist.get(i).setPaymentDate(date);
                    System.out.println(i+". " + paylist.get(i).getPaymentID() + "\t "+paylist.get(i).getPaymentDate() + "\t " + paylist.get(i).getTotalAmount() + "0 \t " + paylist.get(i).getPaymentStatus());
                }
            }
        }
     }
    return paylist;
    }
             
}
