package com.nurde.fromregistation;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroupJK;
    private RadioButton radioButtonJK;
    private TextView dateView;
    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dateView = (EditText) findViewById(R.id.inDate);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        dateView = (EditText) findViewById(R.id.inDate);

    }

    public void SendExtrasBundle(View v){
       EditText nm = (EditText) findViewById(R.id.inNama);
       String nama =nm.getText().toString();
       EditText em = (EditText) findViewById(R.id.inEmail);
       String email = em.getText().toString();
       EditText ps = (EditText) findViewById(R.id.inPassword);
       String pass = ps.getText().toString();
       EditText add = (EditText) findViewById(R.id.inAlamat);
       String alamat = add.getText().toString();
       radioGroupJK = (RadioGroup) findViewById(R.id.radioGroupJenisKelamin);
       int selectId = radioGroupJK.getCheckedRadioButtonId();
       radioButtonJK = (RadioButton) findViewById(selectId);
       String jk = radioButtonJK.getText().toString();
       EditText tmpt = (EditText) findViewById(R.id.inTempatLahir);
       String lahir = tmpt.getText().toString();
       EditText tgl = (EditText) findViewById(R.id.inDate);
       String tanggalLahir = tgl.getText().toString();

        //create object intent
        Intent intent = new Intent(this, SecoundActivity.class);
        //create bundle
        Bundle data = new Bundle();
       intent.putExtra("Nama",nama);
       intent.putExtra("Email",email);
       intent.putExtra("Pass",pass);
       intent.putExtra("Tempat Lahir",lahir);
       intent.putExtra("Tanggal Lahir",tanggalLahir);
       intent.putExtra("Jenis Kelamin",jk);
       intent.putExtra("Alamat",alamat);
        //start activity
        startActivity(intent);

    }
    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        /*Toast.makeText(getApplicationContext(), "ca",
                Toast.LENGTH_SHORT)
                .show();
                */
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this,
                    myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new
            DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker arg0,
                                      int arg1, int arg2, int arg3) {
                    // TODO Auto-generated method stub
                    // arg1 = year
                    // arg2 = month
                    // arg3 = day
                    showDate(arg1, arg2+1, arg3);
                }
            };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
}
