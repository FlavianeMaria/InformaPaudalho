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

public class CastraMovelActivity extends AppCompatActivity {

    private CardView cardDetalhesCastramovel;
    private TextView tvBairroNomeCastramovel, tvStatusCastramovel, tvLocalCastramovel, tvDataCastramovel, tvHorarioCastramovel;

    static class InfoCastramovel {
        String status;
        String local;
        String periodo;
        String horario;

        InfoCastramovel(String status, String local, String periodo, String horario) {
            this.status = status;
            this.local = local;
            this.periodo = periodo;
            this.horario = horario;
        }
    }

    private final Map<String, InfoCastramovel> dadosCastramovel = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castramovel);

        Spinner spinnerBairrosCastramovel = findViewById(R.id.spinnerBairrosCastramovel);
        cardDetalhesCastramovel = findViewById(R.id.cardDetalhesCastramovel);
        tvBairroNomeCastramovel = findViewById(R.id.tvBairroNomeCastramovel);
        tvStatusCastramovel = findViewById(R.id.tvStatusCastramovel);
        tvLocalCastramovel = findViewById(R.id.tvLocalCastramovel);
        tvDataCastramovel = findViewById(R.id.tvDataCastramovel);
        tvHorarioCastramovel = findViewById(R.id.tvHorarioCastramovel);

        carregarDados();

        List<String> listaBairros = new ArrayList<>();
        listaBairros.add("Selecione um bairro...");
        listaBairros.addAll(dadosCastramovel.keySet());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                listaBairros
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBairrosCastramovel.setAdapter(adapter);

        spinnerBairrosCastramovel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    cardDetalhesCastramovel.setVisibility(View.GONE);
                } else {
                    String bairroSelecionado = parent.getItemAtPosition(position).toString();
                    exibirDetalhes(bairroSelecionado);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                cardDetalhesCastramovel.setVisibility(View.GONE);
            }
        });
    }

    private void carregarDados() {
        dadosCastramovel.put("Centro", new InfoCastramovel("🟢 AtendimentoAtivo", "Praça Pedro II", "Esta semana", "08:00 às 14:00"));
        dadosCastramovel.put("Alto dois irmãos", new InfoCastramovel("🟡 Em breve", "Próximo à Unidade de Saúde", "Próxima semana", "08:00 às 13:00"));
        dadosCastramovel.put("Guadalajara", new InfoCastramovel("🔴 Finalizado", "Quadra Coberta", "Encerrado neste bairro", "---"));
        dadosCastramovel.put("Chã de Pinheiro", new InfoCastramovel("🟡 Agendado", "Pátio da Associação", "Do dia 15 ao dia 20", "08:00 às 13:00"));
    }

    private void exibirDetalhes(String bairro) {
        InfoCastramovel info = dadosCastramovel.get(bairro);
        if (info != null) {
            tvBairroNomeCastramovel.setText(bairro);
            tvStatusCastramovel.setText("Status: " + info.status);
            tvLocalCastramovel.setText("Local: " + info.local);
            tvDataCastramovel.setText("Período: " + info.periodo);
            tvHorarioCastramovel.setText("Horário: " + info.horario);
            cardDetalhesCastramovel.setVisibility(View.VISIBLE);
        }
    }
}