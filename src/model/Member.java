package model;

import java.util.Objects;

// [Notebook sources] OOP Foundation: Encapsulation
public abstract class Member {
    private String memberId;
    private String name;
    private int borrowedCount;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedCount = 0;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public int getBorrowedCount() { return borrowedCount; }

    public void incrementBorrowedCount() { borrowedCount++; }
    public void decrementBorrowedCount() { if (borrowedCount > 0) borrowedCount--; }

    public abstract int getBorrowLimit();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId.equals(member.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }

    @Override
    public String toString() {
        return "Member [ID=" + memberId + ", Name=" + name + "]";
    }
}