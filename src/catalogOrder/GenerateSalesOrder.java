/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogOrder;

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
       System.out.print("Do you want to generate report ? (Y/N) : ");
       String selectionReport = scan.next();
       
        System.out.println("==========Product Type===========");
        for(int i=0; i<prodTypeList.size(); i++){
            System.out.println(String.format("%d. %s", i + 1, prodTypeList.get(i).getProductTypeName()));
       }
        
        System.out.print("Please enter product type : ");
        int selectionProdType = scan.nextInt(); 
        
         ProductType productType = new ProductType();
        
        productType = prodTypeList.get(selectionProdType-1);
        
        System.out.println("No. \t\t Product Name \t\t\t Quantity \t Total Amount \t");
        for(int i=0; i<orderList.size();i++){
            if(orderList.get(i).getProduct().getProductType().equals(productType))
            {
                totalAmount = orderList.get(i).getProduct().getProductPrice()*orderList.get(i).getQuantity();
                System.out.println(String.format("%d.  \t %s %s %.2f %d %.2f", i + 1,orderList.get(i).getProduct().getProductID(), orderList.get(i).getProduct().getProductName(), orderList.get(i).getProduct().getProductPrice(),orderList.get(i).getQuantity(), totalAmount ));
                sumQty += orderList.get(i).getQuantity();
            }
        }
        
        System.out.print("Total Quantity : " + sumQty);
        return orderList;

    }
}
