package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void RegisterUser(UserEntity userEntity);

    @Query("SELECT * FROM users where user=(:Userid) and   password = (:password)")
    UserEntity login(String Userid , String password);



}
