/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogMaintenance;

import fioreflowershop.Product;
import fioreflowershop.ProductType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class ProductMaintenance {

    /**
     * @param args the command line arguments
     */
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
        productList.add(new Product("P1001","Flowers and Chocolates Gift","DESC...","Red",60.00,5,prodTypeList.get(0)));
        productList.add(new Product("P1002","Ladies Gift Hamper","DESC...","Red",65.00,5,prodTypeList.get(1)));
        productList.add(new Product("P1003","Christmas Treats Gift Box","DESC...","White",15.00,5,prodTypeList.get(1)));
        productList.add(new Product("P1004","Honeybee","DESC...","Yellow",30.00,5,prodTypeList.get(0)));
        productList.add(new Product("P1005","Starry Night","DESC...","Blue",45.00,5,prodTypeList.get(2)));
        
        String option="";
        String options="";
        
        Boolean checkDigit=false;
        do{
            do{
                System.out.println("**************\n Product Maintenance \n**************");
                System.out.println("1. Register New Product");
                System.out.println("2. Display Current Product List"); 
                System.out.println("3. Maintain Product Information"); // 
                System.out.println("4. Exit");      
            
                System.out.printf("\nOption > ");
                option = input.next();
                    //Validation of User Input(Only can be digit)                
              }while(!CheckDigit(option));

            switch(Integer.parseInt(option)){
                case 1: String newProdID = "P" + (1000 + productList.size()+1);
                        prod = RegisterNewProduct(newProdID, prodTypeList);
                        if(prod!=null){
                            productList.add(prod);
                            System.out.println("Add New Product Successfully!");
                            System.out.println("Enter Any Key Return to Main Menu...");
                            System.in.read();
                            input.nextLine();
                        }else{
                            System.out.println("Failed to Register New Product!");
                        }
                        break;
                case 2: 
                    for(int r=0;r<productList.size();r++){
                        System.out.println(productList.get(r).toString());
                    }
                    System.out.print("Enter Any Key Return to Main Menu...");
                    System.in.read();
                    break;
                case 3: 
                    boolean test=false;
                    do{
                        do{
                            System.out.print("\n***********************\n Current Product Type List \n***********************\n");
                            for(int r=0;r<prodTypeList.size();r++){              
                                System.out.println((r+1) + "." + prodTypeList.get(r).getProductTypeName());
                            }  

                            System.out.printf("\nSelect Product Type > ");
                            options = input.next();
                        }while(!CheckDigit(options));
                          if(Integer.parseInt(options)<=0 || Integer.parseInt(options)>prodTypeList.size()){
                                System.out.println("Input Out of Range! Please Enter Again");
                                System.in.read();
                                test=false;
                            }else{
                              test=true;
                          }
                    }while(!test);
                    
                    Boolean check = false; int num=0;
                    int[] position = new int[10]; int index=0;
                    //problem
                    do{
                        System.out.print("\n***********************\n Current Product List \n***********************\n");
                        for(int r=0;r<productList.size();r++){    
                            if(productList.get(r).getProductType().equals(prodTypeList.get(Integer.parseInt(options)-1))){
                                System.out.println(++num + "." + productList.get(r).getProductName());
                                position[index]=r;
                                index++;
                            }
                        }  
                        System.out.println((num+1) + " Return Main Menu");
                        System.out.printf("\nOption > ");
                        options = input.next();
                                
                  }while(!CheckDigit(options));
                          if(Integer.parseInt(options) == (num+1)){
                             break;
                          }else{
                              //problem
                            productList.set(position[Integer.parseInt(options)-1], MaintainProduct(productList.get(position[Integer.parseInt(options)-1]), prodTypeList));
                            System.out.println("Enter Any Key Return to Main Menu...");
                            System.in.read();
                            input.nextLine();
                          }
                    
                          
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
    
    public static Product RegisterNewProduct(String newProdID, List<ProductType> prodTypeList) throws IOException{
        Scanner input = new Scanner(System.in);
        Boolean status=false;
        String prodName = "",prodDesc="",prodColor="", prodPrice="", prodQty="", options="";   
        do{
            System.out.println("***************************\n Register New Product \n***************************\n");
            System.out.printf("Product Type ID: %s\n",newProdID);

            System.out.print("Product Name: ");
            prodName = input.next();

            System.out.print("Product Description: ");
            prodDesc = input.next();
            
            do{
                System.out.print("Product Color: ");
                prodColor = input.next();
            }while(!CheckAlphabetic(prodColor));
            
            do{
                System.out.print("Product Price: ");
                prodPrice = input.next();
            }while(!CheckDigit(prodPrice));
            
            do{
                System.out.print("Product Quantity: ");
                prodQty = input.next();
            }while(!CheckDigit(prodQty));
            boolean test=false;
            do{
                do{
                    System.out.print("\n***********************\n Current Product Type List \n***********************\n");
                    for(int r=0;r<prodTypeList.size();r++){              
                        System.out.println((r+1) + "." + prodTypeList.get(r).getProductTypeName());
                    }  

                    System.out.printf("\nSelect Product Type > ");
                    options = input.next();
                }while(!CheckDigit(options));
                  if(Integer.parseInt(options)<=0 || Integer.parseInt(options)>prodTypeList.size()){
                        System.out.println("Input Out of Range! Please Enter Again");
                        System.in.read();
                        test=false;
                    }else{
                      test=true;
                  }
            }while(!test);
   
            if(prodName.equals("")||prodDesc.equals("")||prodDesc.equals("")||prodColor.equals("")||prodPrice.equals("")||prodQty.equals("")){
                System.out.println("\nSystem Notification: All fields must be filled in!");
                System.out.println("Enter Any Key Return to Register Form");
                System.in.read();
                status=false;
            }else{
                status=true;
            }
        }while(!status);
        
        return new Product(newProdID,prodName,prodDesc, prodColor, Double.parseDouble(prodPrice), Integer.parseInt(prodQty), prodTypeList.get(Integer.parseInt(options)-1));
    }
    
    public static Product MaintainProduct(Product updateProduct, List<ProductType> prodTypeList) throws IOException{
        Scanner input = new Scanner(System.in);
        String option="";
        
        do{
            do{
                System.out.println("******************\n Maintain Product \n******************");
                System.out.println(updateProduct.toString());
                System.out.println("1. Product Name");
                System.out.println("2. Product Description");
                System.out.println("3. Product Color");
                System.out.println("4. Product Price");
                System.out.println("5. Product Quantity");
                System.out.println("6. Product Type");      
                System.out.println("7. Return Main Menu");
            
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
                    System.out.printf("Current Product Description: %s",updateProduct.getProductDesc());
                    System.out.print("\nEnter New Product Description: ");
                    String newProdDesc = input.next();
                    
                    do{
                        System.out.print("Are you sure want to proceed? (Y/N): ");
                        proceed = input.next();
                        if(CheckAlphabetic(proceed)){
                            proceed = proceed.toUpperCase();
                        }
                    }while(!proceed.equals("Y")&&!proceed.equals("N"));
                    
                    if(proceed.equals("Y")){
                        updateProduct.setProductDesc(newProdDesc);
                        System.out.print("Update Product Description Successfully!");
                        System.in.read();
                    }else{
                        System.out.print("Returning to Maintain Product Page...");
                        System.in.read();
                        System.out.println();
                        break;
                    }
                    break;
                case 3:
                    System.out.printf("Current Product Color: %s",updateProduct.getProductColor());
                    System.out.print("\nEnter New Product Color: ");
                    String newProdColor = input.next();
                    
                    do{
                        System.out.print("Are you sure want to proceed? (Y/N): ");
                        proceed = input.next();
                        if(CheckAlphabetic(proceed)){
                            proceed = proceed.toUpperCase();
                        }
                    }while(!proceed.equals("Y")&&!proceed.equals("N"));
                    
                    if(proceed.equals("Y")){
                        updateProduct.setProductColor(newProdColor);
                        System.out.print("Update Product Color Successfully!");
                        System.in.read();
                    }else{
                        System.out.print("Returning to Maintain Product Page...");
                        System.in.read();
                        System.out.println();
                        break;
                    }
                    break;
                case 4: 
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
                    
                case 5: 
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
                case 6: 
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
                case 7: 
                    break;
                default:
                    System.out.printf("Invalid Option! Please Try Again\n");
                    System.out.printf("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        }while(Integer.parseInt(option)!=7);
        
        return updateProduct;
    }
    
    public static boolean CheckDigit(String input) throws IOException{
        boolean checkDigit = false;
        for(int r=0;r<input.length();r++){
            if(Character.isDigit(input.charAt(r))){
                checkDigit = true;
            }
            else{
                System.out.printf("Input Must be in Digit! Please Try Again\n");
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
                System.out.printf("Input Must be in Alphabet! Please Try Again\n");
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
