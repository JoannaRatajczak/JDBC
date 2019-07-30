import java.util.Scanner;

public class TransactionAdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj typ transakcji");
        String t =scanner.nextLine();
        System.out.println("Podaj opis transakcji");
        String o = scanner.nextLine();
        System.out.println("Podaj wydatek transakcji");
        double w = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Podaj datę transakcji");
        String d = scanner.nextLine();

        Transaction transaction = new Transaction(t, o, w, d);
        System.out.println(transaction);
        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.addNew(transaction);
        System.out.println("Dodano pomyślnie");
    }
}
