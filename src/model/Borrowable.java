package model;

import exception.BookAlreadyBorrowedException;

public interface Borrowable {
    void borrowItem(Member member) throws BookAlreadyBorrowedException;
    void returnItem();
}