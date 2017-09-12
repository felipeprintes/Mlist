package com.mlist.felip.mlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] myVetorAlunos;
    private ListView minhaLista;
    private Button meuBotao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVetorAlunos = new String[]{"felipe", "fabio", "gustavo", "felipe", "fabio", "gustavo",
                "felipe", "fabio", "gustavo", "felipe", "fabio", "gustavo", "felipe", "fabio", "gustavo", "felipe", "fabio"};
        minhaLista = (ListView) findViewById(R.id.minha_lista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, myVetorAlunos);
        minhaLista.setAdapter(adapter);

        meuBotao = (Button) findViewById(R.id.meu_botao_formulario);
        meuBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CadastroFilme.class));
            }
        });


    }
}
