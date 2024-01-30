package com.example.likesanddislikescount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final String save_value_like = "LikeSave";
    public final String save_value_dislike = "DislikeSave";
    public Button likeButton, dislikeButton, resetButton;
    public TextView likeText;
    public TextView dislikeText;
    public ImageView likeView, dislikeView;
    public int like = 0;
    public int dislike = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        likeText = findViewById(R.id.likeText);
        dislikeText = findViewById(R.id.dislikeText);
        likeButton = findViewById(R.id.likeButton);
        dislikeButton = findViewById(R.id.dislikeButton);
        resetButton = findViewById(R.id.resetButton);
//        likeView = findViewById(R.id.likeView);
//        dislikeView = findViewById(R.id.dislikeView);

        View.OnClickListener ourLikeClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like++;
                likeText.setText(Integer.toString(like));
                Toast.makeText(MainActivity.this, "You Clicked LIKE button", Toast.LENGTH_SHORT).show();
                // Always set likeView visible
            }
        };

        View.OnClickListener ourDislikeClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dislike++;
                dislikeText.setText(Integer.toString(dislike));
                // Always set dislikeView visible
                Toast.makeText(MainActivity.this, "You Clicked DISLIKE button", Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener ourResetButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like = 0;
                dislike = 0;
                likeText.setText(Integer.toString(like));
                dislikeText.setText(Integer.toString(dislike));
                Toast.makeText(MainActivity.this, "You Clicked RESET button", Toast.LENGTH_SHORT).show();

            }
        };

        likeButton.setOnClickListener(ourLikeClick);
        dislikeButton.setOnClickListener(ourDislikeClick);
        resetButton.setOnClickListener(ourResetButton);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(save_value_like, likeText.getText().toString());
        outState.putString(save_value_dislike, dislikeText.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String saveLike = savedInstanceState.getString(save_value_like);
        String saveDislike = savedInstanceState.getString(save_value_dislike);
        like = Integer.parseInt(saveLike);
        dislike = Integer.parseInt(saveDislike);
        likeText.setText(saveLike);
        dislikeText.setText(saveDislike);
    }
}
