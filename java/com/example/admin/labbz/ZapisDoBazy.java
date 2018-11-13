package com.example.admin.labbz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ZapisDoBazy extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zapis);


        final EditText ImieOsoby = (EditText) findViewById(R.id.eTxTImie);
        final EditText NazwiskoOsoby = (EditText) findViewById(R.id.eTxTNazwisko);
        final EditText WiekOsoby = (EditText) findViewById(R.id.eTxTWiek);
        Button DodajOsobe = (Button) findViewById(R.id.btnDodaj);

        DodajOsobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    SQLiteDatabase baza = openOrCreateDatabase("baza.db", Context.MODE_PRIVATE,null);
                    baza.execSQL("CREATE TABLE IF NOT EXISTS 'Osoba' (idOsoba INTEGER PRIMARY KEY, Imie STRING, Nazwisko STRING, Wiek STRING) ");
                    ContentValues rekord = new ContentValues();
                    rekord.put("Imie", ImieOsoby.getText().toString());
                    rekord.put("Nazwisko", NazwiskoOsoby.getText().toString());
                    rekord.put("Wiek", WiekOsoby.getText().toString());
                    baza.insert("Osoba", null, rekord);
                    baza.close();

                    ImieOsoby.setText("");
                    NazwiskoOsoby.setText("");
                    WiekOsoby.setText("");

                    Toast.makeText(getApplicationContext(), "Zapis powiódł się", Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {

                    Toast.makeText(getApplicationContext(), "Zapis nie powiódł się", Toast.LENGTH_LONG).show();

                }
            }
        });
}
}
