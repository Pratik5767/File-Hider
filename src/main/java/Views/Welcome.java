package Views;

import DAO.UserDAO;
import model.User;
import service.GenerateOTP;
import service.SentOTPService;
import service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class Welcome {
    public void WelcomeScreen() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the application");
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to signUp");
        System.out.println("Press 3 to exit");

        int choice = 0;
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                signUp();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

    Scanner sc = new Scanner(System.in);
    private void login() {
        System.out.print("Enter your Email: ");
        String email = sc.nextLine();
        try {
            if (UserDAO.isExits(email)) {
                String genOTP = GenerateOTP.getOTP();
                SentOTPService.sentOTP(email, genOTP);
                System.out.print("Enter the OTP: ");
                String userOTP = sc.nextLine();

                if (userOTP.equals(genOTP)) {
                    System.out.println("login successfully");
                    new UserView(email).home();
                } else {
                    System.out.println("Wrong OTP");
                }
            } else {
                System.out.println("User Not Found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void signUp() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email");
        String email = sc.nextLine();

        String genOTP = GenerateOTP.getOTP();
        SentOTPService.sentOTP(email, genOTP);
        System.out.print("Enter the OTP");
        String otp = sc.nextLine();

        if (otp.equals(genOTP)) {
            User user = new User(name, email);
            int response = UserService.saveUser(user);

            switch (response) {
                case 0:
                    System.out.println("User Registered");
                    break;
                case 1:
                    System.out.println("User Already Existed");
                    break;
            }
        } else {
            System.out.println("Wrong OTP");
        }
    }
}
