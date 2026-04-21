import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        int score = 0;

        if(password.length() >= 8) score++;
        if(password.matches(".*[A-Z].*")) score++;
        if(password.matches(".*[a-z].*")) score++;
        if(password.matches(".*\\d.*")) score++;
        if(password.matches(".*[@#$%^&+=].*")) score++;

        String[] common = {"123456", "password", "admin"};

        for(String p : common) {
            if(password.equals(p)) {
                System.out.println("Too common password!");
                return;
            }
        }

        if(score <= 2) {
            System.out.println("Weak");
            System.out.println("Try: " + password + "@123");
        }
        else if(score <= 4) {
            System.out.println("Medium");
        }
        else {
            System.out.println("Strong");
        }
    }
}