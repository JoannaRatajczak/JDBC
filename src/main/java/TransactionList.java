import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionList {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj typ transakcji który chcesz wyświetlić : przychod/wydatek");
        String ans = scanner.nextLine();

        List list = new ArrayList();
        TransactionDAO transactionDAO = new TransactionDAO();
        list = transactionDAO.list(ans);
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
