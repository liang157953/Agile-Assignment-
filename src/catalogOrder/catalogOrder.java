/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogOrder;

import fioreflowershop.Customer;
import fioreflowershop.Order;
import fioreflowershop.OrderList;
import fioreflowershop.Payment;
import fioreflowershop.Product;
import fioreflowershop.ProductType;
import fioreflowershop.Staff;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import fioreflowershop.FioreFlowershop.*;
public class catalogOrder {
public static List<Order> CatalogOrderMenu(List<ProductType> listProdType, List<Product> listProduct,List<Order> orderDataList, List<Customer> customerList,List<Staff> staffList, List<Payment> paymentList) throws IOException{    
  
        List<OrderList> orderlist = new ArrayList<OrderList>();
        //orderList.add(new Order("O1001","Give to my girlfriend ","11-11-2018","Process",customerList.get(0),paymentList.get(0),staffList.get(0)));
        boolean addon = false;
        int selection;
        int selectionProd;
        int selectionQty;
        int selectionDeliveryMode;
        String enterDate="";
        String enterTime="";
        String delivery="";
        int newQty = 0;
        double totalAmt = 0;
        char selectionContinue;
        Scanner scan = new Scanner(System.in);
        //Scanner scanString = new Scanner(System.in);
        Product selectedProduct= new Product();
        String indexno = orderDataList.get(orderDataList.size()-1).getOrderID();
        int indexnum = Integer.parseInt(indexno.substring(1, 5)) +1;
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        orderDataList.add(new Order("O"+indexnum,"Description",date,"Received",customerList.get(0),null,staffList.get(0)));
        do{
        Scanner sc = new Scanner(System.in);
        Scanner scc = new Scanner(System.in);
        System.out.println("==========Product Type===========");
        
        for(int i=0; i<listProdType.size();i++)
        {
            System.out.println(String.format("%d. %s", i + 1, listProdType.get(i).getProductTypeName()));
            
        }
        do{
            System.out.print("Please enter product type : ");
            selection = sc.nextInt(); 
            
            if(selection <1 || selection >listProdType.size())
            {
             System.out.println("\n\nInvalid input. Please enter correct input  !  \n\n");
            }
        
        }while(selection  <1 || selection  >listProdType.size());
        
        ProductType selectedProductType = new ProductType();
        
        selectedProductType = listProdType.get(selection-1);
        System.out.println("\n========Product=========");
        
        int qty =0;

        for(int r=0;r<listProduct.size();r++){
            if(listProduct.get(r).getProductType().equals(selectedProductType)){
                System.out.println(String.format("%d. %s", r+1, listProduct.get(r).getProductName()));

            }
        }
     
        do{
        System.out.print("Please enter product : ");
        selectionProd = sc.nextInt();
        
        if(selectionProd <1 || selectionProd >listProduct.size() )
        {
            System.out.println("\n\nInvalid input. Please enter correct input! \n\n");
        }
        }while(selectionProd <1 || selectionProd >listProduct.size());
  
        selectedProduct = listProduct.get(selectionProd-1); //listProduct.add(selectionProd-1, selectedProduct);
        if(selectedProduct.getProductQuantity()==0){
            System.out.println("\n\nSorry...Out of Stock\n");
        }
        else{
            System.out.println("\n\n=============Display Product Detail====================");
            System.out.println("Product ID \t\t\tProduct Name \t\tProduct Price\t\tProduct Quantity");
            for(int r=0;r<listProduct.size();r++){
                if(listProduct.get(r).equals(selectedProduct)){
                System.out.println(listProduct.get(r).toString());
                }
            }
     
                do{
                System.out.print("Please enter quantity : ");
                selectionQty = sc.nextInt();
                if(selectionQty > selectedProduct.getProductQuantity() ){
                    System.out.println("Please enter again quantity");
                }
   
                }while(selectionQty > selectedProduct.getProductQuantity());
                
                newQty = selectedProduct.getProductQuantity() - selectionQty;
                   // totalAmt = selectedProduct.getProductPrice() * selectionQty;             
                    selectedProduct.setProductQuantity(newQty);                    
                    totalAmt += selectedProduct.getProductPrice() * selectionQty;
                    orderlist.add(new OrderList(orderDataList.get(orderDataList.size()-1),selectedProduct,selectionQty));

                    //orderlist.add(new OrderList(orderDataList.get(orderDataList.size()-1),selectedProduct,selectionQty));
                do{
                            System.out.print("Do you want to add the new item (Y/N): ");
                            selectionContinue = scc.next().charAt(0);
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
                        }else if(selectionContinue=='Y'){
                            addon = true;
                        }
            
        }
    }while(selectedProduct.getProductQuantity() == 0 || addon);  
    indexno = paymentList.get(paymentList.size()-1).getPaymentID();
    indexnum = Integer.parseInt(indexno.substring(2, 6)) +1;
    Payment payment = new Payment("PA"+indexnum,null,totalAmt,"Unpaid");
    orderDataList.get(orderDataList.size()-1).setPayment(payment);
    System.out.println("======Select Delivery Mode===========");
    System.out.println("======1. Pick-up on date and time===========");
    System.out.println("======2. Delivery===========");
    System.out.print("Please make a selection : ");
    selectionDeliveryMode = scan.nextInt();
    if(selectionDeliveryMode == 1){
        System.out.print("Enter date : ");
        enterDate = scan.next();
        System.out.print("Enter time : ");
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
     
     //System.out.println("\n\nView details? ");
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
     System.out.println("\n\nno. Product Name  Quantity");
     System.out.println("*******************************");
     
     for(int i=0;i < orderlist.size() ;i++){
         if(orderlist.get(i).getOrder().getOrderID().equals(orderDataList.get(orderDataList.size()-1).getOrderID())){
             orderlist.get(i).setOrder(orderDataList.get(orderDataList.size()-1));
             System.out.println(String.format("%d. %s \t %d", i+1, orderlist.get(i).getProduct().getProductName(), orderlist.get(i).getQuantity()));
         }
     }
     System.out.println("********************************");
     System.out.println("Total Amount :" + orderDataList.get(orderDataList.size()-1).getPayment().getTotalAmount());
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

   