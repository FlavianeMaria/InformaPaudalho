package com.example.informapaudalho;
import com.example.informapaudalho.R;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private EditText etMensagemChat;
    private ChatAdapter chatAdapter;
    private final List<MensagemModel> listaMensagens = new ArrayList<>();

    // Modelo de Mensagem
    static class MensagemModel {
        String texto;
        String hora;
        boolean ehEnviada;

        MensagemModel(String texto, String hora, boolean ehEnviada) {
            this.texto = texto;
            this.hora = hora;
            this.ehEnviada = ehEnviada;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ImageButton btnVoltarChat = findViewById(R.id.btnVoltarChat);
        ImageButton btnEnviarChat = findViewById(R.id.btnEnviarChat);
        etMensagemChat = findViewById(R.id.etMensagemChat);
        RecyclerView recyclerChat = findViewById(R.id.recyclerChat);

        // Configurar RecyclerView
        chatAdapter = new ChatAdapter(listaMensagens);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        recyclerChat.setLayoutManager(layoutManager);
        recyclerChat.setAdapter(chatAdapter);

        // Voltar para a tela anterior
        btnVoltarChat.setOnClickListener(v -> finish());

        // Mensagens de simulação iniciais
        carregarMensagensIniciais();

        // Enviar nova mensagem
        btnEnviarChat.setOnClickListener(v -> {
            String texto = etMensagemChat.getText().toString().trim();
            if (!TextUtils.isEmpty(texto)) {
                listaMensagens.add(new MensagemModel(texto, "13:01", true));
                chatAdapter.notifyItemInserted(listaMensagens.size() - 1);
                recyclerChat.scrollToPosition(listaMensagens.size() - 1);
                etMensagemChat.setText("");
            }
        });
    }

    private void carregarMensagensIniciais() {
        listaMensagens.add(new MensagemModel("Olá! Tudo bem? Como posso ajudar?", "12:58", false));
        listaMensagens.add(new MensagemModel("Olá! Preciso de informações sobre os serviços.", "12:59", true));
        chatAdapter.notifyDataSetChanged();
    }

    // Adapter do RecyclerView
    private static class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final List<MensagemModel> mensagens;

        ChatAdapter(List<MensagemModel> mensagens) {
            this.mensagens = mensagens;
        }

        @Override
        public int getItemViewType(int position) {
            return mensagens.get(position).ehEnviada ? 1 : 0;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (viewType == 1) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_msg_enviada, parent, false);
                return new EnviadaViewHolder(view);
            } else {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_msg_recebida, parent, false);
                return new RecebidaViewHolder(view);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MensagemModel msg = mensagens.get(position);
            if (holder instanceof EnviadaViewHolder) {
                ((EnviadaViewHolder) holder).tvTexto.setText(msg.texto);
                ((EnviadaViewHolder) holder).tvHora.setText(msg.hora);
            } else if (holder instanceof RecebidaViewHolder) {
                ((RecebidaViewHolder) holder).tvTexto.setText(msg.texto);
                ((RecebidaViewHolder) holder).tvHora.setText(msg.hora);
            }
        }

        @Override
        public int getItemCount() {
            return mensagens.size();
        }

        static class EnviadaViewHolder extends RecyclerView.ViewHolder {
            TextView tvTexto, tvHora;
            EnviadaViewHolder(View itemView) {
                super(itemView);
                tvTexto = itemView.findViewById(R.id.tvTextoMsgEnviada);
                tvHora = itemView.findViewById(R.id.tvHoraMsgEnviada);
            }
        }

        static class RecebidaViewHolder extends RecyclerView.ViewHolder {
            TextView tvTexto, tvHora;
            RecebidaViewHolder(View itemView) {
                super(itemView);
                tvTexto = itemView.findViewById(R.id.tvTextoMsgRecebida);
                tvHora = itemView.findViewById(R.id.tvHoraMsgRecebida);
            }
        }
    }
}