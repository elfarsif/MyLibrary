package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY="bookId";

    private TextView txtBookName,txtAuthor,txtPages,txtDescription;
    private Button btnAddToWantToRead, btnWantToAlreadyRead,btnAddToCurrentlyReading,btnAddToFavorite;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();
//        String longDescripption="Ever since Harry Potter had come home for the summer, the Dursleys had been so mean and hideous that all Harry wanted was to get back to the Hogwarts School for Witchcraft and Wizardry. But just as he’s packing his bags, Harry receives a warning from a strange impish creature who says that if Harry returns to Hogwarts, disaster will strike.\n" +
//                "\n" +
//                "And strike it does. For in Harry’s second year at Hogwarts, fresh torments and horrors arise, including an outrageously stuck-up new professor and a spirit who haunts the girls’ bathroom. But then the real trouble begins – someone is turning Hogwarts students to stone. Could it be Draco Malfoy, a more poisonous rival than ever? Could it possible be Hagrid, whose mysterious past is finally told? Or could it be the one everyone at Hogwarts most suspects… Harry Potter himself!";
//
//        //TODO: Get data from recycler view in here
//        Book book=new Book(1,"Chamber of secrets","JK ROWLING",129,"https://www.nypl.org/sites/default/files/Harry_Potter_and_the_Chamber_of_Secrets_(US_cover)_0.jpg",
//                "2nd book og the Harry Potter book", longDescripption);

        Intent intent = getIntent();
        if(intent!=null){
            int bookId=intent.getIntExtra(BOOK_ID_KEY,-1);
            if(bookId!=-1){
                Book incomingBook=Utils.getInstance().getBookById(bookId);
                if(incomingBook!=null){
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);
                }
            }
        }




    }

    private void handleFavoriteBooks(Book book) {

    }

    private void handleCurrentlyReadingBooks(Book book) {

    }

    private void handleWantToReadBooks(final Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();

        boolean existInWantToReadBooks=false;

        for(Book b:wantToReadBooks){
            if(b.getId()==book.getId()){
                existInWantToReadBooks=true;
            }

        }
        if(existInWantToReadBooks){
            btnWantToAlreadyRead.setEnabled(false);
        }else{
            btnWantToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToWantToRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this,AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    /**
     * Enable and disable button,
     * Add the book to Already Read Book Arraylist
     * @param book
     */
    private void handleAlreadyRead(final Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();

        boolean existInAlreadyReadBooks=false;

        for(Book b:alreadyReadBooks){
            if(b.getId()==book.getId()){
                existInAlreadyReadBooks=true;
            }

        }
        if(existInAlreadyReadBooks){
            btnWantToAlreadyRead.setEnabled(false);
        }else{
            btnWantToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Utils.getInstance().addToAlreadyRead(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this,AlreadyReadBookActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Book book) {

        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);

    }

    private void initViews() {
        txtBookName=findViewById(R.id.txtBookName);
        txtAuthor=findViewById(R.id.txtAuthorName);
        txtPages=findViewById(R.id.txtPages);
        txtDescription=findViewById(R.id.txtDescription);


        btnAddToWantToRead=findViewById(R.id.btnAddToWantToReadList);
        btnWantToAlreadyRead =findViewById(R.id.btnAddToAlreadyReadList);
        btnAddToCurrentlyReading=findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavorite=findViewById(R.id.btnAddToFavorite);


        bookImage=findViewById(R.id.imgBook);
    }
}