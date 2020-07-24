package com.jayanth.customer_support;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = users.class,version =1)
public abstract class usersdb extends RoomDatabase {

    public abstract usersdao usersdao();

}
