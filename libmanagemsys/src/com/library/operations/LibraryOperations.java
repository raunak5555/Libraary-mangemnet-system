package com.library.operations;

public interface LibraryOperations {

    void issueBook(int studentId, int bookId);

    void returnBook(int studentId, int bookId);
}