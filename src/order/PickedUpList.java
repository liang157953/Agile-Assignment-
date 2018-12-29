/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import ADT.*;
import fioreflowershop.*;
import order.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author acer
 */
public class PickedUpList {
    
    private static Scanner in = new Scanner(System.in);
    public static char choice = 'n';

    public static void Menu(ListInterface<PickUp> pickUpList, ListInterface<Order> orderDataList, ListInterface<OrderList> orderList, ListInterface<Staff>staffList,Order order,Customized customized)throws IOException {
        
        String option;
        PickUp pk = new PickUp();
        
        do{      
            do{
                System.out.println("********************\n PickUp Menu \n********************"); 
                System.out.println("1. Search specific date pickup list");
                System.out.println("2. Customer pickup order ");
                System.out.println("3. Update preparing pickup status");
                System.out.println("4. Return Main Menu");             
                System.out.printf("\nOption > ");
                
                option = in.next();
                    //Validation of User Input(Only can be digit)                
              }while(!PickedUpList.checkDigit(option));

            switch(Integer.parseInt(option)){
                case 1:
                    ShowPickedUpList(pickUpList,orderList);
                    System.out.print("Enter Any Key Return to PickUp Menu...");
                    System.in.read();
                    in.nextLine();
                    break;
                case 2: 
                    PickedUpTimeStamp.TimeStamp(pickUpList);
                    System.out.print("Enter Any Key Return to PickUp Menu...");
                    System.in.read();
                    in.nextLine();
                    break;
                case 3: 
                    UpdatePickUpStatus(pickUpList);
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
    
//    public static PickUp RegisterNewPickUp(String newPkID, Order order, ListInterface<Staff> staffList, Customized customized) throws IOException {
//        Scanner input = new Scanner(System.in);
//        
//        String rdate="",rtime="";
//        PickUp pickup = new PickUp();
//        
//        rdate = Date();
//        
//        System.out.print("Please enter the required PickUp Time (Eg. 1500): ");
//        rtime = in.next();            
//        
//        boolean test=false;
//        String options;
//        do{
//            do{
//                System.out.println("Please select a staff to handle this Pick Up");
//                for(int i=0;i<staffList.size();i++){
//                    System.out.println((i+1) + "." + staffList.get(i).getStaffName());
//                } 
//
//                System.out.printf("\nSelect Staff : ");
//                options = input.next();
//            }while(!checkDigit(options));
//            if(Integer.parseInt(options)<=0 || Integer.parseInt(options)>staffList.size()){
//                System.out.println(ConsoleColors.RED + "Input Out of Range! Please Enter Again" + ConsoleColors.RESET);
//                System.in.read();
//                test=false;
//            }else{
//                  test=true;
//            }
//        }while(!test);
//        
//        if(order !=null){ // order contains data
//            pickup = new PickUp(newPkID,rdate,rtime,"","","Preparing",staffList.get(Integer.parseInt(options)-1),order);
//        }else{
//            pickup = new PickUp(newPkID,rdate,rtime,"","","Preparing",staffList.get(Integer.parseInt(options)-1),customized);
//        }
//        System.out.println("PickUp No \t Required PickUp Date \t Required PickUp Time \t Staff Incharge");
//        System.out.println("====================================================================================================");
//        System.out.println(newPkID + "\t\t " + rdate + "\t\t " + rtime + "\t\t\t " + staffList.get(Integer.parseInt(options)-1).getStaffName());
//        return pickup;
//    }
//    
    public static void UpdatePickUpStatus(ListInterface<PickUp> pickUpList) throws IOException{
        
        boolean display = false;
        System.out.println("Current Preparing PickUp List ");
        for(int i=0; i<pickUpList.size();i++)
        {
            if(pickUpList.get(i).getPickupStatus().equals("Preparing"))
            {
                System.out.println(pickUpList.get(i).getPickupNo());
            }
        }
        
        do{
            display = false;
            System.out.print(" \nPlease enter the PickUp Number: ");
            String no = in.next();
            
            System.out.println("\n*********************************************");
            System.out.println("                Order Details ");
            System.out.println("*********************************************");
 
            for(int i=0; i<pickUpList.size();i++)
            {
                if(no.matches(pickUpList.get(i).getPickupNo()))
                {
                    display = true;
                    if(pickUpList.get(i).getPickupStatus().equals("Preparing"))
                    {
                         System.out.println("Order ID: " + pickUpList.get(i).getOrder().getOrderID()
                                                       + "\nOder Description: " + pickUpList.get(i).getOrder().getOrderDesc()
                                                       + "\nCustomer Name: " +pickUpList.get(i).getOrder().getCustomer().getCustName()
                                                       + "\nRequired PickUp Date " +pickUpList.get(i).getRequirePickUpDate()
                                                       + "\nRequired PickUp Time " +pickUpList.get(i).getRequirePickUpTime());


                         System.out.print("\nDoes this order is ready to pick up ? (yes/no): ");
                         char c = in.next().charAt(0); 

                         if(c == 'y'|| c == 'Y')
                         {   
                            pickUpList.get(i).setPickupStatus("Standby");
                            System.out.println("PickUp No \t Required PickUp Date \t Required PickUp Time \t Staff Incharge \t Status");
                            System.out.println("====================================================================================================");
                            System.out.println(pickUpList.get(i).getPickupNo() + "\t\t " + pickUpList.get(i).getRequirePickUpDate() + "\t\t " + pickUpList.get(i).getRequirePickUpTime() + "\t\t\t " + pickUpList.get(i).getStaff().getStaffName()+ "\t\t " +pickUpList.get(i).getPickupStatus() );
                            System.out.println("\n>>>>    This order is standby for PickUp !  <<<<");                    
                         }
                    }
                    else if(pickUpList.get(i).getPickupDate() != null){
                        System.out.println("\nSorry, This order have been picked up !");  
                    }
                    else {
                         System.out.println("\nSorry, This order already standby !"); 
                    }
                       
                }

                
            }
            if(display == false){
                    System.out.println("\nSorry, This PickUp number is invalid.");
                    break;
                }
            
            System.out.print("\nDo you want to update another PickUp Number? (yes/no): "); 
            choice = in.next().charAt(0);
            
        }while(choice == 'y'|| choice == 'Y');  
    }
    
    public static void ShowPickedUpList(ListInterface<PickUp> pickUpList, ListInterface<OrderList> orderList) throws IOException{
        
        do
        {
            String indate = Date();
//            System.out.print("Please enter date : ");
//            date = in.nextLine();
//            
//            if(!date.isEmpty())
//            {
//                break;
//            }
//            System.out.println("You do not have any input! Please enter again !");
            System.out.println("\n");
            System.out.println("***************************************");
            System.out.println("    Picked Up Order On Date: " + indate);
            System.out.println("***************************************");

            boolean check = false;

            for(int i=0; i<pickUpList.size();i++)
            {
                if(indate.matches(pickUpList.get(i).getRequirePickUpDate()))
                {
                    System.out.println("Pickup No: " + pickUpList.get(i).getPickupNo() 
                            + "\nRequired Pickup Date: " + pickUpList.get(i).getRequirePickUpDate() 
                            + "\nRequired Pickup Time: " + pickUpList.get(i).getRequirePickUpTime() 
                            + "\nOrder No: " +pickUpList.get(i).getOrder().getOrderID()
                            + "\nOrder Description: " +pickUpList.get(i).getOrder().getOrderDesc());
                    
                    for(int r=0;r<orderList.size();r++){
                        if(orderList.get(r).getOrder().getOrderID().equals(pickUpList.get(i).getOrder().getOrderID())){
                             
                            System.out.printf("Product Name: %10s",orderList.get(r).getProduct().getProductName());
                            System.out.printf("\nProduct Quantity: %2d",orderList.get(r).getQuantity());
                            System.out.printf("\n\n");
                            break;
                        }
                    }
                    check = true;
                }

            }
            
            

            if(check == false)
            {
                System.out.println("\nSorry, Today do not have any order need to pick up.\n"); 
            }
            
            System.out.print("Do you want to search again? (yes/no): "); 
            choice = in.next().charAt(0);
            
        }while(choice == 'y'|| choice == 'Y');    
    }

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
				System.out.print("Please enter Date(DD MM YYYY): ");
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

		String date = day + "/" + month + "/" + year;
		return date;
}
    
    public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
}
    
}
