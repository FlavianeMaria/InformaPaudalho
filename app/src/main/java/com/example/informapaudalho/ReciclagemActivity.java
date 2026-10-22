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

public class ReciclagemActivity extends AppCompatActivity {

    private CardView cardDetalhesReciclagem;
    private TextView tvBairroNomeReciclagem, tvStatusReciclagem, tvDiasReciclagem, tvMateriaisReciclagem, tvHorarioReciclagem;

    static class InfoReciclagem {
        String status;
        String dias;
        String materiais;
        String horario;

        InfoReciclagem(String status, String dias, String materiais, String horario) {
            this.status = status;
            this.dias = dias;
            this.materiais = materiais;
            this.horario = horario;
        }
    }

    private final Map<String, InfoReciclagem> dadosReciclagem = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclagem);

        Spinner spinnerBairrosReciclagem = findViewById(R.id.spinnerBairrosReciclagem);
        cardDetalhesReciclagem = findViewById(R.id.cardDetalhesReciclagem);
        tvBairroNomeReciclagem = findViewById(R.id.tvBairroNomeReciclagem);
        tvStatusReciclagem = findViewById(R.id.tvStatusReciclagem);
        tvDiasReciclagem = findViewById(R.id.tvDiasReciclagem);
        tvMateriaisReciclagem = findViewById(R.id.tvMateriaisReciclagem);
        tvHorarioReciclagem = findViewById(R.id.tvHorarioReciclagem);

        carregarDados();

        List<String> listaBairros = new ArrayList<>();
        listaBairros.add("Selecione um bairro...");
        listaBairros.addAll(dadosReciclagem.keySet());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listaBairros
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBairrosReciclagem.setAdapter(adapter);

        spinnerBairrosReciclagem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    cardDetalhesReciclagem.setVisibility(View.GONE);
                } else {
                    String bairroSelecionado = parent.getItemAtPosition(position).toString();
                    exibirDetalhes(bairroSelecionado);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                cardDetalhesReciclagem.setVisibility(View.GONE);
            }
        });
    }

    private void carregarDados() {
        dadosReciclagem.put("Centro", new InfoReciclagem("🟢 Rota ativa", "Toda Quarta-feira", "Plástico, Papel, Metal, Vidro", "A partir das 08:00"));
        dadosReciclagem.put("Alto dois irmãos", new InfoReciclagem("🟢 Rota ativa", "Toda Quinta-feira", "Plástico, Papelão, Alumínio", "A partir das 09:00"));
        dadosReciclagem.put("Guadalajara", new InfoReciclagem("🟢 Rota ativa", "Toda Terça-feira", "Plástico, Papel, Metal", "A partir das 08:00"));
        dadosReciclagem.put("Chã de Pinheiro", new InfoReciclagem("🟡 Ponto Fixo (PEV)", "Segunda a Sexta", "Plásticos e Metais", "08:00 às 16:00"));
    }

    private void exibirDetalhes(String bairro) {
        InfoReciclagem info = dadosReciclagem.get(bairro);
        if (info != null) {
            tvBairroNomeReciclagem.setText(bairro);
            tvStatusReciclagem.setText("Status: " + info.status);
            tvDiasReciclagem.setText("Coleta: " + info.dias);
            tvMateriaisReciclagem.setText("Aceita: " + info.materiais);
            tvHorarioReciclagem.setText("Horário: " + info.horario);
            cardDetalhesReciclagem.setVisibility(View.VISIBLE);
        }
    }
}