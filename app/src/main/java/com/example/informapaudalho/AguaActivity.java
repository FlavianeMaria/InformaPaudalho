package com.example.informapaudalho;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AguaActivity extends AppCompatActivity {

    private CardView cardDetalhes;
    private TextView tvBairroNome, tvStatus, tvData, tvHorario;

    // Estrutura para armazenar os dados de abastecimento
    static class InfoAgua {
        String status;
        String data;
        String horario;

        InfoAgua(String status, String data, String horario) {
            this.status = status;
            this.data = data;
            this.horario = horario;
        }
    }

    private final Map<String, InfoAgua> dadosAgua = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agua);

        // 1. Mapear os componentes do XML
        Spinner spinnerBairros = findViewById(R.id.spinnerBairros);
        cardDetalhes = findViewById(R.id.cardDetalhes);
        tvBairroNome = findViewById(R.id.tvBairroNome);
        tvStatus = findViewById(R.id.tvStatus);
        tvData = findViewById(R.id.tvData);
        tvHorario = findViewById(R.id.tvHorario);

        // 2. Carregar dados de Paudalho
        carregarDados();

        // 3. Montar a lista para o Spinner
        List<String> listaBairros = new ArrayList<>();
        listaBairros.add("Selecione um bairro...");
        listaBairros.addAll(dadosAgua.keySet());

        // 4. Configurar o Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listaBairros
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBairros.setAdapter(adapter);

        // 5. Clique do Spinner
        spinnerBairros.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    cardDetalhes.setVisibility(View.GONE);
                } else {
                    String bairroSelecionado = parent.getItemAtPosition(position).toString();
                    exibirDetalhes(bairroSelecionado);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                cardDetalhes.setVisibility(View.GONE);
            }
        });
    }

    private void carregarDados() {
        // Bairros de Paudalho
        dadosAgua.put("Centro", new InfoAgua("🟢 Hoje tem água!", "Hoje", "06:00 às 18:00"));
        dadosAgua.put("Alto Dois Irmãos", new InfoAgua("🟡 Chega amanhã", "Amanhã", "08:00 às 20:00"));
        dadosAgua.put("Guadalajara", new InfoAgua("🔴 Sem previsão hoje", "Próxima: Segunda", "00:00 às 12:00"));
        dadosAgua.put("Chã de Pinheiro", new InfoAgua("🟢 Hoje tem água!", "Hoje", "07:00 às 17:00"));
    }

    private void exibirDetalhes(String bairro) {
        InfoAgua info = dadosAgua.get(bairro);
        if (info != null) {
            tvBairroNome.setText(bairro);
            tvStatus.setText("Status: " + info.status);
            tvData.setText("Previsão: " + info.data);
            tvHorario.setText("Horário: " + info.horario);
            cardDetalhes.setVisibility(View.VISIBLE);
        }
    }
}