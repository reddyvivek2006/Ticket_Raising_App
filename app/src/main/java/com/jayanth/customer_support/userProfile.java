package com.jayanth.customer_support;import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

;

public class userProfile extends AppCompatActivity {

    users u;
    usersdb udb;
    TextView l_id,fname,lname,eid,phone,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setTitle("User Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String login_id=getIntent().getStringExtra("lid");

        Boolean logged=getIntent().getBooleanExtra("logged",false);
        if(login_id!=null) {
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("id",login_id);
            editor.commit();
        }
        else {
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
            login_id= settings.getString("id", "0");
        }
        l_id=findViewById(R.id.id);
        fname=findViewById(R.id.fname);
        lname=findViewById(R.id.lname);
        eid=findViewById(R.id.eid);
        phone=findViewById(R.id.phone);
        address=findViewById(R.id.address);

        u=new users();
        udb = Room.databaseBuilder(this, usersdb.class, "usersdb").allowMainThreadQueries().build();

        address.setText(udb.usersdao().getAddress(login_id));
        l_id.setText(login_id);
        fname.setText(udb.usersdao().getFName(login_id));
        lname.setText(udb.usersdao().getLName(login_id));
        eid.setText(udb.usersdao().getEmail(login_id));
        phone.setText(udb.usersdao().getPhone(login_id));
    }
}
