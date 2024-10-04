package airline;

public class AddAirlineEmployee extends Employee {
    private String position;

    public AddAirlineEmployee(String name, String email, String position) {
        super(name, email);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString() + ", Position: " + position;
    }
}
