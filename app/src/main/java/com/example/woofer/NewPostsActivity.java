package com.example.woofer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewPostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_posts);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Linking Navigation button.....
        //bookmarkButton
        ImageButton bookmarkButton=findViewById(R.id.bookmarkButton);
        bookmarkButton.setOnClickListener(v->{
            Intent intent=new Intent(NewPostsActivity.this, SavedPostsActivity.class);
            startActivity(intent);
        });
        //settingsButtons
        ImageButton settingsButtons=findViewById(R.id.settingsButton);
        settingsButtons.setOnClickListener(v->{
            Intent intent=new Intent(NewPostsActivity.this, NewPostsActivity.class);
            startActivity(intent);
        });
        //inboxButton
        ImageButton inboxButton=findViewById(R.id.inboxButton);
        inboxButton.setOnClickListener(v->{
            Intent intent=new Intent(NewPostsActivity.this,DmHome.class );
            startActivity(intent);
        });
        //homeButton
        ImageButton homeButton=findViewById(R.id.homeButton);
        homeButton.setOnClickListener(v->{
            Intent intent=new Intent(NewPostsActivity.this, HomeScreen.class);
            startActivity(intent);
        });
        //End of linking navigation
        //postInput

    }
}