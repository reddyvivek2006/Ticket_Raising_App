package com.jayanth.customer_support;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class closedTickets1 extends AppCompatActivity {
    Spinner status;
    tickets t;
    static tickets_db tdb;
    String tick;
    String status_prev;
    TextView t_no,date,Cstatus,name,email,phone,subject,desc,attachment;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closed_tickets1);
        setTitle("Ticket Details");

        tick = String.valueOf(getIntent().getStringExtra("t_no"));
        status_prev = getIntent().getStringExtra("status");

        t_no = findViewById(R.id.t_no);
        date = findViewById(R.id.date);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        subject = findViewById(R.id.subject);
        desc = findViewById(R.id.desc);
        attachment = findViewById(R.id.attachment);

        t = new tickets();
        tdb = Room.databaseBuilder(this, tickets_db.class, "ticket_db").allowMainThreadQueries().build();

        cursor = closedTickets1.tdb.ticketsdao().gettiktAll(tick);
        cursor.moveToFirst();

        Cstatus=findViewById(R.id.Cstatus);
        t_no.setText(tick);
        Cstatus.setText(cursor.getString(cursor.getColumnIndex("status")));
        date.setText(cursor.getString(1));
        name.setText(cursor.getString(2));
        email.setText(cursor.getString(3));
        phone.setText(cursor.getString(4));
        subject.setText(cursor.getString(5));
        desc.setText(cursor.getString(6));
        attachment.setText(cursor.getString(8));
/*
        attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(closedTickets1.this,pdf_veiwer.class);
                i.putExtra("document",attachment.getText());
                startActivity(i);
            }
        });*/
    }

}
