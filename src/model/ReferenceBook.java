package model;

// [Notebook sources] OOP Foundation: Inheritance (Non-borrowable reference item)
public class ReferenceBook extends LibraryItem {

    public ReferenceBook(String isbn, String title, int publicationYear) {
        super(isbn, title, publicationYear);
    }

    public double calculateFine(int daysLate) {
        return 0.0; // Reference books cannot leave the library
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0.0; // Reference books cannot leave the library
    }
}