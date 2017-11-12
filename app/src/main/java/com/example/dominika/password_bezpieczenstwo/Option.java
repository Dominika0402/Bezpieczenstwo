package com.example.dominika.password_bezpieczenstwo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
        setContentView(R.layout.option_layout);

        Button new_message = (Button) findViewById(R.id.new_message);
        Button change_pass = (Button) findViewById(R.id.change_pass);
        Button show_message = (Button) findViewById(R.id.show_mess);


        new_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Option.this, WriteMessage.class);
                startActivity(intent);
            }
        });

        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Option.this, ChangePassword.class);
                startActivity(intent);
            }
        });

        show_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Option.this, Show.class);
                startActivity(intent);
            }
        });
    }
}
