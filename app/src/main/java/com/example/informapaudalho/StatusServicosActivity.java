package com.example.informapaudalho;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class StatusServicosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_servicos);

        // Mapeamento local dos componentes para evitar avisos (warnings) no Android Studio
        ImageButton btnVoltarChecklist = findViewById(R.id.btnVoltarChecklist);
        CheckBox cbCarroLixo = findViewById(R.id.cbCarroLixo);
        CheckBox cbCarroSopa = findViewById(R.id.cbCarroSopa);
        CheckBox cbCastramovel = findViewById(R.id.cbCastramovel);
        CheckBox cbAgua = findViewById(R.id.cbAgua);
        CheckBox cbReciclagem = findViewById(R.id.cbReciclagem);
        CheckBox cbIluminacao = findViewById(R.id.cbIluminacao);

        // Ação do botão voltar
        btnVoltarChecklist.setOnClickListener(v -> finish());

        // Eventos de clique nos checkboxes para dar feedback ao usuário
        cbCarroLixo.setOnCheckedChangeListener((buttonView, isChecked) ->
                exibirStatus("Carro do lixo", isChecked));

        cbCarroSopa.setOnCheckedChangeListener((buttonView, isChecked) ->
                exibirStatus("Carro da sopa", isChecked));

        cbCastramovel.setOnCheckedChangeListener((buttonView, isChecked) ->
                exibirStatus("Castramóvel", isChecked));

        cbAgua.setOnCheckedChangeListener((buttonView, isChecked) ->
                exibirStatus("Chegada de água", isChecked));

        cbReciclagem.setOnCheckedChangeListener((buttonView, isChecked) ->
                exibirStatus("Coleta seletiva", isChecked));

        cbIluminacao.setOnCheckedChangeListener((buttonView, isChecked) ->
                exibirStatus("Iluminação pública", isChecked));
    }

    private void exibirStatus(String item, boolean marcado) {
        String mensagem = marcado ? item + " marcado como concluído!" : item + " desmarcado.";
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}