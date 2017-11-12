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

public class WriteMessage extends AppCompatActivity {

    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_message_layout);

        context = getApplicationContext();
        final EditText new_message = (EditText) findViewById(R.id.new_message_ET);
        Button set = (Button) findViewById(R.id.new_message_B);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = context.getSharedPreferences("preferences_name", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("message", new_message.getText().toString());
                editor.commit();
                Intent intent = new Intent(WriteMessage.this, Option.class);
                startActivity(intent);
            }
        });
    }
}
