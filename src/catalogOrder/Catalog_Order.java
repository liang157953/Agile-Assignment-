/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogOrder;

import ADT.*;
import fioreflowershop.CorporateCustomer;
import fioreflowershop.Customer;
import fioreflowershop.Order;
import fioreflowershop.OrderList;
import fioreflowershop.Payment;
import fioreflowershop.Product;
import fioreflowershop.ProductType;
import fioreflowershop.Staff;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Catalog_Order {
    public static void CatalogOrderM(ListInterface<ProductType> listProdType, ListInterface<Product> listProduct,ListInterface<Order> orderDataList, 
                                                      ListInterface<Customer> customerList,Staff incharge_staff, ListInterface<Payment> paymentList,
                                                      ListInterface<CorporateCustomer> corporateCustList, ListInterface<OrderList> orderlist) throws IOException{  
                                                        
        Scanner scan = new Scanner(System.in);
        
        int num = 1;
        String indexno;
        int indexnum;
        String option2 = "";
        Boolean checkid = false;
        double totalAmt = 0;
        Boolean allow = true;
        Boolean checkQty = true;
        String optionProdType = "";
        String selectedProdType = "";
        String optionProd = "";
        int selectionQty=0;
        char selectionContinue;
        Boolean addon = false;

        String storeCust = "";
        double balanceCreditLimit = 0;
        char orderAgain=' ';
        Order addOrder = new Order();
        OrderList addOrderList = new OrderList();
        
        int newOrderID = Integer.parseInt(orderDataList.get(orderDataList.size()-1).getOrderID().substring(1, 5))+1;
        String orderID = "O" + newOrderID; //got
        String orderDesc="";
        
        String orderDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String orderStatus = "Process"; //got
        Customer customer = new Customer();
        CorporateCustomer corporateCustomer = new CorporateCustomer(); //got
        //payment got at bottom line 297
        Payment payment = new Payment();
        //incharge_staff got
        String orderCustType=""; //got
        
        int newQty;
        int selectionDeliveryMode;
        
        System.out.println("Order ID: " + orderID);
        
        System.out.print("Order Description: ");
        orderDesc = scan.next();
        System.out.println();
        
        System.out.println("Order Customer Type List");
        System.out.println("1. Customer");
        System.out.println("2. Corporate Customer");
        
        System.out.print("Options > ");
        String optionsType = scan.next();

        System.out.println();
        if(optionsType.equals("1")){ //refer to option 2
            for(int i=0;i< customerList.size();i++){
                System.out.println(String.format("%d. %s  %s", num , customerList.get(i).getCustID(),customerList.get(i).getCustName()));
                num++;
            }
            do{
                orderCustType="Customer";
                checkid = false;
                System.out.print("Enter Customer ID > ");
                option2 = scan.next();
                for(int r=0;r< customerList.size();r++){
                    if(customerList.get(r).getCustID().equals(option2)){
                        checkid=true;
                        customer = customerList.get(r);
                        allow = true;
                    }
                }
            }while(!checkid);    
            addOrder = new Order(orderID, orderDesc, orderDate, orderStatus, customer, payment, incharge_staff, orderCustType);
        }
        else if(optionsType.equals("2")){
            for(int i=0;i< corporateCustList.size();i++){
                System.out.println(String.format("%d. %s  %s", num , corporateCustList.get(i).getCustID(),corporateCustList.get(i).getCustName()));
                num++;
            }
            do{
                orderCustType="Corporate";
                checkid = false;
                System.out.print("Enter Corporate Customer ID > ");
                option2 = scan.next();
                for(int r=0;r< corporateCustList.size();r++){
                    if(corporateCustList.get(r).getCustID().equals(option2)){
                        checkid=true;
                        corporateCustomer = corporateCustList.get(r);
                        if(corporateCustList.get(r).getStatus().equals("Unclear")){            
                            System.out.println("Please make the payment first.");
                            allow = false;
                            return;
                        }
                    }
                }
            }while(!checkid);    
            addOrder = new Order(orderID, orderDesc, orderDate, orderStatus, corporateCustomer, payment, incharge_staff, orderCustType);
        }
       do{
           totalAmt = 0;
           checkid=false;
        do{
            if(allow){
                ProductType selectedProductType = new ProductType();
                Product selectedProduct = new Product();

                System.out.println("\n===========================================================");
                System.out.println("\t\t\tProduct Type");
                System.out.println("===========================================================");
                System.out.println("Product Type ID\t\tProduct Type Name");
                for(int i=0; i<listProdType.size(); i++){
                    System.out.println(String.format("%-5s \t\t\t%-30s", listProdType.get(i).getProductTypeID(),listProdType.get(i).getProductTypeName()));
                }

                do{ //enter product type id
                    System.out.print("\nEnter Product Type ID : ");
                    optionProdType = scan.next();
                    for(int i=0; i<listProdType.size(); i++){
                        if(listProdType.get(i).getProductTypeID().equals(optionProdType)){
                            checkid=true;
                            System.out.println("\n======================================================");
                            System.out.println("\t\t\tProduct");
                            System.out.println("======================================================");
                            System.out.println("Product ID\tProduct Name");

                            for(int r=0; r<listProduct.size();r++){
                                if(listProduct.get(r).getProductType().getProductTypeID().equals(optionProdType)){
                                    System.out.println(String.format("%-5s \t\t%-30s", listProduct.get(r).getProductID(),listProduct.get(r).getProductName()));
                                }
                            }
                            boolean checkProdID=false;
                            do{ //enter product id
                                checkProdID=false;
                                System.out.print("\nEnter Product ID : ");
                                optionProd = scan.next();
                                
                                for(int j=0; j<listProduct.size(); j++){
                                    if(listProduct.get(j).getProductID().equals(optionProd)){
                                        checkProdID=true;  
                                        selectedProduct=listProduct.get(j);
                                        if(listProduct.get(j).getProductQuantity()== 0){
                                            System.out.println("\nSorry..This Product " + optionProd + " out of stock");
                                            checkQty=false;  
                                        }
                                        else{
                                            boolean repeat=false,valid=false;
                                            do{
                                                repeat=false;valid=false;
                                                System.out.println("\n\n===================Display Product Detail==========================");
                                                System.out.println("Product ID \tProduct Name \t\t\t\tProduct Price \tProduct Quantity");
                                                System.out.print(String.format("%-5s \t\t%-30s \t\t%5.2f\t\t%-2d ", listProduct.get(j).getProductID(),listProduct.get(j).getProductName(),listProduct.get(j).getProductPrice(),listProduct.get(j).getProductQuantity()));
                                                
                                                do{
                                                    System.out.print("\nPlease enter quantity : ");
                                                    selectionQty = scan.nextInt();

                                                    if(selectionQty > listProduct.get(j).getProductQuantity()){
                                                        System.out.println("\nPlease enter quantity less than " + listProduct.get(j).getProductQuantity());
                                                    }else if(selectionQty<=0){
                                                        System.out.println("\nPlease enter valid quantity!");
                                                    }else{
                                                        checkQty = true;
                                                    }
                                                }while(selectionQty > listProduct.get(j).getProductQuantity() || selectionQty<=0); 
                                            
                                                do{
                                                    System.out.print("Do you want to reenter quantity? For(Product ID: " + listProduct.get(j).getProductID() +") [Y/N]: ");
                                                    selectionContinue = scan.next().charAt(0);
                                                    if(CheckAlphabetic(selectionContinue)){ // Yes = continue; No = Exit
                                                        switch(selectionContinue)
                                                        {
                                                            case 'y' : case 'Y':
                                                                 repeat = true; valid=true;break;

                                                            case 'n' : case 'N' :
                                                                 repeat = false; valid=true; break;

                                                            default: System.out.println("Invalid Input!");
                                                        }
                                                    }
                                                }while(!valid);
                                            }while(repeat);
                                            
                                            totalAmt += listProduct.get(j).getProductPrice() * selectionQty; 
                                            balanceCreditLimit = corporateCustomer.getCreditLimit() - totalAmt;
                                            
                                            listProduct.get(j).setProductQuantity(listProduct.get(j).getProductQuantity()-selectionQty);
                                            
                                            //later the orderList need update the payment inside the addOrder
                                            addOrderList = new OrderList(addOrder, selectedProduct, selectionQty);
                                            
                                            //compare whther the current orderlist got the same order and same product inside or not
                                            boolean existOrderProduct = false;
                                            for(int r=0;r<orderlist.size();r++){
                                                if(orderlist.get(r).getOrder().getOrderID().equals(addOrderList.getOrder().getOrderID())){
                                                    if(orderlist.get(r).getProduct().getProductID().equals(addOrderList.getProduct().getProductID())){
                                                        //update becuase the order and product already existed in the orderList
                                                        orderlist.get(r).setQuantity(selectionQty);
                                                        existOrderProduct=true;
                                                    }
                                                }
                                            }
                                            //If not exist, add new order into orderlist
                                            if(!existOrderProduct){
                                                orderlist.add(addOrderList);
                                            }
                                            
                                        }//end                               
                                    }
                                } 
                                if(!checkProdID){
                                    System.out.println("Cannot Find Product ID. Re-enter Again... \n");
                                }  
                            }while(!checkProdID);
                        }
                    }
                    if(!checkid){
                        System.out.println("Cannot Find The Product Type ID. Re-enter Again... \n");
                    }
                }while(!checkid);
            }
            do{
                System.out.print("Do you want to add new product? (Y/N): ");
                selectionContinue = scan.next().charAt(0);
                if(CheckAlphabetic(selectionContinue)){ // Yes = continue; No = Exit
                    switch(selectionContinue)
                    {
                        case 'y' : case 'Y':
                             addon = true;break;

                        case 'n' : case 'N' :
                             addon = false; break;

                        default: System.out.println("Invalid Input!");
                    }
                }
            }while(Character.toUpperCase(selectionContinue) !='Y' && Character.toUpperCase(selectionContinue) !='N' );
            
        }while(addon);
        
        Boolean validCredit=true; //ok
        if(orderCustType.equals("Corporate")){
            if(totalAmt > corporateCustomer.getCreditLimit()){
                System.out.print(corporateCustomer.getCustID());
                System.out.println(corporateCustomer.getCustName());
                System.out.println("\n\nPlease Reduce the Order Amount. You have exceed your credit limit.");
                System.out.printf("Your Credit Limit: RM %.2f\n",corporateCustomer.getCreditLimit());
                System.out.printf("Your Order Amount: RM %.2f\n\n",totalAmt);
                validCredit=false;
            }
        }else{
            validCredit=true;
        }
        
     if(validCredit && allow){ //ok
//        System.out.println("======    Select Delivery Mode     ===========");
//        System.out.println("====== 1. Pick-up on date and time ===========");
//        System.out.println("====== 2. Delivery                 ===========");
//        System.out.print("Please make a selection : ");
        //selectionDeliveryMode = scan.nextInt();
        System.out.println("\n");
//        if(selectionDeliveryMode == 1){
//            System.out.printf("Enter date : ");
//            enterDate = scan.next();            
//            System.out.printf("Enter time : ");
//            enterTime = scan.next();
//        }
//        else if(selectionDeliveryMode == 2){
//            System.out.print("Enter address : ");
//            delivery = scan.next();
//        }
//        else{
//            System.out.print("Error");
//        }
            
            //Payment
            indexno = paymentList.get(paymentList.size()-1).getPaymentID();
            indexnum = Integer.parseInt(indexno.substring(2, 6)) +1;
            payment = new Payment("PA"+indexnum,null,totalAmt,"Unpaid");
            addOrder.setPayment(payment);

            orderDataList.add(addOrder);
            paymentList.add(payment);
            
            for(int r=0;r<orderlist.size();r++){
                if(orderlist.get(r).getOrder().getOrderID().equals(addOrder.getOrderID())){
                    orderlist.get(r).getOrder().setPayment(payment);
                }
            }
                
            System.out.println("Make Order Successfully!");
            
            if(orderCustType.equals("Corporate")){
                System.out.print("Corporate Customer ID/ Name : " + corporateCustomer.getCustID() + "\t\t");
                System.out.println(corporateCustomer.getCustName());
            }else{
                System.out.print("Customer ID/ Name : " + customer.getCustID() + "\t\t");
                System.out.println(customer.getCustName());
            }
            System.out.println("No.\tProduct Name \t\t\tQuantity \tUnit Price ");
            System.out.println("********************************************************************");
            
            int countNum=0;
            for(int i=0;i < orderlist.size() ;i++){
                if(orderlist.get(i).getOrder().getOrderID().equals(addOrder.getOrderID())){
                    System.out.println(String.format("%d \t%-30s %2d\t\t%.2f", ++countNum, orderlist.get(i).getProduct().getProductName(), orderlist.get(i).getQuantity(),orderlist.get(i).getProduct().getProductPrice()));
                }
            }
            System.out.println("********************************************************************");
            System.out.printf("Total Amount : RM %.2f\n",totalAmt);
            
            if(orderCustType.equals("Corporate")){
                System.out.printf("Total Credit Limit : RM %.2f\n", corporateCustomer.getCreditLimit());
                System.out.printf("Balance Credit Limit : RM %.2f\n", balanceCreditLimit);
            }
            orderAgain='N';
       } 
    }while(orderAgain=='Y');
    return; 
}   
    
    public static boolean CheckAlphabetic(char input) throws IOException{
        boolean checkAlphabetic = false;
     
            if(Character.isAlphabetic(input)){
                checkAlphabetic = true;
            }
            else{
                System.out.printf("Invalid Option! Please Try Again\n");
                System.out.print("Please Enter Any Key to Proceed...");
                System.in.read();
                System.out.println();
                checkAlphabetic = false;
            }
        
        return checkAlphabetic;
    }
} 
