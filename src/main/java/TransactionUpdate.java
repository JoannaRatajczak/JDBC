import java.util.Scanner;

public class TransactionUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj id transakcji którą chcesz zmodyfikować");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Podaj nowy typ transakcji");
        String t =scanner.nextLine();
        System.out.println("Podaj nowy opis transakcji");
        String o = scanner.nextLine();
        System.out.println("Podaj nowy wydatek transakcji");
        double w = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Podaj nową datę transakcji");
        String d = scanner.nextLine();

        Transaction transaction = new Transaction(id, t, o, w, d);
        System.out.println(transaction);
        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.update(transaction);
        System.out.println("Zmodyfikowano pomyślnie");

    }
}
