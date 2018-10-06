package br.com.valcirjr98.makor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import br.com.valcirjr98.makor.model.Produto;

import java.util.ArrayList;
import java.util.List;


public class MeusProdutos extends AppCompatActivity {

    private RecyclerView recyclerViewProdutos;
    private List <Produto> produtos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_produtos);

        recyclerViewProdutos = findViewById(R.id.reclyclerProdutos);

        recyclerViewProdutos.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProdutos.setHasFixedSize(true);

    }
}
