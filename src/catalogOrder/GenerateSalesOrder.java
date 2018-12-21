/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogOrder;

import ADT.*;
import static catalogOrder.catalogOrder.CheckAlphabetic;
import fioreflowershop.*;
//import fioreflowershop.OrderList;
//import fioreflowershop.Product;
//import fioreflowershop.ProductType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class GenerateSalesOrder {
    public static void GenerateReportMain(ListInterface<ProductType> prodTypeList, ListInterface<Product> prodList, ListInterface<Order> orderDataList, ListInterface <OrderList> orderList) throws IOException{    
       Scanner scan = new Scanner(System.in); 
       int sumQty = 0;
       double totalAmount = 0;
       double totalPrice =0;
       char selectionReport;
       int selectionProdType = 0;
       Boolean test=false;
       int num=1;

       do{
       System.out.print("Do you want to generate report ? (Y/N) : ");
       selectionReport = scan.next().charAt(0);
      
            if(CheckAlphabetic(selectionReport)){
                switch(selectionReport)
                {
                    case 'y' :selectionReport ='Y';break;
                    case 'n' :selectionReport ='N';break;
                }
            }
        }while(selectionReport !='Y' && selectionReport !='N' );
       
        do{
            System.out.println("\n\n==========Product Type===========");
            for(int i=0; i<prodTypeList.size(); i++){
                System.out.println(String.format("%d. %s", i + 1, prodTypeList.get(i).getProductTypeName()));
            }    
            System.out.print("Please enter product type : ");
            selectionProdType = scan.nextInt();        
            if(selectionProdType<=0 || selectionProdType>prodTypeList.size()){
                System.out.println("Input Out of Range! Please Enter Again");
            }
        }while(selectionProdType<=0 || selectionProdType>prodTypeList.size());
        
        ProductType productType = new ProductType();       
        productType = prodTypeList.get(selectionProdType-1);
        System.out.println("\n\n========================================================================================================");
        System.out.println("\t\t\t\t\tGenerate Report " + productType.getProductTypeName());
        System.out.println("========================================================================================================");
        System.out.println("No. \t Product ID \t Product Name \t\t\t  Unit Price \t Quantity \t Total Amount \t");
        for(int i=0; i<orderList.size();i++){
            if(orderList.get(i).getProduct().getProductType().getProductTypeID().equals(productType.getProductTypeID())){
                totalAmount = orderList.get(i).getProduct().getProductPrice()*orderList.get(i).getQuantity();
                System.out.printf("%2d.%11s \t\t %-29s %10.2f %10d %20.2f \n", num,orderList.get(i).getProduct().getProductID(), orderList.get(i).getProduct().getProductName(), orderList.get(i).getProduct().getProductPrice(),orderList.get(i).getQuantity(), totalAmount );
                sumQty += orderList.get(i).getQuantity();
                num++;
            }
        }    
        System.out.println("\n========================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\tTotal Quantity : " + sumQty);
        System.out.println("========================================================================================================");
        System.out.println("\nSuccessful ...Generate report");
     
    }
    
    public static void CorporateCustGenerateReport(ListInterface<ProductType> prodTypeList, ListInterface<Product> prodList, ListInterface<Order> orderDataList, ListInterface <OrderList> orderList,ListInterface<CorporateCustomer> corporateCustList, ListInterface<Customer> custList ) throws IOException{    
        Scanner scn = new Scanner(System.in); 
        char selectionReportType;
        String enterCoporateCustID;
        double totalPrice = 0;
        double totalAmt =0;
        ListInterface<Order> newOrderDataList = new LinkedList<Order>();
        do{
            System.out.print("\nDo you want to generate report ? (Y/N) : ");
            selectionReportType = scn.next().charAt(0);
      
            if(CheckAlphabetic(selectionReportType)){
                switch(selectionReportType)
                {
                    case 'y' :selectionReportType ='Y';break;
                    case 'n' :selectionReportType ='N';break;
                }
            }
        }while(selectionReportType !='Y' && selectionReportType !='N' );
        System.out.println("\n==============================");
        System.out.println("Order Customer Type List");
        System.out.println("==============================");
        System.out.println("1. Customer");
        System.out.println("2. Corporate Customer");
        System.out.print("Options > ");
        String optionsType = scn.next();
        Boolean found=false;
        boolean condition = true;
        int num = 1;
        switch(optionsType){
            case "1":
                System.out.println("\n\n********** Customer List **********");                
                for(int i=0;i<orderDataList.size();i++){
                    condition =true;
                    if(orderDataList.get(i).getOrderType().equals("Customer")){
                        if(newOrderDataList.isEmpty()){
                            newOrderDataList.add(orderDataList.get(i));
                        }else{
                        for(int r=0;r<newOrderDataList.size();r++){
                            if(orderDataList.get(i).getCustomer().getCustID().equals(newOrderDataList.get(r).getCustomer().getCustID())){
                                condition = false;
                                break;
                            }
                        }                   
                        if(condition){
                            newOrderDataList.add(orderDataList.get(i));
                        }
                        }
                    }
                }
                for(int j=0; j<newOrderDataList.size();j++){                  
                    System.out.println(String.format("%d. %s  %s", num , newOrderDataList.get(j).getCustomer().getCustID(), newOrderDataList.get(j).getCustomer().getCustName()));
                    num++;
                    found=true;                   
                }
                
                Boolean checkid = false;
                String option2="";
                if(found){
                    do{
                        checkid = false;
                        System.out.print("Enter Customer ID > ");
                        option2 = scn.next();
                        
                        for(int i=0;i<orderDataList.size();i++){
                            if(orderDataList.get(i).getOrderType().equals("Customer")){
                                if(orderDataList.get(i).getCustomer().getCustID().equals(option2)){
                                    checkid=true;
                                }
                            }
                        } 
                    }while(!checkid);
                    
                    ListInterface<Product> orderProdList = new LinkedList<Product>();
                    for(int r=0;r<prodList.size();r++){
                        orderProdList.add(prodList.get(r));
                        orderProdList.get(r).setProductQuantity(0);
                    }
                    
                    for(int i=0; i< orderDataList.size(); i++){                   
                        if(orderDataList.get(i).getOrderType().equals("Customer")){ //Customer
                            if(orderDataList.get(i).getCustomer().getCustID().equals(option2)){
                                for(int r=0; r<orderList.size(); r++){
                                    if(orderDataList.get(i).equals(orderList.get(r).getOrder()))
                                        for(int e=0;e<orderProdList.size();e++){
                                            if(orderProdList.get(e).getProductID().equals(orderList.get(r).getProduct().getProductID())){
                                                orderProdList.get(e).setProductQuantity(orderProdList.get(e).getProductQuantity()+orderList.get(r).getQuantity());
                                            }
                                        }
                                }
                            }
                        }
                    }
                    
                    System.out.println("\n=====================================================================================================================");
                    System.out.println("\t\t\t\t\t\tOrder Report: " + option2 );
                    System.out.println("=====================================================================================================================");
                    System.out.println("Product Type\t\tProduct ID\tProduct Name\t\t\tTotal Quantity\tUnit Price\tTotal Price");
                    for(int r=0;r<orderProdList.size();r++){
                        totalPrice = orderProdList.get(r).getProductQuantity()*orderProdList.get(r).getProductPrice();
                        if(orderProdList.get(r).getProductQuantity()>0){
                            System.out.println(orderProdList.get(r).getProductType().getProductTypeName());    
                            System.out.print(String.format("%29s\t\t%-30s %3d \t\t %-5.2f \t\t %-5.2f\n",orderProdList.get(r).getProductID(),orderProdList.get(r).getProductName(),orderProdList.get(r).getProductQuantity(),orderProdList.get(r).getProductPrice(),totalPrice));
                            totalAmt += totalPrice;
                        }
                    }
                    System.out.println("=====================================================================================================================");
                    System.out.print(String.format("\nTotal Amount : RM %.2f\n",totalAmt));
                }
                else{   
                    System.out.println("Not found");     
                }
              
                break;
                
            case "2":
                System.out.println("\n\n********** Coporate Customer List **********");
                for(int i=0;i<orderDataList.size();i++){
                    condition =true;
                    if(orderDataList.get(i).getOrderType().equals("Corporate")){
                        if(newOrderDataList.isEmpty()){
                            newOrderDataList.add(orderDataList.get(i));
                        }else{
                        for(int r=0;r<newOrderDataList.size();r++){
                            if(orderDataList.get(i).getCorporateCustomer().getCustID().equals(newOrderDataList.get(r).getCorporateCustomer().getCustID())){
                                condition = false;
                                break;
                            }
                        }                   
                        if(condition){
                            newOrderDataList.add(orderDataList.get(i));
                        }
                        }
                    }
                }
                for(int j=0; j< newOrderDataList.size();j++){                  
                    System.out.println(String.format("%d. %s  %s", num , newOrderDataList.get(j).getCorporateCustomer().getCustID(), newOrderDataList.get(j).getCorporateCustomer().getCustName()));
                    num++;
                    found=true;                   
                }
                
                if(found){
                    do{
                        checkid = false;
                        System.out.print("Enter Corporate Customer ID > ");
                        option2 = scn.next();
                        for(int i=0;i<orderDataList.size();i++){
                                if(orderDataList.get(i).getOrderType().equals("Corporate")){
                                    if(orderDataList.get(i).getCorporateCustomer().getCustID().equals(option2)){
                                        checkid=true;
                                    }
                                }
                        } 
                    }while(!checkid);
                    ListInterface<Product> orderProdList = new LinkedList<Product>();
                    for(int r=0;r<prodList.size();r++){
                        orderProdList.add(prodList.get(r));
                        orderProdList.get(r).setProductQuantity(0);
                    }
                    
                    for(int i=0; i< orderDataList.size(); i++){                   
                        if(orderDataList.get(i).getOrderType().equals("Corporate")){ //Customer
                            if(orderDataList.get(i).getCorporateCustomer().getCustID().equals(option2)){
                                for(int r=0; r<orderList.size(); r++){
                                    if(orderDataList.get(i).equals(orderList.get(r).getOrder()))
                                        for(int e=0;e<orderProdList.size();e++){
                                            if(orderProdList.get(e).getProductID().equals(orderList.get(r).getProduct().getProductID())){
                                                orderProdList.get(e).setProductQuantity(orderProdList.get(e).getProductQuantity()+orderList.get(r).getQuantity());
                                            }
                                        }
                                }
                            }
                        }
                    }
                    
                    System.out.println("\n=====================================================================================================================");
                    System.out.println("\t\t\t\t\t\tOrder Report: " + option2 );
                    System.out.println("=====================================================================================================================");
                    System.out.println("Product Type\t\tProduct ID\tProduct Name\t\t\tTotal Quantity\tUnit Price\tTotal Price");
                    for(int r=0;r<orderProdList.size();r++){
                        totalPrice = orderProdList.get(r).getProductQuantity()*orderProdList.get(r).getProductPrice();
                        if(orderProdList.get(r).getProductQuantity()>0){
                            System.out.println(orderProdList.get(r).getProductType().getProductTypeName());    
                            System.out.print(String.format("%29s\t\t%-30s %3d \t\t %-5.2f \t\t %-5.2f\n",orderProdList.get(r).getProductID(),orderProdList.get(r).getProductName(),orderProdList.get(r).getProductQuantity(),orderProdList.get(r).getProductPrice(),totalPrice));
                            //System.out.println("\t\t\t" + orderProdList.get(r).getProductID() +"\t\t"+ orderProdList.get(r).getProductName() + "\t\t\t"+ orderProdList.get(r).getProductQuantity());                 
                            totalAmt += totalPrice;
                        }
                    }
                    System.out.println("=====================================================================================================================");
                    System.out.print(String.format("\nTotal Amount : RM %.2f\n",totalAmt));
                }else{   
                    System.out.println("Not found");     
                }
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        //return orderList;    
    }

    public static boolean CheckAlphabetic(char input) throws IOException{
        boolean checkAlphabetic = false;
     
            if(Character.isAlphabetic(input)){
                checkAlphabetic = true;
            }
            else{
                System.out.println("Invalid Option! Please Try Again\n");
                System.out.println("Please Enter Any Key to Proceed...");
                System.in.read();
                System.out.println();
                checkAlphabetic = false;
            }       
        return checkAlphabetic;
    }

}
