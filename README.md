# Smart Library & Fine Calculation System

A Core Java console application designed to manage library inventory, member registrations, book checkouts, and fine calculations using robust Object-Oriented Programming principles.

## Key Features & Concepts Applied
- **4 Pillars of OOP:** 
  - *Encapsulation:* Private fields with controlled access via getters, setters, and behavior methods.
  - *Inheritance:* Common properties shared through an abstract base class (`LibraryItem`) and specialized member types (`Student`, `Faculty`).
  - *Polymorphism:* Overriding behavior like custom fine-calculation formulas across different item types.
  - *Abstraction:* Defining clean contracts via interfaces (`Borrowable`, `Reservable`) and abstract classes.
- **Java Collections Framework:** Uses `List` for inventory tracking, `Map` for fast ISBN lookups, `Set` for unique member registration, and custom `Comparators` for sorting.
- **Custom Exception Handling:** Gracefully manages business rule violations using custom exceptions (`BookAlreadyBorrowedException`, `MemberLimitExceededException`) and robust `try-catch` blocks.

## 🛠️ Built With
- **Language:** Java (JDK 17+)
- **Environment:** Visual Studio Code
