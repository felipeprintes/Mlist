package com.mlist.felip.mlist;

import android.app.ActionBar;
import android.widget.EditText;
import android.widget.RatingBar;

import com.mlist.felip.mlist.modelo.Filme;

/**
 * Created by felip on 12/09/2017.
 */

public class AjudanteFormulario {


    private final EditText campoNome;
    private final EditText campoGenero;
    private final RatingBar campoNota;

    public AjudanteFormulario(CadastroFilme activity){

        campoNome = (EditText) activity.findViewById(R.id.formulario_nome_filme);
        campoGenero = (EditText) activity.findViewById(R.id.formulario_genereno_filme);
        campoNota = (RatingBar) activity.findViewById(R.id.avaliacao_nota);
    }

    public Filme pegaFilme() {

        Filme filme = new Filme();
        filme.setNome(campoNome.getText().toString());
        filme.setGenero(campoGenero.getText().toString());
        filme.setNota(Double.valueOf(campoNota.getProgress()));

        return filme;
    }
}
