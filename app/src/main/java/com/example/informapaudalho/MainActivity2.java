package com.example.informapaudalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EditText email = findViewById(R.id.caixadeemaillog);
        EditText senha = findViewById(R.id.editTextTextPassword2);
        Button botaoLogin = findViewById(R.id.button);

        botaoLogin.setOnClickListener(v ->
                {
                    String emailTexto = email.getText().toString().trim();
                    String senhaTexto = senha.getText().toString().trim();

                    if (emailTexto.isEmpty() || senhaTexto.isEmpty()) {
                        Toast.makeText(this, "Preencha o e-mail e a senha.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Login realizado!", Toast.LENGTH_SHORT).show();
                    }
                }
                );
    }
}