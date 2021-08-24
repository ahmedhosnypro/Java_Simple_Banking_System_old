package banking;

import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private Account account;

    static Scanner scanner = new Scanner(System.in);

    public void mainMenu() {

        System.out.println("1. Create an account\n" +
                "2. Log into account\n" +
                "0. Exit");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                createAccount();
                break;
            case "2":
                logIn();
                break;
            case "0":
                System.out.println("\nBye!");
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }

    private void createAccount() {
        account = AccountData.addAccount();
        System.out.println("\nYour card has been created\n" +
                "Your card number:\n" +
                account.getCardNumber() + "\n" +
                "Your card PIN:\n" +
                account.getPin() + "\n");
        mainMenu();
    }

    public void accountInfoMenu() {
        System.out.println("1. Balance\n" +
                "2. Log out\n" +
                "0. Exit");

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                System.out.println("\nBalance: " + account.getBalance() + "\n");
                accountInfoMenu();
                break;
            case "2":
                logOut();
                break;
            case "0":
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }

    private void logIn() {
        System.out.println("\nEnter your card number:");
        String cardNum = scanner.nextLine();
        System.out.println("Enter your PIN:");

        if (cardNum.length() == 16) {
            String pin = scanner.nextLine();
            if (AccountData.getAccCardNums().contains(cardNum)) {
                Account account = AccountData.getAccounts().get(cardNum);
                if (Objects.equals(pin, account.getPin())) {
                    this.account = account;
                    System.out.println("\nYou have successfully logged in!\n");
                    accountInfoMenu();
                } else {
                    System.out.println("\nWrong card number or PIN!\n");
                    mainMenu();
                }
            }
        } else {
            System.out.println("\nWrong card number!\n");
            mainMenu();
        }
    }

    private void logOut() {
        this.account = null;
        System.out.println("\nYou have successfully logged out!\n");
        mainMenu();
    }
}
