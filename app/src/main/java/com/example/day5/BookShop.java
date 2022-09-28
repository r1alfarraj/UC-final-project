package com.example.day5;

import java.io.Serializable;

public class BookShop implements Serializable {

    private String BookUrl;
    private String bookName;
    private  double bookPrice;
    private  String bookImg;
    private String bookType;




    public BookShop() {
    }

    public BookShop(String bookName, double bookPrice, String bookImg, String bookType, String bookUrl) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookImg = bookImg;
        this.bookType = bookType;
        this.BookUrl = bookUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getbookPrice() {
        return bookPrice;
    }

    public void setbookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
    public BookShop(String bookUrl) {
        BookUrl = bookUrl;
    }

    public String getBookUrl() {
        return BookUrl;
    }

    public void setBookUrl(String bookUrl) {
        BookUrl = bookUrl;
    }


}
