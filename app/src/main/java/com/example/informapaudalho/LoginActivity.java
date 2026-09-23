package com.example.informapaudalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText email = findViewById(R.id.caixadeemaillog);
        EditText senha = findViewById(R.id.editTextTextPassword2);
        Button botaoLogin = findViewById(R.id.button);
        Button botaoCadastro = findViewById(R.id.button3);
        botaoCadastro.setOnClickListener(v ->{
            Intent intent = new Intent(this, CadastroActivity.class);
            startActivity(intent);
        });

        botaoLogin.setOnClickListener(v ->
                {
                    String emailTexto = email.getText().toString().trim();
                    String senhaTexto = senha.getText().toString().trim();

                    if (emailTexto.isEmpty() || senhaTexto.isEmpty()) {
                        Toast.makeText(this, "Preencha o e-mail e a senha.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Login realizado!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(this, MainActivity.class);
                        startActivity(intent);
                    }
                }
                );
    }
}