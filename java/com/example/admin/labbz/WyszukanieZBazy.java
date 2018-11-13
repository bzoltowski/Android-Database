package com.example.admin.labbz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WyszukanieZBazy extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wyszukanie);

        Button Szukaj_Imie = (Button) findViewById(R.id.btnSzukaj_Imie);
        Button Szukaj_Nazwisko = (Button) findViewById(R.id.btnSzukajNazwisko);
        final EditText eTxT_Imie = (EditText) findViewById(R.id.eTxTImie);
        final EditText eTxT_Nazwisko = (EditText) findViewById(R.id.eTxTNazwisko);
        final EditText eTxT_Wiek = (EditText) findViewById(R.id.eTxTWiek);



        Szukaj_Imie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(eTxT_Imie.getText().toString() == ""){
                    Toast.makeText(getApplicationContext(),"Wprowadź dane", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    try{
                        SQLiteDatabase baza = openOrCreateDatabase("baza.db", Context.MODE_PRIVATE,null);
                        String kolumny[] = {"Imie", "Nazwisko", "Wiek"};
                        Cursor k=baza.query("Osoba", kolumny, "Imie=?", new String[]{eTxT_Imie.getText().toString()},null,null,null);
                        k.moveToFirst();
                        baza.close();
                        eTxT_Nazwisko.setText(k.getString(1));
                        eTxT_Wiek.setText(k.getString(2));

                    }
                    catch (Exception e)
                    {

                        Toast.makeText(getApplicationContext(), "Odczyt nie powiódł się", Toast.LENGTH_LONG).show();
                    }


                }
            }
        });

        Szukaj_Nazwisko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(eTxT_Nazwisko.getText().toString() == ""){
                    Toast.makeText(getApplicationContext(),"Wprowadź dane", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    try{
                        String nazwisko = (eTxT_Nazwisko.getText()).toString();
                        String imie;
                        Integer wiek;

                        SQLiteDatabase baza = openOrCreateDatabase("baza.db", Context.MODE_PRIVATE, null);
                        String kolumny[] = {"imie", "nazwisko", "wiek"};
                        Cursor k = baza.query("osoby", kolumny, "nazwisko=?", new String[]{nazwisko}, null, null,null);
                        baza.close();
                        k.moveToFirst();

                        imie = k.getString(0);
                        wiek = Integer.valueOf(k.getString(2));

                        k.close();

                        eTxT_Imie.setText(imie);
                        eTxT_Wiek.setText(wiek);

                    }
                    catch (Exception e)
                    {

                        Toast.makeText(getApplicationContext(), "Odczyt nie powiódł się", Toast.LENGTH_LONG).show();
                    }


                }
            }
        });
    }
}
