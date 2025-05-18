package com.example.woofer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Linking Navigation button.....
        ImageButton bookmarkButton=findViewById(R.id.bookmarkButton);
        bookmarkButton.setOnClickListener(v->{
            Intent intent=new Intent(MenuActivity.this, SavedPostsActivity.class);
            startActivity(intent);
        });
        ImageButton addPostButton=findViewById(R.id.addPostButton);
        addPostButton.setOnClickListener(v->{
            Intent intent=new Intent(MenuActivity.this, NewPostsActivity.class);
            startActivity(intent);
        });
        ImageButton inboxButton=findViewById(R.id.inboxButton);
        inboxButton.setOnClickListener(v->{
            Intent intent=new Intent(MenuActivity.this,DmHome.class );
            startActivity(intent);
        });
        ImageButton homeButton=findViewById(R.id.homeButton);
        homeButton.setOnClickListener(v->{
            Intent intent=new Intent(MenuActivity.this, HomeScreen.class);
            startActivity(intent);
        });
        //End of linking navigation
        //Top bar
        ImageButton exit=findViewById(R.id.exit);
        exit.setOnClickListener(v->{
            Intent intent=new Intent(MenuActivity.this, HomeScreen.class);
            startActivity(intent);
        });
    }
}