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
public class Staff {
    private String staffID;
    private String staffName;
    private String staffContactNo;

    public Staff() {
    }

    public Staff(String staffID, String staffName, String staffContactNo) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffContactNo = staffContactNo;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffContactNo() {
        return staffContactNo;
    }

    public void setStaffContactNo(String staffContactNo) {
        this.staffContactNo = staffContactNo;
    }

    @Override
    public String toString() {
        return "Staff{" + "staffID=" + staffID + ", staffName=" + staffName + ", staffContactNo=" + staffContactNo + '}';
    }
}
