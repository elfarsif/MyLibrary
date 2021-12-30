package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView booksRecView;
    private BookRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        adapter=new BookRecViewAdapter(this);
        booksRecView=findViewById(R.id.booksRecView);

        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Book> books =new ArrayList<>();
        books.add(new Book(1,"Chamber of secrets","JK ROWLING",129,"https://www.nypl.org/sites/default/files/Harry_Potter_and_the_Chamber_of_Secrets_(US_cover)_0.jpg",
                "2nd book og the Harry Potter book", "Long Desc"));
        books.add(new Book(1,"Prizoner of Azkaban","JK ROWLING",229,"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1630547330l/5._SY475_.jpg",
                "3rd book og the Harry Potter book", "Long Desc"));
        adapter.setBooks(books);
    }
}