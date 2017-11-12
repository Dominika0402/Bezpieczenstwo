package com.example.dominika.password_bezpieczenstwo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

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
        final EditText old_pass = (EditText) findViewById(R.id.old_password);
        final Button change = (Button) findViewById(R.id.change_pass_B);

        final SharedPreferences preferences = getApplicationContext().getSharedPreferences("preferences_name",
                getApplicationContext().MODE_PRIVATE);
        final String value = preferences.getString("password", "");

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(value.equals(sha256(old_pass.getText().toString()))) {
                    SharedPreferences preferences = context.getSharedPreferences("preferences_name", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("password", sha256(change_pass.getText().toString()));
                    editor.commit();

                    Toast.makeText(ChangePassword.this, "ZMIENIONO HASLO", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ChangePassword.this, Option.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(ChangePassword.this, "BŁĄD, WPISZ PONOWNIE HASŁO.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
