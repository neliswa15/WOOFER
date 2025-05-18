package com.example.woofer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SavedPostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saved_posts);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Linking Navigation button.....
        //bookmarkButton
        ImageButton addPostButton=findViewById(R.id.addPostButton);
        addPostButton.setOnClickListener(v->{
            Intent intent=new Intent(SavedPostsActivity.this, SavedPostsActivity.class);
            startActivity(intent);
        });
        //settingsButtons
        ImageButton settingsButtons=findViewById(R.id.settingsButton);
        settingsButtons.setOnClickListener(v->{
            Intent intent=new Intent(SavedPostsActivity.this, NewPostsActivity.class);
            startActivity(intent);
        });
        //inboxButton
        ImageButton inboxButton=findViewById(R.id.inboxButton);
        inboxButton.setOnClickListener(v->{
            Intent intent=new Intent(SavedPostsActivity.this,DmHome.class );
            startActivity(intent);
        });
        //homeButton
        ImageButton homeButton=findViewById(R.id.homeButton);
        homeButton.setOnClickListener(v->{
            Intent intent=new Intent(SavedPostsActivity.this, HomeScreen.class);
            startActivity(intent);
        });
        //End of linking navigation
    }
}