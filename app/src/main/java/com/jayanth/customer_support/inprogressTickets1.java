package com.jayanth.customer_support;

import android.arch.persistence.room.Room;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class inprogressTickets1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner status;
    String statusarray[]={"unassigned","inprogress","closed"};
    tickets t;
    static tickets_db tdb;
    String tick;
    String status_prev;
    TextView Cstatus,t_no,date,name,email,phone,subject,desc,attachment;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inprogress_tickets1);
        setTitle("Ticket Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tick= String.valueOf(getIntent().getStringExtra("t_no"));
        status_prev=getIntent().getStringExtra("status");

        status=findViewById(R.id.status);
        ArrayAdapter<CharSequence> sadapter=new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,statusarray);
        sadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        status.setAdapter(sadapter);
        status.setSelection(sadapter.getPosition(status_prev));
        status.setOnItemSelectedListener(this);

        Cstatus=findViewById(R.id.Cstatus);
        t_no=findViewById(R.id.t_no);
        date=findViewById(R.id.date);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        subject=findViewById(R.id.subject);
        desc=findViewById(R.id.desc);
        attachment=findViewById(R.id.attachment);

        t=new tickets();
        tdb= Room.databaseBuilder(this, tickets_db.class, "ticket_db").allowMainThreadQueries().build();

        cursor=inprogressTickets1.tdb.ticketsdao().gettiktAll(tick);
        cursor.moveToFirst();

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
                Intent i=new Intent(ticket_intent.this,pdf_veiwer.class);
                i.putExtra("document",attachment.getText());
                startActivity(i);
            }
        });*/

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int select_item_pos, long l) {
        String stts= (String) adapterView.getItemAtPosition(select_item_pos);
        if(stts.equals(status_prev)){
            //do none
        }
        else{
            inprogressTickets1.tdb.ticketsdao().updatestts(tick,stts);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
