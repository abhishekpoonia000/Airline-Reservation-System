package airline;

public class AddAirlineEmployee {
    private String employeeID;
    private String employeeName;
    private String role;

    public AddAirlineEmployee(String employeeID, String employeeName, String role) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.role = role;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeID + ", Name: " + employeeName + ", Role: " + role;
    }
}
