/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import ADT.*;
import catalogOrder.Catalog_Order;
import fioreflowershop.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.Scanner;
import static order.DeliveryList.Date;
import order.PickedUpList.ConsoleColors;
import static order.PickedUpList.ShowPickedUpList;
/**
 *
 * @author acer
 */
public class DeliveryList {
    private static Scanner in = new Scanner(System.in);
    public static char choice = 'n';
    public static char reenter = 'n';

    public static void Menu(ListInterface<Delivery> deliveryList, ListInterface<OrderList> orderList)throws IOException {
        
        String option;
        Delivery d = new Delivery();
        
        do{      
            do{
                System.out.println("********************\n Delivery Menu \n********************"); 
                System.out.println("1. Search specific date delivery list");
                System.out.println("2. Order delivered ");
                System.out.println("3. Update processing delivery status");
                System.out.println("4. Return Main Menu");             
                System.out.printf("\nOption > ");
                
                option = in.next();
                    //Validation of User Input(Only can be digit)                
              }while(!PickedUpList.checkDigit(option));

            switch(Integer.parseInt(option)){
                case 1:
                    ShowDeliveryList(deliveryList,orderList);
                    System.out.print("Enter Any Key Return to PickUp Menu...");
                    System.in.read();
                    in.nextLine();
                    break;
                case 2: 
                    ShowDelivered(deliveryList);
                    System.out.print("Enter Any Key Return to PickUp Menu...");
                    System.in.read();
                    in.nextLine();
                    break;
                case 3: 
                    UpdateDeliveryStatus(deliveryList);
                    System.out.print("Enter Any Key Return to PickUp Menu...");
                    System.in.read();
                    in.nextLine();
                    break;
                case 4:
                    break; 
                default:
                    System.out.println(ConsoleColors.RED + "Invalid Option! Please Try Again" + ConsoleColors.RESET);
                    System.out.print("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        }while(Integer.parseInt(option)!=4);
       
    }
    
    public static void ShowDeliveryList(ListInterface<Delivery> deliveryList, ListInterface<OrderList> orderList) throws IOException{      
        String option;
        do
        {
            String indate = Date();
            System.out.println("\n");
            do{
                do{
                    System.out.println("********************\n Delivery State \n********************");
                    System.out.println("1. Setapak ");
                    System.out.println("2. Kuala Lumpur"); 
                    System.out.println("3. Selangor");      
                    do{
                        System.out.printf("\nPlease enter your option : ");
                        option = in.next();
                    }while(!checkDigit(option) || Integer.parseInt(option)<1 || Integer.parseInt(option)>3);
                    switch (Integer.parseInt(option)){
                        case 1:
                            option = "Setapak";
                            break;
                        case 2:
                            option = "Kuala Lumpur";
                            break;
                        case 3:
                            option = "Selangor";
                            break;        
                    }
                }while(Integer.parseInt(option)!=3);
                                     
                System.out.println("\n");
                System.out.println("***************************************");
                System.out.println("    Delivery List On Date: "+ indate);
                System.out.println("***************************************");

                boolean check = false;
                QueueInterface<Delivery> deliveryqueue = new LinkedQueue<>();
                deliveryqueue = Catalog_Order.GenerateDeliveryQueue(deliveryList, indate);
                if(!deliveryqueue.isEmpty()){
                    do{
                        Delivery delivery = deliveryqueue.dequeue();
                        if(indate.matches(delivery.getRequireDeliveryDate()))
                    {

                        if(option.equals(delivery.getState()) )
                        {
                            System.out.println("\n");
                            System.out.println("***************************************");
                            System.out.println("     " + delivery.getState());
                            System.out.println("***************************************");

                        System.out.println("Tracking No: " + delivery.getTrackingNo()
                            + "\nRequired Delivery Date: " + delivery.getRequireDeliveryDate() 
                            + "\nRequired Delivery Time: " + delivery.getRequireDeliveryTime() 
                            + "\nDelivery Address: " +delivery.getDeliveryAddress()
                            + "\nDelivery Contact Number: " +delivery.getDeliveryContactNo()
                            + "\nDelivery Status: " +delivery.getDeliveryStatus()
                            + "\nIncharge Staff Name: " +delivery.getStaff().getStaffName()
                            + "\n-----------------------------------------------------------------"
                            + "\n|       Order No: " +delivery.getOrder().getOrderID() +"\t\t\t\t\t\t|"
                            + "\n|       Order Description: " +delivery.getOrder().getOrderDesc()+"\t\t|") ;

                        for(int r=0;r<orderList.size();r++){
                            if(orderList.get(r).getOrder().getOrderID().equals(delivery.getOrder().getOrderID())){

                                System.out.printf("|       Product Name: %10s  \t\t|",orderList.get(r).getProduct().getProductName());
                                System.out.printf("\n|       Product Quantity: %2d \t\t\t\t\t|",orderList.get(r).getQuantity());
                                System.out.printf("\n-----------------------------------------------------------------");
                                System.out.printf("\n\n");
                                break;
                            }
                        }
                        check = true;
                        }
                    }
                      //System.out.println(deliveryqueue.dequeue().getDelivery().toString());
                    }while(!deliveryqueue.isEmpty());
                    check = true;
                }     
                if(check == false)
                {
                    System.out.println("\nSorry, Today do not have any order need to deliver to this state.\n"); 
                }

                System.out.print("Do you want to search other state? (yes/no): " ); 
                reenter = in.next().charAt(0);
            
            }while(reenter == 'y'|| reenter == 'Y');


            System.out.print("Do you want to search another day? (yes/no): " ); 
            choice = in.next().charAt(0);
        }while(choice == 'y'|| choice == 'Y');
        
        
        
        System.out.println("\n\nPress any key to exit...");
        System.in.read();

    }
    
    /**
     *
     * @param deliveryList
     * @return
     */
    public static ListInterface<Delivery> ShowDelivered(ListInterface<Delivery> deliveryList){
        
        boolean display = false;
        System.out.println("\n Ready for Delivering List ");
        System.out.println("======================");
        
        for(int i=0; i<deliveryList.size();i++)
        {
            if(deliveryList.get(i).getDeliveryStatus().equals("Delivering"))
            {
                System.out.println(deliveryList.get(i).getTrackingNo());
            }
        }
        do{
            System.out.print(" \nPlease enter the Tracking Number: ");
            String no = in.next();
            
            System.out.println("\n*********************************************");
            System.out.println("                Order Details ");
            System.out.println("*********************************************");
            
            
            for(int i=0; i<deliveryList.size();i++)
            {
                if(no.matches(deliveryList.get(i).getTrackingNo()))
                {
                    display = true;
                    if(deliveryList.get(i).getArrivalDate().isEmpty())
                    {
                         System.out.println("Order ID: " + deliveryList.get(i).getOrder().getOrderID()
                                                       + "\nOder Description: " + deliveryList.get(i).getOrder().getOrderDesc()
                                                       + "\nCustomer Name: " +deliveryList.get(i).getOrder().getCustomer().getCustName()
                                                       + "\nRequired Delivery Date " +deliveryList.get(i).getRequireDeliveryDate()
                                                       + "\nRequired Delivery Time " +deliveryList.get(i).getRequireDeliveryTime());

                         String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                         String time = new SimpleDateFormat("HHmm").format(new Date());

                         System.out.print("\nDoes this order delivered NOW? (yes/no): ");
                         char c = in.next().charAt(0); 

                         if(c == 'y'|| c == 'Y')
                         {
                            System.out.println("\n-------------------------------------------------------");
                            System.out.println("    Current time for order delivered");
                            System.out.println("-------------------------------------------------------");
                            System.out.println("Delivered date: " + date);
                            System.out.println("Delivered time: " + time);     
                            deliveryList.get(i).setArrivalDate(date);
                            deliveryList.get(i).setArrivalTime(time);
                            deliveryList.get(i).setDeliveryStatus("Delivered");
                            deliveryList.get(i).getOrder().getPayment().setPaymentStatus("Paid");
                            
                            System.out.println("\n>>>>    This order have been updated !  <<<<");                    
                         }
                    }
                    else{
                        System.out.println("\nSorry, This order have been delivered !");                        
                    }     
                } 

            }
            if(display == false){
                System.out.println("\nSorry, This Tracking number is invalid.");
                break;
            }
            
            System.out.print("\nDo you want to search another Tracking Number? (yes/no): "); 
            choice = in.next().charAt(0);
            
        }while(choice == 'y'|| choice == 'Y');  
        return deliveryList;
    }

    public static void UpdateDeliveryStatus(ListInterface<Delivery> deliveryList) throws IOException{
        
        boolean display = false;
        System.out.println("Processing Delivery List ");
        for(int i=0; i<deliveryList.size();i++)
        {
            if(deliveryList.get(i).getDeliveryStatus().equals("Processing"))
            {
                System.out.println(deliveryList.get(i).getTrackingNo());
            }
        }
        
        do{
            display = false;
            System.out.print(" \nPlease enter the Tracking Number: ");
            String no = in.next();
            
            System.out.println("\n*********************************************");
            System.out.println("                Order Details ");
            System.out.println("*********************************************");
 
            for(int i=0; i<deliveryList.size();i++)
            {
                if(no.matches(deliveryList.get(i).getTrackingNo()))
                {
                    display = true;
                    if(deliveryList.get(i).getDeliveryStatus().equals("Processing"))
                    {
                         System.out.println("Order ID: " + deliveryList.get(i).getOrder().getOrderID()
                                                       + "\nOder Description: " + deliveryList.get(i).getOrder().getOrderDesc()
                                                       + "\nCustomer Name: " +deliveryList.get(i).getOrder().getCustomer().getCustName()
                                                       + "\nRequired Delivery Date " +deliveryList.get(i).getRequireDeliveryDate()
                                                       + "\nRequired Delivery Time " +deliveryList.get(i).getRequireDeliveryTime());


                         System.out.print("\nDoes this order is ready to delivery ? (yes/no): ");
                         char c = in.next().charAt(0); 

                         if(c == 'y'|| c == 'Y')
                         {   
                            deliveryList.get(i).setDeliveryStatus("Delivering");
                            System.out.println("Tracking No\tRequired Delivery Date\tRequired Delivery Time\t Staff Incharge \t Status");
                            System.out.println("=======================================================================================================");
                            System.out.println(deliveryList.get(i).getTrackingNo() + "\t\t" + deliveryList.get(i).getRequireDeliveryDate() + "\t\t" + deliveryList.get(i).getRequireDeliveryTime() + "\t\t\t " + deliveryList.get(i).getStaff().getStaffName()+ "\t\t" +deliveryList.get(i).getDeliveryStatus() );
                            System.out.println("\n>>>>    This order is delivering !  <<<<");                    
                         }
                    }
                    else if(deliveryList.get(i).getArrivalDate() != null){
                        System.out.println("\nSorry, This order have been delivered !");  
                    }
                    else {
                         System.out.println("\nSorry, This order already delivering !"); 
                    }
                       
                }

                
            }
            if(display == false){
                    System.out.println("\nSorry, This Tracking number is invalid.");
                    break;
                }
            
            System.out.print("\nDo you want to update another Tracking Number? (yes/no): "); 
            choice = in.next().charAt(0);
            
        }while(choice == 'y'|| choice == 'Y');  
    }
    
    //Check validation of date
    public static boolean ValidDate(int day,int month,int year){
		boolean valid = false;
		if(year > 2000 && year <=2100){
			switch(month){
			case 1:case 3:case 5:case 7:case 8: case 10: case 12:
					 if(day > 0 && day <=31){
						valid = true;
						break;
					 }
			case 2: if(year%4==0){
						if(day > 0 && day <=29)
							valid = true;
					}
					else {
						if(day > 0 && day <=28)
							valid = true;
					}
					break;
			case 4:case 6:case 9:case 11:
					if(day > 0 && day <=30){
						valid = true;
						break;
					}
			}
		}
		return valid;
    }
    
    public static boolean checkDigit(String input){
            boolean checkDigit = false;
            for(int r=0;r<input.length();r++){
                if(Character.isDigit(input.charAt(r))){
                checkDigit = true;
                }
                else{
                    checkDigit = false;
                    break;
                }
            }
            return checkDigit;
	}

	public static String Date(){
	    
		boolean validDate = false;
		int day = 0;
		int month = 0;
		int year = 0;
		String d="";
		String m="";
		String y="";
		do{
			boolean checkD = false;
			boolean checkM = false;
			boolean checkY = false;
			do{
				System.out.print("Enter Date(DD MM YYYY): ");
				d = in.next();
				m = in.next();
				y = in.next();

				//Validation of day(Only can be digit)
				checkD = checkDigit(d);

				if(checkD == true){
					//Validation of month(Only can be digit)
					checkM = checkDigit(m);
				}

			    if(checkM == true){
			    	//Validation of year(Only can be digit)
					checkY = checkDigit(y);
				}

				if(!checkY){
					System.out.println("\nInvalid Date! Please enter again\n");
				}
			}while(!checkY);

			day = Integer.parseInt(d);
			month = Integer.parseInt(m);
			year = Integer.parseInt(y);
			validDate = ValidDate(day,month,year);

			if(!validDate){
				System.out.println("\nInvalid Date! Please enter again");
			}
		}while(!validDate);		
                String date;
 if(day<10){
           if(month<10)
           date = "0"+ Integer.toString(day)+"/"+"0"+Integer.toString(month)+"/"+Integer.toString(year);
           else
           date = "0"+ Integer.toString(day)+"/"+Integer.toString(month)+"/"+Integer.toString(year);
       }
       else{
           if(month<10)
           date = Integer.toString(day)+"/"+"0"+Integer.toString(month)+"/"+Integer.toString(year);
           else
           date = Integer.toString(day)+"/"+Integer.toString(month)+"/"+Integer.toString(year);     
                   
       }

		return date;
}
}
