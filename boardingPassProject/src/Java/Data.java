import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    public Data() {

    }

    public ArrayList<String> list = new ArrayList<>();

    public void getInputs() {
        Scanner scanner = new Scanner(System.in);

        String name = getName();
        String email = getEmail();
        String phoneNumber = getPhoneNumber();
        String gender = getGender();
        String age = getAge();
        int boardingPassNumber = 0;
        String origin = getOrigin();
        String destination = getDestination();
        String departureTime = getDepartureTime();



    }

    public String getName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();

        list.add(name);

        return name;
    }

    public String getEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email");
        String email = scanner.nextLine();
        if(email.matches("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$")) {
            email = email;
            list.add(email);
        } else {
            System.out.println("please re-enter your email in the correct email format");
            return getEmail();
        }

        return email;
    }

    public String getPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your phone number in the following format: XXX-XXX-XXXX");
        String phoneNumber = scanner.nextLine();
        if(phoneNumber.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$")) {
            phoneNumber = phoneNumber;
            list.add(phoneNumber);
        } else {
            return getPhoneNumber();
        }

        return phoneNumber;
    }

    public String getGender() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your gender (M or F)");
        String gender = scanner.nextLine();
        gender = gender.equals("M") ? gender : gender.equals("m") ? gender : gender.equals("F") ? gender : gender.equals("f") ? gender : getGender();
        list.add(gender);
        return gender;
    }

    public String getAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your age (example: 24)");
        String age = null;
        if (scanner.hasNextInt()) {
            age = String.valueOf(scanner.nextInt());
            list.add(age);
        } else {
            return getAge();
        }
        return age;
    }

    public String getOrigin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter origin location");
        String origin = scanner.nextLine();
        if (origin.isEmpty()) {
            return getOrigin();
        } else {
            origin = origin;
            list.add(origin);
        }
        return origin;
    }

    public String getDestination() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter destination location");
        String destination = scanner.nextLine();
        if(destination.isEmpty()) {
            return getDestination();
        } else {
            destination = destination;
            list.add(destination);
        }
        return destination;
    }

    public String getDepartureTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter departure time in 24h format (example: 0100 for 1:00am, 1300 for 1:00pm)");
        String departure = Integer.toString(scanner.nextInt());

        list.add(departure);

        return departure;
    }



}
