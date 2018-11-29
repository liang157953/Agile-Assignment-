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
       
       System.out.print("Do you want to generate report ? (Y/N) : ");
       String selectionReport = scan.next();
       for(int i=0; i<orderList.size(); i++){
        System.out.println("==========Product Type===========");
        
        for(int r=0; r<prodTypeList.size();r++)
        {
            System.out.println(String.format("%d. %s", r + 1, prodTypeList.get(r).getProductTypeName()));
            
        }
        
        System.out.print("Please enter product type : ");
        int selectionProdType = scan.nextInt(); 
        
        if(orderList.get(i).getProduct().getProductType().equals(prodTypeList.get(prodTypeList.size()-1).getProductTypeID()))
        {
            //System.out.println();
        }
        
       }
        

        return orderList;
    }

}
