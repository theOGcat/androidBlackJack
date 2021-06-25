package com.example.finalproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface UserDAO {

    @Insert
    void Insert(User user);

    @Insert
    void Insert(UserScores userScores);

    @Update
    public void updateUsers(User... users);

    @Query("SELECT * FROM UserScores NATURAL JOIN User WHERE username = :username")
    public List<UserScores> getUserScores(String username);

    @Query("SELECT username FROM User WHERE username = :username LIMIT 1")
    public String checkUser(String username);

    @Query("SELECT username FROM User")
    public List<String> cookieUser();



}
