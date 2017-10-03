package com.example.dominika.password_bezpieczenstwo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Dominika on 03.10.2017.
 */

public class Message extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.message);

        TextView textView = (TextView) findViewById(R.id.message_TV);

        String newString;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("message");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("message");
        }

        textView.setText(newString);
    }
}
