package com.smktelkom.rahmad.bookinventory.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smktelkom.rahmad.bookinventory.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BasicActivity extends AppCompatActivity {
    @BindView(R.id.editBookTitle)
    EditText editBookTitle;
    @BindView(R.id.editBookAuthor)
    EditText editBookAuthor;
    @BindView(R.id.editGenre)
    EditText editGenre;
    @BindView(R.id.editIsbn)
    EditText editISBN;
    @BindView(R.id.editPublishedYear)
    EditText editPublishYear;
    @BindView(R.id.editSynopsis)
    EditText editSynopsis;
    @BindView(R.id.btnSave)
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    Toast.makeText(BasicActivity.this, "Data Valid!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private boolean validate() {
        boolean valid = true;
        String isbn = editISBN.getText().toString();
        String booktitle = editBookTitle.getText().toString();
        String bookauthor = editBookAuthor.getText().toString();
        String publishedYear = editPublishYear.getText().toString();
        String genre = editGenre.getText().toString();
        String synopsis = editSynopsis.getText().toString();

        if (isbn.isEmpty()) {
            editISBN.setError("Enter ISBN");
            valid = false;
        } else {
            editISBN.setError(null);
        }

        if (booktitle.isEmpty()) {
            editBookTitle.setError("Enter Book Title");
            valid = false;
        } else {
            editBookTitle.setError(null);
        }

        if (bookauthor.isEmpty()) {
            editBookAuthor.setError("Enter Book Author");
            valid = false;
        } else {
            editBookAuthor.setError(null);
        }

        if (publishedYear.isEmpty() || publishedYear.length() < 4) {
            editPublishYear.setError("Publish Year empty or not in yyyy format");
            valid = false;
        } else {
            editPublishYear.setError(null);
        }

        if (genre.isEmpty()) {
            editGenre.setError("Enter genre");
            valid = false;
        } else {
            editGenre.setError(null);
        }

        if (synopsis.isEmpty()) {
            editSynopsis.setError("Enter synopsis");
            valid = false;
        } else {
            editSynopsis.setError(null);
        }

        return valid;

    }
}
