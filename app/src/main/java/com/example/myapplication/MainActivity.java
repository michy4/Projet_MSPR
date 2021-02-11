package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;

    private String keyName = "Bob";
    private String keyPassword = "1234567890";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        eName=findViewById(R.id.LoginConnect);
        ePassword=findViewById(R.id.motDePasseConnect);
        eLogin=findViewById(R.id.Connect);

        eLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String name = eName.getText().toString();
                String password = ePassword.getText().toString();

                if (name.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Veuillez saisir tous les champs ci-dessus", Toast.LENGTH_LONG).show();
                }
                else
                {
                    boolean isValid = validate(name, password);
                    if (!isValid)
                    {
                        Toast.makeText(MainActivity.this,"Identifiant incorrect", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }

                //MainActivity main_activity = new MainActivity();
            }
        });
    }

    private boolean validate (String name, String password)
    {
        return (name.equals(keyName) && password.equals(keyPassword));
    }
}
