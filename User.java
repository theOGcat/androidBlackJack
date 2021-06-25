package com.example.finalproject;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "User")
public class User {
    @PrimaryKey
    @NonNull
    public String username;
    public User(@NonNull String username){
        this.username = username;
    }
}