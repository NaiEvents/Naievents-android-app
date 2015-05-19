package com.example.felix_000.naievents_beta;

import android.app.DatePickerDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseCrashReporting;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class EventCreationActivity extends ActionBarActivity implements View.OnClickListener {
    private Button saveButton;
    private EditText editText;
    private DatePickerDialog datePickerDialog;
    private EditText fromDate;
    private EditText toDate;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private Button button;
    ParseObject event = new ParseObject("EventsData");
    private SimpleDateFormat simpleDateFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_creation);
        // Enable Crash Reporting
        ParseCrashReporting.enable(this);
         //Enable Local Datastores
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "yKTdQtjm9QjPKlym7zVFjJrXjbmAX5EncrgUZCbV", "pMSZxLIDpkcgqxIiTYAM1Ybh58uGesRKt5N1nXHf");
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        findViewsById();
        setDateTimeField();
        saveButton = (Button) findViewById(R.id.add);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.put("fromDate", fromDate.getText().toString());
                event.put("toDate", toDate.getText().toString());
                EditText title = (EditText) findViewById(R.id.title);
                event.put("Title", title.getText().toString());
                EditText location = (EditText) findViewById(R.id.location);
                event.put("Location", location.getText().toString());
                //try to save image
//                Drawable drawable = getResources().getDrawable(R.drawable.lufthansa) ;
//
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                byte[] data = stream.toByteArray();
//
//                ParseFile imageFile = new ParseFile("lufthansa.png", data);
                event.saveInBackground();
            }
        });

    }
    //Set Date Pickers

    private void findViewsById() {
        fromDate = (EditText) findViewById(R.id.fromdate);
        fromDate.setInputType(InputType.TYPE_NULL);
        fromDate.requestFocus();

        toDate = (EditText) findViewById(R.id.todate);
        toDate.setInputType(InputType.TYPE_NULL);
        fromDate.requestFocus();
    }

    private void setDateTimeField() {
        fromDate.setOnClickListener(this);
        toDate.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDate.setText(simpleDateFormat.format(newDate.getTime()));


            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDate.setText(simpleDateFormat.format(newDate.getTime()));


            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
   public void addEvent(View view){
      // setDateTimeField();


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

    @Override
    public void onClick(View view) {
        if(view == fromDate) {
            fromDatePickerDialog.show();
        } else if(view == toDate) {
            toDatePickerDialog.show();
        }
    }
}
