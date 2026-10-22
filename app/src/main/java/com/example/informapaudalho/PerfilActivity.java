package com.example.informapaudalho;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // Mapeamento local para evitar avisos em amarelo (warnings)
        ImageButton btnVoltarPerfil = findViewById(R.id.btnVoltarPerfil);
        Button btnMensagemPerfil = findViewById(R.id.btnMensagemPerfil);
        Button btnEditarPerfil = findViewById(R.id.btnEditarPerfil);

        // Voltar para a tela anterior
        btnVoltarPerfil.setOnClickListener(v -> finish());

        // Ação do botão Mensagem: abre o Chat
        btnMensagemPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(PerfilActivity.this, ChatActivity.class);
            startActivity(intent);
        });

        // Ação do botão Editar (pode ser expandida no futuro)
        btnEditarPerfil.setOnClickListener(v -> {
            // Lógica para editar perfil
        });
    }
}