import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in); 
        System.err.println("\nEnter name: ");
        String name = scan.nextLine();
        System.err.println("\nEnter Account ID: ");
        String id = scan.nextLine();

        BankAccount ac = new BankAccount(name,id);

        ac.displayMenu();
    }
}