/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import fioreflowershop.*;
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

    public static void ShowPickedUpList(List<PickUp> pickUpList, List<OrderList> orderList) throws IOException{
        
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
        
        
        
        System.out.println("\n\nPress any key to end...");
        System.in.read();
        
        
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

		String date = day + "/" + month + "/" + year;
		return date;
}
   
    
    
}
