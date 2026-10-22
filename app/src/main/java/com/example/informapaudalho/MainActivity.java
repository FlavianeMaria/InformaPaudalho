package com.example.informapaudalho;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Botão de Perfil (Topo) -> Leva para a PerfilActivity
        ImageButton buttonPerfil = findViewById(R.id.buttonPerfil);
        if (buttonPerfil != null) {
            buttonPerfil.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                startActivity(intent);
            });
        }

        // 2. Botão de Checklist (AO LADO DO PERFIL NO TOPO) -> Leva para StatusServicosActivity
        ImageButton buttonChecklist = findViewById(R.id.buttonChecklist);
        if (buttonChecklist != null) {
            buttonChecklist.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, StatusServicosActivity.class);
                startActivity(intent);
            });
        }

        // 3. Cada Serviço levando para sua própria tela específica
        ImageButton botaoAgua = findViewById(R.id.buttonAgua);
        botaoAgua.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AguaActivity.class);
            startActivity(intent);
        });

        ImageButton botaoCarroSopa = findViewById(R.id.buttonCarroSopa);
        botaoCarroSopa.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CarroSopaActivity.class);
            startActivity(intent);
        });

        ImageButton botaoReciclagem = findViewById(R.id.buttonReciclagem);
        botaoReciclagem.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReciclagemActivity.class);
            startActivity(intent);
        });

        ImageButton botaoChat = findViewById(R.id.buttonChat);
        botaoChat.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ChatActivity.class);
            startActivity(intent);
        });

        ImageButton botaoColetaLixo = findViewById(R.id.buttonColetaLixo);
        botaoColetaLixo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ColetaLixoActivity.class);
            startActivity(intent);
        });

        ImageButton botaoCastraMovel = findViewById(R.id.buttonCastraMovel);
        botaoCastraMovel.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CastraMovelActivity.class);
            startActivity(intent);
        });
    }
}