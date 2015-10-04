package com.example.user.weekday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class WeekDay extends AppCompatActivity {


    private int day;
    private int month;
    private int year;
    private int century;
    private int d;
    public String theDAY;
    private EditText et_day;
    private EditText et_month;
    private EditText et_year;
    private TextView gg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_day);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_week_day, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getInput()
    {
        et_day = (EditText) findViewById(R.id.editText2);
        et_month = (EditText) findViewById(R.id.editText);
        et_year = (EditText) findViewById(R.id.editText3);

        day = Integer.parseInt(et_day.getText().toString());
        month = Integer.parseInt(et_month.getText().toString());
        year = Integer.parseInt(et_year.getText().toString());

        century = year / 100;
        year = year - (century * 100);
        if (month == 1 || month == 2)
            month = month + 12;

    }

    public void onClickCompute(View view){
        getInput();

        d = (day + ((26 * (month + 1)) / 10) + year + (year / 4) + (century / 4) + (5 * century)) % 7;


        if (d == 0)
            theDAY = "Saturday";
        else if (d == 1)
            theDAY = "Sunday";
        else if (d == 2)
            theDAY = "Monday";
        else if (d == 3)
            theDAY = "Tuesday";
        else if (d == 4)
            theDAY = "Wednesday";
        else if (d == 5)
            theDAY = "Thursday";
        else if (d == 6)
            theDAY = "Friday";


        //gg = (TextView) findViewById(R.id.textView4);
        //gg.setText((theDAY));


        //startActivity(new Intent(this.getApplication(), WeekDayActivity2.class));

        // Intent to go to the second activity
        Intent i = new Intent(this, WeekDayActivity2.class);

        // Put attachment data along with the intent
        i.putExtra("message", theDAY);

        startActivity(i);
    }
}
