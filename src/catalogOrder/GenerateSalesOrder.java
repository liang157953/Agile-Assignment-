/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogOrder;

import static catalogOrder.catalogOrder.CheckAlphabetic;
import fioreflowershop.Order;
import fioreflowershop.OrderList;
import fioreflowershop.Product;
import fioreflowershop.ProductType;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class GenerateSalesOrder {
    public static List<OrderList> GenerateReportMain(List<ProductType> prodTypeList, List<Product> prodList, List<Order> orderDataList, List <OrderList> orderList ) throws IOException{    
       Scanner scan = new Scanner(System.in); 
       int sumQty = 0;
       double totalAmount = 0;
       char selectionReport;
       int selectionProdType = 0;
       Boolean test=false;String options="";

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
            test=false;options="";
            //do{
        System.out.println("\n==========Product Type===========");
        for(int i=0; i<prodTypeList.size(); i++){
            System.out.println(String.format("%d. %s", i + 1, prodTypeList.get(i).getProductTypeName()));
       }
        
        
        
        System.out.print("Please enter product type : ");
        selectionProdType = scan.nextInt(); 
        if(Integer.parseInt(options)<=0 || Integer.parseInt(options)>prodTypeList.size()){
                System.out.printf("Input Out of Range! Please Enter Again");
                System.in.read();
                test=false;
            }else{
                test=true;
            }
        
        ProductType productType = new ProductType();
        
        productType = prodTypeList.get(selectionProdType-1);
        
        System.out.println("\n\n========================================================================================================");
        System.out.println("\t\t\t\t\tGenerate Report");
        System.out.println("========================================================================================================");
        System.out.println("No. \t Product ID \t Product Name \t\t\t  Unit Price \t Quantity \t Total Amount \t");
        for(int i=0; i<orderList.size();i++){
            if(orderList.get(i).getProduct().getProductType().equals(productType))
            {
                totalAmount = orderList.get(i).getProduct().getProductPrice()*orderList.get(i).getQuantity();
                System.out.printf("%2d.%11s %37s %10.2f %10d %20.2f \n", i + 1,orderList.get(i).getProduct().getProductID(), orderList.get(i).getProduct().getProductName(), orderList.get(i).getProduct().getProductPrice(),orderList.get(i).getQuantity(), totalAmount );
                sumQty += orderList.get(i).getQuantity();
            }
        }
         //}while(!CheckDigit(options+1));
      
        System.out.println("\n========================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t    Total Quantity : " + sumQty);
        System.out.println("========================================================================================================");
        return orderList;

    }while(!test);
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
