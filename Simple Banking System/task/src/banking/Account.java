package banking;

import java.util.Random;

public class Account {
    private final String cardNumber;
    private final String pin;
    private final long balance;

    public Account(String cardNumber) {
        this.cardNumber = cardNumber;
        pin = createPin();
        balance = 0;
    }

    public String getCardNumber() {
        return cardNumber;
    }


    private static String createPin() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }

    public String getPin() {
        return pin;
    }

    public long getBalance() {
        return balance;
    }

//    public void setPin(int pin) {
//        this.pin = pin;
//    }
//
//    public void setBalance(long balance) {
//        this.balance = balance;
//    }
}
