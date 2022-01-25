


import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class TicketData {
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;
    private int boardingPassNumber;
    private Date departureDateTime;
    private String origin;
    private String destination;
    private Date eta;
    private int ticketPrice;

    Scanner scanner = new Scanner(System.in);

    public TicketData() {

    }


    public int getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public void setBoardingPassNumber(int boardingPassNumber) {
        this.boardingPassNumber = boardingPassNumber;
    }

    public void getInputs() throws ParseException {
        getName();
        getEmail();
        getPhoneNumber();
        getGender();
        getAge();
        getOrigin();
        getDestination();
        getDepartureDateTime();
    }

    public String getName(){
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        setName(name);

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        System.out.println("Enter your email");
        String email = scanner.nextLine();
        if(email.matches("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")) {
            setEmail(email);
        } else {
            System.out.println("please re-enter your email in the correct email format");
            return getEmail();
        }

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        System.out.println("Enter your phone number in the following format: XXX-XXX-XXXX");
        String phoneNumber = scanner.nextLine();
        if(phoneNumber.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")) {
            setPhoneNumber(phoneNumber);
        } else {
            return getPhoneNumber();
        }

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your gender (M or F)");
        String gender = scanner.nextLine();
        gender = gender.equals("M") ? gender : gender.equals("m") ? gender : gender.equals("F") ? gender : gender.equals("f") ? gender : getGender();
        setGender(gender);
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age (example: 24)");
        int age;
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
            setAge(age);
        } else {
            return getAge();
        }
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOrigin() {
        System.out.println("Enter origin location");
        String origin = scanner.nextLine();
        if (origin.isEmpty()) {
            return getOrigin();
        } else {
            setOrigin(origin);
        }
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        System.out.println("Enter destination location");
        String destination = scanner.nextLine();
        if(destination.isEmpty()) {
            return getDestination();
        } else {
            setDestination(destination);
        }
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDateTime() throws ParseException {
        System.out.println("Enter departure date and time in the given format: MM-dd-yyyy HH:mm");
        String departureDateTimeString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        Date departureDateTime = format.parse(departureDateTimeString);

        setDepartureDateTime(departureDateTime);
        return departureDateTime;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }



    public Date computeETA() throws IOException {
        int randomFlightLength = (int) (Math.floor(Math.random()*10)+1);

        Date eta = Date.from(this.departureDateTime.toInstant().plus(Duration.ofHours(randomFlightLength)));
        setETA(eta);
        return eta;
    }

    public void setETA(Date eta) {
        this.eta = eta;
    }

    public int computeTicketPrice() {

        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "BOARDING PASS # " + boardingPassNumber + "\n" +
                "Name: " + name + "  |  " + "Email: " + email + "  |  " + "Phone Number: " + phoneNumber + "  |  " + "Gender: " + gender + "  |  " + "Age: " + age + "\n" +
                "Departure Date & Time: " + departureDateTime + "\n" +
                "Origin: " + origin + "  |  " + "Destination: " + destination + "  |  " + "ETA: " + eta + "\n" +
                "Ticket Price: " + ticketPrice;
    }

}
