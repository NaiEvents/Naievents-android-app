package com.example.felix_000.naievents_beta;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseCrashReporting;
import com.parse.ParseObject;


public class EventCreationActivity extends ActionBarActivity {
private Button button;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creation);
        // Enable Crash Reporting
        ParseCrashReporting.enable(this);
//Enable Local Datastores
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "yKTdQtjm9QjPKlym7zVFjJrXjbmAX5EncrgUZCbV", "pMSZxLIDpkcgqxIiTYAM1Ybh58uGesRKt5N1nXHf");
    }
   public void addEvent(View view){
       ParseObject event = new ParseObject("EventsData");
  EditText date = (EditText) findViewById(R.id.date);

       event.put("Date", date.getText().toString());
       EditText title = (EditText) findViewById(R.id.title);

       event.put("Title", title.getText().toString());
       EditText location = (EditText) findViewById(R.id.location);

       event.put("Location", location.getText().toString());
       Log.v("Check Value", date.getText().toString());
        event.saveInBackground();
   }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_creation, menu);
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
}
