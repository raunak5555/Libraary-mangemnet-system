package com.library.service;

import java.util.ArrayList;

import com.library.model.Book;
import com.library.model.Student;
import com.library.operations.LibraryOperations;

public class Library implements LibraryOperations {

    private ArrayList<Book> books;
    private ArrayList<Student> students;

    public Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBookDetails();
        }
    }

    private Book findBookById(int id) {

        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }

        return null;
    }

    private Student findStudentById(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    @Override
    public void issueBook(int studentId, int bookId) {

        Student student = findStudentById(studentId);
        Book book = findBookById(bookId);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book already issued!");
            return;
        }

        if (student.getBorrowedBooks().size() >= 3) {
            System.out.println("Student cannot borrow more than 3 books!");
            return;
        }

        student.borrowBook(book);
        book.setAvailable(false);

        System.out.println("Book issued successfully!");
    }

    @Override
    public void returnBook(int studentId, int bookId) {

        Student student = findStudentById(studentId);
        Book book = findBookById(bookId);

        if (student == null || book == null) {
            System.out.println("Invalid student or book ID!");
            return;
        }

        if (!student.getBorrowedBooks().contains(book)) {
            System.out.println("This student did not borrow the book!");
            return;
        }

        student.returnBook(book);
        book.setAvailable(true);

        System.out.println("Book returned successfully!");
    }

    public void viewStudentDetails(int studentId) {

        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        student.displayDetails();
    }
}