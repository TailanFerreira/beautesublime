package com.example.trabalhofinaltailan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button btnentrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    Button btnentrar = findViewById(R.id.btn_entrar);
    btnentrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setContentView(R.layout.activity_main);
        }
    });

    }
}