package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(primaryKeys = {"username", "time"}, foreignKeys = @ForeignKey(entity = User.class, parentColumns = "username", childColumns = "username",onDelete = ForeignKey.CASCADE))
public class UserScores {

    @NonNull
    public String username;

    public long time;

    public int win;
    public int lose;

    public UserScores(String username, int win,int lose){
        this.username = username;
        time = System.currentTimeMillis();
        this.win = win;
        this.lose = lose;
    }
}
