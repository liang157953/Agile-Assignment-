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
    public static void Customize(List<Customer> customerList,List<Customized> customizeList,List<Order> orderDataList,List<Style> styleList,List<Size> sizeList, List<Product> productList, List<Accessories> accessoriesList,List<Payment> paymentList,Staff staff){
        int size;
        int style;
        int product;
        int accessories;
        double totalPrice = 0;
        String customer;
        Customer selectedcustomer = new Customer();
        int totaloption;
        Scanner scan = new Scanner(System.in);
        Scanner scancust = new Scanner(System.in);
        System.out.println("Enter CutomerID: ");
        customer = scancust.next();
          for(int i=0; i< customerList.size();i++){
              if(customer.equals(customerList.get(i).getCustID()))
                   selectedcustomer = customerList.get(i);
                }
        
        System.out.println("Customize Product");
        System.out.println("***************************");
        totaloption =0;
        
        System.out.println("\nProduct Price List");
        System.out.println("***************************");
        for(int i = 0; i < productList.size();i++){
            System.out.format("%d. %-25s \t RM %.2f \n",i+1,productList.get(i).getProductName(),productList.get(i).getProductPrice());
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
            System.out.format("%d. %-20s RM %.2f \n",i+1,sizeList.get(i).getSizeDesc(),sizeList.get(i).getSizePrice());

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
            System.out.format("%d. %-20s RM %.2f \n",i+1,styleList.get(i).getStyleDesc(),styleList.get(i).getStylePrice());
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
            System.out.format("%d. %-10s RM %.2f \n",i+1,accessoriesList.get(i).getAccDesc(),accessoriesList.get(i).getAccPrice());
       } 
       do{
        System.out.println("***************************");
        System.out.print("Please select the flower: ");
        accessories = scan.nextInt();
         if(accessories < 0 || accessories > accessoriesList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(accessories < 0 || accessories > accessoriesList.size());
       int priority ;
        System.out.println("\nPick Up Priority");
        System.out.println("***************************");
        System.out.println("1. Normal   RM  8.00");
        System.out.println("2. Express  RM 20.00");
        do{
        System.out.println("***************************");
        System.out.print("Please select the priority level: ");
        priority = scan.nextInt();
          if(priority < 0 || priority > 2){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(priority < 0 || priority > 3);
        
       customizeList.add(new Customized());
       customizeList.get(customizeList.size()-1).setStyle(styleList.get(style-1));
        customizeList.get(customizeList.size()-1).setSize(sizeList.get(size-1));
        customizeList.get(customizeList.size()-1).setProduct(productList.get(product-1));
        customizeList.get(customizeList.size()-1).setAccessories(accessoriesList.get(accessories-1));
        customizeList.get(customizeList.size()-1).setPriority(priority);
       totalPrice += customizeList.get(customizeList.size()-1).getStyle().getStylePrice();
       totalPrice += customizeList.get(customizeList.size()-1).getSize().getSizePrice();
       totalPrice += customizeList.get(customizeList.size()-1).getProduct().getProductPrice();
       totalPrice += customizeList.get(customizeList.size()-1).getAccessories().getAccPrice();
       switch(priority){
           case 1 : totalPrice += 8.00;
           break;
           case 2: totalPrice += 20.00;
           break;
       }
       
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
       int newOrder;
       newOrder = Integer.parseInt(orderDataList.get(orderDataList.size()-1).getOrderID().substring(1,5));
       newOrder += 1;
        
        
       int newPID;
       newPID = Integer.parseInt(paymentList.get(paymentList.size()-1).getPaymentID().substring(2,6));
       newPID += 1;

       
        paymentList.add(new Payment("PA"+newPID,date,totalPrice,"Paid"));
        customizeList.get(customizeList.size()-1).setOrder(orderDataList.get(orderDataList.size()-1));
        Order order = new Order("O"+ newOrder,"customized",date,"Pending",selectedcustomer,paymentList.get(paymentList.size()-1),staff,"Customer");
        System.out.println("You had place order successfully!");
        
        
        System.out.format("\nItemized Bill \t\t\t\t\t Date:%s\n", date);

        System.out.println("**************************************************************************");
        System.out.format("1. %-15s :\t  %-25s \t Price: RM %.2f \n","Flower",customizeList.get(customizeList.size()-1).getProduct().getProductName(),customizeList.get(customizeList.size()-1).getProduct().getProductPrice());
        System.out.format("2. %-15s :\t  %-25s \t Price: RM %.2f \n","Size",customizeList.get(customizeList.size()-1).getSize().getSizeDesc(),customizeList.get(customizeList.size()-1).getSize().getSizePrice());
        System.out.format("3. %-15s :\t  %-25s \t Price: RM %.2f \n","Style",customizeList.get(customizeList.size()-1).getStyle().getStyleDesc(),customizeList.get(customizeList.size()-1).getStyle().getStylePrice());  
        System.out.format("4. %-15s :\t  %-25s \t Price: RM %.2f \n","Accessories",customizeList.get(customizeList.size()-1).getAccessories().getAccDesc(),customizeList.get(customizeList.size()-1).getAccessories().getAccPrice());
        switch(priority){
           case 1 : System.out.format("5.  %-15s :\t  %-25s \t Price: RM %.2f \n","Priority Level","Normal",8.00);
           break;
           case 2: System.out.format("5.  %-15s :\t  %-25s \t Price: RM %.2f \n","Priority Level","Express",20.00);
           break;
       }
        
        System.out.println("**************************************************************************");
       System.out.println("Total : \t\t\t\t\t\t\tRM" + totalPrice +"0");  
    }
   
}