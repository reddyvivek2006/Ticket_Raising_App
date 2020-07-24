package com.jayanth.customer_support;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class loginpage extends AppCompatActivity {

    EditText id, pass;
    String s_id, s_pass;
    static usersdb udb;
    Intent i;
    static String logged="";
    users u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        setTitle("Login");

        id = findViewById(R.id.login_id);
        pass = findViewById(R.id.pass);
        u = new users();
        udb = Room.databaseBuilder(this, usersdb.class, "usersdb").allowMainThreadQueries().build();

    }


    public void log_in(View v) {

        s_id = id.getText().toString();
        s_pass = pass.getText().toString();
        String db_pass = loginpage.udb.usersdao().getPass(s_id);
        if (s_pass.equals(db_pass)) {
            i = new Intent(this, MainActivity.class);
            i.putExtra("login_id",s_id);
            i.putExtra("logged",true);
            startActivity(i);
        }
        else {

        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}