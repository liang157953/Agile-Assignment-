/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogMaintenance;
import fioreflowershop.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class RegisterNewProductType {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        ProductType prodType = new ProductType();
        List<ProductType> prodTypeList = new ArrayList<ProductType>();
        
        prodTypeList.add(new ProductType("PT1001","Fresh Flowers","The flowers that will be wither..."));
        prodTypeList.add(new ProductType("PT1002","Bouquets","An attractively arranged bunch of flowers, especially one presented as a gift or carried at a ceremony."));
        prodTypeList.add(new ProductType("PT1003","Floral Arrangements","Flower arrangement is an organization of design and color towards creating an ambience using flowers, foliage and other floral accessories"));
        
        Product prod = new Product();
        List<Product> productList = new ArrayList<Product>();
        //ID,name,price,qty,productType
        productList.add(new Product("P1001","Flowers and Chocolates Gift",60.00,5,prodTypeList.get(0)));
        productList.add(new Product("P1002","Ladies Gift Hamper",65.00,5,prodTypeList.get(1)));
        productList.add(new Product("P1003","Christmas Treats Gift Box",15.00,5,prodTypeList.get(1)));
        productList.add(new Product("P1004","Honeybee",30.00,5,prodTypeList.get(0)));
        productList.add(new Product("P1005","Starry Night",45.00,5,prodTypeList.get(2)));
        
        String option="";
        String options="";
        
        Boolean checkDigit=false;
        do{
            do{
                System.out.println("***********\n Main Menu \n***********");
                System.out.println("1. Register New Product Type");
                System.out.println("2. Display Current Product Type List");
                System.out.println("3. Maintain Product Information");
                System.out.println("4. Exit");      
            
                System.out.printf("\nOption > ");
                option = input.next();
                    //Validation of User Input(Only can be digit)                
              }while(!CheckDigit(option));

            switch(Integer.parseInt(option)){
                case 1: String newProdTypeID = "PT" + (1000 + prodTypeList.size()+1);
                        prodType = RegisterNewProductType(newProdTypeID);
                        if(prodType!=null){
                            prodTypeList.add(prodType);
                            System.out.println("Register New Product Type Successfully!");
                            System.out.println("Enter Any Key Return to Main Menu...");
                            System.in.read();
                            input.nextLine();
                        }else{
                            System.out.println("Failed to Register New Product Type");
                        }
                        break;
                case 2: 
                    for(int r=0;r<prodTypeList.size();r++){
                        System.out.println(prodTypeList.get(r).toString());
                    }
                    System.out.print("Enter Any Key Return to Main Menu...");
                    System.in.read();
                    break;
                case 3: 
                    Boolean check = false;
                    do{
                    System.out.print("***********************\n Current Product List \n***********************\n");
                        for(int r=0;r<productList.size();r++){              
                            System.out.println((r+1) + "." + productList.get(r).getProductName());
                        }   
                            System.out.println((productList.size()+1) + " Return Main Menu");
                            System.out.printf("\nOption > ");
                            options = input.next();
                                //Validation of User Input(Only can be digit)
                          }while(!CheckDigit(options));
                          
                          if(Integer.parseInt(options)==productList.size()+1){
                             break;
                          }
			
                        productList.set(Integer.parseInt(options)-1, MaintainProduct(productList.get(Integer.parseInt(options)-1), prodTypeList));
                        System.out.println("Enter Any Key Return to Main Menu...");
                        System.in.read();
                        input.nextLine();
                    
                    break;
                case 4: 
                    System.out.println("Thank You For Using This System :D...");
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.printf("Invalid Option! Please Try Again\n");
                    System.out.print("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        }while(Integer.parseInt(option)!=4);  
    }
    
    public static ProductType RegisterNewProductType(String newProdTypeID) throws IOException{
        Scanner input = new Scanner(System.in);
        Boolean status=false;
        String prodTypeName = "";   
        String prodTypeDesc = "";
        do{
            System.out.println("***************************\n Register New Product Type\n***************************\n");
            System.out.printf("Product Type ID: %s\n",newProdTypeID);

            System.out.print("Product Type Name: ");
            prodTypeName = input.nextLine();

            System.out.print("Product Type Description: ");
            prodTypeDesc = input.nextLine();
            
            if(prodTypeName.equals("")||prodTypeDesc.equals("")){
                System.out.println("\nSystem Notification: All fields must be filled in!");
                System.out.println("Enter Any Key Return to Register Form");
                System.in.read();
                status=false;
            }else{
                status=true;
            }
        }while(!status);

        return new ProductType(newProdTypeID,prodTypeName,prodTypeDesc);
    }
    
    public static Product MaintainProduct(Product updateProduct, List<ProductType> prodTypeList) throws IOException{
        Scanner input = new Scanner(System.in);
        String option="";
        
        do{
            do{
                System.out.println("******************\n Maintain Product \n********************");
                System.out.println("1. Product Name");
                System.out.println("2. Product Price");
                System.out.println("3. Product Quantity");
                System.out.println("4. Product Type");      
                System.out.println("5. Return Main Menu");
            
                System.out.printf("\nOption > ");
                option = input.next();
                    
              }while(!CheckDigit(option));
              
            String proceed = "";
            switch(Integer.parseInt(option)){
                case 1: 
                    System.out.printf("Current Product Name: %s",updateProduct.getProductName());
                    System.out.print("\nEnter New Product Name: ");
                    String newProdName = input.next();
                    
                    do{
                        System.out.print("Are you sure want to proceed? (Y/N): ");
                        proceed = input.next();
                        if(CheckAlphabetic(proceed)){
                            proceed = proceed.toUpperCase();
                        }
                    }while(!proceed.equals("Y")&&!proceed.equals("N"));
                    
                    if(proceed.equals("Y")){
                        updateProduct.setProductName(newProdName);
                        System.out.print("Update Product Name Successfully!");
                        System.in.read();
                    }else{
                        System.out.print("Returning to Maintain Product Page...");
                        System.in.read();
                        System.out.println();
                        break;
                    }
                    break;
                    
                case 2: 
                    Boolean checkDigit=false;
                    String newProdPrice="";
                        do{
                            System.out.printf("Current Product Price: RM%.2f\n",updateProduct.getProductPrice());
                            System.out.print("Enter New Product Price: RM");
                            newProdPrice = input.next();
                            checkDigit = CheckDigit(newProdPrice);
                            System.out.println();
                        }while(!checkDigit);
                        
                    do{
                        System.out.print("Are you sure want to proceed? (Y/N): ");
                        proceed = input.next();
                        if(CheckAlphabetic(proceed)){
                            proceed = proceed.toUpperCase();
                        }
                        System.out.println();
                    }while(!proceed.equals("Y")&&!proceed.equals("N"));
                    
                    if(proceed.equals("Y")){
                        updateProduct.setProductPrice(Double.parseDouble(newProdPrice));
                        System.out.print("Update Product Price Successfully!");
                        System.in.read();
                    }else{
                        System.out.print("Returning to Maintain Product Page...");
                        System.in.read();
                        System.out.println();
                        break;
                    }
                    break;
                    
                case 3: 
                    String newProdQty="";
                    do{
                        System.out.printf("Current Product Quantity: %2d\n",updateProduct.getProductQuantity());
                        System.out.print("Enter New Product Quantity: ");
                        newProdQty = input.next();
                        
                        }while(!CheckDigit(newProdQty));
                        
                    do{
                        System.out.print("Are you sure want to proceed? (Y/N): ");
                        proceed = input.next();
                        if(CheckAlphabetic(proceed)){
                            proceed = proceed.toUpperCase();
                        }
                        System.out.println();
                    }while(!proceed.equals("Y")&&!proceed.equals("N"));
                    
                    if(proceed.equals("Y")){
                        updateProduct.setProductQuantity(Integer.parseInt(newProdQty));
                        System.out.print("Update Product Quantity Successfully!");
                        System.in.read();
                    }else{
                        System.out.print("Returning to Maintain Product Page...");
                        System.in.read();
                        System.out.println();
                        break;
                    }
                    break;
                case 4: 
                    //product Type
                    System.out.println("***************************\n Current Product Type List \n***************************\n");
                    System.out.printf("Current Product Type: %s\n\nChange To:\n", updateProduct.getProductType().getProductTypeName());
                    for(int r=0;r<prodTypeList.size();r++){
                        System.out.println((r+1) + "." + prodTypeList.get(r).getProductTypeName());
                    }
                    do{
                        System.out.printf("\nOption > ");
                        option = input.next();
                    }while(!CheckDigit(option));
                    
                    do{
                        System.out.print("Are you sure want to proceed? (Y/N): ");
                        proceed = input.next();
                        if(CheckAlphabetic(proceed)){
                            proceed = proceed.toUpperCase();
                        }
                    }while(!proceed.equals("Y")&&!proceed.equals("N"));
                    
                    if(proceed.equals("Y")){
                        updateProduct.setProductType(prodTypeList.get(Integer.parseInt(option)-1));;
                        System.out.print("Update Product Type Successfully!");
                        System.in.read();
                    }else{
                        System.out.print("Returning to Maintain Product Page...");
                        System.in.read();
                        System.out.println();
                        break;
                    }
                    break;
                case 5: 
                    break;
                default:
                    System.out.printf("Invalid Option! Please Try Again\n");
                    System.out.printf("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        }while(Integer.parseInt(option)!=5);
        
        return updateProduct;
    }
    
    public static boolean CheckDigit(String input) throws IOException{
        boolean checkDigit = false;
        for(int r=0;r<input.length();r++){
            if(Character.isDigit(input.charAt(r))){
                checkDigit = true;
            }
            else{
                System.out.printf("Invalid Option! Please Try Again\n");
                System.out.print("Please Enter Any Key to Proceed...");
                System.in.read();
                checkDigit = false;
                break;
            }
        }
        return checkDigit;
    }
    
    public static boolean CheckAlphabetic(String input) throws IOException{
        boolean checkAlphabetic = false;
        for(int r=0;r<input.length();r++){
            if(Character.isAlphabetic(input.charAt(r))){
                checkAlphabetic = true;
            }
            else{
                System.out.printf("Invalid Option! Please Try Again\n");
                System.out.print("Please Enter Any Key to Proceed...");
                System.in.read();
                System.out.println();
                checkAlphabetic = false;
                break;
            }
        }
        return checkAlphabetic;
    }
}
