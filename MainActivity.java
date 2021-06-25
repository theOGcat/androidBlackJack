package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button Select;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.TextPersonName);
        Select = findViewById(R.id.button);
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getX() >= (editText.getWidth() - editText
                            .getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        editText.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(R.drawable.down), null);
                        showListPopulWindow(view);
                        return true;
                    }
                }
                return false;
            }
        });

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserDatabase db = UserDatabase.getDatabase(getApplicationContext());
                UserDAO userDAO = db.userDAO();
                String username = editText.getText().toString();

                if (!editText.getText().toString().matches("")) {

                    if (userDAO.checkUser(username) == null) {
                        UserDatabase.databaseWriteExecutor.execute(() -> {
                            User newUser = new User(username);
                            userDAO.Insert(newUser);

                        });
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("username", username);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("username", username);
                        startActivity(intent);
                    }

                }
            }
        });


    }


    public void showListPopulWindow(View view) {

        UserDatabase db = UserDatabase.getDatabase(getApplicationContext());
        UserDAO userDAO= db.userDAO();

        List<String> list;
        list = userDAO.cookieUser();
        final ListPopupWindow listPopupWindow;
        listPopupWindow = new ListPopupWindow(MainActivity.this);
        listPopupWindow.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list));
        listPopupWindow.setAnchorView(editText);
        listPopupWindow.setModal(true);
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                editText.setText(list.get(i));
                listPopupWindow.dismiss();
            }
        });
        listPopupWindow.show();


    }

}