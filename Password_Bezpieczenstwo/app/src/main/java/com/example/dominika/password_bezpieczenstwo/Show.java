package com.example.dominika.password_bezpieczenstwo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Dominika on 03.10.2017.
 */

public class Show extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.show);

        TextView textView = (TextView) findViewById(R.id.message_TV2);

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
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("preferences_name",
                getApplicationContext().MODE_PRIVATE);
        String value = preferences.getString("message",
                "default_value");
        textView.setText(value);
    }
}
