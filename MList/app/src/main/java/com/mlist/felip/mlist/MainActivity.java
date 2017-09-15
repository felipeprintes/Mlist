package com.mlist.felip.mlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.mlist.felip.mlist.modelo.Filme;
import com.mlist.felip.mlist.modeloDb.FilmeModeloBD;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView minhaLista;
    private Button meuBotao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregaLista();

        meuBotao = (Button) findViewById(R.id.meu_botao_formulario);
        meuBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CadastroFilme.class));
            }
        });


        registerForContextMenu(minhaLista);

    }

    private void carregaLista() {
        FilmeModeloBD modelo = new FilmeModeloBD(this);
        List<Filme> filmes = modelo.buscaFilmes();
        modelo.close();

        minhaLista = (ListView) findViewById(R.id.minha_lista);
        ArrayAdapter<Filme> adapter = new ArrayAdapter<Filme>(this,android.R.layout.simple_list_item_1, filmes);
        minhaLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem deletar = menu.add("Deletar Filme");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Filme filme = (Filme) minhaLista.getItemAtPosition(info.position);

                FilmeModeloBD modelo =  new FilmeModeloBD(MainActivity.this);
                modelo.deleta(filme);
                modelo.close();

                carregaLista();
                return false;
            }
        });

    }
}
