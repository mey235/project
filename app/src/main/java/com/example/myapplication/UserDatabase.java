package com.example.myapplication;
 import android.content.Context;
 import android.content.Entity;

 import androidx.room.Database;
 import androidx.room.Room;
 import androidx.room.RoomDatabase;
 @Database(entities = {UserEntity.class}, version = 4)
public abstract class UserDatabase extends RoomDatabase {

    public static final String dbname="user";
    private static UserDatabase userdatabase;

    public static synchronized UserDatabase getUserdatabase(Context context)
    {
        if(userdatabase==null)
        {
            userdatabase = Room.databaseBuilder(context,UserDatabase.class,dbname).fallbackToDestructiveMigration().build();
        }
        return userdatabase;
    }
    public abstract UserDao userDao();

}
