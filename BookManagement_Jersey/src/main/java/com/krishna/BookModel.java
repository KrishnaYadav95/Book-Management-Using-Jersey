package com.krishna;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookModel {
    private int BookNumber;
    private String BookName;
    private String Author;

    public int getBookNumber() {
        return BookNumber;
    }

    public void setBookNumber(int bookNumber) {
        BookNumber = bookNumber;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }
}
