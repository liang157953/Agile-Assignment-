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
    public static List<Product> ProductMaintenanceMenu(List<Product> newProdList, List<ProductType> prodTypeList) throws IOException{
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
                case 1: String info = "********************************\n Register New Promotion Product \n********************************";
                        System.out.println(info);
                        String newProdID = "P" + (1000 + newProdList.size()+1);
                        
                        prod = RegisterNewProduct(newProdID, prodTypeList,0);
                        if(prod!=null){
                            newProdList.add(prod);
                            System.out.print(ConsoleColors.GREEN + "Add New Product Successfully!\n\n" + ConsoleColors.RESET);
                            System.out.print("Enter Any Key Return to Product Menu...");
                            System.in.read();
                            input.nextLine();
                        }else{
                            System.err.println("Failed to Register New Product!");
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
                            return ProductMaintenanceMenu(newProdList, prodTypeList);
                        }
                        
                          if(Integer.parseInt(options)<=0 || Integer.parseInt(options)>prodTypeList.size()){
                            System.err.printf("Input Out of Range! Please Enter Again");
                            System.in.read();
                            test=false;
                           }else{
                            test=true;
                          }
                    }while(!test);
                    
                    int no=0; boolean found=false;
                    for(int r=0;r<newProdList.size();r++){    
                        if(newProdList.get(r).getProductType().equals(prodTypeList.get(Integer.parseInt(options)-1))){
                            found=true;
                        }
                    }  
                    
                    if(found){
                        System.out.print("\n********************************\n Current Promotion Product List \n********************************\n");
                        for(int r=0;r<newProdList.size();r++){    
                            if(newProdList.get(r).getProductType().equals(prodTypeList.get(Integer.parseInt(options)-1))){
                                System.out.println(newProdList.get(r).toString());
                            }
                        }
                    }else{
                        System.err.println("No Current Product List\n");
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
                            return ProductMaintenanceMenu(newProdList, prodTypeList);
                        }
                        
                          if(Integer.parseInt(options)<=0 || Integer.parseInt(options)>prodTypeList.size()){
                            System.err.printf("Input Out of Range! Please Enter Again");
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
                            System.err.printf("Input Out of Range! Please Enter Again");
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
                    System.err.printf("Invalid Option! Please Try Again\n");
                    System.out.print("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        }while(Integer.parseInt(option)!=4);  
        return newProdList;
    }
    
    public static List<Product> PromotionProductMaintenanceMenu(List<Product> prodPromotionList, List<ProductType> prodTypeList) throws IOException{
        Scanner input = new Scanner(System.in);
       
        Product promotionProd = new Product();
        String option="";
        String options="";
        
        Boolean checkDigit=false;boolean test=false;
        do{
            do{
                System.out.println("\n*******************************\n Promotion Product Maintenance \n*******************************");
                System.out.println("1. Register New Promotion Product");
                System.out.println("2. Display Current Promotion Product List"); 
                System.out.println("3. Maintain Promotion Product Information"); // 
                System.out.println("4. Return Main Menu");      
            
                System.out.printf("\nOption > ");
                option = input.next();
                    //Validation of User Input(Only can be digit)                
              }while(!CheckDigit(option));
            
            switch(Integer.parseInt(option)){
                case 1: String newProdID = "PM" + (1000 + prodPromotionList.size()+1);
                    String info = "********************************\n Register New Promotion Product \n********************************";
                    System.out.println(info);
                        promotionProd = RegisterNewProduct(newProdID, prodTypeList,1);
                        if(promotionProd!=null){
                            prodPromotionList.add(promotionProd);
                            System.out.print(ConsoleColors.GREEN + "Add New Promotion Product Successfully!\n\n" + ConsoleColors.RESET);
                            System.out.print("Enter Any Key Return to Product Menu...");
                            System.in.read();
                            input.nextLine();
                        }else{
                            System.out.println("Failed to Register New Product!");
                        }
                        break;
                case 2:
                    String selectPromoMonth=""; boolean checkMonth=true;                      
                    do{
                        selectPromoMonth="";
                        checkMonth=true;
                        do{
                            System.out.print("Enter Promotion Month (eg. 1 = Jan): ");
                            selectPromoMonth = input.next();
                        }while(!CheckDigit(selectPromoMonth));

                        switch(Integer.parseInt(selectPromoMonth)){
                            case 1: selectPromoMonth="JANUARY"; break;
                            case 2: selectPromoMonth="FEBRUARY"; break;
                            case 3: selectPromoMonth="MARCH"; break;
                            case 4: selectPromoMonth="APRIL"; break;
                            case 5: selectPromoMonth="MAY"; break;
                            case 6: selectPromoMonth="JUNE"; break;
                            case 7: selectPromoMonth="JULY"; break;
                            case 8: selectPromoMonth="AUGUST"; break;
                            case 9: selectPromoMonth="SEPTEMBER"; break;
                            case 10: selectPromoMonth="OCTORBER"; break;
                            case 11: selectPromoMonth="NOVEMBER"; break;
                            case 12: selectPromoMonth="DECEMBER"; break;
                            default:System.err.println("Error: Input out of Range!"); checkMonth=false;
                        }
                    }while(!checkMonth);
        
                    System.out.println("\nMonthly Promotion: " + ConsoleColors.RED + selectPromoMonth + ConsoleColors.RESET);
                    
                    int no=0; boolean found=false;
                    for(int r=0;r<prodPromotionList.size();r++){    
                        if(prodPromotionList.get(r).getProductPromotionMonth().equals(selectPromoMonth)){
                                found=true;
                            }
                    }  
                    
                    if(found){
                        System.out.print("\n********************************\n Current Promotion Product List \n********************************\n");
                        for(int r=0;r<prodPromotionList.size();r++){    
                            if(prodPromotionList.get(r).getProductPromotionMonth().equals(selectPromoMonth)){
                                System.out.println(prodPromotionList.get(r).toString());
                            }
                        }
                    }else{
                        System.err.println("No Current Promotion Product List\n");
                    }
                    
                    System.out.print("Enter Any Key Return to Product Menu...");
                    System.in.read();
                    break;
                case 3: 
                    selectPromoMonth=""; checkMonth=true;                      
                    do{
                        selectPromoMonth="";
                        checkMonth=true;
                        do{
                            System.out.print("Enter Promotion Month (eg. 1 = Jan): ");
                            selectPromoMonth = input.next();
                        }while(!CheckDigit(selectPromoMonth));

                        switch(Integer.parseInt(selectPromoMonth)){
                            case 1: selectPromoMonth="JANUARY"; break;
                            case 2: selectPromoMonth="FEBRUARY"; break;
                            case 3: selectPromoMonth="MARCH"; break;
                            case 4: selectPromoMonth="APRIL"; break;
                            case 5: selectPromoMonth="MAY"; break;
                            case 6: selectPromoMonth="JUNE"; break;
                            case 7: selectPromoMonth="JULY"; break;
                            case 8: selectPromoMonth="AUGUST"; break;
                            case 9: selectPromoMonth="SEPTEMBER"; break;
                            case 10: selectPromoMonth="OCTORBER"; break;
                            case 11: selectPromoMonth="NOVEMBER"; break;
                            case 12: selectPromoMonth="DECEMBER"; break;
                            default:System.err.println("Error: Input out of Range!"); checkMonth=false;
                        }
                    }while(!checkMonth);
        
                    System.out.println("\nMonthly Promotion: " + ConsoleColors.RED + selectPromoMonth + ConsoleColors.RESET);
                    
                    no=0; found=false;
                    for(int r=0;r<prodPromotionList.size();r++){    
                        if(prodPromotionList.get(r).getProductPromotionMonth().equals(selectPromoMonth)){
                                found=true;
                            }
                    }  

                    test=false;
                        
                    Boolean check = false; int num=0;test=false;
                    int[] position = new int[100]; int index=0;String optionss="";
                    //problem
                    do{
                        index=0;num=0;test=false;
                        do{
                            System.out.print("\n*******************************\n Current Promotion Product List \n*******************************\n");
                            for(int r=0;r<prodPromotionList.size();r++){    
                                if(prodPromotionList.get(r).getProductPromotionMonth().equals(selectPromoMonth)){
                                    System.out.println(++num + "." + prodPromotionList.get(r).getProductName());
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
                            System.err.printf("Input Out of Range! Please Enter Again");
                            System.in.read();
                            test=false;
                           }else{
                            test=true;
                            
                            prodPromotionList.set(position[Integer.parseInt(optionss)-1], MaintainProduct(prodPromotionList.get(position[Integer.parseInt(optionss)-1]), prodTypeList));
                            System.out.printf("Enter Any Key Return to Product Menu...");
                            System.in.read();
                            input.nextLine();
                          }
                    }while(!test);
                    break;
                case 4: 
                    return prodPromotionList;
                default:
                    System.err.printf("Invalid Option! Please Try Again\n");
                    System.out.print("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        }while(Integer.parseInt(option)!=4); 
        return prodPromotionList;
    }
    
    public static boolean CustomerViewProducts(List<Product> newProdList, List<ProductType> prodTypeList,String options) throws IOException{
        Scanner input = new Scanner(System.in);
        Boolean test=false;//String options="";
        Boolean check=false;
        //do{
            test=false;//options="";
            //do{
                System.out.print("\n***************************\n Current Product Type List \n***************************\n");
                for(int r=0;r<prodTypeList.size();r++){              
                    System.out.println((r+1) + ". " + prodTypeList.get(r).getProductTypeName());
                }  
                System.out.printf("\nSelect Product Type > ");
                //options = input.next();
            //}while(!CheckDigit(options+1));
            if(Integer.parseInt(options)<=0 || Integer.parseInt(options)>prodTypeList.size()){
                System.err.printf("Input Out of Range! Please Enter Again");
                System.in.read();
                test=false;
            }else{
                test=true;
            }
        //}while(!test);
        
        if(test){
            System.out.print("\n***********************\n Current Product List \n***********************\n");
            int no=0;
            for(int r=0;r<newProdList.size();r++){    
                if(newProdList.get(r).getProductType().equals(prodTypeList.get(Integer.parseInt(options)-1))){
                    System.out.println((++no) + ". " + newProdList.get(r).toString());
                    check=true;
                }
            }  
        }else{
            System.out.println("Invalid Options!");
        }
        
        return check;
    }
    
    public static void ProductOutOfStockNotification(List<Product> prodList, List<ProductType> prodTypeList) {
        for(int r=0;r<prodList.size();r++){
            if(prodList.get(r).getProductQuantity()<5){
                JOptionPane.showMessageDialog(null, "Product Type  : " + prodList.get(r).getProductType().getProductTypeID()+ " " + prodList.get(r).getProductType().getProductTypeName()+ "\nProduct ID        : " + prodList.get(r).getProductID() + "\nProduct Name : " + prodList.get(r).getProductName() + "\nProduct Color  : " + prodList.get(r).getProductColor() + "\nIn-Stock Qty     : " + prodList.get(r).getProductQuantity(), "InfoBox: " + "Product Out Of Stock Notification", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    public static Product RegisterNewProduct(String newProdID, List<ProductType> prodTypeList, int access) throws IOException{
        Scanner input = new Scanner(System.in);
        Boolean status=false;
        String prodName = "",prodDesc="",prodColor="", prodPrice="", prodQty="", options="", promoMonth=null; 
        do{
            if(access==1){
                 boolean checkMonth=true;
                do{
                    checkMonth=true;
                    do{
                        System.out.print("Enter Promotion Month (eg. 1 = Jan): ");
                        promoMonth = input.nextLine();
                    }while(!CheckDigit(promoMonth));

                    switch(Integer.parseInt(promoMonth)){
                            case 1: promoMonth="JANUARY"; break;
                            case 2: promoMonth="FEBRUARY"; break;
                            case 3: promoMonth="MARCH"; break;
                            case 4: promoMonth="APRIL"; break;
                            case 5: promoMonth="MAY"; break;
                            case 6: promoMonth="JUNE"; break;
                            case 7: promoMonth="JULY"; break;
                            case 8: promoMonth="AUGUST"; break;
                            case 9: promoMonth="SEPTEMBER"; break;
                            case 10: promoMonth="OCTORBER"; break;
                            case 11: promoMonth="NOVEMBER"; break;
                            case 12: promoMonth="DECEMBER"; break;
                        default:System.err.println("Error: Input out of Range!"); checkMonth=false;
                    }
                }while(!checkMonth);
                System.out.println("\nCreating Monthly Promotion: " + ConsoleColors.RED + promoMonth + ConsoleColors.RESET);
            }
            
            System.out.println("Product Type ID: " + ConsoleColors.BLUE + newProdID + ConsoleColors.RESET);

            System.out.print("Product Name: ");
            prodName = input.nextLine();

            System.out.print("Product Description: ");
            prodDesc = input.nextLine();
            
            do{
                System.out.print("Product Color: ");
                prodColor = input.nextLine();
            }while(!CheckAlphabetic(prodColor));
            
            prodPrice = "" + ProductMaintenance.askInputDouble("Product Price: RM ");      
            
            do{
                System.out.print("Product Quantity: ");
                prodQty = input.next();
            }while(!CheckDigit(prodQty));
            boolean test=false;
            do{
                do{
                    System.out.print("\n***************************\n Current Product Type List \n***************************\n");
                    for(int r=0;r<prodTypeList.size();r++){              
                        System.out.println((r+1) + "." + prodTypeList.get(r).getProductTypeName());
                    }  

                    System.out.printf("\nSelect Product Type > ");
                    options = input.next();
                }while(!CheckDigit(options));
                  if(Integer.parseInt(options)<=0 || Integer.parseInt(options)>prodTypeList.size()){
                        System.err.println("Input Out of Range! Please Enter Again");
                        System.in.read();
                        test=false;
                    }else{
                      test=true;
                  }
            }while(!test);
   
            if(prodName.equals("")||prodDesc.equals("")||prodDesc.equals("")||prodColor.equals("")||prodPrice.equals("")||prodQty.equals("")){
                System.err.println("\nSystem Notification: All fields must be filled in!");
                System.out.println("Enter Any Key Return to Register Form");
                System.in.read();
                status=false;
            }else{
                status=true;
            }
        }while(!status);
        
        return new Product(newProdID,prodName,prodDesc, prodColor, Double.parseDouble(prodPrice), Integer.parseInt(prodQty), prodTypeList.get(Integer.parseInt(options)-1),promoMonth);
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
                        System.out.print(ConsoleColors.GREEN + "Update Product Name Successfully!\n\n" + ConsoleColors.RESET);
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
                        System.out.print(ConsoleColors.GREEN + "Update Product Description Successfully!\n\n" + ConsoleColors.RESET);
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
                        System.out.print(ConsoleColors.GREEN + "Update Product Color Successfully!\n\n" + ConsoleColors.RESET);
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
                    System.out.printf("Current Product Price: RM%.2f\n",updateProduct.getProductPrice());
                    newProdPrice = "" + ProductMaintenance.askInputDouble("Enter New Product Price: RM ");  
                    System.out.println();
                        
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
                        System.out.print(ConsoleColors.GREEN + "Update Product Price Successfully!\n\n" + ConsoleColors.RESET);
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
                        System.out.print(ConsoleColors.GREEN + "Update Product Quantity Successfully!\n\n" + ConsoleColors.RESET);
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
                            System.err.printf("Input Out of Range! Please Enter Again");
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
                                System.out.print(ConsoleColors.GREEN + "Update Product Type Successfully!\n\n" + ConsoleColors.RESET);
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
                    System.err.printf("Invalid Option! Please Try Again\n");
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
                System.err.printf("Input Must be in Digit! Please Try Again");
                System.out.println("Please Enter Any Key to Proceed...");
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
                System.err.printf("Input Must be in Alphabet! Please Try Again\n");
                System.out.print("\nPlease Enter Any Key to Proceed...");
                System.in.read();
                System.out.println();
                checkAlphabetic = false;
                break;
            }
        }
        
        return checkAlphabetic;
    }
    
    public static double askInputDouble(String informationText) {
        Scanner input = new Scanner(System.in);
        Boolean error = false;
        String userInp = "";
        do {
            System.out.print(informationText);
            userInp = input.nextLine();
            if (!ProductMaintenance.isDouble(userInp, "double")) {
                System.err.println("Error: must be a Double.");
                error = true;
            } else {
                error = false;
            }
        } while (error == true);
        return Double.parseDouble(userInp);
    }
    
    public static Boolean isDouble(String testStr, String type) {
        try {
            if (type.equalsIgnoreCase("double")) {
                Double.parseDouble(testStr);
            }
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    
    public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
}
}