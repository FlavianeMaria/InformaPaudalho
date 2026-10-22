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

public class ColetaLixoActivity extends AppCompatActivity {

    private CardView cardDetalhesLixo;
    private TextView tvBairroNomeLixo, tvStatusLixo, tvDataLixo, tvHorarioLixo, tvTipoLixo;

    // Estrutura para armazenar as informações da coleta de lixo
    static class InfoLixo {
        String status;
        String dias;
        String horario;
        String tipo;

        InfoLixo(String status, String dias, String horario, String tipo) {
            this.status = status;
            this.dias = dias;
            this.horario = horario;
            this.tipo = tipo;
        }
    }

    private final Map<String, InfoLixo> dadosLixo = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coletalixo);

        // 1. Mapear componentes do XML (Spinner declarado como variável local para evitar avisos)
        Spinner spinnerBairrosLixo = findViewById(R.id.spinnerBairrosLixo);
        cardDetalhesLixo = findViewById(R.id.cardDetalhesLixo);
        tvBairroNomeLixo = findViewById(R.id.tvBairroNomeLixo);
        tvStatusLixo = findViewById(R.id.tvStatusLixo);
        tvDataLixo = findViewById(R.id.tvDataLixo);
        tvHorarioLixo = findViewById(R.id.tvHorarioLixo);
        tvTipoLixo = findViewById(R.id.tvTipoLixo);

        // 2. Carregar os dados dos bairros de Paudalho
        carregarDados();

        // 3. Montar a lista para o Spinner
        List<String> listaBairros = new ArrayList<>();
        listaBairros.add("Selecione um bairro...");
        listaBairros.addAll(dadosLixo.keySet());

        // 4. Configurar o Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listaBairros
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBairrosLixo.setAdapter(adapter);

        // 5. Clique do Spinner
        spinnerBairrosLixo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    cardDetalhesLixo.setVisibility(View.GONE);
                } else {
                    String bairroSelecionado = parent.getItemAtPosition(position).toString();
                    exibirDetalhes(bairroSelecionado);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                cardDetalhesLixo.setVisibility(View.GONE);
            }
        });
    }

    private void carregarDados() {
        // Cronograma do Carro do Lixo em Paudalho
        dadosLixo.put("Centro", new InfoLixo("🟢 Hoje tem coleta!", "Segunda, Quarta e Sexta", "A partir das 07:00", "Lixo Doméstico"));
        dadosLixo.put("Alto dois irmãos", new InfoLixo("🟡 Coleta amanhã", "Terça, Quinta e Sábado", "A partir das 08:00", "Lixo Doméstico"));
        dadosLixo.put("Guadalajara", new InfoLixo("🟢 Hoje tem coleta!", "Segunda, Quarta e Sexta", "A partir das 18:00 (Noturno)", "Lixo Doméstico"));
        dadosLixo.put("Chã de Pinheiro", new InfoLixo("🔴 Sem coleta hoje", "Terça e Sexta-feira", "A partir das 13:00", "Lixo Doméstico"));
    }

    private void exibirDetalhes(String bairro) {
        InfoLixo info = dadosLixo.get(bairro);
        if (info != null) {
            tvBairroNomeLixo.setText(bairro);
            tvStatusLixo.setText("Status: " + info.status);
            tvDataLixo.setText("Dias: " + info.dias);
            tvHorarioLixo.setText("Horário: " + info.horario);
            tvTipoLixo.setText("Tipo: " + info.tipo);
            cardDetalhesLixo.setVisibility(View.VISIBLE);
        }
    }
}