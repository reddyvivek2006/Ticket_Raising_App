package com.jayanth.customer_support;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class inprogressTickets extends AppCompatActivity {

    LinearLayout[] l=new LinearLayout[10];
    LinearLayout[] cardinl=new LinearLayout[10];
    LinearLayout[] cl=new LinearLayout[10];
    LinearLayout[] rl=new LinearLayout[2];
    CardView[] c=new CardView[10];
    CardView[] pass = new CardView[10];
    TextView[] t=new TextView[10];
    LinearLayout pl;
    tickets tikt;
    static tickets_db tikt_db;
    String[][] cursor_data=new String[10][10];
    String status="inprogress";
    Cursor cursor;
    String[] s={"Date","Ticket No","Subject","Description","Attachment"};

    int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inprogress_tickets);
        setTitle("Inprogress Tickets");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tikt=new tickets();
        tikt_db= Room.databaseBuilder(this, tickets_db.class, "ticket_db").allowMainThreadQueries().build();


        cursor=inprogressTickets.tikt_db.ticketsdao().getAll(status);

        LinearLayout.LayoutParams llp=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        CardView.LayoutParams lp= new CardView.LayoutParams (CardView.LayoutParams.MATCH_PARENT,CardView.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params_cl_head = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params_cl_head.weight=1;
        LinearLayout.LayoutParams params_cl_data = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params_cl_data.weight=1;

        n=inprogressTickets.tikt_db.ticketsdao().getCount("unassigned");
        pl=findViewById(R.id.p1);
        cursor.moveToFirst();
        String[] s1={"date","ticket_no","subject","description","attachment"};
        for(int i=0;i<n && (!cursor.isAfterLast());i++){
            l[i]=new LinearLayout(this);
            c[i]=new CardView(this);
            cardinl[i]=new LinearLayout(this);
            c[i].setLayoutParams(lp);
            l[i].setLayoutParams(llp);
            l[i].setPadding(10,10,10,10);
            cardinl[i].setOrientation(LinearLayout.VERTICAL);
            rl[0]=new LinearLayout(this);
            rl[1]=new LinearLayout(this);
            rl[0].setOrientation(LinearLayout.VERTICAL);
            rl[1].setOrientation(LinearLayout.VERTICAL);
            cl[i]=new LinearLayout(this);
            c[i].setId(i);
            rl[0].setLayoutParams(params_cl_head);
            rl[1].setLayoutParams(params_cl_data);
            for(int j=0;j<5;++j)
            {

                rl[0].setGravity(Gravity.LEFT);
                rl[1].setGravity(Gravity.LEFT);
                t[j]=new TextView(this);
                t[j+5]=new TextView(this);
                t[j].setText(s[j]);
                t[j].setTypeface(null, Typeface.BOLD);
                t[j+5].setText(cursor.getString(cursor.getColumnIndex(s1[j])));
                rl[0].addView(t[j]);
                rl[1].addView(t[j+5]);
            }
            cursor.moveToNext();
            cl[i].setPadding(5,5,5,5);
            cl[i].addView(rl[0]);
            cl[i].addView(rl[1]);
            final int finalI = i;
            c[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pass[finalI]=findViewById(view.getId());
                    Intent i=new Intent(inprogressTickets.this,closedTickets1.class);
                    i.putExtra("t_no",((TextView)(((LinearLayout)(((LinearLayout)pass[finalI].getChildAt(0)).getChildAt(1))).getChildAt(1))).getText().toString());
                    i.putExtra("status","unassigned");
                    startActivity(i);
                }
            });
            c[i].addView(cl[i]);
            l[i].addView(c[i]);
            pl.addView(l[i]);
        }

    }
}