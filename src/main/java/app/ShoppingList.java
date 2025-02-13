package app;
import java.util.Scanner;
import utils.DynamicArrayList;

/**
 *
 * @author michelle
 */
public class ShoppingList {
    public static void main(String[] args) {
        DynamicArrayList newList = new DynamicArrayList();
        Scanner keyboard = new Scanner(System.in);

        System.out.print("How many entries would you like to add to your shopping list? ");
        int numEntries = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Enter your shopping list entries (one item per line):");
        for (int i = 0; i < numEntries; i++) {
            String entry = keyboard.nextLine();
            newList.add(entry);
        }

    }
}
