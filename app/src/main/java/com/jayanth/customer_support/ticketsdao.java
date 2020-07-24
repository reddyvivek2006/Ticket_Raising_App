package com.jayanth.customer_support;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.database.Cursor;

@Dao
public interface ticketsdao {

    @Insert
    void insert(tickets t);

    @Query("select count(*) from tickets where status=:stts")
    int getCount(String stts);

    @Query("select * from tickets where status=:stts")
    Cursor getAll(String stts);

    @Query("select * from tickets where ticket_no=:tno")
    Cursor gettiktAll(String tno);

    @Query("Select date from tickets where ticket_no=:t_no and status=:stts")
    String getDate(String t_no,String stts);

    @Query("Select subject from tickets where ticket_no=:t_no and status=:stts")
    String getSub(String t_no,String stts);

    @Query("Select description from tickets where ticket_no=:t_no and status=:stts")
    String getDesc(String t_no,String stts);

    @Query("Select attachment from tickets where ticket_no=:t_no and status=:stts")
    String getAttchmnt(String t_no,String stts);

    @Query("update tickets set status=:stts where ticket_no=:t_no")
    void updatestts(String t_no,String stts);
}
