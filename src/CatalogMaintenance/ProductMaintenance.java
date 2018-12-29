package CatalogMaintenance;

import ADT.*;
import fioreflowershop.*;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ProductMaintenance {

    public static void ProductMainMenu(ListInterface<Product> prodList, ListInterface<ProductType> prodTypeList, ListInterface<Product> prodPromotionList) throws IOException{
        Scanner input = new Scanner(System.in);
        String option = "";
        do {
            do {
                System.out.println("\n*******************************\n Product Maintenance Main Menu\n*******************************");
                System.out.println("1. Product Maintenance Menu");
                System.out.println("2. Promotion Product Maintenance Menu");
                System.out.println("3. Return Main Menu");

                System.out.printf("\nOption > ");
                option = input.next();
                //Validation of User Input(Only can be digit)                
            } while (!Validation.CheckDigit(option));

            switch (Integer.parseInt(option)) {
                case 1: //Product Maintenance Menu
                    ProductMaintenanceMenu(prodList, prodTypeList);
                    break;
                case 2: //Prmotion Product Maintenance Menu
                    PromotionProductMaintenanceMenu(prodPromotionList, prodTypeList);
                    break;
                case 3: //Return Main Menu
                    System.out.print("Returning to Main Menu...");
                    System.in.read();
                    System.out.println();
                    break;
                default: //Display error message if not within the options provided
                    System.out.println(ConsoleColors.RED + "Invalid Option! Please Try Again" + ConsoleColors.RESET);
                    System.out.print("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        } while (Integer.parseInt(option) != 3);
    }
    
    public static void ProductMaintenanceMenu(ListInterface<Product> prodList, ListInterface<ProductType> prodTypeList) throws IOException {
        Scanner input = new Scanner(System.in);

        Product prod = new Product();
        String option = "";
        String options = "";
        
        Boolean checkDigit = false;
        boolean test = false;
        do {
            do {
                ProductOutOfStockNotification(prodList, prodTypeList);
                System.out.println("\n*********************\n Product Maintenance \n*********************");
                System.out.println("1. Register New Product");
                System.out.println("2. Display Current Product List");
                System.out.println("3. Maintain Product Information");
                System.out.println("4. Return Product Maintenance Main Menu");

                System.out.printf("\nOption > ");
                option = input.next();
                //Validation of User Input(Only can be digit)                
            } while (!Validation.CheckDigit(option));

            switch (Integer.parseInt(option)) {
                case 1: //Register new product
                    String info = "**********************\n Register New Product \n**********************";
                    System.out.println(info);
                    //Assign new product id
                    String newProdID = "P" + (Integer.parseInt(prodList.get(prodList.size() - 1).getProductID().substring(1, 5)) + 1);

                    //Return the new product by assigning the product id, product type list, and access level
                    //access level = 0 which is for add new product; access level = 1 which is for add new promotion product
                    prod = RegisterNewProduct(newProdID, prodTypeList, 0);
                    if (prod != null) {
                        prodList.add(prod); //add the new product into the product list
                        //display the message in green color to notify user the new product has added sucessfully
                        System.out.print(ConsoleColors.GREEN + "Add New Product Successfully!\n\n" + ConsoleColors.RESET);
                        System.out.print("Enter Any Key Return to Product Menu...");
                        System.in.read(); //Pause it, to let user enter any key to continue the process
                        input.nextLine();
                    } else {
                        System.err.println("Failed to Register New Product!"); //error message if the new product is null
                    }
                    break;
                case 2: //Display Current Product List
                    boolean exit = false;
                    //if the user would like to exit, then return the exit = true
                    //Call the ViewProductList method to view the current product list
                    exit = ViewProductList(prodList, prodTypeList);
                    if (exit) {
                        System.out.print("\nEnter Any Key Return to Product Menu...");
                        System.in.read();
                    }
                    break;
                case 3: //Maintain Product Information
                    test = false;
                    boolean returnMenu = false;
                    do {
                        returnMenu = false;
                        do {
                            System.out.print("\n***************************\n Current Product Type List \n***************************\n");
                            //Display Current Product Type List
                            for (int r = 0; r < prodTypeList.size(); r++) {
                                System.out.println((r + 1) + ". " + prodTypeList.get(r).getProductTypeName());
                            }
                            System.out.println((prodTypeList.size() + 1) + ". Return Product Maintenance Menu");
                            System.out.printf("\nSelect Product Type > ");
                            options = input.next();
                        } while (!Validation.CheckDigit(options + 1)); //Validation.CheckDigit: check whether the options is in digit or not

                        //options+1 = Return Product Maintenance Menu
                        if (Integer.parseInt(options) == prodTypeList.size() + 1) {
                            returnMenu = true;
                        }

                        //Check if the options is within the size of the product type list or not
                        //If not then display error message
                        if (Integer.parseInt(options) <= 0 || Integer.parseInt(options) > prodTypeList.size() + 1) {
                            System.out.println(ConsoleColors.RED + "Input Out of Range! Please Enter Again" + ConsoleColors.RESET);
                            System.in.read();
                            test = false;
                        } else {
                            test = true;
                        }
                    } while (!test); //Continue until the input is within the size of the product type list

                    Boolean check = false;
                    int num = 0;
                    test = false;
                    int index = 0;
                    String optionss = "";

                    if (!returnMenu) {
                        do {
                            int[] position = new int[100];
                            index = 0;
                            num = 0;
                            test = false;
                            do {
                                num = 0; //Display option for user enter (eg. 1. XXX)
                                System.out.print("\n***********************\n Current Product List \n***********************\n");
                                for (int r = 0; r < prodList.size(); r++) {
                                    if (prodList.get(r).getProductType().equals(prodTypeList.get(Integer.parseInt(options) - 1))) {
                                        System.out.println(++num + "." + prodList.get(r).getProductName());
                                        //Store the selected product index which according to the product type list that user selected  
                                        position[index] = r;
                                        index++;
                                    }
                                }
                                System.out.println((num + 1) + " Return Product Maintenance Menu");//num+1 = Return Product Maintenance Menu
                                System.out.printf("\nOption > ");
                                optionss = input.next();

                            } while (!Validation.CheckDigit(optionss)); //Check whether the optionss is in integer or not
                            if (Integer.parseInt(optionss) == index + 1) { //index+1 = return.
                                break;
                            }

                            //Check if the optionss is within the size of the product list or not
                            //If not then display error message
                            if (Integer.parseInt(optionss) <= 0 || Integer.parseInt(optionss) > index) {
                                System.out.println(ConsoleColors.RED + "Input Out of Range! Please Enter Again" + ConsoleColors.RESET);
                                System.in.read();
                                test = false;
                            } else {
                                test = true;
                                //MaintainProduct(prodList.get(position[Integer.parseInt(optionss) - 1]) 
                                //= Update the specified product in the product list according to the user selected
                                Product maintainProduct = MaintainProduct(prodList.get(position[Integer.parseInt(optionss) - 1]),prodTypeList);
                                prodList.set(0, maintainProduct);
                                
                                
                                System.out.printf("Enter Any Key Return to Product Menu...");
                                System.in.read();
                                input.nextLine();
                                break;
                            }
                        } while (!test);
                    }
                    break;
                case 4:
                    break; //Return to main menu
                default: //Display error message if not within the options provided
                    System.out.println(ConsoleColors.RED + "Invalid Option! Please Try Again" + ConsoleColors.RESET);
                    System.out.print("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        } while (Integer.parseInt(option) != 4);
    }

    public static void PromotionProductMaintenanceMenu(ListInterface<Product> prodPromotionList, ListInterface<ProductType> prodTypeList) throws IOException {
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        Product promotionProd = new Product();
        String option = "";
        String options = "";
        StackInterface<Product> stackPromotion = new LinkedStack<Product>();

        Boolean checkDigit = false;
        boolean test = false;
        do {
            do {
                System.out.println("\n*******************************\n Promotion Product Maintenance \n*******************************");
                System.out.println("1. Register New Promotion Product");
                System.out.println("2. Display Current Promotion Product List");
                System.out.println("3. Maintain Promotion Product Information");  
                System.out.println("4. Remove Out-of-Stock Promotion Products");
                System.out.println("5. Return Product Maintenance Main Menu");

                System.out.printf("\nOption > ");
                option = input.next();
                //Validation of User Input(Only can be digit)    
            } while (!Validation.CheckDigit(option));

            switch (Integer.parseInt(option)) {
                case 1: //Register new promotion product
                    //Assign new product id
                    String newProdID = "PM" + (Integer.parseInt(prodPromotionList.get(prodPromotionList.size() - 1).getProductID().substring(2, 6)) + 1); //
                    String info = "********************************\n Register New Promotion Product \n********************************";
                    System.out.println(info);

                    //Return the new promotion product by assigning the product id, product type list, and access level
                    //access level = 0 which is for add new product; access level = 1 which is for add new promotion product
                    promotionProd = RegisterNewProduct(newProdID, prodTypeList, 1);
                    if (promotionProd != null) {
                        prodPromotionList.add(promotionProd);//add the new product into the product list
                        //display the message in green color to notify user the new product has added sucessfully
                        System.out.print(ConsoleColors.GREEN + "Add New Promotion Product Successfully!\n\n" + ConsoleColors.RESET);
                        System.out.print("Enter Any Key Return to Product Menu...");
                        System.in.read();
                        input.nextLine();
                    } else {
                        System.out.println("Failed to Register New Product!");
                    }
                    break;
                case 2: //Display Current Promotion Product List
                    boolean found;
                    //if the user would like to exit, then return the exit = true
                    //Call the ViewPromotionProductList method to view the current product list
                    found = ViewPromotionProductList(prodPromotionList, prodTypeList);

                    if (!found) {
                        System.out.println(ConsoleColors.RED + "\nNo Current Promotion Product List" + ConsoleColors.RESET);
                    }

                    System.out.print("\nEnter Any Key Return to Promotion Product Menu...");
                    System.in.read();
                    break;
                case 3: //Maintain Promotion Product
                    String selectPromoMonth = "";
                    boolean checkMonth = true;
                    do {
                        selectPromoMonth = "";
                        checkMonth = true;
                        do {
                            do{
                            System.out.print("Enter Promotion Month (eg. 1 = Jan): ");
                            selectPromoMonth = scan.nextLine();
                            
                            if(selectPromoMonth.equals("")){
                                System.out.print(ConsoleColors.RED + "Promotion Month Cannot Be Empty" + ConsoleColors.RESET);
                                System.in.read();
                                System.out.println();
                            }
                        }while(selectPromoMonth.equals(""));
                        } while (!Validation.CheckDigit(selectPromoMonth)); //Check whether the user input in digit or not

                        //Compare the user input with the month; Check whether is the valid month or not
                        switch (Integer.parseInt(selectPromoMonth)) {
                            case 1:
                                selectPromoMonth = "JANUARY";
                                break;
                            case 2:
                                selectPromoMonth = "FEBRUARY";
                                break;
                            case 3:
                                selectPromoMonth = "MARCH";
                                break;
                            case 4:
                                selectPromoMonth = "APRIL";
                                break;
                            case 5:
                                selectPromoMonth = "MAY";
                                break;
                            case 6:
                                selectPromoMonth = "JUNE";
                                break;
                            case 7:
                                selectPromoMonth = "JULY";
                                break;
                            case 8:
                                selectPromoMonth = "AUGUST";
                                break;
                            case 9:
                                selectPromoMonth = "SEPTEMBER";
                                break;
                            case 10:
                                selectPromoMonth = "OCTORBER";
                                break;
                            case 11:
                                selectPromoMonth = "NOVEMBER";
                                break;
                            case 12:
                                selectPromoMonth = "DECEMBER";
                                break;
                            default: //Display error message
                                System.err.println("Error: Input out of Range!\n");
                                checkMonth = false;
                        }
                    } while (!checkMonth);

                    System.out.println("\nMonthly Promotion: " + ConsoleColors.RED + selectPromoMonth + ConsoleColors.RESET);

                    int no = 0;
                    found = false;
                    //Check whether the current promotion product is same with the user input month
                    for (int r = 0; r < prodPromotionList.size(); r++) {
                        if (prodPromotionList.get(r).getProductPromotionMonth().equals(selectPromoMonth)) {
                            found = true; //found the promotion product which same with the user input month
                        }
                    }

                    test = false;

                    Boolean check = false;
                    int num = 0;
                    test = false;
                    int[] position = new int[100];
                    int index = 0;
                    String optionss = "";

                    do {
                        index = 0;
                        num = 0;
                        test = false;
                        do {
                            System.out.print("\n*******************************\n Current Promotion Product List \n*******************************\n");
                            for (int r = 0; r < prodPromotionList.size(); r++) {
                                if (prodPromotionList.get(r).getProductPromotionMonth().equals(selectPromoMonth)) {
                                    System.out.println(++num + "." + prodPromotionList.get(r).getProductName());
                                    //Store the selected prmotion product index which according to the promotion month that user selected  
                                    position[index] = r;
                                    index++;
                                }
                            }
                            //num+1 = Return Product Maintenance Menu
                            System.out.println((num + 1) + " Return Product Maintenance Menu");
                            System.out.printf("\nOption > ");
                            optionss = input.next();

                        } while (!Validation.CheckDigit(optionss));
                        if (Integer.parseInt(optionss) == index + 1) {
                            break;
                        }
                        //Check if the optionss is within the size of the product list or not
                        //If not then display error message
                        if (Integer.parseInt(optionss) <= 0 || Integer.parseInt(optionss) > index) {
                            System.out.println(ConsoleColors.RED + "Input Out of Range! Please Enter Again" + ConsoleColors.RESET);
                            System.in.read();
                            test = false;
                        } else {
                            test = true;

                            //MaintainProduct(prodPromotionList.get(position[Integer.parseInt(optionss) - 1]) 
                            //= Update the specified product in the product list according to the user selected
                            Product maintainPromotionProduct = MaintainProduct(prodPromotionList.get(position[Integer.parseInt(optionss) - 1]), prodTypeList);
                            prodPromotionList.set(0, maintainPromotionProduct);
                            System.out.printf("Enter Any Key Return to Product Menu...");
                            System.in.read();
                            input.nextLine();
                        }
                    } while (!test);
                    break;
                case 4: //Remove Out-of-Stock Promotion Products
                    RemoveOutOfStockPromotionProduct(prodPromotionList, stackPromotion);
                    break;
                case 5: //Return to main menu
                    break;
                default://Display error message if not within the options provided
                    System.out.println(ConsoleColors.RED + "Invalid Option! Please Try Again" + ConsoleColors.RESET);
                    System.out.print("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        } while (Integer.parseInt(option) != 5);
    }

    public static boolean ViewProductList(ListInterface<Product> prodList, ListInterface<ProductType> prodTypeList) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean check = false;
        String options = "";
        boolean exit = false;
        String selectedProdType = "";
        do {
            do {
                System.out.print("\n***************************\n Current Product Type List \n***************************\n");
                for (int r = 0; r < prodTypeList.size(); r++) { //Display all the current product type list
                    System.out.println((r + 1) + ". " + prodTypeList.get(r).getProductTypeName());
                }
                System.out.println((prodTypeList.size() + 1) + ". Display All Current Product List");
                System.out.println((prodTypeList.size() + 2) + ". Return Product Maintenance Menu");
                System.out.printf("\nSelect Product Type > ");
                options = input.next();
                //Check whether the input is in digit or not; option + 1 = return to the product maintenance menu
            } while (!Validation.CheckDigit(options));

            if (Integer.parseInt(options) == prodTypeList.size() + 1) {
                System.out.println("############################################################################################################################################");
                System.out.println(ConsoleColors.BLUE + "Product ID\tName\t\t\t\tDescription\t\tColor\t\tPrice\t\tQuantity\tType Name" + ConsoleColors.RESET);
                System.out.println("############################################################################################################################################");
                for (int r = 0; r < prodList.size(); r++) {
                    System.out.printf("%-10s\t%-30s\t%-20s\t%-10s\tRM%6.2f\t   %-10d\t%-20s\n",
                            prodList.get(r).getProductID(), prodList.get(r).getProductName(), prodList.get(r).getProductDesc(),
                            prodList.get(r).getProductColor(), prodList.get(r).getProductPrice(), prodList.get(r).getProductQuantity(),
                            prodList.get(r).getProductType().getProductTypeName());
                }
                
                return exit = true;
            } //after display then exit 
            
            if (Integer.parseInt(options) == prodTypeList.size() + 2) {
                return exit = true;
            } //exit to main menu

            //Check whether the input is between the product type list or not
            if (Integer.parseInt(options) <= 0 || Integer.parseInt(options) > prodTypeList.size() + 2) {
                System.out.printf(ConsoleColors.RED + "Input Out of Range! Please Enter Again" + ConsoleColors.RESET);
                System.in.read();
                System.out.println();
                check = false; // if out of range return false and keep looping until the input is correct
            } else {
                check = true; //if within the range return true and exit the do while loop
            }
        } while (!check);

        int no = 0;
        boolean found = false;
        int asd = prodList.size();
        for (int r = 0; r < prodList.size(); r++) { //Compare whether the user input (product type) is valid in the list or not
            if (prodList.get(r).getProductType().equals(prodTypeList.get(Integer.parseInt(options) - 1))) {
                selectedProdType = prodList.get(r).getProductType().getProductTypeName();
                found = true; //if valid return true
            }
        }

        if (found) { //if true; display the product details according to the selected product type
            System.out.println("\nSelected Product Type: " + ConsoleColors.RED + selectedProdType + ConsoleColors.RESET);
            System.out.println("####################################################################################################################");
            System.out.println(ConsoleColors.BLUE + "Product ID\tName\t\t\t\tDescription\t\tColor\t\tPrice\t\tQuantity" + ConsoleColors.RESET);
            System.out.println("####################################################################################################################");
            for (int r = 0; r < prodList.size(); r++) {
                if (prodList.get(r).getProductType().getProductTypeName().equals(selectedProdType)){
                    System.out.printf("%-10s\t%-30s\t%-20s\t%-10s\tRM%6.2f\t   %-10d\n",
                            prodList.get(r).getProductID(), prodList.get(r).getProductName(), prodList.get(r).getProductDesc(),
                            prodList.get(r).getProductColor(), prodList.get(r).getProductPrice(), prodList.get(r).getProductQuantity());
                    exit = true; //after display exit set to true
                }
            }
        } else {
            System.out.println(ConsoleColors.RED + "\nNo Current Product List" + ConsoleColors.RESET);
            exit = true; //if not found then display error message and exit = true
        }

        return exit;
    }

    public static boolean ViewPromotionProductList(ListInterface<Product> prodPromotionList, ListInterface<ProductType> prodTypeList) throws IOException {
        Scanner input = new Scanner(System.in);
        String selectPromoMonth = "";
        boolean checkMonth = true, found = false;
        String option="";
        do {
            do {
                System.out.println("\n****************************\n Display Promotion Products\n****************************");
                System.out.println("1. Promotion Products in Month");
                System.out.println("2. All Promotion Products");
                System.out.println("3. Return Promotion Products Menu");

                System.out.printf("\nOption > ");
                option = input.next();
                //Validation of User Input(Only can be digit)                
            } while (!Validation.CheckDigit(option));

            switch (Integer.parseInt(option)) {
                case 1: //Display Promotion Product in Month
                    do {
                        selectPromoMonth = "";
                        checkMonth = true;
                        do {
                            System.out.print("\nEnter Promotion Month (eg. 1 = Jan): ");
                            selectPromoMonth = input.next();
                            //Check the user input only in digit
                        } while (!Validation.CheckDigit(selectPromoMonth));
                        System.out.println();
                        switch (Integer.parseInt(selectPromoMonth)) {
                            case 1:
                                selectPromoMonth = "JANUARY";
                                break;
                            case 2:
                                selectPromoMonth = "FEBRUARY";
                                break;
                            case 3:
                                selectPromoMonth = "MARCH";
                                break;
                            case 4:
                                selectPromoMonth = "APRIL";
                                break;
                            case 5:
                                selectPromoMonth = "MAY";
                                break;
                            case 6:
                                selectPromoMonth = "JUNE";
                                break;
                            case 7:
                                selectPromoMonth = "JULY";
                                break;
                            case 8:
                                selectPromoMonth = "AUGUST";
                                break;
                            case 9:
                                selectPromoMonth = "SEPTEMBER";
                                break;
                            case 10:
                                selectPromoMonth = "OCTORBER";
                                break;
                            case 11:
                                selectPromoMonth = "NOVEMBER";
                                break;
                            case 12:
                                selectPromoMonth = "DECEMBER";
                                break;
                            default:
                                //if invalid input display error message
                                System.err.println("Error: Input out of Range!");
                                checkMonth = false;
                        }
                        //Check until the user input valid month in digit
                    } while (!checkMonth);

                    int no = 0;
                    found = false;
                    //Check whether the current promotion product list exist of the user input month or not
                    for (int r = 0; r < prodPromotionList.size(); r++) {
                        if (prodPromotionList.get(r).getProductPromotionMonth().equals(selectPromoMonth)) {
                            found = true; //if found = true
                        }
                    }

                    if (found) { //if found in the promotion product list; Display the product details according to the input month
                        System.out.print("********************************\n Current Promotion Product List \n********************************\n");
                        System.out.println("\nMonthly Promotion: " + ConsoleColors.RED + selectPromoMonth + ConsoleColors.RESET);
                        System.out.println("############################################################################################################################################");
                        System.out.println(ConsoleColors.BLUE + "Product ID\tName\t\t\t\tDescription\t\tColor\t\tPrice\t\tQuantity\tType Name" + ConsoleColors.RESET);
                        System.out.println("############################################################################################################################################");
                        for (int r = 0; r < prodPromotionList.size(); r++) {
                            if (prodPromotionList.get(r).getProductPromotionMonth().equals(selectPromoMonth)) {
                                System.out.printf("%-10s\t%-30s\t%-20s\t%-10s\tRM%6.2f\t   %-10d\t%-20s\n",
                                        prodPromotionList.get(r).getProductID(), prodPromotionList.get(r).getProductName(), prodPromotionList.get(r).getProductDesc(),
                                        prodPromotionList.get(r).getProductColor(), prodPromotionList.get(r).getProductPrice(), prodPromotionList.get(r).getProductQuantity(),
                                        prodPromotionList.get(r).getProductType().getProductTypeName());
                            }
                        }
                    }
                    System.out.print("\nPlease Enter Any Key to Proceed...");
                    System.in.read();
                    break;
                case 2: //Display all promotion products
                    found=true;
                    System.out.print("********************************\n Current Promotion Product List \n********************************\n");
                    System.out.println("##################################################################################################################################################################");
                    System.out.println(ConsoleColors.BLUE + "Product ID\tName\t\t\t\tDescription\t\tColor\t\tPrice\t\tQuantity\tType Name\t\tPromotion Month" + ConsoleColors.RESET);
                    System.out.println("##################################################################################################################################################################");
                    for (int r = 0; r < prodPromotionList.size(); r++) {
                        System.out.printf("%-10s\t%-30s\t%-20s\t%-10s\tRM%6.2f\t   %-10d\t%-20s\t%-20s\n",
                                prodPromotionList.get(r).getProductID(), prodPromotionList.get(r).getProductName(), prodPromotionList.get(r).getProductDesc(),
                                prodPromotionList.get(r).getProductColor(), prodPromotionList.get(r).getProductPrice(), prodPromotionList.get(r).getProductQuantity(),
                                prodPromotionList.get(r).getProductType().getProductTypeName(),prodPromotionList.get(r).getProductPromotionMonth());
                    }
                    System.out.print("\nPlease Enter Any Key to Proceed...");
                    System.in.read();
                    break;
                case 3: //Return Main Menu
                    found=true;
                    break;
                default: //Display error message if not within the options provided
                    System.out.println(ConsoleColors.RED + "Invalid Option! Please Try Again" + ConsoleColors.RESET);
                    System.out.print("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        } while (Integer.parseInt(option) != 3);

        return found;
    }

    public static void ProductOutOfStockNotification(ListInterface<Product> prodList, ListInterface<ProductType> prodTypeList) {
        if (!prodList.isEmpty()) { // if the current product list is not empty
            for (int r = 0; r < prodList.size(); r++) { //display all the product details in dialog which product is almost out of stock
                if (prodList.get(r).getProductQuantity() < 5) {
                    JOptionPane.showMessageDialog(null, "Product Type  : " + prodList.get(r).getProductType().getProductTypeID() + " " + prodList.get(r).getProductType().getProductTypeName() + "\nProduct ID        : " + prodList.get(r).getProductID() + "\nProduct Name : " + prodList.get(r).getProductName() + "\nProduct Color  : " + prodList.get(r).getProductColor() + "\nIn-Stock Qty     : " + prodList.get(r).getProductQuantity(), "InfoBox: " + "Product Out Of Stock Notification", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

    public static void RemoveOutOfStockPromotionProduct(ListInterface<Product> prodPromotionList, StackInterface<Product> productStackList) throws IOException {
        Scanner input = new Scanner(System.in);
        String continue1;
        boolean continueRemove = false;
        do {
            continueRemove = false;
            boolean checkID = false;
            int count=0;
            
            System.out.printf("\n" + ConsoleColors.RED + "%90s" + ConsoleColors.RESET, "Current Out of Stock Promotion Product");
            System.out.println("\n###################################################################################################################################################################");
            System.out.println(ConsoleColors.BLUE + "Product ID\tName\t\t\t\tDescription\t\tColor\t\tPrice\t\tQuantity\tType Name\t\tPromotion Month" + ConsoleColors.RESET);
            System.out.println("###################################################################################################################################################################");
            if (!prodPromotionList.isEmpty()) { // if the current promotion product list is not empty
                for (int r = 0; r < prodPromotionList.size(); r++) {
                    if (prodPromotionList.get(r).getProductQuantity() <= 0) {
                        System.out.printf("%-10s\t%-30s\t%-20s\t%-10s\tRM%6.2f\t   %-10d\t%-20s\t%-20s\n",
                                prodPromotionList.get(r).getProductID(), prodPromotionList.get(r).getProductName(), prodPromotionList.get(r).getProductDesc(),
                                prodPromotionList.get(r).getProductColor(), prodPromotionList.get(r).getProductPrice(), prodPromotionList.get(r).getProductQuantity(),
                                prodPromotionList.get(r).getProductType().getProductTypeName(), prodPromotionList.get(r).getProductPromotionMonth());
                        count++;
                    }
                }
            }else{
                System.out.println(ConsoleColors.RED + "Current No Out-of-Stock Promotion Product." + ConsoleColors.RESET);
                System.out.print("\nReturning to Maintain Product Page...");
                System.in.read();
                System.out.println();
                return;
            }

            do {
                checkID = false;
                if (!prodPromotionList.isEmpty()) { // if the current promotion product list is not empty
                    for (int r = 0; r < prodPromotionList.size(); r++) {
                        if (prodPromotionList.get(r).getProductQuantity() == 0) {
                            productStackList.push(prodPromotionList.get(r)); //if those promotion product is out of stock        
                        }
                    }
                    
                    if (!productStackList.isEmpty()) {
                        String proceed = "";
                        String toRemovePromoProdID = "";
                        String promoProdID="";
                        
                        if(count==0){
                            System.out.println(ConsoleColors.RED + "Current No Out-of-Stock Promotion Product." + ConsoleColors.RESET);
                            System.out.print("\nReturning to Maintain Product Page...");
                            System.in.read();
                            System.out.println();
                            return;
                        }

                        System.out.print("\nEnter Promotion Product ID to Remove: ");
                        promoProdID = input.nextLine();
                        
                        promoProdID = promoProdID.toUpperCase();
                            
                        for (int r = 0; r < count; r++) {

                            toRemovePromoProdID = productStackList.pop().getProductID(); //obtain the toRemove Promotion Product ID
                            
                            if (promoProdID.equals(toRemovePromoProdID)) { // if the promProdID is match with the pop out product promo id
                                checkID = true;

                                do { //Confirmation of removing the promotion product. y=remove;n=remains unchanged
                                    System.out.print("Are you sure want to remove? (Y/N): ");
                                    proceed = input.nextLine();
                                    if (Validation.CheckAlphabetic(proceed)) {
                                        proceed = proceed.toUpperCase();
                                    }
                                } while (!proceed.equals("Y") && !proceed.equals("N"));

                                if (proceed.equals("Y")) { //remove the promotion product
                                    for (int i = 0; i < prodPromotionList.size(); i++) {
                                        if (prodPromotionList.get(i).getProductID().equals(toRemovePromoProdID)) {
                                            prodPromotionList.remove(i); //remove the specified position of the promotion product
                                            
                                            for(int g=i;g<prodPromotionList.size();g++){ //To change the promotion product id
                                                //eg. remove PM1002; change the product id from PM1003 to PM1002 and etc...
                                                int newPromoID = Integer.parseInt(prodPromotionList.get(g).getProductID().substring(2, 6))-1;
                                                prodPromotionList.get(g).setProductID("PM" + newPromoID);
                                            }
                                        }
                                    }

                                    System.out.print(ConsoleColors.GREEN + "Remove Promotion Product ID: " + toRemovePromoProdID + " Successfully" + ConsoleColors.RESET);
                                    System.in.read();
                                    break;
                                } else { //return to Remove Promotion Product Menu
                                    break;
                                }
                            } else {
                                checkID = false; //invalid input or promotion product not found
                            }
                        }
                    } else{ //Display none out-of-stock promotion product message
                        System.out.println(ConsoleColors.RED + "Current No Out-of-Stock Promotion Product." + ConsoleColors.RESET);
                        System.out.print("\nReturning to Maintain Product Page...");
                        System.in.read();
                        System.out.println();
                        return;    
                    } 
                    if (!checkID) {
                        System.out.print(ConsoleColors.RED + "No Such Promotion Product ID!" + ConsoleColors.RESET);
                        System.in.read();
                        break;
                    }
                }
            } while (!checkID);
            do { //Confirmation of updating the product name. y=update;n=remains unchanged
                System.out.print("\nContinue to remove? (Y/N): ");
                continue1 = input.nextLine();
                if (Validation.CheckAlphabetic(continue1)) {
                    continue1 = continue1.toUpperCase();
                }
            } while (!continue1.equals("Y") && !continue1.equals("N"));

            if (continue1.equals("N")) { //return to maintain product page
                ReturnMaintainProductPage();
                continueRemove = false;
                break;
            } else {
                continueRemove = true;
            }
        } while (continueRemove); //if the wants to proceed remove out-of-stock promotion product
    }

    public static Product RegisterNewProduct(String newProdID, ListInterface<ProductType> prodTypeList, int access) throws IOException {
        Scanner input = new Scanner(System.in);
        Boolean status = false;
        String prodName = "", prodDesc = "", prodColor = "", prodPrice = "", prodQty = "", options = "", promoMonth = "";
        do {
            if (access == 1) { //access level 1 = regsiter new promotion product
                boolean checkMonth = true;
                do {
                    checkMonth = true;
                    do { //input month in digit
                        do{
                            System.out.print("Enter Promotion Month (eg. 1 = Jan): ");
                            promoMonth = input.nextLine();
                            
                            if(promoMonth.equals("")){
                                System.out.print(ConsoleColors.RED + "Promotion Month Cannot Be Empty" + ConsoleColors.RESET);
                                System.in.read();
                                System.out.println();
                            }
                        }while(promoMonth.equals(""));
                    } while (!Validation.CheckDigit(promoMonth));

                    switch (Integer.parseInt(promoMonth)) {
                        case 1:
                            promoMonth = "JANUARY";
                            break;
                        case 2:
                            promoMonth = "FEBRUARY";
                            break;
                        case 3:
                            promoMonth = "MARCH";
                            break;
                        case 4:
                            promoMonth = "APRIL";
                            break;
                        case 5:
                            promoMonth = "MAY";
                            break;
                        case 6:
                            promoMonth = "JUNE";
                            break;
                        case 7:
                            promoMonth = "JULY";
                            break;
                        case 8:
                            promoMonth = "AUGUST";
                            break;
                        case 9:
                            promoMonth = "SEPTEMBER";
                            break;
                        case 10:
                            promoMonth = "OCTORBER";
                            break;
                        case 11:
                            promoMonth = "NOVEMBER";
                            break;
                        case 12:
                            promoMonth = "DECEMBER";
                            break;
                        default:
                            System.err.println("Error: Input out of Range!");
                            checkMonth = false;
                    }
                } while (!checkMonth); //while the month is valid then exit the do while
                System.out.println("\nCreating Monthly Promotion: " + ConsoleColors.RED + promoMonth + ConsoleColors.RESET);
            }
            //For both add new product or promotion product
            System.out.println("Product ID: " + ConsoleColors.BLUE + newProdID + ConsoleColors.RESET);

            do{
                System.out.print("Product Name: ");
                prodName = input.nextLine();
                
                if (prodName.equals("")) {
                    System.out.print(ConsoleColors.RED + "Product Name Cannot Be Empty" + ConsoleColors.RESET);
                    System.in.read();
                    System.out.println();
                }
            }while(prodName.equals(""));
            
            do{
                System.out.print("Product Description: ");
                prodDesc = input.nextLine();
                
                if (prodDesc.equals("")) {
                    System.out.print(ConsoleColors.RED + "Product Description Cannot Be Empty" + ConsoleColors.RESET);
                    System.in.read();
                    System.out.println();
                }
            }while(prodDesc.equals(""));
            
            do { //Check the input color in alphabetic only since the color dont have integer 
                do{
                    System.out.print("Product Color: ");
                    prodColor = input.nextLine();

                    if (prodColor.equals("")) {
                        System.out.print(ConsoleColors.RED + "Product Description Cannot Be Empty" + ConsoleColors.RESET);
                        System.in.read();
                        System.out.println();
                    }
                }while(prodColor.equals(""));
            } while (!Validation.CheckAlphabetic(prodColor));

            //Provide user to input the product price in double 
            //(Validation.askInputDouble("Product Price: RM ") will return double value
            do{
                prodPrice = "" + Validation.askInputDouble("Product Price: RM ");
                if(Double.parseDouble(prodPrice)<=0){
                    System.out.println(ConsoleColors.RED + "Minimum Product Price: RM 1.00" + ConsoleColors.RESET);
                }
            }while(Double.parseDouble(prodPrice)<=0);

            do{
                do {//Check the product quantity only in digit
                    do{
                        System.out.print("Product Quantity: ");
                        prodQty = input.nextLine();
                        
                        if (prodQty.equals("")) {
                            System.out.print(ConsoleColors.RED + "Product Quantity Cannot Be Empty" + ConsoleColors.RESET);
                            System.in.read();
                            System.out.println();
                        }
                    }while(prodQty.equals(""));
                } while (!Validation.CheckDigit(prodQty));
                if (Integer.parseInt(prodQty)< 1) { //check quantity cannot less than 1
                    System.out.println(ConsoleColors.RED + "Minimum Product Quantity: 1" + ConsoleColors.RESET);
                    System.out.println();
                }
            }while (Integer.parseInt(prodQty)< 1);
            
            boolean test = false;
            do { // display the current product type list for user to select
                do {
                    System.out.print("\n***************************\n Current Product Type List \n***************************\n");
                    for (int r = 0; r < prodTypeList.size(); r++) {
                        System.out.println((r + 1) + "." + prodTypeList.get(r).getProductTypeName());
                    }

                    System.out.printf("\nSelect Product Type > ");
                    options = input.next();
                    //Only the product type within the list will be accepted and the options must in digit
                } while (!Validation.CheckDigit(options));

                //Check whether the user input product type is within the product type list or not
                if (Integer.parseInt(options) <= 0 || Integer.parseInt(options) > prodTypeList.size()) {
                    System.out.print(ConsoleColors.RED + "Input Out of Range! Please Enter Again" + ConsoleColors.RESET);
                    System.in.read();
                    test = false; //if out of range; display error message
                } else {
                    test = true; //if within the range; test = true for proceed
                }
            } while (!test);

            //if the user did not input anything, this will required the user to input again start from the top to bottom
            if (prodName.equals("") || prodDesc.equals("") || prodDesc.equals("") || prodColor.equals("") || prodPrice.equals("") || prodQty.equals("")) {
                System.out.println(ConsoleColors.RED + "\nSystem Notification: All fields must be filled in!" + ConsoleColors.RESET);
                System.out.println("Enter Any Key Return to Register Form\n");
                System.in.read();
                status = false; //if is empty; return false
            } else {
                status = true; //if not empty; return true
            }
        } while (!status);
        //Return the new product object to the main menu; in order to add the new product into the product list
        return new Product(newProdID, prodName, prodDesc, prodColor, Double.parseDouble(prodPrice), Integer.parseInt(prodQty), prodTypeList.get(Integer.parseInt(options) - 1), promoMonth);
    }

    public static Product MaintainProduct(Product updateProduct, ListInterface<ProductType> prodTypeList) throws IOException {
        Scanner input = new Scanner(System.in);
        String option = "";

        do {
            do {
                //display the selected product that specified by the user (updateProduct) at the main menu
                System.out.println("******************\n Maintain Product \n******************");

                System.out.println("Selected Product Type: " + ConsoleColors.RED + updateProduct.getProductType().getProductTypeName() + ConsoleColors.RESET);
                System.out.println("####################################################################################################################");
                System.out.println(ConsoleColors.BLUE + "Product ID\tName\t\t\t\tDescription\t\tColor\t\tPrice\t\tQuantity" + ConsoleColors.RESET);
                System.out.println("####################################################################################################################");
                System.out.printf("%-10s\t%-30s\t%-20s\t%-10s\tRM%6.2f\t   %-10d\n",
                        updateProduct.getProductID(), updateProduct.getProductName(), updateProduct.getProductDesc(),
                        updateProduct.getProductColor(), updateProduct.getProductPrice(), updateProduct.getProductQuantity());
                System.out.println("####################################################################################################################");
                //The user can update all the product details as below:
                System.out.println("1. Product Name");
                System.out.println("2. Product Description");
                System.out.println("3. Product Color");
                System.out.println("4. Product Price");
                System.out.println("5. Product Quantity");
                System.out.println("6. Product Type");
                System.out.println("7. Return Product Menu");

                System.out.printf("\nOption > ");
                option = input.next();
                //Check the input is in digit or not
            } while (!Validation.CheckDigit(option));

            Scanner scan = new Scanner(System.in);
            String proceed="";
            switch (Integer.parseInt(option)) { //Check the user input is within the range or not
                case 1: //update product name
                    String newProdName="";
                    do{
                        System.out.printf("Current Product Name: %s", updateProduct.getProductName());
                        System.out.print("\nEnter New Product Name: ");
                        newProdName = scan.nextLine();
                        
                        if(newProdName.equals("")){
                            System.out.print(ConsoleColors.RED + "Product Name Cannot Be Empty" + ConsoleColors.RESET);
                            System.in.read();
                            System.out.println();
                        }
                    }while(newProdName.equals(""));

                    //Confirmation of updating the product name. y=update;n=remains unchanged
                    proceed = ConfirmProceed(proceed, input); 

                    if (proceed.equals("Y")) { //update product name
                        updateProduct.setProductName(newProdName);
                        System.out.print(ConsoleColors.GREEN + "Update Product Name Successfully!" + ConsoleColors.RESET);
                        System.in.read();
                        System.out.println("\n");
                    } else {                         
                        ReturnMaintainProductPage();
                        break;
                    }
                    break;
                case 2: //update product description
                    String newProdDesc="";
                    do{
                        System.out.printf("Current Product Description: %s", updateProduct.getProductDesc());
                        System.out.print("\nEnter New Product Description: ");
                        newProdDesc = scan.nextLine();
                        
                        if(newProdDesc.equals("")){
                            System.out.print(ConsoleColors.RED + "Product Description Cannot Be Empty" + ConsoleColors.RESET);
                            System.in.read();
                            System.out.println();
                        }
                    }while(newProdDesc.equals(""));

                    //Confirmation of updating the product description. y=update;n=remains unchanged
                    proceed = ConfirmProceed(proceed, input); 

                    if (proceed.equals("Y")) {  //update product description
                        updateProduct.setProductDesc(newProdDesc);
                        System.out.print(ConsoleColors.GREEN + "Update Product Description Successfully!" + ConsoleColors.RESET);
                        System.in.read();
                        System.out.println("\n");
                    } else { //return to maintain product page
                        ReturnMaintainProductPage();
                        break;
                    }
                    break;
                case 3: //update product color
                    String newProdColor="";
                    do{
                        System.out.printf("Current Product Color: %s", updateProduct.getProductColor());
                        System.out.print("\nEnter New Product Color: ");
                        newProdColor = scan.nextLine();
                        
                        if(newProdColor.equals("")){
                            System.out.print(ConsoleColors.RED + "Product Color Cannot Be Empty" + ConsoleColors.RESET);
                            System.in.read();
                            System.out.println();
                        }
                    }while(newProdColor.equals(""));

                    //Confirmation of updating the product color. y=update;n=remains unchanged
                    proceed = ConfirmProceed(proceed, input); 

                    if (proceed.equals("Y")) { //update product color
                        updateProduct.setProductColor(newProdColor);
                        System.out.print(ConsoleColors.GREEN + "Update Product Color Successfully!" + ConsoleColors.RESET);
                        System.in.read();
                        System.out.println("\n");
                    } else { //return to maintain product page
                        ReturnMaintainProductPage();
                        break;
                    }
                    break;
                case 4: //update product price
                    Boolean checkDigit = false;
                    String newProdPrice = "";
                    
                    do{
                        System.out.printf("Current Product Price: RM %.2f\n", updateProduct.getProductPrice());
                        newProdPrice = "" + Validation.askInputDouble("Enter New Product Price: RM ");
                        System.out.println();
                        if (Double.parseDouble(newProdPrice) <= 0) {
                            System.out.println(ConsoleColors.RED + "Minimum Price: RM 1.00" + ConsoleColors.RESET + "\n");
                        }
                    } while (Double.parseDouble(newProdPrice) <= 0);     

                    //Confirmation of updating the product price. y=update;n=remains unchanged
                    proceed = ConfirmProceed(proceed, input); 

                    if (proceed.equals("Y")) { //update product price
                        updateProduct.setProductPrice(Double.parseDouble(newProdPrice));
                        System.out.print(ConsoleColors.GREEN + "Update Product Price Successfully!" + ConsoleColors.RESET);
                        System.in.read();
                        System.out.println("\n");
                    } else { //return to maintain product page
                        ReturnMaintainProductPage();
                        break;
                    }
                    break;

                case 5: //update product quantity
                    String newProdQty = "";
                    do {
                        do{
                            System.out.printf("Current Product Quantity: %2d\n", updateProduct.getProductQuantity());
                            System.out.print("Enter New Product Quantity: ");
                            newProdQty = scan.nextLine();
                            
                            if(newProdQty.equals("")){
                                System.out.print(ConsoleColors.RED + "Product Name Cannot Be Empty" + ConsoleColors.RESET);
                                System.in.read();
                                System.out.println();
                            }
                        }while(newProdQty.equals(""));
                    } while (!Validation.CheckDigit(newProdQty));

                    //Confirmation of updating the product quantity. y=update;n=remains unchanged
                    proceed = ConfirmProceed(proceed, input); 

                    if (proceed.equals("Y")) { //update product qunantity
                        updateProduct.setProductQuantity(Integer.parseInt(newProdQty));
                        System.out.print(ConsoleColors.GREEN + "Update Product Quantity Successfully!" + ConsoleColors.RESET);
                        System.in.read();
                        System.out.println("\n");
                    } else { //return to maintain product page
                        ReturnMaintainProductPage();
                        break;
                    }
                    break;
                case 6: //update product type
                    boolean test = false;
                    do {
                        test = false;
                        do {
                            System.out.print("\n***************************\n Current Product Type List \n***************************\n");
                            for (int r = 0; r < prodTypeList.size(); r++) {
                                System.out.println((r + 1) + ". " + prodTypeList.get(r).getProductTypeName());
                            }
                            System.out.println((prodTypeList.size() + 1) + ". Return to Maintain Product Page");
                            System.out.printf("\nSelect Product Type > ");
                            option = input.next();
                        } while (!Validation.CheckDigit(option));

                        if (Integer.parseInt(option) == prodTypeList.size() + 1) {
                            ReturnMaintainProductPage();
                            break;
                        }

                        if (Integer.parseInt(option) <= 0 || Integer.parseInt(option) > prodTypeList.size()) {
                            System.out.println(ConsoleColors.RED + "Input Out of Range! Please Enter Again" + ConsoleColors.RESET);
                            System.in.read();
                            test = false;
                        } else {
                            test = true;
                            proceed = ConfirmProceed(proceed, input);

                            if (proceed.equals("Y")) { //update product type
                                updateProduct.setProductType(prodTypeList.get(Integer.parseInt(option) - 1));
                                System.out.print(ConsoleColors.GREEN + "Update Product Type Successfully!" + ConsoleColors.RESET);
                                System.in.read();
                                System.out.println("\n");
                            } else { //return to maintain product page
                                ReturnMaintainProductPage();
                                break;
                            }
                        }
                    } while (!test);
                    break;
                case 7: //return to product/promotion product maintenance menu
                    break;
                default: //invalid input, display error message
                    System.out.print(ConsoleColors.RED + "Invalid Option! Please Try Again\n" + ConsoleColors.RESET);
                    System.out.printf("Please Enter Any Key to Proceed...");
                    System.in.read();
                    System.out.println();
            }
        } while (Integer.parseInt(option) != 7);
        //return updateProduct to the main menu in order to update it to the current product、promotion product list according to the user specified position
        return updateProduct;
    }

    private static String ConfirmProceed(String proceed, Scanner input) throws IOException {
        do { //Confirmation of updating the product. y=update;n=remains unchanged
            System.out.print("Are you sure want to proceed? (Y/N): ");
            proceed = input.next();
            if (Validation.CheckAlphabetic(proceed)) {
                proceed = proceed.toUpperCase();
            }
        } while (!proceed.equals("Y") && !proceed.equals("N"));
        return proceed;
    }

    private static void ReturnMaintainProductPage() throws IOException {
        //return to maintain product page
        System.out.print("Returning to Maintain Product Page...");
        System.in.read();
        System.out.println();
    }
}