import java.util.Scanner;

public class TransactionDelete {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj ID transakcji");
        long id = scanner.nextLong();

        TransactionDAO transactionDAO = new TransactionDAO();
        transactionDAO.deleteByID(id);
        System.out.println("Usunięto");

    }
}
