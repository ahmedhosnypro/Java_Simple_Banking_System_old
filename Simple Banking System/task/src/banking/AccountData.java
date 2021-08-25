package banking;

import java.util.*;

public class AccountData {
    private static final HashMap<String, Account> accounts = new HashMap<>();
    private static final ArrayList<String> accCardNums = new ArrayList<>();

    public static Account addAccount() {
        String cardNumber = createCardNumber();
        accounts.put(cardNumber, new Account(cardNumber));
        accCardNums.add(cardNumber);

        return accounts.get(cardNumber);
    }

    private static String createCardNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> array = new ArrayList<>();
        array.add(4);
        for (int i = 0; i < 5; i++) {
            array.add(0);
        }
        sb.append(400000);

        for (int i = 0; i < 9; i++) {
            int n = random.nextInt(9);
            sb.append(n);
            array.add(n);
        }

        for (int i = 0; i < 16; i += 2) {
            array.set(i, array.get(i) * 2);
        }

        int sum = 0;

        for (int i = 0; i < 15; i++) {
            int tmp = array.get(i);
            if (tmp > 9) {
                sum += tmp - 9;
            } else {
                sum += tmp;
            }

        }

        int remainder = sum % 10;
        int checkSum;
        if (remainder != 0) {
            checkSum = 10 - remainder;
        } else {
            checkSum = remainder;
        }


        sb.append(checkSum);

        if (getAccCardNums().contains(sb.toString())) {
            return createCardNumber();
        }

        return sb.toString();
    }

    public static HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public static ArrayList<String> getAccCardNums() {
        return accCardNums;
    }
}
