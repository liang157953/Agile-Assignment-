/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import ADT.*;
import fioreflowershop.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import static order.PickedUpList.Date;
import static order.PickedUpList.choice;

/**
 *
 * @author acer
 */
public class PickedUpTimeStamp {
    
    private static Scanner in = new Scanner(System.in);
    public static char choice = 'n';
    
    public static ListInterface<PickUp> TimeStamp(ListInterface<PickUp> pul) throws IOException{
        
        boolean display = false;
        System.out.println("\nStandby PickUp List ");
        System.out.println("======================");
        for(int i=0; i<pul.size();i++)
        {
            if(pul.get(i).getPickupStatus().equals("Standby"))
            {
                System.out.println(pul.get(i).getPickupNo());
            }
        }
        do{
            System.out.print(" \nPlease enter the PickUp Number: ");
            String no = in.next();
            
            System.out.println("\n*********************************************");
            System.out.println("                Order Details ");
            System.out.println("*********************************************");
            
            
            for(int i=0; i<pul.size();i++)
            {
                if(no.matches(pul.get(i).getPickupNo()))
                {
                    display = true;
                    if(pul.get(i).getPickupDate().isEmpty())
                    {
                         System.out.println("Order ID: " + pul.get(i).getOrder().getOrderID()
                                                       + "\nOder Description: " + pul.get(i).getOrder().getOrderDesc()
                                                       + "\nCustomer Name: " +pul.get(i).getOrder().getCustomer().getCustName()
                                                       + "\nRequired PickUp Date " +pul.get(i).getRequirePickUpDate()
                                                       + "\nRequired PickUp Time " +pul.get(i).getRequirePickUpTime());

                         String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                         String time = new SimpleDateFormat("HHmm").format(new Date());

                         System.out.print("\nDoes this order pick up NOW? (yes/no): ");
                         char c = in.next().charAt(0); 

                         if(c == 'y'|| c == 'Y')
                         {
                            System.out.println("\n-------------------------------------------------------");
                            System.out.println("    Current time for customer pick up order");
                            System.out.println("-------------------------------------------------------");
                            System.out.println("Customer pick up date: " + date);
                            System.out.println("Customer pick up time: " + time);     
                            pul.get(i).setPickupDate(date);
                            pul.get(i).setPickupTime(time);
                            
                            System.out.println("\n>>>>    This order have been updated !  <<<<");                    
                         }
                    }
                    else{
                        System.out.println("\nSorry, This order have been picked up !");
                        
                    }
                       
                }
                

            }
            if(display == false){
                System.out.println("\nSorry, This PickUp number is invalid.");
                break;
            }
            
            System.out.print("\nDo you want to search another PickUp Number? (yes/no): "); 
            choice = in.next().charAt(0);
            
        }while(choice == 'y'|| choice == 'Y');  
        return pul;
    }
    
}
