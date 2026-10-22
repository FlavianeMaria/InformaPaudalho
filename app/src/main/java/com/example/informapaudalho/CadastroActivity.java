package com.example.informapaudalho;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Ligando os campos com os IDs do XML
        EditText edtNomeCadastro = findViewById(R.id.edtNomeCadastro);
        EditText edtEmailCadastro = findViewById(R.id.edtEmailCadastro);
        EditText edtSenhaCadastro = findViewById(R.id.edtSenhaCadastro);
        EditText edtConfirmarSenhaCadastro = findViewById(R.id.edtConfirmarSenhaCadastro);
        Button btnCadastrar = findViewById(R.id.btnCadastrar);
        Button btnVoltarLogin = findViewById(R.id.btnVoltarLogin);

        // Ação do Botão Cadastrar
        btnCadastrar.setOnClickListener(v -> {
            String nome = edtNomeCadastro.getText().toString().trim();
            String email = edtEmailCadastro.getText().toString().trim();
            String senha = edtSenhaCadastro.getText().toString().trim();
            String confirmarSenha = edtConfirmarSenhaCadastro.getText().toString().trim();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                Toast.makeText(CadastroActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else if (!senha.equals(confirmarSenha)) {
                Toast.makeText(CadastroActivity.this, "As senhas não coincidem!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(CadastroActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

                // Leva o usuário para a Tela Inicial
                Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                startActivity(intent);

                // Fecha a tela de cadastro para não voltar ao apertar o botão 'voltar' do celular
                finish();
            }
        });

        //Ação do Botão Voltar para o Login
        btnVoltarLogin.setOnClickListener(v -> finish());
    }
}