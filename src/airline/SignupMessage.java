package airline;

public class SignupMessage {

    public static void displayMessage() {
        System.out.println("Signup successful! Welcome to the Airline Reservation System.");
    }

    public static void displayMessage(String username) {
        System.out.println("Signup successful! Welcome to the Airline Reservation System, " + username + "!");
    }

    public static void displayFailureMessage() {
        System.out.println("Signup failed. Please check your details and try again.");
    }
}
