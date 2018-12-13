/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corporatecustomer;

import fioreflowershop.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class CorporateCustomerMaintenance {
    public static void Menu(List<CorporateCustomer> corporateList,Staff staff,List<Order> order, List<Payment> paymentList,List<Customer> customerList) throws ParseException{
        char resume = 'n';
        do{
            int menuint = 0;
            int err = 0;
            do{
               if(err == 1)
               {
                       System.out.println("Please enter between 1 to 3");
               }
                
            Scanner menu = new Scanner(System.in);
            System.out.println("\n\n");
            System.out.println("Menu");
            System.out.println("******************************************");
            System.out.println("1. Check Debt and Make Payment");
            System.out.println("2. Approve Corporate Customer Application");
            System.out.println("3. Corporate Customer That haven't make payment");
            System.out.println("4. Exit");
            System.out.println("******************************************");
            System.out.print("Enter Your Choice: ");
            menuint = menu.nextInt();
            err++;
            }while(menuint<0 || menuint > 3);
            
            
            if(menuint == 1){
            Scanner scan = new Scanner(System.in);
            CorporateCustomer selectedcust = new CorporateCustomer();
           
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
                System.out.println("\nNo.PaymentID \t Amount Status");
                System.out.println("******************************");
            for(int i =0; i <order.size();i++){
                if(order.get(i).getCorporateCustomer() != null){
                if(order.get(i).getCorporateCustomer().equals(selectedcust)){
                    if(order.get(i).getPayment().getPaymentStatus().equals("UnPaid")){
                    System.out.println(i+1 +". " + order.get(i).getPayment().getPaymentID() + "\t " + order.get(i).getPayment().getTotalAmount() + "0" + "\t " + order.get(i).getPayment().getPaymentStatus());
                    totaldebt += order.get(i).getPayment().getTotalAmount();
                    }
                }
               }
            }
            
            if(totaldebt == 0.00){
                System.out.print("**No Debt For This Customer**");
               
             do{
                Scanner newscan = new Scanner(System.in);
                System.out.print("\nBack To Menu? (y/n): ");
                resume = (newscan.next().charAt(0));
                switch(resume){
                    case 'Y':
                        resume = 'y';
                        break;
                    case 'N':
                        resume = 'n';
                        break;
                }
                if(resume != 'y' &&resume !='n'){
                    System.out.println("Please Enter y/n only");
                }    
                }while(resume != 'y' &&resume !='n');   
             
             if(resume == 'n'){
                System.out.println("Thank You!");
                break;
            }
              continue;
            }
                System.out.println("******************************************");
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
                String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                System.out.println("**Paid Successful**");
                System.out.println("No.PaymentID \t Paid Date \t Amount \t Status");
                System.out.println("*********************************************************************");
             for(int i =0; i <order.size();i++){
                  if(order.get(i).getCorporateCustomer() != null){
                if(order.get(i).getCorporateCustomer().equals(selectedcust)){
                    if(order.get(i).getPayment().getPaymentStatus().equals("UnPaid")){
                        order.get(i).getPayment().setPaymentStatus("Paid");
                         order.get(i).getPayment().setPaymentDate(date);
                    System.out.println(i+1+". " + order.get(i).getPayment().getPaymentID() + "\t "+order.get(i).getPayment().getPaymentDate() + "\t " + order.get(i).getPayment().getTotalAmount() + "0 \t " + order.get(i).getPayment().getPaymentStatus());
                    totaldebt += order.get(i).getPayment().getTotalAmount();
                    }
                }
               }
             }  
             } //System.out.println("\nOn The Way Back To Menu...");

        }else if(menuint == 2){
                Scanner selectcustomer = new Scanner(System.in);
                Scanner limit = new Scanner(System.in);
                int customerindex;
                double limitAmount;
                System.out.println("\nList of Customer Want to become Corporate Customer");
                System.out.println("***************************************************");
                for(int i=0; i< customerList.size();i++){
                    System.out.println(i+1 + ". " + customerList.get(i).getCustID() + "\t"+ customerList.get(i).getCustName());
                }
                System.out.println("****************************************************");
                do{
                System.out.print("Which customer application you want to approve ?\nEnter Your Choice: " );
                customerindex = selectcustomer.nextInt();
                if(customerindex > customerList.size()){
                    System.out.println("Invalid Input, Please Try Again!");
                }
                }while(customerindex<0||customerindex > customerList.size());
                int newCorID;
                newCorID = Integer.parseInt(corporateList.get(corporateList.size()-1).getCustID().substring(2,6));
                newCorID += 1;
                
                System.out.print("Please Enter Monthly Limit:" );
                limitAmount = limit.nextDouble();              
                corporateList.add(new CorporateCustomer(limitAmount,0.00,"Available","CO" + newCorID,customerList.get(customerindex-1).getCustName(),customerList.get(customerindex-1).getCustAddress(),customerList.get(customerindex-1).getCustContactNo()));
                customerList.remove(customerindex-1);
                System.out.println("\n\n Updated Corporate Customer List");
                System.out.println("**************************************");
                for(int i =0; i< corporateList.size();i++){
                    System.out.println(i+1 + ". "+corporateList.get(i).getCustID() + "\t" + corporateList.get(i).getCustName() + "\t" + corporateList.get(i).getCreditLimit());
                }      
            }
            if(menuint == 3){
            do{
                String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                Date date1 =new SimpleDateFormat("dd/MM/yyyy").parse(date);  
                String newdate = "07" + date.substring(2,10);
                Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse(newdate);     
                int numberrecord =0;
               System.out.println("no.\t custID \t orderID \t orderDate \t Total Amount \t Telno.");
               System.out.println("****************************************************************************************");
                if(date1.after(date2)){
                    int j =1;
                    for(int i =0;i < order.size();i++){
                        if(order.get(i).getCorporateCustomer() != null){
                        if(new SimpleDateFormat("dd/MM/yyyy").parse(order.get(i).getOrderDate()).after(date2) &&order.get(i).getPayment().getPaymentStatus().equals("UnPaid")){
                            System.out.format("%d \t %-8s \t  %-13s %-12s \t RM %-6.2f \t %-12s\n",j,order.get(i).getCorporateCustomer().getCustID(),order.get(i).getOrderID(),order.get(i).getOrderDate(),order.get(i).getPayment().getTotalAmount(),order.get(i).getCorporateCustomer().getCustContactNo());
                            j++;
                            numberrecord++;
                        }
                        }
                    }
                }else{ 
                    int j =1;
                    for(int i =0;i < order.size();i++){
                         if(order.get(i).getCorporateCustomer() != null){
                        if(new SimpleDateFormat("dd/MM/yyyy").parse(order.get(i).getOrderDate()).before(date2) &&order.get(i).getPayment().getPaymentStatus().equals("UnPaid")){
                            System.out.format("%d \t %-8s \t  %-13s %-12s \t RM %-6.2f %-12s\n",j,order.get(i).getCorporateCustomer().getCustID(),order.get(i).getOrderID(),order.get(i).getOrderDate(),order.get(i).getPayment().getTotalAmount(),order.get(i).getCorporateCustomer().getCustContactNo());
                            j++;
                            numberrecord++;
                        }
                    }
                    }
                }
                if(numberrecord == 0){
                    System.out.print("Record Not Found!\n\n");
                }
                
                Scanner newscan = new Scanner(System.in);
                System.out.print("Back To Menu? (y/n): ");
                resume = (newscan.next().charAt(0));
                switch(resume){
                    case 'Y':
                        resume = 'y';
                        break;
                    case 'N':
                        resume = 'n';
                        break;
                }
                if(resume != 'y' &&resume !='n'){
                    System.out.println("Please Enter y/n only");
                }    
                }while(resume != 'y' &&resume !='n');
            if(resume == 'n'){
                System.out.println("Thank You!");
                break;
            }
            }
            else{
                System.out.println("Thank You!");
                 break;
            }
        }while(resume == 'y');
        
    }
}