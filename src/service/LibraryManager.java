package service;

import exception.MemberLimitExceededException;
import model.*;

import java.util.*;

// [Notebook sources] Java Collections Framework usage (List, Map, Set, and Comparators)
public class LibraryManager {
    private List<LibraryItem> inventory = new ArrayList<>(); // List for tracking inventory
    private Map<String, LibraryItem> isbnMap = new HashMap<>(); // Map for fast ISBN lookups
    private Set<Member> registeredMembers = new HashSet<>(); // Set to prevent duplicate registrations

    public void addItem(LibraryItem item) {
        inventory.add(item);
        isbnMap.put(item.getIsbn(), item);
    }

    public boolean registerMember(Member member) {
        return registeredMembers.add(member); // Set ensures uniqueness via equals/hashCode
    }

    public LibraryItem findItemByIsbn(String isbn) {
        return isbnMap.get(isbn);
    }

    public void borrowItem(String isbn, Member member) throws Exception {
        LibraryItem item = findItemByIsbn(isbn);
        if (item == null) {
            throw new Exception("Book with ISBN " + isbn + " not found.");
        }

        if (member.getBorrowedCount() >= member.getBorrowLimit()) {
            throw new MemberLimitExceededException("Member " + member.getName() + " has reached their borrowing limit!");
        }

        if (item instanceof Borrowable) {
            ((Borrowable) item).borrowItem(member);
            member.incrementBorrowedCount();
            System.out.println("Success: " + member.getName() + " borrowed '" + item.getTitle() + "'");
        } else {
            throw new Exception("Reference books cannot be borrowed!");
        }
    }

    // Custom sorting using Comparator by Publication Year
    public void sortByYear() {
        inventory.sort(Comparator.comparingInt(LibraryItem::getPublicationYear));
    }

    public void displayInventory() {
        System.out.println("\n--- Current Library Inventory ---");
        for (LibraryItem item : inventory) {
            System.out.println(item);
        }
    }
}