/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop;
import CatalogMaintenance.ProductMaintenance;
import catalogOrder.*;
import corporatecustomer.CorporateCustomerMaintenance;
import customize.CustomizeOrder;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import order.*;

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
        List<ProductType> prodTypeList = new ArrayList<ProductType>();
        prodTypeList.add(new ProductType("PT1001","Fresh Flowers","The flowers that will be wither..."));
        prodTypeList.add(new ProductType("PT1002","Bouquets","An attractively arranged bunch of flowers, especially one presented as a gift or carried at a ceremony."));
        prodTypeList.add(new ProductType("PT1003","Floral Arrangements","Flower arrangement is an organization of design and color towards creating an ambience using flowers, foliage and other floral accessories"));
        
        //Product Data
        List<Product> prodList = new ArrayList<Product>();
        prodList.add(new Product("P1001","Flowers and Chocolates Gift","DESC...","Red",60.00,5,prodTypeList.get(0)));
        prodList.add(new Product("P1002","Ladies Gift Hamper","DESC...","Red",65.00,5,prodTypeList.get(1)));
        prodList.add(new Product("P1003","Christmas Treats Gift Box","DESC...","White",15.00,3,prodTypeList.get(1)));
        prodList.add(new Product("P1004","Honeybee","DESC...","Yellow",30.00,5,prodTypeList.get(0)));
        prodList.add(new Product("P1005","Starry Night","DESC...","Blue",45.00,5,prodTypeList.get(2)));
        
        //Customer Data
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer("C1001","Koh Liao Liao","pv16,jalan setapak","011-39958399"));
        customerList.add(new Customer("C1002","Lew Hao Hap","pv16,jalan setapak","012-7878778"));
        customerList.add(new Customer("C1003","Ong Jin Jin","pv16,jalan setapak","013-7799889"));
        
        //CorporateCustomer Data
        List<CorporateCustomer> corporateCustomerList = new ArrayList<CorporateCustomer>();
        corporateCustomerList.add(new CorporateCustomer(1000.00,0.0,"Unclear","CO1001","Lew Lew Lew","pv16,jalan setapak","011-39958399"));
        corporateCustomerList.add(new CorporateCustomer(1000.00,0.0,"Unclear","CO1002","Hao Hao Hao","pv16,jalan setapak","011-39958399"));
        corporateCustomerList.add(new CorporateCustomer(1000.00,0.0,"Unclear","CO1003","Wei Wei Wei","pv16,jalan setapak","011-39958399"));
        
        //Staff Data
        List<Staff> staffList = new ArrayList<Staff>();
        staffList.add(new Staff("S1001","Lim Yong Qi","019-7272566"));
        staffList.add(new Staff("S1002","Jimmy Chew","012-3435617"));
        staffList.add(new Staff("S1003","Cindy Lee","019-434580"));
        
        //Payment Data
        List<Payment> paymentList = new ArrayList<Payment>();
        paymentList.add(new Payment("PA1001","10-11-2018",100.0,"Paid"));
        paymentList.add(new Payment("PA1002","11-11-2018",200.0,"UnPaid"));
        paymentList.add(new Payment("PA1003","15-11-2018",100.0,"UnPaid"));
        
        //Order Data
        List<Order> orderDataList = new ArrayList<Order>();
        orderDataList.add(new Order("O1001","Give to my girlfriend ","11/11/2018","Process",customerList.get(0),paymentList.get(0),staffList.get(0),"Customer"));
        orderDataList.add(new Order("O1002","","15/11/2018","Process",customerList.get(1),paymentList.get(1),staffList.get(1),"Customer"));
        orderDataList.add(new Order("O1003","Please say happy to the receiver","15/11/2018","Process",customerList.get(2),paymentList.get(2),staffList.get(2),"Customer"));
        orderDataList.add(new Order("O1004","Please say birthday to the receiver","15/11/2018","Process",corporateCustomerList.get(2),paymentList.get(2),staffList.get(2),"Corporate"));
        orderDataList.add(new Order("O1005","Please say hi to the receiver","15/11/2018","Process",corporateCustomerList.get(1),paymentList.get(2),staffList.get(2),"Corporate"));
        orderDataList.add(new Order("O1006","Please say gg to the receiver","15/11/2018","Process",corporateCustomerList.get(0),paymentList.get(2),staffList.get(2),"Corporate"));


        //PickUp Data
        List<PickUp> pickupList = new ArrayList<PickUp>();
        pickupList.add(new PickUp("PU1001","20/11/2018","1400","20/11/2018","1410","Standby",staffList.get(0),orderDataList.get(0)));
        pickupList.add(new PickUp("PU1002","20/11/2018","1200","20/11/2018","1230","Standby",staffList.get(0),orderDataList.get(2)));
        pickupList.add(new PickUp("PU1003","21/11/2018","1500","21/11/2018","1610","Standby",staffList.get(0),orderDataList.get(0)));
        
        //Style Data
        List<Style> styleList = new ArrayList<Style>();
        styleList.add(new Style("ST1001","Standard",1.00));
        styleList.add(new Style("ST1002","Love",10.00));
        styleList.add(new Style("ST1003","Convo",20.00));
        
        //Size Data
        List<Size> sizeList = new ArrayList<Size>();
        sizeList.add(new Size("SZ1001","Small",1.00));
        sizeList.add(new Size("SZ1002","Medium",5.00));   
        sizeList.add(new Size("SZ1003","Large",10.00)); 
        sizeList.add(new Size("SZ1004","Extra Large",15.00)); 
        
        //Accessories Data
        List<Accessories> accessoriesList = new ArrayList<Accessories>();
        accessoriesList.add(new Accessories("A1001","Bear",5.00));
        accessoriesList.add(new Accessories("A1002","Ribbon",10.00));
        accessoriesList.add(new Accessories("A1003","Pokemon",20.00));
        
        List<Delivery> deliveryList = new ArrayList<Delivery>();
        deliveryList.add(new Delivery("T1101","25-20,PV16","Setapak","019-7132686","20/11/2018","1200","26/11/2018","1200","Processing",staffList.get(0),orderDataList.get(0),1));
        deliveryList.add(new Delivery("T1102","20,jalan barongan,taman berjaya","Johor","019-7788115","2/11/2018","1200","5/11/2018","1200","Processing",staffList.get(2),orderDataList.get(0),1));
        deliveryList.add(new Delivery("T1103","25-20,PV16","Setapak","019-7755115","20/11/2018","1200","11/12/2018","1200","Processing",staffList.get(1),orderDataList.get(0),1));
        
        List<OrderList> orderLL = new ArrayList<OrderList>();
        orderLL.add(new OrderList(orderDataList.get(0),prodList.get(0),2));
        orderLL.add(new OrderList(orderDataList.get(0), prodList.get(2), 1));
        orderLL.add(new OrderList(orderDataList.get(0),prodList.get(0),3));
        orderLL.add(new OrderList(orderDataList.get(1),prodList.get(4),4));
        orderLL.add(new OrderList(orderDataList.get(3),prodList.get(2),3));
        orderLL.add(new OrderList(orderDataList.get(2),prodList.get(1),5));
        orderLL.add(new OrderList(orderDataList.get(1),prodList.get(3),3));
        
        List<Customized> customizedList = new ArrayList<Customized>();
        //System.out.println("Main Program");
       //ProductMaintenance.StaffMenu(prodList, prodTypeList);
        //ProductMaintenance.CustomerViewProducts(prodList, prodTypeList);
        //ProductMaintenance.ProductOutOfStockNotification(prodList, prodTypeList);
        //orderLL = GenerateSalesOrder.CorporateCustGenerateReport(prodTypeList, prodList, orderDataList, orderLL, corporateCustomerList, customerList);
        
        //orderLL = GenerateSalesOrder.GenerateReportMain(prodTypeList, prodList, orderDataList, orderLL);
        //orderDataList = catalogOrder.CatalogOrderMenu(prodTypeList,prodList,orderDataList,customerList,staffList,paymentList);
//        
//        pickupList = PickedUpTimeStamp.TimeStamp(pickupList, orderDataList);

          //DeliveryList.ShowDeliveryList(deliveryList, orderLL);
          
          paymentList = CustomerPayment.MakePayment(paymentList);
          

//        CorporateCustomerMaintenance.Menu(corporateCustomerList, staffList.get(0), orderDataList, paymentList, customerList);
       //CustomizeOrder.Customize(customerList,customizedList, orderDataList, styleList, sizeList, prodList, accessoriesList, paymentList,staffList.get(0));
    }
    
}

