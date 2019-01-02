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
    private String password;

    public Staff() {
    }

    public Staff(String staffID, String staffName, String staffContactNo, String password) {
        this.staffID = staffID;
        this.staffName = staffName;
        this.staffContactNo = staffContactNo;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Staff{" + "staffID=" + staffID + ", staffName=" + staffName + ", staffContactNo=" + staffContactNo + '}';
    }
}
