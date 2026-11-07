package model;

import exception.BookAlreadyBorrowedException;

// [Notebook sources] OOP Foundation: Inheritance and Polymorphism
public class Journal extends LibraryItem implements Borrowable {
    private boolean isBorrowed;
    private Member borrowedBy;

    public Journal(String isbn, String title, int publicationYear) {
        super(isbn, title, publicationYear);
        this.isBorrowed = false;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    @Override
    public void borrowItem(Member member) throws BookAlreadyBorrowedException {
        if (isBorrowed) {
            throw new BookAlreadyBorrowedException("Journal '" + getTitle() + "' is already borrowed!");
        }
        this.isBorrowed = true;
        this.borrowedBy = member;
    }

    @Override
    public void returnItem() {
        this.isBorrowed = false;
        this.borrowedBy = null;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 2.50; // Journals incur a late fee of 2.50 per day
    }
}