/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/**
 *
 * @author User
 */
public class FioreFlowershop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Product Type Data
        ProductType prodType = new ProductType();
        List<ProductType> prodTypeList = new ArrayList<ProductType>();
        prodTypeList.add(new ProductType("PT1001","Fresh Flowers","The flowers that will be wither..."));
        prodTypeList.add(new ProductType("PT1002","Bouquets","An attractively arranged bunch of flowers, especially one presented as a gift or carried at a ceremony."));
        prodTypeList.add(new ProductType("PT1003","Floral Arrangements","Flower arrangement is an organization of design and color towards creating an ambience using flowers, foliage and other floral accessories"));
        
        //Product Data
        Product prod = new Product();
        List<Product> productList = new ArrayList<Product>();
        productList.add(new Product("P1001","Flowers and Chocolates Gift","DESC...","Red",60.00,5,prodTypeList.get(0)));
        productList.add(new Product("P1002","Ladies Gift Hamper","DESC...","Red",65.00,5,prodTypeList.get(1)));
        productList.add(new Product("P1003","Christmas Treats Gift Box","DESC...","White",15.00,5,prodTypeList.get(1)));
        productList.add(new Product("P1004","Honeybee","DESC...","Yellow",30.00,5,prodTypeList.get(0)));
        productList.add(new Product("P1005","Starry Night","DESC...","Blue",45.00,5,prodTypeList.get(2)));
        
        System.out.println("Main Program");
    }
    
}
