package com.jayanth.customer_support;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = tickets.class,version = 1)
public abstract class tickets_db extends RoomDatabase {

    public abstract ticketsdao ticketsdao();
}
