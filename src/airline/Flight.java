package airline;

public class Flight {
    private String flightNumber;
    private String destination;
    private String departureTime;
    private String arrivalTime;

    // Constructor for the Flight class
    public Flight(String flightNumber, String destination, String departureTime, String arrivalTime) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    // Setters
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                '}';
    }
}
