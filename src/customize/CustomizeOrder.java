/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customize;
import fioreflowershop.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import ADT.*;
import java.util.Date;
import java.util.Scanner;
import order.DeliveryList;
/**
 *
 * @author User
 */
public class CustomizeOrder {
   public static void Customize(ListInterface<Customer> customerList,ListInterface<Customized> customizeList,ListInterface<Order> orderDataList,ListInterface<Style> styleList,ListInterface<Size> sizeList, ListInterface<Product> productList, ListInterface<Accessories> accessoriesList,ListInterface<Payment> paymentList,Staff staff,ListInterface<PickUp> pickupList){
        int size,style,product,accessories,priority;
        double totalPrice = 0;
        Scanner scan = new Scanner(System.in);
        char resume ;
        Customer selectedcustomer = new Customer();
        selectedcustomer = SelectCustomer(customerList);
        do{      
        System.out.println("Customize Product");
        System.out.println("***************************");
        product = SelectProduct(productList);
        size = SelectSize(sizeList);
        style = SelectStyle(styleList);
        accessories = SelectAccessories(accessoriesList); 
        priority = SelectPriority();  
        
       CreateCustomizedOrder(customizeList,styleList,style,sizeList,size,productList,product,accessoriesList,accessories,priority);
       totalPrice = CalculatePrice(customizeList,priority);
       
       String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
       
       int newOrder;
       if(orderDataList.get(orderDataList.size()-1).getOrderID() != null){
       newOrder = Integer.parseInt(orderDataList.get(orderDataList.size()-1).getOrderID().substring(1,5));
       newOrder += 1;
       }
       else{
           newOrder = 1001;
       }
       int newPID;
       if(paymentList.get(paymentList.size()-1).getPaymentID() != null) {
       newPID = Integer.parseInt(paymentList.get(paymentList.size()-1).getPaymentID().substring(2,6));
       newPID += 1;
       }
       else{
           newPID = 1001;
       }
        paymentList.add(new Payment("PA"+newPID,date,totalPrice,"Paid"));
        orderDataList.add(new Order("O"+ newOrder,"customized",date,"Pending",selectedcustomer,paymentList.get(paymentList.size()-1),staff,"Customer"));
        customizeList.get(customizeList.size()-1).setOrder(orderDataList.get(orderDataList.size()-1));
        System.out.println("You had place order successfully!");
        ItemizedBill(priority,customizeList,date,totalPrice,pickupList,staff);    
        System.out.print("Do You Want To Make Another Customize Order?(y/n) :");
        do{
           
         resume = (scan.next().charAt(0));
                switch(resume){
                    case 'Y':
                        resume = 'y';
                        break;
                    case 'N':
                        resume = 'n';
                        break;
                }
                if(resume != 'y' &&resume !='n'){
                    System.out.println("Please Enter y/n only");
                }    
        }while(resume != 'y' &&resume !='n');   
        }while(resume == 'y');
    }
    
   public static void ItemizedBill(int priority, ListInterface<Customized> customizeList, String date,double totalPrice,ListInterface<PickUp> pickupList,Staff staff){
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
       SelectPickUp(customizeList,pickupList,staff);
        }
   
   public static Customer SelectCustomer(ListInterface<Customer> customerList){
        String customer;
        char newcust = 'n';
        Customer selectedcustomer = new Customer();
    
        Scanner scancust = new Scanner(System.in);
       System.out.print("Are you the new customer? (y/n) :");
       newcust = scancust.next().charAt(0);
       if(newcust == 'Y' || newcust == 'y'){
           addNewCustomer(customerList);
           selectedcustomer = customerList.get(customerList.size()-1);
       }
       else{
       System.out.print("Enter CutomerID: ");
        customer = scancust.next();
          for(int i=0; i< customerList.size();i++){
              if(customer.equals(customerList.get(i).getCustID()))
                   selectedcustomer = customerList.get(i);
                }
         }
       return selectedcustomer;
   }
   
   public static void CreateCustomizedOrder(ListInterface<Customized> customizeList,ListInterface<Style> styleList,int style,ListInterface<Size> sizeList,int size,ListInterface<Product> productList,int product,ListInterface<Accessories> accessoriesList,int accessories,int priority){
       customizeList.add(new Customized());
       int newCustomize;
       if(customizeList.get(customizeList.size()-1).getCustomizedID() != null){
       newCustomize = Integer.parseInt(customizeList.get(customizeList.size()-1).getCustomizedID().substring(2,6));
       newCustomize += 1;
       }
       else{
           newCustomize = 1001;
       }
       customizeList.get(customizeList.size()-1).setCustomizedID("CZ"+newCustomize);
       customizeList.get(customizeList.size()-1).setStyle(styleList.get(style-1));
        customizeList.get(customizeList.size()-1).setSize(sizeList.get(size-1));
        customizeList.get(customizeList.size()-1).setProduct(productList.get(product-1));
        customizeList.get(customizeList.size()-1).setAccessories(accessoriesList.get(accessories-1));
        customizeList.get(customizeList.size()-1).setPriority(priority);
   }
   
   public static double CalculatePrice(ListInterface<Customized> customizeList,int priority){
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
   
   public static int SelectProduct(ListInterface<Product> productList){
      Scanner scan = new Scanner(System.in);
       int product = 0;
        System.out.println("\nProduct Price List");
        System.out.println("*************************************************");
        for(int i = 0; i < productList.size();i++){
            System.out.format("%d. %-25s \t RM %.2f \n",i+1,productList.get(i).getProductName(),productList.get(i).getProductPrice());
        }
        System.out.println("*************************************************");
        do{
        System.out.print("Please select the flower: ");
        
        product = scan.nextInt();
        if(product < 0 || product > productList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(product < 0 || product > productList.size());
        return product;
   }
   
   public static int SelectSize(ListInterface<Size> sizeList){
       Scanner scan = new Scanner(System.in);
       int size =0;
        System.out.println("\nSize Price List");
        System.out.println("*************************************************");
        for(int i = 0; i < sizeList.size();i++){
            System.out.format("%d. %-20s RM %.2f \n",i+1,sizeList.get(i).getSizeDesc(),sizeList.get(i).getSizePrice());

        }
        do{
        System.out.println("*************************************************");
        System.out.print("Please select the size: ");
        size = scan.nextInt();
         if(size < 0 || size > sizeList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(size < 0 || size > sizeList.size());
        return size;
   }
    
   public static int SelectStyle(ListInterface<Style> styleList){
       Scanner scan = new Scanner(System.in);
       int style =0;
       System.out.println("\nStyle Price List");
        System.out.println("*************************************************");
        for(int i = 0; i < styleList.size();i++){
            System.out.format("%d. %-20s RM %.2f \n",i+1,styleList.get(i).getStyleDesc(),styleList.get(i).getStylePrice());
        }
        do{
        System.out.println("*************************************************");
        System.out.print("Please select the style: ");
        style = scan.nextInt();
          if(style < 0 || style > styleList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(style < 0 || style > styleList.size());
        return style;
   }
   
   public static int SelectAccessories(ListInterface<Accessories> accessoriesList){
        Scanner scan = new Scanner(System.in);
        int accessories  = 0;
       System.out.println("\nAccessories Price List");
        System.out.println("************************************************");
       for(int i = 0; i < accessoriesList.size();i++){
            System.out.format("%d. %-10s RM %.2f \n",i+1,accessoriesList.get(i).getAccDesc(),accessoriesList.get(i).getAccPrice());
       } 
       do{
        System.out.println("************************************************");
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
   
   public static void SelectPickUp(ListInterface<Customized> customizeList,ListInterface<PickUp> pickupList,Staff staff){
       Scanner scan = new Scanner(System.in);
       Scanner scanInt = new Scanner(System.in);
       String requirePickUpDate;
       int day;
       int month;
       int year;
       String requirePickUpTime;
       boolean checkDate = false;
       do{
       requirePickUpDate = DeliveryList.Date();
       day = Integer.parseInt(requirePickUpDate.substring(0,2));
       month = Integer.parseInt(requirePickUpDate.substring(3,5));
       year = Integer.parseInt(requirePickUpDate.substring(6,10));
       checkDate = DeliveryList.ValidDate(day,month,year);
      
       if(!checkDate){
           System.out.print("The Date is invalid, please enter again!\n\n");
       }
       }while(!checkDate);
       System.out.print("Please Select the Pick Up Time:");
       requirePickUpTime = scan.nextLine();
       int newPickUp;
       if(pickupList.get(pickupList.size()-1).getPickupNo() != null){
       newPickUp = Integer.parseInt(pickupList.get(pickupList.size()-1).getPickupNo().substring(2,6));
       newPickUp += 1;   
       }
       else{
           newPickUp = 1001;
       }
       pickupList.add(new PickUp("PU"+newPickUp,requirePickUpDate,requirePickUpTime,null,null,null,staff,customizeList.get(customizeList.size()-1),customizeList.get(customizeList.size()-1).getPriority()));
   }
   
    public static QueueInterface<PickUp> GenerateQueue(ListInterface<PickUp> pickupList, String date) {

        ListInterface<PickUp> sortedPriority = new LinkedList<>();
        SortedListInterface<PickUp> sortedTime = new SortedLinkedList<>();
        ListInterface<PickUp> sameDate = new LinkedList<>();
        QueueInterface<PickUp> pickupqueue = new LinkedQueue<>();
        for (int i = 0; i < pickupList.size(); i++) { //compare same date
            if (pickupList.get(i).getRequirePickUpDate().equals(date)) {
                sameDate.add(pickupList.get(i));
            }
        }
        
        for (int i = 0; i < sameDate.size(); i++) { //sort time morning = highest priority
            sortedTime.add(sameDate.get(i).getPickUp());
        }

        int size = sortedTime.getLength();

        PickUp highestPriority = new PickUp();

        for (int i = 1; i <= sortedTime.getLength(); i++) {
            highestPriority = sortedTime.getEntry(i);
            for (int r = 1; r <= sortedTime.getLength(); r++) {
                if (sortedTime.getEntry(i).getPriorityLevel() >= sortedTime.getEntry(r).getPriorityLevel()) {
                    highestPriority = sortedTime.getEntry(i);
                }
            }
            sortedPriority.add(highestPriority);
        }

        size = sortedPriority.size();

        for (int i = 0; i < size; i++) {
            pickupqueue.enqueue(sortedPriority.get(i));
        }

        return pickupqueue;
    }
   
   public static void addNewCustomer(ListInterface<Customer> customerList){
    String custID;
    String custName;
    String custAddress;
    String custContactNo;
    Scanner scan = new Scanner(System.in);
    System.out.println("= = = = = = = = = = = = = = = = = = = ");
    System.out.println("Regiter New Customer");
    System.out.println("= = = = = = = = = = = = = = = = = = = ");
    
        int newCID;
       newCID = Integer.parseInt(customerList.get(customerList.size()-1).getCustID().substring(1,5));
       newCID += 1;
       custID = "C"+newCID;
    System.out.print("Customer Name:");
    custName = scan.nextLine();
    System.out.print("Customer Address:");
    custAddress = scan.nextLine();
    System.out.print("Customer Contact No:");
    custContactNo = scan.nextLine();
    System.out.print("\n\n\n");
    customerList.add(new Customer(custID,custName,custAddress,custContactNo));
    
   }

   
}