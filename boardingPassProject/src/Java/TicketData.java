import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Scanner;

public class TicketData {
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;
    private int boardingPassNumber = 0;
    private Date departureDateTime;
    private String origin;
    private String destination;
    private Date eta;
    private String ticketPrice;
    private int randomFlightLength = (int) (Math.floor(Math.random()*10)+1);

    Scanner scanner = new Scanner(System.in);

    public TicketData() {

    }


    public void generateID() throws IOException {
        Path path = Paths.get("BoardingPass.txt");

        long lines = lines = Files.lines(path).count();

        setBoardingPassNumber((int) lines + 1);
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

    public void getName(){
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        setName(name);
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

    public void getDepartureDateTime() throws ParseException {
        System.out.println("Enter departure date and time in the given format (24h): MM-dd-yyyy HH:mm");
        String departureDateTimeString = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy HH:mm");
        Date departureDateTime = format.parse(departureDateTimeString);

        setDepartureDateTime(departureDateTime);
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }



    public void computeETA() {

        Date eta = Date.from(this.departureDateTime.toInstant().plus(Duration.ofHours(randomFlightLength)));
        setETA(eta);
    }

    public void setETA(Date eta) {
        this.eta = eta;
    }

    public void computeTicketPrice() {
        float discount = 1;
        float ticketPrice = randomFlightLength * 100;
        if (this.age <= 12) {
            discount -= .5;

        }
        if (this.age >= 60) {
            discount -= .4;
        }
        if (this.gender.equals("F") || this.gender.equals("f")) {
            discount -= .75;
        }
        float discountedTicketPrice;
        if (discount != 1) {
            discountedTicketPrice = ticketPrice - (ticketPrice * discount);
        } else {
            discountedTicketPrice = ticketPrice;
        }
        setTicketPrice("$" + discountedTicketPrice);
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void writeToFile() throws IOException {
        FileWriter writer = new FileWriter("BoardingPass.txt", true);
        writer.write("ID: " + boardingPassNumber + " Name: " + name + " Email: " + email + " Phone Number: " + phoneNumber + " Gender: " + gender + " Age: " + age + " Departure Time & Date: " + departureDateTime + " Origin: " + origin + " Destination: " + destination + " ETA: " + eta + " Ticket Price: " + ticketPrice + "\n");
        writer.close();
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
