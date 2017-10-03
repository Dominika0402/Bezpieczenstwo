package com.example.dominika.password_bezpieczenstwo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Password extends AppCompatActivity {

    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.password_layout);

        context = getApplicationContext();
        Button password = (Button) findViewById(R.id.password_B);
        final EditText password_et = (EditText) findViewById(R.id.password_ET);


        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getApplicationContext().getSharedPreferences("preferences_name",
                        getApplicationContext().MODE_PRIVATE);
                String value = preferences.getString("password", "");
                if (value.equals(password_et.getText().toString()))
                {
                    Intent intent = new Intent(Password.this, Option.class);
                    startActivity(intent);
                }
                else if (value.equals(""))
                {
                    SharedPreferences preferences2 = context.getSharedPreferences("preferences_name", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences2.edit();
                    editor.putString("password", password_et.getText().toString());
                    editor.commit();

                    Intent intent = new Intent(Password.this, WriteMessage.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "BLAD", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
