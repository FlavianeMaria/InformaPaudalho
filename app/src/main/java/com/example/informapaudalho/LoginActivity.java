package com.example.informapaudalho;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmailLogin;
    private EditText edtSenhaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnEntrar;
        Button btnIrParaCadastro;

        // Ligando as variáveis do Java com os novos IDs do XML
        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        edtSenhaLogin = findViewById(R.id.edtSenhaLogin);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnIrParaCadastro = findViewById(R.id.btnIrParaCadastro);

        // Ação do Botão "Criar uma conta" (Abre a tela de cadastro)
        btnIrParaCadastro.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
            startActivity(intent);
        });

        // Ação do Botão "Login"
        btnEntrar.setOnClickListener(v -> {
            String emailTexto = edtEmailLogin.getText().toString().trim();
            String senhaTexto = edtSenhaLogin.getText().toString().trim();

            if (emailTexto.isEmpty() || senhaTexto.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Preencha o e-mail e a senha.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(LoginActivity.this, "Login realizado!", Toast.LENGTH_SHORT).show();

                // Navega para a tela principal (MainActivity)
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}