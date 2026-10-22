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

public class CarroSopaActivity extends AppCompatActivity {

    private CardView cardDetalhesSopa;
    private TextView tvBairroNomeSopa, tvStatusSopa, tvDataSopa, tvHorarioSopa;

    // Estrutura para armazenar as informações da sopa
    static class InfoSopa {
        String status;
        String dia;
        String horario;

        InfoSopa(String status, String dia, String horario) {
            this.status = status;
            this.dia = dia;
            this.horario = horario;
        }
    }

    private final Map<String, InfoSopa> dadosSopa = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrosopa);

        // 1. Mapear componentes do XML
        Spinner spinnerBairrosSopa = findViewById(R.id.spinnerBairrosSopa);
        cardDetalhesSopa = findViewById(R.id.cardDetalhesSopa);
        tvBairroNomeSopa = findViewById(R.id.tvBairroNomeSopa);
        tvStatusSopa = findViewById(R.id.tvStatusSopa);
        tvDataSopa = findViewById(R.id.tvDataSopa);
        tvHorarioSopa = findViewById(R.id.tvHorarioSopa);

        // 2. Carregar dados dos bairros
        carregarDados();

        // 3. Montar lista para o Spinner
        List<String> listaBairros = new ArrayList<>();
        listaBairros.add("Selecione um bairro...");
        listaBairros.addAll(dadosSopa.keySet());

        // 4. Configurar o Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listaBairros
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBairrosSopa.setAdapter(adapter);

        // 5. Escutar eventos do Spinner
        spinnerBairrosSopa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    cardDetalhesSopa.setVisibility(View.GONE);
                } else {
                    String bairroSelecionado = parent.getItemAtPosition(position).toString();
                    exibirDetalhes(bairroSelecionado);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                cardDetalhesSopa.setVisibility(View.GONE);
            }
        });
    }

    private void carregarDados() {
        // Bairros de Paudalho com a grafia exata
        dadosSopa.put("Centro", new InfoSopa("🟢 Hoje tem sopa!", "Toda Segunda e Quarta", "16:00 às 17:30"));
        dadosSopa.put("Alto dois irmãos", new InfoSopa("🟡 Próxima entrega amanhã", "Toda Terça e Quinta", "16:30 às 18:00"));
        dadosSopa.put("Guadalajara", new InfoSopa("🟢 Hoje tem sopa!", "Toda Quarta e Sexta", "16:00 às 17:30"));
        dadosSopa.put("Chã de Pinheiro", new InfoSopa("🔴 Sem sopa hoje", "Toda Sexta-feira", "17:00 às 18:30"));
    }

    private void exibirDetalhes(String bairro) {
        InfoSopa info = dadosSopa.get(bairro);
        if (info != null) {
            tvBairroNomeSopa.setText(bairro);
            tvStatusSopa.setText("Status: " + info.status);
            tvDataSopa.setText("Dias: " + info.dia);
            tvHorarioSopa.setText("Horário: " + info.horario);
            cardDetalhesSopa.setVisibility(View.VISIBLE);
        }
    }
}