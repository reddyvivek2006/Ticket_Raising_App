package com.jayanth.customer_support;

import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createTickets extends AppCompatActivity {

    EditText name,email,ph_no,school_name,sub,des;
    tickets t;
    Button submit,reset;
    static tickets_db tdb;
    int t_no;
    SharedPreferences wmbPreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tickets);
        setTitle("Create Ticket");

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        ph_no=findViewById(R.id.ph_no);
        school_name=findViewById(R.id.school_name);
        sub=findViewById(R.id.sub);
        des=findViewById(R.id.des);
        submit=findViewById(R.id.submit);
        reset=findViewById(R.id.reset);

        wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        t_no = wmbPreference.getInt("t_no", 1600);


        t=new tickets();
        tdb= Room.databaseBuilder(this, tickets_db.class, "ticket_db").allowMainThreadQueries().build();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setName(name.getText().toString());
                t.setEmail(email.getText().toString());
                t.setPhone_no(ph_no.getText().toString());
                t.setSubject(sub.getText().toString());
                t.setDescription(des.getText().toString());
                t.setStatus("unassigned");
                t.setDate("28/07/2019");
                t.setTicket_no(String.valueOf(t_no));
                t_no++;

                SharedPreferences.Editor editor = wmbPreference.edit();
                editor.putInt("t_no", t_no);
                editor.commit();

                createTickets. tdb.ticketsdao().insert(t);
                Toast.makeText(createTickets.this,"ticket added",Toast.LENGTH_SHORT).show();

                reset(v);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void reset(View v){

        name.setText("");
        email.setText("");
        ph_no.setText("");
        school_name.setText("");
        sub.setText("");
        des.setText("");

    }

}
