package com.example.admin.labbz;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btnZapis = (Button) findViewById(R.id.BtnZapis);
        Button btnOdczyt = (Button) findViewById(R.id.BtnOdczyt);

        btnZapis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntentZapis = new Intent(getApplicationContext(), ZapisDoBazy.class);
                startActivity(IntentZapis);
            }

        });

        btnOdczyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent InstentOdczyt = new Intent(getApplicationContext(), WyszukanieZBazy.class);
                startActivity(InstentOdczyt);
            }
        });

    }
}
