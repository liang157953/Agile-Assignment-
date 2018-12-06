/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customize;
import fioreflowershop.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author User
 */
public class CustomizeOrder {
    public static void Customize(List<Customer> customerList, List<Staff> staffList,List<Customized> customizeList,List<Order> orderDataList,List<Style> styleList,List<Size> sizeList, List<Product> productList, List<Accessories> accessoriesList,List<Payment> paymentList){
        int size;
        int style;
        int product;
        int accessories;
        double totalPrice = 0;
        
        int totaloption;
        Scanner scan = new Scanner(System.in);
        System.out.println("Customize Product");
        System.out.println("***************************");
        totaloption =0;
        
        System.out.println("\nProduct Price List");
        System.out.println("***************************");
        for(int i = 0; i < productList.size();i++){
            System.out.format("%d. %-25s \t %.2f \n",i+1,productList.get(i).getProductName(),productList.get(i).getProductPrice());
        }
        System.out.println("***************************");
        do{
        System.out.print("Please select the flower: ");
        
        product = scan.nextInt();
        if(product < 0 || product > productList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(product < 0 || product > productList.size());

        System.out.println("\nSize Price List");
        System.out.println("***************************");
        for(int i = 0; i < sizeList.size();i++){
            System.out.format("%d. %-20s %.2f \n",i+1,sizeList.get(i).getSizeDesc(),sizeList.get(i).getSizePrice());

        }
        do{
        System.out.println("***************************");
        System.out.print("Please select the size: ");
        size = scan.nextInt();
         if(size < 0 || size > sizeList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(size < 0 || size > sizeList.size());

        System.out.println("\nStyle Price List");
        System.out.println("***************************");
        for(int i = 0; i < styleList.size();i++){
            System.out.format("%d. %-20s %.2f \n",i+1,styleList.get(i).getStyleDesc(),styleList.get(i).getStylePrice());
        }
        do{
        System.out.println("***************************");
        System.out.print("Please select the style: ");
        style = scan.nextInt();
          if(style < 0 || style > styleList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(style < 0 || style > styleList.size());

        System.out.println("\nAccessories Price List");
        System.out.println("***************************");
       for(int i = 0; i < accessoriesList.size();i++){
            System.out.format("%d. %-10s %.2f \n",i+1,accessoriesList.get(i).getAccDesc(),accessoriesList.get(i).getAccPrice());
       } 
       do{
        System.out.println("***************************");
        System.out.print("Please select the flower: ");
        accessories = scan.nextInt();
         if(accessories < 0 || accessories > accessoriesList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(accessories < 0 || accessories > accessoriesList.size());
       customizeList.add(new Customized());
       customizeList.get(customizeList.size()-1).setStyle(styleList.get(style-1));
        customizeList.get(customizeList.size()-1).setSize(sizeList.get(size-1));
        customizeList.get(customizeList.size()-1).setProduct(productList.get(product-1));
        customizeList.get(customizeList.size()-1).setAccessories(accessoriesList.get(accessories-1));
       totalPrice += customizeList.get(customizeList.size()-1).getStyle().getStylePrice();
       totalPrice += customizeList.get(customizeList.size()-1).getSize().getSizePrice();
       totalPrice += customizeList.get(customizeList.size()-1).getProduct().getProductPrice();
       totalPrice += customizeList.get(customizeList.size()-1).getAccessories().getAccPrice();
       int newOID;
       newOID = Integer.parseInt(orderDataList.get(orderDataList.size()-1).getOrderID().substring(1,5));
       newOID += 1;
       int newPID;
       newPID = Integer.parseInt(paymentList.get(paymentList.size()-1).getPaymentID().substring(2,6));
       newPID += 1;
       paymentList.add(new Payment("PA"+newPID,null,totalPrice,"Paid"));
       String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
       // change this one (hard code)
        orderDataList.add(new Order("O"+newOID,"Walk-In",date,"Processing",customerList.get(0),paymentList.get(paymentList.size()-1),staffList.get(0)));
        customizeList.get(customizeList.size()-1).setOrder(orderDataList.get(orderDataList.size()-1));
        System.out.println("You had place order successfully!");
        System.out.println("\nItemized Bill");
        System.out.println("*******************************************");
        System.out.format("1. %-10s \t - %-10s \t Price: RM %.2f \n","flower",customizeList.get(customizeList.size()-1).getProduct().getProductName(),customizeList.get(customizeList.size()-1).getProduct().getProductPrice());
        System.out.format("2. %-10s \t - %-10s \t Price: RM %.2f \n","size",customizeList.get(customizeList.size()-1).getSize().getSizeDesc(),customizeList.get(customizeList.size()-1).getSize().getSizePrice());
        System.out.format("3. %-10s \t - %-10s \t Price: RM %.2f \n","style",customizeList.get(customizeList.size()-1).getStyle().getStyleDesc(),customizeList.get(customizeList.size()-1).getStyle().getStylePrice());  
        System.out.format("4. %-10s \t - %-10s \t Price: RM %.2f \n","accessories",customizeList.get(customizeList.size()-1).getAccessories().getAccDesc(),customizeList.get(customizeList.size()-1).getAccessories().getAccPrice());
        System.out.println("*******************************************");
       System.out.println("Total :      RM" + totalPrice +"0");  
    }
   
}