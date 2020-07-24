package com.jayanth.customer_support;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface usersdao {

    @Insert
    void insert(users u);

    @Query("select pswd from users where login_id=:g_id")
    String getPass(String g_id);

    @Query("select first_name from users where login_id=:g_id")
    String getFName(String g_id);

    @Query("select last_name from users where login_id=:g_id")
    String getLName(String g_id);

    @Query("select phone_no from users where login_id=:g_id")
    String getPhone(String g_id);

    @Query("select email_id from users where login_id=:g_id")
    String getEmail(String g_id);

    @Query("select address from users where login_id=:g_id")
    String getAddress(String g_id);
}
