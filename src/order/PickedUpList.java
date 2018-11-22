/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import fioreflowershop.Customer;
import fioreflowershop.Order;
import fioreflowershop.Payment;
import fioreflowershop.PickUp;
import fioreflowershop.Staff;
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
//    public static char choice = 'n';
    
    public static void main(String args[]) throws IOException{
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer("C1001","Koh Liao Liao","pv16,jalan setapak","011-39958399"));
        customerList.add(new Customer("C1002","Lew Hao Hap","pv16,jalan setapak","012-7878778"));
        customerList.add(new Customer("C1003","Ong Jin Jin","pv16,jalan setapak","013-7799889"));
        
        List<Staff> staffList = new ArrayList<Staff>();
        staffList.add(new Staff("S1001","Lim Yong Qi","019-7272566"));
        staffList.add(new Staff("S1002","Jimmy Chew","012-3435617"));
        staffList.add(new Staff("S1003","Cindy Lee","019-434580"));
        
        List<Payment> paymentList = new ArrayList<Payment>();
        paymentList.add(new Payment("P1001","",100.00,"UnPaid"));
        paymentList.add(new Payment("P1002","",200.00,"Unpaid"));
        paymentList.add(new Payment("P1003","",100.00,"UnPaid"));
        
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(new Order("O1001","Give to my girlfriend ","11-11-2018","Process",customerList.get(0),paymentList.get(0),staffList.get(0)));
        orderList.add(new Order("O1002","","15/11/2018","Process",customerList.get(1),paymentList.get(1),staffList.get(1)));
        orderList.add(new Order("O1003","Please say happy birthday to the receiver","15-11-2018","Process",customerList.get(2),paymentList.get(2),staffList.get(2)));
        
        List<PickUp> pickupList = new ArrayList<PickUp>();
        pickupList.add(new PickUp("U1001","20/11/2018","1400","20-11-2018","1410","Standby",staffList.get(0),orderList.get(0)));
        pickupList.add(new PickUp("U1002","20/11/2018","1200","20-11-2018","1230","Standby",staffList.get(0),orderList.get(2)));
        pickupList.add(new PickUp("U1003","21/11/2018","1500","21-11-2018","1610","Standby",staffList.get(0),orderList.get(0)));
        
       
//        do
//        {
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
            System.out.println("*************************************");
            System.out.println("    Picked Up Order On " + indate);
            System.out.println("*************************************");

            boolean check = false;

            for(int i=0; i<pickupList.size();i++)
            {
                if(indate.matches(pickupList.get(i).getRequirePickUpDate()))
                {
                    System.out.println("Pickup No: " + pickupList.get(i).getPickupNo() 
                            + "\nRequired Pickup Date: " + pickupList.get(i).getRequirePickUpDate() 
                            + "\nRequired Pickup Time: " + pickupList.get(i).getRequirePickUpTime() 
                            + "\nOrder No: " +pickupList.get(i).getOrder().getOrderID()
                            + "\n");
                    check = true;
                }

            }

            if(check == false)
            {
                System.out.println("Sorry, Today do not have any order need to pick up."); 
            }
            
//            System.out.println("Do you want to search again? (yes/no)"); 
//            String c = in.nextLine();
//            choice = c.charAt(0);
            
//        }while(choice == 'y');
        
        
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
