import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            try {
                if (!str.equals("0")) {
                    int i = Integer.parseInt(str);
                    System.out.println(i * 10);
                } else {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid user input: " + str);
            }
        }
    }
}