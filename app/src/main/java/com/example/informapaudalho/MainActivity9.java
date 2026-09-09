package com.example.informapaudalho;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity9 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        Button btnMenu = findViewById(R.id.btnMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu menu = new PopupMenu(MainActivity9.this, btnMenu);

                menu.getMenu().add("Início");
                menu.getMenu().add("Perfil");
                menu.getMenu().add("Materiais");
                menu.getMenu().add("Configurações");
                menu.getMenu().add("Sair");

                menu.show();
            }
        });
    }
}