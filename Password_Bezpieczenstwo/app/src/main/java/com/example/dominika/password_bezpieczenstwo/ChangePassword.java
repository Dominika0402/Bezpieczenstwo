package com.example.dominika.password_bezpieczenstwo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Dominika on 03.10.2017.
 */

public class ChangePassword extends AppCompatActivity {

    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.change_pass_layout);

        context = getApplicationContext();
        final EditText change_pass = (EditText) findViewById(R.id.change_pass_ET);
        Button change = (Button) findViewById(R.id.change_pass_B);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = context.getSharedPreferences("preferences_name", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("password", change_pass.getText().toString());
                editor.commit();

                Intent intent = new Intent(ChangePassword.this, Option.class);
                startActivity(intent);
            }
        });
    }
}
