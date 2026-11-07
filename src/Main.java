import exception.BookAlreadyBorrowedException;
import model.*;
import service.LibraryManager;

// [Notebook sources] Exception Handling & Core Execution flow
public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        // 1. Add Inventory Items
        manager.addItem(new Textbook("978-0134685991", "Effective Java", 2018));
        manager.addItem(new Journal("978-0265321458", "AI Quarterly", 2023));
        manager.addItem(new ReferenceBook("978-1118008188", "Encyclopedia Britannica", 2010));

        // 2. Register Members (Set prevents duplicate member ID registration)
        Member student = new Student("S001", "Alice Smith");
        Member faculty = new Faculty("F001", "Dr. John Doe");

        manager.registerMember(student);
        manager.registerMember(faculty);
        manager.registerMember(new Student("S001", "Alice Duplicate")); // Ignored by Set

        manager.displayInventory();

        // 3. Test Borrowing and Robust Exception Handling
        System.out.println("\n--- Testing Transactions & Exceptions ---");
        try {
            manager.borrowItem("978-0134685991", student);
            
            // Attempting to borrow the same book triggers BookAlreadyBorrowedException
            manager.borrowItem("978-0134685991", faculty); 

        } catch (BookAlreadyBorrowedException e) {
            System.err.println("Caught Custom Exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        // 4. Test Sorting with Comparator
        System.out.println("\n--- Sorting Inventory by Publication Year ---");
        manager.sortByYear();
        manager.displayInventory();

        // 5. Test Polymorphic Fine Calculation
        LibraryItem textbook = manager.findItemByIsbn("978-0134685991");
        double fine = ((Textbook) textbook).calculateFine(4); // 4 days late
        System.out.println("\nCalculated Fine for 4 days late on '" + textbook.getTitle() + "': $" + fine);
    }
}
