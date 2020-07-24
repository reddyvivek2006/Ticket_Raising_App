package com.jayanth.customer_support;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    tickets tikt;
    static tickets_db tikt_db;
    boolean logged;
    users u;
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    String lid;
    static usersdb udb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Dash Board");

         lid=getIntent().getStringExtra("login_id");
        logged=getIntent().getBooleanExtra("logged",true);

        tikt=new tickets();
        tikt_db= Room.databaseBuilder(this, tickets_db.class, "ticket_db").allowMainThreadQueries().build();

        u = new users();
        udb = Room.databaseBuilder(this, usersdb.class, "usersdb").allowMainThreadQueries().build();

        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRST_RUN", true);
        if (isFirstRun)
        {
            logged=false;
            insertUsers();
            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRST_RUN", false);
            editor.commit();
            insertickets();

            if(!logged) {
                Intent i = new Intent(MainActivity.this, loginpage.class);
                logged=true;
                i.putExtra("logged", logged);
                i.putExtra("lid",lid);
                startActivity(i);
            }

        }
        userProfile();
        createTickets();
        unassignedTickets();
        openTickets();
        closedTickets();
        feedBack();
    }

    public void insertUsers(){
        u.setLogin_id("emp001");
        u.setPswd("qwerty");
        u.setFirst_name("Sunku");
        u.setLast_name("prashanth");
        u.setEmail_id("prashanth@gmail.com");
        u.setAddress("Saroor Nagar");
        u.setPhone_no("0123456789");
        MainActivity.udb.usersdao().insert(u);

        u.setLogin_id("emp002");
        u.setPswd("asd123");
        u.setFirst_name("allot");
        u.setLast_name("ali");
        u.setEmail_id("allotali@gmail.com");
        u.setAddress("h.no-18-11,kamala Nagar,hyderabad");
        u.setPhone_no("9836452312");
        MainActivity.udb.usersdao().insert(u);

        u.setLogin_id("emp003");
        u.setPswd("passout");
        u.setFirst_name("achan");
        u.setLast_name("varshith");
        u.setEmail_id("varshith6@gmail.com");
        u.setAddress("h.no-123/5,p&t colony,hyderabad");
        u.setPhone_no("9584631579");
        MainActivity.udb.usersdao().insert(u);

        u.setLogin_id("emp004");
        u.setPswd("rohan@123");
        u.setFirst_name("maddi");
        u.setLast_name("rohan");
        u.setEmail_id("rohanmaddi@gmail.com");
        u.setAddress("hitech city");
        u.setPhone_no("8925413671");
        MainActivity.udb.usersdao().insert(u);

        u.setLogin_id("emp005");
        u.setPswd("passpass");
        u.setFirst_name("verri");
        u.setLast_name("danush");
        u.setEmail_id("danush06@gmail.com");
        u.setAddress("h.no-45/A,kuatpally,hyderabad");
        u.setPhone_no("9754168254");
        MainActivity.udb.usersdao().insert(u);

        u.setLogin_id("emp006");
        u.setPswd("swanith");
        u.setFirst_name("madeli");
        u.setLast_name("swanith");
        u.setEmail_id("swanith456@gmail.com");
        u.setAddress("h.no-11-40,hastinapuram,vizag");
        u.setPhone_no("8547625032");
        MainActivity.udb.usersdao().insert(u);

        u.setLogin_id("emp007");
        u.setPswd("jayanth124");
        u.setFirst_name("saiad");
        u.setLast_name("jayanth");
        u.setEmail_id("jayanth12@gmail.com");
        u.setAddress("h.no-24-10,ravinagar,vijayadwada");
        u.setPhone_no("9154780189");
        MainActivity.udb.usersdao().insert(u);
    }

    public void insertickets(){

        tikt.setDate("22/12/2018");
        tikt.setTicket_no("1593");
        tikt.setSubject("class room");
        tikt.setDescription("untidy");
        tikt.setAttachment("doc1");
        tikt.setName("prashanth");
        tikt.setEmail("prashanth@gmail.com");
        tikt.setPhone_no("9494106895");
        tikt.setStatus("inprogress");

        MainActivity.tikt_db.ticketsdao().insert(tikt);


        tikt.setName("jayanth");
        tikt.setEmail("jayanth@gmail.com");
        tikt.setPhone_no("9875123405");
        tikt.setStatus("closed");
        tikt.setDate("2/2/18");
        tikt.setTicket_no("1526");
        tikt.setSubject("wash room");
        tikt.setDescription("untidy");
        tikt.setAttachment("doc2");

        MainActivity.tikt_db.ticketsdao().insert(tikt);

        tikt.setName("vivek");
        tikt.setEmail("vivek@gmail.com");
        tikt.setPhone_no("9014642587");
        tikt.setStatus("closed");
        tikt.setDate("12/1/19");
        tikt.setTicket_no("1527");
        tikt.setSubject("bus");
        tikt.setDescription("untidy");
        tikt.setAttachment("doc1");

        MainActivity.tikt_db.ticketsdao().insert(tikt);

        tikt.setName("dinesh");
        tikt.setEmail("dinesh12@gmail.com");
        tikt.setPhone_no("9812452587");
        tikt.setStatus("inprogress");
        tikt.setDate("4/4/18");
        tikt.setTicket_no("1530");
        tikt.setSubject("faculty");
        tikt.setDescription("less in number");
        tikt.setAttachment("doc2");

        MainActivity.tikt_db.ticketsdao().insert(tikt);

        tikt.setName("arthi");
        tikt.setEmail("arthi45@gmail.com");
        tikt.setPhone_no("9000125587");
        tikt.setStatus("closed");
        tikt.setDate("20/10/19");
        tikt.setTicket_no("1531");
        tikt.setSubject("adminstration");
        tikt.setDescription("not upto the mark");
        tikt.setAttachment("doc1");

        MainActivity.tikt_db.ticketsdao().insert(tikt);

        tikt.setName("vamshi");
        tikt.setEmail("vamshi12@gmail.com");
        tikt.setPhone_no("9105558787");
        tikt.setStatus("unassigned");
        tikt.setDate("2/2/18");
        tikt.setTicket_no("1533");
        tikt.setSubject("adminstration");
        tikt.setDescription("books");
        tikt.setAttachment("doc2");

        MainActivity.tikt_db.ticketsdao().insert(tikt);

        tikt.setName("teja");
        tikt.setEmail("teja12@gmail.com");
        tikt.setPhone_no("8754210017");
        tikt.setStatus("unassigned");
        tikt.setDate("16/1/17");
        tikt.setTicket_no("1534");
        tikt.setSubject("class room");
        tikt.setDescription("ventilation");
        tikt.setAttachment("doc2");

        MainActivity.tikt_db.ticketsdao().insert(tikt);

        tikt.setName("rupa");
        tikt.setEmail("rupa@gmail.com");
        tikt.setPhone_no("8775642587");
        tikt.setStatus("unassigned");
        tikt.setDate("2/2/18");
        tikt.setTicket_no("1537");
        tikt.setSubject("adminstration");
        tikt.setDescription("study structure");
        tikt.setAttachment("doc1");

        MainActivity.tikt_db.ticketsdao().insert(tikt);

        tikt.setName("buddy");
        tikt.setEmail("buddy@gmail.com");
        tikt.setPhone_no("9000112587");
        tikt.setStatus("unassigned");
        tikt.setDate("12/8/18");
        tikt.setTicket_no("1538");
        tikt.setSubject("campus");
        tikt.setDescription("water");
        tikt.setAttachment("doc1");

        MainActivity.tikt_db.ticketsdao().insert(tikt);

        tikt.setName("bharath");
        tikt.setEmail("bharath@gmail.com");
        tikt.setPhone_no("9887766554");
        tikt.setStatus("unassigned");
        tikt.setDate("28/2/18");
        tikt.setTicket_no("1540");
        tikt.setSubject("play ground");
        tikt.setDescription("untidy");
        tikt.setAttachment("doc1");

        MainActivity.tikt_db.ticketsdao().insert(tikt);

        tikt.setName("sai");
        tikt.setEmail("sai12@gmail.com");
        tikt.setPhone_no("8754210321");
        tikt.setStatus("inprogress");
        tikt.setDate("12/4/18");
        tikt.setTicket_no("1544");
        tikt.setSubject("faculty");
        tikt.setDescription("syllabus coverage");
        tikt.setAttachment("doc1");

        MainActivity.tikt_db.ticketsdao().insert(tikt);

        tikt.setName("koushika");
        tikt.setEmail("koushika@gmail.com");
        tikt.setPhone_no("9822222587");
        tikt.setStatus("closed");
        tikt.setDate("18/8/19");
        tikt.setTicket_no("1548");
        tikt.setSubject("class room");
        tikt.setDescription("benches");
        tikt.setAttachment("doc2");

        MainActivity.tikt_db.ticketsdao().insert(tikt);
    }

    public void userProfile(){
        CardView c1=findViewById(R.id.c1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, userProfile.class);
                intent.putExtra("logged",logged);
                intent.putExtra("lid",lid);
                startActivity(intent);
            }
        });
    }

    public void createTickets(){
        CardView c2=findViewById(R.id.c2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, createTickets.class);
                startActivity(intent);
            }
        });
    }

    public void unassignedTickets(){
        CardView c4=findViewById(R.id.c3);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, unassignedTickets.class);
                startActivity(intent);
            }
        });

    }

    public void openTickets(){
        CardView c5=findViewById(R.id.c4);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, inprogressTickets.class);
                startActivity(intent);
            }
        });

    }

    public void closedTickets(){
        CardView c6=findViewById(R.id.c5);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, closedTickets.class);
                startActivity(intent);
            }
        });
    }
    public void feedBack(){
        CardView c7=findViewById(R.id.c6);
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,feedback.class);
                startActivity(i);
            }
        });
    }
    public void logout(View v){
        logged=false;
        Intent i=new Intent(MainActivity.this,loginpage.class);
        startActivity(i);
    }

}
