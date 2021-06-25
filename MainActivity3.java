package com.example.finalproject;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Query;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;


public class MainActivity3 extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        TextView mytext = findViewById(R.id.result);
        boolean isPlayerWin = MainActivity2.playerWin;
      if (isPlayerWin){
          mytext.setText("Congrats, you win !");
      }
      else mytext.setText("You lose, Try again !");

    }

    public void clickMethodPlaya(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
