/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corporatecustomer;

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

public class NewClass {

    /**
     * @param args the command line arguments
     */
  

    public static void main(String[] args) throws IOException {
        List<ProductType> listProdType = new ArrayList<>();
        
        listProdType.add(new ProductType("PT101","Fresh Flower","Red"));
        listProdType.add(new ProductType("PT102","Flower Bouquet","Yellow"));
        listProdType.add(new ProductType("PT103","Flower Arrangement","Blue"));
        
        List<Product> listProduct = new ArrayList<Product>();
        List<OrderList> orderlist = new ArrayList<OrderList>();
        listProduct.add(new Product("P1001","Rose", 20.00, 50, listProdType.get(0)));
        listProduct.add(new Product("P1002","SunFlower",10.00, 30, listProdType.get(2)));
        listProduct.add(new Product("P1003","Wax Flower",5.00, 40, listProdType.get(1)));
        listProduct.add(new Product("P1004","Lily", 12.00, 0, listProdType.get(0)));
        listProduct.add(new Product("P1005","Aster",12.00, 30, listProdType.get(1)));
        listProduct.add(new Product("P1006","Carnation",25.00, 40, listProdType.get(1)));
        listProduct.add(new Product("P1007","Dahlia",6.00, 10, listProdType.get(0)));
        
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer("C1001","Koh Liao Liao","pv16,jalan setapak","011-39958399"));
        customerList.add(new Customer("C1002","Lew Hao Hap","pv16,jalan setapak","012-7878778"));
        customerList.add(new Customer("C1003","Ong Jin Jin","pv16,jalan setapak","013-7799889"));
        
        List<Staff> staffList = new ArrayList<Staff>();
        staffList.add(new Staff("S1001","Lim Yong Qi","019-7272566"));
        staffList.add(new Staff("S1002","Jimmy Chew","012-3435617"));
        staffList.add(new Staff("S1003","Cindy Lee","019-434580"));
        
        List<Payment> paymentList = new ArrayList<Payment>();
        paymentList.add(new Payment("P1001","10-11-2018",100.0,"Paid"));
        paymentList.add(new Payment("P1002","11-11-2018",200.0,"Unpaid"));
        paymentList.add(new Payment("P1003","15-11-2018",100.0,"UnPaid"));
        
        List<Order> orderList = new ArrayList<Order>();
        orderList.add(new Order("O1001","Give to my girlfriend ","11-11-2018","Process",customerList.get(0),paymentList.get(0),staffList.get(0)));
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
        String indexno = orderList.get(orderList.size()-1).getOrderID();
        int indexnum = Integer.parseInt(indexno.substring(1, 5)) +1;
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        orderList.add(new Order("O"+indexnum,"Description",date,"Received",customerList.get(0),null,staffList.get(0)));
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
            
            if(selection <1 || selection >3)
            {
             System.out.println("\n\nInvalid input. Please enter correct input (1-3) !  \n\n");
            }
        
        }while(selection  <1 || selection  >3);
        
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
        
        if(selectionProd <1 || selectionProd >7 )
        {
            System.out.println("\n\nInvalid input. Please enter correct input!(1-7) \n\n");
        }
        }while(selectionProd <1 || selectionProd >7);
  
        selectedProduct = listProduct.get(selectionProd-1); //listProduct.add(selectionProd-1, selectedProduct);
        if(selectedProduct.getProductQuantity()==0){
            System.out.println("Out of Stock");
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
                    
                    orderlist.add(new OrderList(orderList.get(orderList.size()-1),selectedProduct,selectionQty));
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
    indexnum = Integer.parseInt(indexno.substring(1, 5)) +1;
    Payment payment = new Payment("P"+indexnum,null,totalAmt,"Unpaid");
    orderList.get(orderList.size()-1).setPayment(payment);
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
         if(orderlist.get(i).getOrder().getOrderID().equals(orderList.get(orderList.size()-1).getOrderID())){
             orderlist.get(i).setOrder(orderList.get(orderList.size()-1));
             System.out.println(String.format("%d. %s \t %d", i+1, orderlist.get(i).getProduct().getProductName(), orderlist.get(i).getQuantity()));
         }
     }
     System.out.println("********************************");
     System.out.println("Total Amount :" + orderList.get(orderList.size()-1).getPayment().getTotalAmount());
    
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