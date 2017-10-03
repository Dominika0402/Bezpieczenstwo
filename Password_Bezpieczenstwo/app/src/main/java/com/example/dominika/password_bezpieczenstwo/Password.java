package com.example.dominika.password_bezpieczenstwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dominika on 03.10.2017.
 */

public class Password extends AppCompatActivity {

    String password2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.password);

        Button button = (Button) findViewById(R.id.button2);
        final EditText password = (EditText) findViewById(R.id.editText3);

        final String newString;
        /*if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("message");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("message");
        }*/


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                password2 = password.getText().toString();
                Intent intent = new Intent(Password.this, Option.class);
                //intent.putExtra("message", newString);
                intent.putExtra("password", password2);
                startActivity(intent);
            }
        });
    }
}
