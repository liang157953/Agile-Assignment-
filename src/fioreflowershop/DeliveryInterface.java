/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fioreflowershop;

/**
 *
 * @author User
 */
public interface DeliveryInterface extends Comparable<DeliveryInterface> {
  public Delivery getDelivery();
  public String getTrackingNo() ;
}
