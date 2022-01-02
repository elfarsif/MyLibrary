package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    private Utils() {

        if(null==allBooks){
            allBooks=new ArrayList<>();
            initData();
        }

        if(null==alreadyReadBooks){
            alreadyReadBooks=new ArrayList<>();
        }

        if(null==wantToReadBooks){
            wantToReadBooks=new ArrayList<>();
        }

        if(null==currentlyReadingBooks){
            currentlyReadingBooks=new ArrayList<>();
        }

        if(null==favoriteBooks){
            favoriteBooks=new ArrayList<>();
        }
    }

    private void initData() {
        //TODO: add initial data

        ArrayList<Book> books =new ArrayList<>();
        allBooks.add(new Book(1,"Chamber of secrets","JK ROWLING",129,"https://www.nypl.org/sites/default/files/Harry_Potter_and_the_Chamber_of_Secrets_(US_cover)_0.jpg",
                "2nd book og the Harry Potter book", "Long Desc"));
        allBooks.add(new Book(2,"Prizoner of Azkaban","JK ROWLING",229,"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1630547330l/5._SY475_.jpg",
                "3rd book og the Harry Potter book", "Long Desc"));

    }


    public static Utils getInstance() {
        if(null!=instance){
            return instance;
        }else{
            instance = new Utils();
            return instance;
        }

    }


    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookById(int id){
        for(Book b:allBooks){
            if(b.getId()==id){
                return b;
            }
        }

        return null;
    }


    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book);
    }

    public boolean addToWantToRead(Book book) {
        return wantToReadBooks.add(book);
    }
}
