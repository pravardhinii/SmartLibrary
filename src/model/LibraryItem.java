package model;

public abstract class LibraryItem implements Reservable{
    private String isbn;
    private String title;
    private int publicationYear;
    private boolean isReserved;

    public LibraryItem(String isbn, String title, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.isReserved = false;
    }

    public String getIsbn() { return isbn;}
    public String getTitle() { return title;}
    public int getPublicationYear() { return publicationYear;}
    public boolean isReserved() { return isReserved; }
    
    public void setReserved(boolean reserved){ isReserved = reserved; }

    public abstract double calculateLateFee(int daysLate);

    @Override
    public void reserveItem(Member member) {
        this.isReserved = true;
        System.out.println("Item [" + title + "] has been reserved by " + member.getName());
    }
    @Override public String toString() {
        return "Item [ISBN: " + isbn + ", Title: " + title + ", Publication Year: " + publicationYear + "]";
    }
}
