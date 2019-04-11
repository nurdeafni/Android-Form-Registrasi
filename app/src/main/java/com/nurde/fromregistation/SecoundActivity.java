package com.nurde.fromregistation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecoundActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secound);

        //get intent
        Intent intent = getIntent();

        //get extra with bundle
        Bundle data = intent.getExtras();
        String nama = data.getString("Nama");
        String email = data.getString("Email");
        String passw = data.getString("Pass");
        String lahir = data.getString("Tempat Lahir");
        String JK = data.getString("Jenis Kelamin");
        String tgl = data.getString("Tanggal Lahir");
        String alamat = data.getString("Alamat");

        //give data to name
        TextView nm = (TextView) findViewById(R.id.txtNama);
        nm.setText(nama);
        TextView eml = (TextView) findViewById(R.id.txtEmail);
        eml.setText(email);
        TextView pass = (TextView) findViewById(R.id.txtPass);
        pass.setText(passw);
        TextView jk = (TextView) findViewById(R.id.txtJK);
        jk.setText(JK);
        TextView tl = (TextView) findViewById(R.id.txtTempatLahir);
        tl.setText(lahir);
        TextView tg = (TextView) findViewById(R.id.txtTanggalLahir);
        tg.setText(tgl);
        TextView almt = (TextView) findViewById(R.id.txtAlamat);
        almt.setText(alamat);

    }
}
