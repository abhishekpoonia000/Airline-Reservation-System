package airline;

public class FlightJourney {
    private String journeyID;
    private String flightNumber;
    private String departureTime;
    private String arrivalTime;

    // Constructor
    public FlightJourney(String journeyID, String flightNumber, String departureTime, String arrivalTime) {
        this.journeyID = journeyID;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    // Getters
    public String getJourneyID() {
        return journeyID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    // Setters
    public void setJourneyID(String journeyID) {
        this.journeyID = journeyID;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Journey ID: " + journeyID +
                ", Flight Number: " + flightNumber +
                ", Departure Time: " + departureTime +
                ", Arrival Time: " + arrivalTime;
    }
}
