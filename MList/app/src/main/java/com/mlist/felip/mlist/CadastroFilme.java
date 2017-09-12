package com.mlist.felip.mlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.mlist.felip.mlist.modelo.Filme;
import com.mlist.felip.mlist.modeloDb.FilmeModeloBD;

public class CadastroFilme extends AppCompatActivity {


    private AjudanteFormulario ajudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_filme);

        ajudante = new AjudanteFormulario(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                Filme filme = ajudante.pegaFilme();
                FilmeModeloBD modelo = new FilmeModeloBD(this);
                modelo.insere(filme);
                Toast.makeText(CadastroFilme.this, "O filme " + filme.getNome() + " foi salvo", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
