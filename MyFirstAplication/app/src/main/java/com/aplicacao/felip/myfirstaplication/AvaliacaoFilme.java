package com.aplicacao.felip.myfirstaplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AvaliacaoFilme extends AppCompatActivity {

    private Button botaoAvalia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_filme);

        Button botaoAvalia = (Button) findViewById(R.id.botao_avaliar);
        botaoAvalia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AvaliacaoFilme.this, "Avaliação realizada com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
