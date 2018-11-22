/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customize;
import fioreflowershop.*;
import java.io.IOException;
import java.util.*;
/**
 *
 * @author User
 */
public class customize {
    public static void main(String args[]){
        int size;
        int style;
        int product;
        int accessories;
        double totalPrice = 0;
        
        Customized cust = new Customized();
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
        
        List<Order> order = new ArrayList<Order>();
        order.add(new Order("O1001","Give to my girlfriend ","11-11-2018","Process",customerList.get(0),paymentList.get(0),staffList.get(0)));
        order.add(new Order("O1002","","15-11-2018","Process",customerList.get(1),paymentList.get(1),staffList.get(1)));
        order.add(new Order("O1003","Please say happy birthday to the receiver","15-11-2018","Process",customerList.get(2),paymentList.get(2),staffList.get(2)));
        
        List<Style> styleList = new ArrayList<Style>();
        styleList.add(new Style("1001","Standard",1.00));
        styleList.add(new Style("1002","LOVE",10.00));
        styleList.add(new Style("1003","Convo",20.00));
        
        List<Size> sizeList = new ArrayList<Size>();
        sizeList.add(new Size("1001","Small",1.00));
        sizeList.add(new Size("1002","Medium",5.00));   
        sizeList.add(new Size("1002","Large",10.00)); 
        sizeList.add(new Size("1002","Extra Large",15.00)); 
        
        List<ProductType> prodTypeList = new ArrayList<ProductType>();
        prodTypeList.add(new ProductType("PT1001","Fresh Flowers","The flowers that will be wither..."));
        prodTypeList.add(new ProductType("PT1002","Bouquets","An attractively arranged bunch of flowers, especially one presented as a gift or carried at a ceremony."));
        prodTypeList.add(new ProductType("PT1003","Floral Arrangements","Flower arrangement is an organization of design and color towards creating an ambience using flowers, foliage and other floral accessories"));
        
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product("1001","Rose",2.00,50,prodTypeList.get(0)));
        productList.add(new Product("1002","Peruvian LIly",100.00,50,prodTypeList.get(1)));
        productList.add(new Product("1003","Star of Bethlehem",200000.00,50,prodTypeList.get(2)));
        
        List<Accessories> accessoriesList = new ArrayList<Accessories>();
        accessoriesList.add(new Accessories("1001","Bear",5.00));
        accessoriesList.add(new Accessories("1002","Ribbon",10.00));
        accessoriesList.add(new Accessories("1003","Pokemon",20.00));
        
        int totaloption;
        Scanner scan = new Scanner(System.in);
        System.out.println("Customize Product");
        System.out.println("*****************************");
        totaloption =0;
        
        System.out.println("\nProduct Price List");
        System.out.println("*****************************");
        for(int i = 0; i < productList.size();i++){
            System.out.printf(i+1 + "." + productList.get(i).getProductName() + "\t RM" + productList.get(i).getProductPrice() +"\n");
        }
        System.out.println("*****************************");
        do{
        System.out.print("Please select the flower: ");
        
        product = scan.nextInt();
        if(product < 0 || product > productList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(product < 0 || product > productList.size());

        System.out.println("\nSize Price List");
        System.out.println("*****************************");
        for(int i = 0; i < sizeList.size();i++){
            System.out.printf(i+1 + "." + sizeList.get(i).getSizeDesc() + "\t RM" + sizeList.get(i).getSizePrice()+"\n");

        }
        do{
        System.out.println("*****************************");
        System.out.print("Please select the size: ");
        size = scan.nextInt();
         if(size < 0 || size > sizeList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(size < 0 || size > sizeList.size());

        System.out.println("\nStyle Price List");
        System.out.println("*****************************");
        for(int i = 0; i < styleList.size();i++){
            System.out.printf(i+1 + "." + styleList.get(i).getStyleDesc() + "\t RM" + styleList.get(i).getStylePrice()+"\n");
        }
        do{
        System.out.println("*****************************");
        System.out.print("Please select the style: ");
        style = scan.nextInt();
          if(style < 0 || style > styleList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(style < 0 || style > styleList.size());

        System.out.println("\nAccessories Price List");
        System.out.println("*****************************");
       for(int i = 0; i < accessoriesList.size();i++){
            System.out.printf(i+1 + "." + accessoriesList.get(i).getAccDesc() + "\t RM" + accessoriesList.get(i).getAccPrice() +"\n");
       } 
       do{
        System.out.println("*****************************");
        System.out.print("Please select the flower: ");
        accessories = scan.nextInt();
         if(accessories < 0 || accessories > accessoriesList.size()){
            System.out.println("Invalid Input, Please Enter Again!");
        }
        }while(accessories < 0 || accessories > accessoriesList.size());
        cust.setStyle(styleList.get(style-1));
        cust.setSize(sizeList.get(size-1));
        cust.setProduct(productList.get(product-1));
        cust.setAccessories(accessoriesList.get(accessories-1));
        cust.setOrder(order.get(1));
        totalPrice += cust.getStyle().getStylePrice();
        totalPrice += cust.getSize().getSizePrice();
        totalPrice += cust.getProduct().getProductPrice();
        totalPrice += cust.getAccessories().getAccPrice();
        
        System.out.println("You had place order successfully!");
        System.out.println("\nItemized Bill");
        System.out.println("*********************************************");
        System.out.println("1. flower - " + cust.getProduct().getProductName() + "\t Price: RM" + cust.getProduct().getProductPrice() +"0");
        System.out.println("2. size - " + cust.getSize().getSizeDesc() + "\t Price: RM" + cust.getSize().getSizePrice() +"0");
        System.out.println("3. style - " + cust.getStyle().getStyleDesc()  + "\t Price: RM" + cust.getStyle().getStylePrice()+"0");  
        System.out.println("4. accessories - " + cust.getAccessories().getAccDesc() + "\t Price: RM" + cust.getAccessories().getAccPrice() +"0");
        System.out.println("*********************************************");
       System.out.println("Total :      RM" + totalPrice +"0");  
    }
   
}
