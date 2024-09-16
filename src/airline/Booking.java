package airline;

import java.util.UUID;

public class Booking {
    private String id;
    private Passenger passenger;
    private Flight flight;

    public Booking(Passenger passenger, Flight flight) {
        this.id = UUID.randomUUID().toString();
        this.passenger = passenger;
        this.flight = flight;
    }

    public String getId() {
        return id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }
}
