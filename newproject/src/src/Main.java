package src;

import java.io.OptionalDataException;

public class Main {

    public static String method(String str) {
        String reversed = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            reversed+= str.charAt(i);
        }
        return reversed;
    }
    public static void main(String[] args) {
	// write your code here
        String str = "hello";
        System.out.println(method(str));
    }
}
