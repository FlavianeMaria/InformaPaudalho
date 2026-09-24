package com.example.informapaudalho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton botaoAgua = findViewById(R.id.buttonAgua);
        botaoAgua.setOnClickListener(V -> {
            Intent intent = new Intent(this, AguaActivity.class);
            startActivity(intent);
        });
        ImageButton botaoCarroSopa = findViewById(R.id.buttonCarroSopa);
        botaoCarroSopa.setOnClickListener(v -> {
            Intent intent = new Intent(this, CarroSopaActivity.class);
        });
        ImageButton botaoReciclagem = findViewById(R.id.buttonReciclagem);
        botaoReciclagem.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReciclagemActivity.class);
        });
        ImageButton botaoChat = findViewById(R.id.buttonChat);
        botaoChat.setOnClickListener(v -> {
            Intent intent = new Intent(this, ChatActivity.class);
        });
        ImageButton botaoColetaLixo = findViewById(R.id.buttonColetaLixo);
        botaoColetaLixo.setOnClickListener(v -> {
            Intent intent = new Intent(this, ColetaLixoActivity.class);
        });
        ImageButton botaoCastraMovel = findViewById(R.id.buttonCastraMovel);
        botaoCastraMovel.setOnClickListener(v -> {
            Intent intent = new Intent(this, CastraMovelActivity.class);
        });
    }
}