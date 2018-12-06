/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CatalogMaintenance;
import fioreflowershop.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;


/**
 *
 * @author ASUS
 */
public class ProductMaintenance {
    public static List<Product> StaffMenu(List<Product> newProdList, List<ProductType> prodTypeList) throws IOException{
        Scanner input = new Scanner(System.in);
       
        Product prod = new Product();
        String option="";
        String options="";
        
        Boolean checkDigit=false;boolean test=false;
        do{
            do{
                System.out.println("\n*********************\n Product Maintenance \n*********************");
                System.out.println("1. Register New Product");
                System.out.println("2. Display Current Product List"); 
                System.out.println("3. Maintain Product Information"); // 
                System.out.println("4. Return Main Menu");      
            
                System.out.printf("\nOption > ");
                option = input.next();
                    //Validation of User Input(Only can be digit)                
              }while(!CheckDigit(option));

            switch(Integer.parseInt(option)){
                case 1: String newProdID = "P" + (1000 + newProdList.size()+1);
                        prod = RegisterNewProduct(newProdID, prodTypeList);
                        if(prod!=null){
                            newProdList.add(prod);
                            System.out.println("Add New Product Successfully!");
                            System.out.println("Enter Any Key Return to Product Menu...");
                            System.in.read();
                            input.nextLine();
                        }else{
                            System.out.println("Failed to Register New Product!");
                        }
                        break;
                case 2: 
                    test=false;
                    do{
                        do{
                            System.out.print("\n***************************\n Current Product Type List \n***************************\n");
                            for(int r=0;r<prodTypeList.size();r++){              
                                System.out.println((r+1) + ". " + prodTypeList.get(r).getProductTypeName());
                            }  
                            System.out.println((prodTypeList.size()+1) + ". Return Product Maintenance Menu");
                            System.out.printf("\nSelect Product Type > ");
                            options = input.next();
                        }while(!CheckDigit(options+1));
                        
                        if(Integer.parseInt(options)==prodTypeList.size()+1){
                            return StaffMenu(newProdList, prodTypeList);
                        }
                        
                          if(Integer.parseInt(options)<=0 || Integer.parseInt(options)>prodTypeList.size()){
                            System.out.printf("Input Out of Range! Please Enter Again");
                            System.in.read();
                            test=false;
                           }else{
                            test=true;
                          }
                    }while(!test);
                    
                    System.out.print("\n***********************\n Current Product List \n***********************\n");
                    int no=0;
                    for(int r=0;r<newProdList.size();r++){    
                        if(newProdList.get(r).getProductType().equals(prodTypeList.get(Integer.parseInt(options)-1))){
                            System.out.println((++no) + ". " + newProdList.get(r).toString());
                        }
                    }  

                    System.out.print("Enter Any Key Return to Product Menu...");
                    System.in.read();
                    break;
                case 3: 
                    test=false;
                    do{
                        do{
                            System.out.print("\n***************************\n Current Product Type List \n***************************\n");
                            for(int r=0;r<prodTypeList.size();r++){              
                                System.out.println((r+1) + ". " + prodTypeList.get(r).getProductTypeName());
                            }  
                            System.out.println((prodTypeList.size()+1) + ". Return Product Maintenance Menu");
                            System.out.printf("\nSelect Product Type > ");
                            options = input.next();
                        }while(!CheckDigit(options+1));
                        
                        if(Integer.parseInt(options)==prodTypeList.size()+1){
                            return StaffMenu(newProdList, prodTypeList);
                        }
                        
                          if(Integer.parseInt(options)<=0 || Integer.parseInt(options)>prodTypeList.size()){
                            System.out.printf("Input Out of Range! Please Enter Again");
                            System.in.read();
                            test=false;
                           }else{
                            test=true;
                          }
                    }while(!test);
                    
                    Boolean check = false; int num=0;test=false;
                    int[] position = new int[100]; int index=0;String optionss="";
                    //problem
                    do{
                        index=0;num=0;test=false;
                        do{
                            System.out.print("\n***********************\n Current Product List \n***********************\n");
                            for(int r=0;r<newProdList.size();r++){    
                                if(newProdList.get(r).getProductType().equals(prodTypeList.get(Integer.parseInt(options)-1))){
                                    System.out.println(++num + "." + newProdList.get(r).getProductName());
                                    position[index]=r;
                                    index++;
                                }
                            }  
                            System.out.println((num+1) + " Return Product Maintenance Menu");
                            System.out.printf("\nOption > ");
                            optionss = input.next();
                            
                      }while(!CheckDigit(optionss));
                        if(Integer.parseInt(optionss)==index+1){
                            break;
                        }
                        if(Integer.parseInt(optionss)<=0 || Integer.parseInt(optionss)>index){
                            System.out.printf("Input Out of Range! Please Enter Again");
                            System.in.read();
                            test=false;
                           }else{
                            test=true;
                            
                            newProdList.set(position[Integer.parseInt(optionss)-1], MaintainProduct(newProdList.get(position[Integer.parseInt(optionss)-1]), prodTypeList));
                            System.out.printf("Enter Any Key Return to Product Menu...");
                            System.in.read();
                            input.nextLine();
                          }
                    }while(!test);
                    break;
                case 4: 
                    return newProdList;  
                default:
                    System.out.printf("Invalid Option! Please Try Again\n");
                    System.out.print("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        }while(Integer.parseInt(option)!=4);  
        
        return newProdList;
    }
    
    public static void CustomerViewProducts(List<Product> newProdList, List<ProductType> prodTypeList) throws IOException{
        Scanner input = new Scanner(System.in);
        Boolean test=false;String options="";
        do{
            test=false;options="";
            do{
                System.out.print("\n***************************\n Current Product Type List \n***************************\n");
                for(int r=0;r<prodTypeList.size();r++){              
                    System.out.println((r+1) + ". " + prodTypeList.get(r).getProductTypeName());
                }  
                System.out.printf("\nSelect Product Type > ");
                options = input.next();
            }while(!CheckDigit(options+1));
            if(Integer.parseInt(options)<=0 || Integer.parseInt(options)>prodTypeList.size()){
                System.out.printf("Input Out of Range! Please Enter Again");
                System.in.read();
                test=false;
            }else{
                test=true;
            }
        }while(!test);

        System.out.print("\n***********************\n Current Product List \n***********************\n");
        int no=0;
        for(int r=0;r<newProdList.size();r++){    
            if(newProdList.get(r).getProductType().equals(prodTypeList.get(Integer.parseInt(options)-1))){
                System.out.println((++no) + ". " + newProdList.get(r).toString());
            }
        }  
    }
    
    public static void ProductOutOfStockNotification(List<Product> prodList, List<ProductType> prodTypeList) {
        for(int r=0;r<prodList.size();r++){
            if(prodList.get(r).getProductQuantity()<5){
                JOptionPane.showMessageDialog(null, "Product Type  : " + prodList.get(r).getProductType().getProductTypeID()+ " " + prodList.get(r).getProductType().getProductTypeName()+ "\nProduct ID        : " + prodList.get(r).getProductID() + "\nProduct Name : " + prodList.get(r).getProductName() + "\nProduct Color  : " + prodList.get(r).getProductColor() + "\nIn-Stock Qty     : " + prodList.get(r).getProductQuantity(), "InfoBox: " + "Product Out Of Stock Notification", JOptionPane.WARNING_MESSAGE);
            }
        }
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
                System.out.println("7. Return Product Menu");
            
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
                    boolean test=false;
                    do{
                        test=false;
                        do{
                            System.out.print("\n***************************\n Current Product Type List \n***************************\n");
                            for(int r=0;r<prodTypeList.size();r++){              
                                System.out.println((r+1) + ". " + prodTypeList.get(r).getProductTypeName());
                            }  
                            System.out.println((prodTypeList.size()+1) + ". Return to Maintain Product Page");
                            System.out.printf("\nSelect Product Type > ");
                            option = input.next();
                        }while(!CheckDigit(option+1));
                        
                        if(Integer.parseInt(option)==prodTypeList.size()+1){
                            System.out.print("Returning to Maintain Product Page...");
                            System.in.read();
                            System.out.println();
                            break;
                        }
                        
                          if(Integer.parseInt(option)<=0 || Integer.parseInt(option)>prodTypeList.size()){
                            System.out.printf("Input Out of Range! Please Enter Again");
                            System.in.read();
                            test=false;
                           }else{
                            test=true;
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
                          }
                    }while(!test);
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