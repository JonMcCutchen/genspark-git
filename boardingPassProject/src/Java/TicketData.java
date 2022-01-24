import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


import java.io.IOException;
import java.util.Scanner;

public class TicketData {
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;
    private int boardingPassNumber;
    private String departureDate;
    private String origin;
    private String destination;
    private int departureTime;
    private String eta;
    private int ticketPrice;

    Scanner scanner = new Scanner(System.in);

    public TicketData() {

    }

    public TicketData(String name, String email, String phoneNumber, String gender, int age, int boardingPassNumber, String departureDate, String origin, String destination, int departureTime, String eta, int ticketPrice) {
        name = this.name;
        email = this.email;
        phoneNumber = this.phoneNumber;
        gender = this.gender;
        age = this.age;
        boardingPassNumber = this.boardingPassNumber;
        departureDate = this.departureDate;
        origin = this.origin;
        destination = this.destination;
        departureTime = this.departureTime;
        eta  = this.eta;
        ticketPrice = this.ticketPrice;
    }

    public int getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public void setBoardingPassNumber(int boardingPassNumber) {
        this.boardingPassNumber = boardingPassNumber;
    }

    public void getInputs() {
        getName();
        getEmail();
        getPhoneNumber();
        getGender();
        getAge();
        getOrigin();
        getDestination();
        getDepartureDate();
        getDepartureTime();
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

    public int getDepartureTime() {
        System.out.println("Enter departure time in 24h format (example: 0100 for 1:00am, 1300 for 1:00pm)");
        int departureTime = scanner.nextInt();

       setDepartureTime(departureTime);


        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter departure date in the following format: dd/MM/yyyy");
        String departureDate = scanner.nextLine();
        if(departureDate.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}")){
            setDepartureDate(departureDate);
        } else {
            getDepartureDate();
        }
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String computeETA(String origin, String destination, String departureTime, String departureDate) throws IOException {
        origin = this.origin;
        destination = this.destination;
        departureTime = String.valueOf(this.departureTime);
        departureDate = this.departureDate;
        String url = "https://www.travelmath.com/flying-time/from/"+origin+"/to/"+destination;
        Document document = Jsoup.connect(url).get();
        Element time = document.getElementById("flyingtime");

        setETA(time.text());
        return time.text();
    }

    public void setETA(String eta) {
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
                "Departure Date: " + departureDate + "  |  " + "Departure Time: " + departureTime + "\n" +
                "Origin: " + origin + "  |  " + "Destination: " + destination + "  |  " + "ETA: " + eta + "\n" +
                "Ticket Price: " + ticketPrice;
    }

}
