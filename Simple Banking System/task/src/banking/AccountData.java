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
        sb.append(400000);

        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(9));
        }

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
