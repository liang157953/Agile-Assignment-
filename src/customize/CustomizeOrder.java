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
        int size,style,product,accessories,priority;
        double totalPrice = 0;
        
        Customer selectedcustomer = new Customer();
        selectedcustomer = SelectCustomer(customerList);

        System.out.println("Customize Product");
        System.out.println("***************************");
        product = SelectProduct(productList);
        size = SelectSize(sizeList);
        style = SelectStyle(styleList);
        accessories = SelectAccessories(accessoriesList); 
        priority = SelectPriority();  
        
       CreateCustomizedOrder(customizeList,styleList,style,sizeList,size,productList,product,accessoriesList,accessories,priority);
       totalPrice = CalculatePrice(customizeList,priority);
       
       String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
       int newOrder;
       newOrder = Integer.parseInt(orderDataList.get(orderDataList.size()-1).getOrderID().substring(1,5));
       newOrder += 1;
         
       int newPID;
       newPID = Integer.parseInt(paymentList.get(paymentList.size()-1).getPaymentID().substring(2,6));
       newPID += 1;
       
        paymentList.add(new Payment("PA"+newPID,date,totalPrice,"Paid"));
        orderDataList.add(new Order("O"+ newOrder,"customized",date,"Pending",selectedcustomer,paymentList.get(paymentList.size()-1),staff,"Customer"));
        customizeList.get(customizeList.size()-1).setOrder(orderDataList.get(orderDataList.size()-1));
        System.out.println("You had place order successfully!");
        ItemizedBill(priority,customizeList,date,totalPrice);
    }
    
   public static void ItemizedBill(int priority, List<Customized> customizeList, String date,double totalPrice){
             System.out.format(" \t\t\t\t\t\t     %-6s : %-10s",customizeList.get(customizeList.size()-1).getOrder().getStaff().getStaffID(),customizeList.get(customizeList.size()-1).getOrder().getStaff().getStaffName());
             System.out.format("\nItemized Bill \t\t\t\t\t\t Date:%s\n", date);

        System.out.println("**************************************************************************");
        System.out.format("1. %-15s :\t  %-25s \t Price: RM %.2f \n","Flower",customizeList.get(customizeList.size()-1).getProduct().getProductName(),customizeList.get(customizeList.size()-1).getProduct().getProductPrice());
        System.out.format("2. %-15s :\t  %-25s \t Price: RM %.2f \n","Size",customizeList.get(customizeList.size()-1).getSize().getSizeDesc(),customizeList.get(customizeList.size()-1).getSize().getSizePrice());
        System.out.format("3. %-15s :\t  %-25s \t Price: RM %.2f \n","Style",customizeList.get(customizeList.size()-1).getStyle().getStyleDesc(),customizeList.get(customizeList.size()-1).getStyle().getStylePrice());  
        System.out.format("4. %-15s :\t  %-25s \t Price: RM %.2f \n","Accessories",customizeList.get(customizeList.size()-1).getAccessories().getAccDesc(),customizeList.get(customizeList.size()-1).getAccessories().getAccPrice());
        switch(priority){
           case 1 : System.out.format("5. %-15s :\t  %-25s \t Price: RM %.2f \n","Priority Level","Normal",8.00);
           break;
           case 2: System.out.format("5. %-15s :\t  %-25s \t Price: RM %.2f \n","Priority Level","Express",20.00);
           break;
       }
        System.out.println("**************************************************************************");
       System.out.println("Total : \t\t\t\t\t\t\tRM" + totalPrice +"0");  
        }
   
   public static Customer SelectCustomer(List<Customer> customerList){
        String customer;
        Customer selectedcustomer = new Customer();
    
        Scanner scancust = new Scanner(System.in);
       System.out.print("Enter CutomerID: ");
        customer = scancust.next();
          for(int i=0; i< customerList.size();i++){
              if(customer.equals(customerList.get(i).getCustID()))
                   selectedcustomer = customerList.get(i);
                }
          return selectedcustomer;
   }
   
   public static void CreateCustomizedOrder(List<Customized> customizeList,List<Style> styleList,int style,List<Size> sizeList,int size,List<Product> productList,int product,List<Accessories> accessoriesList,int accessories,int priority){
       customizeList.add(new Customized());
       customizeList.get(customizeList.size()-1).setStyle(styleList.get(style-1));
        customizeList.get(customizeList.size()-1).setSize(sizeList.get(size-1));
        customizeList.get(customizeList.size()-1).setProduct(productList.get(product-1));
        customizeList.get(customizeList.size()-1).setAccessories(accessoriesList.get(accessories-1));
        customizeList.get(customizeList.size()-1).setPriority(priority);
   }
   
   public static double CalculatePrice(List<Customized> customizeList,int priority){
       double totalPrice = 0.0;
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
       return totalPrice;
   }
   
   public static int SelectProduct(List<Product> productList){
      Scanner scan = new Scanner(System.in);
       int product = 0;
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
        return product;
   }
   
   public static int SelectSize(List<Size> sizeList){
       Scanner scan = new Scanner(System.in);
       int size =0;
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
        return size;
   }
    
   public static int SelectStyle(List<Style> styleList){
       Scanner scan = new Scanner(System.in);
       int style =0;
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
        return style;
   }
   
   public static int SelectAccessories(List<Accessories> accessoriesList){
        Scanner scan = new Scanner(System.in);
        int accessories  = 0;
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
       return accessories;
   }
   
   public static int SelectPriority(){
       Scanner scan = new Scanner(System.in);
       int priority = 0;
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
        return priority;
   }
}