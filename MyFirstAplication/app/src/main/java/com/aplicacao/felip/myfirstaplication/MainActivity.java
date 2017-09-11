package com.aplicacao.felip.myfirstaplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView ImgBotao;
    private Button botaoAdiciona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImgBotao = (ImageView) findViewById(R.id.avenger_img);

        ImgBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AvaliacaoFilme.class));

            }
        });

        botaoAdiciona = (Button) findViewById(R.id.botao_adiciona);
        botaoAdiciona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Botao de adicionar clicado", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
