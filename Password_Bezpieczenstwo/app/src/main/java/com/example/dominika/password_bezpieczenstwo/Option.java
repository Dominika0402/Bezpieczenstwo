package com.example.dominika.password_bezpieczenstwo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dominika on 03.10.2017.
 */

public class Option extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);

        final String text1 = "String";


        Button odczytaj = (Button) findViewById(R.id.button4);
        Button zmien_haslo = (Button) findViewById(R.id.button5);


        final String newString;
        final String newString2;

        String password2;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
                newString2= null;
            } else {
                //newString= extras.getString("message");
                newString2= extras.getString("password");
            }
        } else {
            //newString= (String) savedInstanceState.getSerializable("message");
            newString2= (String) savedInstanceState.getSerializable("password");
        }


        odczytaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Option.this, Show.class);
                //intent.putExtra("message", newString);
                intent.putExtra("password", newString2);

                if(newString2.equals("domi")) {
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "BLAD",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        zmien_haslo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
