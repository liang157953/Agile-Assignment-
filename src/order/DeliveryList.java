/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import fioreflowershop.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import static order.PickedUpList.ShowPickedUpList;
/**
 *
 * @author acer
 */
public class DeliveryList {
    private static Scanner in = new Scanner(System.in);
    public static char choice = 'n';
    public static char reenter = 'n';

    public static void ShowDeliveryList(List<Delivery> deliveryList, List<OrderList> orderList) throws IOException{
      
        String option;

        Boolean displayed=false;

        
        do
        {
            String indate = Date();
            System.out.println("\n");
            do{
                System.out.println("********************\n Delivery State \n********************");
                System.out.println("1. Setapak ");
                System.out.println("2. Kuala Lumpur"); 
                System.out.println("3. Selangor");      
            
                System.out.printf("\nPlease enter your option in full text: ");
                
                option = in.next();
                    //Validation of User Input(Only can be digit)                
              

                System.out.println("\n");
                System.out.println("***************************************");
                System.out.println("    Delivery List On Date: "+ indate);
                System.out.println("***************************************");

                boolean check = false;

                for(int i=0; i<deliveryList.size();i++)
                {
                    if(indate.matches(deliveryList.get(i).getRequireDeliveryDate()))
                    {

                        if(option.equals(deliveryList.get(i).getState()) )
                        {
                            System.out.println("\n");
                            System.out.println("***************************************");
                            System.out.println("     " + deliveryList.get(i).getState());
                            System.out.println("***************************************");

                        System.out.println("Tracking No: " + deliveryList.get(i).getTrackingNo()
                            + "\nRequired Delivery Date: " + deliveryList.get(i).getRequireDeliveryDate() 
                            + "\nRequired Delivery Time: " + deliveryList.get(i).getRequireDeliveryTime() 
                            + "\nDelivery Address: " +deliveryList.get(i).getDeliveryAddress()
                            + "\nDelivery Contact Number: " +deliveryList.get(i).getDeliveryContactNo()
                            + "\nDelivery Status: " +deliveryList.get(i).getDeliveryStatus()
                            + "\nIncharge Staff Name: " +deliveryList.get(i).getStaff().getStaffName()
                            + "\n-----------------------------------------------------------------"
                            + "\n|       Order No: " +deliveryList.get(i).getOrder().getOrderID() +"\t\t\t\t\t\t|"
                            + "\n|       Order Description: " +deliveryList.get(i).getOrder().getOrderDesc()+"\t\t|") ;

                        for(int r=0;r<orderList.size();r++){
                            if(orderList.get(r).getOrder().getOrderID().equals(deliveryList.get(i).getOrder().getOrderID())){

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
                }
                if(check == false)
                {
                    System.out.println("\nSorry, Today do not have any order need to deliver to this state.\n"); 
                }

                System.out.print("Do you want to search other state? (yes/no): " ); 
                System.out.print("Do you want to search other state? (yes/no): "); 
                reenter = in.next().charAt(0);
            
            }while(reenter == 'y'|| reenter == 'Y');


            System.out.print("Do you want to search another day? (yes/no): " ); 
            System.out.print("Do you want to search another day? (yes/no): "); 
            choice = in.next().charAt(0);
        }while(choice == 'y'|| choice == 'Y');
        
        
        
        System.out.println("\n\nPress any key to exit...");
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
