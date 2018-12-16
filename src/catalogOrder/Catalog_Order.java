/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogOrder;

import fioreflowershop.CorporateCustomer;
import fioreflowershop.Customer;
import fioreflowershop.Order;
import fioreflowershop.OrderList;
import fioreflowershop.Payment;
import fioreflowershop.Product;
import fioreflowershop.ProductType;
import fioreflowershop.Staff;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Catalog_Order {
    public static List<Order> CatalogOrderM(List<ProductType> listProdType, List<Product> listProduct,List<Order> orderDataList, List<Customer> customerList,List<Staff> staffList, List<Payment> paymentList, List<CorporateCustomer> corporateCustList) throws IOException{    
        Scanner scan = new Scanner(System.in);
        List<OrderList> orderlist = new ArrayList<OrderList>();
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
        int selectionQty;
        char selectionContinue;
        Boolean addon = false;
        int newQty;
        int selectionDeliveryMode;
        System.out.println("Order Customer Type List");
        System.out.println("1. Customer");
        System.out.println("2. Corporate Customer");
        System.out.print("Options > ");
        String optionsType = scan.next();
        String enterDate;
        String enterTime;
        String delivery;
        String storeCust = "";
        double balanceCreditLimit = 0;
        CorporateCustomer cc = new CorporateCustomer();
        char orderAgain;
        List<Product> orderProductList = new ArrayList<Product>();

        if(optionsType.equals("1")){
            indexno = customerList.get(customerList.size()-1).getCustID();
            indexnum = Integer.parseInt(indexno.substring(1, 5)) + 1;
            System.out.println("Customer ID : " + "C" + indexnum);
        }
        else if(optionsType.equals("2")){
            for(int i=0;i< corporateCustList.size();i++){
                System.out.println(String.format("%d. %s  %s", num , corporateCustList.get(i).getCustID(),corporateCustList.get(i).getCustName()));
                num++;
            }
            do{
                checkid = false;
                System.out.print("Enter Corporate Customer ID > ");
                option2 = scan.next();
                for(int r=0;r< corporateCustList.size();r++){
                    if(corporateCustList.get(r).getCustID().equals(option2)){

                        checkid=true;
                        cc = corporateCustList.get(r);
                        if(corporateCustList.get(r).getStatus().equals("Unclear")){            
                            System.out.println("Please make the payment first.");
                            allow = false;
                        }
                    }
                }
            }while(!checkid);      
        }
       do{
           totalAmt = 0;
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

            do{
                System.out.print("Enter Product Type ID : ");
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
                        do{
                            System.out.print("Enter Product ID : ");
                            optionProd = scan.next();
                            for(int j=0; j<listProduct.size(); j++){
                                if(listProduct.get(j).getProductID().equals(optionProd)){
                                    checkid=true;   
                                    if(listProduct.get(j).getProductQuantity()== 0){
                                        System.out.println("Sorry..This Product " + optionProd + " out of stock");
                                        System.out.println(listProduct.get(j).getProductQuantity());
                                        checkQty=false;  
                                    }
                                    else{
                                        System.out.println("\n\n=============Display Product Detail====================");
                                        System.out.println("Product ID \tProduct Name \t\tProduct Price \tProduct Quantity");
                                        System.out.print(String.format("%-5s \t%-30s \t%5.2f\t%-2d ", listProduct.get(j).getProductID(),listProduct.get(j).getProductName(),listProduct.get(j).getProductPrice(),listProduct.get(j).getProductQuantity()));

                                        do{
                                        System.out.print("\nPlease enter quantity : ");
                                        selectionQty = scan.nextInt();
                                        if(selectionQty > listProduct.get(j).getProductQuantity()){
                                            System.out.println("Enter quantity is less than " + listProduct.get(j).getProductQuantity());
                                        }
                                        }while(selectionQty > listProduct.get(j).getProductQuantity());
                                        
                                        Boolean foundOrderProductList=false;
                                        if(orderProductList.size()==0){
                                            orderProductList.add(listProduct.get(j));
                                            orderProductList.get(0).setProductQuantity(selectionQty);
                                            foundOrderProductList=true;
                                        }else{
                                            for(int h=0;h<orderProductList.size();h++){//1
                                                if(listProduct.get(j).getProductID().equals(orderProductList.get(h).getProductID())){
                                                    orderProductList.get(h).setProductQuantity(orderProductList.get(h).getProductQuantity()+selectionQty);//self qty += new qty
                                                    foundOrderProductList=true;
                                                    break;
                                                }
                                            }
                                        }
                                        
                                        if(!foundOrderProductList){
                                            orderProductList.add(listProduct.get(j));             
                                            orderProductList.get(orderProductList.size()-1).setProductQuantity(selectionQty);
                                        }
                                        totalAmt += listProduct.get(j).getProductPrice() * selectionQty;
                                        balanceCreditLimit = cc.getCreditLimit() - totalAmt;
                                        do{
                                            System.out.print("Do you want to add the new item (Y/N): ");
                                            selectionContinue = scan.next().charAt(0);
                                            if(CheckAlphabetic(selectionContinue)){
                                                switch(selectionContinue)
                                                {
                                                    case 'y' :selectionContinue ='Y';break;
                                                    case 'n' :selectionContinue ='N';break;
                                                }
                                            }
                                        }while(selectionContinue !='Y' && selectionContinue !='N' );

                                        if(selectionContinue == 'N'){
                                            addon = false;   
                                        }
                                        else if(selectionContinue=='Y'){
                                            addon = true;
                                        } 
                                        checkQty = true;
                                    }                               
                                }
                            } 
                            if(!checkid){
                                System.out.println("Cannot Find This ID. Re-enter Again... \n");
                            }
                        }while(!checkid);
                    }
                }
                if(!checkid){
                    System.out.println("Cannot Find This ID. Re-enter Again... \n");
                }
               
            }while(!checkid );
        }
        }while(!checkQty || addon);
        for(int i=0;i < orderlist.size() ;i++){
             double totalPrice = orderlist.get(i).getProduct().getProductQuantity()*orderlist.get(i).getProduct().getProductPrice();
             if(orderlist.get(i).getOrder().getOrderID().equals(orderDataList.get(orderDataList.size()-1).getOrderID())){
                orderlist.get(i).setOrder(orderDataList.get(orderDataList.size()-1));
                totalAmt += totalPrice;
             }
         }
        
        Boolean validCredit=true;
        if(totalAmt > cc.getCreditLimit()){
            System.out.print(cc.getCustID());
            System.out.println(cc.getCustName());
            System.out.println("\n\nPlease Reduce the Order Amount. You have exceed your credit limit.");
            System.out.printf("Your Credit Limit: RM %.2f\n",cc.getCreditLimit());
            System.out.printf("Your Order Amount: RM %.2f\n\n",totalAmt);
            orderProductList.clear(); 
            validCredit=false;
        }
        
     if(validCredit && allow){
         System.out.println(orderProductList.size());
        for(int j=0; j<listProduct.size(); j++){
            for(int h=0;h<orderProductList.size();h++){
                if(listProduct.get(j).getProductID().equals(orderProductList.get(h).getProductID())){  
                    //listProduct.get(j).setProductQuantity(orderProductList.get(h).getProductQuantity());
                    orderlist.add(new OrderList(orderDataList.get(orderDataList.size()-1),orderProductList.get(h),orderProductList.get(h).getProductQuantity()));
                }            
            }
        }
         
        indexno = paymentList.get(paymentList.size()-1).getPaymentID();
        indexnum = Integer.parseInt(indexno.substring(2, 6)) +1;
        Payment payment = new Payment("PA"+indexnum,null,totalAmt,"Unpaid");
        orderDataList.get(orderDataList.size()-1).setPayment(payment);
        System.out.println("======    Select Delivery Mode     ===========");
        System.out.println("====== 1. Pick-up on date and time ===========");
        System.out.println("====== 2. Delivery                 ===========");
        System.out.print("Please make a selection : ");
        selectionDeliveryMode = scan.nextInt();
        if(selectionDeliveryMode == 1){
            System.out.printf("Enter date : ");
            enterDate = scan.next();
            
            System.out.printf("Enter time : ");
            enterTime = scan.next();
        }
        else if(selectionDeliveryMode == 2){
            System.out.print("Enter address : ");
            delivery = scan.next();
        }
        else{
            System.out.print("Error");
        }

            System.out.println("Successful make an order.");

            do{
                System.out.print("\n\nView Details (Y/N): ");
                selectionContinue = scan.next().charAt(0);
                if(CheckAlphabetic(selectionContinue)){
                    switch(selectionContinue)
                    {
                        case 'y' :selectionContinue ='Y';break;
                        case 'n' :selectionContinue ='N';break;
                    }
                }
            }while(selectionContinue !='Y' && selectionContinue !='N' );

            //System.out.println(orderlist.size());

            System.out.print("Corporate Customer ID/ Name : " + cc.getCustID() + "\t\t");
            System.out.println(cc.getCustName());
            System.out.println("No.\tProduct Name \t\t\tQuantity \tUnit Price ");
            System.out.println("********************************************************************");
            
            for(int i=0;i < orderlist.size() ;i++){
                double totalPrice = orderlist.get(i).getProduct().getProductQuantity()*orderlist.get(i).getProduct().getProductPrice();
                if(orderlist.get(i).getOrder().getOrderID().equals(orderDataList.get(orderDataList.size()-1).getOrderID())){
                    orderlist.get(i).setOrder(orderDataList.get(orderDataList.size()-1));
                    System.out.println(String.format("%d \t%-30s %2d\t\t%.2f", i+1, orderlist.get(i).getProduct().getProductName(), orderlist.get(i).getQuantity(),orderlist.get(i).getProduct().getProductPrice()));
                }
            }
            System.out.println("********************************************************************");
            System.out.printf("Total Amount : RM %.2f\n",totalAmt);
            System.out.printf("Total Credit Limit : RM %.2f\n", cc.getCreditLimit());
            System.out.printf("Balance Credit Limit : RM %.2f\n", balanceCreditLimit);
            orderAgain='N';
            //System.out.println("Total Amount :" + orderDataList.get(orderDataList.size()-1).getPayment().getTotalAmount());
       }else{
         do{
            System.out.print("\nOrder Again? (Y/N): ");
           orderAgain = Character.toUpperCase(scan.next().charAt(0));
         }while(orderAgain !='Y' && orderAgain !='N' );
       }    
    }while(orderAgain=='Y');
    return orderDataList; 
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
