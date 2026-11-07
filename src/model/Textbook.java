package model;

import exception.BookAlreadyBorrowedException;

// [Notebook sources] OOP Foundation: Inheritance and Polymorphism
public class Textbook extends LibraryItem implements Borrowable {
    private boolean isBorrowed;
    private Member borrowedBy;

    public Textbook(String isbn, String title, int publicationYear) {
        super(isbn, title, publicationYear);
        this.isBorrowed = false;
    }

    @Override
    public void borrowItem(Member member) throws BookAlreadyBorrowedException {
        if (isBorrowed) {
            throw new BookAlreadyBorrowedException("Textbook '" + getTitle() + "' is already borrowed!");
        }
        this.isBorrowed = true;
        this.borrowedBy = member;
    }

    @Override
    public void returnItem() {
        this.isBorrowed = false;
        this.borrowedBy = null;
    }

    public double calculateFine(int daysLate) {
        return calculateLateFee(daysLate);
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.50; // Polymorphic fine calculation rule for textbooks
    }
}